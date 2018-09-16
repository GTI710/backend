package com.tipme.form.account.response.Login;

import org.springframework.http.HttpStatus;

public class LogoutSucceededResponse extends AbstractLogoutResponse {

    private final Integer accountId;
    private final String username;

    public LogoutSucceededResponse(Integer accountId, String username) {
        super(false, HttpStatus.OK);
        this.accountId = accountId;
        this.username = username;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return username;
    }
}
