package com.tipme.form.account.response;

import com.tipme.dto.AccountDTO;
import com.tipme.model.Account;
import com.tipme.utils.DateFormatter;
import org.springframework.http.HttpStatus;

public class InfoResponse {

    private static final String INFO_FAILED = "A problem has been encountered, please login again.";
    private static final String INFO_SESSION_EXPIRED = "Session expired, please login again.";
    private static final String INFO_OK = "OK";

    private HttpStatus status;
    private String message;
    private AccountDTO user;
    private boolean tokenExpired;

    public InfoResponse() {
    }

    public InfoResponse ok(Account account) {
        this.status = HttpStatus.OK;
        this.message = INFO_OK;
        this.tokenExpired = false;
        this.user = new AccountDTO(
                account.getIdAccount(),
                account.getEmail(),
                account.getUsername(),
                account.getProfileDescription(),
                DateFormatter.DateToStringDate(account.getDateBirthday()),
                null,
                account.getImageProfile(),
                null,
                null,
                account.getGender()
        );
        return this;
    }

    public InfoResponse failed() {
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        message = INFO_FAILED;
        this.tokenExpired = true;
        return this;
    }

    public InfoResponse sessionExpired() {
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        message = INFO_SESSION_EXPIRED;
        tokenExpired = true;
        return this;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AccountDTO getUser() {
        return user;
    }

    public void setUser(AccountDTO user) {
        this.user = user;
    }

    public boolean getTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }
}
