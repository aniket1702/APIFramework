package com.apitesting.httpmethods.delete;

import com.apitesting.constants.endpoints.EndPoint;
import com.apitesting.pojo.Payload;
import com.apitesting.pojo.students.Student;
import com.apitesting.request_response_specification.RequestResponseSpecification;
import com.apitesting.utils.commons.logging.LogResponse;
import com.apitesting.utils.commons.request_response_verification.VerifyResponse;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DELETE_StudentDetails {

    @Test(testName = "Delete Student Record",description = "Verify deleted student record with success status 200")
    public void deleteStudentRecords()
    {
        int id=new Faker().number().numberBetween(1,60);
        System.out.println(id);


        Response response= RestAssured
                .given()
                    .spec(RequestResponseSpecification.requestBuilder())
                    .queryParam("address.street","Hoeger Mall")
                .when()
                    .delete(EndPoint.DELETE_USER+id)
                .then()
                    .spec(RequestResponseSpecification.responseBuilder())
                    .extract()
                    .response();

        LogResponse.logHeaders(response);
        LogResponse.logBody(response);
        VerifyResponse.verifyStatusCode(response,200);
        VerifyResponse.verifyJsonKey(response, "id");

    }

}
