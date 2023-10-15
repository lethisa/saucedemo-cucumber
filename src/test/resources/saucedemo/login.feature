Feature: Login at saucedemo

  @Regression @Positive
  Scenario: Success Login
    Given user is on saucedemo login page
    When user input X as username
    And user input X as password
    And click login button
    Then user is on product page

  @Regression @Positive
  Scenario: Failed Login
    Given user is on saucedemo login page
    When user input X as username
    And user input X as invalid password
    And click login button
    Then user get error messages

  @Regression @Negative
  Scenario: Success Login Random Username Password
    Given user is on saucedemo login page
    When user input Y as username
    And user input Y as password
    And click login button
    Then user is on product page