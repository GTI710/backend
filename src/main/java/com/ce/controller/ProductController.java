package com.ce.controller;

import com.ce.form.product.response.InfoResponse;
import com.ce.form.product.response.ListResponse;
import com.ce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ProductController")
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productTemplateService;

    /**
     * Fetch a product via its idProduct
     * @param idProduct
     * @return InfoResponse
     */
    @GetMapping("/{idProduct}")
    public ResponseEntity<?> findById(@PathVariable("idProduct") Integer idProduct) {

        InfoResponse infoResponse = productTemplateService.getByID(idProduct);
        return ResponseEntity.status(infoResponse.getStatus()).body(infoResponse);
    }

    /**
     * Get products
     * @param idProductCategory
     * @return ListResponse
     */
    @GetMapping("/findall/{idProductCategory}")
    public ResponseEntity<?> getProducts(@PathVariable("idProductCategory") Integer idProductCategory) {

        ListResponse listResponse = productTemplateService.getProducts(idProductCategory);
        return ResponseEntity.status(listResponse.getStatus()).body(listResponse);
    }

}
