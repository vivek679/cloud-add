package com.learning.userservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.userservice.repositories.ProfileRepository;
import com.learning.userservice.service.ProfileCreationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

    @Value("${startup-actions.initializeProfiles}")
    private Boolean initializeProfiles;

    private final ProfileRepository profileRepository;
    private final ProfileCreationService profileCreationService;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class);
    }

    private void clearAllData() {
        profileRepository.deleteAll();
    }

    @Override
    public void run(String... args) {
        logger.info("Pre-processing-started");
        if (initializeProfiles) {
            clearAllData();
            profileCreationService.saveProfilesToDB();
        }
        logger.info("Pre-processing-completed");
    }
}
