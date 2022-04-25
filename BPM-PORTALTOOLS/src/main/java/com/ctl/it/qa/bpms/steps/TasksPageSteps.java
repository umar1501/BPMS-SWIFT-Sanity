package com.ctl.it.qa.bpms.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctl.it.qa.bpms.pages.SettingsPage;
import com.ctl.it.qa.bpms.pages.TasksPage;
import com.ctl.it.qa.bpms.steps.common.CommonObjectsPageSteps;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;
import com.ibm.icu.impl.Assert;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class TasksPageSteps extends CommonObjectsPageSteps {

	TasksPage tasksPage;
	SettingsPage settingsPage;

	@Step
	public void setCurrTask(String trgTaskName) {
		tasksPage.setCurrTask(trgTaskName);
	}

	@Step
	public String getCurrTask() {
		return tasksPage.getCurrTask();
	}

	@Step
	public void setCurrTaskId(String trgTaskId) {
		tasksPage.setCurrTaskId(trgTaskId);
	}

	@Step
	public String getCurrTaskId() {
		return tasksPage.getCurrTaskId();
	}

	@Step
	public void enterPortAssignment(String strPort) {
		tasksPage.sync(tasksPage, tasksPage.tbx_PortAssignment);
		// syncObject(ExpectedConditions.visibilityOf_PortAssignment));
		tasksPage.tbx_PortAssignment.sendKeys(strPort);
	}

	@Step
	public void selectClosureCode(String strClosureCode) {
		tasksPage.sync(tasksPage, tasksPage.sel_ClosureCode);
		// syncObject(ExpectedConditions.visibilityOf(this, sel_ClosureCode));
		Select select = new Select(tasksPage.sel_ClosureCode);
		select.selectByVisibleText(strClosureCode);
	}

	@Step
	public void validateAssignDesignRequestGroups() {

		tasksPage.validateAssignDesignRequestGroups();

	}

	@Step
	public void selectAssignDesignRequestGroups(String strGroups) {

		selectAssignDesignRequestGroups(strGroups);

	}

	@Step
	public void validate_LATAMGroups() {

		tasksPage.validate_LATAMGroups();

	}

	@Step
	public void validateAssignInstallationRequestGroups() {

		tasksPage.validateAssignInstallationRequestGroups();

	}

	@Step
	public void selectGroups(String strGroups) {

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

		waitABit(4000);
	}

	@Step
	public void selectUsers(String strUser) {
		tasksPage.sync(tasksPage, tasksPage.sel_Users_DD);
		tasksPage.sel_Users_DD.click();
		System.out.println("User dropdown Successfully cliked");

		for (WebElementFacade option : tasksPage.sel_Users_Options) {
			if (option.containsText(strUser)) {
				option.click();
				System.out.println("Successfully entered the User");
				break;
			}
		}
	}

	@Step
	public void taskSelfAssign(WebElement task) {

		tasksPage.sync(tasksPage, task);
		System.out.println(task.getText());

		task.click();

		tasksPage.lnk_SelfAssign.click();
		WaitForPageToLoad(30);

		tasksPage.btn_OK_SelfAssign.click();
		WaitForPageToLoad(60);

		// closeNotification();

	}

	@Step
	public int clickOn_SaveAndCompleteBtn() {
		waitABit(2000);
		try {
			WebDriverWait wait = new WebDriverWait(this.getDriver(), 120);
			wait.until(ExpectedConditions.visibilityOf(tasksPage.btn_SaveAndComplete));
			tasksPage.sync(tasksPage, tasksPage.btn_SaveAndComplete);
			tasksPage.sync(tasksPage, ExpectedConditions.visibilityOf(tasksPage.btn_SaveAndComplete));
			String saveAndCompleteButtonStatus = tasksPage.btn_SaveAndComplete.getAttribute("aria-disabled");
			System.out.println("Save and Complete button disbled status=" + saveAndCompleteButtonStatus);
			if (saveAndCompleteButtonStatus.equals("false")) {
				// if(tasksPage.btn_SaveAndComplete.isEnabled()) {
				populateMandatoryFields(getCurrTask());
				tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.btn_SaveAndComplete));
				tasksPage.btn_SaveAndComplete.click();
				checkAlert();
				closeNotification();

				WaitForPageToLoad(120);

				return 0;
			} else {

				tasksPage.btn_BackToSearchResults.click();
				WaitForPageToLoad(120);

				return 1;

			}

		} catch (TimeoutException exe) {
			System.out.println("---------------Refresh is required--------------------");
			// if(tasksPage.sync(tasksPage,ExpectedConditions.visibilityOf(tasksPage.ele_Loading)))
			// {
			this.getDriver().navigate().refresh();
			waitABit(10000);

		}

		return 2;

	}

	@Step
	public int clickOn_SaveAndCompleteButton() {

		try {
			waitABit(2000);
			WebDriverWait wait = new WebDriverWait(this.getDriver(), 120);
			wait.until(ExpectedConditions.visibilityOf(tasksPage.btn_SaveAndComplete));
			tasksPage.sync(tasksPage, tasksPage.btn_SaveAndComplete);

			tasksPage.sync(tasksPage, ExpectedConditions.visibilityOf(tasksPage.btn_SaveAndComplete));

			String saveAndCompleteButtonStatus = tasksPage.btn_SaveAndComplete.getAttribute("aria-disabled");
			System.out.println("Save and Complete button disbled status=" + saveAndCompleteButtonStatus);
			if (saveAndCompleteButtonStatus.equals("false")) {
				// if(tasksPage.btn_SaveAndComplete.isEnabled()) {
				populateMandatoryFields(getCurrTask());
				tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.btn_SaveAndComplete));
				tasksPage.btn_SaveAndComplete.click();
				checkAlert();
				closeNotification();

				WaitForPageToLoad(120);

				return 0;
			} else {

				tasksPage.btn_BackToSearchResults.click();
				WaitForPageToLoad(120);

				return 1;

			}
		}

		catch (TimeoutException exe) {
			System.out.println("---------------Refresh is required--------------------");
			// if(tasksPage.sync(tasksPage,ExpectedConditions.visibilityOf(tasksPage.ele_Loading)))
			// {
			this.getDriver().navigate().refresh();
			waitABit(10000);

		}
		return 2;

	}

// 		@Step
// 	public int clickOn_SaveAndCompleteBtn() {		

// 		waitABit(2000);		
// 		tasksPage.sync(tasksPage, tasksPage.btn_SaveAndComplete);	
// 		tasksPage.sync(tasksPage, ExpectedConditions.visibilityOf(tasksPage.btn_SaveAndComplete));
// 		String saveAndCompleteButtonStatus=tasksPage.btn_SaveAndComplete.getAttribute("aria-disabled");

// 		if(saveAndCompleteButtonStatus.equals("false"))
// 		{
// 		//if(tasksPage.btn_SaveAndComplete.isEnabled()) {
// 			populateMandatoryFields(getCurrTask());
// 			tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.btn_SaveAndComplete));
// 			tasksPage.btn_SaveAndComplete.click();
// 			checkAlert();
// 			closeNotification();

// 			WaitForPageToLoad(120);

// 			return 0;
// 		} else {

// 				tasksPage.btn_BackToSearchResults.click();
// 				WaitForPageToLoad(120);

// 				return 1;															

// 			}
// 		}

	@Step
	public void populateMandatoryFields(String forTask) {

		Select select;
		IntDataContainer dataContainer = commonData.getContainer("Manage Task").getContainer(forTask);
		WaitForPageToLoad(120);

		Calendar calendar = Calendar.getInstance();
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 20);
		calendar.set(calendar.DAY_OF_WEEK, calendar.FRIDAY);
		System.out.println(format.format(calendar.getTime()));
		String terminatingRegion = tasksPage.terminatingRegionCode.getText();

