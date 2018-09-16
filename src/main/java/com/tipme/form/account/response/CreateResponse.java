package com.tipme.form.account.response;

import com.tipme.dto.AccountDTO;
import com.tipme.model.Account;
import org.springframework.http.HttpStatus;

public class CreateResponse {

    private static final String CREATE_SUCCEEDED = "The account has been created successfully.";
    private static final String CREATE_FIELDS_MISSING = "All the inputs must be filled.";
    private static final String CREATE_FAILED_EMAIL_CONFLICT = "The email already exists.";
    private static final String CREATE_FAILED_USERNAME_CONFLICT = "The username already exists.";
    private static final String CREATE_WRONG_PASSWORDS = "The password and the confirmation password do not match.";
    private static final String CREATE_INVALID_EMAIL = "The email does not meet the requirements (100 characters maximum).";
    private static final String CREATE_INVALID_USERNAME = "The username does not meet the requirements (between 4-25 characters).";
    private static final String CREATE_INVALID_PASSWORD = "The password does not meet the requirements (60 characters maximum)";
    private static final String INVALID_DATE_FORMAT = "The birthday date does not meet the requirements (\"yyyy-MM-dd\")";
    private static final String CREATE_INVALID_BIRTHDAY = "The user must be older than 13 years old to sign up.";
    private static final String CREATE_FAILED = "The account couldn't be created.";

    private HttpStatus status;
    private String message;
    private AccountDTO user;
    private String token;

    public CreateResponse() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public AccountDTO getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }

    public CreateResponse ok(Account account, String token) {
        status = HttpStatus.OK;
        message = CREATE_SUCCEEDED;
        this.user = new AccountDTO(
                account.getIdAccount(),
                account.getEmail(),
                account.getUsername(),
            null,
            null,
            null,
            null,
            null,
            null,
            null
        );
        this.token = token;
        return this;
    }

    public CreateResponse failed() {
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        message = CREATE_FAILED;
        return this;
    }

    public CreateResponse fieldsMissing() {
        status = HttpStatus.BAD_REQUEST;
        message = CREATE_FIELDS_MISSING;
        return this;
    }

    public CreateResponse wrongPasswords() {
        status = HttpStatus.BAD_REQUEST;
        message = CREATE_WRONG_PASSWORDS;
        return this;
    }

    public CreateResponse invalidDateFormat() {
        status = HttpStatus.BAD_REQUEST;
        message = INVALID_DATE_FORMAT;
        return this;
    }

    public CreateResponse emailAlreadyUsed() {
        status = HttpStatus.CONFLICT;
        message = CREATE_FAILED_EMAIL_CONFLICT;
        return this;
    }

    public CreateResponse usernameAlreadyUsed() {
        status = HttpStatus.CONFLICT;
        message = CREATE_FAILED_USERNAME_CONFLICT;
        return this;
    }

    public CreateResponse invalidEmailFormat() {
        status = HttpStatus.BAD_REQUEST;
        message = CREATE_INVALID_EMAIL;
        return this;
    }

    public CreateResponse invalidUsernameFormat() {
        status = HttpStatus.BAD_REQUEST;
        message = CREATE_INVALID_USERNAME;
        return this;
    }

    public CreateResponse invalidPasswordFormat() {
        status = HttpStatus.BAD_REQUEST;
        message = CREATE_INVALID_PASSWORD;
        return this;
    }

    public CreateResponse invalidBirthday() {
        status = HttpStatus.BAD_REQUEST;
        message = CREATE_INVALID_BIRTHDAY;
        return this;
    }
}
