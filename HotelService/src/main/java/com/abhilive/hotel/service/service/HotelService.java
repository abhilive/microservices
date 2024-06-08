package com.abhilive.hotel.service.service;

import com.abhilive.hotel.service.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel get(String Id);
}
