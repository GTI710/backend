package com.tipme.form.validator;

import com.tipme.form.account.request.CreateRequest;
import com.tipme.form.account.request.UpdateRequest;
import com.tipme.utils.DateFormatter;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountValidator {

    // Validate if it is an email address
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    // Username between 4-25 characters
    private static final Pattern VALID_USERNAME_REGEX =
            Pattern.compile("^[a-zA-Z0-9_]{4,25}$", Pattern.CASE_INSENSITIVE);

    /**
     * Validate if email address is valid
     * @param emailStr
     * @return boolean
     */
    private static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }

    /**
     * Validate if username is valid (between 4-25 characters)
     * @param usernameStr
     * @return boolean
     */
    private static boolean validateUsername(String usernameStr) {
        Matcher matcher = VALID_USERNAME_REGEX .matcher(usernameStr);
        return matcher.find();
    }

    /**
     * Validate if CreateRequest inputs aren't empty
     * @param req
     * @return boolean
     */
    public static boolean isCreateRequestComplete(CreateRequest req) {

        return CommonValidator.notEmpty(req.getEmail())
                && CommonValidator.notEmpty(req.getUsername())
                && CommonValidator.notEmpty(req.getPassword())
                && CommonValidator.notEmpty(req.getConfirmPassword());
    }

    /**
     * Validate if UpdateRequest inputs aren't empty
     * @param req
     * @return boolean
     */
    public static boolean isUpdateRequestComplete(UpdateRequest req) {

        return CommonValidator.notEmpty(req.getEmail())
                && CommonValidator.notEmpty(req.getUsername())
                && CommonValidator.notEmpty(req.getProfileDescription())
                && CommonValidator.notEmpty(req.getGender())
                && CommonValidator.notEmpty(req.getDateBirthday());
    }

    /**
     * Validate if email is lesser or equal than 100 characters
     * @param email
     * @return boolean
     */
    public static boolean isEmailValid(String email) {
        if(email.length() <= 100){
            return validateEmail(email);
        } else {
            return false;
        }
    }

    /**
     * Validate if username is lesser or equal than 25 characters
     * @param username
     * @return boolean
     */
    public static boolean isUsernameValid(String username) {
        if(username.length() <= 25){
            return validateUsername(username);
        } else {
            return false;
        }
    }

    /**
     * Validate if birthday is at least 13 years old
     * @param dateBirthday
     * @return boolean
     */
    public static boolean isDateBirthdayValid(Date dateBirthday) {
        return DateFormatter.isDateBirthdayValid(dateBirthday);
    }

    /**
     * Validate that the password is lesser or equal than 60 characters
     * @param password
     * @return boolean
     */
    public static boolean isPasswordLengthValid(String password) {
        return password.length() <= 60;
    }
}
