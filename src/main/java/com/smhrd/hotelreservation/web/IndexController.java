package com.smhrd.hotelreservation.web;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.smhrd.hotelreservation.service.ReservationsService;
import com.smhrd.hotelreservation.service.RoomTypesService;
import com.smhrd.hotelreservation.service.RoomsService;
import com.smhrd.hotelreservation.service.UsersService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final UsersService usersService;
//	private final ReservationsService reservationsService;
	private final RoomsService roomsService;
	private final RoomTypesService roomTypesService;
	
	
	// 메인페이지
	@GetMapping("/")
	public String index(ModelMap model) {
		usersService.save();
		return "index";
	}
	
	// reservation(예약하기)
	@GetMapping("/reservation")
	public String reservation(Model model) {
		log.info("예약하기 이동...");
		model.addAttribute("roomTypes", roomTypesService.findAll());
		return "reservation";
	}
	
	// 객실 타입 관리
	@GetMapping("/roomtype")
	public String roomtype(Model model) {
		log.info("객실타입관리 이동...");
		model.addAttribute("roomTypes", roomTypesService.findAll());
		return "roomtype";
	}
	
	// room(객실 관리)
	@GetMapping("/room")
	public String room(Model model) {
		log.info("객실관리 이동...");
		model.addAttribute("roomTypes", roomTypesService.findAll());
		model.addAttribute("rooms", roomsService.findAllRooms());
		return "room";
	}
	
	
	
//	
	// reservationList(예약내역)
//	@GetMapping("/reservationList")
//	public String reservationList(Model model) {
//		log.info("예약 내역 이동...");
//		model.addAttribute("reservations", reservationsService.findAllReservations());
//		return "reservationList";
//	}
//	

	
	
	
	
	
}
