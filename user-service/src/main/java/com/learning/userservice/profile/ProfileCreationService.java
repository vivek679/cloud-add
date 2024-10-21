package com.learning.userservice.profile;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.Gender;
import com.learning.userservice.util.Utils;

import com.google.gson.reflect.TypeToken;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileCreationService {

    private static final String MALE_PROFILE_PATH = "profiles_male.json";
    private static final String FEMALE_PROFILE_PATH = "profiles_female.json";

    private final ProfileRepository profileRepository;

    /**
     * Used to pre-process the profiles before the App runs.
     */
    public void saveProfilesToDB() {
        List<Profile> allProfiles = new ArrayList<>();
        Type profileListType = new TypeToken<List<Profile>>() {
        }.getType();
        allProfiles.addAll(Utils.loadDataFromJson(FEMALE_PROFILE_PATH, profileListType));
        allProfiles.addAll(Utils.loadDataFromJson(MALE_PROFILE_PATH, profileListType));

        profileRepository.deleteAll();
        profileRepository.saveAll(allProfiles);
    }

    public void createProfile(int numberOfProfiles, Gender lookingFor) {

    }
}
