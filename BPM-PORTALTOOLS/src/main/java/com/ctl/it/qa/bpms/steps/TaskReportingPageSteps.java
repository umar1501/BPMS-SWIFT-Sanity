package com.ctl.it.qa.bpms.steps;

import static org.junit.Assert.assertEquals;

import com.ctl.it.qa.bpms.steps.common.CommonObjectsPageSteps;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ctl.it.qa.bpms.pages.OrdersPage;
import com.ctl.it.qa.bpms.pages.TaskReportingPage;
import com.ctl.it.qa.bpms.pages.TasksPage;
import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.Steps;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class TaskReportingPageSteps extends CommonObjectsPageSteps {

	TaskReportingPage taskReportingPage;
	TasksPage tasksPage;
	OrdersPage ordersPage;

	@Step
	public Page getPageObj() {
		return taskReportingPage;
	}

	@Step
	public List<WebElementFacade> getTableRows() {
		return taskReportingPage.getTableRows();
	}

	@Step
	public List<WebElementFacade> getTableColumns() {
		return taskReportingPage.getTableColumns();
	}

	@Step
	public List<WebElementFacade> getTableHeaders() {
		return taskReportingPage.getTableHeaders();
	}

	@Step
	public int getColumnNum(String columnName, List<WebElementFacade> headers) {
		return taskReportingPage.getColumnNum(columnName, headers);
	}

	@Step
	public int getColumnNum(String columnName) {
		return taskReportingPage.getColumnNum(columnName, null);
	}

	@Step
	public void selectTaskStatusFilter(String strTaskStatus) {
		taskReportingPage.sync(taskReportingPage, taskReportingPage.sel_TaskStatusFilter_TaskReportingPage);
		Select select = new Select(taskReportingPage.sel_TaskStatusFilter_TaskReportingPage);
		select.selectByVisibleText(strTaskStatus);
	}

	@Step
	public void selectSearchOnID(String idToSelect) {
		taskReportingPage.sync(taskReportingPage, taskReportingPage.sel_SearchOnId_TaskReportingPage);
		// syncObject(ExpectedConditions.elementToBeClickable(sel_SearchOnId_TaskReportingPage));
		Select select = new Select(taskReportingPage.sel_SearchOnId_TaskReportingPage);
		select.selectByVisibleText(idToSelect);
	}

	@Step
	public void enterSearchOnID() {
		taskReportingPage.sync(taskReportingPage, taskReportingPage.tbx_SearchID_TaskReportingPage);
		taskReportingPage.tbx_SearchID_TaskReportingPage.sendKeys(Serenity.sessionVariableCalled("OrderID").toString());
	}

	@Step
	public void enterNetworkOrderID(String id) {
		String OrderID = id;
		Serenity.setSessionVariable("OrderID").to(OrderID);

		System.out.println(id);
		if (OrderID.startsWith("N")) {
			taskReportingPage.sync(taskReportingPage, taskReportingPage.tbx_NetworkOrderSearchID_TaskReportingPage);
			taskReportingPage.tbx_NetworkOrderSearchID_TaskReportingPage
					.sendKeys(Serenity.sessionVariableCalled("OrderID").toString());
		} else {
			taskReportingPage.sync(taskReportingPage, taskReportingPage.tbx_quickStartSearchID_TaskReportingPage);
			taskReportingPage.tbx_quickStartSearchID_TaskReportingPage
					.sendKeys(Serenity.sessionVariableCalled("OrderID").toString());

		}
	}

	// Method to validate task
	// performers***********************************************************************
	@Step
	public void validateTaskPerformer(List<WebElementFacade> rows, List<WebElementFacade> headers) {

		IntDataContainer dataContainer;
		int taskNameIndex = -1, taskPerformerIndex = -1, taskStatusIndex = -1;

		System.out.println("!!!**********************************!!!");
		System.out.println("---       Performer Validation       ---");
		System.out.println("!!!**********************************!!!");

		String taskName, actualTaskPerformer, expectedTaskPerformer, taskStatus;
		List<WebElement> cells;

		int i;

		taskReportingPage.sync(taskReportingPage);

		for (i = 0; i < rows.size(); i++) {
			cells = rows.get(i).findElements(By.tagName("td"));

			taskNameIndex = (taskNameIndex > -1) ? taskNameIndex : (getColumnNum("Task Name", headers) - 1);
			taskPerformerIndex = (taskPerformerIndex > -1) ? taskPerformerIndex
					: (getColumnNum("Performer", headers) - 1);
			taskStatusIndex = (taskStatusIndex > -1) ? taskStatusIndex : (getColumnNum("Task Status", headers) - 1);

			taskName = cells.get(taskNameIndex).getText();
			actualTaskPerformer = cells.get(taskPerformerIndex).getText();
			taskStatus = cells.get(taskStatusIndex).getText();

			if ((taskName.startsWith("AUTO")) || (taskName.startsWith("DEPENDENCY"))
					|| (taskStatus.equals("Completed"))) {
				continue;
			}

			try {
				dataContainer = commonData.getContainer("Manage Task").getContainer(taskName);
				expectedTaskPerformer = dataContainer.getFieldValue("lbl_Performer");

				if (dataContainer.getFieldValue("lbl_Performer") == null) {
					continue;
				}

				if (actualTaskPerformer.equals(expectedTaskPerformer)) {
					System.out.println("    ---" + taskName + " - Passed.");
				} else {
					System.out.println("    ---" + taskName + " - Failed.");
					System.out.println("          -Expected - " + expectedTaskPerformer);
					System.out.println("          -Actual - " + actualTaskPerformer);
				}

				dataContainer = commonData.getContainer("Controller");
				if (Boolean.parseBoolean(dataContainer.getFieldValue("enableValidation"))) {
					assertEquals(actualTaskPerformer, expectedTaskPerformer);
				}

			} catch (Exception exp) {
				exp.printStackTrace();
			}

		}

	}

	// *********************************************************************************************************

	@Step
	public boolean validateOrderStatus_OrdersPage() {
		boolean status;
		navigateTo_OrdersPage();
		status = ordersPage.validate_OrderStatus("");
		navigateTo_TaskReportingPage();

		return status;
	}

	// Method to get the Task Status from Results Grid based on task
	// name***************************************
	@Step
	public boolean validateTasksCompletionStatus(List<WebElementFacade> rows, List<WebElementFacade> headers) {

		System.out.println("$$$$$$$$$$$$$$validateTasksCompletionStatus - TRP");

		// refreshSearchResult();

		String taskStatus, taskName;
		List<WebElement> cells;
		// List<WebElementFacade> columns;
		// columns = getTableColumns();

		int i;
		boolean status = false;

		taskReportingPage.sync(taskReportingPage);

		for (i = 0; i < rows.size(); i++) {

			taskReportingPage.sync(taskReportingPage, ExpectedConditions.visibilityOf(rows.get(1)));

			cells = rows.get(0).findElements(By.tagName("td"));
			taskName = cells.get((getColumnNum("Task Name", headers)) - 1).getText();
			taskStatus = cells.get((getColumnNum("Task Status", headers)) - 1).getText();

			if (!taskStatus.equals("Completed")) {
				status = false;
				break;
			} else if (taskStatus.equals("Completed") && i <= 1) {
				refreshSearchResult();
			} else {
				status = true;
				break;
			}

			// if (taskName.equals("AUTO_SetProcessStatusComplete")) {
			// if (taskStatus.equals("Completed")) {
			// status = true;
			// break;
			// }
			// }
		}

		if (status == true) {
			status = validateOrderStatus_OrdersPage();
		} else {
			// refreshSearchResult();
		}

		System.out.println("Status : " + status);
		return status;
	}

	// *********************************************************************************************************

	@Step
	public void waitForTaskCompletion(String trgTaskName) {

		System.out.println("Waiting for the task \"" + trgTaskName + "\" to be completed...");

		String taskName, taskStatus, taskCounter;
		List<WebElement> cells;
		List<WebElementFacade> rows, headers;// , columns;
		int i;
		boolean Exit = true;

		while (Exit) {
			rows = taskReportingPage.getTableRows();
			headers = taskReportingPage.getTableHeaders();
			// columns = getTableColumns();
			taskReportingPage.sync(taskReportingPage);
			taskReportingPage.sync(taskReportingPage, rows.get(1));

			for (i = 0; i < rows.size(); i++) {

				// taskReportingPage.sync(taskReportingPage,
				// ExpectedConditions.visibilityOf(rows.get(1)));
				try {
					cells = rows.get(i).findElements(By.tagName("td"));
				} catch (Exception exp) {
					waitABit(5000);
					refreshSearchResult();
					rows = taskReportingPage.getTableRows();
					cells = rows.get(i).findElements(By.tagName("td"));
				}
				taskName = cells.get((taskReportingPage.getColumnNum("Task Name", headers)) - 1).getText();
				taskStatus = cells.get((taskReportingPage.getColumnNum("Task Status", headers)) - 1).getText();
				taskCounter = cells.get((taskReportingPage.getColumnNum("Task Counter", headers)) - 1).getText();
				if (!taskStatus.equals("Completed")) {
					if (Integer.parseInt(taskCounter) > 1) {
						Exit = false;
						break;
					} else if (taskName.trim().equals(trgTaskName.trim())) {
						Exit = true;
						refreshSearchResult();
						waitABit(1000);
						break;
					}
				} else {
					Exit = false;
					System.out.println("Successfully completed -" + trgTaskName + " task");
					break;
				}
			}
		}
	}

// 	@Step
// 	public void waitForTaskCompletion(String trgTaskName) {

// 		System.out.println("Waiting for the task \"" + trgTaskName + "\" to be completed...");

// 		String taskName, taskStatus, taskCounter;
// 		List<WebElement> cells;
// 		List<WebElementFacade> rows, headers;//, columns;		
// 		int i;
// 		boolean Exit = true;

// 		while(Exit) {
// 			rows = getTableRows();
// 			headers = getTableHeaders();
// 			//columns = getTableColumns();
// 			taskReportingPage.sync(taskReportingPage);
// 			taskReportingPage.sync(taskReportingPage, rows.get(1));

// 			try {
// 				cells = rows.get(getRowNumberforTask(trgTaskName, rows)-1).findElements(By.tagName("td"));
// 			} catch (ArrayIndexOutOfBoundsException exp) {
// 				refreshSearchResult();
// 				waitABit(5000);
// 				rows = getTableRows();
// 				cells = rows.get(getRowNumberforTask(trgTaskName, rows)-1).findElements(By.tagName("td"));
// 			}

// 			taskStatus = cells.get((getColumnNum("Task Status", headers))-1).getText();
// 			taskCounter = cells.get((getColumnNum("Task Counter", headers))-1).getText();

// 			refreshSearchResult();

// 			if(!taskStatus.equals("Completed")) {
// 				if (Integer.parseInt(taskCounter)>1) {
// 					Exit = false;
// 					break;
// 				}
// 			} else {
// 				Exit = false;
// 				break;
// 			}

// 		}
// 	}

	// Method to check task status for all tasks currently
	// displayed********************************************
	@Step
	public void waitForTaskCompletion2(String trgTaskName) {

		System.out.println("$$$$$$$$$$$$$$$$$$waitForTaskCompletion - TRP");

		String taskName, taskStatus, taskCounter;
		List<WebElement> cells;
		List<WebElementFacade> rows, columns;
		rows = getTableRows();
		columns = getTableColumns();
		int i;
		boolean Exit = true;

		while (Exit) {

			taskReportingPage.sync(taskReportingPage);
			// syncObject(ExpectedConditions.stalenessOf(taskReportingPage.rows.get(0)));

			for (i = 0; i < rows.size(); i++) {

				taskReportingPage.sync(taskReportingPage, columns.get(1));

				cells = rows.get(i).findElements(By.tagName("td"));
				taskName = cells.get((getColumnNum("Task Name")) - 1).getText();
				taskStatus = cells.get((getColumnNum("Task Status")) - 1).getText();
				taskCounter = cells.get((getColumnNum("Task Counter")) - 1).getText();

				if (!taskStatus.equals("Completed")) {
					if (taskName.equals(trgTaskName)) {
						if (Integer.parseInt(taskCounter) > 1) {
							Exit = false;
							break;
						} else {
							refreshSearchResult();
							break;
						}
					}
				} else {
					Exit = false;
					break;
				}
			}
		}
	}

	// *********************************************************************************************************

	@Step
	public void clickOnManageTask() {
		List<WebElement> cells;
		List<WebElementFacade> rows;
		rows = getTableRows();
		cells = rows.get(getRowNumberforTask(taskReportingPage.getCurrTask()) - 1).findElements(By.tagName("td"));
		WebElement btn_ManageTask = cells.get((getColumnNum("Actions")) - 1)
				.findElement(By.xpath("//a[contains(@href,'" + taskReportingPage.getCurrTaskId() + "')]"));
		taskReportingPage.sync(taskReportingPage, btn_ManageTask);
		btn_ManageTask.click();
		WaitForPageToLoad(120);
	}

	@Step
	public void selectDependencyTaskFilter(String strDependencyTaskFilter) {
		// ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl02_excludeMilestoneDependencyTasksDropDown
		taskReportingPage.sync(taskReportingPage, taskReportingPage.sel_dependencyTaskFilter_TaskReportingPage);
		Select select = new Select(taskReportingPage.sel_dependencyTaskFilter_TaskReportingPage);
		select.selectByVisibleText(strDependencyTaskFilter);
	}

	@Step
	public void selectAutomationTaskFilter(String strAutomationTaskFilter) {
		// ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl02_excludeMilestoneDependencyTasksDropDown
		taskReportingPage.sync(taskReportingPage, taskReportingPage.sel_automationTaskFilter_TaskReportingPage);
		Select select = new Select(taskReportingPage.sel_automationTaskFilter_TaskReportingPage);
		select.selectByVisibleText(strAutomationTaskFilter);
	}

	@Step
	public void verifyTaskCompleted(String trgTaskName, String trgProductComponent) {

		System.out.println("Waiting for the task \"" + trgTaskName + "\" to be completed...");

		String taskName, taskStatus, taskId, productComponent;
		List<WebElement> cells;
		List<WebElementFacade> rows, headers;// , columns;
		int i;
		boolean Exit = true;
		refreshSearchResult();
		while (Exit) {
			rows = taskReportingPage.getTableRows();
			headers = taskReportingPage.getTableHeaders();
			// columns = getTableColumns();
			taskReportingPage.sync(taskReportingPage);
			taskReportingPage.sync(taskReportingPage, rows.get(1));

			for (i = 0; i < rows.size(); i++) {

				taskReportingPage.sync(taskReportingPage, ExpectedConditions.visibilityOf(rows.get(1)));
				try {
					cells = rows.get(i).findElements(By.tagName("td"));
				} catch (Exception exp) {
					waitABit(5000);
					refreshSearchResult();
					rows = taskReportingPage.getTableRows();
					cells = rows.get(i).findElements(By.tagName("td"));
				}
				taskName = cells.get((taskReportingPage.getColumnNum("Task Name", headers)) - 1).getText();
				taskStatus = cells.get((taskReportingPage.getColumnNum("Task Status", headers)) - 1).getText();
				productComponent = cells.get((taskReportingPage.getColumnNum("Product Component", headers)) - 1)
						.getText();
				// taskId = cells.get((taskReportingPage.getColumnNum("Task Id",
				// headers))-1).getText();

				if (!taskStatus.equals("Completed")) {

					if (taskName.trim().equals(trgTaskName.trim()) && productComponent.equals(trgProductComponent)) {
						Exit = true;
						refreshSearchResult();
						break;
					}
				} else {
					System.out.println("Successfully Completed-" + trgTaskName + " task");
					Exit = false;
					break;
				}
			}
		}
	}

	@Step
	public boolean validateTasksCompletionStatus2(List<WebElementFacade> rows, List<WebElementFacade> headers,
			String trgTaskNameAndProductComponent) {

		System.out.println("$$$$$$$$$$$$$$validateTasksCompletionStatus - TRP");

		// refreshSearchResult();
		String[] value = trgTaskNameAndProductComponent.split(" of ");
		String trgTaskName = value[0];

		String trgProductComponent = value[1];
//		System.out.println("value[0]="+trgTaskName);
		System.out.println("value[1]=" + trgProductComponent);
		String taskStatus, taskName, productComponent;
		List<WebElement> cells;
		rows = taskReportingPage.getTableRows();
		headers = taskReportingPage.getTableHeaders();
		// List<WebElementFacade> columns;
		// columns = getTableColumns();

		int i;
		int j = 0;
		int k = 0;
		boolean status = false;
		boolean status1 = true;
		taskReportingPage.sync(taskReportingPage);

		for (i = 0; i < rows.size(); i++) {

		//	taskReportingPage.sync(taskReportingPage, ExpectedConditions.visibilityOf(rows.get(1)));
			taskReportingPage.sync(taskReportingPage, ExpectedConditions.visibilityOf(rows.get(0)));

			if (k == 1) {
				cells = rows.get(0).findElements(By.tagName("td"));
			} else {
				cells = rows.get(i).findElements(By.tagName("td"));
			}
			// cells = rows.get(i).findElements(By.tagName("td"));
			taskName = cells.get((taskReportingPage.getColumnNum("Task Name", headers)) - 1).getText();
			taskStatus = cells.get((taskReportingPage.getColumnNum("Task Status", headers)) - 1).getText();
			productComponent = cells.get((taskReportingPage.getColumnNum("Product Component", headers)) - 1).getText();

			System.out.println("Task Status-" + taskStatus);

			if (!taskStatus.equals("Completed")) {
				if (taskName.equals(trgTaskName) && trgProductComponent.contains(productComponent)) {
					System.out.println("Equal to target task");
					status = true;
					break;
				}

//				else if(taskName.equals("DEPENDENCY - accessProvisioningComplete")) {
//					status = false;	
//					status1=false;					
//					//refreshSearchResult();
//				}

				else if (taskName.startsWith("AUTO_") || taskName.startsWith("DEPENDENCY")) {
					status = false;
					status1 = false;
					System.out.println("Not Equal to target task1");
					continue;
				}

				else {
					status = false;
					status1 = false;
					System.out.println("Not Equal to target task2");
//				//break;
				}

			}

			else if (taskStatus.equals("Completed") && status1 == false) {
				status = false;
				System.out.println("Abc");
				break;
			} else if (taskStatus.equals("Completed") && i <= 1) {
				status = true;
				refreshSearchResult();
				waitABit(4000);
				k = 1;

			}

			else {
				status = true;
				break;
			}

		}

		System.out.println("Status : " + status);
		return status;
	}

	// Method to validate task performers
	// LATAM***********************************************************************

	@Step
	public void validateTaskPerformer(List<WebElementFacade> rows, List<WebElementFacade> headers,
			String terminatingRegion) {

		IntDataContainer dataContainer;
		int taskNameIndex = -1, taskPerformerIndex = -1, taskStatusIndex = -1;

		System.out.println("!!!**********************************!!!");
		System.out.println("---       Performer Validation       ---");
		System.out.println("!!!**********************************!!!");

		String taskName, actualTaskPerformer, expectedTaskPerformer, taskStatus, expectedTaskPerformer_LA;
		List<WebElement> cells;

		int i;

		taskReportingPage.sync(taskReportingPage);

		for (i = 0; i < rows.size(); i++) {
			cells = rows.get(i).findElements(By.tagName("td"));

			taskNameIndex = (taskNameIndex > -1) ? taskNameIndex : (getColumnNum("Task Name", headers) - 1);
			taskPerformerIndex = (taskPerformerIndex > -1) ? taskPerformerIndex
					: (getColumnNum("Performer", headers) - 1);
			taskStatusIndex = (taskStatusIndex > -1) ? taskStatusIndex : (getColumnNum("Task Status", headers) - 1);

			taskName = cells.get(taskNameIndex).getText();
			actualTaskPerformer = cells.get(taskPerformerIndex).getText();
			taskStatus = cells.get(taskStatusIndex).getText();

			System.out.println("Task Name-" + taskName);
			if (taskStatus.equals("Completed")) {
				break;
			}

			if ((taskName.startsWith("AUTO")) || (taskName.startsWith("DEPENDENCY"))
					|| (taskStatus.equals("Completed") || (taskStatus.equals("Assigned")))) {
				System.out.println("Its Auto tasks/Self assigned-" + taskName);
				continue;

			}

			try {
				dataContainer = commonData.getContainer("Manage Task").getContainer(taskName);
				if (terminatingRegion.equals("LA")) {
					expectedTaskPerformer = dataContainer.getFieldValue("lbl_Performer_LA");
					if (expectedTaskPerformer.equals(null) || expectedTaskPerformer.equals(" ")) {
						System.out.println("Not required to validate Task Performer");
						continue;
					}

				} else {
					expectedTaskPerformer = dataContainer.getFieldValue("lbl_Performer");
					System.out.println("expectedTaskPerf-" + expectedTaskPerformer);
					if (expectedTaskPerformer.equals(null) || expectedTaskPerformer.equals(" ")) {
						System.out.println("Not required to validate Task Performer");
						continue;
					}
				}

				if (actualTaskPerformer.equals(expectedTaskPerformer)) {
					System.out.println("    ---" + taskName + " - Passed.");
				} else {
					System.out.println("    ---" + taskName + " - Failed.");
					System.out.println("          -Expected - " + expectedTaskPerformer);
					System.out.println("          -Actual - " + actualTaskPerformer);
				}

				dataContainer = commonData.getContainer("Controller");

				if (Boolean.parseBoolean(dataContainer.getFieldValue("enableValidation"))) {
					assertEquals(actualTaskPerformer, expectedTaskPerformer);
				}

			} catch (Exception exp) {
				exp.printStackTrace();
			}

		}

	}

	@Step
	public void waitForTaskCompletion3(String trgTaskName) {

		taskReportingPage.waitForTaskCompletion3(trgTaskName);
		
//		System.out.println("Waiting for the task \"" + trgTaskName + "\" to be completed...");
//
//		String var5 = "//td[@title='Task Name' and text()='";
//		String var6 = trgTaskName + "']/../td[@title='Task Status']";
//
//		WebElement taskStatus = this.getDriver().findElement(By.xpath(var5 + var6));
//		String actualStatus = taskStatus.getText();
//		System.out.println(trgTaskName + "-" + actualStatus);
//
//		if (actualStatus.equals("Completed")) {
//			System.out.println("Successfully validated the task is completed");
//		} else {
//			throw new ArithmeticException("Task not completed");
//		}
//
		
		
		
	}

	public void clickOnManageTaskLink(String trgTaskName) {
		String taskName, taskStatus, taskCounter, performer, processName, productComponent; // orderID,
		int taskNameIndex = -1, taskStatusIndex = -1, taskCounterIndex = -1, productComponentIndex = -1;
		WebElement btn_ManageTask;
		boolean saveAndCompleteButtonStatus = false;
		;

		waitABit(2000);
		List<WebElementFacade> rows = getTableRows();
		List<WebElementFacade> columns = getTableColumns();
		List<WebElementFacade> headers = getTableHeaders();
		sync(getPageObj());
		sync(getPageObj(), ExpectedConditions.visibilityOf(rows.get(1)));
		while (saveAndCompleteButtonStatus == false) {
			for (int i = 0; i < rows.size(); i++) {

				// orderID = cells.get((taskReportingPageSteps.getColumnNum("Customer Order Id",
				// headers))-1).getText();
				taskNameIndex = (taskNameIndex > -1) ? taskNameIndex
						: ((taskReportingPage.getColumnNum("Task Name", headers)) - 1);
				taskStatusIndex = (taskStatusIndex > -1) ? taskStatusIndex
						: ((taskReportingPage.getColumnNum("Task Status", headers)) - 1);
				productComponentIndex = (productComponentIndex > -1) ? productComponentIndex
						: ((taskReportingPage.getColumnNum("Product Component", headers)) - 1);
				List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));

				taskName = cells.get(taskNameIndex).getText();
				taskStatus = cells.get(taskStatusIndex).getText();
				productComponent = cells.get(productComponentIndex).getText();
				// tasksPageSteps.setCurrTask(taskName);
				System.out.println("Current Task - " + taskName);

				if (taskName.equals(trgTaskName)||taskName.equals((trgTaskName.replace("AUTO_", ""))) && !taskStatus.equals("Completed")) {
					btn_ManageTask = cells.get((getColumnNum("Actions", headers)) - 1)
							.findElement(By.xpath("//a[contains(@href,'"
									+ cells.get((getColumnNum("Task Id", headers)) - 1).getText() + "')]"));
					sync(getPageObj(), btn_ManageTask);

					JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
					js.executeScript(
							"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
							cells.get((getColumnNum("Actions", headers)) - 1));
					btn_ManageTask.click();

					switch (tasksPage.clickOn_SaveAndCompleteButton()) {
					case 0:
						saveAndCompleteButtonStatus = true;
						break;
					case 1:
						tasksPage.taskSelfAssign(
								rows.get(i).findElement(By.xpath("//td[contains(text(),'" + trgTaskName + "')]")));
						refreshSearchResult();
						break;

					default:
						break;
					}
				}
			}
		}
	}

	@Step
	public boolean validateTaskInTaskReportingPage(String trgTaskName) {

		WebElement pageElement = getDriver().findElement(By.xpath(
				"//*[@id='ctl00_mainContent_searchView_resultsPanel_resultsGridUpdatePanel']/div/table[2]/tbody/tr/td[5]"));
		String lastpage = pageElement.getText();
		String[] text = lastpage.split("of ");
		String totalpage = text[1];
		String totalPagefinal = text[1].replace(")", "");
		int totalPages = Integer.parseInt(totalPagefinal);
		// WebElement forwardButton=
		// getDriver().findElement(By.xpath("(//*[@class='silk-icon
		// silk-icon-control-fastforward'])[2]"));
		boolean taskNamefound = false;
		boolean result;

		for (int i = 1; i <= totalPages - 1; i++) {
			System.out.println("i value=" + i);
			if (taskNamefound == false) {
				String var1 = "//td[@title='Task Name' and text()='";
				String var2 = trgTaskName + "']";
				WaitForPageToLoad(120);
				try {
					WebElement ele = this.getDriver().findElement(By.xpath(var1 + var2));
					result = ele.isDisplayed();
					taskNamefound = true;
				} catch (NoSuchElementException e) {
					WebElement forwardButton = getDriver()
							.findElement(By.xpath("(//*[@class='silk-icon silk-icon-control-fastforward'])[2]"));
					// e.printStackTrace();
					taskReportingPage.sync(taskReportingPage);
					forwardButton.click();
					waitABit(2000);
					continue;

				}

				if (taskNamefound == true) {
					System.out.println("Task validated-" + trgTaskName + "in Task reporting Page");
					// taskNamefound=true;
					taskReportingPage.setCurrTask(trgTaskName);

				}

				break;
			}
		}

		return true;
	}

	public void moveToFirstPage() {
		WebElement firstpage = getDriver().findElement(By.xpath("(//*[@class='silk-icon silk-icon-control-start'])[1]"));
		firstpage.click();
		waitABit(2000);
	}

	public void backToTaskReportingFirstPage() {
		taskReportingPage.backToTaskReportingFirstPage();
	}

	public void selectTaskCreateDateDropdown(String value) {
		taskReportingPage.selectTaskCreateDateDropdown(value);

	}

	public void selectTaskCreateDateValue(String expectedData) {
		taskReportingPage.selectTaskCreateDateValue(expectedData);
	}

	public void selectTaskCompleteDateDropdown(String value) {
		taskReportingPage.selectTaskCompleteDateDropdown(value);

	}

	public void selectTaskCompleteDateValue(String expectedData) {
		taskReportingPage.selectTaskCompleteDateValue(expectedData);
	}

	public void selectSolutionTypeOrProjectType(String value) {
		taskReportingPage.selectSolutionTypeOrProjectType(value);
	}

	public void selectProjectTypeValue(String expectedData) {
		taskReportingPage.selectProjectTypeValue(expectedData);
	}

	public void ValidateProjectTypeinTaskReportingPage() {
		taskReportingPage.ValidateProjectTypeinTaskReportingPage();

	}

	public void validateCMMCBannerOnTopOfPage() {
		taskReportingPage.validateCMMCBannerOnTopOfPage();

	}
	
	public void validatesCustomerNameInManageOrderPage(String expectedData) {
		taskReportingPage.validatesCustomerNameInManageOrderPage(expectedData);

		}
	
	public void validatesCustomerNameInTaskReportingPage(String expectedData) {
		taskReportingPage.validatesCustomerNameInTaskReportingPage(expectedData);

		}

	public void clickOnManageTasks(String taskName) {
		taskReportingPage.clickOnManageTasks(taskName);
		
	}

	public void validateTaskShouldNotTrigger(String expectedData) {
		taskReportingPage.validateTaskShouldNotTrigger(expectedData);
		
	}
	
}