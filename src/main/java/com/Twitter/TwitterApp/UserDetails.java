package com.Twitter.TwitterApp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserDetails {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String street;
    @Column
    private int number;

    public UserDetails(String street, int number) {
        this.street = street;
        this.number = number;
    }

    public UserDetails() {
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}