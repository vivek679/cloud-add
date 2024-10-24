package com.learning.ratingservice.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.ratingservice.request.RatingRequest;
import com.learning.ratingservice.response.RatingResponse;
import com.learning.ratingservice.service.RatingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rating-service/v1/ratings")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @PostMapping
    public ResponseEntity<RatingResponse> createRating(@RequestBody RatingRequest ratingRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(ratingRequest));
    }

    @GetMapping
    public ResponseEntity<List<RatingResponse>> getRatings() {
        return ResponseEntity.ok(ratingService.getRatings());
    }

    @GetMapping("/profile/{profileId}")
    public ResponseEntity<List<RatingResponse>> getRatingsByProfileId(@PathVariable("profileId") String profileId) {
        return ResponseEntity.ok(ratingService.getRatingByProfileId(profileId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<RatingResponse>> getRatingsByHotelId(@PathVariable("hotelId") String hotelId) {
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }
}
