package com.smhrd.hotelreservation.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smhrd.hotelreservation.model.entity.Rooms;

public interface RoomsJpaRepository extends JpaRepository<Rooms, Long>{

}
