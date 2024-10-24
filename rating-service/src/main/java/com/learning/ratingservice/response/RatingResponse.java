package com.learning.ratingservice.response;

public record RatingResponse(
        String ratingId,
        String profileId,
        String hotelId,
        float rating,
        String feedback) {

    public RatingResponse(String ratingId, String profileId, String hotelId, float rating, String feedback) {
        this.ratingId = ratingId;
        this.profileId = profileId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.feedback = feedback;
    }

    public RatingResponse(String ratingId, String profileId, String hotelId, String feedback) {
        this(ratingId, profileId, hotelId, 1, feedback);
    }
}
