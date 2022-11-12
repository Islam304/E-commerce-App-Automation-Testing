@smoke
Feature: test register
  Background:user navigate to page and close it after finish
    Given initialize register feature

  Scenario: Register with valid data

    When user press register icon
    And user selects "male" and enters "islam" as first name, "khaled" as last name, "islamkhaled4520@gmail.com" as email, "Aman" as company, "Aman@2" as password and "Aman@2" as confirm password
    And user set his birthday as follow "21" Day "5" Month "1994" Year
    And user clicks on register button
    Then successful registration message appears

  Scenario: user didn't enter any data

    When user press register icon
    And user clicks on register button
    Then error messages appear

  Scenario: user didn't enter the same password

    When user press register icon
    And user selects "male" and enters "islam" as first name, "khaled" as last name, "islamkhaled4520@gmail.com" as email, "Aman" as company, "Aman@2" as password and "Aman@0" as confirm password
    And user set his birthday as follow "21" Day "5" Month "1994" Year
    And user clicks on register button
    Then user get non identical passwords

  Scenario: email already exist

    When user press register icon
    And user selects "male" and enters "islam" as first name, "khaled" as last name, "islamkhaled4520@gmail.com" as email, "Aman" as company, "Aman@2" as password and "Aman@2" as confirm password
    And user set his birthday as follow "21" Day "5" Month "1994" Year
    And user clicks on register button
    Then email exist message appears
