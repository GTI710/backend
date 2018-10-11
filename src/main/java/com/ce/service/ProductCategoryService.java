package com.ce.service;

import com.ce.dto.ProductCategoryDTO;
import com.ce.form.productcategory.response.*;
import com.ce.form.productcategory.response.InfoResponse;
import com.ce.model.ProductCategory;
import com.ce.repository.ProductCategoryRepository;
import com.ce.utils.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    /**
     * Fetch a category by idProductCategory
     * @param idProductCategory
     * @return InfoResponse
     */
    public InfoResponse getByID(Integer idProductCategory) {

        // Fetch a category by idProductCategory
        ProductCategory productCategory = productCategoryRepository.findOne(idProductCategory);

        // If the category is not found
        if (productCategory == null) {
            return new InfoResponse().notFound();
        }

        return new InfoResponse().ok(productCategory);
    }

    /**
     * Fetch the categories
     * @return InfoResponse
     */
    public ListResponse getCategories() {

        // Fetch products
        List<ProductCategory> categories = productCategoryRepository.findAll();

        // Convert to DTO & sort by oldest to most recent
        List<ProductCategoryDTO> categoryDTOS = convertCategoriesToCategoryDTOs(categories);
        categoryDTOS.sort(Comparator.comparing((ProductCategoryDTO arr) -> arr.getDateCreated()));

        return new ListResponse().ok(categoryDTOS);
    }

    private List<ProductCategoryDTO> convertCategoriesToCategoryDTOs(List<?> categories) {
        List<ProductCategoryDTO> categoryDTOS = new ArrayList<>();

        for (ProductCategory category : (List<ProductCategory>) categories) {
            categoryDTOS.add(new ProductCategoryDTO(
                    category.getIdProductCategory(),
                    category.getParentPath(),
                    category.getName(),
                    category.getCompleteName(),
                    category.getIdParent(),
                    category.getCreateUID(),
                    DateFormatter.DateToString(category.getDateCreated()),
                    category.getWriteUID(),
                    DateFormatter.DateToString(category.getDateWrite()),
                    category.getIdRemovalStrategy()
            ));
        }

        return categoryDTOS;
    }
}
