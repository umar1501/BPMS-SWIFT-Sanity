@Regression
Feature: Regression Testing

 @QuickStart
 @CNSDITIE-3918
      Scenario Outline: QS-LATAM One Office Track
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<QuickStart Order ID>"
    And Move to QuickStart Order sub tab under Orders Page
    And User selects the "Request Id" and enters the "<QuickStart Order ID>"
    And User clicks on search button
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And Move to QuickStart Order sub tab under domain criteria
    And User enters the "<QuickStart Order ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting
       Examples: 
      | QuickStart Order ID|
      | 19004689458|   