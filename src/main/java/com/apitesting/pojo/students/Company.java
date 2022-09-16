package com.apitesting.pojo.students;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {

    @JsonProperty("name")
    private String name;
    @JsonProperty("catchPhrase")
    private String catchPhrase;
    @JsonProperty("bs")
    private String bs;
}
