@Regression
Feature: CMMC validation Testing

@CMMC
Scenario Outline: CMMC Validation
Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
When User Navigates to Orders Page
And User fetch the orderId from database "<ID>"
And User Enters Search Criteria with SearchOnIDType as "<Type Of ID>" and SearchOnID on Orders Page
And User clicks on search button
Then Results Grid is displayed with details
And User validates Results Grid with following data for ID
| Order Action | Order Status | Order Type | Service Type | Product | Product Component | Terminating Region Code |Customer Name|
| Install | Accepted | New | Transport-or-Data | Dedicated Internet Access | Access - On Net-or-IP Enhanced Services| NA |Q&O SRT Account|
| Install | Accepted | New | Data-or-Transport | Dedicated Internet Access | IP Enhanced Services-or-Access - On Net| NA |Q&O SRT Account|
When User clicks on Manage Order link against "Access - On Net" type
Then User validates the Customer Name in the Manage order page
|Customer Name|
|Q&O SRT Account|
Then User Navigates to Task Reporting Page
And User Selects Task Status Filter as "All"
And User Clicks on Domain Criteria Tab
And User Enters Search Criteria with SearchOnIDType as "<Type Of ID>" and SearchOnID on Task Reporting Page
And User clicks on search button
Then Results Grid is displayed with details
And User validates the Customer Name in the task reporting page
|Customer Name|
|Q&O SRT Account|
Then User validates results grid and completes all the tasks upto "Assign Design Request of Access - On Net" task
 When User clicks on Manage Task link of "Assign Design Request" task
 Then User validates the Customer Name in task details page
 |Customer Name|
 |Q&O SRT Account|
And User validates Results Grid and completes all the available tasks
Examples:
| Type Of ID |ID |
| Customer Order Id |552161148 |