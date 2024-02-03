package com.ygorftf.apicostumers.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_phone_numbers")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;

    public Phone() {
    }

    public Phone(Long id, String phoneNumber, Costumer costumer) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.costumer = costumer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }
}
