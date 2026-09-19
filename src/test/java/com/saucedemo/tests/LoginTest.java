package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        takeScreenshot("01_login_page");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );
        

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Login was not successful"
        );
        

        takeScreenshot("02_login_success");
    }
}