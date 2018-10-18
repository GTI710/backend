package com.ce.repository;

import com.ce.model.RatingTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RatingRepository extends JpaRepository<RatingTable, Integer> {

    List<RatingTable> findAllByIdProductTemplate(Integer idProductTemplate);
}
