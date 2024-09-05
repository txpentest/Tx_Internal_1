Feature: Test a scenario in SalesForce

  @SFAutomation
  Scenario Outline: 10001_Create a Case and validate the creation
    Given Read the test data  "<TestData>" from Excel file
    When Navigate to the url
    And Enter the SF login credentials
    Then Click on SF login button
    When Click on app launcher button
    And Enter "Cases" to search as app
    And Click on searched app
    When Click on new button
    And Click on next button
    And Click on account name field
    And Click on first recent account name
    And Click on save button
    Then Save newly created case number
    When Click on setup button
    And Click on Developer console option in setup menu
    Then Switch to developer console
    And Clear the query field
    When Input the query to using case number
    And Click on execute query button
    Then Check if case number and ID fields are displaying
    When Switch back to SF Application
    And Click on report menu list to display options
    And Click Open cases of all time link
    And Click on search report table field
    Then Enter case number in the search report table field
    When Click on case number displaying in the table
    Then Validate the created case details
	
    Examples: 
      | TestData  |
      | TestDataSF |