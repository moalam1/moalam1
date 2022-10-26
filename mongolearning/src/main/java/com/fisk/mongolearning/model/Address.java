package com.fisk.mongolearning.model;

public class Address {

    private String country;
    private String city;
    private int postcode;

    public Address(String country, String city, int postcode) {
        this.country = country;
        this.city = city;
        this.postcode = postcode;
    }
}
