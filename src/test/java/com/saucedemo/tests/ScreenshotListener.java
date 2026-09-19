package com.saucedemo.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Object currentClass = result.getInstance();

        if (currentClass instanceof BaseTest) {

            BaseTest baseTest =
                    (BaseTest) currentClass;

            if (baseTest.driver != null) {

                TakesScreenshot screenshot =
                        (TakesScreenshot) baseTest.driver;

                File sourceFile =
                        screenshot.getScreenshotAs(
                                OutputType.FILE
                        );

                Path screenshotDirectory =
                        Paths.get("screenshots");

                try {

                    Files.createDirectories(
                            screenshotDirectory
                    );

                    String testName =
                            result.getMethod()
                                   .getMethodName();

                    Path destination =
                            screenshotDirectory.resolve(
                                    testName + ".png"
                            );

                    Files.copy(
                            sourceFile.toPath(),
                            destination,
                            java.nio.file.StandardCopyOption
                                    .REPLACE_EXISTING
                    );

                    System.out.println(
                            "Failure screenshot saved: "
                            + destination.toAbsolutePath()
                    );

                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }
    }
}