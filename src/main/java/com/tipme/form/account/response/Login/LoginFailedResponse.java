package com.tipme.form.account.response.Login;

import org.springframework.http.HttpStatus;

public class LoginFailedResponse extends AbstractLoginResponse {

    private static final String LOGIN_FAILED_REASON = "The username or password is incorrect.";

    private final String message;

    public LoginFailedResponse() {
        super(false, HttpStatus.UNAUTHORIZED);
        this.message = LOGIN_FAILED_REASON;
    }

    public String getMessage() {
        return message;
    }
}
