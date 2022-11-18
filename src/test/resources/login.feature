@login
Feature: login feature

  As a customer
  I want to login to the login functionality to check my login details

  Scenario: Login with valid credential
    Given i am on home page
    When i click on login button
    Then i should  see "welcome, Please Sign In!" text on login page