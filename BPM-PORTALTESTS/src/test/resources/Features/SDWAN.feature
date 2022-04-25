@Regression
Feature: Regression Testing

  @Regression4
  Scenario Outline: GETCWM-10326 and GETTNF-7261-HA Availibility On Access Indicator- #Passed(2)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the Order Status as "Accepted"
    When User clicks on Manage Order link against "Hybrid Connectivity" type
    Then User should have High availability flag as " "
    When User clicks on Manage Order link against "Broadband Internet Access" type
    #pending line
    Then User validate the number of static IPs attribute value
    Then User should have High availability flag as "Yes"
    When User clicks on Manage Order link against "Cellular Internet Access" type
    Then User should have High availability flag as "Yes"
    When User clicks on Manage Order link against "Dedicated Internet Access" type
    Then User should have High availability flag as "Yes"

    Examples: 
      | ID        |
      | 551067262 |

  @Regression5
  Scenario Outline: GETTNF-7232 ,GETTNF-7132-related PR Dispatch,GETTNF-7138- LCON,#and GETTNF-13996 (3)
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
    #Recieve Completion Notification
    Then User validates results grid and completes all the tasks upto "Receive Completion Notification of Broadband Internet Access" task
    And User validates that Task with task name "Receive Completion Notification" is getting displayed
    When User clicks on Manage Task link of "Receive Completion Notification" task
    Then User validate the new mandatory Gateway IP field added in task detail page
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    #CPE
    Then User validates results grid and completes all the tasks upto "Create PR Dispatch of CPE Package or Cellular Internet Access" task
    And User validates that Task with task name "Create PR Dispatch" is getting displayed
    When User clicks on Manage Task link of "Create PR Dispatch" task
    Then User validate the selected LCON information should display in Local Contacts section
      | Role Type                       | Contact Name    | Work Phone Number | Cell Phone Number | Fax Number | Email Address                   |
      | A End Local Contact - Primary   | Anistasia Bills | 303-566-5821      |                   |            | anistasia.bills@centurylink.com |
      | A End Local Contact - Secondary | Anistasia Bills | 303-566-5821      |                   |            | anistasia.bills@centurylink.com |
      | Z End Local Contact - Primary   | Anistasia Bills | 303-566-5821      |                   |            | anistasia.bills@centurylink.com |
      | Z End Local Contact - Secondary | Anistasia Bills | 303-566-5821      |                   |            | anistasia.bills@centurylink.com |
    And User validate the Product Family and PIID link in Related PR Dispatch section
    #|Product Family|
    #|HC_SDWAN_CPE  |
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    #Cellular
    Then User validates results grid and completes all the tasks upto "Create PR Dispatch of CPE Package or Cellular Internet Access" task
    And User validates that Task with task name "Create PR Dispatch" is getting displayed
    When User clicks on Manage Task link of "Create PR Dispatch" task
    Then User validate the selected LCON information should display in Local Contacts section
      | Role Type                       | Contact Name    | Work Phone Number | Cell Phone Number | Fax Number | Email Address                   |
      | A End Local Contact - Primary   | Anistasia Bills | 303-566-5821      |                   |            | anistasia.bills@centurylink.com |
      | A End Local Contact - Secondary | Anistasia Bills | 303-566-5821      |                   |            | anistasia.bills@centurylink.com |
      | Z End Local Contact - Primary   | Anistasia Bills | 303-566-5821      |                   |            | anistasia.bills@centurylink.com |
      | Z End Local Contact - Secondary | Anistasia Bills | 303-566-5821      |                   |            | anistasia.bills@centurylink.com |
    And User validate the Product Family and PIID link in Related PR Dispatch section
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates the results grid and completes all the available tasks in task reporting

  @Regression7
  Scenario Outline: GETCWM-10318-Add addition kit type selector for Large kit (1)
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
    Then User validates results grid and completes all the tasks upto "Create Boot Config of CPE Package" task
    And User validates that Task with task name "Create Boot Config" is getting displayed
    When User clicks on Manage Task link of "Create Boot Config" task
    Then validate the Large Kit type dropdown should display the following values
      | Large Kit Type       |
      |                      |
      | 10 GIG LR            |
      | 10 GIG LR + 1 GIG SM |
      | 10 GIG SR            |
      | 10 GIG SR + 1 GIG SM |
      | Copper Gig E         |
      | Custom               |
      | Optical Gig E MM     |
      | Optical Gig E SM     |
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Create PR Dispatch of CPE Package" task
    And User validates that Task with task name "Create PR Dispatch" is getting displayed
    When User clicks on Manage Task link of "Create PR Dispatch" task
    Then User validate that the selected Kit list "Large" value should display in create PR dispatch task
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003820 |

  
  @Regression9
  Scenario Outline: -Passed-GETTNF-7143-XL Device SD WAN device should dispaly the kit list dropdown(1)
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
    Then User validates results grid and completes all the tasks upto "Create Boot Config of CPE Package" task
    And User validates that Task with task name "Create Boot Config" is getting displayed
    When User clicks on Manage Task link of "Create Boot Config" task
    And User validate the XLarge SD WAN device should dispaly the kit list mandatory dropdown with below values
      | XLARGE KIT List               |
      |                               |
      | Custom                        |
      | SDWAN-2x10G2x1GXLMMF-10G-XX-R |
      | SDWAN-2x10G2x1GXLSMF-10G-XX-R |
      | SDWAN-2x10G4x1GXLMMF-10G-XX-R |
      | SDWAN-2x10G4x1GXLSMF-10G-XX-R |
      | SDWAN-2x10GXLMMF-10G-XX-R     |
      | SDWAN-2x10GXLSMF-10G-XX-R     |
      | SDWAN-2x1GXLMMF-1G-XX-R       |
      | SDWAN-2x1GXLSMF-1G-XX-R       |
      | SDWAN-4x10GXLMMF-10G-XX-R     |
      | SDWAN-4x10GXLSMF-10G-XX-R     |
      | SDWAN-4x1GLARGEMMF-1G-XX-R    |
      | SDWAN-4x1GXLSMF-1G-XX-R       |
      | SDWAN-XLCOPPER-1G-XX-R        |
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Create PR Dispatch of CPE Package" task
    And User validates that Task with task name "Create PR Dispatch" is getting displayed
    When User clicks on Manage Task link of "Create PR Dispatch" task
    Then User validate that the selected Kit list "XLarge" value should display in create PR dispatch task
    When User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003820 |

  @Regression11
  Scenario Outline: GETTNF-7194-Expand Vendor Order Id, GETTNF-7257-Activate,  GETTNF-7244-Internally Supported CPE-SDWAN-Medium-BIA_CIA_DIA(3)
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
    #GETTNf-7194
    Then User validates results grid and completes all the tasks upto "CaptureFOC of Broadband Internet Access" task
    When User clicks on Manage Task link of "CaptureFOC" task
    Then User validate the Vendor Order Id attribute should display in task details
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    #Review CPE Request-GETTNF-7244
    Then User validates results grid and completes all the tasks upto "Review CPE Request of CPE Package" task
    When User clicks on Manage Task link of "Review CPE Request" task
    Then User validate the internally supported CPE attribute should display in task details
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "Create PR Dispatch of Cellular Internet Access	" task
    When User clicks on Manage Task link of "Create PR Dispatch" task
    Then User validate the selected internally supported CPE value should display in task details
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    #GETTNF-7257
    Then User validates results grid and completes all the tasks upto "	ActivateSvc_AddlActivation_NA of CPE Package" task
    And User validates that Task with task name "ActivateSvc_AddlActivation_NA" is getting displayed
    When User clicks on Manage Task link of "ActivateSvc_AddlActivation_NA" task
    #Then User validate the task will open until all related access types are completed
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003820 |

  @Regression12
  Scenario Outline: GETTNF-7128-SDWAN with Spare Device Indicator (1)
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
    #Review SOW
    Then User validates results grid and completes all the tasks upto "Review SOW of CPE Package" task
    When User clicks on Manage Task link of "Review SOW" task
    Then User validate the spare device displays as a warning label above the Order information section
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    #Create PR Dispatch
    Then User validates results grid and completes all the tasks upto "Create PR Dispatch of CPE Package" task
    When User clicks on Manage Task link of "Create PR Dispatch" task
    Then User validate the spare device displays as a warning label above the Order information section
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    #Create Boot Config
    Then User validates results grid and completes all the tasks upto "Create Boot Config of CPE Package" task
    When User clicks on Manage Task link of "Create PR Dispatch" task
    Then User validate the spare device displays as a warning label above the Order information section
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    #Develop and Deploy Config
    Then User validates results grid and completes all the tasks upto "Develop and Deploy Config of CPE Package" task
    When User clicks on Manage Task link of "Create PR Dispatch" task
    Then User validate the spare device displays as a warning label above the Order information section
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003820 |

  @Regression18
  Scenario Outline: GETTNF-7118-Add a mandatory entry field Tenant Name in the DDC Task for Security Upgrade order (1)
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
    #GETTNF-7118
    Then User validates results grid and completes all the tasks upto "Develop And Deploy Config of CPE Package" task
    And User validates that Task with task name "Develop And Deploy Config" is getting displayed
    When User clicks on Manage Task link of "Develop And Deploy Config" task
    Then User validate the mandatory Tenant Name editable field added in the task
    When User enters required details
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

  @Regression20
  Scenario Outline: GETTNf-7199- BPMS | SDWAN | Ability to View All CPE Associated to a Customer Address-CradlePoint_cpePackageType(BB+CIA) (1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
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
    Then User validates results grid and completes all the tasks upto "Create PR Dispatch" task
    When User clicks on Manage Task link of "Create PR Dispatch" task
    Then User validate the CPE Package type in task details
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003820 |

  @Regression21
  Scenario Outline: GETTNF-7159 -Dmarc/CNS | Designate and collect discrete fields for dmarc components(1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
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
    Then User validates results grid and completes all the tasks upto "Install cross connect" task
    When User clicks on Manage Task link of "Install cross connect" task
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003820 |

  @Regression22
  Scenario Outline: GETTNF-19927- TC01- BPMS | AVS | SD-WAN related AVS Premises (603) Product Pkg Workflow - New install - Lite Ask- AVS with no HA (1)
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
      | 552003250 |

  @Regression23
  Scenario Outline: GETTNf-7287- SDWAN | TC_01-Add CNR Capability in Coordinate Activation for SDWAN CPE Package(1)
    Given User Launches BPMS Portal and logs in as "Sowmiya" with valid credentials
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
    Then User validates results grid and completes all the tasks upto "Coordinate Activation of CPE Package" task
    When User clicks on Manage Task link of "Coordinate Activation" task
    #	  Then User validate the CNR attribute in task details
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003820 |

  @Regression24
  Scenario Outline: GETTNF-7276 BPMS | SDWAN | CPE | Enable APAC task routing - NA Terminating (1)
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
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003820 |

  

  @Regression26
  Scenario Outline: GETTNF-32378 TC02- Test BPMS | SDWAN | Support Fortinet Vendor | Update Workflow- LA Global Region(1)
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

  @Regression27
  Scenario Outline: GETTNF-7192 TC01-| BE | Update Initiate BE task to remove human tasks(1)
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
    Then User validates results grid and completes all the tasks upto "AUTO_InitiateBuildingExtension" task
    And User validates that Task with task name "AUTO_InitiateBuildingExtension" is getting displayed
    Then User validate the Performer Name in task reporting page
    When User clicks on Manage Task link of "AUTO_InitiateBuildingExtension" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "AUTO_CompleteBuildingExtension" task
    And User validates that Task with task name "AUTO_CompleteBuildingExtension" is getting displayed
    Then User validate the Performer Name in task reporting page
    When User clicks on Manage Task link of "AUTO_CompleteBuildingExtension" task
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003820 |

 

  @Regression29
  Scenario Outline: GETTNF-21429 TC-01| Test BPMS | Meraki | Add MX68 device models to follow MX100 behavior(1)
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

  @Regression30
  Scenario Outline: GETTNF-7237 [Part 1] BPM | SDWAN | Cellular Access | Add EMEA Terminating Tasking(1)
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
      | Install      | Accepted     | New        | HC_SDWAN_CPE    | SD-WAN                   | CPE Package              | EU                      |
      | Install      | Accepted     | New        | CELLULAR_ACCESS | Cellular Internet Access | Cellular Internet Access | EU                      |
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

  @Regression31
  Scenario Outline: GETTNF-7227. GETTNF-7222 BPM | SD-WAN | Enable Change SDWAN - NA(2)
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
      | Change       | Accepted     | New        | HC_SDWAN_CPE     | SD-WAN                    | CPE Package               | NA                      |
      | Change       | Accepted     | New        | BROADBAND_ACCESS | Broadband Internet Access | Broadband Internet Access | NA                      |
      | Change       | Accepted     | New        | CELLULAR_ACCESS  | Cellular Internet Access  | Cellular Internet Access  | NA                      |
    When User clicks on Manage Order link
    And User validates the SalesRepRegion in order details tab
    And User clicks on Back link
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552003820 |

  @Regression32
  Scenario Outline: GETTNF-7190, GETTNF-7189 BPM | SD-WAN | Enable Change SDWAN-EU(2)
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
      | Change       | Accepted     | New        | HC_SDWAN_CPE     | SD-WAN                    | CPE Package               | EU                      |
      | Change       | Accepted     | New        | BROADBAND_ACCESS | Broadband Internet Access | Broadband Internet Access | EU                      |
      | Change       | Accepted     | New        | CELLULAR_ACCESS  | Cellular Internet Access  | Cellular Internet Access  | EU                      |
    When User clicks on Manage Order link
    And User validates the SalesRepRegion in order details tab
    And User clicks on Back link
    Then User Navigates to Task Reporting Page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
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

  
