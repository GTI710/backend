package com.ce.form.productcategory.response;

import com.ce.dto.ProductCategoryDTO;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ListResponse {

    private List<ProductCategoryDTO> productCategories;
    private HttpStatus status;

    public ListResponse() {
    }

    public ListResponse ok(List<ProductCategoryDTO> categories) {
        status = HttpStatus.OK;
        this.productCategories = categories;
        return this;
    }

    public ListResponse failed() {
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        productCategories = null;
        return this;
    }

    public List<ProductCategoryDTO> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategoryDTO> productCategories) {
        this.productCategories = productCategories;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
