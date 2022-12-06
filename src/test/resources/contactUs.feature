@contactUs @regression
Feature: Contact us feature

  As a customer
  I want to use contact us functionality


  Scenario: Validate contact us functionality
    Given I am on home page
    When I click on Contact us button on home page
    Then I should see "Contact Us" text on contact us page
    And I should see "/contactus" text in url on contact us page