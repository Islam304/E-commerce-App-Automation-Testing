@smoke
Feature: test currency
  Background:user navigate to page and close it after finish
    Given initialize Currencies feature
  Scenario: user change currency to euro
    When user press on currencies
    And user chooses "euro"
    Then the product currency changes to "euro"