
@BPMSSanity
Feature: BPMS sanity testing
 
    @DIA_Sanity
    Scenario Outline: End to end Validation from Swift to BPMS - DIA Sanity
    Given User logged in Swift in specified environment "<ENV>" with Account ID "<Account_ID>"
    When User creates the new order package 
    And User validates order package created by searching for order package ID
    And User search and select the following CLLI "<Clli>" and Product "<Product>"
    And User configures and saves the product "<AttributesList>"    
    And User updates the contact details "<Contact>"
    And User updates the order details and dates "<Order_Type>"
    Then User should validate and complete the tasks generated
    Given User Launches BPMS Portal and logs in as "Umar" with valid credentials
		When User Navigates to Orders Page
		And User fetch the sanity orderId from database
		And User Enters Search Criteria with SearchOnIDType as "<Type Of ID>" and SearchOnID on Orders Page
		And User clicks on search button
		Then Results Grid is displayed with details
		And User validates Results Grid with following data for ID
		| Order Action | Order Status | Order Type | Service Type | Product | Product Component | Terminating Region Code |Customer Name|
		| Install | Accepted | New | Transport-or-Data | Dedicated Internet Access | Access - On Net-or-IP Enhanced Services| NA |Q&O SRT Account|
		| Install | Accepted | New | Data-or-Transport | Dedicated Internet Access | IP Enhanced Services-or-Access - On Net| NA |Q&O SRT Account|
		Then User Navigates to Task Reporting Page
		And User Selects Task Status Filter as "All"
		And User Clicks on Domain Criteria Tab
		And User Enters Search Criteria with SearchOnIDType as "<Type Of ID>" and SearchOnID on Task Reporting Page
		And User clicks on search button
		Then Results Grid is displayed with details
	  And User validates Results Grid and completes all the available tasks
   

    Examples: 
     | Type Of ID        | ENV | Account_ID |  Clli   | Contact        | Order_Type | Product                  | AttributesList |
     | Customer Order Id |  1  | 5176906 	  | DNVTCO56| Anistasia Bills|  Install   | Dedicated Internet Acces | Circuit_Type:DS3;Port_Type:Flat Rate;InsideWiring:Extended Delivery - To the Customer Suite (Lumen Provided);| 
  