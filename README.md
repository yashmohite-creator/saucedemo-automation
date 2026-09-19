SAUCEDEMO E-COMMERCE WEB APPLICATION TESTING


PROJECT OVERVIEW

This project is a Selenium automation testing framework created for the SauceDemo (Swag Labs) e-commerce website.

I built this project to practice and demonstrate web application testing using Java, Selenium WebDriver, TestNG, Maven, and the Page Object Model (POM).

The project covers common e-commerce activities such as login, product selection, product sorting, shopping cart operations, and checkout.

I also added screenshots and ExtentReports to make the test execution results easier to review.


APPLICATION UNDER TEST

• Website: SauceDemo (Swag Labs)

The application provides a sample e-commerce environment where users can:

• Log in with different user accounts
• View available products
• Sort products
• Add products to the shopping cart
• Remove products from the shopping cart
• Enter checkout information
• Complete an order


TEST SCENARIOS

LOGIN TESTING

• Successful login with valid username and password
• Login with an incorrect password
• Login using a locked-out user
• Login with empty username and password fields


PRODUCT AND INVENTORY TESTING

• Verify that the Products page is displayed after login
• Add a product to the shopping cart
• Verify that the selected product appears in the cart
• Sort products by price from low to high
• Verify that products are correctly sorted by price


SHOPPING CART TESTING

• Verify that the selected product is available in the cart
• Remove a product from the cart
• Verify that the product is removed successfully


CHECKOUT TESTING

• Open the checkout page
• Enter first name, last name, and postal code
• Verify the Checkout Overview page
• Complete the order
• Verify the order confirmation message


TECHNOLOGIES USED

• Java 21
• Selenium WebDriver 4.38.0
• TestNG 7.11.0
• Maven
• ExtentReports 5.1.2
• Google Chrome
• Eclipse IDE
• Git
• GitHub


AUTOMATION FRAMEWORK

The project follows the Page Object Model (POM) design pattern.

The page classes contain the web element locators and reusable actions.

The test classes contain the test scenarios, test data, and assertions.

This structure makes the automation framework easier to understand, maintain, and extend.


PAGE CLASSES

• LoginPage.java
• InventoryPage.java
• CartPage.java
• CheckoutPage.java
• CheckoutOverviewPage.java


TEST CLASSES

• LoginTest.java
• NegativeLoginTest.java
• InventoryTest.java
• InventorySortTest.java
• CartTest.java
• CartRemoveTest.java
• CheckoutTest.java
• CompleteCheckoutTest.java


SUPPORTING CLASSES

• BaseTest.java
• ExtentReportManager.java
• ExtentReportListener.java
• ScreenshotListener.java


PROJECT STRUCTURE

saucedemo-automation

• src
  • main
    • java
      • com.saucedemo.pages
        • LoginPage.java
        • InventoryPage.java
        • CartPage.java
        • CheckoutPage.java
        • CheckoutOverviewPage.java

  • test
    • java
      • com.saucedemo.tests
        • BaseTest.java
        • LoginTest.java
        • NegativeLoginTest.java
        • InventoryTest.java
        • InventorySortTest.java
        • CartTest.java
        • CartRemoveTest.java
        • CheckoutTest.java
        • CompleteCheckoutTest.java
        • ExtentReportManager.java
        • ExtentReportListener.java
        • ScreenshotListener.java

• screenshots
• reports
  • ExtentReport.html
• testng.xml
• pom.xml
• README.md


HOW TO RUN THE PROJECT

Prerequisites

• Java 21
• Maven
• Google Chrome
• Eclipse IDE


Check Java version

java -version


Check Maven version

mvn -version


RUN THE TEST SUITE

Open the project directory in Command Prompt and run:

mvn clean test

The tests can also be executed from Eclipse:

• Right-click the project
• Select Run As
• Select Maven build
• Enter clean test in Goals
• Click Run


TEST EXECUTION RESULT

The current automation suite contains 10 automated tests.

