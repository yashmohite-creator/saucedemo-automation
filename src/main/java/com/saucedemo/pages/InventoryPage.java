package com.saucedemo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By productsTitle =
            By.className("title");

    private By addBackpackButton =
            By.id("add-to-cart-sauce-labs-backpack");

    private By shoppingCart =
            By.className("shopping_cart_link");

    // Product sorting dropdown
    private By sortDropdown =
            By.className("product_sort_container");

    public InventoryPage(WebDriver driver) {

        this.driver = driver;

        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10)
                );
    }

    public String getProductsTitle() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        productsTitle
                )
        ).getText();
    }

    public void addBackpackToCart() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        addBackpackButton
                )
        ).click();
    }

    public void clickShoppingCart() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        shoppingCart
                )
        ).click();
    }

    // Sort products by price: low to high
    public void sortByPriceLowToHigh() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        sortDropdown
                )
        ).click();

        driver.findElement(
                By.cssSelector(
                        ".product_sort_container option[value='lohi']"
                )
        ).click();
    }
}