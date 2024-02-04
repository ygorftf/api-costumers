package com.ygorftf.apicostumers.repositories;

import com.ygorftf.apicostumers.entities.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Costumer,Long> {

}
