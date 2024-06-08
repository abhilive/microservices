package com.abhilive.user.service.external.services;

import com.abhilive.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
@Service
public interface RatingService {

    @GetMapping("/ratings/users/{userId}")
    List<Rating> getRating(@PathVariable("userId") String userId);

    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(Rating values);

    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);

}
