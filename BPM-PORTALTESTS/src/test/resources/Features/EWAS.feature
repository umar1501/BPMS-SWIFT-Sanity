@Regression
Feature: Regression Testing

  @EWAS
  @GETTNF-33652
  Scenario Outline: GETTNF-33652 To check the L4_Install_EWAS template kickedn off on EWAS (1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product                            | Terminating Region Code |
      | Install      | Accepted     | New        | HC_EWAS      | Enterprise Wireless Access Service | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validate the tasks should get completed before "AUTO_EWAS_Logistics" task completed in task reporting
    | AUTO_EWAS_Init|
    And User clicks on Refresh button
    And User validates results grid and completes all the tasks upto "AUTO_EWAS_Logistics of Enterprise Wireless Access Service" task
    And User validates that Task with task name "AUTO_EWAS_Logistics" is getting displayed
    When User clicks on Manage Task link of "AUTO_EWAS_Logistics" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validate the Process Name of "EWAS_Logistics" kicked of in task reporting page
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552278563 |
      
      
      
    #Then User validates results grid and completes all the tasks upto "AUTO_EWAS_Init" task
    #And User validates that Task with task name "AUTO_EWAS_Init" is getting displayed
    #When User clicks on Manage Task link of "AUTO_EWAS_Init" task
    #And User clicks on Save and Complete button to complete the task