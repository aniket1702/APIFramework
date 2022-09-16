package com.apitesting.extentreports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public final class ExtentReportManager {
    private ExtentReportManager() {

    }

    private static final ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return extTest.get();
    }

    static void setExtentTest(ExtentTest extentTest) {
        if (Objects.nonNull(extentTest)) {
            extTest.set(extentTest);
        }

    }

    static void unload() {
        extTest.remove();

    }
}
