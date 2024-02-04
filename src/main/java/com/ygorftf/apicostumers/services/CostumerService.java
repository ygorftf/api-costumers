package com.ygorftf.apicostumers.services;

import com.ygorftf.apicostumers.repositories.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostumerService {

    @Autowired
    private CostumerRepository repository;

}
