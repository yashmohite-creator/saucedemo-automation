package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.CheckoutOverviewPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutTest() {

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
                "Backpack was not found in cart"
        );

        takeScreenshot(
                "checkout_01_cart_page"
        );

        cartPage.clickCheckout();

        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        checkoutPage.enterCheckoutInformation(
                "Yash",
                "Tester",
                "415109"
        );

        takeScreenshot(
                "checkout_02_overview"
        );

        CheckoutOverviewPage overviewPage =
                new CheckoutOverviewPage(driver);

        Assert.assertEquals(
                overviewPage.getPageTitle(),
                "Checkout: Overview",
                "Checkout overview page was not displayed"
        );
    }
}