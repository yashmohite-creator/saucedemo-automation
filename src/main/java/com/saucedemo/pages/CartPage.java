package com.saucedemo.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;

    private WebDriverWait wait;

    private By backpackItem =
            By.id("item_4_title_link");

    private By checkoutButton =
            By.id("checkout");

    private By removeBackpackButton =
            By.id("remove-sauce-labs-backpack");

    public CartPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );
    }

    public String getBackpackName() {

        return wait.until(driver -> {

            try {

                WebElement element =
                        driver.findElement(backpackItem);

                if (element.isDisplayed()) {
                    return element.getText();
                }

            } catch (StaleElementReferenceException e) {

                return null;
            }

            return null;
        });
    }

    public void clickCheckout() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        checkoutButton
                )
        );

        WebElement checkoutButtonElement =
                driver.findElement(checkoutButton);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                checkoutButtonElement
        );

        wait.until(
                ExpectedConditions.urlContains(
                        "checkout-step-one.html"
                )
        );
    }

    public void removeBackpack() {

        WebElement removeButton =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                removeBackpackButton
                        )
                );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                removeButton
        );
    }

    public boolean isBackpackDisplayed() {

        List<WebElement> items =
                driver.findElements(backpackItem);

        for (WebElement item : items) {

            try {

                if (item.isDisplayed()) {
                    return true;
                }

            } catch (StaleElementReferenceException e) {
                // Continue checking
            }
        }

        return false;
    }
}