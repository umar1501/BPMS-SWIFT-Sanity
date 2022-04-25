package com.ctl.it.qa.bpms.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ctl.it.qa.bpms.pages.common.CommonObjectsPage;
import com.ctl.it.qa.bpms.steps.SettingsPageSteps;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SettingsPage extends CommonObjectsPage {

	SettingsPageSteps settingsPageSteps;

	// Objects for Task
	// Completion******************************************************************************

	@FindBy(xpath = "//td[contains(@title,'Task Status')]")
	public WebElementFacade lbl_TaskStatus_ManageTask;

	@FindBy(xpath = "//input[contains(@value,'Save & Complete')]")
	public WebElementFacade btn_SaveAndComplete;

	// *********************************************************************************************************

	// Objects for
	// Impersonation********************************************************************************

	@FindBy(id = "ctl00_ctl00_mainContent_contentPlaceHolder_impersonationUserNameTxtBox")
	public WebElementFacade tbx_Impersonate;

	@FindBy(id = "ctl00_ctl00_mainContent_contentPlaceHolder_impersonateBtn")
	public WebElementFacade btn_Impersonate;

	@FindBy(id = "ctl00_ctl00_mainContent_contentPlaceHolder_removeAllCache")
	public WebElementFacade btn_RemoveAllCache;

	@FindBy(xpath = "//a[contains(text(),'Undo Impersonation')]")
	public WebElementFacade lnk_UndoImpersonate;

	@FindBy(xpath = "//div[@id='content']/h4[contains(text(),'necessary permissions')]")
	public WebElementFacade lbl_AccessError;

	// *********************************************************************************************************

	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return tbx_Impersonate;
	}

	public void enterImpersonationID(String trgUser) {
		sync(this, tbx_Impersonate);
		tbx_Impersonate.sendKeys(trgUser);
	}

	public void ImpersonateUser(String trgUser) {
		navigateTo_SettingsPage();
		navigateTo_SettingsPage_AdminTab();
		WaitForPageToLoad(60);
		System.out.println(lbl_AccessError.isVisible());
		if (lbl_AccessError.isCurrentlyVisible()) {
			assertTrue("User Does not the access for Admin Page", false);
		}
		enterImpersonationID(trgUser);
		btn_Impersonate.click();
		WaitForPageToLoad(60);
		// syncObject(taskReportingPage.lnk_UndoImpersonate);
		sync(this, ExpectedConditions.elementToBeClickable(lnk_UndoImpersonate));
		System.out.println("Impersonating the current user to - " + trgUser + "     --Successful");
		navigateTo_TaskReportingPage();
	}

}
