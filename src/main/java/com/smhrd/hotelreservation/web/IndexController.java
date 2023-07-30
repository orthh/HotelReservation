package com.smhrd.hotelreservation.web;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	private final RoomsService roomsService;
	private final RoomTypesService roomTypesService;
	private final ReservationsService reservationsService;

	// 메인페이지
	@GetMapping("/")
	public String index(ModelMap model) {
		usersService.save();
		return "index";
	}

	// 사용자 페이지
	@GetMapping("/home")
	public String home(ModelMap model) {
		usersService.save();
		return "home";
	}

	// 관리자 페이지
	@GetMapping("/admin")
	public String admin(ModelMap model) {
		usersService.save();
		return "admin";
	}

	// 객실 타입 관리
	@GetMapping("/admin/roomtype")
	public String roomtype(Model model) {
		log.info("객실타입관리 이동...");
		model.addAttribute("roomTypes", roomTypesService.findAll());
		return "roomtype";
	}

	// room(객실 관리)
	@GetMapping("/admin/room")
	public String room(Model model) {
		log.info("객실관리 이동...");
		model.addAttribute("roomTypes", roomTypesService.findAll());
		model.addAttribute("rooms", roomsService.findAllRooms());
		return "room";
	}

	// 예약내역
	@GetMapping("/admin/reservationList")
	public String reservationList(Model model) {
		log.info("예약내역 이동...");
		model.addAttribute("reservtionList", reservationsService.findAll());
		return "reservationList";
	}

}
