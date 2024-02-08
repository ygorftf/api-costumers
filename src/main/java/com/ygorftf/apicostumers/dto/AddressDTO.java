package com.ygorftf.apicostumers.dto;

import com.ygorftf.apicostumers.entities.Address;

public class AddressDTO {

    private Long id;
    private String street;
    private String number;
    private String district;
    private String city;
    private String addressLink;

    public AddressDTO() {
    }

    public AddressDTO(Long id, String street, String number, String district, String city, String addressLink) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.district = district;
        this.city = city;
        this.addressLink = addressLink;
    }

    public AddressDTO(Address address) {
        id = address.getId();
        street = address.getStreet();
        number = address.getNumber();
        district = address.getDistrict();
        city = address.getCity();
        addressLink = address.getAddressLink();
    }


    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public String getAddressLink() {
        return addressLink;
    }
}
