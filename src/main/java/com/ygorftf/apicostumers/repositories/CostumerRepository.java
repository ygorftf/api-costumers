package com.ygorftf.apicostumers.repositories;

import com.ygorftf.apicostumers.entities.Costumer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CostumerRepository extends JpaRepository<Costumer,Long> {

    @Query(value = "SELECT obj FROM Costumer obj WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))", countQuery = "SELECT COUNT(obj) FROM Costumer obj")
    Page<Costumer> findAllCostumers(Pageable pageable, String name);
}
