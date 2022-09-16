package com.apitesting.httpmethods.get;

import com.apitesting.constants.endpoints.EndPoint;
import com.apitesting.extentreports.ExtentLogger;
import com.apitesting.extentreports.loggers.LogType;
import com.apitesting.request_response_specification.RequestResponseSpecification;
import com.apitesting.utils.commons.logging.LogResponse;
import com.apitesting.utils.commons.request_response_verification.VerifyResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GET_StudentDetails {

    @Test(testName = "Get All Users/Students",description = "Verify all student with status code 200")
    public void getStudents(){

        Response response= RestAssured.given()
                .spec(RequestResponseSpecification.requestBuilder())
                .queryParam("address.street","Kulas Light")
                .when()
                .get(EndPoint.GET_USER)
                .then()
                .spec(RequestResponseSpecification.responseBuilder())
                .extract()
                .response();

        LogResponse.logHeaders(response);
        LogResponse.logBody(response);
        VerifyResponse.verifyStatusCode(response,200);
        VerifyResponse.verifyJsonKey(response,"address");
    }
}
