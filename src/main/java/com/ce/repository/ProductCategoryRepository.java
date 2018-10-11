package com.ce.repository;

import com.ce.model.ProductCategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    ProductCategory findByIdProductCategory(Integer idProductCategory);

    List<ProductCategory> findAll();

}
