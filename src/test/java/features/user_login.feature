Feature: User Authentication
  I am a user
  I want to Log In
  To purchase items

  Background:
    Given I am on the Main Page
    When I Click on My account and choose Log in

  Scenario: Logging in with correct credentials
    And I Enter email for email
    And I Enter password for password
    And I Click Log in button
    Then My account Page is shown

#  Scenario: Logging in with incorrect credentials
#    And I Enter "user@user.ge" for email
#    And I Enter "user1" for password
#    And I Click Log in button
#    Then I Should see an error message


