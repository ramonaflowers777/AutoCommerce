Feature: Search functionality for products
  I am a user
  I want to search for a product
  To get information about them

  Scenario Outline: Searching for a product and verifying that correct page is open
    Given I am on the Main Page
    When I click on the search field and input <productName>
    Then <productName> page is displayed

    Examples:
      | productName |
      | "MacBook"   |
      | "iPhone"    |
