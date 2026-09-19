package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;

public class CartTest extends BaseTest {

    @Test
    public void verifyBackpackInCart() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        inventoryPage.addBackpackToCart();

        inventoryPage.clickShoppingCart();

        takeScreenshot("06_cart_page");

        CartPage cartPage =
                new CartPage(driver);

        Assert.assertEquals(
                cartPage.getBackpackName(),
                "Sauce Labs Backpack",
                "Backpack was not found in the cart"
        );

        takeScreenshot("07_backpack_verified");
    }
}