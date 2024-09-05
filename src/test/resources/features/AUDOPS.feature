Feature: DOPS features

  @DOPS
  Scenario Outline: 1_Login DOPS application
    Given Read the test data  "<TestData>" from Excel file
    When Navigate to the url
    And Enter valid credentials
    And Click on login button to initiate login
    Then Verify Login status

    Examples: 
      | TestData  |
      | TestDataDOPS |