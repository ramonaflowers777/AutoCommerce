Feature: Footer links accessibility
  I am a user
  I want to click on links in footer
  To contact or read about company

  Scenario Outline: Interacting with footer links
    Given I am on the Main Page
    When I click "<footerElement>" link in footer
    Then Page should contain "<footerElement>" displayed

    Examples:
    |footerElement|
    | About Us |
    | Contact Us |
