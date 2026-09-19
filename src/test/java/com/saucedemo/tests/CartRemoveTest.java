package com.saucedemo.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;

public class CartRemoveTest extends BaseTest {

    @Test
    public void removeProductFromCartTest() throws InterruptedException {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        inventoryPage.addBackpackToCart();

        inventoryPage.clickShoppingCart();

        CartPage cartPage =
                new CartPage(driver);

        Assert.assertEquals(
                cartPage.getBackpackName(),
                "Sauce Labs Backpack",
                "Backpack was not added to cart"
        );

        takeScreenshot(
                "remove_01_product_in_cart"
        );

        // Remove the backpack
        cartPage.removeBackpack();

        // Give the page a short time to update
        Thread.sleep(1000);

        takeScreenshot(
                "remove_02_product_removed"
        );

        String pageText =
                driver.findElement(
                        By.tagName("body")
                ).getText();

        System.out.println(
                "Cart page after removal:\n"
                        + pageText
        );

        Assert.assertFalse(
                pageText.contains("Sauce Labs Backpack"),
                "Backpack was not removed from cart"
        );
    }
}