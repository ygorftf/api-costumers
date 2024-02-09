package com.ygorftf.apicostumers.dto;

import com.ygorftf.apicostumers.entities.Address;
import com.ygorftf.apicostumers.entities.Costumer;
import com.ygorftf.apicostumers.entities.Phone;

import java.util.*;
import java.util.stream.Collectors;

public class CostumerAddressPhoneDTO {
    private Long id;
    private String name;

    private List<AddressDTO> addresses = new ArrayList<>();

    private List<PhoneDTO> phoneNumbers = new ArrayList<>();

    public CostumerAddressPhoneDTO() {
    }

    public CostumerAddressPhoneDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CostumerAddressPhoneDTO(Optional<Costumer> costumer) {
        id = costumer.get().getId();
        name = costumer.get().getName();
        for (Address ad : costumer.get().getAddresses()){
            addresses.add(new AddressDTO(ad));
        }
        for (Phone ph : costumer.get().getPhoneNumbers()){
            phoneNumbers.add(new PhoneDTO(ph));
        }
    }

    public CostumerAddressPhoneDTO(Costumer costumer) {
        id = costumer.getId();
        name = costumer.getName();
        for (Address ad : costumer.getAddresses()){
            addresses.add(new AddressDTO(ad));
        }
        for (Phone ph : costumer.getPhoneNumbers()){
            phoneNumbers.add(new PhoneDTO(ph));
        }
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
