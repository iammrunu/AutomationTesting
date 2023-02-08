Feature: Screenshot Functionality
 @Screenshot
 Scenario: Take a Screenshot of google page
   Given  User open the browser and navigate to "http://google.com"
   Then  User enter "w3schools"
   Then  User click the google search button
   When  User click on search button result should displayed
   Then  User select or click JavaScript Tutorial
   When  User click JavaScript Tutorial assert JavaScript Tutorial is loaded or not
   Then  User take screenshot and stored it