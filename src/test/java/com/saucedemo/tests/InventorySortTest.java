package com.saucedemo.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;

public class InventorySortTest extends BaseTest {

    @Test
    public void verifyPriceLowToHighSorting() {

        // Login
        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        // Create InventoryPage object
        InventoryPage inventoryPage =
                new InventoryPage(driver);

        // Screenshot before sorting
        takeScreenshot(
                "sort_01_products_before_sorting"
        );

        // Sort products by Price: Low to High
        inventoryPage.sortByPriceLowToHigh();

        // Screenshot after sorting
        takeScreenshot(
                "sort_02_products_low_to_high"
        );

        // Get all product prices
        List<WebElement> priceElements =
                driver.findElements(
                        By.className("inventory_item_price")
                );

        List<Double> actualPrices =
                new ArrayList<>();

        for (WebElement priceElement : priceElements) {

            String priceText =
                    priceElement.getText();

            double price =
                    Double.parseDouble(
                            priceText.replace("$", "")
                    );

            actualPrices.add(price);
        }

        // Create expected sorted list
        List<Double> expectedPrices =
                new ArrayList<>(actualPrices);

        Collections.sort(expectedPrices);

        // Verify prices are sorted low to high
        Assert.assertEquals(
                actualPrices,
                expectedPrices,
                "Products are not sorted from low to high price"
        );

        System.out.println(
                "Products sorted successfully: "
                        + actualPrices
        );
    }
}