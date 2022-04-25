package com.ctl.it.qa.bpms.pages;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hamcrest.core.IsNull;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import cucumber.api.Scenario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Switch;

public class CommonObjectsPage extends Page {

	private Page page;

	// Objects for Notification bar which shows number of Returned Search
	// Results*******************************
	@FindBy(xpath = "//ul[@class='ui-notification-container ui-helper-reset']")
	public WebElementFacade notificationContainer;

	@FindBy(xpath = "//*[@class='ui-notification-container ui-helper-reset']/descendant::a[@class='ui-icon ui-icon-close']")
	public WebElementFacade btn_CloseNotification;

	// *********************************************************************************************************

	// Objects for Navigation Bar i.e. Tasks, Orders, Task Reporting,....
	// etc***********************************
	@FindBy(xpath = "//div[@id='navigation']/descendant::a[contains(text(),'Tasks')]")
	@CacheLookup
	public WebElementFacade nav_Tasks;

	@FindBy(xpath = "//div[@id='navigation']/descendant::a[contains(text(),'Settings')]")
	@CacheLookup
	public WebElementFacade nav_Settings;

	@FindBy(xpath = "//a[contains(text(),'Admin')]")
	@CacheLookup
	public WebElementFacade nav_Admin;

	// *********************************************************************************************************

	// Objects from Criteria Toolbar Under Search Criteria
	// Header***********************************************
	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_ctl02_savedSearchesBtn")
	public WebElementFacade btn_SavedSearches_CriteriaToolbar;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_ctl02_loadSearchDropDown")
	public WebElementFacade dd_LoadSearch_CriteriaToolbar;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_ctl03_clearBtn")
	public WebElementFacade btn_Clear_CriteriaToolbar;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_ctl03_searchBtn")
	public WebElementFacade btn_Search_CriteriaToolbar;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_orderSearchDomainTabs_Quick")
	public WebElementFacade quickStartTab;

