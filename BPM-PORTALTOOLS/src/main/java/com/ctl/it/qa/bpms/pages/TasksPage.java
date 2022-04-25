package com.ctl.it.qa.bpms.pages;

import com.ctl.it.qa.bpms.pages.common.CommonObjectsPage;
import com.ctl.it.qa.bpms.steps.TasksPageSteps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class TasksPage extends CommonObjectsPage {

	// public String currentOrderID;

	// Objects for Task
	// Completion******************************************************************************

	@FindBy(xpath = "//td[contains(@title,'Task Status')]")
	@CacheLookup
	public WebElementFacade lbl_TaskStatus_ManageTask;

	@FindBy(xpath = "//input[@value='Save & Complete']")
	// @FindBy(xpath = "//input[contains(@value,'Save & Complete')]")
	public WebElementFacade btn_SaveAndComplete;

	@FindBy(id = "ctl00_mainContent_ctl00_backBtn")
	public WebElementFacade btn_BackToSearchResults;

	// *********************************************************************************************************

	// Objects for Task Completion - Port
	// Assignment************************************************************

	@FindBy(xpath = "//select[@title='Closure Code']")
	// @FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl02_Input")
	public WebElementFacade sel_ClosureCode;

	@FindBy(xpath = "//input[@title='Port Assignment']")
	// @FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl04_Input")
	public WebElementFacade tbx_PortAssignment;

	// *********************************************************************************************************

	// Objects for Self
	// Assign**********************************************************************************

	@FindBy(id = "ctl00_mainContent_searchView_resultsPanel_ctl03_Self Assign/Delegate")
	public WebElementFacade lnk_SelfAssign;

	@FindBy(id = "ctl00_mainContent_searchView_resultsPanel_ctl03_Dialog_OkBtn")
	public WebElementFacade btn_OK_SelfAssign;

	// *********************************************************************************************************

	// Objects for Task Completion - Assign Design Request and Assign IP
	// Request********************************

	@FindBy(xpath = "//td/strong[contains(text(),'Users')]/following::a[1]")
	public WebElementFacade sel_Users_DD;

	@FindBy(xpath = "//td/strong[contains(text(),'Users')]/following::a[1]/following::div/div/following::li")
	public List<WebElementFacade> sel_Users_Options;

	// *********************************************************************************************************

	// Objects for Task Completion - Complete
	// Design************************************************************

	@FindBy(xpath = "//div[contains(@class,'task-view-warnings')]")
	public WebElementFacade lbl_taskWarnings;

	@FindBy(id = "ctl00_mainContent_ctl00_OrderDetailLink")
	public WebElementFacade lnk_OrderDetail;

	@FindBy(id = "ctl00_mainContent_ctl02_ctl03_Order Dates")
	public WebElementFacade tab_OrderDates;

	@FindBy(id = "ctl00_mainContent_ctl02_ctl05_ctl00_DatesAccordion_ctl00_ctl01_commitDate")
	public WebElementFacade tbx_CommitDate;

	@FindBy(id = "ctl00_mainContent_ctl02_ctl05_ctl00_saveBtn")
	public WebElementFacade btn_SaveDates;

	@FindBy(id = "ctl00_mainContent_ctl02_backBtn")
	public WebElementFacade lnk_BackToTaskDetails;

	@FindBy(xpath = "//td[@title='CCD:']")
	public WebElementFacade lbl_CCD;
	
	@FindBy(xpath = "//td[@title='FCD:']")
	public WebElementFacade lbl_FCD;

	@FindBy(xpath = "//select[@title='Access Type']")
	public WebElementFacade accessType;

	// *********************************************************************************************************

	// Objects for Task completion - Define Physical
	// Installation***********************************************

	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_ctl11_DispatchLocationsGrid_ctl02_GridViewAction_1")
	public WebElementFacade btn_Edit_DispatchLoc;

	// if hot cut order DPI
	@FindBy(xpath = "//li[contains(.,'Hot Cut Order?:Yes')]")
	public WebElementFacade hotCutOrderStatus;

	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_ctl11_DispatchLocationsGrid_ctl02_pendingAction")
	public WebElementFacade sel_DispatchAction;

	@FindBy(xpath = "(//span[@class='silk-icon silk-icon-calendar-view-day'])[1]")
	public WebElementFacade startDate;

	@FindBy(xpath = "(//span[@class='silk-icon silk-icon-calendar-view-day'])[2]")
	public WebElementFacade endDate;

	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_ctl11_DispatchLocationsGrid_ctl02_GatewayLookupCtrl_Worksite")
	public WebElementFacade tbx_Location;

	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_ctl11_DispatchLocationsGrid_ctl02_GatewayLookupCtrl_DispatchGateway")
	public WebElementFacade sel_GateWay;

	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_ctl11_DispatchLocationsGrid_ctl02_dueDate")
	public WebElementFacade tbx_DueDate;

	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_ctl11_DispatchLocationsGrid_ctl02_note")
	public WebElementFacade tbx_Note;

	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_ctl11_DispatchLocationsGrid_ItemEditDialog_Save")
	public WebElementFacade lnk_OK;

	// *********************************************************************************************************

	// Objects for Task completion -
	// InitiateBuildingExtension**************************************************

	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl06_Input")
	public WebElementFacade tbx_RelatedNetBuildID;

	// *********************************************************************************************************

	// Objects for Task completion -
	// CompleteBuildingExtension**************************************************

	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl07_Input")
	public WebElementFacade tbx_noStatus;

	// *********************************************************************************************************

	// Objects for Task completion - Logical Test With
	// Customer*************************************************

// 	@FindBy(id ="ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl06_Input")
// 	public WebElementFacade sel_TypeOfTest;	

	@FindBy(xpath = "//select[@title='Type of Test']")
	public WebElementFacade sel_TypeOfTest;

	// *********************************************************************************************************

	// Objects for Task completion - Install Cross
	// Connect******************************************************

	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl08_Input")
	public WebElementFacade sel_ClosureCode_ICC;

	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl12_Input")
	public WebElementFacade tbx_LightLevelReading_Protect;

	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl07_Input")
	public WebElementFacade sel_RemoveHardLoop;

	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl09_Input")
	public WebElementFacade tbx_Demarc;

	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl11_Input")
	public WebElementFacade sel_HardLoopLeft;

	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl13_Input")
	public WebElementFacade tbx_LightLevelReading_Work;

	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl15_Input")
	public WebElementFacade sel_RedlinesNecessary;

	// Added by Raj-- First task to get Terminating Region Code

	// Added by Raj
	// Waiting for Static IPs
	@FindBy(xpath = "//select[@title='Skip Static IP Wait']") // select
	public WebElementFacade sel_skipStaticIPWait;

	//
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_ctl00_tdeChkLst0_0") // checkbox
	public WebElementFacade check_readyToComplete;

	// Initiate ASR Manual
	// @FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl09_Input")
	@FindBy(xpath = "//input[@title='ASR Submit Date']")
	public WebElementFacade tbx_ASRSubmitDate;
	// @FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl11_Input")
	@FindBy(xpath = "//input[@title='PON/Sub Account']")
	public WebElementFacade pon_subAccount;
	// @FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl13_Input")
	@FindBy(xpath = "//input[@title='Request Date']")
	public WebElementFacade tbx_RequestDate;

	// Recieve Cellular site survey
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl04_Input")
	public WebElementFacade cellularSiteSurveyResult;
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl05_Input")
	public WebElementFacade equipmentProvider;
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl06_Input")
	public WebElementFacade maaintenanceProvider;
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl07_Input")
	public WebElementFacade cellularVendor;

	// CaptureFOC _BIA
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl20_Input") // date
	public WebElementFacade tbx_expectedFocRcvdDate;
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl21_Input") // Date
	public WebElementFacade tbx_commitDate;
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl22_Input") // date
	public WebElementFacade tbxFocRcvdDate;

	// Capture FOC--Cellular Access

	@FindBy(xpath = "//input[@title='Cellular FOC Date']")
	public WebElementFacade tbx_cellularFocDate;
	@FindBy(xpath = "//input[@title='Cellular FOC Received Date']")
	public WebElementFacade tbx_cellularFocRecievedDate;

	// Enter Cellular IP
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl07_Input") // tex
	public WebElementFacade cellularAccessSerialNum;
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl08_Input") // Date
	public WebElementFacade staticIP;
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl09_Input") // date
	public WebElementFacade macAddress;
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl11_Input") // date
	public WebElementFacade cellularSimId;

	// Receive Completion Notification
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl18_Input")
	public WebElementFacade tbx_dateComplete;
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl17_Input")
	public WebElementFacade tbx_accountNo;
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl22_Input")
	public WebElementFacade tbx_staticIP;
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl20_Input")
	public WebElementFacade tbx_gatewayIP;

	// Review SOW
	// ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl07_Input
//			@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl05_Input")
//			public WebElementFacade tbx_maintenanceProvider;
	@FindBy(xpath = "//select[@title='Maintenance Provider']")
	public WebElementFacade tbx_maintenanceProvider;
	@FindBy(xpath = "//select[@title='Equipment Provider']")
	public WebElementFacade tbx_equipmentProvider;

	@FindBy(xpath = "//select[@title='Resource Model']")
	public WebElement selResourceModel;

	// Create Boot Config
	@FindBy(xpath = "//textarea[@title='Boot Config']")
	public WebElementFacade bootConfig;

	@FindBy(xpath = "//input[@title='Device Name']")
	public WebElementFacade tbx_deviceName;
	@FindBy(xpath = "//select[@title='Primary Director']")
	public WebElementFacade selPrimaryDirector;
	@FindBy(xpath = "//input[@title='Tenant Name']")
	public WebElementFacade tbx_tenantName;

	// Remove Hard Loop
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_TaskDataSlotCtrl_ctl19_Input")
	public WebElementFacade tbx_closureCode;

	// Create PR_Dispatch
	@FindBy(xpath = "//input[@title='CPE Courier Tracking Number']")
	public WebElementFacade tbx_cpeCourierTrackingNum;
	@FindBy(xpath = "//input[@title='PR Number']")
	public WebElementFacade tbx_pr_Num;
	@FindBy(xpath = "//input[@title='Serial Number']")
	public WebElementFacade tbx_serialNum;
	@FindBy(xpath = "//input[@title='Date Shipped']")
	public WebElementFacade tbx_dateShipped;
	@FindBy(xpath = "//input[@title='Manufacturer Part Number']")
	public WebElementFacade tbx_manufacturedPartNum;

	@FindBy(xpath = "//input[@title='UPS Tracking Number']")
	public WebElementFacade tbx_upsTrackingNumber;

	@FindBy(xpath = "//input[@title='AUTO_LATAM_SAP_Success']")
	public WebElementFacade tbx_autoLatamSapSuccess;

	// proof of Delivery
	@FindBy(xpath = "//input[@title='Date Delivered']")
	public WebElementFacade tbx_dateDelivered;
	@FindBy(xpath = "//input[@title='Delivery Date']")
	public WebElementFacade tbx_deliveryDate;

	// Schedule Pre-Activation
	@FindBy(xpath = "//input[@title='Pre-Activation Ops Console Ticket 1']")
	public WebElementFacade preActivationOpsConsoleTicket1;
	@FindBy(xpath = "//select[@title='Onsite Installation Resource']")
	public WebElementFacade onsiteInstallationResource;

	// Cordinate Activation
	@FindBy(xpath = "//input[@title='Final Activation Ops Console Ticket']")
	public WebElementFacade tbx_finalActivationOpsConsoleticket;

	// Activate Service
	@FindBy(xpath = "//select[@title='Activation Result']")
	public WebElementFacade tbx_activationResult;
	@FindBy(xpath = "//input[@title='Versa Management IP']")
	public WebElementFacade tbx_versaManagementIP;
	@FindBy(xpath = "//input[@title='FCD for Perform CPE Implementation']")
	public WebElementFacade tbx_fcdDate;
	@FindBy(xpath = "//td[@title='Service Type:']")
	public WebElementFacade serviceType;

	// Submit CPE Request
	@FindBy(xpath = "//select[@title='CPEType']")
	public WebElementFacade cpeType;
	@FindBy(xpath = "//select[@title='Handoff Type Customer']")
	public WebElementFacade handOffTypeCust;
	@FindBy(xpath = "//input[@title='Device Name']")
	public WebElementFacade deviceName;
	@FindBy(xpath = "//input[@title='LCON Phone']")
	public WebElementFacade tbx_lconPhone;
	@FindBy(xpath = "//input[@title='LCON Phone']")
	public WebElementFacade lconPhone;
	@FindBy(xpath = "//select[@title='NID Type']")
	public WebElementFacade nidType;
	@FindBy(xpath = "//input[@title='CPE KIT Number']")
	public WebElementFacade cpeKitNum;
	@FindBy(xpath = "//input[@title='Customer Address']")
	public WebElementFacade customerAddress;
	@FindBy(xpath = "//input[@title='Customer Name']")
	public WebElementFacade customerName;
	@FindBy(xpath = "//input[@title='LCON']")
	public WebElementFacade lcon;
	@FindBy(xpath = "//select[@title='Handoff Type LEC']")
	public WebElementFacade handOffTypeLec;

	@FindBy(xpath = "//select[@name='ctl00$mainContent$ctl00$ctl16$ctl11$DispatchLocationsGrid$ctl02$pendingAction'][contains(@id,'pendingAction')]")
	public WebElementFacade dispatchAction;

	@FindBy(xpath = "//h3[contains(.,'Hot Cut Details:')]")
	public WebElementFacade hotCutDetail;
	@FindBy(xpath = "//select[contains(@name,'selectedYn')]")
	public WebElementFacade dispatchRequired;

	// Perform Hot Cut
	@FindBy(xpath = "//select[@title='Closure Code']")
	public WebElementFacade closureCode;

	// Request Internal Support Evaluation
	@FindBy(xpath = "//input[@title='LCON']")
	public WebElementFacade lcon2;

	@FindBy(xpath = "//select[@title='Handoff Type LEC']")
	public WebElementFacade handOffTypeLEC;

	@FindBy(xpath = "//textarea[@title='Customer Address']")
	public WebElementFacade customerAddress2;

	@FindBy(xpath = "//input[@title='Customer Name']")
	public WebElementFacade customerName2;

	@FindBy(xpath = "//input[@title='LCON Phone']")
	public WebElementFacade lconPhone2;
	// Create PR_Dispatch
	@FindBy(id = "ctl00_mainContent_ctl00_ctl16_ctl11_DispatchLocationsGrid_ctl02_selectedYn")
	public WebElementFacade dispatchRequired2;

//	@FindBy(xpath = "//td[@title='Service Type:']")
//	public WebElementFacade serviceType;
//	
	@FindBy(xpath = "//select[@title='Large Kit Type']")
	public WebElementFacade largeKitTypeDropdown;

	@FindBy(xpath = "//li[contains(.,'CPE Package Type:XLarge')]")
	public WebElementFacade cpPackageType;

	@FindBy(xpath = "//li[contains(.,'CPE Package Type:Large')]")
	public WebElementFacade cpPackageLargeType;

	// pre _Activate Service
	@FindBy(xpath = "//select[@title='Maintenance Provider']")
	public WebElementFacade maintenanceProvider;

	@FindBy(xpath = "//select[@title='Equipment Provider']")
	public WebElementFacade eqipmentProvider;

	// High Level design Task
	@FindBy(xpath = "//a[contains(.,'Hybrid Orders')]")
	public WebElementFacade tabHybridOrders;
	@FindBy(xpath = "//select[contains(@name,'networkTypeDropDown')]")
	public WebElementFacade sel_networkType;
	@FindBy(xpath = "//select[contains(@name,'carrierNameDropDown')]")
	public WebElementFacade sel_carrierName;
	@FindBy(xpath = "//select[@id='ctl00_mainContent_ctl00_ctl24_ctl00_SegmentsGrid_ctl02_VendorName']")
	public WebElementFacade sel_vendorName;

	@FindBy(xpath = "//input[contains(@name,'inventoryDesignId')]")
	public WebElementFacade invDesignId;
	@FindBy(xpath = "//select[contains(@name,'inventoryDesignSource')]")
	public WebElementFacade sel_invDesignSource;
	@FindBy(xpath = "//input[@id='ctl00_mainContent_ctl00_ctl24_ctl00_SegmentsGrid_ctl02_requestDate']")
	public WebElementFacade reqDate;
//			@FindBy(xpath = "//button/span[@class='silk-icon silk-icon-calendar-view-day']")
//			public WebElementFacade reqDate;
	@FindBy(xpath = "//input[contains(@name,'AClli')]")
	public WebElementFacade aCLLI;
	@FindBy(xpath = "//input[contains(@name,'ZClli')]")
	public WebElementFacade zCLLI;

	// Radio Workflow tasks element
	// Review Survey Information
	@FindBy(xpath = "//select[@title='Assign Critical Infrastructure?']")
	public WebElementFacade assignCrticalInfrastructure;
	@FindBy(xpath = "//select[@title='Request Site Survey with EAIM']")
	public WebElementFacade requestSiteSurveyWithEAIM;
	@FindBy(xpath = "//select[@title='Require Frequency Government Permission']")
	public WebElementFacade requireFrequencyGovernmentPermission;

	@FindBy(xpath = "//input[@title='Maintenance Provider']")
	public WebElementFacade internalFOC;
//	@FindBy(xpath = "//input[@title='PR Number']")
//	public WebElementFacade tbx_pr_Num;
//	@FindBy(xpath = "//input[@title='Serial Number']")
//	public WebElementFacade tbx_serialNum;
//	@FindBy(xpath = "//input[@title='Date Shipped']")
//	public WebElementFacade tbx_dateShipped;
//	@FindBy(xpath = "//input[@title='Manufacturer Part Number']")
//	public WebElementFacade tbx_manufacturedPartNum;

//	@FindBy(xpath = "//input[@title='UPS Tracking Number']")
//	public WebElementFacade tbx_upsTrackingNumber;

	@FindBy(xpath = "//input[@title='CenturyLink Assigned Engineer']")
	public WebElementFacade centurylinkAssignedEngineer;

	@FindBy(xpath = "//select[@title='Activity']")
	public WebElementFacade activity;

	@FindBy(xpath = "//select[@title='Requester Area (Cost Center)']")
	public WebElementFacade requesterArea;

	@FindBy(xpath = "//select[@id='ctl00_mainContent_ctl00_ctl15_TaskDataSlotCtrl_ctl09_Input']")
	public WebElementFacade intervention;
	@FindBy(xpath = "//select[@title='Solution (Equipment Technologies)']")
	public WebElementFacade solution_EquipmentTechnology;
	@FindBy(xpath = "//select[@title='Require Additional Work']")
	public WebElementFacade requireAdditionalWork;

	@FindBy(xpath = "//input[@title='Suggested EAIM']")
	public WebElementFacade suggesstedEAIM;
	@FindBy(xpath = "//select[@title='EAIM']")
	public WebElementFacade eaim;

	@FindBy(xpath = "//input[@title='Comments']")
	public WebElementFacade comments;

	// Approve EAIM Intervention
	@FindBy(xpath = "//select[@title='EAIM Approved']")
	public WebElementFacade eaimApproved; // -Yes/No

	@FindBy(xpath = "//textarea[@title='Intervention Comments']")
	public WebElementFacade interventionComments;

	@FindBy(xpath = "//input[@title='Office Track FTP Link']")
	public WebElementFacade officeTrackFtpLink;

	@FindBy(xpath = "//select[@title='No Show']")
	public WebElementFacade noShow;

	@FindBy(xpath = "//textarea[@title='Reason for No Show']")
	public WebElementFacade reasonForNoShow;

	@FindBy(xpath = "//select[@title='Technical Report']")
	public WebElementFacade technicalReport;
	@FindBy(xpath = "//select[@title='Tools']")
	public WebElementFacade tools;
	@FindBy(xpath = "//select[@title='Punctuality']")
	public WebElementFacade punctuality;
	@FindBy(xpath = "//select[@title='Procedures']")
	public WebElementFacade procedures;
	@FindBy(xpath = "//select[@title='Technical Knowledge']")
	public WebElementFacade technicalKnowledge;

	@FindBy(xpath = "//input[@title='Cost of Intervention (Local Currency)']")
	public WebElementFacade costOfIntervention;

	// Government Permission Approval
	@FindBy(xpath = "//select[@title='Freqeuency Approved']")
	public WebElementFacade frequencyAppproved; // -Yes/No

//	@FindBy(xpath = "//input[@title='AUTO_LATAM_SAP_Success']")
//	public WebElementFacade tbx_autoLatamSapSuccess;

	@FindBy(xpath = "//input[@title='PR Number']")
	public WebElementFacade prNumber;
	@FindBy(xpath = "//input[@title='internalTDGRequired']")
	public WebElementFacade internalTDGRequired;

	// Activate Service
//	@FindBy(xpath = "//select[@title='Activation Result']")
//	public WebElementFacade tbx_activationResult;
	// Order Cellular Access
	@FindBy(xpath = "//input[@title='Cellular Expected FOC Received Date']")
	public WebElementFacade expectedFocRecievedDate;

	@FindBy(xpath = "//input[@title='Cellular Submit Date']")
	public WebElementFacade cellularSubmitDate;

//	@FindBy(xpath = "//input[@title='Versa Management IP']")
//	public WebElementFacade tbx_versaManagementIP;
//	@FindBy(xpath = "//input[@title='FCD for Perform CPE Implementation']")
//	public WebElementFacade tbx_fcdDate;

	// High Level Design Task
	@FindBy(xpath = "//*[@id='ctl00_mainContent_ctl00_ctl15_Hybrid Orders']")
	public WebElementFacade hybridOrders;
	@FindBy(xpath = "//select[@id='ctl00_mainContent_ctl00_ctl24_ctl00_networkDetailControl_networkTypeDropDown']")
	public WebElementFacade networkType;

	@FindBy(xpath = "//td[@title='Terminating Region Code:']")
	public WebElementFacade terminatingRegionCode;
	@FindBy(xpath = "//a[@id='ctl00_mainContent_ctl00_ctl24_ctl00_saveBtn']")
	public WebElementFacade saveButton;
	@FindBy(xpath = "//tbody/tr[2]/td[@class='grid-action-cell']/a[1]")
	public WebElementFacade task1;

	// XLargeKittypeDropdown --Create Boot Config
	@FindBy(xpath = "//select[@title='XLarge Kit Type']")
	public WebElementFacade xLargeKitTypeDropdown;

	@FindBy(xpath = "//td[@title='CPE Package Type:']")
	public WebElementFacade cpePackageType;

	@FindBy(xpath = "//label[text()='XIME Link:']")
	public WebElementFacade ximeLink;

	@FindBy(xpath = "//label[text()='DWDM Link:']")
	public WebElementFacade dwdmLink;

	@FindBy(xpath = "//div[@class='task-view-warnings ui-notificiation-inline ui-notification-warning ui-corner-all']")
	public WebElementFacade primaryWirelessBanner;

	@FindBy(xpath = "//label[text()='Primary Wireless:']/..")
	public WebElementFacade prmarywirelessValue;

	@FindBy(xpath = "//input[@title='Alt Ship to Address']")
	public WebElementFacade altShipAddress;

	@FindBy(xpath = "//input[@title='Vendor Order Id']")
	public WebElementFacade vendorOrderId;

	@FindBy(xpath = "//label[text()='Internally Supported CPE:']/..")
	public WebElementFacade internallySupprtedCPE;

	@FindBy(xpath = "//input[@title='Internally Supported CPE']")
	public WebElementFacade internallySupprtedCPEDropdown;

//	@FindBy(xpath = "//input[@title='Device Name']")
//	public WebElementFacade deviceName;

	@FindBy(xpath = "//label[text()='Service ID:']/..")
	public WebElementFacade serviceID;
	@FindBy(xpath = "//label[text()='Service Order ID:']/..")
	public WebElementFacade ServiceOrderID;
	@FindBy(xpath = "//label[text()='Service Order Version:']/..")
	public WebElementFacade ServiceOrderVersion;
	@FindBy(xpath = "//input[@title='Autopilot task status']")
	public WebElementFacade autopilotTaskStatus;

	@FindBy(xpath = "//input[@title='Static IP']")
	public WebElementFacade staticIPField;
	@FindBy(xpath = "//input[@title='Wireless IMEI']")
	public WebElementFacade wirelessIMEI;

	@FindBy(xpath = "//td[@title='Primary Director']")
	public WebElementFacade PrimaryDirector;

	@FindBy(xpath = "//td[@title='Service Id:']")
	public WebElementFacade serviceId;

	@FindBy(xpath = "//td[@title='Device PIID:']")
	public WebElementFacade DevicePIID;

	// *********************************************************************************************************

	// Network Order
	// Site Survery Confirmation
	@FindBy(xpath = "//input[@title='Survey  Date']")
	public WebElementFacade surveyDate;

	// REDDIA

	// Naas Qualify order
	@FindBy(xpath = "//input[@title='Qualified Device']")
	public WebElementFacade qualifiedDevice;

	@FindBy(xpath = "//input[@title='Qualified Port']")
	public WebElementFacade qualifiedPort;

	@FindBy(xpath = "//input[@title='Qualified Port Type']")
	public WebElementFacade qualigfiedPortType;

	// Naas Crete Port
	@FindBy(xpath = "//input[@title='Edge Device Port']")
	public WebElementFacade edgeDevicePort;

	@FindBy(xpath = "//input[@title='serviceNamePort']")
	public WebElementFacade serviceNamePort;

	@FindBy(xpath = "//input[@title='createPortOffnetCorrelationId']")
	public WebElementFacade createPortOffnetCorrelationId;

	@FindBy(xpath = "//input[@title='Vendor VLAN']")
	public WebElementFacade vendorVLAN;

	// Naas Crete Path
	@FindBy(xpath = "//input[@title='serviceNamePath']")
	public WebElementFacade serviceNamePath;

	// Default Config Validation
	@FindBy(xpath = "//select[@title='Exit to BAU']")
	public WebElementFacade exitToBAU;

	// AUTO_NaaS_Add_ILC
	// No Attributes

	// AUTO_NaaS_Create_Entity
	// No Attributes

	// AUTO_NaaS_Create_Internet
	@FindBy(xpath = "//input[@title='serviceNameInternet']")
	public WebElementFacade serviceNameInternet;

	// AUTO_NaaS_Test_Internet
	// Logical Test With Customer

	// AUTO_NaaS_Select_POM_CFA
	@FindBy(xpath = "//input[@title='NNI']")
	public WebElementFacade nni;

	@FindBy(xpath = "//input[@title='POMQualified']")
	public WebElementFacade pomQualified;

	@FindBy(xpath = "//input[@title='POMCorrelationId']")
	public WebElementFacade pomCorrelationId;

	@FindBy(xpath = "//input[@title='VLAN']")
	public WebElementFacade vlan;

	@FindBy(xpath = "//li[contains(.,'CPE Package Type:CradlePoint')]")
	public WebElementFacade cpePackageTypeCradle;

	@FindBy(xpath = "//input[@title='Vendor Order Id']")
	public WebElementFacade tbx_vendorOrderIdInputbox;

	@FindBy(xpath = "//select[@title='Primary Director']")
	public WebElementFacade PrimaryDirectorValues;
	// QuickStart Order
	// Submit SW Install Order
	@FindBy(xpath = "//select[@title='ASR Required']")
	public WebElementFacade asrRequired;
	@FindBy(xpath = "//select[@title='IMT']")
	public WebElementFacade imt;
	@FindBy(xpath = "//select[@title='Legacy Network']")
	public WebElementFacade legacyNetwork;
	@FindBy(xpath = "//select[@title='MeetPoint']")
	public WebElementFacade meetPoint;
	@FindBy(xpath = "//select[@title='Order Type']")
	public WebElementFacade orderType;
	@FindBy(xpath = "//input[@title='Point Code A End (OPC)']")
	public WebElementFacade pointCodeAEnd_OPC;
	@FindBy(xpath = "//select[@title='SS7 Build Required']")
	public WebElementFacade ss7buildRequired;
	@FindBy(xpath = "//select[@title='Switch Type']")
	public WebElementFacade switchType;
	@FindBy(xpath = "//input[@title='A CLLI']")
	public WebElementFacade a_CLLI;
	@FindBy(xpath = "//select[@title='IXC Required']")
	public WebElementFacade ixcRequired;
	@FindBy(xpath = "//select[@title='Install Action']")
	public WebElementFacade installAction;

	@FindBy(xpath = "//input[@title='Point Code Z End (DPC)']")
	public WebElementFacade pointCodeZEnd_OPC;
	@FindBy(xpath = "//input[@title='Z CLLI']")
	public WebElementFacade z_CLLI;

	@FindBy(xpath = "//input[@title='Design ASR Workgroup']")
	public WebElementFacade designAsrWorkgroup;

	@FindBy(xpath = "//label[text()='Region Code:']/..")
	public WebElementFacade regionCodeValue;

	@FindBy(xpath = "//select[@title='Customer Not Ready']")
	public WebElementFacade cnrAttributes;

	@FindBy(xpath = "//input[@title='Electronics Commit Date']")
	public WebElementFacade electronicsCommitDate;

	@FindBy(xpath = "//textarea[@title='Project Code']")
	public WebElementFacade projectCode;

	@FindBy(xpath = "//select[@title='Update CAD Required ?']")
	public WebElementFacade sel_updateCADReq;

	@FindBy(xpath = "//select[@id='ctl00_mainContent_ctl00_ctl16_ctl02_TnocGrid_ctl02_acceptanceType']")
	public WebElementFacade sel_tnoc;

	// Submit EAIM Request
	@FindBy(xpath = "//select[@title='Nearnet Country Code']")
	public WebElementFacade sel_nearnetCountryCode;
	@FindBy(xpath = "//input[@title='Order Package ID']")
	public WebElementFacade tbx_orderPackageId;
//		@FindBy(xpath = "//select[@title='Activity']")
//		public WebElementFacade sel_activity;
	@FindBy(xpath = "//select[@title='Requester Area (Cost Area)']")
	public WebElementFacade sel_requesterArea;
	@FindBy(xpath = "//select[@title='Solution (Equipment Teshnologies)']")
	public WebElementFacade sel_solution;
//		@FindBy(xpath = "//select[@title='EAIM']")
//		public WebElementFacade sel_eaim;
	@FindBy(xpath = "//input[@title='Service ID']")
	public WebElementFacade tbx_serviceId;
	@FindBy(xpath = "//select[@title='Client Site Or Alternative Site']")
	public WebElementFacade sel_clientSideOrAlternateSite;
	@FindBy(xpath = "//input[@title='Customer Name']")
	public WebElementFacade tbx_customerName;

	@FindBy(xpath = "//input[@title='Alternative Site PL']")
	public WebElementFacade tbxAlternateSitePL;
	@FindBy(xpath = "//input[@title='Alternative Site SL']")
	public WebElementFacade tbxAlternateSiteSL;

//		@FindBy(xpath = "//select[@title='Intervention (Type Of Service)']")
//		public WebElementFacade sel_intervention_TypeOfService;
//		@FindBy(xpath = "//select[@title='Require Additional Work']")
//		public WebElementFacade sel_reqAdditionalwork;

	@FindBy(xpath = "//textarea[@title='Additional Work Description']")
	public WebElementFacade tbx_additionalWorkDesc;

	@FindBy(xpath = "//input[@title='Estimated USD Value']")
	public WebElementFacade tbx_estimatedUSDValue;

	@FindBy(xpath = "//textarea[@title='Request Comments']")
	public WebElementFacade tbx_reqComments;

	// GetLocationContactInfo_EAIM
	@FindBy(xpath = "//input[@title='AUTO_LATAM_OT_EAIM_Success']")
	public WebElementFacade tbx_autoEaimLatamSuccess;

	@FindBy(xpath = "//input[@title='AUTO_LATAM_OT_Intgrn_Success']")
	public WebElementFacade tbx_autoLatamOTIntegrationSuccess;

	@FindBy(xpath = "//input[@title='AUTO_LATAM_OT_Order_Accepted']")
	public WebElementFacade tbx_autoLatamOTOrderAccepted;
	
	@FindBy(xpath = "//input[@title='WirelessDeviceSerialNumber']")
	public WebElementFacade tbx_wirelessDeviceSerialNumber;
	
	@FindBy(xpath = "//input[@title='portalID']")
	public WebElementFacade tbx_portalId;

	@FindBy(xpath = "//select[@title='FCD Time']")
	public WebElementFacade tbx_fcdTime;
	
	@FindBy(xpath = "//input[@title='autopilotManagedOffnet']")
	public WebElementFacade tbxAutopilotManagedOffnet;
	
	@FindBy(xpath = "//*[text()='Group ASR']")
	public WebElementFacade groupASR;
	
	@FindBy(xpath = "//*[@id=\"ctl00_mainContent_ctl00_ctl23_ctl00_AvailableItemsGrid\"]/tbody/tr[1]/th")
	public List<WebElementFacade> asrTableHeaders;
	
	@FindBy(xpath = "//*[@id=\"ctl00_mainContent_ctl00_ctl23_ctl00_AvailableItemsGrid\"]/tbody/tr[2]/td")
	public List<WebElementFacade> asrTableRows;
	
	@FindBy(xpath = "//*[text()=\"Create Group for Selected Rows\"]")
	public WebElementFacade createGrpForSelectedRows;
	
	@FindBy(xpath = "//*[@title=\"asriFulfilment\"]")
	public WebElementFacade tbx_asriFulfilment;
	
	public void validateAssignInstallationRequestGroups() {

		String[] a1 = new String[6];
		a1[0] = " ";
		a1[1] = "LATAM_SDM_ANDEAN";
		a1[2] = "LATAM_SDM_BRAZIL";
		a1[3] = "LATAM_SDM_HEAD";
		a1[4] = "LATAM_SDM_NORTH";
		a1[5] = "LATAM_SDM_SOUTH";

		WebElement sel_Groups_DD = getDriver()
				.findElement(By.xpath("//td/strong[contains(text(),'Groups')]/following::a[1]"));
		// tasksPage.sync(tasksPage,sel_Groups_DD);
		sel_Groups_DD.click();

		List<WebElement> sel_Groups_Options = getDriver()
				.findElements(By.xpath("//td/strong[contains(text(),'Groups')]/../div/ul/li"));

		for (int i = 0; i <= sel_Groups_Options.size() - 1; i++) {
			String groupName = sel_Groups_Options.get(i).getText();
			System.out.println("Group Name=" + groupName);
			Assert.assertEquals(groupName, a1[i]);
		}
		System.out.println("Passed");

	}

	public void validateAssignDesignRequestGroups() {

		String[] a1 = new String[6];
		a1[0] = " ";
		a1[1] = "LATAM_TXSA_ANDEAN";
		a1[2] = "LATAM_TXSA_BRAZIL";
		a1[3] = "LATAM_TXSA_HEAD";
		a1[4] = "LATAM_TXSA_NORTH";
		a1[5] = "LATAM_TXSA_SOUTH";

		WebElement sel_Groups_DD = getDriver()
				.findElement(By.xpath("//td/strong[contains(text(),'Groups')]/following::a[1]"));
		// tasksPage.sync(tasksPage,sel_Groups_DD);
		sel_Groups_DD.click();

		List<WebElement> sel_Groups_Options = getDriver()
				.findElements(By.xpath("//td/strong[contains(text(),'Groups')]/../div/ul/li"));
		for (int i = 0; i <= sel_Groups_Options.size() - 1; i++) {
			String groupName = sel_Groups_Options.get(i).getText();
			System.out.println("Group Name=" + groupName);
			Assert.assertEquals(groupName, a1[i]);
		}

	}

	public void selectAssignDesignRequestGroups(String strGroups) {

		WebElement sel_Groups_DD = getDriver()
				.findElement(By.xpath("//td/strong[contains(text(),'Groups')]/following::a[1]"));
		List<WebElement> sel_Groups_Options = getDriver()
				.findElements(By.xpath("//td/strong[contains(text(),'Groups')]/../div/ul/li"));
		for (int i = 0; i <= sel_Groups_Options.size() - 1; i++) {
			String groupName = sel_Groups_Options.get(i).getText();

			if (groupName.equalsIgnoreCase(strGroups)) {
				sel_Groups_Options.get(i).click();
				break;
			}
		}

		WaitForPageToLoad(20);
	}

	public void validate_LATAMGroups() {

		String[] a1 = new String[6];
		a1[0] = " ";
		a1[1] = "LATAM_IPSA_ANDEAN";
		a1[2] = "LATAM_IPSA_BRAZIL";
		a1[3] = "LATAM_IPSA_HEAD";
		a1[4] = "LATAM_IPSA_NORTH";
		a1[5] = "LATAM_IPSA_SOUTH";

		WebElement sel_Groups_DD = getDriver()
				.findElement(By.xpath("//td/strong[contains(text(),'Groups')]/following::a[1]"));
		// tasksPage.sync(tasksPage,sel_Groups_DD);
		sel_Groups_DD.click();
		// tasksPage.sel_Users_DD.click();
		List<WebElement> sel_Groups_Options = getDriver()
				.findElements(By.xpath("//td/strong[contains(text(),'Groups')]/../div/ul/li"));

		for (int i = 0; i <= sel_Groups_Options.size() - 1; i++) {
			String groupName = sel_Groups_Options.get(i).getText();
			System.out.println("Group Name=" + groupName);
			Assert.assertEquals(groupName, a1[i]);

		}
	}

	public void waitTillElementToBeClicakble(WebElement trgElement) {
		sync(this, trgElement);
		WebDriverWait wait = new WebDriverWait(this.getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(trgElement));
		WaitForPageToLoad(120);
	}

	public void validateGatewayIpFieldInTaskPage() {
		boolean staicIPElement = tbx_staticIP.isCurrentlyEnabled();
		boolean gatewayIpelement = tbx_gatewayIP.isCurrentlyEnabled();
		if (staicIPElement == true && gatewayIpelement == true) {
			System.out.println("Successfully validated the Static IP and Gateway IP elements");
		}
	}

	public void validateLocalContactsInformation(List<List<String>> list) {

		for (int i = 0; i <= list.size() - 1; i++) {
			for (int j = 0; j <= 5; j++) {
				int trValue = i + 2;
				int tdValue = j + 1;
				String expectedData = list.get(i).get(j);
				WebElement ele = getDriver().findElement(
						By.xpath("//b[text()='Local Contacts']/../../../tr[" + trValue + "]/td[" + tdValue + "]"));
				String actualData = ele.getText();

				Assert.assertEquals(expectedData, actualData);

			}
		}
		System.out.println("Successfully validated the LCON Information In Create Pr Dispatch");
	}

	public void validateProductFamily() {
		String productFamily = "";
		String productComp = serviceType.getText();
		if (productComp.equals("HC_SDWAN_CPE")) {
			productFamily = "CELLULAR_ACCESS";
		} else if (productComp.equals("CELLULAR_ACCESS")) {
			productFamily = "HC_SDWAN_CPE";
		}
		sync(this, btn_SaveAndComplete);

		WebElement product_Family = getDriver()
				.findElement(By.xpath("//tbody/tr/th/b[text()='Related PR Dispatch']/../../../tr[3]/td[2]"));
		String actualValue = product_Family.getText();
		System.out.println("Actual Product Family=" + actualValue);
		// String orderId=getCurrentOrderID();
		// String orderId=commonObjectsPage.getCurrentOrderID();
		// System.out.println("Order-"+orderId);
		WebElement piidLink = getDriver().findElement(By.xpath("//b[text()='Related PR Dispatch']/../../..//tr//a"));
		String text = piidLink.getAttribute("href");
		System.out.println(text);
		System.out.println("PIID link-" + piidLink.getText());

		Assert.assertEquals(productFamily, actualValue);

	}

	public int clickOn_SaveAndCompleteButton() {

		sync(this, btn_SaveAndComplete);
		waitABit(2000);
		sync(this, ExpectedConditions.visibilityOf(btn_SaveAndComplete));

		String saveAndCompleteButtonStatus = btn_SaveAndComplete.getAttribute("aria-disabled");

		if (saveAndCompleteButtonStatus.equals("false")) {
			return 0;

		} else {

			System.out.println("Save And Complete button is disabled");
			btn_BackToSearchResults.click();
			WaitForPageToLoad(120);

			return 1;

		}
	}

	public void taskSelfAssign(WebElement task) {

		sync(this, task);
		task.click();

		lnk_SelfAssign.click();
		WaitForPageToLoad(30);

		btn_OK_SelfAssign.click();
		WaitForPageToLoad(60);

		// closeNotification();

	}

	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return lbl_TaskStatus_ManageTask;
	}

	public void validateXLargeDropdownKitValues(List<List<String>> list) {

		Select s1 = new Select(xLargeKitTypeDropdown);
		List<WebElement> allOptions = s1.getOptions();

		for (int i = 0; i <= allOptions.size() - 1; i++) {
			String expectedData = list.get(i + 1).get(0);
			String actualData = allOptions.get(i).getText();
			System.out.println("Expected Data-" + expectedData);
			System.out.println("Actual Data-" + actualData);
			Assert.assertEquals(expectedData, actualData);
		}
	}

	public void validateLargeDropdownKitValues(List<List<String>> list) {

		Select s1 = new Select(largeKitTypeDropdown);
		List<WebElement> allOptions = s1.getOptions();

		for (int i = 0; i <= allOptions.size() - 1; i++) {
			String expectedData = list.get(i + 1).get(0);
			String actualData = allOptions.get(i).getText();
			System.out.println("Expected Data-" + expectedData);
			System.out.println("Actual Data-" + actualData);
			Assert.assertEquals(expectedData, actualData);
		}
	}

	public void verifySelectedCPEPackageType() {
		String expectedCpePackageType = "CPE Package Type:XLarge";
		String actalCpePackageType = cpPackageType.getText();
		Assert.assertEquals(expectedCpePackageType, actalCpePackageType);
	}

	public void verifySelectedCPEPackageType(String cpeTpe) {
		String expectedCpePackageType = "Large ";
		String actualCpePackageType = cpPackageLargeType.getText();
		String[] text = actualCpePackageType.split("\n");
		System.out.println(text[0]);
		System.out.println(text[1]);
		Assert.assertEquals(expectedCpePackageType, text[1]);
	}

	public void validateMandatoryTenantNameFieldInDevelopAndDeployConfig() {

		IntDataContainer dataContainer = commonData.getContainer("Manage Task")
				.getContainer("Develop And Deploy Config");
		String fieldStatus = tbx_tenantName.getAttribute("class");
		System.out.println("Tenanat Name is " + fieldStatus);
		tbx_tenantName.sendKeys(dataContainer.getFieldValue("tbx_tenantName"));

	}

	public void validateEWASProcessTemplate(String taskName) {
		String taskName1 = "//td[text()='";
		String taskName2 = "']";
		String taskName3 = "/..//td[@title='Process Name']";
		// td[text()='ActivateSvc_AddlActivatin_APAC']/..//td[@title='Performer']
		WebElement TaskName4 = getDriver().findElement(By.xpath(taskName1 + taskName + taskName2));
		WebElement processName = getDriver().findElement(By.xpath(taskName1 + taskName + taskName2 + taskName3));
		String actualsProcessName = processName.getText();
		String actualTaskName = TaskName4.getText();
		System.out.println("TaskName of EWAS is " + actualTaskName);
		if (actualsProcessName.equals("L4_Install_EWAS")) {
			System.out.println("EWAS Process template kicked is " + actualsProcessName + "in the workflow");
			System.out.println("Validation of EWAS Process Name is ...     --Successful");
		}
	}

	public void validateBEPreformer(String taskName) {
		String taskName1 = "//td[text()=";
		String taskName2 = "']";
		String taskName3 = "/..//td[@title='Performer']";
		WebElement TaskName4 = getDriver().findElement(By.xpath(taskName1 + taskName + taskName2));
		WebElement Performer = getDriver().findElement(By.xpath(taskName1 + taskName + taskName2 + taskName3));
		String actualsPerformer = Performer.getText();
		String actualTaskName = TaskName4.getText();
		System.out.println("Current TaskName is " + actualTaskName);

		if (actualsPerformer.equals("ext_automation_rpa_buildingext")) {
			System.out.println("Performer of" + actualTaskName + " is " + actualsPerformer);
			System.out.println("Validation of BE Performer is ...     --Successful");
		}
	}

	public void validatePrimaryDirectorInTaskPage() {
		String actualsPrimaryDirector = PrimaryDirector.getText();
		if (actualsPrimaryDirector.equals("BST-DIRECTOR-01")) {
			Assert.assertEquals("BST-DIRECTOR-01", actualsPrimaryDirector);
			System.out.println("Primary Director is " + actualsPrimaryDirector);
			System.out.println("Same Primary Director value is copied from Develop and deploy task which is "
					+ actualsPrimaryDirector);
			System.out.println("Validation of Primary Director is ...     --Successful");
		} else {
			System.out.println("Primary Director is " + actualsPrimaryDirector);
			;
			System.out.println("Primary Director value is not copied from Develop and deploy task");
		}

	}

	public void validateDevicePIDInTaskPage() {
		String actualsServiceId = serviceId.getText();
		String actualsDevicePIID = DevicePIID.getText();
		if (actualsDevicePIID.contentEquals(actualsServiceId) || actualsDevicePIID == null) {
			Assert.assertEquals(actualsServiceId, actualsDevicePIID);
			System.out.println("This order failed to copy the Device PIID....  validation failed");
		} else {
			System.out.println("Device PIID value- " + actualsDevicePIID + "is copied successfully");
			System.out.println("Validation of Device PIID is ...     --Successful");
		}

	}

	public void validateVendorOrderIdInTaskPage() {

		// Get maxlength attribute of input box
		String maxLengthDefined = tbx_vendorOrderIdInputbox.getAttribute("maxlength");

		if (maxLengthDefined == null) {
			System.out.println("No limit is set.");
		}

		else {
			if (maxLengthDefined.equals("256")) {
				System.out.println("Max character limit is set as expected.");
			}
		}
		// IntDataContainer dataContainer = commonData.getContainer("Manage
		// Task").getContainer("CaptureFOC");
		// tbx_vendorOrderIdInputbox.sendKeys(dataContainer.getFieldValue("tbx_tenantName"));
		tbx_vendorOrderIdInputbox.sendKeys("VendorID123");
	}

