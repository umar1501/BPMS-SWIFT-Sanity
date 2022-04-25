@Regression
Feature: Regression Testing

  @DIALATAM
  Scenario Outline: GETTNF-7277, or GETENF-57795 -DIA-DIA- LATAM-(2) #Passed
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product                   | Terminating Region Code |
      | Install      | Accepted     | New        | Transport    | Dedicated Internet Access | LA                      |
      | Install      | Accepted     | New        | Data         | Dedicated Internet Access | LA                      |
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
      | 551276618 |

  @Regression2
  Scenario Outline: GETTNF-7098-DIA-DIA with Manged Router LATAM (1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type    | Product                   | Terminating Region Code |
      | Install      | Accepted     | New        | Transport       | Dedicated Internet Access | LA                      |
      | Install      | Accepted     | New        | Data            | Dedicated Internet Access | LA                      |
      | Install      | Accepted     | New        | Managed Service | Dedicated Internet Access | LA                      |
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 551067262 |

  @DIA
  @GETTNF-7146
  Scenario Outline: GETTNF-7146-DIA_Onnet_GIGE(1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type      | Product                   | Terminating Region Code |
      | Install      | Accepted     | New        | Transport-or-Data | Dedicated Internet Access | NA                      |
      | Install      | Accepted     | New        | Data-or-Transport | Dedicated Internet Access | NA                      |
    #And User validates the product information as per the data entered in Order Entry System
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "Assign Installation Request of Access - On Net" task
    And User validate the tasks should get completed before "Assign Installation Request" task spwaned in task reporting
      | Develop and Deploy Config |
      | Complete Design           |
    Then User validates the results grid and completes all the available tasks in task reporting

  @DIA
  @GETTNF-7252
  Scenario Outline: GETTNF-7252-DIA_Offnet_GIGE (1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type      | Product                   | Terminating Region Code |
      | Install      | Accepted     | New        | Transport-or-Data | Dedicated Internet Access | NA                      |
      | Install      | Accepted     | New        | Data-or-Transport | Dedicated Internet Access | NA                      |
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "Activate Service of Access - Off Net" task
    And User validate the following tasks should not get spwaned in task reporting
      | Test NNI Logical Interface |
      | Assign IP Address          |
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003820 |

  @Regression15
  Scenario Outline: GETTNF-7108 or GETENF-57767-CPE workflow automation with CRUD (1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type   | Product                   | Terminating Region Code |
      | Install      | Accepted     | New        | Transport      | Dedicated Internet Access | LA                      |
      | Install      | Accepted     | New        | Data           | Dedicated Internet Access | LA                      |
      | Install      | Accepted     | New        | Managed Router | Dedicated Internet Access | LA                      |
    And User retrieves the service Id of "Access - On Net" component
    And User retrieves the service Id of "Managed Router" component
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto " Create NID and Assign WAN IP in CRUD of Access Package" task
    When User clicks on Manage Task link of "Create NID and Assign WAN IP in CRUD" task
    And user validates the task should display the Access SCID
    And User clicks on Save and Complete button to complete the task
    Then User validates results grid and completes all the tasks upto "Gather Order Details" task
    When User clicks on Manage Task link of "Gather Order Details" task
    And User clicks on Save and Complete button to complete the task
    Then User validates results grid and completes all the tasks upto "Create CPE and Assign WAN IP in CRUD of Managed Router Package" task
    When User clicks on Manage Task link of "Create CPE and Assign WAN IP in CRUD" task
    And user validates the task should display the CPE SCID
    And User clicks on Save and Complete button to complete the task
    Then User validates results grid and completes all the tasks upto "Activate Service of Access Package" task
    When User clicks on Manage Task link of "Activate Service" task
    And User clicks on Save and Complete button to complete the task
    Then User validates results grid and completes all the tasks upto "Generate NID Config of Access Package" task
    When User clicks on Manage Task link of "Generate NID Config" task
    And user validates the task should display the Access SCID
    And User clicks on Save and Complete button to complete the task
    Then User validates results grid and completes all the tasks upto "Generate Device Config of Managed Router Package" task
    When User clicks on Manage Task link of "Generate Device Config" task
    And user validates the task should display the CPE SCID
    And User clicks on Save and Complete button to complete the task
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003820 |

  @Regression17
  Scenario Outline: GETTNF-7103-Add Alt Shipping Address field to NID process(SDWAN_DIA) (1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type      | Product                   | Terminating Region Code |
      | Install      | Accepted     | New        | Transport-or-Data | Dedicated Internet Access | NA                      |
      | Install      | Accepted     | New        | Data-or-Transport | Dedicated Internet Access | NA                      |
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "Submit CPE Request of Access - On Net" task
    And User validates that Task with task name "Submit CPE Request" is getting displayed
    When User clicks on Manage Task link of "Submit CPE Request" task
    Then User validate that the new "Alt Shipping Address" field should display in "Submit CPE Request" task details page
    When User enters the Alt Shipping Address value
    And User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Create PR Dispatch of Access - On Net" task
    When User clicks on Manage Task link of "Create PR Dispatch" task
    And User validate the entered "Alt Shipping Address" should display in "Create PR Dispatch" task
    And User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003820 |

  @Regression19
  Scenario Outline: GETTNF-7196-Validate Perform End to End task should generate only after completing building extensions workflow (DIA_Offnet + NNI)(1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
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
    Then User validates results grid and completes all the tasks upto "Perform End to End Test" task
    And User validate the tasks should get completed before Perform End to End Test task spwaned in task reporting
      | AUTO: Initiate Building Extension -or- AUTO: Complete Building Extension |
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003820 |

  @Regression34
  Scenario Outline: GETTNF-19586-REDDIA Onnet #Passed (1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product                   | Terminating Region Code |
      | Install      | Accepted     | New        | Transport    | Dedicated Internet Access | NA                      |
      | Install      | Accepted     | New        | Data         | Dedicated Internet Access | NA                      |
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 551276618 |

  @Regression35
  Scenario Outline: GETTNF-32665- RED DIA Offnet #Passed (1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product                   | Terminating Region Code |
      | Install      | Accepted     | New        | Transport    | Dedicated Internet Access | NA                      |
      | Install      | Accepted     | New        | Data         | Dedicated Internet Access | NA                      |
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 551276618 |

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
