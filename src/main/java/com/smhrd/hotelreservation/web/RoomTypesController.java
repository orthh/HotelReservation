package com.smhrd.hotelreservation.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.smhrd.hotelreservation.service.RoomTypesService;

import com.smhrd.hotelreservation.web.dto.RoomTypesSaveReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@RestController
public class RoomTypesController {
	
	private final  RoomTypesService roomTypesService;

	@PostMapping("/admin/roomtype/add")
	public Long addRoomtype(@RequestBody RoomTypesSaveReqDto requestDto) {
		// @RequestBody로 받으면 Dto타입으로 받을 수 있음.
		log.info("view to controller with addRoomtype");
		return roomTypesService.addRoomtype(requestDto);
	}
}
