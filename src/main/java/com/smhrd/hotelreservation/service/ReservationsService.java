package com.smhrd.hotelreservation.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.smhrd.hotelreservation.model.entity.ReservationDetails;
import com.smhrd.hotelreservation.model.entity.Rooms;
import com.smhrd.hotelreservation.model.entity.Users;
import com.smhrd.hotelreservation.web.dto.ReservationDetailsSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReservationsService {
	
	/**
	 * method	예약
	 */
	@Transactional
	public Long reservation(List<ReservationDetailsSaveReqDto> requestDto) {
		
		Long code = 200L;
		
		// 예약정보 저장
//		this.saveReservation(requestDto);
		
		
		
		
		
		return code;
		
	}
	
	/**
	 * method	예약 정보 등록
	 */
//	@Transactional
//	public Long saveReservation(List<ReservationDetailsSaveReqDto> requestDto) {
//		Users users = Users.builder().build();
//		List<ReservationDetails> reservationDetailList = new ArrayList<ReservationDetails>();
//		
//		for(ReservationDetailsSaveReqDto elem : requestDto) {
//			Rooms rooms = RoomsService.findById(elem.getRoomId());
//			ReservationDetails reservationDetails = ReservationDetails
//		}
//		
//		
//	}
	
	
	
	
}
