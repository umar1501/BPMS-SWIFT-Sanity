Feature: Functionaltesting

  @Functional1
  Scenario Outline: GETTNF-19927 TC01- BPMS | AVS | SD-WAN related AVS Premises (603) Product Pkg Workflow - New install, GETENF-61209 (2)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type     | Product                            | Product Component                  | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE     | SD-WAN                             | Adaptive Virtual Services          | NA                      |
      | Install      | Accepted     | New        | BROADBAND_ACCESS | Broadband Internet Access          | Broadband Internet Access          | NA                      |
      | Install      | Accepted     | New        | HC_SDWAN_CPE     | Adaptive Virtual Services Premises | Adaptive Virtual Services Premises | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552049455 |

  @Functional02
  Scenario Outline: GETTNF-19927- TC02- BPMS | AVS | SD-WAN related AVS Premises (603) Product Pkg Workflow - New install - Lite Ask- AVS with HA (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type     | Product                            | Product Component                  | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE     | SD-WAN                             | Adaptive Virtual Services          | NA                      |
      | Install      | Accepted     | New        | BROADBAND_ACCESS | Broadband Internet Access          | Broadband Internet Access          | NA                      |
      | Install      | Accepted     | New        | HC_SDWAN_CPE     | Adaptive Virtual Services Premises | Adaptive Virtual Services Premises | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003802 |

  @Functional3
  Scenario Outline: GETENF-58664 , GETENF-61210 TC01- BPMS | AVS Premises Standalone order- env4 (2)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product                            | Product Component                  | Terminating Region Code |
      | Install      | Accepted     | New        | HC_UCPE      | Adaptive Virtual Services Premises | Adaptive Virtual Services Premises | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552051132 |

  @Functional4
  Scenario Outline: GETTNF-36273 Test BPM Portal | PROD | Hot Cut Attribute Addition(1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product | Product Component | Terminating Region Code |
      | Install      | Accepted     | New        | Transport    | (3) DIA | Access            | NA                      |
      | Install      | Accepted     | New        | Data         | (3) DIA | IP Port           | NA                      |
    When User clicks on Manage Order link
    Then User validates the HotCut Details in order details tab
    And User clicks on Back link

    Examples: 
      | ID       |
      | 1039WHSM |

  @Functional5
  Scenario Outline: GETENF-59143 TC01-Test BPM Portal | AVS Premises (uCPE) | Support new Product Family uCPE(1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product                            | Product Component                  | Terminating Region Code |
      | Install      | Accepted     | New        | HC_UCPE      | Adaptive Virtual Services Premises | Adaptive Virtual Services Premises | NA                      |
    When User clicks on Manage Order link
    Then User validates the Product Family in order details tab
    And User clicks on Back link

    Examples: 
      | ID        |
      | 552003250 |

  @Functional6
  Scenario Outline: GETENF-35058 TC-01|Test BPMS | SDWAN | SLM | Add Primary Director to SLM task- (NA Sold NA Terminated SecurityUpgarde-Yes) (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
      | Order Action | Order Status | Order Type | Service Type     | Product                   | Product Component         | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE     | SD-WAN                    | CPE Package               | NA                      |
      | Install      | Accepted     | New        | BROADBAND_ACCESS | Broadband Internet Access | Broadband Internet Access | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "AUTO_initiate_slm_setup" task
    When User clicks on Manage Task link of "AUTO_initiate_slm_setup" task
    Then User validate the Primary Director attribute in task details
    And User clicks on Refresh button
    And User validates Results Grid and completes all the available tasks

    Examples: 
      | ID        |
      | 551954617 |

  @Functional7
  Scenario Outline: GETTNF-24555 TC01- Test BPM Portal | Tibco WSDL Consumption for unbounded attributes- DIA (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product                   | Terminating Region Code |
      | Install      | Accepted     | New        | Transport    | Dedicated Internet Access | NA                      |
      | Install      | Accepted     | New        | Data         | Dedicated Internet Access | NA                      |
    When User clicks on Manage Order link
    Then User validates the TDG Data in order details tab
    And User clicks on Back link

    Examples: 
      | ID        |
      | 552003835 |

  @Functional8
  Scenario Outline: GETTNF-24556 TC02- Test BPM Portal | Tibco WSDL Consumption for unbounded attributes- DIA with MR, GETTNF-32265- REDDIA not qualified (2)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type   | Product                   | Terminating Region Code |
      | Install      | Accepted     | New        | Transport      | Dedicated Internet Access | NA                      |
      | Install      | Accepted     | New        | Data           | Dedicated Internet Access | NA                      |
      | Install      | Accepted     | New        | Managed Router | Dedicated Internet Access | NA                      |
    When User clicks on Manage Order link
    Then User validates the TDG Data in order details tab
    And User clicks on Back link

    Examples: 
      | ID        |
      | 552003835 |

  @Functional9
  Scenario Outline: GETTNF-30055 TC01- Test BPMS | SDWAN | Support Fortinet Vendor | Update Workflow- NA Global Region (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type     | Product                   | Product Component         | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE     | SD-WAN                    | SD-WAN                    | NA                      |
      | Install      | Accepted     | New        | BROADBAND_ACCESS | Broadband Internet Access | Broadband Internet Access | NA                      |
      | Install      | Accepted     | New        | BROADBAND_ACCESS | Broadband Internet Access | Broadband Internet Access | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003802 |

  @Functional10
  Scenario Outline: GETTNF-26901- TC-01|Test BPMS | SD-WAN | Related AVS Premises PRO Inventory | Template Changes (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type     | Product                            | Product Component                  | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE     | SD-WAN                             | Adaptive Virtual Services          | NA                      |
      | Install      | Accepted     | New        | BROADBAND_ACCESS | Broadband Internet Access          | Broadband Internet Access          | NA                      |
      | Install      | Accepted     | New        | HC_SDWAN_CPE     | Adaptive Virtual Services Premises | Adaptive Virtual Services Premises | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "Develop And Deploy Config" task
    And User validates that Task with task name "Develop And Deploy Config" is getting displayed
    When User clicks on Manage Task link of "Develop And Deploy Config" task
    Then User validate the Device PID present in task detail page
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Create PR Dispatch" task
    And User validates that Task with task name "Create PR Dispatch" is getting displayed
    When User clicks on Manage Task link of "Create PR Dispatch" task
    Then User validate the Device PID present in task detail page
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "AUTO_CreateInventoryCPE" task
    And User validates that Task with task name "AUTO_CreateInventoryCPE" is getting displayed
    When User clicks on Manage Task link of "AUTO_CreateInventoryCPE" task
    Then User validate the Device PID present in task detail page
    And User clicks on back To TaskReportingPage
    And User clicks on Refresh button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003802 |

  @Functional11
  Scenario Outline: GETTNF-34435 TC-01|Test BPMS | EWAS Workflow | CCD Changes against Install (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
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
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003869 |

  @Functional12
  Scenario Outline: GETTNF-33652 To check the L4_Install_EWAS template kicked on EWAS (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
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
    Then User validates results grid and completes all the tasks upto "AUTO_EWAS_Init" task
    And User validates that Task with task name "AUTO_EWAS_Init" is getting displayed
    When User clicks on Manage Task link of "AUTO_EWAS_Init" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "AUTO_EWAS_Logistics" task
    And User validates that Task with task name "AUTO_EWAS_Logistics" is getting displayed
    When User clicks on Manage Task link of "AUTO_EWAS_Logistics" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validate the Process Name kicked of in task reporting page
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003869 |

  @Functional13
  Scenario Outline: GETTNF-28494 TC01- Test BPMS | NGO | L4_Install_Transport | offnet -Refactor Network Activation to use AUTO task pattern-darkdeploy enable (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
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
    Then User validates results grid and completes all the tasks upto "AUTO_Activate_Network" task
    And User validates that Task with task name "AUTO_Activate_Network" is getting displayed
    When User clicks on Manage Task link of "AUTO_Activate_Network" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validate the Process Name kicked of in task reporting page
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003835 |

  @Functional14
  Scenario Outline: GETTNF-28495 TC02- Test BPMS | NGO | L4_Install_Transport | Refactor Network Activation to use AUTO task pattern-darkdeploy disable (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
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
    Then User validates results grid and completes all the tasks upto "Activate task" task
    And User validate the following tasks should not get spwaned in task reporting
      | AUTO_Activate_Network |
    And User validates Results Grid and completes all the available tasks

    Examples: 
      | ID        |
      | 552003835 |

  @Functional15
  Scenario Outline: GETTNF-23949, GETTNF-23950 Managed Equipment-Support Switches and Wireless Access Point delivery (2)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product           | Product Component | Terminating Region Code |
      | Install      | Accepted     | New        | HC_MES       | Managed Equipment | Managed Equipment | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552047603 |

  @Functional16
  Scenario Outline: GETTNF-22459 Meraki | Add  MX67W device models to follow MX100 behavior (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type    | Product                  | Product Component        | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE    | SD-WAN                   | CPE Package              | NA                      |
      | Install      | Accepted     | New        | CELLULAR_ACCESS | Cellular Internet Access | Cellular Internet Access | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003947 |

  @Functional17
  Scenario Outline: GETTNF-21429 Meraki | Add MX68 device models to follow MX100 behavior (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type    | Product                  | Product Component        | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE    | SD-WAN                   | CPE Package              | NA                      |
      | Install      | Accepted     | New        | CELLULAR_ACCESS | Cellular Internet Access | Cellular Internet Access | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003947 |

  @Functional18
  Scenario Outline: GETTNF-24835-Customer Digital TDG | AUTO_ManageTDG | Add Customer TDG Response dataslot and adjust perform logic- DIA (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
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
    Then User validates results grid and completes all the tasks upto "AUTO_ManageTDG" task
    And User validates that Task with task name "AUTO_ManageTDG" is getting displayed
    Then User validate the Performer Name in task reporting page
    When User clicks on Manage Task link of "AUTO_ManageTDG" task
    Then User validate InternalTDGRequired dataslot present in task detail page
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Gather Order Details TDE" task
    And User validates that Task with task name "Gather Order Details TDE" is getting displayed
    When User clicks on Manage Task link of "Gather Order Details TDE" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552048453 |

  @Functional19
  Scenario Outline: GETTNF-24836-Customer Digital TDG | AUTO_ManageTDG | Add Customer TDG Response dataslot and adjust perform logic- REDDIA (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
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
    Then User validates results grid and completes all the tasks upto "AUTO_ManageTDG" task
    And User validates that Task with task name "AUTO_ManageTDG" is getting displayed
    Then User validate the Performer Name in task reporting page
    When User clicks on Manage Task link of "AUTO_ManageTDG" task
    Then User validate InternalTDGRequired dataslot present in task detail page
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Gather Order Details TDE" task
    And User validates that Task with task name "Gather Order Details TDE" is getting displayed
    When User clicks on Manage Task link of "Gather Order Details TDE" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552048453 |

  @Functional20
  Scenario Outline: GETTNF-25527  Meraki Switches | Order Complete Notification is not sent to OE (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product           | Product Component | Terminating Region Code |
      | Install      | Accepted     | New        | HC_MES       | Managed Equipment | Managed Equipment | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552047603 |

  @Functional21
  Scenario Outline: GETTNF-32378 TC01- Test BPMS | SDWAN | Support Fortinet Vendor | Update Workflow- LA Global Region (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type     | Product                   | Product Component         | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE     | SD-WAN                    | SD-WAN                    | LA                      |
      | Install      | Accepted     | New        | BROADBAND_ACCESS | Broadband Internet Access | Broadband Internet Access | LA                      |
      | Install      | Accepted     | New        | BROADBAND_ACCESS | Broadband Internet Access | Broadband Internet Access | LA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003802 |

  @Functiona22
  Scenario Outline: GETTNF-29948- TC01- BPMS | AVS | SD-WAN related AVS Premises (603) Product Pkg Workflow - New install (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type     | Product                            | Product Component                  | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE     | SD-WAN                             | Adaptive Virtual Services          | NA                      |
      | Install      | Accepted     | New        | BROADBAND_ACCESS | Broadband Internet Access          | Broadband Internet Access          | NA                      |
      | Install      | Accepted     | New        | HC_SDWAN_CPE     | Adaptive Virtual Services Premises | Adaptive Virtual Services Premises | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003802 |

  @Functional23
  Scenario Outline: GETTNF-35080 TC-01|Test IPVPN|BPMS|Wait Static IPs task incorrect place in workflow, GETTNF-28388 (2)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
      | Order Action | Order Status | Order Type | Service Type     | Product                   | Product Component         | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE     | SD-WAN                    | CPE Package               | NA                      |
      | Install      | Accepted     | New        | BROADBAND_ACCESS | Broadband Internet Access | Broadband Internet Access | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "Review SOW" task
    And User validate the tasks should get completed before Review SOW task spwaned in task reporting
      | Waiting for Static IPs |
    Then User validates results grid and completes all the tasks upto "Develop And Deploy Config" task
    And User validates that Task with task name "Develop And Deploy Config" is getting displayed
    When User clicks on Manage Task link of "Develop And Deploy Config" task
    Then User validate the additional dropdownvalues in Primary Director in task detail page
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    And User validates Results Grid and completes all the available tasks

    Examples: 
      | ID        |
      | 552053607 |

  @Functional24
  Scenario Outline: GETTNF-34251 BPMS | SDWAN | Logistics task routing issue- NA Sold NA Terminating (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type     | Product                   | Product Component         | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE     | SD-WAN                    | CPE Package               | NA                      |
      | Install      | Accepted     | New        | BROADBAND_ACCESS | Broadband Internet Access | Broadband Internet Access | NA                      |
      | Install      | Accepted     | New        | CELLULAR_ACCESS  | Cellular Internet Access  | Cellular Internet Access  | NA                      |
    When User clicks on Manage Order link
    And User validates the SalesRepRegion in order details tab
    And User clicks on Back link
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "Raise SDWAN Order" task
    And User validates that Task with task name "Raise SDWAN Order" is getting displayed
    Then User validate the Performer Name in task reporting page
    When User clicks on Manage Task link of "Raise SDWAN Order" task
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validate the Performer Name in task reporting page
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003820 |

  @Functional25
  Scenario Outline: GETENF-62099 TC01-Test BPMS | PROD | Increase 'Project ID' field size - DIA (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product | Terminating Region Code |
      | Install      | Accepted     | New        | Transport    | (3) DIA | NA                      |
      | Install      | Accepted     | New        | Data         | (3) DIA | NA                      |
    When User clicks on Manage Order link
    Then User validates the ProjectGroupId in order details tab
    And User clicks on Back link

    Examples: 
      | ID       |
      | 1041HCWB |

  @Functional26
  Scenario Outline: GETENF-61391 TC01- Test BPMS | SD-WAN Versa | Hand off to AutoPilot for Global (other than NA Terminated) case of SD-WAN CPE or AVS order- EU terminated(1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type     | Product                   | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE     | SD-WAN                    | EU                      |
      | Install      | Accepted     | New        | BROADBAND_ACCESS | Broadband Internet Access | EU                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "AUTO_Versa_Init" task
    And User validates that Task with task name "AUTO_Versa_Init" is getting displayed
    When User clicks on Manage Task link of "AUTO_Versa_Init" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "AUTO_Versa_Logistics" task
    And User validates that Task with task name "AUTO_Versa_Logistics" is getting displayed
    When User clicks on Manage Task link of "AUTO_Versa_Logistics" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validate the Process Name kicked of in task reporting page
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552050899 |

  @Functional27
  Scenario Outline: GETENF-61393 TC01- Test BPMS | SD-WAN Versa | Hand off to AutoPilot for Global (other than NA Terminated) case of SD-WAN CPE or AVS order-LA terminated(1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type     | Product                   | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE     | SD-WAN                    | LA                      |
      | Install      | Accepted     | New        | BROADBAND_ACCESS | Broadband Internet Access | LA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "AUTO_Versa_Init" task
    And User validates that Task with task name "AUTO_Versa_Init" is getting displayed
    When User clicks on Manage Task link of "AUTO_Versa_Init" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "AUTO_Versa_Logistics" task
    And User validates that Task with task name "AUTO_Versa_Logistics" is getting displayed
    When User clicks on Manage Task link of "AUTO_Versa_Logistics" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validate the Process Name kicked of in task reporting page
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552050919 |

  @Functional28
  Scenario Outline: GETENF-61392 TC02- Test BPMS | SD-WAN Versa | Hand off to AutoPilot for Global (other than NA Terminated) case of SD-WAN CPE or AVS order- AP terminated(1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type     | Product                   | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE     | SD-WAN                    | AP                      |
      | Install      | Accepted     | New        | BROADBAND_ACCESS | Broadband Internet Access | AP                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "AUTO_Versa_Init" task
    And User validates that Task with task name "AUTO_Versa_Init" is getting displayed
    When User clicks on Manage Task link of "AUTO_Versa_Init" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "AUTO_Versa_Logistics" task
    And User validates that Task with task name "AUTO_Versa_Logistics" is getting displayed
    When User clicks on Manage Task link of "AUTO_Versa_Logistics" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validate the Process Name kicked of in task reporting page
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552050513 |

  @Functional29
  Scenario Outline: GETTNF-24828-Add Create Entity task, GETTNF-32815, GETTNF-32816, GETTNF-32267, GETTNF-32264 (5)- REDDIA workflow
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
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
    Then User validates results grid and completes all the tasks upto "AUTO_NaaS_Create_Entity" task
    And User validates that Task with task name "NaaS_Create_Entity" is getting displayed
    When User clicks on Manage Task link of "NaaS_Create_Entity" task
    Then User validate the following attributes in "NaaS_Create_Entity" task
      | TaskDetailsValue     |
      | ServiceOrderID       |
      | ServiceID;           |
      | ServiceOrder Version |
      | autopilotTaskStatus  |
      | macdCode             |
      | isSuppOrder          |
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Validate and Test" task
    And User validates that Task with task name "Validate and Test" is getting displayed
    When User clicks on Manage Task link of "Validate and Test" task
    Then User validates the port service name and path service name in banner section
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    And User validates Results Grid and completes all the available tasks

    Examples: 
      | ID        |
      | 552003947 |

  @Functional30
  Scenario Outline: GETTNF-24721-Enable AUTO_ManageTDG (1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
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
    Then User validates results grid and completes all the tasks upto "AUTO_ManageTDG" task
    And User validates that Task with task name "ManageTDG" is getting displayed
    When User clicks on Manage Task link of "ManageTDG" task
    Then User validate the following attributes in "ManageTDG" task
      | TaskDetailsValue     |
      | ServiceOrderID       |
      | ServiceID;           |
      | ServiceOrder Version |
      | autopilotTaskStatus  |
      | macdCode             |
      | isSuppOrder          |
      | internalTDGRequired  |
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Default Config Validation" task
    And User validates that Task with task name "Default Config Validation" is getting displayed
    When User clicks on Manage Task link of "Default Config Validation" task
    Then User validate the following attributes in "Default Config Validation" task
      | TaskDetailsValue |
      | serviceNamePath  |
      | serviceNamePort  |
      | exitToBAU        |
    And User validates Results Grid and completes all the available tasks

    Examples: 
      | ID        |
      | 552003947 |

  @Functional31
  Scenario Outline: GETTNF-32661, GETTNF-32814 - -RED DIA Onnet& Offnet-Add LOV (2)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
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
    Then User validates results grid and completes all the tasks upto "Default Config Validation" task
    And User validates that Task with task name "Default Config Validation" is getting displayed
    When User clicks on Manage Task link of "Default Config Validation" task
    Then User validate the exit to BAU attributes in "Default Config Validation" task
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates Results Grid and completes all the available tasks

    Examples: 
      | ID        |
      | 552003947 |

  @Functional32
  Scenario Outline: GETTNF-24175-Add terminating region to R2O Auto tasks, GETTNF-26260 (2)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
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
    Then User validates results grid and completes all the tasks upto "AUTO_Ethernet_Order_Creation" task
    And User validates that Task with task name "AUTO_Ethernet_Order_Creation" is getting displayed
    When User clicks on Manage Task link of "AUTO_Ethernet_Order_Creation" task
    Then User validate the region code value in "AUTO_Ethernet_Order_Creation" task
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates Results Grid and completes all the available tasks

    Examples: 
      | ID        |
      | 552003947 |

  @Functional33
  Scenario Outline: GETENF-57763,GETTNF-26261 (2)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
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
    Then User validates results grid and completes all the tasks upto "AUTO_Design_Offnet_Segment" task
    And User validates that Task with task name "AUTO_Design_Offnet_Segment" is getting displayed
    When User clicks on Manage Task link of "AUTO_Design_Offnet_Segment" task
    Then User validate the region code value in "AUTO_Design_Offnet_Segment" task
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    And User validate the following tasks should not get spwaned in task reporting
      | AUTO_Ethernet_Order_Creation |
    Then User validates Results Grid and completes all the available tasks

    Examples: 
      | ID        |
      | 552003947 |

  @Functional34
  Scenario: GETENF-61299 (1)
    Given User launches BPMS portal and logged in as "Rajneesh" with valid credentials
    Then User validates the CMMC banner should display on top of page

  @Functional35
  Scenario Outline: GETTNF-34433 TC-01|Test BPM Portal | PROD | Display charge values in Tasks and Task Reporting (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product | Terminating Region Code |
      | Install      | Accepted     | New        | Transport    | (3) DIA | NA                      |
      | Install      | Accepted     | New        | Data         | (3) DIA | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID       |
      | 1041HCWB |

  @Functional36
  Scenario Outline: GETTNF-12437 TC02-Test BPMS | Meraki | Intake PortalID on AutoPilot task and present on Inventory task - MX100 (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type    | Product                  | Product Component        | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE    | SD-WAN                   | CPE Package              | NA                      |
      | Install      | Accepted     | New        | CELLULAR_ACCESS | Cellular Internet Access | Cellular Internet Access | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "AUTO_Versa_Logistics" task
    And User validates that Task with task name "AUTO_Meraki_Logistics" is getting displayed
    When User clicks on Manage Task link of "AUTO_Meraki_Logistics" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "AUTO_CreateInventoryCPE" task
    And User validates that Task with task name "AUTO_CreateInventoryCPE" is getting displayed
    When User clicks on Manage Task link of "AUTO_CreateInventoryCPE" task
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003947 |

  @Functional37
  Scenario Outline: GETTNF-12362 TC01-Test BPMS | Meraki | Intake PortalID on AutoPilot task and present on Inventory task - MX68CW (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type    | Product                  | Product Component        | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE    | SD-WAN                   | CPE Package              | NA                      |
      | Install      | Accepted     | New        | CELLULAR_ACCESS | Cellular Internet Access | Cellular Internet Access | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "AUTO_Versa_Logistics" task
    And User validates that Task with task name "AUTO_Meraki_Logistics" is getting displayed
    When User clicks on Manage Task link of "AUTO_Meraki_Logistics" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "AUTO_CreateInventoryCPE" task
    And User validates that Task with task name "AUTO_CreateInventoryCPE" is getting displayed
    When User clicks on Manage Task link of "AUTO_CreateInventoryCPE" task
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003947 |

  @Functional38
  Scenario Outline: GETTNF-24720-Enable AUTO_ManageTDG - Offnet (1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
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
    Then User validates results grid and completes all the tasks upto "AUTO_ManageTDG" task
    And User validates that Task with task name "ManageTDG" is getting displayed
    When User clicks on Manage Task link of "ManageTDG" task
    Then User validate the following attributes in "ManageTDG" task
      | TaskDetailsValue     |
      | ServiceOrderID       |
      | ServiceID;           |
      | ServiceOrder Version |
      | autopilotTaskStatus  |
      | macdCode             |
      | isSuppOrder          |
      | internalTDGRequired  |
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Default Config Validation" task
    And User validates that Task with task name "Default Config Validation" is getting displayed
    When User clicks on Manage Task link of "Default Config Validation" task
    Then User validate the following attributes in "Default Config Validation" task
      | TaskDetailsValue |
      | serviceNamePath  |
      | serviceNamePort  |
      | exitToBAU        |
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552056279 |

  @Functional39
  Scenario Outline: GETTNF-25775-RED DIA Onnet, GETTNF-32797, GETTNF-32770, GETTNF-33005, GETTNF-25780 #Passed (5)
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
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "AUTO_NaaS_Create_Port" task
    When User clicks on Manage Task link of "NaaS_Create_Port" task
    Then User validate the following attributes in "NaaS_Create_Port" task
      | Vendor VLAN |
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Default Config Validation" task
    And User validates that Task with task name "Default Config Validation" is getting displayed
    When User clicks on Manage Task link of "Default Config Validation" task
    Then User validate the exit to BAU attributes in "Default Config Validation" task
    And User select the Yes value in exit to BAU attributes
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "AUTO_NaaS_Create_Headless_DIA" task
    And User validates that Task with task name "AUTO_NaaS_Create_Headless_DIA" is getting displayed
    When User clicks on Manage Task link of "NaaS_Create_Headless_DIA" task
    Then User validates the port service name and path service name in banner section
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Gather Order Details" task
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 551276618 |

  @Functional40
  Scenario Outline: GETTNF-25526 (1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
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
    Then User validates results grid and completes all the tasks upto "Default Config Validation" task
    And User validates that Task with task name "Default Config Validation" is getting displayed
    When User clicks on Manage Task link of "Default Config Validation" task
    Then User validate the exit to BAU attributes in "Default Config Validation" task
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates Results Grid and completes all the available tasks

    Examples: 
      | ID        |
      | 552003947 |

  @Functional41
  Scenario Outline: GETTNF-34436,GETTNF-34095,GETTNF-29293,GETTNF-29203,GETTNF-29984,GETTNF-30857-LATAM QS Order (6)
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
    Then User validates results grid and completes all the tasks upto "Submit EAIM Request of  " task
    When User clicks on Manage Task link of "Submit EAIM Request" task
    Then User validates the EAIM Customer Name in the "Submit EAIM Request" task
    And User validate the client site or alternate site dropdown values in "Submit EAIM Request" task
    When User User selects the alternate site option in client site or alternate site dropdown
    Then User validates the PL and SL fields will be enabled
    When User selects the client site option in client site or alternate site dropdown
    Then User validates the PL and SL fields will be disabled
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "AUTO_GetLocationContactInfo_EAIM of  " task
    When User clicks on Manage Task link of "GetLocationContactInfo_EAIM" task
    Then User validates the EAIM Customer Name in the "GetLocationContactInfo_EAIM" task
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "AUTO_EAIM_OT_BPMS_Integration of  " task
    When User clicks on Manage Task link of "EAIM_OT_BPMS_Integration" task
    Then User validates the EAIM Customer Name in the "EAIM_OT_BPMS_Integration" task
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "EAIM Approval Intervention of  " task
    When User clicks on Manage Task link of "EAIM Approval Intervention" task
    Then User validate the cost of intervention field in "EAIM Approval Intervention" task
    Then User validate the no show dropdown values in "EAIM Approval Intervention" task
    And User selects the No value in no show dropdown
    Then User validates the Reason No show attributes is not required field
    Then User validate the below "<Attrubes>" with "<dropdown vales>" values in "EAIM Approval Intervention" task
      | Attributes Name     | Dropdown values   |
      | TECHNICAL REPORT    | 1. VERY GOOD      |
      | PROCEDURES          | 2. GOOD           |
      | TOOLS               | 3. SATISFACTORY   |
      | TECHNICAL KNOWLEDGE | 4. UNSATISFACTORY |
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | QuickStart Order ID |
      |         19004464997 |
      
      
       @Functional42
  Scenario Outline: GETTNF-34822 Red DIA | Enable Offnet | Create BE Dependency Decomposer (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product                   | Terminating Region Code |
      | Install      | Complete     | New        | Transport    | Dedicated Internet Access | NA                      |
      | Install      | Complete     | New        | Data         | Dedicated Internet Access | NA                      |
    When User clicks on Process Progression link of Data component in orders page
    And User clicks on Logic History in Process Progression page
    Then User validates the BEDependency Decomposer task 
    
     Examples: 
      | ID        |
      | 552056286 |
    
    
    
    @Functional43
  Scenario Outline: working Managed Equipment-Support Switches and Wireless Access Point delivery(1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User selects Customer Order sub-tab under Search Criteria
    And User fetch the orderId from database "<ID>"
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type | Product           | Product Component | Terminating Region Code |
      | Install      | Accepted     | New        | HC_MES       | Managed Equipment | Managed Equipment | NA                      |
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552047603 |
    
    
    
    
    
    
