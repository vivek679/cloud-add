package com.learning.userservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.Gender;
import com.learning.userservice.service.ProfileCreationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("user-service/v1/profiles-creations")
public class ProfileCreationController {

    private final ProfileCreationService profileCreationService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createProfiles(
            @RequestParam(value = "numberOfProfiles", defaultValue = "0") int numberOfProfiles,
            @RequestParam(value = "lookingFor", defaultValue = "FEMALE") Gender lookingFor) {
        profileCreationService.createProfile(numberOfProfiles, lookingFor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
