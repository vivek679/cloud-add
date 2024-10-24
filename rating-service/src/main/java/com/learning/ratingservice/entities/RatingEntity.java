package com.learning.ratingservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("ratings")
public class RatingEntity {

    @Id
    private String ratingId;
    private String profileId;
    private String hotelId;
    private float rating;
    private String feedback;
}
