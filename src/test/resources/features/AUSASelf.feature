Feature: SaSelf features

  @SASelf
  Scenario Outline: 1_Enter mobile number and click verify
    Given Read the test data  "<TestData>" from Excel file
    When Navigate to the url
    And Enter valid contact number
    And Click on verify button
    Then Verify if the OTP screen displays

    Examples: 
      | TestData  |
      | TestDataSASelf |