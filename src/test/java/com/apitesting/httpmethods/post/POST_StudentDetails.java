package com.apitesting.httpmethods.post;

import com.apitesting.constants.endpoints.EndPoint;
import com.apitesting.extentreports.ExtentLogger;
import com.apitesting.extentreports.loggers.LogType;
import com.apitesting.pojo.Payload;
import com.apitesting.request_response_specification.RequestResponseSpecification;
import com.apitesting.utils.commons.logging.LogResponse;
import com.apitesting.utils.commons.request_response_verification.VerifyResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class POST_StudentDetails {
    @Test(testName = "Add students",description = "Verify all student with status code 201",enabled = false)
    public void addStudents(){

        Response response= RestAssured.given()
                .spec(RequestResponseSpecification.requestBuilder())
                .when()
                .body(Payload.setValues())
                .post(EndPoint.ADD_USER)
                .then()
                .spec(RequestResponseSpecification.responseBuilder())
                .extract()
                .response();

        LogResponse.logHeaders(response);
        LogResponse.logBody(response);
        VerifyResponse.verifyStatusCode(response,201);
        VerifyResponse.verifyJsonKey(response,"address.street");
    }
}
