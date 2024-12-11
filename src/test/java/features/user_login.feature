Feature: User Authentication
  I am a user
  I want to Log In
  To purchase items

  Background:
    Given I am on the Main Page
    When I Click on My account and choose Log in

  Scenario Outline: Logging in with correct credentials
    When I Enter "<email>" for email
    And I Enter "<password>" for password
    And I Click Log in button
    Then I should see "<expectedResult>"

    Examples:
    | email | password | expectedResult |
    | test@test.ge | test123 | My account page |
    | user@user.ge| user123 | Error message    |

