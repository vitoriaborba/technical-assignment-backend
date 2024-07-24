package com.example.brewery_backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Brewery {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("brewery_type")
    private String breweryType;

    @JsonProperty("address_1")
    private String address1;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state_province")
    private String stateProvince;

    @JsonProperty("postal_code")
    private String postalCode;

    @JsonProperty("country")
    private String country;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("website_url")
    private String websiteUrl;

    @JsonProperty("state")
    private String state;


    // Default constructor
    public Brewery() {}

}