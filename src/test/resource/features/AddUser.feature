@User
Feature: Adding the user to the List.
Background:
Given user on reques url
@Add
Scenario Outline: add user

When user enter the "<name>" and "<job>"
And users hit the users API
Then users are added to list

Examples:
|name|job|
|manikanta|Farmer|
|Ganesh|Hacker|
@Update
Scenario: Update the user
  When user enters name & job
  |Jyothi|Consultant|
  |Manikanta|Sr. Consultant|
  And user hits the API
  Then User data is updated