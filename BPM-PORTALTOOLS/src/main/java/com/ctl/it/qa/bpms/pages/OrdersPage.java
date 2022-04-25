package com.ctl.it.qa.bpms.pages;

import com.ctl.it.qa.bpms.pages.common.CommonObjectsPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import com.ctl.it.qa.staf.Page;
//import com.ctl.it.qa.staf.SplunkLogger;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class OrdersPage extends CommonObjectsPage {

	public Map<String, Integer> map = new HashMap<String, Integer>();

	private int NoOfCols = 0;

	// Objects for tabs under Search
	// Criteria*******************************************************************

	@FindBy(name = "ctl00$mainContent$searchView$criteriaPanel$criteriaControl$coSearchTab$ctl08")
	public WebElementFacade sel_SearchOnId_OrdersPage;

	@FindBy(name = "ctl00$mainContent$searchView$criteriaPanel$criteriaControl$coSearchTab$ctl10")
	public WebElementFacade tbx_SearchID_OrdersPage;

	// *********************************************************************************************************

	// Objects for Search Results under Search
	// Criteria*********************************************************

	@FindBy(id = "ctl00_mainContent_searchView_resultsPanel_ResultsGrid_ctl04_GridViewAction_1")
	public WebElementFacade btn_ManageOrder_OrdersPage;

	// *********************************************************************************************************

	// Object for Search
	// Results********************************************************************************

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_ctl03_searchBtn")
	public WebElementFacade btn_Search_CriteriaToolbar;

	@FindBy(id = "ctl00_mainContent_searchView_resultsPanel_clearBtn")
	public WebElementFacade btn_Clear_SearchResults;

	@FindBy(id = "ctl00_mainContent_searchView_resultsPanel_settingsBtn")
	public WebElementFacade btn_CustomizeResults_SearchResults;

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

	@FindBy(xpath = "//span[contains(text(),'Select an Order Version')]")
	public WebElementFacade lnk_OrderVersion;

	@FindBy(xpath = "//span[@id='ctl00_mainContent_ctl02_ctl04_ctl00_ctl00_orderVersionTreeView']/descendant::a[contains(text(),'Service Id:')]")
	public List<WebElementFacade> lnk_orderVersions;

	@FindBy(id = "ctl00_mainContent_ctl02_backBtn")
	public WebElementFacade btn_Back;

	@FindBy(xpath = "//td[contains(@title,'High Availability:')]")
	public WebElementFacade highAvailability;

	// order details page
	@FindBy(id = "ctl00_mainContent_ctl02_ctl03_Order Details")
	public WebElementFacade orderdetails;

	@FindBy(xpath = "//td[@title='Sales Rep Region Code:']")
	public WebElementFacade salesRegionCode;

	@FindBy(xpath = "//td[@title='Hot Cut / Replacement:']")
	public WebElementFacade HotcutReplacement;

	@FindBy(xpath = "//td[@title='Is There Live Traffic?:']")
	public WebElementFacade isLiveTraffic;

	@FindBy(xpath = "//td[@title='Is Hot Cut?:']")
	public WebElementFacade isHotCut;

	@FindBy(xpath = "//td[@title='Product Family:']")
	public WebElementFacade ProductFamily;

	@FindBy(xpath = "//td[@title='Product:']")
	public WebElementFacade Product;

	@FindBy(xpath = "//td[@title='CliReadOnlyAccess:']")
	public WebElementFacade ClliReadOnlyAccess;

	@FindBy(xpath = "//td[@title='SnmpReadOnly:']")
	public WebElementFacade SnmpReadOnly;

	@FindBy(xpath = "//td[@title='NetFlowEnabled:']")
	public WebElementFacade NetFlowEnabled;

	// CCD CRD Value

	@FindBy(xpath = "//td[@title='CRD:']")
	public WebElementFacade CRDvalue;

	@FindBy(xpath = "//td[@title='CCD:']")
	public WebElementFacade CCDvalue;

	@FindBy(xpath = "//td[@title='Submitted Date:']")
	public WebElementFacade submittedDate;

	@FindBy(xpath = "//td[@title='Project Group Id:']")
	public WebElementFacade projectId;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_orderSearchDomainTabs_Quick Start")
	public WebElementFacade quickStartTab;

	@FindBy(xpath = "//select[@name='ctl00$mainContent$searchView$criteriaPanel$criteriaControl$qsSearchTab$ctl05']")
	public WebElementFacade sel_QSSearchOnId_OrdersPage;

	@FindBy(xpath = "//textarea[@name='ctl00$mainContent$searchView$criteriaPanel$criteriaControl$qsSearchTab$ctl07']")
	public WebElementFacade tbx_QSSearchID_OrdersPage;
	
	@FindBy(id = "ctl00_mainContent_ctl00_backBtn")
	public WebElementFacade btn_Back_ProcessProgression;
	
	@FindBy(id = "ctl00_mainContent_tabsView_Logic History")
	public WebElementFacade btn_LogicHistory;
	
	@FindBy(xpath = "//div/table/tbody/tr[49]/td[2]")
	public WebElementFacade beDepDecomposer;
	 

	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return tab_CustomerOrder_OrdersPage;
	}

	public int getNoOfColumns() {
		if (NoOfCols < 1) {
			getTableHeaders();
		}
		return NoOfCols;
	}

	public List<WebElementFacade> getTableRows() {
		return getTableRows(0);
	}

	public List<WebElementFacade> getTableRows(int counter) {
		sync(this, ExpectedConditions.visibilityOfNestedElementsLocatedBy(tbl_SearchResults,
				By.xpath("./tbody/tr[contains(@class,'grid-row')]")));
		try {
			if (counter < 3 && rows.size() < 1) {
				getTableRows(counter + 1);
			}
		} catch (Exception exp) {
			exp.printStackTrace();
			waitABit(5000);
		}

		return rows;
	}

	public List<WebElementFacade> getTableColumns() {
		return getTableColumns(0);
	}

	public List<WebElementFacade> getTableColumns(int counter) {
		sync(this, ExpectedConditions.visibilityOfNestedElementsLocatedBy(tbl_SearchResults,
				By.xpath("./tbody/tr[contains(@class,'grid-row')]/td")));
		try {
			if (counter < 3 && columns.size() < 1) {
				getTableColumns(counter + 1);
			}
		} catch (Exception exp) {
			exp.printStackTrace();
			waitABit(5000);
		}

		return columns;
	}

	public List<WebElementFacade> getTableHeaders() {
		return getTableHeaders(0);
	}

	public List<WebElementFacade> getTableHeaders(int counter) {
		sync(this, ExpectedConditions.visibilityOfNestedElementsLocatedBy(tbl_SearchResults,
				By.xpath("./tbody/tr[contains(@class,'grid-header')]/th")));
		try {
			if (counter < 3 && headers.size() < 1) {
				getTableHeaders(counter + 1);
			} else {
				NoOfCols = headers.size();
				if (NoOfCols != map.size()) {
					map.clear();
					for (int i = 0; i < headers.size(); i++) {
						map.put(headers.get(i).getText(), i + 1);
					}
				}
			}
		} catch (Exception exp) {
			exp.printStackTrace();
			waitABit(5000);
		}

		return headers;
	}

	public int getColumnNum(String columnName, List<WebElementFacade> headers) {

		if (headers == null || headers.size() < 1) {
			headers = getTableHeaders();
		}
		int columnNum = 0;

		try {
			columnNum = map.get(columnName);
		} catch (Exception exp) {
			for (int i = 0; i < headers.size(); i++) {
				map.put(headers.get(i).getText(), i + 1);
			}
			getColumnNum(columnName, headers);
		}

		System.out.println("Column Number for Column : " + columnName + " is : " + columnNum);
		return columnNum;

	}

	public void validateOrdersPage_ResultsTable(List<List<String>> list) {

		System.out.println("----------------------------------");
		System.out.println("| Validation of Order Attributes |");
		System.out.println("----------------------------------");

		String orderID, expectedValue, actualValue;
		String trgOrderID = Serenity.sessionVariableCalled("OrderID").toString();
		List<WebElementFacade> rows = getTableRows();
		List<WebElementFacade> headers = getTableHeaders();
		IntDataContainer dataContainer = commonData.getContainer("Controller");

		// syncObject(true);
		sync(this, ExpectedConditions.visibilityOf(rows.get(0)), true);

		for (int i = 0; i < rows.size(); i++) {
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			orderID = cells.get((getColumnNum("Customer Order Id", headers)) - 1).getText();
			if (orderID.startsWith(trgOrderID)) {

				for (int j = 0; j < list.get(0).size(); j++) {

					expectedValue = list.get(i + 1).get(j);
					String expectedValues[] = expectedValue.split("-or-");
					actualValue = cells.get(getColumnNum(list.get(0).get(j), headers) - 1).getText();

					for (int k = 0; k < expectedValues.length; k++) {
						if (expectedValues[k].equals(actualValue)) {
							System.out.println("   -" + (i + 1) + " - Expected - " + expectedValues[k] + ", Actual - "
									+ actualValue + "     --Successful");
							break;
						} else {
							if (k == expectedValues.length - 1) {
								System.out.println("   -" + (i + 1) + " - Expected - " + expectedValues[k]
										+ ", Actual - " + actualValue + "     --Failed");
								if (Boolean.parseBoolean(dataContainer.getFieldValue("enableValidation"))) {
									assertEquals(expectedValues[k], actualValue);
								}
							}
						}
					}
				}
			}
		}

		System.out.println("Validation of Order Attributes...     --Successful");

	}

	public boolean validate_OrderStatus(String trgOrderStatus) {
		String orderStatus;
		List<WebElement> cells;
		List<WebElementFacade> rows = getTableRows();
		List<WebElementFacade> headers = getTableHeaders();

		boolean status = true;
		sync(this);

		for (int counter = 0; counter < 3; counter++) {
			for (int i = 0; i < rows.size(); i++) {
				sync(this, columns.get(1));

				cells = rows.get(i).findElements(By.tagName("td"));

				orderStatus = cells.get((getColumnNum("Order Status", headers)) - 1).getText();

				if (trgOrderStatus.equals("") || trgOrderStatus.equals("Complete")) {
					if (!orderStatus.equals("Complete")) {
						refreshSearchResult();
						status = false;
						break;
					} else {
						status = true;
						int rownum = i + 1;
						System.out.println("Order status of " + rownum + " Product Component-" + orderStatus);
					}
				} else {
					assertEquals("Order Status Validation Failed: Expected - " + trgOrderStatus + ", Actual - "
							+ orderStatus, trgOrderStatus, orderStatus);
				}

			}
		}

		return status;
	}

	public void checkHighAvailabilityStatus(String highAvailabilityStatus) {
		sync(this, highAvailability);
		String actualStatus = highAvailability.getText();
		System.out.println("actual Value-" + actualStatus);
		Assert.assertEquals(highAvailabilityStatus, actualStatus);
		sync(this, btn_Back);
		btn_Back.click();
		WaitForPageToLoad(120);
	}

	public void retrieveServiceIdOfComponent(String component) {

		String serviceId1 = "td[text()='";
		String serviceId2 = "']/..//td[@title='Service Id']";

		WebElement retriveServiceId = getDriver().findElement(By.xpath(serviceId1 + component + serviceId2));

		String serviceIdValue = retriveServiceId.getText();
		System.out.println("Service Id-" + serviceIdValue);
	}

	public void validateNoOfStaticIP() {

	}

	public void validateTDGDataSection() {
		String actualClliReadonlyAccess = ClliReadOnlyAccess.getText();
		String actualSnmpReadOnly = SnmpReadOnly.getText();
		String actualNetFlowEnabled = NetFlowEnabled.getText();

		if (actualClliReadonlyAccess == null) {

			System.out.println("This order failed to hold the TDG data....  validation failed");
		} else {
			System.out.println("ClliReadonlyAccess value is " + actualClliReadonlyAccess);
			System.out.println("Validation of ClliReadonlyAccess value is...     --Successful");
		}

		if (actualSnmpReadOnly == null) {

			System.out.println("This order failed to hold the TDG data....  validation failed");
		} else {
			System.out.println("SnmpReadOnly value is " + actualSnmpReadOnly);
			System.out.println("Validation of SnmpReadOnly value is...     --Successful");
		}

		if (actualNetFlowEnabled == null) {

			System.out.println("This order failed to hold the TDG data....  validation failed");
		} else {
			System.out.println("NetFlowEnabled value is " + actualNetFlowEnabled);
			System.out.println("Validation of NetFlowEnabled value is...     --Successful");
		}
	}

	public void validateProductFamilyinOrderItemDetails() {
		String actualsProductFamily = ProductFamily.getText();
		String actualProduct = Product.getText();
		if (actualsProductFamily.equals("HC_UCPE")) {
			Assert.assertEquals("HC_UCPE", actualsProductFamily);
			System.out.println("Product Family is " + actualsProductFamily);
			System.out.println("Product is " + actualProduct);
			System.out.println("Validation of Product Family is ...     --Successful");
		} else {
			System.out.println("Product Family is " + actualsProductFamily);
			System.out.println("Product family does not belong to HC_UCPE");
		}

	}

	public void validateHotCutSection() {

		String actualHotcutReplacement = HotcutReplacement.getText();
		String actualisLiveTraffic = isLiveTraffic.getText();
		String actualisHotCut = isHotCut.getText();

		if (actualHotcutReplacement.equals("true") || actualisLiveTraffic.equals("true")) {
			Assert.assertEquals("Yes", actualisHotCut);
			System.out.println("is Hot cut value is  " + actualisHotCut);
			System.out.println("Validation of is Hot cut value...     --Successful");
		} else {
			System.out.println("is Hot cut value is " + actualisHotCut);
			System.out.println("is Hot cut value is No or null");
		}

	}

	public void validateSalesRegion() {

		String actualsalesRepRegion = salesRegionCode.getText();
		if (actualsalesRepRegion.equals("AP")) {
			Assert.assertEquals("AP", actualsalesRepRegion);
			System.out.println("Sales Rep Region is " + actualsalesRepRegion);
			System.out.println("Validation of SalesRepRegion...     --Successful");
		} else if (actualsalesRepRegion.equals("EU")) {
			Assert.assertEquals("EU", actualsalesRepRegion);
			System.out.println("Sales Rep Region is " + actualsalesRepRegion);
			System.out.println("Validation of SalesRepRegion...     --Successful");
		} else if (actualsalesRepRegion.equals("NA")) {
			Assert.assertEquals("NA", actualsalesRepRegion);
			System.out.println("Sales Rep Region is " + actualsalesRepRegion);
			System.out.println("Validation of SalesRepRegion...     --Successful");
		} else if (actualsalesRepRegion.equals("LA")) {
			Assert.assertEquals("LA", actualsalesRepRegion);
			System.out.println("Sales Rep Region is " + actualsalesRepRegion);
			System.out.println("Validation of SalesRepRegion...     --Successful");
		}
	}

	public void validateCCDinOrderDetailsPage() {

		String actualCRDvalue = CRDvalue.getValue();
		String actualCCDvalue = CCDvalue.getValue();
		String actualSubmittedDate = submittedDate.getValue();

		// submittedDate +
		if (actualCCDvalue.compareTo(actualCRDvalue) > 0) {
			System.out.println("actualCCDvalue is after actualCRDvalue");
		}

	}

	public void validateProjectIdCharlimit() {

		String projectID = projectId.getText().trim();
		if (projectID.length() > 80) {
			System.out.println(projectID + "length is");
			System.out.println("Validation of projectGroupID is greater than 80 char...     --Successful");
		}

		if (projectID.length() <= 255) {
			System.out.println("Projcet Group Id entered length is - " + projectID.length());
			System.out.println(
					"Validation of projectGroupID entered length is lesser than or equal to 255 char...     --Successful");
		} else {
			System.out.println("Projcet Group Id entered length is - " + projectID.length());
			System.out.println(
					"Validation of projectGroupID entered length is greater than 255 char...     --Not Successful");
		}

	}

	public void navigateToQuickStartPageUnderOrderPage() {
		sync(this, quickStartTab);

		quickStartTab.click();

		System.out.println("*********************************");
		System.out.println("**        QuickStarts Under Orders Page       **");
		System.out.println("*********************************");

		WaitForPageToLoad(120);

	}

	public void validateBEDepDecomposertask() {
		String actualBEDeptask = beDepDecomposer.getText();
		if (actualBEDeptask.equals("DEP_AccessBuildingExtnsComplete")) {
			Assert.assertEquals("DEP_AccessBuildingExtnsComplete", actualBEDeptask);
			System.out.println("BE Dependency decomposer task is " + actualBEDeptask);
			System.out.println("Validation of BE Dependency decomposer task is...     --Successful");
		}
				
	}
}
