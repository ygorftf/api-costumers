package com.ygorftf.apicostumers.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tb_costumers")
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "costumer")
    private Set<Address> addresses = new HashSet<>();
    @OneToMany(mappedBy = "costumer")
    private Set<Phone> phoneNumbers = new HashSet<>();

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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Set<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }
}
