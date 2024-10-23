package com.learning.hotelservice.request;

public record HotelRequest(
        String name,
        String location,
        String about
) {
}
