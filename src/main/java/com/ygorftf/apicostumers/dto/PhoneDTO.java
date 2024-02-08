package com.ygorftf.apicostumers.dto;

import com.ygorftf.apicostumers.entities.Phone;

public class PhoneDTO {

    private Long id;
    private String phoneNumber;

    public PhoneDTO(Long id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public PhoneDTO(Phone phone) {
        id = phone.getId();
        phoneNumber = phone.getPhoneNumber();
    }

    public Long getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber ;
    }
}
