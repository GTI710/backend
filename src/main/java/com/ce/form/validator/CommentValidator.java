package com.ce.form.validator;

import com.ce.form.comment.request.CreateRequest;

public class CommentValidator {

    /**
     * Validate if CreateRequest inputs aren't empty
     * @param req
     * @return boolean
     */
    public static boolean isCreateRequestComplete(CreateRequest req) {
        return CommonValidator.notEmpty(String.valueOf(req.getIdProductTemplate())) &&
                CommonValidator.notEmpty(req.getBody());
    }
}
