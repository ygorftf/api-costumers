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

    private List<PhoneDTO> phoneNumbers = new ArrayList<>();

    public CostumerDTO() {
    }

    public CostumerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CostumerDTO(Optional<Costumer> costumer) {
        id = costumer.get().getId();
        name = costumer.get().getName();
        addresses = costumer.get().getAddresses().stream().map(
                x -> new AddressDTO(x)).collect(Collectors.toList());
        phoneNumbers = costumer.get().getPhoneNumbers().stream().map(
                x -> new PhoneDTO(x)).collect(Collectors.toList());
    }

    public CostumerDTO(Costumer costumer) {
        id = costumer.getId();
        name = costumer.getName();
        addresses = costumer.getAddresses().stream().map(
                x -> new AddressDTO(x)).collect(Collectors.toList());
        phoneNumbers = costumer.getPhoneNumbers().stream().map(
                x -> new PhoneDTO(x)).collect(Collectors.toList());
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

    public List<PhoneDTO> getPhoneNumbers() {
        return phoneNumbers;
    }
}
