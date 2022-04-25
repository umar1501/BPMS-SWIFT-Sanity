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

  @Regression3
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

  @Regression6
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
    And user validate the tasks should get completed before Develop and Deploy Config task spwaned in task reporting
      | Assign IP Request        |
      | Gather Order Details TDE |
      | Complete Design          |
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | 552003813 |

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

  @Regression8
  Scenario Outline: GETTNF-7142 or GETENF-57740,GETTNF-7137 or GETENF-57788-EBAS with Primary Cellular-Add LCON data to Request Cellular Site Survey task (2)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    #Then User validates the Order Status as "Accepted"
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
      | A End Local Contact - Primary   | Anistasia Bills | 303-566-5829      |                   |            | anistasia.bills@centurylink.com |
      | A End Local Contact - Secondary | Anistasia Bills | 303-566-5829      |                   |            | anistasia.bills@centurylink.com |
      | Z End Local Contact - Primary   | Jackie Moran    |           2342456 |                   |            | jackie@gmail.com                |
      | Z End Local Contact - Secondary | Jackie Moran    |           2342456 |                   |            | jackie@gmail.com                |
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
    Then User validates results grid and completes all the tasks upto "Schedule Pre-Activation of Cellular Internet Access" task
    And User validates that Task with task name "Schedule Pre-Activation" is getting displayed
    When User clicks on Manage Task link of "Schedule Pre-Activation" task
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
    When User enters required details
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    #Pending Part
    #Then User search the "AUTO_CreateInventoryDesign" task in task reporting page
    #When User clicks on Manage Task link of "AUTO_CreateInventoryDesign" task
    #Then User validate the "PrimaryWirelessValue-Y" value in "AUTO_CreateInventoryDesign" task of Cellular Access
    #When User clicks on Task Reporting tab at the top of the page
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 552047575 |

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

  @Regression10
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

  @Regression13
  Scenario Outline: GETTNF-10129 or GETENF-57727 GETTNF-21429 ,GETTNF-7219-SDWAN-Meraki-Passed(3)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type    | Product                   | Terminating Region Code |
      | Install      | Accepted     | New        | HC_SDWAN_CPE    | SD-WAN                    | NA                      |
      | Install      | Accepted     | New        | Transport       | Dedicated Internet Access | NA                      |
      | Install      | Accepted     | New        | Data            | Dedicated Internet Access | NA                      |
      | Install      | Accepted     | New        | CELLULAR_ACCESS | Cellular Internet Access  | NA                      |
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then User validates results grid and completes all the tasks upto "AUTO_Meraki_Init of CPE Package" task
    And User validates that Task with task name "AUTO_Meraki_Init" is getting displayed
    When User clicks on Manage Task link of "AUTO_Meraki_Init" task
    Then User validate the following attributes in "AUTO_Meraki_Init" task
      | TaskDetailsValue     |
      | ServiceOrderID       |
      | ServiceID;           |
      | ServiceOrder Version |
      | autopilotTaskStatus  |
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto "AUTO_Meraki_Logistics of CPE package" task
    And User validates that Task with task name "AUTO_Meraki_Logistics" is getting displayed
    When User clicks on Manage Task link of "AUTO_Meraki_Logistics" task
    Then User validate the Static IP and Wireless IMEI is optional atrribute in "AUTO_Meraki_Logistics" task
    Then User validate the device name field should accept max length character in task detail page
    And user validate the mandatory device Name field should allow 256 character
    And User clicks on Save and Complete button to complete the task
    And User clicks on Refresh button
    Then User validates results grid and completes all the tasks upto " AUTO_Meraki_Activation task of CPE package" task
    And User validates that Task with task name "AUTO_Meraki_Activation" is getting displayed
    When User clicks on Manage Task link of "AUTO_Meraki_Activation" task
    And User clicks on Task Reporting tab at the top of the page
    Then User validates the results grid and completes all the available tasks in task reporting

    Examples: 
      | ID        |
      | 551276618 |

  @Regression14
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
    Then User validates results grid and completes all the tasks upto " of Access - On Net" task
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

  @Regression16
  Scenario Outline: HSIP Wavelength Onnet-#Passed (1)
    Given User Launches BPMS Portal and logs in as "Rajneesh" with valid credentials
    When User clicks on Orders tab at the top of the page
    And User fetch the orderId from database "<ID>"
    And User selects Customer Order sub-tab under Search Criteria
    And User selects "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
    Then Results Grid is displayed with details
    And User validates Results Grid with following data for ID
      | Order Action | Order Status | Order Type | Service Type      | Product                         | Terminating Region Code |
      | Add          | Accepted     | New        | Transport-or-Data | HSIP Wavelength-or-HSIP Service | NA                      |
      | Add          | Accepted     | New        | Data-or-Transport | HSIP Wavelength-or-HSIP Service | NA                      |
    When User clicks on Task Reporting tab at the top of the page
    And User selects "All" for Task Status under Common Criteria sub-tab
    And User select dependency task filter as "No" and automation task filter as "No"
    And User clicks on Domain Criteria sub-tab
    And User selects Search On Id as "Customer Order Id" and enters the "<ID>"
    And User clicks on search button
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

  @Regression25
  Scenario Outline: GETENF-58664 TC01- BPMS | AVS Premises Standalone order(1)
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
      | 552003250 |

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

  @Regression28
  Scenario Outline: GETTNF-23950 Managed Equipment-Support Switches and Wireless Access Point delivery(1)
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

  @Regression33
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
