package com.ce.repository;

import com.ce.model.DeliveryTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryTable, Integer> {

}
