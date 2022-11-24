@login
Feature: Login feature

  As a customer
  I want to login to the login functionality to check my login details


  Scenario: Validate login page
    Given I am on home page
    When I click on login button
    Then I should see "Welcome, Please Sign In!" text on login page
    And I should see text "/login" in url on login page

  Scenario: Login with valid credential
    Given I am on home page
    When I click on login button
    When I enter valid email "tan@gmail.com"
    When enter valid password "123abc"
    When I click on login button on login page
    Then I should see log out button displayed




