package com.ce.service;

import com.ce.dto.CommentDTO;
import com.ce.dto.ProductTemplateDTO;
import com.ce.form.product.response.InfoResponse;
import com.ce.form.product.response.ListResponse;
import com.ce.model.CommentTable;
import com.ce.model.ProductTemplate;
import com.ce.model.RatingTable;
import com.ce.repository.CommentRepository;
import com.ce.repository.ProductRepository;
import com.ce.repository.RatingRepository;
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

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private CommentRepository commentRepository;

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

        // Fetch product rating
        List<RatingTable> ratings = ratingRepository.findAllByIdProductTemplate(idProduct);

        Double averageRating = 0.0;
        Double sum = 0.0;
        for (RatingTable r : ratings) {
            sum += r.getScore();
        }
        if (sum != 0.0) {
            averageRating = sum/(double)ratings.size();
        }

        List<CommentTable> comments = commentRepository.findAllByIdProductTemplate(idProduct);
        List<CommentDTO> commentDTOS = convertCommentsToCommentDTOs(comments);

        return new InfoResponse().ok(product, averageRating, commentDTOS);
    }

    /**
     * Fetch the categories
     * @return InfoResponse
     */
    public ListResponse getProducts(Integer idCategory) {

        // Fetch products
        List<ProductTemplate> products = productRepository.findAllByIdCategory(idCategory);

        // Convert to DTO & sort by oldest to most recent
        List<ProductTemplateDTO> productDTOS = convertProductsToProductDTOs(products);
        productDTOS.sort(Comparator.comparing((ProductTemplateDTO arr) -> arr.getDateCreated()));

        return new ListResponse().ok(productDTOS);
    }

    private List<ProductTemplateDTO> convertProductsToProductDTOs(List<?> products) {
        List<ProductTemplateDTO> productDTOS = new ArrayList<>();

        for (ProductTemplate p : (List<ProductTemplate>) products) {

            // Fetch product rating
            List<RatingTable> ratings = ratingRepository.findAllByIdProductTemplate(p.getIdProductTemplate());

            Double averageRating = 0.0;
            Double sum = 0.0;
            for (RatingTable r : ratings) {
                sum += r.getScore();
            }
            if (sum != 0.0) {
                averageRating = sum/(double)ratings.size();
            }

            List<CommentTable> comments = commentRepository.findAllByIdProductTemplate(p.getIdProductTemplate());
            List<CommentDTO> commentDTOS = convertCommentsToCommentDTOs(comments);

            productDTOS.add(new ProductTemplateDTO(
                    p.getIdProductTemplate(),
                    averageRating,
                    commentDTOS,
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

    private List<CommentDTO> convertCommentsToCommentDTOs(List<?> comments) {
        List<CommentDTO> commentDTOs = new ArrayList<>();

        for (CommentTable c : (List<CommentTable>) comments) {
            commentDTOs.add(
                    new CommentDTO(
                            c.getIdCommentTable(),
                            c.getIdProductTemplate(),
                            c.getBody(),
                            DateFormatter.DateToString(c.getDateCreation())
                    )
            );
        }

        return commentDTOs;

    }
}
