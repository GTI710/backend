package com.ce.form.product.response;

import com.ce.dto.ProductTemplateDTO;
import com.ce.model.ProductTemplate;
import com.ce.utils.DateFormatter;
import org.springframework.http.HttpStatus;


public class InfoResponse {

    private ProductTemplateDTO product;

    private HttpStatus status;
    private String message;

    private final String CREATE_FIELDS_MISSING = "All the fields must be filled.";
    private final String PRODUCT_NOT_FOUND = "The product couldn't be found.";
    private final String PRODUCT_FAILED = "The product couldn't be fetched.";
    private static final String INFO_OK = "OK";

    public InfoResponse() {
    }

    public InfoResponse ok(ProductTemplate p) {
        this.product = new ProductTemplateDTO(
                p.getIdProductTemplate(),
                p.getName(),
                p.getSequence(),
                p.getDescription(),
                p.getDescriptionPurchase(),
                p.getDescriptionSale(),
                p.getType(),
                p.getRental(),
                p.getIdCategory(),
                p.getListPrice(),
                p.getVolume(),
                p.getWeight(),
                p.getSaleOk(),
                p.getPurchaseOk(),
                p.getActive(),
                DateFormatter.DateToString(p.getDateCreated()),
                DateFormatter.DateToString(p.getDateWrite()),
                p.getRatingLastValue(),
                p.getWebsiteMetaOgImg(),
                p.getPublished(),
                p.getInventoryAvailability(),
                p.getAvailableThreshold()

        );

        message = INFO_OK;
        status = HttpStatus.OK;
        return this;
    }

    public InfoResponse notFound() {
        status = HttpStatus.NOT_FOUND;
        message = PRODUCT_NOT_FOUND;
        return this;
    }

    public InfoResponse failed() {
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        message = PRODUCT_FAILED;
        return this;
    }

    public InfoResponse fieldsMissing() {
        status = HttpStatus.BAD_REQUEST;
        message = CREATE_FIELDS_MISSING;
        return this;
    }

    public ProductTemplateDTO getProduct() {
        return product;
    }

    public void setProduct(ProductTemplateDTO product) {
        this.product = product;
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
