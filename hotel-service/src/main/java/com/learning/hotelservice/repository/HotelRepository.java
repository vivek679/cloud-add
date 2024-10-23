package com.learning.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.hotelservice.entities.HotelEntity;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, String> {

}
