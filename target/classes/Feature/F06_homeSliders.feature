@smoke
Feature: test slider
  Background:user navigate to page and close it after finish
    Given initialize slider feature
  Scenario: test nokia pic
    When user select Nokia picture
    Then user should navigate to Nokia page

  Scenario: test iphone pic
    When user select iphone picture
    Then user should navigate to iphone page