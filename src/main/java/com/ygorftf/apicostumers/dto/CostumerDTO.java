package com.ygorftf.apicostumers.dto;

import com.ygorftf.apicostumers.entities.Costumer;

public class CostumerDTO {
    private Long id;
    private String name;

    public CostumerDTO() {
    }

    public CostumerDTO(Costumer costumer) {
        id = costumer.getId();
        name = costumer.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
