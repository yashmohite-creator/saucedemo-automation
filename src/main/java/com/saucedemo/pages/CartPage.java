package com.saucedemo.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    private By firstNameField =
            By.id("first-name");

    public CartPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );
    }

    public String getBackpackName() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        backpackItem
                )
        ).getText();
    }

    public void clickCheckout() {

        WebElement checkout =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                checkoutButton
                        )
                );

        try {

            checkout.click();

        } catch (Exception e) {

            JavascriptExecutor js =
                    (JavascriptExecutor) driver;

            js.executeScript(
                    "arguments[0].click();",
                    checkout
            );
        }

        try {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            firstNameField
                    )
            );

        } catch (Exception e) {

            JavascriptExecutor js =
                    (JavascriptExecutor) driver;

            WebElement checkoutAgain =
                    driver.findElement(checkoutButton);

            js.executeScript(
                    "arguments[0].click();",
                    checkoutAgain
            );

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            firstNameField
                    )
            );
        }
    }

    public void removeBackpack() {

        WebElement removeButton =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                removeBackpackButton
                        )
                );

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                removeButton
        );
    }

    public boolean isBackpackDisplayed() {

        List<WebElement> items =
                driver.findElements(backpackItem);

        for (WebElement item : items) {

            if (item.isDisplayed()) {
                return true;
            }
        }

        return false;
    }
}