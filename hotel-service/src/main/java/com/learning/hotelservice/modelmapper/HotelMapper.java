package com.learning.hotelservice.modelmapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.learning.hotelservice.entities.HotelEntity;
import com.learning.hotelservice.request.HotelRequest;
import com.learning.hotelservice.response.HotelResponse;

@Component
public class HotelMapper {
    public HotelResponse toHotelResponse(HotelEntity hotel) {
        return new HotelResponse(
                hotel.getHotelId(),
                hotel.getName(),
                hotel.getLocation(),
                hotel.getAbout()
        );
    }

    public HotelEntity toEntity(HotelRequest hotelRequest) {
        String hotelId = UUID.randomUUID().toString();
        return HotelEntity.builder()
                .hotelId(hotelId)
                .name(hotelRequest.name())
                .location(hotelRequest.location())
                .about(hotelRequest.about())
                .build();
    }
}
