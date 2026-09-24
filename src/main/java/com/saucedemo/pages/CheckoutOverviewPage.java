package com.saucedemo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverviewPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By pageTitle =
            By.className("title");

    private By finishButton =
            By.id("finish");

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

        WebElement button =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                finishButton
                        )
                );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                button
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        finishButton
                )
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                button
        );

        wait.until(
                ExpectedConditions.urlContains(
                        "checkout-complete.html"
                )
        );
    }

    public String getConfirmationMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        confirmationMessage
                )
        ).getText();
    }
}