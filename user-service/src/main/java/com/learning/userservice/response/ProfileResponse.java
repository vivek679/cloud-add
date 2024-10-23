package com.learning.userservice.response;

import com.learning.Gender;

public record ProfileResponse(
        String profileId,
        String firstName,
        String lastName,
        int age,
        String ethnicity,
        Gender gender,
        String bio,
        String imageUrl,
        String myersBriggsPersonalityType) {
}
