Feature: Login Functionality
  @LoginPage
  Scenario: Take a Screenshot After login
    Given User open the Browser and Navigate to "https://www.amazon.com/"
    Then User click on Sign In Button
    When User click on Sign in button, assert logo is present or not
    Then Take a Screenshot and store it
