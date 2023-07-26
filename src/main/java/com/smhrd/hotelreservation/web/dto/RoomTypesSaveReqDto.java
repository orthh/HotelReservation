package com.smhrd.hotelreservation.web.dto;

import com.smhrd.hotelreservation.model.entity.RoomTypes;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RoomTypesSaveReqDto {
	private String roomName;
	private Long price;
	
	@Builder
	public RoomTypesSaveReqDto(String roomName, Long price) {
		this.roomName = roomName;
		this.price = price;
	}
	
	public RoomTypes toEntity() {
		return RoomTypes.builder().roomName(roomName).price(price).build();
	}
}
