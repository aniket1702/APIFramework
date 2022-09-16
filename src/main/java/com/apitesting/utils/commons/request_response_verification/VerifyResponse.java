package com.apitesting.utils.commons.request_response_verification;

import com.apitesting.extentreports.ExtentLogger;
import com.apitesting.extentreports.loggers.LogType;
import io.restassured.response.Response;
import org.testng.Assert;

public final class VerifyResponse
{
    private VerifyResponse(){

    }


    public static void verifyStatusCode(Response response,int expectedStatusCode)
    {
        int actualStatusCode=response.getStatusCode();
        if(response.getBody()!=null){

            try{
                Assert.assertEquals(actualStatusCode,expectedStatusCode);
                if(actualStatusCode==expectedStatusCode)
                {
                    ExtentLogger.log(LogType.PASS,"ACTUAL STATUS CODE:: "+actualStatusCode+"</br>EXPECTED STATUS CODE:: "+expectedStatusCode);
                }
                else{
                    ExtentLogger.log(LogType.FAIL,"ACTUAL STATUS CODE:: "+actualStatusCode+"</br>EXPECTED STATUS CODE:: "+expectedStatusCode);
                }
            }
            catch (AssertionError | Exception error)
            {
                ExtentLogger.log(LogType.FAIL,error.fillInStackTrace().toString());
            }
        }
    }

    public static void verifyJsonKey(Response response,String keyParam)
    {
        if(response.getBody()!=null){

            try
            {
               ExtentLogger.log(LogType.PASS, keyParam+"::<div width='100%' style='overflow-y:auto; overflow-x: hidden; height:auto; border:1px solid black; padding:10px'><pre>"+response.jsonPath().get(keyParam)+"</pre></div>");
            }
            catch (AssertionError | Exception error)
            {
                ExtentLogger.log(LogType.FAIL,error.fillInStackTrace().toString());
            }
        }
        else{
            ExtentLogger.log(LogType.FAIL,keyParam+" is not present");
        }
    }



}