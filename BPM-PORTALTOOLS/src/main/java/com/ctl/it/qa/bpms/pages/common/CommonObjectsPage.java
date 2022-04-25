package com.ctl.it.qa.bpms.pages.common;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.core.IsNull;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class CommonObjectsPage extends Page {

	private String currentOrderID;
	private String currTask;
	private String currTaskId;

	public int NoOfCols = 0;

	public Map<String, Integer> map = new HashMap<String, Integer>();
	// public Map<WebElement, List<WebElement>> rowMap = new HashMap<WebElement,
	// List<WebElement>>();

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

	@FindBy(xpath = "//div[@id='navigation']/descendant::a[contains(text(),'Orders')]")
	// @CacheLookup
	public WebElementFacade nav_Orders;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_orderSearchDomainTabs_Customer Order")
	public WebElementFacade tab_CustomerOrder_OrdersPage;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl03_domainTabs_Network Order")
	public WebElementFacade tab_NetworkOrder_TaskReportingPage;
	              
	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl03_domainTabs_Quick Start")
	public WebElementFacade tab_quickStart_TaskReportingPage;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_orderSearchDomainTabs_Quick Start")
	public WebElementFacade tab_quickStart_OrderPage;

	@FindBy(xpath = "//div[@id='navigation']/descendant::a[contains(text(),'Settings')]")
	@CacheLookup
	public WebElementFacade nav_Settings;

	@FindBy(xpath = "//a[contains(text(),'Admin')]")
	@CacheLookup
	public WebElementFacade nav_Admin;

	@FindBy(xpath = "//div[@id='navigation']/descendant::a[contains(text(),'Task Reporting')]")
	// @CacheLookup
	public WebElementFacade nav_TaskReporting;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_headerTabs_Common Criteria")
	public WebElementFacade tab_CommonCriteria_TaskReportingPage;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_headerTabs_Domain Criteria")
	public WebElementFacade tab_DomainCriteria_TaskReportingPage;

	// *********************************************************************************************************

	// Object for
	// Loading***************************************************************************************
	@FindBy(xpath = "//span[contains(@id,'loadingIndicator')]")
	public WebElementFacade ele_Loading;

	// *********************************************************************************************************

	// Object for
	// Table*****************************************************************************************
	@FindBy(id = "ctl00_mainContent_searchView_resultsPanel_ResultsGrid")
	public WebElementFacade tbl_SearchResults;

	@FindBy(xpath = "//table[@id='ctl00_mainContent_searchView_resultsPanel_ResultsGrid']/tbody/tr[contains(@class,'grid-row')]")
	public List<WebElementFacade> rows;

	@FindBy(xpath = "//table[@id='ctl00_mainContent_searchView_resultsPanel_ResultsGrid']/tbody/tr[contains(@class,'grid-row')][1]/td")
	public List<WebElementFacade> columns;

	@FindBy(xpath = "//table[@id='ctl00_mainContent_searchView_resultsPanel_ResultsGrid']/tbody/tr[contains(@class,'grid-header')]/th")
	public List<WebElementFacade> headers;

	@FindBy(id = "ctl00_mainContent_searchView_resultsPanel_refreshBtn")
	public WebElementFacade btn_Refresh_SearchResults;

	// *********************************************************************************************************

	public void setCurrentOrderID(String trgOrderID) {
		this.currentOrderID = trgOrderID;
	}

	public String getCurrentOrderID() {
		return this.currentOrderID;
	}

	public void setCurrTask(String trgTaskName) {
		this.currTask = trgTaskName;
	}

	public String getCurrTask() {
		return this.currTask;
	}

	public void setCurrTaskId(String trgTaskId) {
		this.currTaskId = trgTaskId;
	}

	public String getCurrTaskId() {
		return this.currTaskId;
	}

	public void openPortal(String userName) {
		IntDataContainer dataContainer = envData.getContainer(userName);

		openAt("http://" + dataContainer.getFieldValue("tbx_username") + ":"
				+ dataContainer.getFieldValue("tbx_password") + "@" + envData.getFieldValue("BPMS-url"));
		System.out.println("Opening Portal...     --Successful");

		maximize();
		WaitForPageToLoad(120);
	}

	public List<WebElementFacade> getTableRows() {
		try {
			sync(this, ExpectedConditions.visibilityOf(rows.get(1)));
		} catch (Exception exp) {
			PageFactory.initElements(this.getDriver(), this);
		}

		if (rows.size() == 0) {
			getTableRows();
		}

		System.out.println("Syncing Rows...     --Successful");
		return rows;
	}

	public List<WebElementFacade> getTableColumns() {
		try {
			sync(this, ExpectedConditions.visibilityOf(columns.get(1)));
		} catch (Exception exp) {
			PageFactory.initElements(this.getDriver(), this);
		}

		// System.out.println("Syncing Columns... --Successful");
		return columns;
	}

	public List<WebElementFacade> getTableHeaders() {
		try {
			sync(this, ExpectedConditions.visibilityOf(headers.get(1)));
		} catch (Exception exp) {
			PageFactory.initElements(this.getDriver(), this);
			map.clear();
		}

		NoOfCols = headers.size();
		if (NoOfCols != map.size()) {
			map.clear();
		}

		// System.out.println("Syncing Headers... --Successful");
		return headers;
	}

	public int getColumnNum(String columnName, List<WebElementFacade> headers) {

		if (headers == null || headers.size() < 1) {
			headers = getTableHeaders();
		}
		int columnNum = 0;

		// sync(this, this.tbl_SearchResults);
		// sync(this, ExpectedConditions.visibilityOf(headers.get(0)), true);

		try {
			columnNum = map.get(columnName);
		} catch (Exception exp) {
			for (int i = 0; i < headers.size(); i++) {
				map.put(headers.get(i).getText(), i + 1);
			}
		} finally {
			columnNum = map.get(columnName);
		}

		System.out.println("Column Number for Column : " + columnName + " is : " + columnNum);
		return columnNum;
	}

	public void refreshSearchResult() {

		System.out.println("Refreshing Search Result...");
		sync(this);
		sync(this, ExpectedConditions.elementToBeClickable(btn_Refresh_SearchResults));

		try {
			btn_Refresh_SearchResults.click();
		} catch (ElementClickInterceptedException exp) {
			waitABit(5000);
			btn_Refresh_SearchResults.click();
		} finally {
			WaitForPageToLoad(60);
		}

// 		if(sync(this, ExpectedConditions.visibilityOf(ele_Loading))) {
// 			sync(this, ExpectedConditions.invisibilityOf(ele_Loading));
// 		} else {
// 			sync(this, ExpectedConditions.visibilityOf(ele_Loading));
// 			sync(this, ExpectedConditions.invisibilityOf(ele_Loading));
// 		}

		waitABit(8000);
		sync(this, ExpectedConditions.elementToBeClickable(btn_Refresh_SearchResults));

		System.out.println("Refreshing Search Result...     --Successful");

//		if (ele_Loading.isCurrentlyVisible()) {
//			sync(this, ExpectedConditions.invisibilityOf(ele_Loading));
//		}

		sync(this, ExpectedConditions.elementToBeClickable(btn_Refresh_SearchResults));

		System.out.println("Refreshing Search Result...     --Successful");

	}

	public void sync(Page page) {
		try {
			page.withTimeoutOf(Duration.ofSeconds(60)).doWait().pollingEvery(Duration.ofSeconds(5))
					.ignoring(StaleElementReferenceException.class);
		} catch (Exception exp) {
			printErrorDetails(exp);
		}
	}

	public void sync(Page page, WebElementFacade trgObj) {
		try {
			page.withTimeoutOf(Duration.ofSeconds(60)).waitFor(trgObj);
		} catch (StaleElementReferenceException staleExp) {
			page.withTimeoutOf(Duration.ofSeconds(60)).waitFor(trgObj);
		} catch (Exception exp) {
			printErrorDetails(exp);
		}

	}

	public void sync(Page page, WebElement trgObj) {
		try {
			page.withTimeoutOf(Duration.ofSeconds(60)).waitFor(trgObj);
		} catch (StaleElementReferenceException staleExp) {
			page.withTimeoutOf(Duration.ofSeconds(60)).waitFor(trgObj);
		} catch (Exception exp) {
			printErrorDetails(exp);
		}

	}

	public boolean sync(Page page, ExpectedCondition expectedCondition) {
		try {
			page.withTimeoutOf(Duration.ofSeconds(60)).waitFor(expectedCondition);
			return true;
		} catch (StaleElementReferenceException staleExp) {
			page.withTimeoutOf(Duration.ofSeconds(60)).waitFor(expectedCondition);
			return true;
		} catch (Exception exp) {
			printErrorDetails(exp);
			return false;
		}
	}

	public void sync(Page page, ExpectedCondition expectedCondition, boolean IsFluent) {
		try {
			page.withTimeoutOf(Duration.ofSeconds(60)).doWait().pollingEvery(Duration.ofSeconds(5))
					.ignoring(StaleElementReferenceException.class, NoSuchElementException.class)
					.until(expectedCondition);
		} catch (StaleElementReferenceException staleExp) {
			page.withTimeoutOf(Duration.ofSeconds(60)).doWait().pollingEvery(Duration.ofSeconds(5))
					.ignoring(StaleElementReferenceException.class, NoSuchElementException.class)
					.until(expectedCondition);
		} catch (Exception exp) {
			printErrorDetails(exp);
		}
	}

	public void printErrorDetails(Exception exp) {
		System.out.println("-----  Sync Failed  -----");
		System.out.println("  -Message :- " + exp.getMessage());
		System.out.println("  -Cause : - " + exp.getCause());
		waitABit(5000);
		exp.printStackTrace();
	}

	public void navigateTo_TasksPage() {
		sync(this, nav_Tasks);

		nav_Tasks.click();
		System.out.println("Navigating to Tasks Page...     --Successful");

		System.out.println("********************");
		System.out.println("*    Tasks Page    *");
		System.out.println("********************");

		WaitForPageToLoad(120);
	}

	public void navigateTo_OrdersPage() {
		sync(this, nav_Orders);
		// syncObject(ExpectedConditions.elementToBeClickable(nav_Orders));

		nav_Orders.click();
		System.out.println("Navigating to Orders Page...     --Successful");

		System.out.println("*********************");
		System.out.println("*    Orders Page    *");
		System.out.println("*********************");

		WaitForPageToLoad(120);
	}

	public void navigateTo_CustomerOrderTab() {
		sync(this, tab_CustomerOrder_OrdersPage);

		tab_CustomerOrder_OrdersPage.click();
		System.out.println("Navigating to Customer Order Tab...     --Successful");

		WaitForPageToLoad(120);
	}

	public void navigateTo_TaskReportingPage() {
		sync(this, nav_TaskReporting);
		// syncObject(ExpectedConditions.elementToBeClickable(nav_TaskReporting));

		nav_TaskReporting.click();
		System.out.println("Navigating to Task Reporting Page...     --Successful");

		System.out.println("*****************************");
		System.out.println("*    Task Reporting Page    *");
		System.out.println("*****************************");

		WaitForPageToLoad(120);
	}

	public void navigateTo_CommonCriteria() {
		sync(this, tab_CommonCriteria_TaskReportingPage);

		tab_CommonCriteria_TaskReportingPage.click();
		System.out.println("Navigating to Common Criteria Tab...     --Successful");

		WaitForPageToLoad(60);
	}

	public void navigateTo_DomainCriteria() {
		sync(this, tab_DomainCriteria_TaskReportingPage);

		tab_DomainCriteria_TaskReportingPage.click();
		System.out.println("Navigating to Domain Criteria Tab...     --Successful");

		WaitForPageToLoad(60);
	}

	public void navigateTo_SettingsPage() {
		sync(this, nav_Settings);

		nav_Settings.click();
		System.out.println("Navigating to Settings Page...     --Successful");

		System.out.println("***********************");
		System.out.println("*    Settings Page    *");
		System.out.println("***********************");

		WaitForPageToLoad(120);
	}

	public void navigateTo_SettingsPage_AdminTab() {
		sync(this, nav_Admin);

		nav_Admin.click();
		System.out.println("Navigating to Admin Tab...     --Successful");

		WaitForPageToLoad(120);
	}

	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return notificationContainer;
	}

	public void navigateTo_NetworkOrderPage() {
		sync(this, tab_NetworkOrder_TaskReportingPage);

		tab_NetworkOrder_TaskReportingPage.click();
		System.out.println("Navigating to Network Order Page...     --Successful");

		System.out.println("***********************");
		System.out.println("*    Network Order Page    *");
		System.out.println("***********************");

		WaitForPageToLoad(120);
	}

	public void navigateTo_QuickStartPageUnderTaskReporting() {
		sync(this, tab_quickStart_TaskReportingPage);

		tab_quickStart_TaskReportingPage.click();
		System.out.println("Navigating to QuickStart Page...     --Successful");

		System.out.println("***********************");
		System.out.println("*    QuickStart Page    *");
		System.out.println("***********************");

		WaitForPageToLoad(120);
	}

	public void navigateToQuickStartPageUnderOrderPage() {
		sync(this, tab_quickStart_OrderPage);

		tab_quickStart_OrderPage.click();
		System.out.println("Navigating to QuickStart Order Page...     --Successful");

		System.out.println("***********************");
		System.out.println("*    QuickStart Order Page    *");
		System.out.println("***********************");

		WaitForPageToLoad(120);

	}

}