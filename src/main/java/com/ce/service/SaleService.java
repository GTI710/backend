package com.ce.service;

import com.ce.form.sale.request.CreateRequest;
import com.ce.form.sale.response.CreateResponse;
import com.ce.form.sale.response.InfoResponse;
import com.ce.form.validator.SaleValidator;
import com.ce.model.DeliveryTable;
import com.ce.model.SaleTable;
import com.ce.repository.DeliveryRepository;
import com.ce.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    /**
     * Fetch a sale by idSaleTable
     * @param idSaleTable
     * @return InfoResponse
     */
    public InfoResponse getByID(Integer idSaleTable) {

        // Fetch a sale by idSaleTable
        SaleTable sale = saleRepository.findOne(idSaleTable);

        // If the sale is not found
        if (sale == null) {
            return new InfoResponse().notFound();
        }

        return new InfoResponse().ok(sale);
    }

    /**
     * Create a sale
     * @param request
     * @return CreateResponse
     */
    @Transactional
    public CreateResponse create(CreateRequest request) {

        // If the inputs are empty
        if (!SaleValidator.isCreateRequestComplete(request)) {
            return new CreateResponse().fieldsMissing();
        }

        SaleTable newSale;
        DeliveryTable newDelivery;

        Random rand = new Random();

        int n = rand.nextInt(9999999) + 1000000;

        try {

            // Create the sale
            newSale = new SaleTable(
                    null,
                    "SO" + n,
                    request.getAmount(),
                    request.getNameClient(),
                    "CAD",
                    new Date()
            );

            // Save the changes
            SaleTable created = saleRepository.save(newSale);

            // Create the sale
            newDelivery = new DeliveryTable(
                    null,
                    created.getIdSaleTable(),
                    request.getStreet(),
                    request.getZipcode(),
                    request.getCity(),
                    request.getCountry(),
                    new Date()
            );

            // Save the changes
            DeliveryTable createdDelivery = deliveryRepository.save(newDelivery);

        } catch (NullPointerException npe) {
            return new CreateResponse().failed();
        }

        return new CreateResponse().ok(newSale);
    }
}
