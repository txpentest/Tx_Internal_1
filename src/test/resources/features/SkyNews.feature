Feature: Create an account for new user

  @SkyNews
  Scenario Outline: 1_Navigate to latest news page
    Given Read the test data  "<TestData>" from Excel file
    When Navigate to the url
    And Navigate to "Latest News" page
    Then Validate the latest news page navigation

    Examples: 
      | TestData  |
      | TestDataSN |