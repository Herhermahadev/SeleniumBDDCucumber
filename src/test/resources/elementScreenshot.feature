@elementScreenshot @regression
  Feature: Element screenshot

    Scenario: Take element screenshot of search field
      Given I am on home page
      When I take screenshot of search field
#      Then screenshot match with searchFieldScreenshot