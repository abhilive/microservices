package com.abhilive.user.service;

import com.abhilive.user.service.entities.Rating;
import com.abhilive.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	RatingService ratingService;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateRating() {
		Rating rating = Rating.builder().ratingId(10).userId("").hotelId("").feedback("This is created using feign client.").build();
		ResponseEntity<Rating> newRating = ratingService.createRating(rating);
		System.out.println("New rating created with status code: " + newRating.getStatusCode());
	}

}
