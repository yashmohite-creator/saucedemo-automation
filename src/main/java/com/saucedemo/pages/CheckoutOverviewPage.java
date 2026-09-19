package com.saucedemo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverviewPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By pageTitle = By.className("title");
    private By finishButton = By.id("finish");

    private By confirmationMessage =
            By.className("complete-header");

    public CheckoutOverviewPage(WebDriver driver) {

        this.driver = driver;

        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(20)
                );
    }

    public String getPageTitle() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        pageTitle
                )
        ).getText();
    }

    public void clickFinish() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        finishButton
                )
        ).click();
    }

    public String getConfirmationMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        confirmationMessage
                )
        ).getText();
    }
}