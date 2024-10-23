package com.learning.hotelservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.learning.hotelservice.entities.HotelEntity;
import com.learning.hotelservice.exceptions.ResourceNotFoundException;
import com.learning.hotelservice.modelmapper.HotelMapper;
import com.learning.hotelservice.repository.HotelRepository;
import com.learning.hotelservice.request.HotelRequest;
import com.learning.hotelservice.response.HotelResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;


    public HotelResponse create(HotelRequest hotelRequest) {
        return hotelMapper.toHotelResponse(
                hotelRepository.save(
                        hotelMapper.toEntity(hotelRequest)
                )
        );
    }

    public HotelResponse get(String hotelId) {
        HotelEntity hotelEntity = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Something"));
        return hotelMapper.toHotelResponse(hotelEntity);
    }

    public List<HotelResponse> getAll() {
        return hotelRepository.findAll()
                .stream()
                .map(hotelMapper::toHotelResponse)
                .collect(Collectors.toList());
    }
}
