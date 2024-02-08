package com.ygorftf.apicostumers.controllers;

import com.ygorftf.apicostumers.dto.AddressDTO;
import com.ygorftf.apicostumers.dto.CostumerDTO;
import com.ygorftf.apicostumers.services.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<Page<CostumerDTO>> findAllCostumers(
            @RequestParam(name = "name", defaultValue = "") String name, Pageable pageable){
        Page<CostumerDTO> page = service.findAllCostumers(pageable, name);
        return ResponseEntity.ok(page);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CostumerDTO> updateCostumer(@PathVariable Long id, @RequestBody CostumerDTO dto){
        dto = service.updateCostumerById(id, dto);
        return ResponseEntity.ok(dto);
    }
}
