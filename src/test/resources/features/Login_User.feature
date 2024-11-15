@loginAutomation
Feature: Login with user

  Background:
    Given Launch browser
    And Navigate to the automation exercise url
    Then Verify that the home page is visible successfully
    When Click on the signup login button
    Then Verify login to your account is visible

    @loginValid
  Scenario: Login with user correct email and password
    When Enter correct email address and password
    And click on the login button
    Then Verify the logged in as username is visible
    When click delete account button
    Then Verify that the account delete is visible

    @loginInvalid
  Scenario: Login with user incorrect email and password
    When Enter incorrect email address and password
    And Click on the signup login button
    Then Verify error your email or password is incorrect is visible
