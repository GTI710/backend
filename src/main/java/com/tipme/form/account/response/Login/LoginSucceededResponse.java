package com.tipme.form.account.response.Login;

import com.tipme.model.Account;
import org.springframework.http.HttpStatus;

public class LoginSucceededResponse extends AbstractLoginResponse {

    private final Account user;
    private final String token;

    public LoginSucceededResponse(Account user, String token) {
        super(true, HttpStatus.OK);
        this.user = user;
        this.token = token;
    }

    public Account getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }
}
