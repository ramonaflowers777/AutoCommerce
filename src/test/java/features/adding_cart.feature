Feature: Managing cart items

  I am a user
  I want to add products to Cart and change quantity
  So that I can purchase them


  Scenario Outline: Adding items to cart and changing quantity
    Given I am on the Main Page
    When I add product with "<id>" in cart
    Then Success Message with product "<id>" is shown
    When I open the cart
    Then The Shopping cart page should be open
    And Product with "<id>" is in the cart
    When I change quantity by "<quantity>" and submit
    Then The product with "<id>" should be removed from the cart if the "<quantity>" is 0
    And The total price should be price times "<quantity>" if the quantity is greater than 0

    Examples:
      | id | quantity |
      | 43 | 0        |
      | 40 | 5        |

