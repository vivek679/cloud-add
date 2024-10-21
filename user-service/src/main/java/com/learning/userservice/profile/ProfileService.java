package com.learning.userservice.profile;

import static com.learning.Gender.FEMALE;
import static com.learning.Gender.MALE;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.learning.Gender;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileService {

    @Value("#{${user.default.profile.character}}")
    private Map<String, String> userProfileProperties;

    private final ProfileRepository profileRepository;


    public Profile getRandomProfileForUser(Gender userGender) {
        return switch (userGender) {
            case MALE -> profileRepository.getRandomProfileByGender(FEMALE.toString());
            case FEMALE -> profileRepository.getRandomProfileByGender(MALE.toString());
            case NON_BINARY -> profileRepository.getRandomProfileForNonBinary();
            default -> throw new IllegalArgumentException("Invalid gender: " + userGender);
        };
    }

    public Profile registerNewUserFromAppProperties() {
        return profileRepository.findById(userProfileProperties.get("profileId"))
                .orElseGet(() -> {
                    Profile profile = new Profile(
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
                    return profileRepository.save(profile);
                });
    }
}
