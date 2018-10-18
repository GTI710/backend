package com.ce.form.sale.response;

import com.ce.dto.SaleDTO;
import com.ce.model.SaleTable;
import com.ce.utils.DateFormatter;
import org.springframework.http.HttpStatus;

public class CreateResponse {

    private static final String SUCCESS = "The sale has been created successfully.";
    private static final String MISSING_FIELDS = "All the fields must be filled.";

    private HttpStatus status;
    private String message;

    private SaleDTO sale;

    public CreateResponse() {
    }

    public CreateResponse ok(SaleTable s) {
        this.sale = new SaleDTO(
                s.getIdSaleTable(),
                s.getSalesNumber(),
                s.getAmount(),
                s.getNameClient(),
                s.getCurrency(),
                DateFormatter.DateToString(s.getDateCreation())
        );

        status = HttpStatus.OK;
        message = SUCCESS;
        return this;
    }

    public CreateResponse failed() {
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        message = MISSING_FIELDS;
        return this;
    }

    public CreateResponse fieldsMissing() {
        status = HttpStatus.BAD_REQUEST;
        message = MISSING_FIELDS;
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

    public SaleDTO getSale() {
        return sale;
    }

    public void setSale(SaleDTO sale) {
        this.sale = sale;
    }
}
