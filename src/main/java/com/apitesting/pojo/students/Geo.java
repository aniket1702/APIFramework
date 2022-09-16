package com.apitesting.pojo.students;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Geo {

    @JsonProperty("lat")
    private String lat;
    @JsonProperty("lng")
    private String lng;
}
