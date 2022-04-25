@Regression
Feature: Regression Testing

  @Network 
  @GETTNF-7099
  Scenario Outline: GETTNF-7099 -Electronics with Ring and Site Survey(1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And Move to Network Order sub tab under domain criteria
    And User enters the "<Network Order ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "Make Available of  " task
    And User validates that Task with task name "Make Available" is getting displayed
    When User clicks on Manage Task link of "Make Available" task
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button

    Examples: 
      | Network Order ID |
      | N721614          |

  @Network1 
  @GETTNF-7243
  Scenario Outline: GETTNF-7243 -Add missing product types to Network Order search (1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User selects the "Relative Date" option in create Date dropdown and enters the relative date
      | Relative Date |
      | Past 30 Days  |
    And User selects the "Relative Date" option in complete Date dropdown and enters the relative date
      | Relative Date |
      | Past 30 Days  |
    And User clicks on Domain Criteria sub-tab
    And Move to Network Order sub tab under domain criteria
    And User select the "Project Types" under Solution Type/Project Type dropdown values
      | Project Types          |
      | Dark Fiber             |
      | Inside Wire            |
      | Building Add Expansion |
    And User clicks on search button
    Then User validates the results grid with the project type

    Examples: 
      | ID       |
      | N721613  |

  @Regression3
  Scenario Outline: QS
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And Move to QuickStart Order sub tab under Orders Page
    And User selects the "Request Id" and enters the "<QuickStart Order ID>"
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And Move to QuickStart Order sub tab under domain criteria
    And User enters the "<QuickStart Order ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | QuickStart Order ID |
      |         19004464997 |

  