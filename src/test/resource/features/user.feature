Feature: Get all list of users
Scenario: Get all user
Given user is on REQRES URL
When user hits the users API
Then all the users is displayed
 