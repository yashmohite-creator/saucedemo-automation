package com.saucedemo.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
    }

    // Reusable screenshot method
    public void takeScreenshot(String screenshotName) {

        try {

            // Give the browser a short time to finish rendering
            Thread.sleep(1500);

            TakesScreenshot screenshot =
                    (TakesScreenshot) driver;

            File sourceFile =
                    screenshot.getScreenshotAs(
                            OutputType.FILE
                    );

            String timestamp =
                    new SimpleDateFormat(
                            "yyyyMMdd_HHmmss_SSS"
                    ).format(new Date());

            Path screenshotDirectory =
                    Paths.get("screenshots");

            Files.createDirectories(
                    screenshotDirectory
            );

            Path destination =
                    screenshotDirectory.resolve(
                            screenshotName
                                    + "_"
                                    + timestamp
                                    + ".png"
                    );

            Files.copy(
                    sourceFile.toPath(),
                    destination
            );

            System.out.println(
                    "Screenshot saved: "
                            + destination.toAbsolutePath()
            );

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    // Screenshot method for ExtentReports
    public String takeScreenshotForReport(
            String screenshotName)
            throws IOException {

        TakesScreenshot screenshot =
                (TakesScreenshot) driver;

        File sourceFile =
                screenshot.getScreenshotAs(
                        OutputType.FILE
                );

        String timestamp =
                new SimpleDateFormat(
                        "yyyyMMdd_HHmmss_SSS"
                ).format(new Date());

        Path screenshotDirectory =
                Paths.get("screenshots");

        Files.createDirectories(
                screenshotDirectory
        );

        Path destination =
                screenshotDirectory.resolve(
                        screenshotName
                                + "_failure_"
                                + timestamp
                                + ".png"
                );

        Files.copy(
                sourceFile.toPath(),
                destination
        );

        System.out.println(
                "Failure screenshot saved: "
                        + destination.toAbsolutePath()
        );

        return destination.toAbsolutePath().toString();
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}