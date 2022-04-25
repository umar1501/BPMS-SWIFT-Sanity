@Regression
Feature: Regression Testing

  @Regression36
  Scenario Outline: GETTNF-36080- Enchanced Search Module- add Country Code for Swift orders (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product                   | Terminating Region Code |
      | Install      | Accepted     | New        | Transport    | Dedicated Internet Access | LA                      |
      | Install      | Accepted     | New        | Data         | Dedicated Internet Access | LA                      |
    When User clicks on Enchanced Search tab at the top of the page
    And User clicks on Search sub-tab in EnchancedSearch Page
    And User clicks on Task Search subtab in Search subtab
    And User selects Search On Id in TaskSearch EnchancedSearch as "Customer Order Id" and enters the "<ID>"
    And User clicks on Task Search Go button
    Then User validate the CountryCode in task Search Result in Enchancedreporting page

    Examples: 
      | ID        |
      | 552003835 |