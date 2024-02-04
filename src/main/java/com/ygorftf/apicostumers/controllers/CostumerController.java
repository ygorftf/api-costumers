package com.ygorftf.apicostumers.controllers;

import com.ygorftf.apicostumers.dto.CostumerDTO;
import com.ygorftf.apicostumers.services.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/costumers")
public class CostumerController {
    @Autowired
    private CostumerService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CostumerDTO> findCostumerById(@PathVariable Long id){
        CostumerDTO dto = service.findCostumerById(id);
        return ResponseEntity.ok(dto);
    }
}
