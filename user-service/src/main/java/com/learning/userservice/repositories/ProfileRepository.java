package com.learning.userservice.repositories;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learning.userservice.entities.ProfileEntity;

@Repository
public interface ProfileRepository extends MongoRepository<ProfileEntity, String> {

    @Aggregation(pipeline = {
            "{ $match: { 'gender': ?0 } }",  // Match based on gender
            "{ $sample: { size: 1 } }"       // Get a random document
    })
    ProfileEntity getRandomProfileByGender(String gender);

    @Aggregation(pipeline = {
            "{ $match: { 'gender': { $in: [ 'MALE', 'FEMALE' ] } } }",
            "{ $sample: { size: 1 } }"                                  // Get a random document
    })
    ProfileEntity getRandomProfileForNonBinary();


}
