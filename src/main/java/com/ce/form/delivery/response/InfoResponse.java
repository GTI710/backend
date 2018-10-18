package com.ce.form.delivery.response;

import com.ce.dto.DeliveryDTO;
import com.ce.model.DeliveryTable;
import com.ce.utils.DateFormatter;
import org.springframework.http.HttpStatus;


public class InfoResponse {

    private DeliveryDTO delivery;

    private HttpStatus status;
    private String message;

    private final String CREATE_FIELDS_MISSING = "All the fields must be filled.";
    private final String SALE_NOT_FOUND = "The delivery couldn't be found.";
    private final String SALE_FAILED = "The delivery couldn't be fetched.";
    private static final String INFO_OK = "OK";

    public InfoResponse() {
    }

    public InfoResponse ok(DeliveryTable d) {
        this.delivery = new DeliveryDTO(
                d.getIdDeliveryTable(),
                d.getIdSaleTable(),
                d.getStreet(),
                d.getZipcode(),
                d.getCity(),
                d.getCountry(),
                DateFormatter.DateToString(d.getDateCreation())
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

    public DeliveryDTO getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryDTO delivery) {
        this.delivery = delivery;
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
