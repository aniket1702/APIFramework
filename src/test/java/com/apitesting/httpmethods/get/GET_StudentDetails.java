package com.apitesting.httpmethods.get;

import com.apitesting.constants.endpoints.EndPoint;
import com.apitesting.request_response_specification.RequestResponseSpecification;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GET_StudentDetails {

    @Test(testName = "Get All Users/Students",description = "Verify all student with status code 200")
    public void getStudents(){

        Response response= RestAssured.given()
                .spec(RequestResponseSpecification.requestBuilder())
                .when()
                .get(EndPoint.GET_USER)
                .then()
                .spec(RequestResponseSpecification.responseBuilder())
                .extract()
                .response();

    }
}
