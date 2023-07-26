package com.smhrd.hotelreservation.service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smhrd.hotelreservation.model.entity.ReservationDetails;
import com.smhrd.hotelreservation.model.entity.Rooms;
import com.smhrd.hotelreservation.model.entity.Users;
import com.smhrd.hotelreservation.web.dto.ReservationSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReservationsService {
	
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
		List<ReservationDetails> reservationDetailList = new ArrayList<ReservationDetails>();
		
		// 일자별로 카운트 계산하기
		// ChronoUnit.DAYS.between(a,b) : 두개의 특정 날짜 사이의 차이 일수반환
		// ChronoUnit.DAYS.between(date, longAmount) : 특정날짜 전/후 알기 
		int days = (int) ChronoUnit.DAYS.between(requestDto.getCheckInDate(), requestDto.getCheckOutDate());
		System.out.println(days);
		for(int i=0; i<days; i++) {
			
		}
		
		
		
		return 200L;
	}
	
	
	
	
}
