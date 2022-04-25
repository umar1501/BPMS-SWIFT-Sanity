@Regression
Feature: Regression Testing

  @HSIP_LA
  Scenario Outline: GETTNF-12848 or GETENF-57772 -HSIP- LATAM- #Passed(1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Status | Order Type | Service Type | Product         | Terminating Region Code |
      | Accepted     | New        | Transport    | HSIP Wavelength | LA                      |
      | Accepted     | New        | Data         | HSIP Service    | LA                      |
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User search the "AUTO_UpdateInventoryPath" task in task reporting page
    When User clicks on Manage Task link of "AUTO_UpdateInventoryPath" task
    Then User validate the following links url in "AUTO_UpdateInventoryPath" task details page
      | Links      |
      | XIME Link  |
      | DWDM Link  |
      | Radio Link |
    And User navigates back to the first page of task reporting page
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003820 |
      
      
      
       @HSIP
       @GETTNF-7113
  Scenario Outline: GETTNF-7113-Validate Develop and Deploy Config task should wait for below tasks to get completed (HSIP and PL)-Passed (1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "Yes" and automation task filter as "Yes"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "Develop And Deploy Config of HSIP Service" task
    And User validate the tasks should get completed before "Develop And Deploy Config" task spwaned in task reporting
      | Assign IP Request -or- Gather Order Details TDE -or- Complete Design|
    #And user validate the tasks should get completed before Develop and Deploy Config task spwaned in task reporting
      #| Assign IP Request        |
      #| Gather Order Details TDE |
      #| Complete Design          |
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | 552003813 |
      
      
   @TEST_CNSDITIE-4254
  Scenario Outline: Validate FCD should be CCD-2 if FCD/CCD is not falling on weekend/holiday 
    Given User Launches BPMS Portal and logs in as "Umar" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "Yes" and automation task filter as "Yes"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "Install Cross Connect of HSIP Cross Connect" task
    When User clicks on Manage Task link of "Install Cross Connect" task
    Then User validate FCD with CCD
    
  
    Examples: 
      | ID        | 
      | 552326280 |
      
  
      