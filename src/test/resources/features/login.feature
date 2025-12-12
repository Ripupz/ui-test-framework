Feature: Login functionality

  Background:
    Given I open the login page

  Scenario: Successful login (positive)
    When I login with username "amindrichman@gmail.com" and password "Amind8787"
    Then I should see the home page

  Scenario: Login failure with wrong credentials (negative)
    When I login with username "amindrichman@gmail.com" and password "wrongPass"
    Then I should see an error message

  Scenario: Username boundary tests
    When I login with username "wrong@gmail.com" and password "somePass"
    Then I should see an error message

  Scenario: Very long username (boundary)
    When I login with username "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail" and password "somePass"
    Then I should see an error message or validation message
