package com.ygorftf.apicostumers.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "tb_costumers")
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "costumer")
    private List<Address> addresses = new ArrayList<>();
    @OneToMany(mappedBy = "costumer")
    private List<Phone> phoneNumbers = new ArrayList<>();

    public Costumer() {}

    public Costumer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }
}
