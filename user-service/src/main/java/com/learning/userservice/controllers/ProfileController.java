package com.learning.userservice.controllers;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.Gender;
import com.learning.userservice.request.ProfileRequest;
import com.learning.userservice.response.ProfileResponse;
import com.learning.userservice.service.ProfileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user-service/v1/profiles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping(path = "{userGender}/random", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProfileResponse getRandomProfile(@PathVariable("userGender") Gender userGender) {
        return profileService.getRandomProfileForUser(userGender);
    }

    @PostMapping(path = "/register-new-user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProfileResponse addNewUserFromAppProperties() {
        return profileService.registerNewUserFromAppProperties();
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> registerNewProfile(@RequestBody ProfileRequest payload) {
        ProfileResponse profile = profileService.registerNewProfile(payload);
        return ResponseEntity.created(URI.create(profile.profileId())).build();
    }

    @GetMapping
    public ResponseEntity<?> getAllProfiles() {
        return ResponseEntity.ok().body(profileService.getAllProfiles());
    }

    @GetMapping(path = "{profileId}")
    public ResponseEntity<?> getProfileById(@PathVariable("profileId") String profileId) {
        return ResponseEntity.ok().body(profileService.getProfileById(profileId));
    }

}
