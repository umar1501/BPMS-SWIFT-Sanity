package com.ctl.it.qa.bpms.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ctl.it.qa.bpms.steps.common.CommonObjectsPageSteps;
import com.ctl.it.qa.bpms.pages.OrdersPage;
import com.ctl.it.qa.bpms.pages.TasksPage;
import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.Steps;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class OrdersPageSteps extends CommonObjectsPageSteps {

	OrdersPage ordersPage;

	@Step
	public Page getPageObj() {
		return ordersPage;
	}

	@Step
	public List<WebElementFacade> getTableRows() {
		return ordersPage.getTableRows();
	}

	@Step
	public List<WebElementFacade> getTableColumns() {
		return ordersPage.getTableColumns();
	}

	@Step
	public List<WebElementFacade> getTableHeaders() {
		return ordersPage.getTableHeaders();
	}

	@Step
	public int getColumnNum(String columnName, List<WebElementFacade> headers) {
		return ordersPage.getColumnNum(columnName, headers);
	}

	@Step
	public int getColumnNum(String columnName) {
		return ordersPage.getColumnNum(columnName, null);
	}

	@Step
	public void setCurrentOrderID(String trgOrder) {
		ordersPage.setCurrentOrderID(trgOrder);
	}

	@Step
	public String getCurrentOrderID() {
		return ordersPage.getCurrentOrderID();
	}

	@Step
	public void selectSearchOnID(String idToSelect) {
		ordersPage.sync(ordersPage, ordersPage.sel_SearchOnId_OrdersPage);
		// syncObject(ExpectedConditions.elementToBeClickable(sel_SearchOnId_OrdersPage));
		Select select = new Select(ordersPage.sel_SearchOnId_OrdersPage);
		select.selectByVisibleText(idToSelect);
	}

	@Step
	public void enterSearchOnID() {
		ordersPage.sync(ordersPage, ordersPage.tbx_SearchID_OrdersPage);

		ordersPage.tbx_SearchID_OrdersPage.sendKeys(Serenity.sessionVariableCalled("OrderID").toString());
	}

	@Step
	public void clickOn_ManageOrder() {
		WebElement btn_ManageOrder;
		List<WebElementFacade> rows = ordersPage.getTableRows();
		// List <WebElementFacade> columns = getTableColumns();
		List<WebElementFacade> headers = ordersPage.getTableHeaders();
		ordersPage.sync(ordersPage);
		for (int i = 0; i < rows.size(); i++) {
			ordersPage.sync(ordersPage, headers.get(1));

			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			btn_ManageOrder = cells.get((ordersPage.getColumnNum("Actions", headers)) - 1)
					.findElement(By.xpath("//a[contains(@href,'"
							+ cells.get((ordersPage.getColumnNum("Customer Order Id", headers)) - 1).getText()
							+ "')]"));

			ordersPage.sync(ordersPage, btn_ManageOrder);
			btn_ManageOrder.click();
			break;
		}
	}

	@Step
	public void clickOn_SearchBtn() {
		ordersPage.sync(ordersPage, ordersPage.btn_Search_CriteriaToolbar);
		ordersPage.btn_Search_CriteriaToolbar.click();
		WaitForPageToLoad(120);
		waitABit(5000);
		closeNotification();
	}

	@Step
	public void IsSearchResultTableDispalyed() {
		ordersPage.sync(ordersPage, ordersPage.tbl_SearchResults);
		if (ordersPage.tbl_SearchResults.isDisplayed()) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	@Step
	public int getRowNumberforTask(String trgTaskName, List<WebElementFacade> rows, List<WebElementFacade> headers) {
		String taskName;
		List<WebElement> cells;
		// List<WebElementFacade> columns;
		// rows = getTableRows();
		// columns = getTableColumns();

		if (rows == null || rows.size() < 1) {
			rows = ordersPage.getTableRows();
		}

		if (headers == null || headers.size() < 1) {
			headers = ordersPage.getTableHeaders();
		}

		setCurrTask(trgTaskName);

		for (int i = 0; i < rows.size(); i++) {
			sync(ordersPage, rows.get(1));
			cells = rows.get(i).findElements(By.tagName("td"));
			sync(ordersPage, cells.get(0));
			taskName = cells.get((ordersPage.getColumnNum("Task Name", headers)) - 1).getText();
			if (taskName.equals(trgTaskName)) {
				setCurrTaskId(cells.get((ordersPage.getColumnNum("Task Id", headers)) - 1).getText());
				return i + 1;
			}
		}
		return 0;
	}

	@Step
	public void validateOrdersPage_ResultsTable(List<List<String>> list) {
		ordersPage.validateOrdersPage_ResultsTable(list);
	}

	@Step
	public boolean validate_OrderStatus(String trgOrderStatus) {
		return ordersPage.validate_OrderStatus(trgOrderStatus);
	}

	@Step
	public void click_SelectAnOrderVersion() {
		ordersPage.sync(ordersPage, ordersPage.lnk_OrderVersion);
		ordersPage.lnk_OrderVersion.click();
	}

	@Step
	public void click_VersionNumber() {
		ordersPage.sync(ordersPage, ordersPage.lnk_orderVersions.get(0));
		ordersPage.lnk_orderVersions.get(0).click();
		WaitForPageToLoad(120);
	}

	@Step
	public void click_BackBtn() {
		ordersPage.sync(ordersPage, ordersPage.btn_Back);
		ordersPage.btn_Back.click();
		WaitForPageToLoad(120);
	}

	@Step
	public void clickOn_ManageOrderInOrderPage(String type) {
		WebElement btn_ManageOrder;
		String productComponent;
		List<WebElementFacade> rows = getTableRows();
		List<WebElementFacade> columns = getTableColumns();
		ordersPage.sync(ordersPage);
		for (int i = 0; i < rows.size(); i++) {
			ordersPage.sync(ordersPage, columns.get(1));
			System.out.println("I value-" + i);
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			productComponent = cells.get((getColumnNum("Product")) - 1).getText();
			System.out.println("Pr-" + productComponent);

			if (productComponent.equals(type)) {
				// btn_ManageOrder =
				// cells.get((getColumnNum("Actions"))-1).findElement(By.xpath("//a[@title='Manage
				// Order']"));

				btn_ManageOrder = cells.get((getColumnNum("Actions")) - 1).findElement(By.xpath(
						"//a[contains(@href,'" + cells.get((getColumnNum("Customer Order Id")) - 1).getText() + "')]"));
				ordersPage.sync(ordersPage, btn_ManageOrder);

				JavascriptExecutor jse2 = (JavascriptExecutor) this.getDriver();
				jse2.executeScript("arguments[0].scrollIntoView()", btn_ManageOrder);
				Actions a1 = new Actions(this.getDriver());
				a1.moveToElement(btn_ManageOrder).click().perform();

				// btn_ManageOrder.click();
				System.out.println("Inside Product-" + productComponent);
			}

		}

	}

	@Step
	public void checkHighAvailabilityStatus(String highAvailabilityStatus) {
		ordersPage.checkHighAvailabilityStatus(highAvailabilityStatus);
	}

	@Step
	public void validateCCD() {
		ordersPage.validateCCDinOrderDetailsPage();
	}

	public void retrieveServiceIdOfComponent(String component) {
		ordersPage.retrieveServiceIdOfComponent(component);
	}

	@Step
	public String getSalesRegionCode() {

		ordersPage.sync(ordersPage, ordersPage.orderdetails);
		System.out.println("Order details page loaded successfully");
		String salesRegionCode = ordersPage.salesRegionCode.getText();
		System.out.println(salesRegionCode);
		return salesRegionCode;

	}

	@Step
	public void validateSalesRegionCode() {
		ordersPage.sync(ordersPage, ordersPage.orderdetails);
		System.out.println("Order details page loaded successfully");
		ordersPage.validateSalesRegion();
	}

	public void validateNoOfStaticIP() {
		ordersPage.validateNoOfStaticIP();

	}

	public void validateHotCutDetails() {
		ordersPage.sync(ordersPage, ordersPage.orderdetails);
		System.out.println("Order details page loaded successfully");
		ordersPage.validateHotCutSection();
	}

	@Step
	public void validateProductFamily() {
		ordersPage.sync(ordersPage, ordersPage.orderdetails);
		System.out.println("Order details page loaded successfully");
		ordersPage.validateProductFamilyinOrderItemDetails();
	}

	@Step
	public void validateTDGData() {
		ordersPage.sync(ordersPage, ordersPage.orderdetails);
		System.out.println("Order details page loaded successfully");
		ordersPage.validateTDGDataSection();
	}

	@Step
	public void validateProjectIDLength() {
		ordersPage.sync(ordersPage, ordersPage.orderdetails);
		System.out.println("Order details page loaded successfully");
		ordersPage.validateProjectIdCharlimit();
	}

	public void selectQSSearchOnID(String idToSelect) {
		ordersPage.sync(ordersPage, ordersPage.sel_QSSearchOnId_OrdersPage);
		// syncObject(ExpectedConditions.elementToBeClickable(sel_SearchOnId_OrdersPage));
		Select select = new Select(ordersPage.sel_QSSearchOnId_OrdersPage);
		select.selectByVisibleText(idToSelect);

	}

	public void enterQSSearchOnID(String id) {
		String OrderID = id;
		Serenity.setSessionVariable("OrderID").to(OrderID);
		ordersPage.sync(ordersPage, ordersPage.tbx_QSSearchID_OrdersPage);

		ordersPage.tbx_QSSearchID_OrdersPage.sendKeys(Serenity.sessionVariableCalled("OrderID").toString());

	}
	
	@Step
	public void clickOn_ProcessProgression_DataComponent(String type) {
		WebElement btn_ProcessProgression;
		String productComponent;
		List<WebElementFacade> rows = getTableRows();
		List<WebElementFacade> columns = getTableColumns();
		ordersPage.sync(ordersPage);
		for (int i = 0; i < rows.size(); i++) {
			ordersPage.sync(ordersPage, columns.get(1));
			System.out.println("I value-" + i);
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			productComponent = cells.get((getColumnNum("Product")) - 1).getText();
			System.out.println("Pr-" + productComponent);
			
			if (productComponent.equals(type)) {
				btn_ProcessProgression = cells.get((getColumnNum("Actions")) - 1).findElement(By.xpath(
						"//a[contains(@href,'" + cells.get((getColumnNum("Customer Order Id")) - 1).getText() + "')]"));
				ordersPage.sync(ordersPage, btn_ProcessProgression);

				JavascriptExecutor jse2 = (JavascriptExecutor) this.getDriver();
				jse2.executeScript("arguments[0].scrollIntoView()", btn_ProcessProgression);
				Actions a1 = new Actions(this.getDriver());
				a1.moveToElement(btn_ProcessProgression).click().perform();

				System.out.println("Inside Product-" + productComponent);
			}
			
			
		}

	}
	
	@Step
	public void clickOn_LogicHistory() {
		ordersPage.sync(ordersPage, ordersPage.btn_LogicHistory);
		ordersPage.btn_LogicHistory.click();
		WaitForPageToLoad(120);
	}
	
	
	@Step
	public void validateBEDependencyDecomposertask() {
		ordersPage.sync(ordersPage, ordersPage.btn_LogicHistory);
		WaitForPageToLoad(120);
		System.out.println("Logic History details page loaded successfully");
		ordersPage.validateBEDepDecomposertask();
	}

}