	// *********************************************************************************************************

	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return notificationContainer;
	}

	public void closeNotification() {
		syncObject(this, ExpectedConditions.visibilityOf(notificationContainer));
		// syncObject(this,
		// ExpectedConditions.presenceOfNestedElementsLocatedBy(notificationContainer,
		// ""));
		List<WebElement> list;
		if (notificationContainer.isCurrentlyVisible()) {
			list = notificationContainer.findElements(By.tagName("li"));
			for (WebElement webElement : list) {
				System.out.println(webElement.getText());
				if (syncObject(this,
						ExpectedConditions.elementToBeClickable(webElement.findElement(By.tagName("a"))))) {
					webElement.findElement(By.tagName("a")).click();
				}
			}
		}
	}

	public void checkAlert() {
		Boolean found = false;

		try {
			System.out.println("Waiting For Alert...");
			this.withTimeoutOf(Duration.ofSeconds(10)).waitFor(ExpectedConditions.alertIsPresent());
			found = true;
			System.out.println("Alert Found!!!");
		} catch (Exception exp) {
			// exp.printStackTrace();
			System.out.println("Alert Not Found!!!");
			found = false;
		} finally {
			if (found == true) {
				Alert alert = getDriver().switchTo().alert();
				alert.accept();
				System.out.println("Alert Accepted.");
				checkAlert();
			}
		}
	}

	public void syncPage(Page page) {
		try {
			page.withTimeoutOf(Duration.ofSeconds(30)).doWait().pollingEvery(Duration.ofSeconds(5))
					.ignoring(StaleElementReferenceException.class);
		} catch (Exception exp) {
			System.out.println("-----" + page.toString() + " - syncPage Failed-----");
			System.out.println("   --Message : - " + exp.getMessage());
			System.out.println("   --Cause : - " + exp.getCause());
			waitABit(5000);
			exp.printStackTrace();
		}
	}

	public void syncObject(Page page, WebElementFacade trgObj) {
		try {
			page.withTimeoutOf(Duration.ofSeconds(60)).waitFor(trgObj);
		} catch (Exception exp) {
			System.out.println("-----" + page.toString() + " - syncObject Failed without Condition-----");
			System.out.println("   --Object : - " + trgObj.getTagName() + " - " + trgObj.getText());
			System.out.println("   --Message : - " + exp.getMessage());
			System.out.println("   --Cause : - " + exp.getCause());
			waitABit(5000);
			exp.printStackTrace();
		}
	}

	public void syncObject(Page page, WebElement trgObj) {
		try {
			page.withTimeoutOf(Duration.ofSeconds(30)).waitFor(trgObj);
		} catch (Exception exp) {
			System.out.println("-----" + page.toString() + " - syncObject Failed without Condition-----");
			System.out.println("   --Object : - " + trgObj.getTagName() + " - " + trgObj.getText());
			System.out.println("   --Message : - " + exp.getMessage());
			System.out.println("   --Cause : - " + exp.getCause());
			waitABit(5000);
			exp.printStackTrace();
		}
	}

	public boolean syncObject(Page page, ExpectedCondition expectedCondition) {
		try {
			page.withTimeoutOf(Duration.ofSeconds(60)).waitFor(expectedCondition);
			return true;
		} catch (Exception exp) {
			System.out.println("-----TaskReportingPageSteps - syncObject Failed with Condition-----");
			System.out.println("   --Object : - " + expectedCondition.toString());
			System.out.println("   --Message : - " + exp.getMessage());
			System.out.println("   --Cause : - " + exp.getCause());
			waitABit(5000);
			exp.printStackTrace();
			return false;
		}
	}

	public void syncObject(Page page, boolean IsFluent) {
		try {
			page.withTimeoutOf(Duration.ofSeconds(30)).doWait().pollingEvery(Duration.ofSeconds(5))
					.ignoring(StaleElementReferenceException.class);
		} catch (Exception exp) {
			System.out.println("-----TaskReportingPageSteps - syncObject Failed without Condition-----");
			;
			System.out.println("   --Message : - " + exp.getMessage());
			System.out.println("   --Cause : - " + exp.getCause());
			waitABit(5000);
			exp.printStackTrace();
		}
	}

	public void syncObject(Page page, ExpectedCondition expectedCondition, boolean IsFluent) {
		try {
			page.withTimeoutOf(Duration.ofSeconds(30)).doWait().pollingEvery(Duration.ofSeconds(5))
					.ignoring(StaleElementReferenceException.class).until(expectedCondition);
		} catch (Exception exp) {
			System.out.println("-----TaskReportingPageSteps - syncObject Failed with Condition-----");
			System.out.println("   --Object : - " + expectedCondition.toString());
			System.out.println("   --Message : - " + exp.getMessage());
			System.out.println("   --Cause : - " + exp.getCause());
			waitABit(5000);
			exp.printStackTrace();
		}
	}

	public void openPortal(String userName) {
		IntDataContainer dataContainer = envData.getContainer(userName);
		openAt("http://" + dataContainer.getFieldValue("tbx_username") + ":"
				+ dataContainer.getFieldValue("tbx_password") + "@" + envData.getFieldValue("BPMS-url"));
		maximize();
		WaitForPageToLoad(120);
		checkAlert();
		closeNotification();
	}

	public void navigateToTasksPage() {
		syncObject(this, nav_Tasks);
		// syncObject(this, ExpectedConditions.elementToBeClickable(nav_Tasks));
		nav_Tasks.click();

		System.out.println("******************************");
		System.out.println("**        Tasks Page        **");
		System.out.println("******************************");

		WaitForPageToLoad(120);
	}

	public void navigateToSettingsPage() {
		syncObject(this, nav_Settings);
		// syncObject(ExpectedConditions.elementToBeClickable(this, nav_Settings));
		nav_Settings.click();

		System.out.println("*********************************");
		System.out.println("**        Settings Page        **");
		System.out.println("*********************************");

		WaitForPageToLoad(120);
	}

	public void navigateToAdminTab() {
		syncObject(this, nav_Admin);
		// syncObject(this, ExpectedConditions.elementToBeClickable(this, nav_Admin));
		nav_Admin.click();
		System.out.println("             -Admin Tab");
		WaitForPageToLoad(120);
	}

	public void clickSearchBtn_CriteriaToolbar() throws InterruptedException {
		syncObject(this, btn_Search_CriteriaToolbar);
		// syncObject(this,
		// ExpectedConditions.elementToBeClickable(btn_Search_CriteriaToolbar));
		btn_Search_CriteriaToolbar.click();

		WaitForPageToLoad(120);

		closeNotification();
	}

	public void clickResetBtn_CriteriaToolbar() {
		syncObject(this, btn_Clear_CriteriaToolbar);
		// syncObject(this,
		// ExpectedConditions.elementToBeClickable(btn_Clear_CriteriaToolbar));
		btn_Clear_CriteriaToolbar.click();

		WaitForPageToLoad(120);

	}

	public void navigateToQuickStartPageUnderOrderPage() {
		syncObject(this, quickStartTab);
		// syncObject(ExpectedConditions.elementToBeClickable(this, nav_Settings));
		quickStartTab.click();

		System.out.println("*********************************");
		System.out.println("**        QuickStarts        **");
		System.out.println("*********************************");

		WaitForPageToLoad(120);
	}

}
