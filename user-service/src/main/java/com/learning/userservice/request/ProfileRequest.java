package com.learning.userservice.request;

import com.learning.Gender;

public record ProfileRequest(
        String firstName,
        String lastName,
        int age,
        String ethnicity,
        Gender gender,
        String bio,
        String imageUrl,
        String myersBriggsPersonalityType) {

    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    // This will only be accepted during deserialization (input), but excluded from the JSON response

    // @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    // This will only be present in the JSON response (output), but excluded when deserializing input

}
