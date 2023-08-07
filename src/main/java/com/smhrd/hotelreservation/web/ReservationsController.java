package com.smhrd.hotelreservation.web;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.hotelreservation.service.ReservationsService;
import com.smhrd.hotelreservation.web.dto.ReservationSaveReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ReservationsController {
	
	private final ReservationsService reservationsService;
	
	// post	예약등록
	@PostMapping("/home/reservation/add")
	public Long reservation(@RequestBody ReservationSaveReqDto requestDto) {
		// @RequestBody로 받으면 Dto타입으로 받을 수 있음.
		System.out.println(requestDto);
		log.info("view to controller with reservation");
//		return 200L;
		return reservationsService.reservation(requestDto);
	}
	
	// delete 관리자 상세예약 취소
	@DeleteMapping("/admin/reservationdetails/remove")
	public Long adminDelete() {
		
		
		
		return 1L;
	}
	
	
	
}
