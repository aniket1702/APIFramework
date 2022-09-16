package com.apitesting.listeners;

import com.apitesting.extentreports.ExtentReport;
import com.apitesting.extentreports.loggers.LogType;
import org.testng.*;

import static com.apitesting.extentreports.ExtentLogger.log;

public class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {

        ExtentReport.initReport();

    }

    @Override
    public void onFinish(ISuite suite) {

        try {
            ExtentReport.flushReport();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getConstructorOrMethod().getMethod());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        log(LogType.PASS,result.getMethod().getMethodName()+" is Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log(LogType.FAIL,result.getMethod().getMethodName() + " is Failed.");
        log(LogType.FAIL,result.getThrowable().toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        log(LogType.SKIP,result.getMethod().getMethodName() + " is Skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }

    /**
     * Invoked each time a test fails due to a timeout.
     *
     * @param result <code>ITestResult</code> containing information about the run
     *               test
     */
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    /**
     * Invoked before running all the test methods belonging to the classes inside
     * the &lt;test&gt; tag and calling all their Configuration methods.
     *
     * @param context The test context
     */
    @Override
    public void onStart(ITestContext context) {
        // not implemented
    }

    /**
     * Invoked after all the test methods belonging to the classes inside the
     * &lt;test&gt; tag have run and all their Configuration methods have been
     * called.
     *
     * @param context The test context
     */
    @Override
    public void onFinish(ITestContext context) {
        // not implemented
    }
}
