package com.tipme.form.account.response;

import org.springframework.http.HttpStatus;

public class DeleteResponse {

    private final String ACCOUNT_NOT_FOUND = "The account couldn't be found.";
    private final String ACCOUNT_DELETE_FAILED = "The account couldn't be deleted.";
    private final String SUCCESS = "The account has been deleted successfully.";

    private HttpStatus status;
    private String message;

    public DeleteResponse() {
    }

    public DeleteResponse ok() {
        status = HttpStatus.OK;
        message = SUCCESS;
        return this;
    }

    public DeleteResponse notFound() {
        status = HttpStatus.NOT_FOUND;
        message = ACCOUNT_NOT_FOUND;
        return this;
    }

    public DeleteResponse failed() {
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        message = ACCOUNT_DELETE_FAILED;
        return this;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
