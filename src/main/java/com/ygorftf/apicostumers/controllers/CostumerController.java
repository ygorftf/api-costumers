package com.ygorftf.apicostumers.controllers;

import com.ygorftf.apicostumers.dto.CostumerAddressPhoneDTO;
import com.ygorftf.apicostumers.services.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/costumers")
public class CostumerController {
    @Autowired
    private CostumerService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CostumerAddressPhoneDTO> findCostumerById(@PathVariable Long id){
        CostumerAddressPhoneDTO dto = service.findCostumerById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<CostumerAddressPhoneDTO>> findAllCostumers(
            @RequestParam(name = "name", defaultValue = "") String name, Pageable pageable){
        Page<CostumerAddressPhoneDTO> page = service.findAllCostumers(pageable, name);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public ResponseEntity<CostumerAddressPhoneDTO> insertCostumer(@RequestBody CostumerAddressPhoneDTO dto){
        dto = service.insertCostumer(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CostumerAddressPhoneDTO> updateCostumer(@PathVariable Long id, @RequestBody CostumerAddressPhoneDTO dto){
        dto = service.updateCostumer(id, dto);
        return ResponseEntity.ok(dto);
    }
}
