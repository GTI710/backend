package com.ce.form.rating.response;

import com.ce.dto.RatingDTO;
import com.ce.model.RatingTable;
import com.ce.utils.DateFormatter;
import org.springframework.http.HttpStatus;

public class CreateResponse {

    private static final String SUCCESS = "The rating has been created successfully.";
    private static final String MISSING_FIELDS = "All the fields must be filled.";

    private HttpStatus status;
    private String message;

    private RatingDTO rating;

    public CreateResponse() {
    }

    public CreateResponse ok(RatingTable r) {
        this.rating = new RatingDTO(
                r.getIdRatingTable(),
                r.getIdProductTemplate(),
                r.getScore(),
                DateFormatter.DateToString(r.getDateCreation())
        );

        status = HttpStatus.OK;
        message = SUCCESS;
        return this;
    }

    public CreateResponse failed() {
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        message = MISSING_FIELDS;
        return this;
    }

    public CreateResponse fieldsMissing() {
        status = HttpStatus.BAD_REQUEST;
        message = MISSING_FIELDS;
        return this;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RatingDTO getRating() {
        return rating;
    }

    public void setRating(RatingDTO rating) {
        this.rating = rating;
    }
}
