package com.learning.hotelservice.response;

public record HotelResponse(
        String hotelId,
        String name,
        String location,
        String about
) {
}
