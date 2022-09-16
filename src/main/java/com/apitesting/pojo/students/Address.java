package com.apitesting.pojo.students;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    @JsonProperty("street")
    private String street;
    @JsonProperty("suite")
    private String suite;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zipcode")
    private String zipcode;
    @JsonProperty("geo")
    private Geo geo;

}
