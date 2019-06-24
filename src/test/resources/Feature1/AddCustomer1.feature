Feature: Add Customer Feature Functional Validation
  I want to use this template for my feature file

 
  Scenario: Title of your scenario
    Given user is in telecom domain
    And the user clicked on Add customer
    When the user has filling all the details
                |Firstname|Vasavi|
                |Lastname|Patnana|
                |Email ID|vasavipatnana.7@gmail.com|
                |Address|Srikakulam|
                |Telephone No|1234567890|
    And the user clicked on Submit button
    Then the user will be displayed ID

