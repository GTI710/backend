package com.tipme.form.account.response;

import org.springframework.http.HttpStatus;

public class ResetPasswordResponse {

    private static final String RESET_SUCCEEDED = "The password has been updated successfully.";
    private static final String RESET_FAILED = "A problem has been encountered.";
    private static final String RESET_WRONG_OLD_PASSWORD = "The old password is invalid.";
    private static final String RESET_WRONG_NEW_PASSWORDS = "The new password and the new password confirmation do not match.";

    private HttpStatus status;
    private String message;

    public ResetPasswordResponse() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ResetPasswordResponse ok() {
        status = HttpStatus.OK;
        message = RESET_SUCCEEDED;
        return this;
    }

    public ResetPasswordResponse failed() {
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        message = RESET_FAILED;
        return this;
    }

    public ResetPasswordResponse wrongOldPassword() {
        status = HttpStatus.BAD_REQUEST;
        message = RESET_WRONG_OLD_PASSWORD;
        return this;
    }

    public ResetPasswordResponse wrongNewPasswords() {
        status = HttpStatus.BAD_REQUEST;
        message = RESET_WRONG_NEW_PASSWORDS;
        return this;
    }
}
