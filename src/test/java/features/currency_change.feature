Feature: Changing currency on the website
  I am a user
  I want to change currency
  To pay with my preferred currency


  Scenario Outline: User changes the currency on the website
    Given I am on the Main Page
    When I open the currency dropdown
    And I select "<currency>"
    Then the currency for products should be displayed in "<currencySymbol>"

    Examples:
      | currency | currencySymbol |
      | EUR      | €             |
      | GBP      | £             |
      | USD      | $             |