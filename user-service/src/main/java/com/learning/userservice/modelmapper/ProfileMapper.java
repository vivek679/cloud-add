package com.learning.userservice.modelmapper;

import org.springframework.stereotype.Component;

import com.learning.userservice.entities.ProfileEntity;
import com.learning.userservice.request.ProfileRequest;
import com.learning.userservice.response.ProfileResponse;

@Component
public class ProfileMapper {

    public ProfileResponse toProfileResponse(ProfileEntity profile) {
        return new ProfileResponse(
                profile.getProfileId(),
                profile.getFirstName(),
                profile.getLastName(),
                profile.getAge(),
                profile.getEthnicity(),
                profile.getGender(),
                profile.getBio(),
                profile.getImageUrl(),
                profile.getMyersBriggsPersonalityType()
        );
    }

    public ProfileEntity toEntity(ProfileRequest profileRequest) {
        return ProfileEntity.builder()
                .firstName(profileRequest.firstName())
                .lastName(profileRequest.lastName())
                .age(profileRequest.age())
                .ethnicity(profileRequest.ethnicity())
                .gender(profileRequest.gender())
                .bio(profileRequest.bio())
                .imageUrl(profileRequest.imageUrl())
                .myersBriggsPersonalityType(profileRequest.myersBriggsPersonalityType())
                .build();
    }
}
