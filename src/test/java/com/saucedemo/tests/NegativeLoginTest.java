package com.saucedemo.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.LoginPage;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void invalidPasswordTest() {

        takeScreenshot("04_invalid_login_page");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "wrong_password"
        );

        takeScreenshot("05_invalid_password_error");

        String errorMessage = driver.findElement(
                By.cssSelector("[data-test='error']")
        ).getText();

        Assert.assertTrue(
                errorMessage.contains(
                        "Username and password do not match"
                ),
                "Expected invalid login error was not displayed"
        );
    }

    @Test
    public void lockedOutUserTest() {

        takeScreenshot("06_locked_user_login_page");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "locked_out_user",
                "secret_sauce"
        );

        takeScreenshot("07_locked_user_error");

        String errorMessage = driver.findElement(
                By.cssSelector("[data-test='error']")
        ).getText();

        Assert.assertTrue(
                errorMessage.contains("locked out"),
                "Expected locked-out user error was not displayed"
        );
    }

    @Test
    public void emptyLoginFieldsTest() {

        takeScreenshot("08_empty_login_page");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "",
                ""
        );

        takeScreenshot("09_empty_fields_error");

        String errorMessage = driver.findElement(
                By.cssSelector("[data-test='error']")
        ).getText();

        Assert.assertTrue(
                errorMessage.contains("Username is required"),
                "Expected username required error was not displayed"
        );
    }
}