package com.tipme.form.account.response.Login;

import org.springframework.http.HttpStatus;

public class AbstractLogoutResponse {

    private final boolean isAuthenticated;
    private final HttpStatus status;

    public AbstractLogoutResponse(boolean isAuthenticated, HttpStatus status) {
        this.isAuthenticated = isAuthenticated;
        this.status = status;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
