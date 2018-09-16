package com.tipme.form.account.response;

import com.tipme.dto.AccountDTO;
import com.tipme.model.Account;
import com.tipme.utils.DateFormatter;
import org.springframework.http.HttpStatus;

public class UpdateResponse {

    private static final String UPDATE_SUCCEEDED = "The account has been updated successfully.";
    private static final String UPDATE_FIELDS_MISSING = "All the inputs must be filled.";
    private static final String UPDATE_FAILED_EMAIL_CONFLICT = "The email already exists.";
    private static final String UPDATE_FAILED_USERNAME_CONFLICT = "The username already exists.";
    private static final String UPDATE_FAILED = "The account couldn't be updated.";
    private static final String UPDATE_INVALID_EMAIL = "The email does not meet the requirements (100 characters maximum).";
    private static final String UPDATE_INVALID_USERNAME = "The username does not meet the requirements (between 4-25 characters).";
    private static final String UPDATE_INVALID_DATE_FORMAT = "The birthday date does not meet the requirements (\"yyyy-MM-dd\")";
    private static final String UPDATE_INVALID_BIRTHDAY = "The user must be older than 13 years old to sign up.";
    private final String ACCOUNT_NOT_FOUND = "The account couldn't be found.";

    private HttpStatus status;
    private String message;
    private AccountDTO user;
    private String token;

    public UpdateResponse() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public UpdateResponse ok(Account account, String token) {
        status = HttpStatus.OK;
        message = UPDATE_SUCCEEDED;
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
        this.token = token;
        return this;
    }

    public UpdateResponse failed() {
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        message = UPDATE_FAILED;
        return this;
    }

    public UpdateResponse fieldsMissing() {
        status = HttpStatus.BAD_REQUEST;
        message = UPDATE_FIELDS_MISSING;
        return this;
    }

    public UpdateResponse notFound() {
        status = HttpStatus.NOT_FOUND;
        message = ACCOUNT_NOT_FOUND;
        return this;
    }

    public UpdateResponse invalidDateFormat() {
        status = HttpStatus.BAD_REQUEST;
        message = UPDATE_INVALID_DATE_FORMAT;
        return this;
    }

    public UpdateResponse emailAlreadyUsed() {
        status = HttpStatus.CONFLICT;
        message = UPDATE_FAILED_EMAIL_CONFLICT;
        return this;
    }

    public UpdateResponse usernameAlreadyUsed() {
        status = HttpStatus.CONFLICT;
        message = UPDATE_FAILED_USERNAME_CONFLICT;
        return this;
    }

    public UpdateResponse invalidEmailFormat() {
        status = HttpStatus.BAD_REQUEST;
        message = UPDATE_INVALID_EMAIL;
        return this;
    }

    public UpdateResponse invalidUsernameFormat() {
        status = HttpStatus.BAD_REQUEST;
        message = UPDATE_INVALID_USERNAME;
        return this;
    }

    public UpdateResponse invalidBirthday() {
        status = HttpStatus.BAD_REQUEST;
        message = UPDATE_INVALID_BIRTHDAY;
        return this;
    }

    public AccountDTO getUser() {
        return user;
    }

    public void setUser(AccountDTO user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
