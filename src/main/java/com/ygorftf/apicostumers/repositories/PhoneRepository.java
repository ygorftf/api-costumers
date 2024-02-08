package com.ygorftf.apicostumers.repositories;

import com.ygorftf.apicostumers.entities.Address;
import com.ygorftf.apicostumers.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,Long> {

}
