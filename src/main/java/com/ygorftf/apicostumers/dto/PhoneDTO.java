package com.ygorftf.apicostumers.dto;

import com.ygorftf.apicostumers.entities.Phone;

public class PhoneDTO {

    private String phoneNumber;

    public PhoneDTO(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneDTO(Phone phone) {
        phoneNumber = phone.getPhoneNumber();
    }
    public String getPhoneNumbers() {
        return phoneNumber ;
    }
}
