package com.ce.service;

import com.ce.form.rating.request.CreateRequest;
import com.ce.form.rating.response.CreateResponse;
import com.ce.form.validator.RatingValidator;
import com.ce.model.RatingTable;
import com.ce.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    /**
     * Create a rating
     * @param request
     * @return CreateResponse
     */
    @Transactional
    public CreateResponse create(CreateRequest request) {

        // If the inputs are empty
        if (!RatingValidator.isCreateRequestComplete(request)) {
            return new CreateResponse().fieldsMissing();
        }

        RatingTable newRating;

        try {

            // Create the rating
            newRating = new RatingTable(
                    null,
                    request.getIdProductTemplate(),
                    request.getScore(),
                    new Date()
            );

            // Save the changes
            RatingTable created = ratingRepository.save(newRating);

        } catch (NullPointerException npe) {
            return new CreateResponse().failed();
        }

        return new CreateResponse().ok(newRating);
    }
}
