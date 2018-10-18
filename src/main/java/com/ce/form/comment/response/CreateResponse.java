package com.ce.form.comment.response;

import com.ce.dto.CommentDTO;
import com.ce.dto.RatingDTO;
import com.ce.model.CommentTable;
import com.ce.model.RatingTable;
import com.ce.utils.DateFormatter;
import org.springframework.http.HttpStatus;

public class CreateResponse {

    private static final String SUCCESS = "The comment has been created successfully.";
    private static final String MISSING_FIELDS = "All the fields must be filled.";

    private HttpStatus status;
    private String message;

    private CommentDTO comment;

    public CreateResponse() {
    }

    public CreateResponse ok(CommentTable c) {
        this.comment = new CommentDTO(
                c.getIdCommentTable(),
                c.getIdProductTemplate(),
                c.getBody(),
                DateFormatter.DateToString(c.getDateCreation())
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

    public CommentDTO getComment() {
        return comment;
    }

    public void setComment(CommentDTO comment) {
        this.comment = comment;
    }
}
