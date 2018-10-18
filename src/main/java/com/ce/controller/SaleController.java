package com.ce.controller;

import com.ce.form.sale.request.CreateRequest;
import com.ce.form.sale.response.CreateResponse;
import com.ce.form.sale.response.InfoResponse;
import com.ce.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("SaleController")
@RequestMapping("/api/sale")
public class SaleController {

    @Autowired
    SaleService saleService;

    /**
     * Create a new sale
     * @param newSale
     * @return CreateResponse
     */
    @PostMapping("")
    public ResponseEntity<?> createSale(@Valid @RequestBody CreateRequest newSale) {

        CreateResponse createResponse = saleService.create(newSale);
        return ResponseEntity.status(createResponse.getStatus()).body(createResponse);
    }

    /**
     * Fetch a sale via its idSaleTable
     * @param idSaleTable
     * @return InfoResponse
     */
    @GetMapping("/{idSaleTable}")
    public ResponseEntity<?> findById(@PathVariable("idSaleTable") Integer idSaleTable) {

        InfoResponse infoResponse = saleService.getByID(idSaleTable);
        return ResponseEntity.status(infoResponse.getStatus()).body(infoResponse);
    }

}
