package com.ygorftf.apicostumers.services;

import com.ygorftf.apicostumers.dto.CostumerDTO;
import com.ygorftf.apicostumers.entities.Costumer;
import com.ygorftf.apicostumers.repositories.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CostumerService {

    @Autowired
    private CostumerRepository repository;

    @Transactional(readOnly = true)
    public CostumerDTO findCostumerById(Long id) {
        Optional<Costumer> costumer = repository.findById(id);
        return new CostumerDTO(costumer);
    }

}
