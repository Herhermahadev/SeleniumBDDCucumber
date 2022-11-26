Feature: Registration

  As a new customer
  I want to register

  @register
  Scenario: Registration with valid mandatory data
    Given I am on home page
    Then I click on register button
    And I enter firstname "Tan"
    And I enter lastname "Kan"
    And I enter valid email "tk12@gmail.com" on registration page
    And I enter valid password "Abc123" on registration page
    And I enter valid confirm password "Abc123" on registration page
    When I click on register button on register page
    Then I should see "Your registration completed" text on register page
    And I should see log out button displayed on register page
    And I should see "/registerresult" text in url on register page