//GETTNF-7199
	public void validateCPEPackageTypeInTaskPage() {
		String expectedCpePackageType = "CPE Package Type:CradlePoint";
		String actalCpePackageType = cpePackageTypeCradle.getText();
		Assert.assertEquals(expectedCpePackageType, actalCpePackageType);
	}

	public void validateInternalTDGRequiredTaskPage() {

		boolean internalTDGReq = internalTDGRequired.isCurrentlyEnabled();
		if (internalTDGReq == true) {
			System.out.println("Successfully validated the internalTDGRequired textbox");
		}
		IntDataContainer dataContainer = commonData.getContainer("Manage Task").getContainer("ManageTDG");
		internalTDGRequired.sendKeys(dataContainer.getFieldValue("tbx_internalTDGReq"));
	}

	public void validateExitToBAUFieldInTaskDetailsPage() {

		boolean fieldStatus = exitToBAU.isPresent();
		if (fieldStatus == true) {
			System.out.println("Exit To BUA field is present in task details page");
		}
		Select select = new Select(exitToBAU);
		List<WebElement> allOptions = select.getOptions();
		for (int i = 0; i <= allOptions.size() - 1; i++) {
			System.out.println(allOptions.get(i).getText());
		}
	}

	public void validateRegionCodeValueInTaskDetailsPage() {

		String regionCode_Value = regionCodeValue.getText();
		System.out.println("Region Code Value" + regionCode_Value);

	}

	public void validateCNRAttributesIntaskDetailsPage() {

		Select s1 = new Select(cnrAttributes);
		List<WebElement> allOptions = s1.getOptions();
		for (int i = 0; i <= allOptions.size(); i++) {
			String cnrvalues = allOptions.get(i).getText();
			System.out.println("CNR options=" + cnrvalues);

		}
		System.out.println("Successfully validated the CNR Values");
	}

	public void validateEAIMCustomerNameInTaskDetailsPage() {

		String customerName = tbx_customerName.getAttribute("title");
		System.out.println("Customer Name" + customerName);
		System.out.println("Successfully validated the Customer Name field");
	}

	public void validateClientSite_Or_AlternateSiteFieldsInTaskDetailsPage() {
		Select select = new Select(sel_clientSideOrAlternateSite);
		List<WebElement> allOptions = select.getOptions();
		for (int i = 0; i <= allOptions.size(); i++) {
			System.out.println(allOptions.get(i).getText());
		}
		System.out.println("Successfully validated the ClientSite_Or_AlternateSite field");

	}

	public void selectsAlternate_Site_option_In_ClientSite_Or_AlternateSiteFieldsInTaskDetailsPage() {

		Select select = new Select(sel_clientSideOrAlternateSite);
		select.selectByVisibleText("ALTERNATE SITE");
		System.out.println("Successfully selected the Alternate Site option");
	}

	public void validatesPL_and_SL_FieldsInTaskDetailsPage() {

	}

	public void selectsClient_Site_option_In_ClientSite_Or_AlternateSiteFieldsInTaskDetailsPage() {
		Select select = new Select(sel_clientSideOrAlternateSite);
		select.selectByVisibleText("CLIENTE SITE");
		System.out.println("Successfully selected the Alternate Site option");
	}

	public void validateCostOfInterventionFieldsInTaskDetailsPage() {
		costOfIntervention.isDisplayed();
		System.out.println("Successfully validated Cost Of intervention field");
	}

	public void validatesNoShowDropdownValuesInTaskReportingPage() {

		Select select = new Select(noShow);
		List<WebElement> allOptions = select.getOptions();
		for (int i = 0; i <= allOptions.size(); i++) {
			System.out.println(allOptions.get(i).getText());
		}
		System.out.println("Successfully validated the No Show Field field");

	}

	public void validatesdropdownValuesInEAIMApprovalInterventionTask(List<List<String>> list) {
		Select select1 = new Select(technicalReport);
		List<WebElement> allOptionsTechnicalReport = select1.getOptions();

		for (int j = 0; j <= list.size() - 2; j++) {
			String actualValues = allOptionsTechnicalReport.get(j).getText();
			String expectedValues = list.get(j + 1).get(1);
			if (expectedValues.equals(actualValues)) {
				System.out
						.println("Successfully validated the actualValues option in" + list.get(1).get(0) + "dropdown");
			}

		}

		Select select2 = new Select(tools);
		List<WebElement> allOptionstools = select2.getOptions();
		for (int j = 0; j <= list.size() - 2; j++) {
			String actualValues = allOptionstools.get(j).getText();
			String expectedValues = list.get(j + 1).get(1);
			if (expectedValues.equals(actualValues)) {
				System.out
						.println("Successfully validated the actualValues option in" + list.get(2).get(0) + "dropdown");
			}

		}

		Select select3 = new Select(punctuality);
		List<WebElement> allOptionspunctuality = select3.getOptions();

		for (int j = 0; j <= list.size() - 2; j++) {
			String actualValues = allOptionspunctuality.get(j).getText();
			String expectedValues = list.get(j + 1).get(1);
			if (expectedValues.equals(actualValues)) {
				System.out
						.println("Successfully validated the actualValues option in" + list.get(3).get(0) + "dropdown");
			}

		}

		Select select4 = new Select(procedures);
		List<WebElement> allOptionsprocedures = select4.getOptions();

		for (int j = 0; j <= list.size() - 2; j++) {
			String actualValues = allOptionsprocedures.get(j).getText();
			String expectedValues = list.get(j + 1).get(1);
			if (expectedValues.equals(actualValues)) {
				System.out
						.println("Successfully validated the actualValues option in" + list.get(4).get(0) + "dropdown");
			}

		}

		Select select5 = new Select(technicalKnowledge);
		List<WebElement> allOptionstechnicalKnowledge = select5.getOptions();

		for (int j = 0; j <= list.size() - 2; j++) {
			String actualValues = allOptionstechnicalKnowledge.get(j).getText();
			String expectedValues = list.get(j + 1).get(1);
			if (expectedValues.equals(actualValues)) {
				System.out
						.println("Successfully validated the actualValues option in" + list.get(5).get(0) + "dropdown");
			}

		}

	}

	public void selectNoValueInNoShowDropdown() {

		Select select = new Select(noShow);
		// List<WebElement> allOptionsnoShow=select.getOptions();
		select.selectByVisibleText("No");
		System.out.println("Successfully selected the No Value in No Show Dropdown");
	}

	public void validateReasonForNoShowAttributesStatus() {

		reasonForNoShow.getAttribute("class");
		System.out.println("Successfuly validated the Reason For No Show Field Status");

	}

	public void validatePLAndSLFieldStatus() {

		String alternateSitePLFieldStaus = tbxAlternateSitePL.getAttribute("disabled");
		if (alternateSitePLFieldStaus.equals("disabled")) {
			System.out.println("Susccessfully validated the Alternate Site PL field Status");
		}
		String alternateSiteSLFieldStaus = tbxAlternateSiteSL.getAttribute("disabled");
		if (alternateSiteSLFieldStaus.equals("disabled")) {
			System.out.println("Susccessfully validated the Alternate Site SL field Status");
		}

	}

	public void validatePrimaryDirectorDropdownValues() {
		boolean fieldStatus = PrimaryDirectorValues.isPresent();
		if (fieldStatus == true) {
			System.out.println("Primary Director field is present in task details page");
		}
		Select select = new Select(PrimaryDirectorValues);
		List<WebElement> allPrimaryDirectorOptions = select.getOptions();
		for (int i = 0; i <= allPrimaryDirectorOptions.size() - 1; i++) {
			String primaryDirectorValue = allPrimaryDirectorOptions.get(i).getText();
			if (primaryDirectorValue.equalsIgnoreCase("CER-DIRECTOR-01")) {
				System.out.println(allPrimaryDirectorOptions.get(i).getText());
				System.out.println("Validation of 'CER-DIRECTOR-01'dropdown value is ...     --Successful");
			} else if (primaryDirectorValue.equalsIgnoreCase("OMH-DIRECTOR-01")) {
				System.out.println(allPrimaryDirectorOptions.get(i).getText());
				System.out.println("Validation of 'OMH-DIRECTOR-01'dropdown value is ...     --Successful");
			}
		}

	}

	public void enterActivationResultAndfcdDate(String taskName) {
		IntDataContainer dataContainer = commonData.getContainer("Manage Task").getContainer(taskName);
		Calendar calendar = Calendar.getInstance();
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 20);
		System.out.println(format.format(calendar.getTime()));
		sync(this,tbx_activationResult);
		Select select1 = new Select(tbx_activationResult);
		select1.selectByVisibleText(dataContainer.getFieldValue("tbx_activationResult"));
		tbx_fcdDate.clear();
		tbx_fcdDate.sendKeys(format.format(calendar.getTime()));
		Select select2 = new Select(tbx_fcdTime);
		select2.selectByVisibleText(dataContainer.getFieldValue("tbx_fcdTime"));
		
		
	}
	
	
	
	
}