Latest successful execution:

• Tests run: 10
• Failures: 0
• Errors: 0
• Skipped: 0
• Build: SUCCESS

All 10 automated tests passed successfully in the latest test execution.


TEST REPORTING

The project uses ExtentReports for test execution reporting.

The report is generated at:

reports/ExtentReport.html

The report contains:

• Test names
• Test status
• Test classes
• Browser information
• Environment information
• Execution details
• Failure information
• Failure screenshots


SCREENSHOTS

Screenshots are stored in:

screenshots/

Screenshots are captured at important points during test execution, including:

• Login page
• Successful login
• Products page
• Product added to cart
• Shopping cart
• Checkout page
• Checkout overview
• Order completion

Failure screenshots are also captured when a test fails.


EXAMPLE AUTOMATION FLOW

Open SauceDemo

↓

Login

↓

Products Page

↓

Add Sauce Labs Backpack

↓

Open Shopping Cart

↓

Verify Product

↓

Checkout

↓

Enter Customer Information

↓

Checkout Overview

↓

Finish Order

↓

Verify Order Confirmation


WHY I USED PAGE OBJECT MODEL

I used the Page Object Model because it keeps the page locators and page actions separate from the test cases.

For example, the test can use a reusable method such as:

loginPage.login("standard_user", "secret_sauce");

Instead of writing the same Selenium code in multiple test classes.

This makes the test cases easier to read and maintain.

If a locator changes in the future, it can be updated in the related page class instead of changing the same locator in multiple test files.


TESTING TYPES COVERED

POSITIVE TESTING

• Valid login
• Add product to cart
• Successful checkout
• Successful order completion


NEGATIVE TESTING

• Incorrect password
• Locked-out user
• Empty login fields


FUNCTIONAL TESTING

• Product sorting
• Shopping cart operations
• Checkout information
• Order confirmation


REGRESSION TESTING

The complete TestNG suite can be executed together to verify that previously working functionality continues to work after changes.


CHALLENGES I WORKED ON

During development, I worked through several practical automation issues, including:

• Selenium element synchronization
• Dynamic page loading
• Waiting for elements before interacting with them
• Shopping cart operations
• Checkout page synchronization
• Browser session handling
• Screenshot capture
• ExtentReports configuration
• Debugging failed TestNG tests

I used explicit waits and reusable page methods to make the tests more reliable.


FUTURE IMPROVEMENTS

• Add more positive and negative test scenarios
• Add data-driven testing
• Add manual test case documentation
• Add API testing using Postman
• Add SQL database validation
• Improve test data management
• Add GitHub Actions for CI/CD
• Explore Jenkins integration
• Improve test reporting
• Add more reusable utilities


SKILLS DEMONSTRATED

• Manual Testing
• Functional Testing
• Regression Testing
• Negative Testing
• UI Automation
• Selenium WebDriver
• Java
• TestNG
• Maven
• Page Object Model
• Explicit Waits
• Assertions
• Screenshot Capture
• ExtentReports
• TestNG Listeners
• Debugging Automation Failures
• Git
• GitHub


AUTHOR

Yash

B.Tech Graduate

This project was created as part of my QA Automation learning and portfolio development.


PROJECT STATUS

Current Status: Core UI Automation Completed

The main SauceDemo user flows are automated and the current test suite is passing successfully.

Future enhancements such as API testing, SQL validation, and CI/CD automation are planned.

• API Testing — Postman

API testing was performed using Postman with JSONPlaceholder as a public practice API.

API test scenarios:

• GET — Retrieve a single post
• POST — Create a new post
• PUT — Update an existing post
• DELETE — Delete a post

API validations:

• HTTP status code validation
• Response field validation
• Response data validation
• Automated Postman assertions
• Collection Runner execution

API Test Execution:

• Total API Test Cases: 4
• Passed: 4
• Failed: 0
• Blocked: 0

API documentation:
• api-testing/API-Test-Cases.md