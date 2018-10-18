package com.ce.repository;

import com.ce.model.SaleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SaleRepository extends JpaRepository<SaleTable, Integer> {

}
