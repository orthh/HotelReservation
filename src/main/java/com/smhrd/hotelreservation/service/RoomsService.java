package com.smhrd.hotelreservation.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smhrd.hotelreservation.model.entity.RoomTypes;
import com.smhrd.hotelreservation.model.entity.Rooms;
import com.smhrd.hotelreservation.model.repository.RoomTypesJpaRepository;
import com.smhrd.hotelreservation.model.repository.RoomsJpaRepository;
import com.smhrd.hotelreservation.web.dto.RoomTypesResDto;
import com.smhrd.hotelreservation.web.dto.RoomTypesSaveReqDto;
import com.smhrd.hotelreservation.web.dto.RoomsResDto;
import com.smhrd.hotelreservation.web.dto.RoomsSaveReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoomsService {
	
	private final RoomTypesJpaRepository roomTypesJpaRepository;
	private final RoomsJpaRepository roomsJpaRepository;
	
	// 객실 추가하기
	@Transactional
	public Long addRoom(RoomsSaveReqDto requestDto) {
		RoomTypes roomTypes = roomTypesJpaRepository.findById(requestDto.getRoomType()).orElseThrow(() -> new IllegalArgumentException("해당 객실타입이 없습니다."));;
		return roomsJpaRepository.save(Rooms.builder()
				.roomNumber(requestDto.getRoomNumber())
				.roomTypes(roomTypes).build()).getId();
	}
	
	// 모든 객실 정보 보내기
	@Transactional(readOnly = true)
	public List<RoomsResDto> findAllRooms(){
		return roomsJpaRepository.findAll().stream().map((obj) -> new RoomsResDto(obj)).collect(Collectors.toList());
	}
	
}