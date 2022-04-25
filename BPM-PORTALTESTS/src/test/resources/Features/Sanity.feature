@Sanity
Feature: Sanity Testing
@TEST_GETENF-57737
  Scenario Outline: TC01
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User Navigates to Orders Page
    And User fetch the sanity orderId from database
    And User Enters Search Criteria with SearchOnIDType as "<Type Of ID>" and SearchOnID on Orders Page
         And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type         | Product                   | Product Component                      | Terminating Region Code |
      | Install      | Accepted     | New        | Transport-or-Data    | Dedicated Internet Access | Access - On Net-or-IP Enhanced Services| NA                      |
      | Install      | Accepted     | New        | Data-or-Transport    | Dedicated Internet Access | IP Enhanced Services-or-Access - On Net| NA                      |
    Then User Navigates to Task Reporting Page
    And User Selects Task Status Filter as "All"
    And User Clicks on Domain Criteria Tab
    And User Enters Search Criteria with SearchOnIDType as "<Type Of ID>" and SearchOnID on Task Reporting Page
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid and completes all the available tasks
    Examples: 
      | Type Of ID        |ID       |
      | Customer Order Id |552390631-443856845|
    
   
  
      