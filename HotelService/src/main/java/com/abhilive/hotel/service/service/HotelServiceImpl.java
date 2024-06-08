package com.abhilive.hotel.service.service;

import com.abhilive.hotel.service.entities.Hotel;
import com.abhilive.hotel.service.exceptions.ResourceNotFoundException;
import com.abhilive.hotel.service.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String Id) {
        return hotelRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given Id not found !! :" + Id));
    }
}
