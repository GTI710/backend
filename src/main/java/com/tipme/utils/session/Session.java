package com.tipme.utils.session;

import java.util.Date;

public class Session {

    private final Integer accountId;
    private final String username;
    private String token;
    private Date expire;

    public Session(Integer accountId, String username, String token, Date expire) {
        this.accountId = accountId;
        this.username = username;
        this.token = token;
        this.expire = expire;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }

    public Date getExpire() {
        return expire;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }
}
