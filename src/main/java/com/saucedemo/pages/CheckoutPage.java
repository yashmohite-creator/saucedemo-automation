package com.saucedemo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    private By checkoutForm =
            By.cssSelector("form");

    private By overviewTitle =
            By.className("title");

    private By errorMessage =
            By.cssSelector("[data-test='error']");

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;

        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(20)
                );
    }

    public void enterFirstName(String firstName) {

        WebElement field =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                firstNameField
                        )
                );

        field.clear();
        field.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {

        WebElement field =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                lastNameField
                        )
                );

        field.clear();
        field.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {

        WebElement field =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                postalCodeField
                        )
                );

        field.clear();
        field.sendKeys(postalCode);
    }

    public void clickContinue() {

        WebElement firstName =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                firstNameField
                        )
                );

        WebElement lastName =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                lastNameField
                        )
                );

        WebElement postalCode =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                postalCodeField
                        )
                );

        WebElement button =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                continueButton
                        )
                );

        // Verify all required fields contain data
        if (firstName.getAttribute("value").trim().isEmpty()) {

            throw new RuntimeException(
                    "First Name field is empty"
            );
        }

        if (lastName.getAttribute("value").trim().isEmpty()) {

            throw new RuntimeException(
                    "Last Name field is empty"
            );
        }

        if (postalCode.getAttribute("value").trim().isEmpty()) {

            throw new RuntimeException(
                    "Postal Code field is empty"
            );
        }

        // Scroll to Continue button
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                button
        );

        // Locate the checkout form
        WebElement form =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                checkoutForm
                        )
                );

        // Submit the actual HTML form
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].requestSubmit(arguments[1]);",
                form,
                button
        );

        // Wait for either Overview or validation error
        wait.until(
                ExpectedConditions.or(
                        ExpectedConditions.urlContains(
                                "checkout-step-two.html"
                        ),
                        ExpectedConditions.visibilityOfElementLocated(
                                errorMessage
                        )
                )
        );

        // Check for validation error
        if (driver.findElements(errorMessage).size() > 0) {

            WebElement error =
                    driver.findElement(errorMessage);

            if (error.isDisplayed()) {

                throw new RuntimeException(
                        "SauceDemo checkout validation error: "
                                + error.getText()
                );
            }
        }

        // Verify Overview page
        wait.until(
                ExpectedConditions.textToBe(
                        overviewTitle,
                        "Checkout: Overview"
                )
        );
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