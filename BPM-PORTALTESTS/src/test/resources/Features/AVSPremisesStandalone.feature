@Regression
Feature: Regression Testing

  @AVSPremises
  @GETENF-58664
  Scenario Outline: GETENF-58664 TC01- BPMS | AVS Premises Standalone order(1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product                            | Product Component                  | Terminating Region Code |
      | Install      | Accepted     | New        | HC_UCPE      | Adaptive Virtual Services Premises | Adaptive Virtual Services Premises | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552278561 |
      
      
    #Then User validates results grid and completes all the tasks upto "AUTO_UCPE_Logistics of Adaptive Virtual Services Premises" task
    #And User validates that Task with task name "AUTO_UCPE_Logistics" is getting displayed
    #When User clicks on Manage Task link of "AUTO_UCPE_Logistics" task
    #Then User validates the device Name and serial number mandatory field in the task details page
    #When User enters the device name and serial number field details 
    #And User clicks on Save and Complete button to complete the task