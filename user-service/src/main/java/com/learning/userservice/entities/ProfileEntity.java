package com.learning.userservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.learning.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "profiles")
public class ProfileEntity {
    @Id
    private String profileId;
    private String firstName;
    private String lastName;
    private int age;
    private String ethnicity;
    private Gender gender;
    private String bio;
    private String imageUrl;
    private String myersBriggsPersonalityType;

}
