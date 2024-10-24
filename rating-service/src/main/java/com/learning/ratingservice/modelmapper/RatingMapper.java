package com.learning.ratingservice.modelmapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.learning.ratingservice.entities.RatingEntity;
import com.learning.ratingservice.request.RatingRequest;
import com.learning.ratingservice.response.RatingResponse;

@Component
public class RatingMapper {
    public RatingResponse toRatingResponse(RatingEntity rating) {
        return new RatingResponse(
                rating.getRatingId(),
                rating.getProfileId(),
                rating.getHotelId(),
                rating.getRating(),
                rating.getFeedback());
    }

    public RatingEntity toEntity(RatingRequest ratingRequest) {
        String ratingId = UUID.randomUUID().toString();
        return RatingEntity.builder()
                .ratingId(ratingId)
                .profileId(ratingRequest.profileId())
                .hotelId(ratingRequest.hotelId())
                .rating(ratingRequest.rating())
                .feedback(ratingRequest.feedback())
                .build();
    }
}
