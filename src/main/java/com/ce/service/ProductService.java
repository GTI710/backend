package com.ce.service;

import com.ce.dto.ProductTemplateDTO;
import com.ce.form.product.response.InfoResponse;
import com.ce.form.product.response.ListResponse;
import com.ce.model.ProductTemplate;
import com.ce.repository.ProductRepository;
import com.ce.utils.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Fetch a product by idProduct
     * @param idProduct
     * @return InfoResponse
     */
    public InfoResponse getByID(Integer idProduct) {

        // Fetch a product by idProduct
        ProductTemplate product = productRepository.findOne(idProduct);

        // If the product is not found
        if (product == null) {
            return new InfoResponse().notFound();
        }

        return new InfoResponse().ok(product);
    }

    /**
     * Fetch the categories
     * @return InfoResponse
     */
    public ListResponse getProducts() {

        // Fetch products
        List<ProductTemplate> products = productRepository.findAll();

        // Convert to DTO & sort by oldest to most recent
        List<ProductTemplateDTO> productDTOS = convertProductsToProductDTOs(products);
        productDTOS.sort(Comparator.comparing((ProductTemplateDTO arr) -> arr.getDateCreated()));

        return new ListResponse().ok(productDTOS);
    }

    private List<ProductTemplateDTO> convertProductsToProductDTOs(List<?> products) {
        List<ProductTemplateDTO> productDTOS = new ArrayList<>();

        for (ProductTemplate p : (List<ProductTemplate>) products) {
            productDTOS.add(new ProductTemplateDTO(
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
            ));
        }

        return productDTOS;
    }
}
