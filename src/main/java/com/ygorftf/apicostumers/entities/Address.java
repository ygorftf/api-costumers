package com.ygorftf.apicostumers.entities;

public class Address {

    private Long id;
    private String street;
    private String number;
    private String district;
    private String city;
    private String addressLink;

    public Address() {
    }

    public Address(Long id, String street, String number, String district, String city, String addressLink) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.district = district;
        this.city = city;
        this.addressLink = addressLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLink() {
        return addressLink;
    }

    public void setAddressLink(String addressLink) {
        this.addressLink = addressLink;
    }
}
