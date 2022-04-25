@Regression
Feature: Regression Testing

  @ManagedEquipment
  @GETTNF-23950
  Scenario Outline: GETTNF-23950 Managed Equipment-Support Switches and Wireless Access Point delivery(1)-Passed
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product           | Product Component | Terminating Region Code |
      | Install      | Accepted     | New        | HC_MES       | Managed Equipment | Managed Equipment | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552278809 |