package com.smhrd.hotelreservation.service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smhrd.hotelreservation.model.entity.ReservationDetails;
import com.smhrd.hotelreservation.model.entity.Reservations;
import com.smhrd.hotelreservation.model.entity.Rooms;
import com.smhrd.hotelreservation.model.entity.Users;
import com.smhrd.hotelreservation.model.repository.ReservationDetailsJpaRepository;
import com.smhrd.hotelreservation.model.repository.ReservationsJpaRepository;
import com.smhrd.hotelreservation.model.repository.RoomsJpaRepository;
import com.smhrd.hotelreservation.web.dto.ReservationDetailResDto;
import com.smhrd.hotelreservation.web.dto.ReservationListResDto;
import com.smhrd.hotelreservation.web.dto.ReservationSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReservationsService {
	
	public final RoomsService roomsService;
	public final RoomTypesService rooomTypesService;
	public final ReservationsJpaRepository reservationsJpaRepository;
	public final ReservationDetailsJpaRepository reservationDetailsJpaRepository;
	public final RoomsJpaRepository roomsJpaRepository;
	
	/**
	 * method	예약
	 */
	@Transactional
	public Long reservation(ReservationSaveReqDto requestDto) {
		
		Long code = 200L;
		// 예약정보 저장
		// 결제모듈 연동(나이스 페이먼츠)
		return this.saveReservation(requestDto);
		
	}
	
	/**
	 * method	예약 정보 등록
	 */
	@Transactional
	public Long saveReservation(ReservationSaveReqDto requestDto) {
		Users users = Users.builder().build();
		
		// 빈 객실 찾기	
		List<ReservationDetails> usedReservationDetails = reservationDetailsJpaRepository
				.findAllByDateBetween(requestDto.getCheckInDate(), requestDto.getCheckOutDate());
		
		List<Rooms> allRooms = roomsJpaRepository.findAll();
		
		List<Rooms> emptyRooms = allRooms.stream()
			    .filter(room -> usedReservationDetails.stream()
			        .noneMatch(elem -> elem.getRooms().getId().equals(room.getId()))
			    )
			    .filter(room -> room.getRoomTypes().getId().equals(requestDto.getRoomtype_id()))
			    .collect(Collectors.toList());
		
		// 빈방이 없는경우 -1L반환
		if(emptyRooms.size() <= 0) return -1L; 
		// 랜덤한 룸
		Rooms emtRoom = emptyRooms.get(new Random().nextInt(emptyRooms.size()));
		List<ReservationDetails> reservationList = new ArrayList<ReservationDetails>();
		
		// 일자별로 계산
		int days = (int) ChronoUnit.DAYS.between(requestDto.getCheckInDate(), requestDto.getCheckOutDate()) + 1;
		for(int i=0; i<days; i++) {
			reservationList.add(ReservationDetails.builder().rooms(emtRoom).date(requestDto.getCheckInDate().plusDays(i)).build());
		}
		
		return reservationsJpaRepository.save(Reservations.builder().users(users).reservationDetails(reservationList).build()).getId();
	}
	
	/**
	 * method	전체 예약 정보 조회 
	 */
	@Transactional
	public List<ReservationListResDto> findAll() {
	    Users users = Users.builder().build();
	    List<ReservationListResDto> rl = reservationsJpaRepository.findAll().stream()
	        .map(rv -> ReservationListResDto.builder()
	            .reservation(rv)
	            .user(users)
	            .l(reservationDetailsJpaRepository.findAllByReservationsId(rv.getId()).stream()
	                .collect(Collectors.toList()))
	            .build())
	        .collect(Collectors.toList());
	    return rl;
	}
	
	/**
	 * method	단일 예약 정보 조회 
	 */
	@Transactional
	public ReservationDetailResDto findOne(Long id) {
		Users users = Users.builder().build();
		Reservations r = reservationsJpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 예약 정보가 없습니다."));
		List<ReservationDetails> l = reservationDetailsJpaRepository.findAllByReservationsId(r.getId());
		return new ReservationDetailResDto(users, r, l);
	}
	
}
