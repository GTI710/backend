package com.tipme.form.account.response.Login;

import org.springframework.http.HttpStatus;

public class LogoutFailedResponse extends AbstractLogoutResponse {

    private static final String LOGOUT_FAILED = "The account couldn't be logged off.";

    private final String message;

    public LogoutFailedResponse() {
        super(true, HttpStatus.UNAUTHORIZED);
        this.message = LOGOUT_FAILED;
    }

    public String getMessage() {
        return message;
    }
}
