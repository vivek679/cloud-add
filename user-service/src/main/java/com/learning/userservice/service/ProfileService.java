package com.learning.userservice.service;

import static com.learning.Gender.FEMALE;
import static com.learning.Gender.MALE;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.learning.Gender;
import com.learning.userservice.entities.ProfileEntity;
import com.learning.userservice.exceptions.ResourceNotFoundException;
import com.learning.userservice.modelmapper.ProfileMapper;
import com.learning.userservice.repositories.ProfileRepository;
import com.learning.userservice.request.ProfileRequest;
import com.learning.userservice.response.ProfileResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileService {

    @Value("#{${user.default.profile.character}}")
    private Map<String, String> userProfileProperties;

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;


    public ProfileResponse getRandomProfileForUser(Gender userGender) {
        return switch (userGender) {
            case MALE -> profileMapper.toProfileResponse(profileRepository.getRandomProfileByGender(FEMALE.toString()));
            case FEMALE -> profileMapper.toProfileResponse(profileRepository.getRandomProfileByGender(MALE.toString()));
            case NON_BINARY -> profileMapper.toProfileResponse(profileRepository.getRandomProfileForNonBinary());
            default -> throw new IllegalArgumentException("Invalid gender: " + userGender);
        };
    }

    public ProfileResponse registerNewUserFromAppProperties() {
        return profileMapper.toProfileResponse(
                profileRepository.findById(userProfileProperties.get("profileId"))
                        .orElseGet(() -> {
                            ProfileEntity profileEntity = new ProfileEntity(
                                    userProfileProperties.get("profileId"),
                                    userProfileProperties.get("firstName"),
                                    userProfileProperties.get("lastName"),
                                    Integer.parseInt(userProfileProperties.get("age")),
                                    userProfileProperties.get("ethnicity"),
                                    Gender.valueOf(userProfileProperties.get("gender")),
                                    userProfileProperties.get("bio"),
                                    userProfileProperties.get("imageUrl"),
                                    userProfileProperties.get("myersBriggsPersonalityType")
                            );
                            return profileRepository.save(profileEntity);
                        }));
    }

    public List<ProfileResponse> getAllProfiles() {
        return profileRepository.findAll()
                .stream()
                .map(profileMapper::toProfileResponse)
                .collect(Collectors.toList());
    }

    public ProfileResponse getProfileById(String profileId) {
        ProfileEntity profileEntity = profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile with id: [" + profileId + "] not found"));
        return profileMapper.toProfileResponse(profileEntity);

    }

    public ProfileResponse registerNewProfile(ProfileRequest profileRequest) {
        ProfileEntity profileEntity = profileMapper.toEntity(profileRequest);
        profileEntity = profileRepository.save(profileEntity);
        return profileMapper.toProfileResponse(profileEntity);
    }
}
