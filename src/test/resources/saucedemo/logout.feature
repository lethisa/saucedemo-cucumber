Feature: Saucedemo Product, Checkout and Logout

  Background: Success Login to saucedemo
    Given user is on saucedemo login page to login
    When user input a username
    And user input a password
    And user click login button
    Then user is on saucedemo product page

  @Regression @Positive
  Scenario: Success Logout
    When user click burger button
    And user click logout button
    Then user is on login page at saucedemo

  @Regression @Negative
  Scenario: Failed Logout
    When user click burger button
    And user click logout button
    Then user is on saucedemo product page

  @Regression @Positive
  Scenario: Success add product
    When user click add to cart button
    And user click cart icon
    Then product show at cart list

  @Regression @Negative
  Scenario: Failed add product
    When user click add to cart button
    And user click cart icon
    Then product not show at cart list

  @Regression @Negative
  Scenario: Success Checkout
    When user click checkout button
    Then cart page displayed

  @Regression @Negative
  Scenario: Success Checkout None
    When user click checkout button
    And user input Firstname
    And user input Lastname
    And user click continue
    Then checkout page displayed

  @Regression @Positive
  Scenario: Success Checkout Complete
    When user click checkout button
    And user input Firstname
    And user input Lastname
    And user input postal
    And user click continue
    Then checkout page displayed