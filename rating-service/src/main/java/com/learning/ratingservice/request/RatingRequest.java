package com.learning.ratingservice.request;

public record RatingRequest(
        String profileId,
        String hotelId,
        float rating,
        String feedback) {

    public RatingRequest(String profileId, String hotelId, float rating, String feedback) {
        this.profileId = profileId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.feedback = feedback;
    }

    public RatingRequest(String profileId, String hotelId, String feedback) {
        this(profileId, hotelId, 1, feedback);
    }
}
