package com.abhilive.user.service.services;

import com.abhilive.user.service.entities.Hotel;
import com.abhilive.user.service.entities.Rating;
import com.abhilive.user.service.entities.User;
import com.abhilive.user.service.exceptions.ResourceNotFoundException;
import com.abhilive.user.service.external.services.HotelService;
import com.abhilive.user.service.external.services.RatingService;
import com.abhilive.user.service.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelService hotelService;
    @Autowired
    private RatingService ratingService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with given id is not found on server !! :"+ userId)
        );
        logger.info("---- Abhishek ----");
        List<Rating> userRatings = ratingService.getRating(user.getUserId());

        userRatings.forEach(userRating -> {
            Hotel hotel = hotelService.getHotel(userRating.getHotelId());
            userRating.setHotel(hotel);
        });
        user.setRatings(userRatings);
        return user;
    }
}
