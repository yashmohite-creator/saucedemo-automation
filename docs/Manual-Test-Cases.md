SAUCEDEMO MANUAL TEST CASES

PROJECT: SauceDemo E-Commerce Web Application

APPLICATION UNDER TEST

Website:
https://www.saucedemo.com/

TESTING TYPE

• Functional Testing
• Positive Testing
• Negative Testing
• UI Testing
• Regression Testing

TEST CASE 1 — Valid Login

Test Case ID: TC_LOGIN_001

Test Scenario:
Verify that a valid user can log in successfully.

Test Steps:
1. Open SauceDemo.
2. Enter username: standard_user.
3. Enter password: secret_sauce.
4. Click Login.

Expected Result:
User should be successfully logged in and redirected to the Products page.

Expected URL:
https://www.saucedemo.com/inventory.html

Status:
PASS


TEST CASE 2 — Invalid Password

Test Case ID: TC_LOGIN_002

Test Scenario:
Verify login with an incorrect password.

Test Steps:
1. Open SauceDemo.
2. Enter username: standard_user.
3. Enter an incorrect password.
4. Click Login.

Expected Result:
An appropriate invalid username/password error message should be displayed.

Status:
PASS


TEST CASE 3 — Locked Out User

Test Case ID: TC_LOGIN_003

Test Scenario:
Verify that a locked-out user cannot log in.

Test Steps:
1. Open SauceDemo.
2. Enter username: locked_out_user.
3. Enter password: secret_sauce.
4. Click Login.

Expected Result:
A locked-out user error message should be displayed.

Status:
PASS


TEST CASE 4 — Empty Login Fields

Test Case ID: TC_LOGIN_004

Test Scenario:
Verify login validation when username and password are empty.

Test Steps:
1. Open SauceDemo.
2. Leave username empty.
3. Leave password empty.
4. Click Login.

Expected Result:
The application should display a username-required validation message.

Status:
PASS


TEST CASE 5 — Add Product to Cart

Test Case ID: TC_CART_001

Test Scenario:
Verify that a product can be added to the shopping cart.

Test Steps:
1. Login with a valid user.
2. Open the Products page.
3. Add Sauce Labs Backpack to the cart.
4. Open the shopping cart.

Expected Result:
Sauce Labs Backpack should be displayed in the cart.

Status:
PASS


TEST CASE 6 — Remove Product from Cart

Test Case ID: TC_CART_002

Test Scenario:
Verify that a product can be removed from the shopping cart.

Test Steps:
1. Login with a valid user.
2. Add Sauce Labs Backpack to the cart.
3. Open the shopping cart.
4. Click Remove.

Expected Result:
The product should be removed from the cart.

Status:
PASS


TEST CASE 7 — Sort Products by Price

Test Case ID: TC_PRODUCT_001

Test Scenario:
Verify that products can be sorted from low to high price.

Test Steps:
1. Login with a valid user.
2. Open the Products page.
3. Select Price: Low to High.

Expected Result:
Products should be displayed in ascending order of price.

Status:
PASS


TEST CASE 8 — Checkout Information

Test Case ID: TC_CHECKOUT_001

Test Scenario:
Verify that a user can enter checkout information.

Test Steps:
1. Login with a valid user.
2. Add Sauce Labs Backpack to the cart.
3. Open the cart.
4. Click Checkout.
5. Enter first name.
6. Enter last name.
7. Enter postal code.
8. Click Continue.

Expected Result:
User should be redirected to the Checkout Overview page.

Status:
PASS


TEST CASE 9 — Complete Order

Test Case ID: TC_CHECKOUT_002

Test Scenario:
Verify that a user can successfully complete an order.

Test Steps:
1. Login with a valid user.
2. Add Sauce Labs Backpack to the cart.
3. Open the cart.
4. Click Checkout.
5. Enter checkout information.
6. Continue to Checkout Overview.
7. Click Finish.

Expected Result:
Order confirmation should be displayed.

Expected Message:
Thank you for your order!

Status:
PASS


TEST EXECUTION SUMMARY

Total Test Cases: 9

Passed: 9

Failed: 0

Blocked: 0

Test Result: PASS


AUTOMATION COVERAGE

The above scenarios are also covered by Selenium WebDriver automation using Java, TestNG and Page Object Model.

Automation Result:

Tests Run: 10

Passed: 10

Failed: 0

Skipped: 0

Build Status: SUCCESS