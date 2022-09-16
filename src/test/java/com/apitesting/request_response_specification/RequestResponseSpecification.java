package com.apitesting.request_response_specification;

import com.apitesting.config.ConfigFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestResponseSpecification {
    protected RequestResponseSpecification(){

    }
    static RequestSpecification requestSpecification;
    static ResponseSpecification responseSpecification;


    @Before
    public static RequestSpecification requestBuilder() {

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(ConfigFactory.getConfig().baseURI())
                .setContentType(ContentType.JSON)
                .log(LogDetail.PARAMS)
                .log(LogDetail.URI)
                .log(LogDetail.HEADERS)
                .log(LogDetail.COOKIES);

        requestSpecification = requestSpecBuilder.build();

        return requestSpecification;
    }

    @After
    public static ResponseSpecification responseBuilder() {

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.BODY);

        responseSpecification = responseSpecBuilder.build();

        return responseSpecification;

    }

}
