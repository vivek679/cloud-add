package com.learning.hotelservice.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.hotelservice.request.HotelRequest;
import com.learning.hotelservice.response.HotelResponse;
import com.learning.hotelservice.service.HotelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/hotel-service/v1/hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelResponse> createHotel(@RequestBody HotelRequest hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }


    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelResponse> createHotel(@PathVariable("hotelId") String hotelId) {
        HotelResponse hotelResponse = hotelService.get(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(hotelResponse);
    }


    @GetMapping
    public ResponseEntity<List<HotelResponse>> getAll() {
        return ResponseEntity.ok(hotelService.getAll());
    }
}
