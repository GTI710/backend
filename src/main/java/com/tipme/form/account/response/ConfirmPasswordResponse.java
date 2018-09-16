package com.tipme.form.account.response;

import org.springframework.http.HttpStatus;

public class ConfirmPasswordResponse {

    private static final String CONFIRM_SUCCEEDED = "The password has been confirmed successfully.";
    private static final String CONFIRM_FAILED = "A problem has been encountered.";
    private static final String CONFIRM_WRONG_PASSWORD = "The password is incorrect.";

    private HttpStatus status;
    private String message;

    public ConfirmPasswordResponse() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ConfirmPasswordResponse ok() {
        status = HttpStatus.OK;
        message = CONFIRM_SUCCEEDED;
        return this;
    }

    public ConfirmPasswordResponse failed() {
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        message = CONFIRM_FAILED;
        return this;
    }

    public ConfirmPasswordResponse wrongPassword() {
        status = HttpStatus.BAD_REQUEST;
        message = CONFIRM_WRONG_PASSWORD;
        return this;
    }
}