//		
//		switch (forTask) {
//		case "Port Assignment":
//			selectClosureCode(dataContainer.getFieldValue("sel_ClosureCode"));
//			enterPortAssignment(dataContainer.getFieldValue("tbx_PortAssignment"));
//			break;
//			
//		case "Assign Design Request":
//			selectUsers(dataContainer.getFieldValue("sel_Users"));
//			break;
//			
//		case "Assign IP Request":
//			selectUsers(dataContainer.getFieldValue("sel_Users"));
//			break;
//			
//		case "Assign Installation Request":
//			selectUsers(dataContainer.getFieldValue("sel_Users"));
//			break;
//			
//		case "Work Circuit Design":
//			break;
//			
//		case "Complete Design":
//			if (tasksPage.lbl_CCD.getText().equals(" ")) {
//				tasksPage.lnk_OrderDetail.click();
//				WaitForPageToLoad(120);
//				tasksPage.tab_OrderDates.click();
//				WaitForPageToLoad(120);
//				tasksPage.sync(tasksPage, tasksPage.tbx_CommitDate);
//				tasksPage.tbx_CommitDate.sendKeys(format.format(calendar.getTime()));
//				tasksPage.btn_SaveDates.click();
//				WaitForPageToLoad(120);
//				tasksPage.lnk_BackToTaskDetails.click();
//			}
//			break;
//			
//		case "Define Physical Installation":
//			tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.btn_Edit_DispatchLoc));
//			tasksPage.btn_Edit_DispatchLoc.click();
//				
//			tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.tbx_Location));
//			tasksPage.tbx_Location.sendKeys(dataContainer.getFieldValue("tbx_Location"));
//			tasksPage.tbx_Location.sendKeys(Keys.TAB);
//			tasksPage.sync(tasksPage, ExpectedConditions.visibilityOf(tasksPage.sel_GateWay));
//			
//			tasksPage.tbx_DueDate.sendKeys(format.format(calendar.getTime()));
//			tasksPage.tbx_Note.sendKeys(dataContainer.getFieldValue("tbx_Note"));
//			tasksPage.lnk_OK.click();
//			
//			WaitForPageToLoad(120);
//			
//			break;
//			
//		case "CompleteBuildingExtension":
//			tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.tbx_noStatus));
//			tasksPage.tbx_noStatus.sendKeys(dataContainer.getFieldValue("tbx_noStatus"));
//			
//			break;
//			
//		case "InitiateBuildingExtension":			
//			tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.tbx_RelatedNetBuildID));
//			tasksPage.tbx_RelatedNetBuildID.sendKeys(dataContainer.getFieldValue("tbx_RelatedNetBuildID"));
//			
//			break;
//		
//		case "Logical Test With Customer":
//			tasksPage.sync(tasksPage, tasksPage.sel_TypeOfTest);
//			select = new Select(tasksPage.sel_TypeOfTest);
//			select.selectByVisibleText(dataContainer.getFieldValue("sel_TypeOfTest"));
//			
//			break;
//			
//		case "Install Cross Connect":
//			tasksPage.sync(tasksPage, tasksPage.sel_ClosureCode_ICC);			
//			select = new Select(tasksPage.sel_ClosureCode_ICC);
//			select.selectByVisibleText(dataContainer.getFieldValue("sel_ClosureCode_ICC"));
//			
//			tasksPage.tbx_LightLevelReading_Protect.sendKeys(dataContainer.getFieldValue("tbx_LightLevelReading_Protect"));
//			
//			select = new Select(tasksPage.sel_RemoveHardLoop);
//			select.selectByVisibleText(dataContainer.getFieldValue("sel_RemoveHardLoop"));
//			
//			tasksPage.tbx_Demarc.sendKeys(dataContainer.getFieldValue("tbx_Demarc"));
//			
//			select = new Select(tasksPage.sel_HardLoopLeft);
//			select.selectByVisibleText(dataContainer.getFieldValue("sel_HardLoopLeft"));
//			
//			tasksPage.tbx_LightLevelReading_Work.sendKeys(dataContainer.getFieldValue("tbx_LightLevelReading_Work"));
//			
//			select = new Select(tasksPage.sel_RedlinesNecessary);
//			select.selectByVisibleText(dataContainer.getFieldValue("sel_RedlinesNecessary"));
//			
//			break;
//			
//			
//			
//			
//		default:
//			break;
//		}
//	}

		switch (forTask) {
		case "Port Assignment":
			selectClosureCode(dataContainer.getFieldValue("sel_ClosureCode"));
			enterPortAssignment(dataContainer.getFieldValue("tbx_PortAssignment"));
			break;

		case "Assign Design Request":
			if (terminatingRegion.equals("LA")) {
				validateAssignDesignRequestGroups();
				selectGroups(dataContainer.getFieldValue("sel_LA_Group"));
				selectUsers(dataContainer.getFieldValue("sel_LA_User"));
				break;
			} else {
				System.out.println("User is in Assign Design Requesr");
				selectUsers(dataContainer.getFieldValue("sel_Users"));
				break;
			}

		case "Assign IP Request":
			if (terminatingRegion.equals("LA")) {
				validate_LATAMGroups();
				selectGroups(dataContainer.getFieldValue("sel_LA_Group"));
				selectUsers(dataContainer.getFieldValue("sel_LA_User"));
				break;
			} else {
				selectUsers(dataContainer.getFieldValue("sel_Users"));
			}
			break;

		case "Assign Installation Request":
			if (terminatingRegion.equals("LA")) {
				validateAssignInstallationRequestGroups();
				selectGroups(dataContainer.getFieldValue("sel_LA_Group"));
				selectUsers(dataContainer.getFieldValue("sel_LA_User"));
				break;
			} else {
				selectUsers(dataContainer.getFieldValue("sel_Users"));
			}
			break;

		case "Work Circuit Design":
			break;

		case "Complete Design":

			if (tasksPage.lbl_CCD.getText().equals(" ")) {
				tasksPage.lnk_OrderDetail.click();
				WaitForPageToLoad(120);
				tasksPage.tab_OrderDates.click();
				WaitForPageToLoad(120);
				tasksPage.sync(tasksPage, tasksPage.tbx_CommitDate);
				tasksPage.tbx_CommitDate.sendKeys(format.format(calendar.getTime()));
				tasksPage.btn_SaveDates.click();
				waitABit(2000);
				WaitForPageToLoad(120);
				tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.lnk_BackToTaskDetails));
				tasksPage.lnk_BackToTaskDetails.click();
			}
			
		
			try {
				boolean result = tasksPage.accessType.isEnabled();
				System.out.println(tasksPage.accessType.isEnabled());
				tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.accessType));
				select = new Select(tasksPage.accessType);
				select.selectByVisibleText(dataContainer.getFieldValue("sel_accessType"));
			} catch (NoSuchElementException e) {
				System.out.println("Access type field is not required");
			}

			break;
			
		case "Assign Port":

			if (tasksPage.lbl_CCD.getText().equals(" ")) {
				tasksPage.lnk_OrderDetail.click();
				WaitForPageToLoad(120);
				tasksPage.tab_OrderDates.click();
				WaitForPageToLoad(120);
				tasksPage.sync(tasksPage, tasksPage.tbx_CommitDate);
				tasksPage.tbx_CommitDate.sendKeys(format.format(calendar.getTime()));
				tasksPage.btn_SaveDates.click();
				waitABit(2000);
				WaitForPageToLoad(120);
				tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.lnk_BackToTaskDetails));
				tasksPage.lnk_BackToTaskDetails.click();
			}
			
			break;

		case "Define Physical Installation":
			tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.btn_Edit_DispatchLoc));
			tasksPage.btn_Edit_DispatchLoc.click();

			tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.tbx_Location));
			tasksPage.tbx_Location.sendKeys(dataContainer.getFieldValue("tbx_Location"));
			tasksPage.tbx_Location.sendKeys(Keys.TAB);
			tasksPage.sync(tasksPage, ExpectedConditions.visibilityOf(tasksPage.sel_GateWay));

			tasksPage.tbx_DueDate.sendKeys(format.format(calendar.getTime()));
			tasksPage.tbx_Note.sendKeys(dataContainer.getFieldValue("tbx_Note"));
			tasksPage.lnk_OK.click();
			waitABit(1000);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			WaitForPageToLoad(120);

			break;

		case "CompleteBuildingExtension":
			tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.tbx_noStatus));
			tasksPage.tbx_noStatus.sendKeys(dataContainer.getFieldValue("tbx_noStatus"));

			break;

		case "ManageTDG":
			tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.internalTDGRequired));
			tasksPage.internalTDGRequired.sendKeys(dataContainer.getFieldValue("tbx_internalTDGReq"));

			break;

		case "High Level Design Task":
			tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.hybridOrders));

			tasksPage.hybridOrders.click();
			tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.networkType));
			select = new Select(tasksPage.networkType);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_networkType"));
			tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.saveButton));
			waitABit(2000);
			tasksPage.saveButton.click();
			// tasksPage.networkType.sendKeys(dataContainer.getFieldValue("tbx_RelatedNetBuildID"));

			break;

		case "InitiateBuildingExtension":
			tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.tbx_RelatedNetBuildID));
			tasksPage.tbx_RelatedNetBuildID.sendKeys(dataContainer.getFieldValue("tbx_RelatedNetBuildID"));

			break;

		case "Logical Test With Customer":
			tasksPage.sync(tasksPage, tasksPage.sel_TypeOfTest);
			if (tasksPage.lbl_CCD.getText().equals(" ")) {
				tasksPage.lnk_OrderDetail.click();
				WaitForPageToLoad(120);
				tasksPage.tab_OrderDates.click();
				WaitForPageToLoad(120);
				tasksPage.sync(tasksPage, tasksPage.tbx_CommitDate);
				tasksPage.tbx_CommitDate.sendKeys(format.format(calendar.getTime()));
				tasksPage.btn_SaveDates.click();
				WaitForPageToLoad(120);
				tasksPage.waitTillElementToBeClicakble(tasksPage.lnk_BackToTaskDetails);
				tasksPage.lnk_BackToTaskDetails.click();
			}
			tasksPage.sync(tasksPage, tasksPage.sel_TypeOfTest);
			select = new Select(tasksPage.sel_TypeOfTest);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_TypeOfTest"));

			break;

		case "Install Cross Connect":
			tasksPage.sync(tasksPage, tasksPage.sel_ClosureCode_ICC);
			select = new Select(tasksPage.sel_ClosureCode_ICC);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_ClosureCode_ICC"));

			tasksPage.tbx_LightLevelReading_Protect
					.sendKeys(dataContainer.getFieldValue("tbx_LightLevelReading_Protect"));

			select = new Select(tasksPage.sel_RemoveHardLoop);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_RemoveHardLoop"));

			tasksPage.tbx_Demarc.sendKeys(dataContainer.getFieldValue("tbx_Demarc"));

			select = new Select(tasksPage.sel_HardLoopLeft);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_HardLoopLeft"));

			tasksPage.tbx_LightLevelReading_Work.sendKeys(dataContainer.getFieldValue("tbx_LightLevelReading_Work"));

			select = new Select(tasksPage.sel_RedlinesNecessary);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_RedlinesNecessary"));

			break;

		// Added By Raj

		// CPE
		case "Waiting for Static IPs":
			tasksPage.sync(tasksPage, tasksPage.sel_skipStaticIPWait);
			select = new Select(tasksPage.sel_skipStaticIPWait);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_skipStaticIPWait"));

			break;

		// BB
		case "Assign Provisioning Request":
			tasksPage.sync(tasksPage, tasksPage.sel_Users_DD);
			// tasksPage.sync(tasksPage, tasksPage.sel_skipStaticIPWait);
			selectUsers(dataContainer.getFieldValue("sel_Users"));
			// selectUsers(dataContainer.getFieldValue("sel_Users"));
			break;

		// BB
		case "Follow Up":
			tasksPage.sync(tasksPage, tasksPage.check_readyToComplete);
			tasksPage.check_readyToComplete.click();
			break;

		case "Initiate ASR Manual":
			tasksPage.sync(tasksPage, tasksPage.tbx_ASRSubmitDate);
			tasksPage.tbx_ASRSubmitDate.sendKeys(format.format(calendar.getTime()));
			boolean isElementPresent = this.getDriver().findElements(By.xpath("//input[@title='PON/Sub Account']"))
					.size() != 0;
			if (isElementPresent == true) {
				tasksPage.pon_subAccount.sendKeys(dataContainer.getFieldValue("pon_subAccount"));
			}

			tasksPage.tbx_RequestDate.sendKeys(format.format(calendar.getTime()));
			break;

		case "Receive Cellular Site Survey":

			tasksPage.sync(tasksPage, tasksPage.cellularSiteSurveyResult);
			if (tasksPage.lbl_CCD.getText().equals(" ")) {
				tasksPage.lnk_OrderDetail.click();

				WaitForPageToLoad(120);
				tasksPage.tab_OrderDates.click();
				WaitForPageToLoad(120);
				tasksPage.sync(tasksPage, tasksPage.tbx_CommitDate);
				tasksPage.tbx_CommitDate.sendKeys(format.format(calendar.getTime()));
				tasksPage.btn_SaveDates.click();
				WaitForPageToLoad(120);

				tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.lnk_BackToTaskDetails));
				tasksPage.lnk_BackToTaskDetails.click();
			}
			WaitForPageToLoad(120);
			tasksPage.sync(tasksPage, tasksPage.cellularSiteSurveyResult);
			select = new Select(tasksPage.cellularSiteSurveyResult);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_cellularSiteSurveyResultsAttachedBPMPortal"));
			select = new Select(tasksPage.equipmentProvider);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_equipmentProvider"));
			select = new Select(tasksPage.maaintenanceProvider);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_maintenanceProvider"));
			select = new Select(tasksPage.cellularVendor);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_cellularVendor"));

			break;

		case "CaptureFOC": // Bradband

			String serviceType6 = tasksPage.serviceType.getText();
			if (serviceType6.equals("CELLULAR_ACCESS")) {
				tasksPage.tbx_cellularFocDate.sendKeys(format.format(calendar.getTime()));
				tasksPage.tbx_cellularFocRecievedDate.sendKeys(format.format(calendar.getTime()));
			}
			// tasksPage.sync(tasksPage, tasksPage.cellularSiteSurveyResult);
			// select = new Select(tasksPage.sel_skipStaticIPWait);
			// select.selectByVisibleText(dataContainer.getFieldValue("sel_skipStaticIPWait"));
			// tasksPage.cellularSiteSurveyResult.sendKeys(format.format(calendar.getTime()));
			tasksPage.tbx_expectedFocRcvdDate.sendKeys(format.format(calendar.getTime()));
			tasksPage.tbx_commitDate.sendKeys(format.format(calendar.getTime()));
			tasksPage.tbxFocRcvdDate.sendKeys(format.format(calendar.getTime()));
			break;

		case "Receive Completion Notification":

			tasksPage.sync(tasksPage, tasksPage.tbx_dateComplete);
			tasksPage.tbx_dateComplete.sendKeys(format.format(calendar.getTime()));
			tasksPage.tbx_accountNo.sendKeys(dataContainer.getFieldValue("tbx_accountNo"));
			tasksPage.tbx_staticIP.sendKeys(dataContainer.getFieldValue("tbx_staticIP"));
			tasksPage.tbx_gatewayIP.sendKeys(dataContainer.getFieldValue("tbx_gatewayIP"));
			break;

		// CPE
		case "Review SOW":

			tasksPage.sync(tasksPage, tasksPage.tbx_maintenanceProvider);
			select = new Select(tasksPage.tbx_maintenanceProvider);
			select.selectByVisibleText(dataContainer.getFieldValue("tbx_maintenanceProvider"));
			select = new Select(tasksPage.tbx_equipmentProvider);
			select.selectByVisibleText(dataContainer.getFieldValue("tbx_equipmentProvider"));

			if (tasksPage.selResourceModel.isDisplayed() == true) {
				select = new Select(tasksPage.selResourceModel);
				select.selectByVisibleText(dataContainer.getFieldValue("tbx_selResourceModel"));
				// select.selectByIndex(1);
				System.out.println("Resource Model is present and entered");
			}

			break;

		case "Create Boot Config":

			tasksPage.lnk_OrderDetail.click();

			WaitForPageToLoad(120);
			tasksPage.sync(tasksPage, tasksPage.cpePackageType);
			// td[@title='CPE Package Type:']
			String cpePackageType = tasksPage.cpePackageType.getText();
			System.out.println("CPE package type-" + cpePackageType);
			tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.lnk_BackToTaskDetails));
			tasksPage.lnk_BackToTaskDetails.click();
			WaitForPageToLoad(120);
			if (cpePackageType.equals("Large") || cpePackageType.equals("XLarge")) {
				tasksPage.sync(tasksPage, tasksPage.largeKitTypeDropdown);
				select = new Select(tasksPage.largeKitTypeDropdown);
				select.selectByVisibleText(dataContainer.getFieldValue("tbx_largeKitType"));
			}
			// tasksPage.largeKitTypeDropdown.sendKeys(dataContainer.getFieldValue("tbx_largeKitType"));

			tasksPage.sync(tasksPage, tasksPage.bootConfig);
			tasksPage.bootConfig.sendKeys(dataContainer.getFieldValue("tbx_bootConfig"));

			break;

		case "Develop And Deploy Config":
			// SDWAN data-
			String serviceType4 = tasksPage.serviceType.getText();
			if (serviceType4.equals("HC_SDWAN_CPE")) {
				tasksPage.sync(tasksPage, tasksPage.tbx_deviceName);
				tasksPage.tbx_deviceName.sendKeys(dataContainer.getFieldValue("tbx_deviceName"));
				select = new Select(tasksPage.selPrimaryDirector);
				select.selectByVisibleText(dataContainer.getFieldValue("selPrimaryDirector"));
				// tasksPage.tbx_tenantName.sendKeys(dataContainer.getFieldValue("tbx_tenantName"));
			}
			break;

		case "Enter Cellular IP": //

			tasksPage.sync(tasksPage, tasksPage.cellularAccessSerialNum);
			tasksPage.cellularAccessSerialNum.sendKeys(dataContainer.getFieldValue("cellularAccessSerialNum"));
			tasksPage.sync(tasksPage, tasksPage.staticIP);
			tasksPage.staticIP.sendKeys(dataContainer.getFieldValue("staticIP"));
			tasksPage.sync(tasksPage, tasksPage.macAddress);
			tasksPage.macAddress.sendKeys(dataContainer.getFieldValue("macAddress"));
			tasksPage.sync(tasksPage, tasksPage.cellularSimId);
			tasksPage.cellularSimId.sendKeys(dataContainer.getFieldValue("cellularSimId"));

			break;

		case "FOC Notification":
			if (tasksPage.lbl_CCD.getText().equals(" ")) {
				tasksPage.lnk_OrderDetail.click();

				WaitForPageToLoad(120);
				tasksPage.tab_OrderDates.click();
				WaitForPageToLoad(120);
				tasksPage.sync(tasksPage, tasksPage.tbx_CommitDate);
				tasksPage.tbx_CommitDate.sendKeys(format.format(calendar.getTime()));
				tasksPage.btn_SaveDates.click();
				WaitForPageToLoad(120);
				tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.lnk_BackToTaskDetails));
				tasksPage.waitTillElementToBeClicakble(tasksPage.lnk_BackToTaskDetails);
				tasksPage.lnk_BackToTaskDetails.click();
			}

			break;
		case "Remove Hard Loop":

			tasksPage.sync(tasksPage, tasksPage.tbx_closureCode);
			select = new Select(tasksPage.tbx_closureCode);
			select.selectByVisibleText(dataContainer.getFieldValue("tbx_closureCode"));
			break;
		case "Set CCD":

			if (tasksPage.lbl_CCD.getText().equals(" ")) {
				tasksPage.lnk_OrderDetail.click();

				WaitForPageToLoad(120);
				tasksPage.tab_OrderDates.click();
				WaitForPageToLoad(120);
				tasksPage.sync(tasksPage, tasksPage.tbx_CommitDate);
				tasksPage.tbx_CommitDate.sendKeys(format.format(calendar.getTime()));
				tasksPage.btn_SaveDates.click();
				WaitForPageToLoad(120);
				// tasksPage.lnk_BackToTaskDetails.click();
				tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.lnk_BackToTaskDetails));
				tasksPage.waitTillElementToBeClicakble(tasksPage.lnk_BackToTaskDetails);
				tasksPage.lnk_BackToTaskDetails.click();

			}

			break;

		case "Create PR Dispatch":

			tasksPage.sync(tasksPage, tasksPage.serviceType);
			String serviceType = tasksPage.serviceType.getText();

			if (serviceType.equals("Managed Service") || serviceType.equals("Transport")) {
				System.out.println("In if");
				tasksPage.tbx_pr_Num.sendKeys(dataContainer.getFieldValue("tbx_pr_Num"));
				tasksPage.tbx_serialNum.sendKeys(dataContainer.getFieldValue("tbx_serialNum"));
				tasksPage.sync(tasksPage, tasksPage.tbx_dateShipped);
				tasksPage.tbx_dateShipped.sendKeys(format.format(calendar.getTime()));
				tasksPage.tbx_upsTrackingNumber.sendKeys(dataContainer.getFieldValue("tbx_upsTrackingNumber"));
			} else {
				System.out.println("ele");
				tasksPage.sync(tasksPage, tasksPage.tbx_cpeCourierTrackingNum);
				tasksPage.tbx_cpeCourierTrackingNum.sendKeys(dataContainer.getFieldValue("tbx_cpeCourierTrackingNum"));
				tasksPage.tbx_pr_Num.sendKeys(dataContainer.getFieldValue("tbx_pr_Num"));
				tasksPage.tbx_serialNum.sendKeys(dataContainer.getFieldValue("tbx_serialNum"));
				tasksPage.sync(tasksPage, tasksPage.tbx_dateShipped);
				tasksPage.tbx_dateShipped.sendKeys(format.format(calendar.getTime()));
				tasksPage.tbx_manufacturedPartNum.sendKeys(dataContainer.getFieldValue("tbx_manufacturedPartNum"));
				tasksPage.tbx_lconPhone.sendKeys(dataContainer.getFieldValue("tbx_lconPhone"));
			}
			break;

		case "Schedule Pre-Activation":

			tasksPage.sync(tasksPage, tasksPage.preActivationOpsConsoleTicket1);
			tasksPage.preActivationOpsConsoleTicket1
					.sendKeys(dataContainer.getFieldValue("preActivationOpsConsoleTicket1"));
			select = new Select(tasksPage.onsiteInstallationResource);
			select.selectByVisibleText(dataContainer.getFieldValue("onsiteInstallationResource"));
			break;

		case "Proof of Delivery":

			String serviceType3 = tasksPage.serviceType.getText();
			if (serviceType3.equals("Managed Service") || serviceType3.equals("Transport")) {
				tasksPage.sync(tasksPage, tasksPage.tbx_deliveryDate);
				tasksPage.tbx_deliveryDate.sendKeys(format.format(calendar.getTime()));
			} else {
				tasksPage.sync(tasksPage, tasksPage.tbx_dateDelivered);
				tasksPage.tbx_dateDelivered.sendKeys(format.format(calendar.getTime()));
			}

			break;

		case "Coordinate Activation":

			tasksPage.sync(tasksPage, tasksPage.tbx_finalActivationOpsConsoleticket);
			// System.out.println(dataContainer.getFieldValue("tbx1_finalActivationOpsConsoleticket"));
			tasksPage.tbx_finalActivationOpsConsoleticket
					.sendKeys(dataContainer.getFieldValue("tbx1_finalActivationOpsConsoleticket"));

			break;

		case "Activate Service":

			String serviceType2 = tasksPage.serviceType.getText();
			if (serviceType2.equals("Managed Service") || serviceType2.equals("Transport")) {
				tasksPage.sync(tasksPage, tasksPage.tbx_activationResult);
				select = new Select(tasksPage.tbx_activationResult);

				select.selectByVisibleText(dataContainer.getFieldValue("tbx_activationResultDIA"));
				tasksPage.tbx_fcdDate.sendKeys(format.format(calendar.getTime()));
			} else {
				tasksPage.sync(tasksPage, tasksPage.tbx_activationResult);
				select = new Select(tasksPage.tbx_activationResult);
				select.selectByVisibleText(dataContainer.getFieldValue("tbx_activationResult"));

				if (serviceType2.equals("HC_SDWAN_CPE")) {
					tasksPage.tbx_versaManagementIP.sendKeys(dataContainer.getFieldValue("tbx_versaManagementIP"));
				}

				if (serviceType2.equals("CELLULAR_ACCESS")) {
					
					tasksPage.tbx_versaManagementIP.sendKeys(dataContainer.getFieldValue("tbx_versaManagementIP"));
				}
			}

			break;

		case "Submit CPE Request":

			tasksPage.sync(tasksPage, tasksPage.cpeType);
			select = new Select(tasksPage.cpeType);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_cpeType"));

			select = new Select(tasksPage.handOffTypeCust);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_handOffTypeCust"));

			select = new Select(tasksPage.nidType);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_nidType"));

			select = new Select(tasksPage.handOffTypeLec);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_handOffTypeLec"));

			tasksPage.deviceName.sendKeys(dataContainer.getFieldValue("tbx_deviceName"));
			System.out.println("device Name enteed");
			tasksPage.lconPhone.sendKeys(dataContainer.getFieldValue("tbx_lconPhone"));
			System.out.println("LCON phone entered");
			tasksPage.cpeKitNum.sendKeys(dataContainer.getFieldValue("tbx_cpeKitNum"));
			System.out.println("CPE Kit entered");
			tasksPage.customerAddress.sendKeys(dataContainer.getFieldValue("tbx_customerAddress"));
			System.out.println("Customer Add entered");
			tasksPage.customerName.sendKeys(dataContainer.getFieldValue("tbx_customerName"));
			System.out.println("Customer Name entered");
			tasksPage.lcon.sendKeys(dataContainer.getFieldValue("tbx_lcon"));
			System.out.println("LCON entered");

			waitABit(2000);
			tasksPage.sync(tasksPage, tasksPage.btn_Edit_DispatchLoc);
			tasksPage.sync(tasksPage, ExpectedConditions.elementToBeClickable(tasksPage.btn_Edit_DispatchLoc));
			tasksPage.btn_Edit_DispatchLoc.click();
			System.out.println("Clicked");
			waitABit(5000);

			select = new Select(tasksPage.dispatchAction);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_dispatchAction"));
			waitABit(2000);
			// }
			select = new Select(tasksPage.dispatchRequired);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_dispatchRequired"));
			tasksPage.lnk_OK.click();
			waitABit(8000);

			break;

		// Network Order
		case "Perform Site Survey":

			tasksPage.sync(tasksPage, tasksPage.closureCode);
			select = new Select(tasksPage.closureCode);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_closureCode"));
			// System.out.println(dataContainer.getFieldValue("tbx1_finalActivationOpsConsoleticket"));
			// tasksPage.closureCode.sendKeys(dataContainer.getFieldValue("tbx1_closureCode"));

			break;

		case "Site Survery Confirmation":

			tasksPage.sync(tasksPage, tasksPage.surveyDate);
			// tasksPage.sync(tasksPage, tasksPage.tbx_deliveryDate);
			tasksPage.surveyDate.sendKeys(format.format(calendar.getTime()));
			// tasksPage.surveyDate.sendKeys(dataContainer.getFieldValue("tbx1_surveyDate"));

			break;
		case "Review Vendor Quote":

			break;
		case "Validate Site Survey Result":

			break;

		// REDDIA

		case "NaaS_Create_Port":

			tasksPage.sync(tasksPage, tasksPage.edgeDevicePort);
			tasksPage.deviceName.sendKeys(dataContainer.getFieldValue("tbx_edgeDevicePort"));
			tasksPage.sync(tasksPage, tasksPage.serviceNamePort);
			tasksPage.deviceName.sendKeys(dataContainer.getFieldValue("tbx_serviceNamePort"));
			tasksPage.sync(tasksPage, tasksPage.vendorVLAN);
			tasksPage.deviceName.sendKeys(dataContainer.getFieldValue("tbx_vendorVLAN"));

			break;

		case "NaaS_Create_Path":

			tasksPage.sync(tasksPage, tasksPage.serviceNamePath);
			tasksPage.deviceName.sendKeys(dataContainer.getFieldValue("tbx_serviceNamePath"));
			break;

		case "Default Config Validation":

			tasksPage.sync(tasksPage, tasksPage.exitToBAU);
			select = new Select(tasksPage.exitToBAU);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_exitToBAU"));
			break;

		// REDDIA offnet
		case "AUTO_NaaS_Qualify_Order_Offnet":

			break;

		case "AUTO_NaaS_Create_Port_Offnet":

			tasksPage.sync(tasksPage, tasksPage.edgeDevicePort);
			tasksPage.deviceName.sendKeys(dataContainer.getFieldValue("tbx_edgeDevicePort"));
			tasksPage.sync(tasksPage, tasksPage.serviceNamePort);
			tasksPage.deviceName.sendKeys(dataContainer.getFieldValue("tbx_serviceNamePort"));
			tasksPage.sync(tasksPage, tasksPage.createPortOffnetCorrelationId);
			tasksPage.deviceName.sendKeys(dataContainer.getFieldValue("tbx_createPortOffnetCorrelationId"));

			// optional
			tasksPage.sync(tasksPage, tasksPage.vendorVLAN);
			tasksPage.deviceName.sendKeys(dataContainer.getFieldValue("tbx_vendorVLAN"));

			break;

		case "AUTO_NaaS_Create_Path_Offnet":

			tasksPage.sync(tasksPage, tasksPage.serviceNamePath);
			tasksPage.deviceName.sendKeys(dataContainer.getFieldValue("tbx_serviceNamePath"));
			break;

		case "AUTO_NaaS_Wait_For_POM_DLR":

		case "AUTO_NaaS_Select_POM_CFA":

			tasksPage.sync(tasksPage, tasksPage.nni);
			tasksPage.nni.sendKeys(dataContainer.getFieldValue("tbx_nni"));

			tasksPage.sync(tasksPage, tasksPage.pomQualified);
			tasksPage.pomQualified.sendKeys(dataContainer.getFieldValue("tbx_pomQualified"));

			tasksPage.sync(tasksPage, tasksPage.pomCorrelationId);
			tasksPage.pomCorrelationId.sendKeys(dataContainer.getFieldValue("tbx_pomCorrelationId"));

			tasksPage.sync(tasksPage, tasksPage.vlan);
			tasksPage.vlan.sendKeys(dataContainer.getFieldValue("tbx_vlan"));

			break;
		case "AUTO_NaaS_Qualify_Order_Product":

			break;

		case "Stage Equipment":

			tasksPage.sync(tasksPage, tasksPage.bootConfig);
			tasksPage.deviceName.sendKeys(dataContainer.getFieldValue("tbx_bootConfig"));
			tasksPage.sync(tasksPage, tasksPage.tbx_manufacturedPartNum);
			tasksPage.deviceName.sendKeys(dataContainer.getFieldValue("tbx_manufacturedPartNum"));
			tasksPage.sync(tasksPage, tasksPage.tbx_serialNum);
			tasksPage.deviceName.sendKeys(dataContainer.getFieldValue("tbx_serialNum"));

			break;

		case "Ship Equipment":

			tasksPage.sync(tasksPage, tasksPage.tbx_cpeCourierTrackingNum);
			tasksPage.deviceName.sendKeys(dataContainer.getFieldValue("tbx_cpeCourierTrackingNum"));
			tasksPage.sync(tasksPage, tasksPage.tbx_dateShipped);
			tasksPage.tbx_dateShipped.sendKeys(format.format(calendar.getTime()));

			break;

		case "Obtain Project Code":

			tasksPage.projectCode.sendKeys(dataContainer.getFieldValue("tbx_projectCode"));
			break;

		case "Project Scope":

			selectClosureCode(dataContainer.getFieldValue("sel_closureCode"));
			tasksPage.sync(tasksPage, tasksPage.electronicsCommitDate);
			tasksPage.electronicsCommitDate.sendKeys(format.format(calendar.getTime()));
			break;

		case "Perform Implementation":

			selectClosureCode(dataContainer.getFieldValue("sel_closureCode"));
			tasksPage.sel_updateCADReq.sendKeys(dataContainer.getFieldValue("sel_updateCADReq"));
			break;

		case "TNOC Acceptance":

			tasksPage.sel_tnoc.sendKeys(dataContainer.getFieldValue("sel_tnoc"));
			break;

		case "Submit EAIM Request":

			select = new Select(tasksPage.sel_nearnetCountryCode);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_nearnetCountryCode"));

			tasksPage.tbx_orderPackageId.sendKeys(dataContainer.getFieldValue("tbx_orderPackageId"));
			select = new Select(tasksPage.activity);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_activity"));

			select = new Select(tasksPage.sel_requesterArea);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_requesterArea"));
			select = new Select(tasksPage.sel_solution);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_solution"));
			waitABit(1000);
			select = new Select(tasksPage.eaim);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_eaim"));

			tasksPage.tbx_serviceId.sendKeys(dataContainer.getFieldValue("tbx_serviceId"));

			select = new Select(tasksPage.sel_clientSideOrAlternateSite);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_clientSideOrAlternateSite"));

			tasksPage.tbx_customerName.sendKeys(dataContainer.getFieldValue("tbx_customerName"));
			waitABit(1000);
			select = new Select(tasksPage.intervention);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_intervention_TypeOfService"));
			select = new Select(tasksPage.requireAdditionalWork);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_reqAdditionalwork"));
			tasksPage.tbx_estimatedUSDValue.sendKeys(dataContainer.getFieldValue("tbx_estimatedUSDValue"));
			tasksPage.tbx_reqComments.sendKeys(dataContainer.getFieldValue("tbx_reqComments"));

			break;

		case "GetLocationContactInfo_EAIM":

			tasksPage.tbx_autoEaimLatamSuccess.sendKeys(dataContainer.getFieldValue("tbx_autoEaimLatamSuccess"));
			break;

		case "EAIM_Details_Review":

			// tasksPage.tbx_autoEaimLatamSuccess.sendKeys(dataContainer.getFieldValue("tbx_autoEaimLatamSuccess"));
			break;

		case "EAIM_OT_BPMS_Integration":

			tasksPage.tbx_autoLatamOTIntegrationSuccess
					.sendKeys(dataContainer.getFieldValue("tbx_autoLatamOTIntegrationSuccess"));
			break;

		case "EAIM_OT_OrderAccepted":

			tasksPage.tbx_autoLatamOTOrderAccepted
					.sendKeys(dataContainer.getFieldValue("tbx_autoLatamOTOrderAccepted"));

			break;

		case "Approve EAIM Intervention":

			select = new Select(tasksPage.eaimApproved);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_eaimApproved"));
			tasksPage.interventionComments.sendKeys(dataContainer.getFieldValue("tbx_interventionComments"));
			tasksPage.officeTrackFtpLink.sendKeys(dataContainer.getFieldValue("tbx_officeTrackFtpLink"));
			select = new Select(tasksPage.noShow);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_noShow"));
			select = new Select(tasksPage.technicalReport);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_technicalReport"));
			select = new Select(tasksPage.tools);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_tools"));
			select = new Select(tasksPage.punctuality);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_punctuality"));
			select = new Select(tasksPage.procedures);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_procedures"));
			select = new Select(tasksPage.technicalKnowledge);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_technicalKnowledge"));

			tasksPage.costOfIntervention.sendKeys(dataContainer.getFieldValue("tbx_costOfIntervention"));

			break;

		case "Manual Approve EAIM Intervention":

			select = new Select(tasksPage.eaimApproved);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_eaimApproved"));
			tasksPage.interventionComments.sendKeys(dataContainer.getFieldValue("tbx_interventionComments"));
			tasksPage.officeTrackFtpLink.sendKeys(dataContainer.getFieldValue("tbx_officeTrackFtpLink"));
			select = new Select(tasksPage.noShow);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_noShow"));
			select = new Select(tasksPage.technicalReport);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_technicalReport"));
			select = new Select(tasksPage.tools);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_tools"));
			select = new Select(tasksPage.punctuality);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_punctuality"));
			select = new Select(tasksPage.procedures);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_procedures"));
			select = new Select(tasksPage.technicalKnowledge);
			select.selectByVisibleText(dataContainer.getFieldValue("sel_technicalKnowledge"));

			tasksPage.costOfIntervention.sendKeys(dataContainer.getFieldValue("tbx_costOfIntervention"));

			break;
			
		case "UCPE_Logistics":

			tasksPage.tbx_deviceName
					.sendKeys(dataContainer.getFieldValue("tbx_deviceName"));
			tasksPage.tbx_serialNum
			.sendKeys(dataContainer.getFieldValue("tbx_serialNumber"));
			tasksPage.tbx_wirelessDeviceSerialNumber
			.sendKeys(dataContainer.getFieldValue("tbx_wirelessDeviceSerialNumber"));
			tasksPage.tbx_portalId
			.sendKeys(dataContainer.getFieldValue("tbx_portalId"));
			break;
			
			
		case "Offnet_Design_CFA":

			tasksPage.tbxAutopilotManagedOffnet
					.sendKeys(dataContainer.getFieldValue("tbxAutopilotManagedOffnet"));
			
			break;
			
			
		case "Meraki_Logistics":

			tasksPage.tbx_deviceName
					.sendKeys(dataContainer.getFieldValue("tbx_deviceName"));
			tasksPage.tbx_serialNum
			.sendKeys(dataContainer.getFieldValue("tbx_serialNum"));
			
			
			break;
			
		case "Asri_Fulfilment_Qualify":
			tasksPage.tbx_asriFulfilment
			      .sendKeys(dataContainer.getFieldValue("tbx_asriFulfilment"));

			break;
			
		default:
			break;
		}
	}

	@Step
	public void backToTaskReportingPage() {
		tasksPage.sync(tasksPage, tasksPage.btn_BackToSearchResults);
		tasksPage.btn_BackToSearchResults.click();
		WaitForPageToLoad(120);
	}

	@Step
	public void clickOnSaveAndCompleteButton() {

		sync(tasksPage, tasksPage.btn_SaveAndComplete);
		waitABit(2000);
		sync(tasksPage, ExpectedConditions.visibilityOf(tasksPage.btn_SaveAndComplete));
		tasksPage.btn_SaveAndComplete.click();
		checkAlert();
		closeNotification();

		WaitForPageToLoad(120);
	}

	@Step
	public void validateXLargeDropdownKitValues(List<List<String>> list) {

		sync(tasksPage, tasksPage.btn_SaveAndComplete);

		tasksPage.validateXLargeDropdownKitValues(list);
	}

	@Step
	public void validateLargeDropdownKitValues(List<List<String>> list) {

		sync(tasksPage, tasksPage.btn_SaveAndComplete);

		tasksPage.validateLargeDropdownKitValues(list);
	}

	@Step
	public void verifySelectedCPEPackageType() {

		tasksPage.verifySelectedCPEPackageType();
	}

	public void verifySelectedCPEPackageType(String cpeType) {

		tasksPage.verifySelectedCPEPackageType(cpeType);
	}

	public void refreshPage() {
		this.getDriver().navigate().refresh();
		waitABit(8000);

	}

	public void validateMandatoryTenantNameField() {
		tasksPage.validateMandatoryTenantNameFieldInDevelopAndDeployConfig();

	}

	@Step
	public String getTerminatingRegionCode() {

		tasksPage.sync(tasksPage, tasksPage.task1);
		tasksPage.task1.click();
		waitABit(10000);
		tasksPage.sync(tasksPage, tasksPage.terminatingRegionCode);

		String terminatingRegionCode = tasksPage.terminatingRegionCode.getText();
		System.out.println(terminatingRegionCode);
		tasksPage.sync(tasksPage, tasksPage.btn_BackToSearchResults);
		tasksPage.btn_BackToSearchResults.click();
		WaitForPageToLoad(60);
		return terminatingRegionCode;

	}

	@Step
	public void validateGatewayIpFieldInTaskPage() {
		tasksPage.validateGatewayIpFieldInTaskPage();

	}

	public void validateLocalContactsInformation(List<List<String>> list) {

		tasksPage.validateLocalContactsInformation(list);

	}

	@Step
	public void validateProductFamily() {

		tasksPage.validateProductFamily();

	}

	public void validatePrimaryWirelessValueInTaskDetailsPage(String expectedValue) {

		String actualValue = tasksPage.prmarywirelessValue.getText();

		if (expectedValue.equals(actualValue)) {
			System.out.println("Primary Wireless Value Successfully validated");
		}

	}

	public void validateLinksInTaskDetailsPage(String linkName, String taskName) {

		if (linkName.equals("XIME Link")) {
			String link = tasksPage.ximeLink.getText();
			if (link.contains("XIME Link")) {
				System.out.println("Successfully validated the XIME link");
			} else if (linkName.equals("DWDM Link")) {
				String link2 = tasksPage.dwdmLink.getText();
				if (link2.contains("DWDM Link")) {
					System.out.println("Successfully validated the DWDM link");
				}
			}
		} else if (linkName.equals("Radio Link")) {
			String link3 = tasksPage.dwdmLink.getText();
			if (link3.contains("Radio Link")) {
				System.out.println("Successfully validated the DWDM link");
			}
		}

	}

	public void validatePrimarywirelessBannerOnTopOfOrderInformationSection() {

		String banner = tasksPage.primaryWirelessBanner.getText();
		if (banner.equals("Primary Wireless")) {
			System.out.println("Primary Wireless Banner Successfully validated");
		}

	}

	public void validateAltShippingAddressFieldInTaskDetailsPage() {

		String text = tasksPage.altShipAddress.getAttribute("tiltle");

		if ("Alt Ship to Address".equals(text)) {
			System.out.println("Alt Ship to Address field successfully validated");
		}

	}

	public void enterAltShipAddressFieldValue() {

		tasksPage.altShipAddress.sendKeys("Denver 101");
	}

	public void validateAltShipAddressFieldValue() {

		String actualAltShipAddress = tasksPage.altShipAddress.getAttribute("value");
		if ("Denver 101".equals(actualAltShipAddress)) {
			System.out.println("Alt Ship to Address value successfully validated");
		}

	}

	public void validateVendorOrderIdAttributeOnTaskDetails() {

		String vendorOrderIdattribute = tasksPage.vendorOrderId.getAttribute("title");

		if ("Vendor Order Id".endsWith(vendorOrderIdattribute)) {
			System.out.println("Successfully validated the Vendor Order Id in task details page");
		}

	}

	public void validateInternallySupportedCPEAttributeInTaskDetails() {
		Select s1 = new Select(tasksPage.internallySupprtedCPEDropdown);
		List<WebElement> ss1 = s1.getOptions();
		for (int i = 0; i < ss1.size() - 1; i++) {
			System.out.println(
					"Successully validated the internally supported attribute with values in Review CPE request");
		}
	}

	public void validateSelectedInternallySupportedCPEValue() {
		String internallySupprtedCPEValue = tasksPage.internallySupprtedCPE.getText();
		if ("No".equals(internallySupprtedCPEValue)) {
			System.out.println("Successfully validated the Internally Supported CPE value");
		}
	}

	public void validateDeviceNameMandatoryFieldWithMaxlengthCharacter() {

		String deviceNameField = tasksPage.deviceName.getText();
		System.out.println("");
		String maxLengthDeviceNameField = tasksPage.deviceName.getAttribute("maxlength");
		if (maxLengthDeviceNameField.equals("256")) {
			System.out.println("Successfully validated the Device Name maximum length");
		}

	}

	public void validateAttributesInAuto_Meraki_Init_TaskDetailsPage(List<List<String>> list) {

		for (int i = 0; i <= list.size() - 2; i++) {
			String exptectedValue = list.get(i + 1).get(0);

			System.out.println("Expected Data-" + exptectedValue);
			System.out.println("Successfully validated the " + exptectedValue + " attributes in task details page");

			// tasksPageSteps.validateLinksUrlInTaskDetailsPage(linkName,taskName);

		}

	}

	public void validateStaticIpAndWirelessIMEIAttributes() {

		String fieldStatus = tasksPage.staticIPField.getAttribute("mandatory");

	}

	public void validateDeviceNameFieldLength() {

		String fieldlengthStatus = tasksPage.deviceName.getAttribute("mandatory");
	}

	public void validateAccessSCID() {

	}

	public void validateCPESCID() {
		// TODO Auto-generated method stub

	}

	@Step
	public void validatePerformerNameinTaskReportingPage(String taskName) {
		tasksPage.validateBEPreformer(taskName);
	}

	@Step
	public void validateProcessNameinTaskReportingPage(String taskName) {
		tasksPage.validateEWASProcessTemplate(taskName);
	}

	@Step
	public void validatePrimaryDirectorInTaskDetailsPage() {
		tasksPage.validatePrimaryDirectorInTaskPage();
		tasksPage.sync(tasksPage, tasksPage.btn_BackToSearchResults);
		tasksPage.btn_BackToSearchResults.click();
		WaitForPageToLoad(60);

	}

	@Step
	public void validateDevicePIDInTaskDetailsPage() {
		tasksPage.validateDevicePIDInTaskPage();
	}

	@Step
	public void validateCPEPackageTypeInTaskPage() {
		tasksPage.validateCPEPackageTypeInTaskPage();

	}

	public void validateVendorOrderIdInTaskPage() {
		tasksPage.validateVendorOrderIdInTaskPage();

	}

	public void validateInternalTDGRequiredInTaskPage() {
		tasksPage.validateInternalTDGRequiredTaskPage();

	}

	public void validateExitToBAUFieldInTaskDetailsPage() {
		tasksPage.validateExitToBAUFieldInTaskDetailsPage();
	}

	public void validateRegionCodeValueInTaskDetailsPage() {
		tasksPage.validateRegionCodeValueInTaskDetailsPage();
	}

	public void validateCNRAttributesIntaskDetailsPage() {
		tasksPage.validateCNRAttributesIntaskDetailsPage();

	}

	public void validateEAIMCustomerNameInTaskDetailsPage() {
		tasksPage.validateEAIMCustomerNameInTaskDetailsPage();
	}

	public void validateClientSite_Or_AlternateSiteFieldsInTaskDetailsPage() {
		tasksPage.validateClientSite_Or_AlternateSiteFieldsInTaskDetailsPage();

	}

	public void selectsAlternate_Site_option_In_ClientSite_Or_AlternateSiteFieldsInTaskDetailsPage() {

		tasksPage.selectsAlternate_Site_option_In_ClientSite_Or_AlternateSiteFieldsInTaskDetailsPage();

	}

	public void validatesPL_and_SL_FieldsInTaskDetailsPage() {
		tasksPage.validatesPL_and_SL_FieldsInTaskDetailsPage();

	}

	public void selectsClient_Site_option_In_ClientSite_Or_AlternateSiteFieldsInTaskDetailsPage() {
		tasksPage.selectsClient_Site_option_In_ClientSite_Or_AlternateSiteFieldsInTaskDetailsPage();

	}

	public void validateCostOfInterventionFieldsInTaskDetailsPage() {
		tasksPage.validateCostOfInterventionFieldsInTaskDetailsPage();

	}

	public void validatesNoShowDropdownValuesInTaskReportingPage() {

		tasksPage.validatesNoShowDropdownValuesInTaskReportingPage();
	}

	public void validatesdropdownValuesInEAIMApprovalInterventionTask(List<List<String>> list) {
		tasksPage.validatesdropdownValuesInEAIMApprovalInterventionTask(list);

	}

	public void selectNoValueInNoShowDropdown() {

		tasksPage.selectNoValueInNoShowDropdown();
	}

	public void validateReasonForNoShowAttributesStatus() {
		tasksPage.selectNoValueInNoShowDropdown();
	}

	public void validatePrimaryDirectorDropDownValuesInTaskDetailsPage() {
		tasksPage.validatePrimaryDirectorDropdownValues();
	}

	public void enterActivationResultAndfcdDate(String taskName) {
	
		tasksPage.enterActivationResultAndfcdDate(taskName);
		
	}
	
	public void validateFCDwithCCD() {
		ExpectedConditions.visibilityOf(tasksPage.lbl_CCD);
		System.out.println("CCD:" +tasksPage.lbl_CCD.getText() );
		String[] ccd = tasksPage.lbl_CCD.getText().split("/");
		ExpectedConditions.elementToBeClickable(tasksPage.lbl_FCD);
		System.out.println("FCD:" +tasksPage.lbl_FCD.getText() );
		String[] fcd = tasksPage.lbl_FCD.getText().split("/");
		if(Integer.parseInt(fcd[1])==(Integer.parseInt(ccd[1])-2)) {
			System.out.println("Successfully validated FCD with CCD");
			System.out.println("And FCD is set as CCD-2 when CCD and FCD are not falling under holiday/weekend");
		}
		else {
			Assert.fail("FCD is not set as CCD-2 when CCD and FCD are not falling under holiday/weekend");
		}
		
		
	}
	public void autoPilotManagedOffnetTxtField(String autoPilotManagedOffnetTxtFieldvalue) {
		ExpectedConditions.visibilityOf(tasksPage.tbxAutopilotManagedOffnet);
		tasksPage.tbxAutopilotManagedOffnet.sendKeys(autoPilotManagedOffnetTxtFieldvalue);
		
	}
	public void createASRForDALOrder() {
		WebDriver driver = getDriver();
		Wait<WebDriver> wait = new WebDriverWait(driver, 180);
		WaitForPageToLoad(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y = tasksPage.groupASR.getLocation().getY()-200;
		js.executeScript("window.scrollBy(0,'"+y+"')");
		wait.until(ExpectedConditions.elementToBeClickable(tasksPage.groupASR));
		tasksPage.groupASR.click();
		System.out.println("Grouping ASR");
		WaitForPageToLoad(5000);
		
		try {
		for(int i = 1; i<tasksPage.asrTableHeaders.size();i++) {
			ExpectedConditions.visibilityOf(tasksPage.asrTableRows.get(i));
			
			switch(tasksPage.asrTableHeaders.get(i).getText()) {
			case "New Action":
				Select selNewAction = new Select(tasksPage.asrTableRows.get(i).findElement(By.tagName("Select")));
				selNewAction.selectByVisibleText("Install");
				break;
			case "ASR Product":
				Select selAsrProduct = new Select(tasksPage.asrTableRows.get(i).findElement(By.tagName("Select")));
				selAsrProduct.selectByVisibleText("Point to Point");
				break;
			case "CFA Company Name":
				Select selCFACompName = new Select(tasksPage.asrTableRows.get(i).findElement(By.tagName("Select")));
				selCFACompName.selectByVisibleText("Level 3");
				WaitForPageToLoad(5000);
				break;
			case "Automation Type":
				Select selAutomationType = new Select(tasksPage.asrTableRows.get(i).findElement(By.tagName("Select")));
				selAutomationType.selectByVisibleText("Auto Create");
				break;
			case "ACTL":
				tasksPage.asrTableRows.get(i).findElement(By.tagName("input")).sendKeys("FARGND56");;
				break;
			case "Request Due Date":
				tasksPage.asrTableRows.get(i).findElement(By.tagName("input")).sendKeys("12/12/2022");;
				break;
				
			}
		}
		ExpectedConditions.visibilityOf(tasksPage.asrTableHeaders.get(0));
		tasksPage.asrTableHeaders.get(0).findElement(By.tagName("input")).click();
		tasksPage.createGrpForSelectedRows.click();
		WaitForPageToLoad(5000);
		wait.until(ExpectedConditions.elementToBeClickable(tasksPage.btn_SaveAndComplete));
		System.out.println("ASR is grouped");
		}
		catch (Exception e) {
			Assert.fail("Getting error while grouping the ASR");
			
		}
		
		
		
	}
}
