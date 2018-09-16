package com.tipme.form.validator;


public class CommonValidator {

    /**
     * Validate if the string is not empty
     * @param s
     * @return boolean
     */
    public static boolean notEmpty(final String s) {
        return s != null && !s.trim().isEmpty();
    }
}
