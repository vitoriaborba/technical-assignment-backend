package com.example.brewery_backend;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;

public class BrewerySearchRequest {

    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Name should only contain letters, numbers, and spaces")
    private String name;

    @Pattern(regexp = "^[a-zA-Z ]*$", message = "City should only contain letters and spaces")
    private String city;

    @Pattern(regexp = "^[a-zA-Z ]*$", message = "State should only contain letters and spaces")
    private String state;

    @JsonProperty("brewery_type")
    private String breweryType;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBreweryType() {
        return breweryType;
    }

    public void setBreweryType(String breweryType) {
        this.breweryType = breweryType;
    }
}
