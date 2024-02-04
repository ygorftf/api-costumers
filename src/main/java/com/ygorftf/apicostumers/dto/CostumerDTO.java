package com.ygorftf.apicostumers.dto;

import com.ygorftf.apicostumers.entities.Costumer;

import java.util.Optional;

public class CostumerDTO {
    private Long id;
    private String name;

    public CostumerDTO() {
    }

    public CostumerDTO(Optional<Costumer> costumer) {
        id = costumer.get().getId();
        name = costumer.get().getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
