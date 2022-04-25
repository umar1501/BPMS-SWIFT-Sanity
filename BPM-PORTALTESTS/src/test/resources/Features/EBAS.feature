@Regression
Feature: Regression Testing
  @EBAS
  @GETENF-57740
  @GETENF-57788
  Scenario Outline: GETTNF-7142 or GETENF-57740,GETTNF-7137 or GETENF-57788-EBAS with Primary Cellular-Add LCON data to Request Cellular Site Survey task (2)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "Request Cellular Site Survey of Cellular Internet Access" task
    And User validates that Task with task name "Request Cellular Site Survey" is getting displayed
    When User clicks on Manage Task link of "Request Cellular Site Survey" task
    Then User validate the primary wireless banner should display on the top of task
    Then User validate the selected LCON data should dispaly in "Request Cellular Site Survey task"
      | Role Type                       | Contact Name    | Work Phone Number | Cell Phone Number | Fax Number | Email Address                   |
      | A End Local Contact - Primary   | Anistasia Bills | +1 832-766-6495     |                   |            | anistasia.bills@centurylink.com |
      | A End Local Contact - Secondary | Anistasia Bills | +1 832-766-6495     |                   |            | anistasia.bills@centurylink.com |
      #| Z End Local Contact - Primary   | Jackie Moran    |           2342456 |                   |            | jackie@gmail.com                |
      #| Z End Local Contact - Secondary | Jackie Moran    |           2342456 |                   |            | jackie@gmail.com                |
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Receive Cellular Site Survey of Cellular Internet Access" task
    And User validates that Task with task name "Receive Cellular Site Survey" is getting displayed
    When User clicks on Manage Task link of "Receive Cellular Site Survey" task
    Then User validate the primary wireless banner should display on the top of task
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Enter Cellular IP of Cellular Internet Access" task
    And User validates that Task with task name "Enter Cellular IP" is getting displayed
    When User clicks on Manage Task link of "Enter Cellular IP" task
    Then User validate the primary wireless banner should display on the top of task
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Create PR Dispatch of Cellular Internet Access" task
    And User validates that Task with task name "Create PR Dispatch" is getting displayed
    When User clicks on Manage Task link of "Create PR Dispatch" task
    Then User validate the primary wireless banner should display on the top of task
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Coordinate Activation of Cellular Internet Access" task
    And User validates that Task with task name "Coordinate Activation" is getting displayed
    When User clicks on Manage Task link of "Coordinate Activation" task
    Then User validate the primary wireless banner should display on the top of task
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Pre-Activate Service of Cellular Internet Access" task
    And User validates that Task with task name "Pre-Activate Service" is getting displayed
    When User clicks on Manage Task link of "Pre-Activate Service" task
    Then User validate the primary wireless banner should display on the top of task
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Activate Service of Cellular Internet Access" task
    And User validates that Task with task name "Activate Service" is getting displayed
    When User clicks on Manage Task link of "Activate Service" task
    Then User validate the primary wireless banner should display on the top of task
    When User enters the activation result and fcd date required field in "Activate Service" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button  
    Then User search the "AUTO_CreateInventoryDesign" task in task reporting page
    When User clicks on manage Task link of "AUTO_CreateInventoryDesign" task
    Then User validate the "PrimaryWirelessValue-Y" value in "AUTO_CreateInventoryDesign" task of Cellular Access 
    When User clicks on Task Reporting tab at the top of the page
    And User navigates back to the first page of task reporting page
    Then User validates the results grid and completes all the available tasks in task reporting
    Examples: 
      | ID        |
      | 552209727 |
      
    #Schedule Pre-Activation is not present in workflow
    #Then User validates results grid and completes all the tasks upto "Schedule Pre-Activation of Cellular Internet Access" task
    #And User validates that Task with task name "Schedule Pre-Activation" is getting displayed
    #When User clicks on Manage Task link of "Schedule Pre-Activation" task
    #Then User validate the primary wireless banner should display on the top of task
    #When User enters required details
    #And User clicks on Save and Complete button to complete the task
    #And User clicks on Refresh button