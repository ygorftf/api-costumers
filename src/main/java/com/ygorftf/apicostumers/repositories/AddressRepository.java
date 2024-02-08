package com.ygorftf.apicostumers.repositories;

import com.ygorftf.apicostumers.entities.Address;
import com.ygorftf.apicostumers.entities.Costumer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address,Long> {

}
