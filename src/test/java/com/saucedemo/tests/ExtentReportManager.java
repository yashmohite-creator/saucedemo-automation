package com.saucedemo.tests;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            String reportPath =
                    System.getProperty("user.dir")
                    + File.separator
                    + "reports"
                    + File.separator
                    + "ExtentReport.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName(
                    "SauceDemo Automation Test Report"
            );

            sparkReporter.config().setDocumentTitle(
                    "SauceDemo Test Results"
            );

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo(
                    "Project",
                    "SauceDemo E-Commerce Automation"
            );

            extent.setSystemInfo(
                    "Tester",
                    "Yash"
            );

            extent.setSystemInfo(
                    "Environment",
                    "Windows"
            );

            extent.setSystemInfo(
                    "Browser",
                    "Chrome"
            );
        }

        return extent;
    }
}