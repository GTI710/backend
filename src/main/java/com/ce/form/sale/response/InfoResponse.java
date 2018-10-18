package com.ce.form.sale.response;

import com.ce.dto.SaleDTO;
import com.ce.model.SaleTable;
import com.ce.utils.DateFormatter;
import org.springframework.http.HttpStatus;


public class InfoResponse {

    private SaleDTO sale;

    private HttpStatus status;
    private String message;

    private final String CREATE_FIELDS_MISSING = "All the fields must be filled.";
    private final String SALE_NOT_FOUND = "The sale couldn't be found.";
    private final String SALE_FAILED = "The sale couldn't be fetched.";
    private static final String INFO_OK = "OK";

    public InfoResponse() {
    }

    public InfoResponse ok(SaleTable s) {
        this.sale = new SaleDTO(
                s.getIdSaleTable(),
                s.getSalesNumber(),
                s.getAmount(),
                s.getNameClient(),
                s.getCurrency(),
                DateFormatter.DateToString(s.getDateCreation())
        );

        message = INFO_OK;
        status = HttpStatus.OK;
        return this;
    }

    public InfoResponse notFound() {
        status = HttpStatus.NOT_FOUND;
        message = SALE_NOT_FOUND;
        return this;
    }

    public InfoResponse failed() {
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        message = SALE_FAILED;
        return this;
    }

    public InfoResponse fieldsMissing() {
        status = HttpStatus.BAD_REQUEST;
        message = CREATE_FIELDS_MISSING;
        return this;
    }

    public SaleDTO getSale() {
        return sale;
    }

    public void setSale(SaleDTO sale) {
        this.sale = sale;
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
}
