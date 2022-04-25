@Regression
Feature: RED DIA Functionality
@REDDIA
Scenario Outline: GETTNF-19586-REDDIA Onnet #Passed (1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product                   | Terminating Region Code |
      | Install      | Accepted     | New        | Transport    | Dedicated Internet Access | NA                      |
      | Install      | Accepted     | New        | Data         | Dedicated Internet Access | NA                      |
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552209972 |
