@Sanity
Feature: Sanity
  @TEST_CNSDITIE-7437
  Scenario Outline: Waiting for All Dates task should get terminated when the automation type is Auto Create for DAL order
    Given User Launches BPMS Portal and logs in as "Umar" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Service Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "Yes" and automation task filter as "Yes"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Service Order Id" and enters the "<ID>"
    And User clicks on search button
    #Then User validates results grid and completes all the tasks upto "AUTO_Offnet_Design_CFA" task
    #And User validates that Task with task name "AUTO_Offnet_Design_CFA" is getting displayed
    #When User clicks on Manage Task link of "AUTO_Offnet_Design_CFA" task
    #And User provides "No" value in AutopilotManagedOffnet text field
    #And User clicks on Save and Complete button to complete the task
    #And User clicks on Refresh button
    #Then User validates results grid and completes all the tasks upto "Assign Design Request" task
    #When User clicks on Manage Task link of "Assign Design Request" task
    #When User enters required details
    #And User clicks on Save and Complete button to complete the task
    #And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Design Offnet Segment of Access" task  
    And User validates that Task with task name "Design Offnet Segment" is getting displayed
    When User clicks on Manage Task link of "Design Offnet Segment" task
    And User creates the ASR in the Design Offnet Segment task for DAL order
    And User clicks on Save and Complete button to complete the task

    Examples: 
      | ID                 |
      | 1044TGRC-BCKC64622 |
