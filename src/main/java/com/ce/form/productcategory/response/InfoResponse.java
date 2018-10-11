package com.ce.form.productcategory.response;

import com.ce.model.ProductCategory;
import com.ce.dto.ProductCategoryDTO;
import com.ce.utils.DateFormatter;
import org.springframework.http.HttpStatus;


public class InfoResponse {

    private ProductCategoryDTO productCategory;

    private HttpStatus status;
    private String message;

    private final String CREATE_FIELDS_MISSING = "All the fields must be filled.";
    private final String CATEGORY_NOT_FOUND = "The product category couldn't be found.";
    private final String CATEGORY_FAILED = "The product category couldn't be fetched.";
    private static final String INFO_OK = "OK";

    public InfoResponse() {
    }

    public InfoResponse ok(ProductCategory p) {
        this.productCategory = new ProductCategoryDTO(
                p.getIdProductCategory(),
                p.getIdParent(),
                p.getName(),
                p.getCompleteName(),
                p.getIdParent(),
                p.getCreateUID(),
                DateFormatter.DateToString(p.getDateCreated()),
                p.getWriteUID(),
                DateFormatter.DateToString(p.getDateWrite()),
                p.getIdRemovalStrategy()

        );

        message = INFO_OK;
        status = HttpStatus.OK;
        return this;
    }

    public InfoResponse notFound() {
        status = HttpStatus.NOT_FOUND;
        message = CATEGORY_NOT_FOUND;
        return this;
    }

    public InfoResponse failed() {
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        message = CATEGORY_FAILED;
        return this;
    }

    public InfoResponse fieldsMissing() {
        status = HttpStatus.BAD_REQUEST;
        message = CREATE_FIELDS_MISSING;
        return this;
    }

    public ProductCategoryDTO getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategoryDTO productCategory) {
        this.productCategory = productCategory;
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
