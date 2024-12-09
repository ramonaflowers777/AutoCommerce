Feature: Adding items to Cart and verify total
  I am a user
  I want to add products to Cart
  So that I can purchase them and see the correct total

Scenario Outline: Adding items to the cart and verifying the total price
  Given I am on the Main Page
  When I add product with "<id>" in cart
  Then Success Message with product "<id>" is shown
  When I open the cart
  Then The Shopping cart page should be open
  And Product with "<id>" is in the cart
  When I change quantity by "<quantity>" and submit
  Then Total price is price times "<quantity>"
#  And Price is shown correctly


  Examples:
  | id | quantity |
  | 43 |      2   |
  | 40 |      3   |


#  Then The product with "<id>" should not be in the cart

