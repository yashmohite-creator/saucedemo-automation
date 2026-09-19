package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;

public class InventoryTest extends BaseTest {

    @Test
    public void verifyProductAndAddToCart() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        takeScreenshot("03_products_page");

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        Assert.assertEquals(
                inventoryPage.getProductsTitle(),
                "Products",
                "Products page was not displayed"
        );

        inventoryPage.addBackpackToCart();

        takeScreenshot("04_product_added_to_cart");

        inventoryPage.clickShoppingCart();

        CartPage cartPage =
                new CartPage(driver);

        Assert.assertEquals(
                cartPage.getBackpackName(),
                "Sauce Labs Backpack",
                "Cart page was not opened or backpack was not found"
        );

        takeScreenshot("05_cart_page");
    }
}