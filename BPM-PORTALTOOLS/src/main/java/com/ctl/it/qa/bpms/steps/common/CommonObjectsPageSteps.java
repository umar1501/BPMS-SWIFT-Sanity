package com.ctl.it.qa.bpms.steps.common;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ctl.it.qa.bpms.pages.common.CommonObjectsPage;
import com.ctl.it.qa.bpms.steps.RegressionSteps;
import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.Steps;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class CommonObjectsPageSteps extends Steps {

	CommonObjectsPage commonObjectsPage;

	@Step
	public Page getPage() {
		return commonObjectsPage;
	}

	@Step
	public void setCurrentOrderID(String trgOrderID) {
		commonObjectsPage.setCurrentOrderID(trgOrderID);
	}

	@Step
	public String getCurrentOrderID() {
		return commonObjectsPage.getCurrentOrderID();
	}

	@Step
	public void setCurrTask(String trgTaskName) {
		commonObjectsPage.setCurrTask(trgTaskName);
	}

	@Step
	public String getCurrTask() {
		return commonObjectsPage.getCurrTask();
	}

	@Step
	public void setCurrTaskId(String trgTaskId) {
		commonObjectsPage.setCurrTaskId(trgTaskId);
	}

	@Step
	public String getCurrTaskId() {
		return commonObjectsPage.getCurrTaskId();
	}

	@Step
	public void sync(Page page) {
		commonObjectsPage.sync(page);
	}

	@Step
	public void sync(Page page, WebElementFacade trgObj) {
		commonObjectsPage.sync(page, trgObj);
	}

	@Step
	public void sync(Page page, WebElement trgObj) {
		commonObjectsPage.sync(page, trgObj);
	}

	@Step
	public boolean sync(Page page, ExpectedCondition expectedCondition) {
		return commonObjectsPage.sync(page, expectedCondition);
	}

	@Step
	public void sync(Page page, ExpectedCondition expectedCondition, boolean IsFluent) {
		commonObjectsPage.sync(page, expectedCondition, IsFluent);
	}

	@Step
	public void navigateTo_TasksPage() {
		commonObjectsPage.navigateTo_TasksPage();
	}

	@Step
	public void navigateTo_OrdersPage() {
		commonObjectsPage.navigateTo_OrdersPage();
	}

	@Step
	public void navigateTo_CustomerOrderTab() {
		commonObjectsPage.navigateTo_CustomerOrderTab();
	}

	@Step
	public void navigateTo_TaskReportingPage() {
		commonObjectsPage.navigateTo_TaskReportingPage();
	}

	@Step
	public void navigateTo_CommonCriteria() {
		commonObjectsPage.navigateTo_CommonCriteria();
	}

	@Step
	public void navigateTo_DomainCriteria() {
		commonObjectsPage.navigateTo_DomainCriteria();
	}

	@Step
	public void navigateTo_SettingsPage() {
		commonObjectsPage.navigateTo_SettingsPage();
	}

	@Step
	public void navigateTo_SettingsPage_AdminTab() {
		commonObjectsPage.navigateTo_SettingsPage_AdminTab();
	}

	@Step
	public void navigateTo_NetworkOrderPage() {
		commonObjectsPage.navigateTo_NetworkOrderPage();
	}

	public void navigateTo_QuickStartPageUnderTaskReporting() {
		commonObjectsPage.navigateTo_QuickStartPageUnderTaskReporting();
	}

	@Step
	public void launchPortalAndLogin(String userName) throws InterruptedException {
		commonObjectsPage.openPortal(userName);
		checkAlert();
		closeNotification();
		// getOrderIDFromDB();
		// assertTrue(false);
	}

	@Step
	public void refreshSearchResult() {
		commonObjectsPage.refreshSearchResult();
	}

	@Step
	public IntDataContainer getEnvDataContainer(String containerName) {
		return envData.getContainer(containerName);
	}

	@Step
	public IntDataContainer getCommonDataContainer(String containerName) {
		return commonData.getContainer(containerName);
	}

	@Step
	public void getOrderIDFromDB() throws SQLException {
		String OrderID = "";
		Serenity.setSessionVariable("OrderID").to("");

		IntDataContainer dataContainer = envData.getContainer("Database Connection");

		String userName = dataContainer.getFieldValue("userName");
		String pwd = dataContainer.getFieldValue("password");
		String url = dataContainer.getFieldValue("url");

// 		String sql1 = "select SUBSTR(sod.CUSTOMER_ORDER_ID,1,9), sos.SO_STATUS_ENUM " +
// 		"from SERVICE_ORDER_DATA sod,SO_STATUS sos " +
// 		"where sos.SERVICE_ORDER_DATA_PK = sod.SERVICE_ORDER_DATA_PK " +
// 		"AND sod.PRODUCT_NAME = 'Dedicated Internet Access' AND sos.SO_STATUS_ENUM = 'Accepted' " + // AND sod.BANDWIDTH = 'DS3' AND sod.A_ULTIMATE_CLLI = 'DNVTCO56' " +
// 		"AND (sod.Order_submitted_by = 'l3svc.qoe2etest' or sod.Order_submitted_by = 'u1282496' or sod.Order_submitted_by = 'u1315039') order by sos.SO_STATUS_DATE desc";

// 		String sql2 = "select SUBSTR(sod.CUSTOMER_ORDER_ID,1,9), sos.SO_STATUS_ENUM " +
// 				"from SERVICE_ORDER_DATA sod,SO_STATUS sos " +
// 				"where sos.SERVICE_ORDER_DATA_PK = sod.SERVICE_ORDER_DATA_PK " +
// 				"AND sod.PRODUCT_NAME = 'Dedicated Internet Access' AND sos.SO_STATUS_ENUM = 'Complete' " + // AND sod.BANDWIDTH = 'DS3' AND sod.A_ULTIMATE_CLLI = 'DNVTCO56' " +
// 				"AND (sod.Order_submitted_by = 'l3svc.qoe2etest' or sod.Order_submitted_by = 'u1282496' or sod.Order_submitted_by = 'u1315039') order by sos.SO_STATUS_DATE desc";

		String sql1 = "select sod.CUSTOMER_ORDER_ID,sos.SUPERCEDED_TIMESTAMP,sos.SO_STATUS_ENUM,sod.PRODUCT_NAME,sod.LAST_UPDATED,sod.BANDWIDTH,sod.A_ULTIMATE_CLLI,sod.TRANSPORT_TYPE,sod.Order_submitted_by "
				+ "from SERVICE_ORDER_DATA sod,SO_STATUS sos where sos.SERVICE_ORDER_DATA_PK = sod.SERVICE_ORDER_DATA_PK "
				+ "AND sod.PRODUCT_NAME = 'Dedicated Internet Access' AND sod.TRANSPORT_TYPE = 'On-Net' "
				+ "AND sos.SO_STATUS_ENUM = 'Accepted'"  + " AND sod.BANDWIDTH= 'DS3' " 
				+ "And sos.SUPERCEDED_TIMESTAMP = TO_DATE('9999-12-31', 'YYYY-MM-DD') "
				+ "AND NOT EXISTS (select * from SERVICE_ORDER_DATA where CUSTOMER_ORDER_ID = sod.CUSTOMER_ORDER_ID "
				+ "AND CUSTOMER_ORDER_VERSION = sod.CUSTOMER_ORDER_VERSION " + "AND PRODUCT_FAMILY = 'MANAGEDSERVICE') "
				+ "AND NOT EXISTS (select * from RELATED_SERVICE_ORDER rso, SERVICE_ORDER_DATA sod2 "
				+ "WHERE rso.SERVICE_ORDER_DATA_PK = sod2.SERVICE_ORDER_DATA_PK "
				+ "AND sod2.PRODUCT_FAMILY = 'HC_SDWAN_CPE' AND rso.RELATED_SO_SERVICE_ID = sod.SERVICE_ORDER_ID ) "
				+ "AND (sod.Order_submitted_by = 'AC91162') "
				+ "order by sod.LAST_UPDATED DESC";

		String sql2 = "select sod.CUSTOMER_ORDER_ID,sos.SUPERCEDED_TIMESTAMP,sos.SO_STATUS_ENUM,sod.PRODUCT_NAME,sod.LAST_UPDATED,sod.BANDWIDTH,sod.A_ULTIMATE_CLLI,sod.TRANSPORT_TYPE,sod.Order_submitted_by "
				+ "from SERVICE_ORDER_DATA sod,SO_STATUS sos where sos.SERVICE_ORDER_DATA_PK = sod.SERVICE_ORDER_DATA_PK "
				+ "AND sod.PRODUCT_NAME = 'Dedicated Internet Access' AND sod.TRANSPORT_TYPE = 'On-Net' "
				+ "AND sos.SO_STATUS_ENUM = 'Complete' "
				+ "And sos.SUPERCEDED_TIMESTAMP = TO_DATE('9999-12-31', 'YYYY-MM-DD') "
				+ "AND NOT EXISTS (select * from SERVICE_ORDER_DATA where CUSTOMER_ORDER_ID = sod.CUSTOMER_ORDER_ID "
				+ "AND CUSTOMER_ORDER_VERSION = sod.CUSTOMER_ORDER_VERSION " + "AND PRODUCT_FAMILY = 'MANAGEDSERVICE') "
				+ "AND NOT EXISTS (select * from RELATED_SERVICE_ORDER rso, SERVICE_ORDER_DATA sod2 "
				+ "WHERE rso.SERVICE_ORDER_DATA_PK = sod2.SERVICE_ORDER_DATA_PK "
				+ "AND sod2.PRODUCT_FAMILY = 'HC_SDWAN_CPE' AND rso.RELATED_SO_SERVICE_ID = sod.SERVICE_ORDER_ID ) "
				+ "AND (sod.Order_submitted_by = 'AC91162') "
				+ "order by sod.LAST_UPDATED DESC";

		Connection con = null;

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			con = DriverManager.getConnection(url, userName, pwd);
			System.out.println("Connecting Database...     --Successful");

			Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs1 = st1.executeQuery(sql1);
			ResultSet rs2 = st2.executeQuery(sql2);
			System.out.println("Executing Queries...     --Successful");

			rs1.beforeFirst();
			rs2.beforeFirst();

			if (!rs1.next()) {
				assertTrue("Order ID not found in DB.", false);
			}

			rs1.beforeFirst();

			boolean takeThis = false;

			while (rs1.next()) {
				if (!rs2.next()) {
					takeThis = true;
				}

				rs2.beforeFirst();

				while (rs2.next()) {
					if (rs1.getString(1).equals(rs2.getString(1))) {
						takeThis = false;
						break;
					} else {
						takeThis = true;
					}
				}

				if (takeThis == true) {
					System.out.println(rs1.getString(1));
					OrderID = rs1.getString(1);
					Serenity.setSessionVariable("OrderID").to(OrderID);
					break;
				}
			}

		} catch (Exception exp) {
			exp.printStackTrace();
			assertTrue("Database Method Failed", false);
		}

		finally {

			con.close();

		}

		if (OrderID.equals("")) {
			assertTrue("Order ID not found in DB.", false);
		}

	}

	@Step
	public void checkAlert() {
		Boolean found = false;

		try {
			System.out.println("Waiting For Alert...");
			commonObjectsPage.withTimeoutOf(Duration.ofSeconds(10)).waitFor(ExpectedConditions.alertIsPresent());
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

	@Step
	public void closeNotification() {
		sync(commonObjectsPage, ExpectedConditions.visibilityOf(commonObjectsPage.notificationContainer));
		// syncObject(this,
		// ExpectedConditions.presenceOfNestedElementsLocatedBy(notificationContainer,
		// ""));

		List<WebElement> list;

		if (commonObjectsPage.notificationContainer.isCurrentlyVisible()) {
			list = commonObjectsPage.notificationContainer.findElements(By.tagName("li"));
			System.out.println(list.size());
			for (WebElement webElement : list) {
				System.out.println("Notification : " + webElement.getText());
				if (sync(commonObjectsPage,
						ExpectedConditions.visibilityOfNestedElementsLocatedBy(webElement, By.tagName("a")))) { // elementToBeClickable(webElement.findElement(By.tagName("a")))))
																												// {
					try {
						webElement.findElement(By.tagName("a")).click();
					} catch (Exception exp) {
						exp.printStackTrace();
					}
				} else {
					closeNotification();
				}
			}
		}
	}

	@Step
	public int getColumnNum(String columnName, List<WebElementFacade> headers) {
		return commonObjectsPage.getColumnNum(columnName, headers);
	}

	@Step
	public int getColumnNum(String columnName) {
		return commonObjectsPage.getColumnNum(columnName, null);
	}

	@Step
	public int getRowNumberforTask(String trgTaskName) {
		return getRowNumberforTask(trgTaskName, null);
	}

	@Step
	public int getRowNumberforTask(String trgTaskName, List<WebElementFacade> rows) {
		String taskName;
		List<WebElement> cells;
		// List<WebElementFacade> columns;
		// rows = getTableRows();
		// columns = getTableColumns();

		if (rows == null || rows.size() < 1) {
			rows = getTableRows();
		}

		setCurrTask(trgTaskName);

		for (int i = 0; i < rows.size(); i++) {
			sync(commonObjectsPage, rows.get(1));
			cells = rows.get(i).findElements(By.tagName("td"));
			sync(commonObjectsPage, cells.get(0));
			taskName = cells.get((getColumnNum("Task Name")) - 1).getText();
			if (taskName.equals(trgTaskName)) {
				setCurrTaskId(cells.get((getColumnNum("Task Id")) - 1).getText());
				return i + 1;
			}
		}
		return 0;
	}

	@Step
	public WebElement getTableObj() {
		return commonObjectsPage.tbl_SearchResults;
	}

	@Step
	public List<WebElementFacade> getTableRows() {
		return commonObjectsPage.getTableRows();
	}

	@Step
	public List<WebElementFacade> getTableColumns() {
		return commonObjectsPage.getTableColumns();
	}

	@Step
	public List<WebElementFacade> getTableHeaders() {
		return commonObjectsPage.getTableHeaders();
	}

	public void getOrderIDFromDatabse(String id) {
		//id = RegressionSteps.orderpackageid;
		String OrderID = id;
		Serenity.setSessionVariable("OrderID").to(OrderID);
	}

	public void loginToBPMSPortal(String userName) {
		commonObjectsPage.openPortal(userName);
		checkAlert();
	}

	public void navigateToQuickStartPageUnderOrderPage() {

		commonObjectsPage.navigateToQuickStartPageUnderOrderPage();
	}

}
