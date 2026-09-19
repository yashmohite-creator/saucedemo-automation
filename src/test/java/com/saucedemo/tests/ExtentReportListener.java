package com.saucedemo.tests;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent =
            ExtentReportManager.getReportInstance();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        String testName =
                result.getMethod().getMethodName();

        String className =
                result.getTestClass().getName();

        ExtentTest extentTest =
                extent.createTest(testName);

        extentTest.assignCategory(className);

        test.set(extentTest);

        test.get().log(
                Status.INFO,
                "Test execution started"
        );

        test.get().log(
                Status.INFO,
                "Test Class: " + className
        );

        test.get().log(
                Status.INFO,
                "Test Method: " + testName
        );

        test.get().log(
                Status.INFO,
                "Browser: Chrome"
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().log(
                Status.PASS,
                "Test passed successfully"
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().log(
                Status.FAIL,
                "Test failed"
        );

        if (result.getThrowable() != null) {

            test.get().log(
                    Status.FAIL,
                    result.getThrowable()
            );
        }

        Object currentClass =
                result.getInstance();

        if (currentClass instanceof BaseTest) {

            BaseTest baseTest =
                    (BaseTest) currentClass;

            if (baseTest.driver != null) {

                try {

                    String screenshotPath =
                            baseTest.takeScreenshotForReport(
                                    result.getMethod()
                                            .getMethodName()
                            );

                    test.get().addScreenCaptureFromPath(
                            screenshotPath
                    );

                } catch (IOException e) {

                    test.get().log(
                            Status.WARNING,
                            "Could not attach screenshot: "
                                    + e.getMessage()
                    );
                }
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().log(
                Status.SKIP,
                "Test skipped"
        );
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        test.remove();
    }
}