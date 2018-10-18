package com.ce.controller;

import com.ce.form.delivery.response.InfoResponse;
import com.ce.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("DeliveryController")
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    /**
     * Fetch a delivery via its idDeliveryTable
     * @param idDeliveryTable
     * @return InfoResponse
     */
    @GetMapping("/{idDeliveryTable}")
    public ResponseEntity<?> findById(@PathVariable("idDeliveryTable") Integer idDeliveryTable) {

        InfoResponse infoResponse = deliveryService.getByID(idDeliveryTable);
        return ResponseEntity.status(infoResponse.getStatus()).body(infoResponse);
    }

}
