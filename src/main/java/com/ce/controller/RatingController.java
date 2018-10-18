package com.ce.controller;

import com.ce.form.rating.request.CreateRequest;
import com.ce.form.rating.response.CreateResponse;
import com.ce.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("RatingController")
@RequestMapping("/api/rating")
public class RatingController {

    @Autowired
    RatingService ratingService;

    /**
     * Create a new rating
     * @param newRating
     * @return CreateResponse
     */
    @PostMapping("")
    public ResponseEntity<?> createRating(@Valid @RequestBody CreateRequest newRating) {

        CreateResponse createResponse = ratingService.create(newRating);
        return ResponseEntity.status(createResponse.getStatus()).body(createResponse);
    }

}
