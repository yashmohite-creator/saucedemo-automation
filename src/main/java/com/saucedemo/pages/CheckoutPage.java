package com.saucedemo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private WebDriver driver;

    private WebDriverWait wait;

    private By firstNameField =
            By.id("first-name");

    private By lastNameField =
            By.id("last-name");

    private By postalCodeField =
            By.id("postal-code");

    private By continueButton =
            By.id("continue");

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );
    }

    public void enterFirstName(String firstName) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        firstNameField
                )
        ).clear();

        driver.findElement(firstNameField)
                .sendKeys(firstName);
    }

    public void enterLastName(String lastName) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        lastNameField
                )
        ).clear();

        driver.findElement(lastNameField)
                .sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        postalCodeField
                )
        ).clear();

        driver.findElement(postalCodeField)
                .sendKeys(postalCode);
    }

    public void clickContinue() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        continueButton
                )
        ).click();
    }

    public void enterCheckoutInformation(
            String firstName,
            String lastName,
            String postalCode) {

        enterFirstName(firstName);

        enterLastName(lastName);

        enterPostalCode(postalCode);

        clickContinue();
    }
}