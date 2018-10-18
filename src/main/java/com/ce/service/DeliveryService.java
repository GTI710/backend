package com.ce.service;

import com.ce.form.delivery.response.InfoResponse;
import com.ce.model.DeliveryTable;
import com.ce.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    /**
     * Fetch a sale by idSaleTable
     * @param idDeliveryTable
     * @return InfoResponse
     */
    public InfoResponse getByID(Integer idDeliveryTable) {

        // Fetch a delivery by idDeliveryTable
        DeliveryTable delivery = deliveryRepository.findOne(idDeliveryTable);

        // If the delivery is not found
        if (delivery == null) {
            return new InfoResponse().notFound();
        }

        return new InfoResponse().ok(delivery);
    }
}
