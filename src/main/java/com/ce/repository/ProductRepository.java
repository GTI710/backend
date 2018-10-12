package com.ce.repository;

import com.ce.model.ProductTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductTemplate, Integer> {

    List<ProductTemplate> findAll();

    List<ProductTemplate> findAllByIdCategory(Integer idCategory);

}
