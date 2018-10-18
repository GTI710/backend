package com.ce.form.validator;

import com.ce.form.sale.request.CreateRequest;

public class SaleValidator {

    /**
     * Validate if CreateRequest inputs aren't empty
     * @param req
     * @return boolean
     */
    public static boolean isCreateRequestComplete(CreateRequest req) {
        return CommonValidator.notEmpty(req.getNameClient()) &&
                CommonValidator.notEmpty(String.valueOf(req.getAmount())) &&
                CommonValidator.notEmpty(req.getCity()) &&
                CommonValidator.notEmpty(req.getCountry()) &&
                CommonValidator.notEmpty(req.getStreet()) &&
                CommonValidator.notEmpty(req.getZipcode());
    }
}
