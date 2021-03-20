Feature: Open web on browser
Scenario: Open google
   Given browser "chrome"
   When I enter url as "http://www.google.com/"
   And I write "cucumber"
   And I select "cucumber.io"
   Then I see "cucumber" web