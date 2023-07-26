package com.smhrd.hotelreservation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smhrd.hotelreservation.model.entity.RoomTypes;
import com.smhrd.hotelreservation.model.repository.RoomTypesJpaRepository;
import com.smhrd.hotelreservation.web.dto.RoomTypesResDto;
import com.smhrd.hotelreservation.web.dto.RoomTypesSaveReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoomTypesService {
	
private final RoomTypesJpaRepository roomTypesJpaRepository;
	
	// roomType 추가하기
	@Transactional
	public Long addRoomtype(RoomTypesSaveReqDto requestDto) {
		return roomTypesJpaRepository.save(requestDto.toEntity()).getId();
	}
	
	// 모든 roomType 데이터 보내기
	@Transactional(readOnly = true)
	public List<RoomTypesResDto> findAll(){
		return roomTypesJpaRepository.findAll().stream().map(RoomTypesResDto::new).collect(Collectors.toList());
	}
	
	
	
}
