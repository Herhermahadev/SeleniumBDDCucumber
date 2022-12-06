@register
Feature: Registration
  As a new customer
  I want to register

  Background:
    Given I am on home page
    Then I click on register button

#  Scenario: Registration with valid mandatory data
#    And I enter firstname "Tan"
#    And I enter lastname "Kan"
#    And I enter valid email "tk12@gmail.com" on registration page
#    And I enter valid password "Abc123" on registration page
#    And I enter valid confirm password "Abc123" on registration page
#    When I click on register button on register page
#    Then I should see "Your registration completed" text on register page
#    And I should see log out button displayed on register page
#    And I should see "/registerresult" text in url on register page

  @dataTable @regression
  Scenario Outline: Registration with valid mandatory data
    When I enter following data for registration
#    dataTable
      | firstname   | lastname   | email          | password   | confirm password   |
      | Tan         | Kan        | tk12@gmail.com | abc123     | abc123             |
#      scenario outline
      | <firstname> | <lastname> | <email>        | <password> | <confirm password> |
#    And I enter firstname "Tan"
#    And I enter lastname "Kan"
#    And I enter valid email "tk12@gmail.com" on registration page
#    And I enter valid password "Abc123" on registration page
#    And I enter valid confirm password "Abc123" on registration page
    When I click on register button on register page
    Then I should see "Your registration completed" text on register page
    And I should see log out button displayed on register page
    And I should see "/registerresult" text in url on register page
    Examples:
      | firstname | lastname | email            | password | confirm password |
      | Naresh    | patel    | nk3@gmail.com    | abc123   | abc123           |
      | Bhranti   | patel    | bpatel@gmail.com | acbx     | acbx             |
      | Nirav     | Goyani   | ng13@gmail.com   | abc123   | abc123           |
      | megha     | patel    | mp1@gmail.com    | abcdefg  | abcdefg          |
      | Tim       | Kim      | tk1@gmail.com    | abc123   | abc123           |