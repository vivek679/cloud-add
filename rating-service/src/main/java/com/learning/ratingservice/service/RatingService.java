package com.learning.ratingservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.ratingservice.entities.RatingEntity;
import com.learning.ratingservice.modelmapper.RatingMapper;
import com.learning.ratingservice.repository.RatingRepository;
import com.learning.ratingservice.request.RatingRequest;
import com.learning.ratingservice.response.RatingResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository repository;
    private final RatingMapper ratingMapper;

    public RatingResponse create(RatingRequest ratingRequest) {
        RatingEntity rating = ratingMapper.toEntity(ratingRequest);
        rating = repository.save(rating);
        return ratingMapper.toRatingResponse(rating);
    }

    public List<RatingResponse> getRatings() {
        return repository.findAll()
                .stream()
                .map(ratingMapper::toRatingResponse)
                .toList();
    }

    public List<RatingResponse> getRatingByProfileId(String profileId) {
        return repository.findByProfileId(profileId)
                .stream()
                .map(ratingMapper::toRatingResponse).toList();
    }

    public List<RatingResponse> getRatingByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId)
                .stream()
                .map(ratingMapper::toRatingResponse).toList();
    }
}
