SauceDemo API Testing — Test Cases

Project: SauceDemo E-Commerce Automation
Tool: Postman
API: JSONPlaceholder
Environment: Public Practice API

1. GET - Get Single Post

Test Case ID: API_GET_001
Method: GET
Endpoint: https://jsonplaceholder.typicode.com/posts/1

Objective:
Verify that a single post can be retrieved successfully.

Expected Result:
• Status code should be 200 OK.
• Response should contain userId.
• Response should contain id.
• Response should contain title.
• Response should contain body.

Validation:
• Status code = 200
• Required response fields are present
• Post ID = 1

Result: PASS


2. POST - Create Post

Test Case ID: API_POST_001
Method: POST
Endpoint: https://jsonplaceholder.typicode.com/posts

Request Body:
{
  "title": "SauceDemo API Test",
  "body": "Testing POST API using Postman",
  "userId": 1
}

Objective:
Verify that a new post can be created successfully.

Expected Result:
• Status code should be 201 Created.
• Response should contain the submitted data.
• Response should contain a generated ID.

Validation:
• Status code = 201
• Title is correct
• Body is correct
• User ID is correct

Result: PASS


3. PUT - Update Post

Test Case ID: API_PUT_001
Method: PUT
Endpoint: https://jsonplaceholder.typicode.com/posts/1

Request Body:
{
  "id": 1,
  "title": "Updated SauceDemo API Test",
  "body": "Post updated using PUT request",
  "userId": 1
}

Objective:
Verify that an existing post can be updated successfully.

Expected Result:
• Status code should be 200 OK.
• Response should contain the post ID.

Validation:
• Status code = 200
• Post ID = 1

Result: PASS


4. DELETE - Delete Post

Test Case ID: API_DELETE_001
Method: DELETE
Endpoint: https://jsonplaceholder.typicode.com/posts/1

Objective:
Verify that an existing post can be deleted successfully.

Expected Result:
• Status code should be 200 OK.

Validation:
• Status code = 200

Result: PASS


API Test Execution Summary

Total API Test Cases: 4
Passed: 4
Failed: 0
Blocked: 0

Overall Result: PASS

API Testing Tool:
Postman

Testing Types:
• GET API testing
• POST API testing
• PUT API testing
• DELETE API testing
• Status code validation
• Response field validation
• Automated assertions
• Collection execution