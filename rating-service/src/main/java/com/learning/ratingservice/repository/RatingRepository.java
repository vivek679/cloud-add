package com.learning.ratingservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learning.ratingservice.entities.RatingEntity;

@Repository
public interface RatingRepository extends MongoRepository<RatingEntity, String> {

//    @Query("Select r FROM RATINGS r r.profileId = profileId")
    List<RatingEntity> findByProfileId(String profileId);

    List<RatingEntity> findByHotelId(String hotelId);
}
