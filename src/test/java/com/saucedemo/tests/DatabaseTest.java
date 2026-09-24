package com.saucedemo.tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.utils.DatabaseConnection;

public class DatabaseTest {

    @Test
    public void verifyProductCount() {

        String query =
                "SELECT COUNT(*) AS total_products FROM products";

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(query);

             ResultSet resultSet =
                     statement.executeQuery()) {

            Assert.assertTrue(
                    resultSet.next(),
                    "No result returned from database"
            );

            int totalProducts =
                    resultSet.getInt("total_products");

            Assert.assertEquals(
                    totalProducts,
                    4,
                    "Product count is incorrect"
            );

            System.out.println(
                    "Product count from database: "
                            + totalProducts
            );

        } catch (SQLException e) {

            Assert.fail(
                    "Database test failed: "
                            + e.getMessage()
            );
        }
    }

    @Test
    public void verifyBackpackPrice() {

        String query =
                "SELECT price FROM products " +
                "WHERE product_name = ?";

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(query)) {

            statement.setString(
                    1,
                    "Sauce Labs Backpack"
            );

            try (ResultSet resultSet =
                         statement.executeQuery()) {

                Assert.assertTrue(
                        resultSet.next(),
                        "Sauce Labs Backpack was not found"
                );

                double price =
                        resultSet.getDouble("price");

                Assert.assertEquals(
                        price,
                        29.99,
                        "Backpack price is incorrect"
                );

                System.out.println(
                        "Backpack price from database: "
                                + price
                );
            }

        } catch (SQLException e) {

            Assert.fail(
                    "Database test failed: "
                            + e.getMessage()
            );
        }
    }

    @Test
    public void verifyBackpackStock() {

        String query =
                "SELECT stock FROM products " +
                "WHERE product_name = ?";

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(query)) {

            statement.setString(
                    1,
                    "Sauce Labs Backpack"
            );

            try (ResultSet resultSet =
                         statement.executeQuery()) {

                Assert.assertTrue(
                        resultSet.next(),
                        "Sauce Labs Backpack was not found"
                );

                int stock =
                        resultSet.getInt("stock");

                Assert.assertEquals(
                        stock,
                        10,
                        "Backpack stock is incorrect"
                );

                System.out.println(
                        "Backpack stock from database: "
                                + stock
                );
            }

        } catch (SQLException e) {

            Assert.fail(
                    "Database test failed: "
                            + e.getMessage()
            );
        }
    }
}