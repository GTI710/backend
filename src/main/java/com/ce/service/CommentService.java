package com.ce.service;

import com.ce.form.comment.request.CreateRequest;
import com.ce.form.comment.response.CreateResponse;
import com.ce.form.validator.CommentValidator;
import com.ce.model.CommentTable;
import com.ce.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    /**
     * Create a comment
     * @param request
     * @return CreateResponse
     */
    @Transactional
    public CreateResponse create(CreateRequest request) {

        // If the inputs are empty
        if (!CommentValidator.isCreateRequestComplete(request)) {
            return new CreateResponse().fieldsMissing();
        }

        CommentTable newComment;

        try {

            // Create the rating
            newComment = new CommentTable(
                    null,
                    request.getIdProductTemplate(),
                    request.getBody(),
                    new Date()
            );

            // Save the changes
            CommentTable created = commentRepository.save(newComment);

        } catch (NullPointerException npe) {
            return new CreateResponse().failed();
        }

        return new CreateResponse().ok(newComment);
    }
}
