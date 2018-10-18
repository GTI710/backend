package com.ce.form.validator;

import com.ce.form.rating.request.CreateRequest;

public class RatingValidator {

    /**
     * Validate if CreateRequest inputs aren't empty
     * @param req
     * @return boolean
     */
    public static boolean isCreateRequestComplete(CreateRequest req) {
        return CommonValidator.notEmpty(String.valueOf(req.getIdProductTemplate())) &&
                CommonValidator.notEmpty(String.valueOf(req.getScore()));
    }
}
