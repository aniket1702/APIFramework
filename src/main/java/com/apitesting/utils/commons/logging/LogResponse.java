package com.apitesting.utils.commons.logging;

import com.apitesting.extentreports.ExtentLogger;
import com.apitesting.extentreports.loggers.LogType;
import io.restassured.response.Response;

public  final class LogResponse {
    private LogResponse(){

    }

    public static void logHeaders(Response response)
    {
        ExtentLogger.log(LogType.INFO,"<b>HEADERS</b>:: </br><pre>"+response.getHeaders()+"</pre>");
        ExtentLogger.log(LogType.INFO,"<b>STATUS</b>:: </b>"+response.getStatusLine());
    }

    public static void logBody(Response response)
    {
        ExtentLogger.log(LogType.PASS, "<b>RESPONSE BODY::</b></br>" +
                             "<div width='100%' " +
                                    "style='overflow-y:auto; " +
                                    "overflow-x: hidden; " +
                                    "height:400px; border:1px solid black; " +
                                    "padding:10px'>" +
                                    "<pre>"+response.asPrettyString()+"</pre>" +
                             "</div>"
                        );
    }
}
