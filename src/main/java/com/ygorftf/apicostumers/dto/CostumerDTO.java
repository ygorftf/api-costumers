package com.ygorftf.apicostumers.dto;

import com.ygorftf.apicostumers.entities.Address;
import com.ygorftf.apicostumers.entities.Costumer;
import com.ygorftf.apicostumers.entities.Phone;

import java.util.*;
import java.util.stream.Collectors;

public class CostumerDTO {
    private Long id;
    private String name;

    private List<AddressDTO> addresses = new ArrayList<>();

    public CostumerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CostumerDTO(Optional<Costumer> costumer) {
        id = costumer.get().getId();
        name = costumer.get().getName();
        addresses = costumer.get().getAddresses().stream().map(
                x -> new AddressDTO(x)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }
}
