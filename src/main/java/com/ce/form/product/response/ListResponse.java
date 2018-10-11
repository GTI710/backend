package com.ce.form.product.response;

import com.ce.dto.ProductTemplateDTO;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ListResponse {

    private List<ProductTemplateDTO> products;
    private HttpStatus status;

    public ListResponse() {
    }

    public ListResponse ok(List<ProductTemplateDTO> products) {
        status = HttpStatus.OK;
        this.products = products;
        return this;
    }

    public ListResponse failed() {
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        products = null;
        return this;
    }

    public List<ProductTemplateDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductTemplateDTO> products) {
        this.products = products;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
