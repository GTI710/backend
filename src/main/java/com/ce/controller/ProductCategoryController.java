package com.ce.controller;

import com.ce.form.productcategory.response.*;
import com.ce.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("ProductCategoryController")
@RequestMapping("/api/productcategory")
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    /**
     * Fetch a category via its idProductCategory
     * @param idProductCategory
     * @return InfoResponse
     */
    @GetMapping("/{idProductCategory}")
    public ResponseEntity<?> findById(@PathVariable("idProductCategory") Integer idProductCategory) {

        InfoResponse infoResponse = productCategoryService.getByID(idProductCategory);
        return ResponseEntity.status(infoResponse.getStatus()).body(infoResponse);
    }

    /**
     * Get categories
     * @return ListResponse
     */
    @GetMapping("")
    public ResponseEntity<?> getCategories() {

        ListResponse listResponse = productCategoryService.getCategories();
        return ResponseEntity.status(listResponse.getStatus()).body(listResponse);
    }

}
