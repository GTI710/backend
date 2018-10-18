package com.ce.controller;

import com.ce.form.comment.request.CreateRequest;
import com.ce.form.comment.response.CreateResponse;
import com.ce.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("CommentController")
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    /**
     * Create a new comment
     * @param newComment
     * @return CreateResponse
     */
    @PostMapping("")
    public ResponseEntity<?> createRating(@Valid @RequestBody CreateRequest newComment) {

        CreateResponse createResponse = commentService.create(newComment);
        return ResponseEntity.status(createResponse.getStatus()).body(createResponse);
    }

}
