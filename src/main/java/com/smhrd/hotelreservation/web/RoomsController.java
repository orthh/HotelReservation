package com.smhrd.hotelreservation.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.hotelreservation.service.RoomsService;
import com.smhrd.hotelreservation.web.dto.ReservationSaveReqDto;
import com.smhrd.hotelreservation.web.dto.RoomTypesSaveReqDto;
import com.smhrd.hotelreservation.web.dto.RoomsSaveReqDto;
import com.smhrd.hotelreservation.web.dto.RoomsUpdateReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RoomsController {

	private final RoomsService roomservice;
	
	@PostMapping("/admin/room/add")
	public Long addRoom(@RequestBody RoomsSaveReqDto requestDto) {
		log.info("view to controller with addRoom");
		return roomservice.addRoom(requestDto);
	}
	
	@PutMapping("/admin/room/update")
	public Long updateRoom(@RequestBody RoomsUpdateReqDto requestDto) {
		System.out.println(requestDto.getRoomId());
		System.out.println(requestDto.getRoomTypeId());
		return roomservice.updateRoom(requestDto);
	}
	
}
