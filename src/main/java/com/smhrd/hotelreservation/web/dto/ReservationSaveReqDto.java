package com.smhrd.hotelreservation.web.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReservationSaveReqDto {
	private LocalDate checkOutDate;
	private LocalDate checkInDate;
	private Long roomType;
	
	@Builder
	public ReservationSaveReqDto(LocalDate checkOutDate, LocalDate checkInDate, Long roomType) {
		this.checkOutDate = checkOutDate;
		this.checkInDate = checkInDate;
		this.roomType = roomType;
	}
}
