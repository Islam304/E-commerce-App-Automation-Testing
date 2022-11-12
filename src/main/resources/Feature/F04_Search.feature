@smoke
Feature: test search
  Background:user navigate to page and close it after finish
    Given initialize Search feature
  Scenario Outline: : search products with name
    When user types "<productName>"
    And clicks on search
    Then user should find the "<productName>"
    Examples:
      |productName|
      |book|
      |laptop|
      |nike|

  Scenario Outline: : search products with sku
    When user types "<productSku>" as product sku
    And clicks on search
    Then user should find the "<productSku>" as product sku
    Examples:
      |productSku|
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|