package com.smhrd.hotelreservation.service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
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
		this.saveReservation(requestDto);
		
		// 결제모듈 (나이스페이먼츠)
		
		
		return code;
		
	}
	
	/**
	 * method	예약 정보 등록
	 */
	@Transactional
	public Long saveReservation(ReservationSaveReqDto requestDto) {
		Users users = Users.builder().build();
		
		// 빈 객실 찾기
		
		List<ReservationDetails> emptyReservationDetails = reservationDetailsJpaRepository
				.findAllByDateBetween(requestDto.getCheckInDate(), requestDto.getCheckOutDate());
		
		List<Rooms> allRooms = roomsJpaRepository.findAll();
		
		List<Rooms> emptyRooms = allRooms.stream()
			    .filter(room -> emptyReservationDetails.stream()
			        .noneMatch(elem -> elem.getRooms().getId().equals(room.getId()))
			    )
			    .filter(room -> room.getRoomTypes().getId().equals(requestDto.getRoomtype_id()))
			    .collect(Collectors.toList());
		
		System.out.println(emptyRooms.toString());
		// 
		
		// 일자별로 카운트 계산하기
		int days = (int) ChronoUnit.DAYS.between(requestDto.getCheckInDate(), requestDto.getCheckOutDate());
		System.out.println(days);

		
		
		
		return 200L;
	}
	
	
	
	
}
