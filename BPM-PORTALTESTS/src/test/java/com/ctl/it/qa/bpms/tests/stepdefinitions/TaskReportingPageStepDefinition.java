package com.ctl.it.qa.bpms.tests.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ctl.it.qa.bpms.steps.OrdersPageSteps;
import com.ctl.it.qa.bpms.steps.TaskReportingPageSteps;
import com.ctl.it.qa.bpms.steps.TasksPageSteps;
import com.ctl.it.qa.bpms.steps.common.CommonObjectsPageSteps;

import io.cucumber.datatable.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;

public class TaskReportingPageStepDefinition {

	@Steps
	CommonObjectsPageSteps commonObjectsPageSteps;
	@Steps
	OrdersPageSteps ordersPageSteps;
	@Steps
	TasksPageSteps tasksPageSteps;
	@Steps
	TaskReportingPageSteps taskReportingPageSteps;

	@And("^User Clicks on Domain Criteria Tab$")
	public void User_Clicks_on_Domain_Criteria_Tab() throws InterruptedException {
		taskReportingPageSteps.navigateTo_DomainCriteria();
		// Thread.sleep(10000);
	}

	@And("^User Selects Task Status Filter as \"([^\"]*)\"$")
	public void User_Selects_Task_Status_Filter_as(String strTaskStatus) {
		taskReportingPageSteps.selectTaskStatusFilter(strTaskStatus);
	}

	@And("^User selects \"([^\"]*)\" for Task Status under Common Criteria sub-tab$")
	public void User_selects_for_Task_Status_under_Common_Criteria_sub_tab(String strTaskStatus) {
		taskReportingPageSteps.selectTaskStatusFilter(strTaskStatus);
	}

	@And("^User Enters Search Criteria with SearchOnIDType as \"([^\"]*)\" and SearchOnID on Task Reporting Page$")
	public void User_Enters_Search_Criteria_with_SearchOnID_as_and_SearchOnID_as_on_Task_Reporting_Page(
			String TypeOfSearchOnID) {
		taskReportingPageSteps.selectSearchOnID(TypeOfSearchOnID);
		taskReportingPageSteps.enterSearchOnID();
	}

	@And("^User validates Results Grid and completes all the available tasks")
	public void User_validates_Results_Grid_and_completes_all_the_available_tasks() {
		// taskReportingPageSteps.validateTaskReportingTable();
		System.out.println("$$$Validating Task Reporting Table...");
		String taskName, taskStatus, taskCounter, performer, processName; // orderID,
		int taskNameIndex = -1, taskStatusIndex = -1, taskCounterIndex = -1;
		WebElement btn_ManageTask;
		boolean taskCompleted = false;
		List<WebElementFacade> rows = taskReportingPageSteps.getTableRows();
		// List<WebElementFacade> columns = taskReportingPageSteps.getTableColumns();
		List<WebElementFacade> headers = taskReportingPageSteps.getTableHeaders();
		int i;
		// WebElement trgTable = taskReportingPageSteps.getTableObj();

		taskReportingPageSteps.validateTaskPerformer(rows, headers);

		while (taskReportingPageSteps.validateTasksCompletionStatus(rows, headers) == false) {
			taskReportingPageSteps.sync(taskReportingPageSteps.getPageObj());
			if (rows.size() > 0) {
				taskReportingPageSteps.sync(taskReportingPageSteps.getPageObj(),
						ExpectedConditions.visibilityOf(rows.get(1)));
			} else {
				rows = taskReportingPageSteps.getTableRows();
			}
			// taskReportingPageSteps.sync(taskReportingPageSteps.getPageObj(),
			// ExpectedConditions.visibilityOf(columns.get(1)));

			for (i = 0; i < rows.size(); i++) {

				List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
				// orderID = cells.get((taskReportingPageSteps.getColumnNum("Customer Order Id",
				// headers))-1).getText();

				taskNameIndex = (taskNameIndex > -1) ? taskNameIndex
						: ((taskReportingPageSteps.getColumnNum("Task Name", headers)) - 1);
				taskStatusIndex = (taskStatusIndex > -1) ? taskStatusIndex
						: ((taskReportingPageSteps.getColumnNum("Task Status", headers)) - 1);
				taskCounterIndex = (taskCounterIndex > -1) ? taskCounterIndex
						: ((taskReportingPageSteps.getColumnNum("Task Counter", headers)) - 1);

				taskName = cells.get(taskNameIndex).getText();
				taskStatus = cells.get(taskStatusIndex).getText();
				taskCounter = cells.get(taskCounterIndex).getText();
				tasksPageSteps.setCurrTask(taskName);

				System.out.println("Current Task - " + taskName);

				if ((taskName.startsWith("AUTO")) || (taskName.startsWith("DEPENDENCY"))
						|| (taskStatus.equals("Completed"))
						|| (taskName.startsWith("Verify Physical Install Tasks Completion"))
						|| (taskName.startsWith("Work Circuit Design waiting for Port Assignment"))
						|| (taskName.startsWith("Waiting for ALL Dates")
								|| (taskName.startsWith("ActivateSvc_AddlActivation")))) {

					if ((taskName.startsWith("AUTO_CompleteBuildingExtension"))
							|| (taskName.startsWith("AUTO_InitiateBuildingExtension"))
							|| (taskName.startsWith("AUTO_Ethernet_Order_Creation"))
							|| (taskName.startsWith("AUTO_ManageTDG"))
							|| (taskName.startsWith("AUTO_Asri_Fulfilment_Qualify"))) {
						tasksPageSteps.taskSelfAssign(
								rows.get(i).findElement(By.xpath("//td[contains(text(),'" + taskName + "')]")));
						System.out.println("Self-Assigning the task : " + taskName + "     --Successful");
						taskReportingPageSteps.refreshSearchResult();
						break;
					} else if (taskStatus.equals("Completed")) {
						break;
					}

					else {
						System.out.println("Skipping the task : " + taskName);
						taskReportingPageSteps.refreshSearchResult();
						continue;
					}
				}

				// performer =
				// cells.get((taskReportingPageSteps.getColumnNum("Performer"))-1).getText();
				// processName = cells.get((taskReportingPageSteps.getColumnNum("Process
				// Name"))-1).getText();
				btn_ManageTask = cells.get((taskReportingPageSteps.getColumnNum("Actions", headers)) - 1)
						.findElement(By.xpath("//a[contains(@href,'"
								+ cells.get((taskReportingPageSteps.getColumnNum("Task Id", headers)) - 1).getText()
								+ "')]"));
				taskReportingPageSteps.sync(taskReportingPageSteps.getPageObj(), btn_ManageTask);
				taskReportingPageSteps.sync(taskReportingPageSteps.getPageObj(),
						ExpectedConditions.elementToBeClickable(btn_ManageTask));

				JavascriptExecutor js = (JavascriptExecutor) taskReportingPageSteps.getDriver();
				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						cells.get((taskReportingPageSteps.getColumnNum("Actions", headers)) - 1));

				// if (!taskStatus.equals("Completed")) {
				btn_ManageTask.click();
				taskReportingPageSteps.WaitForPageToLoad(120);

				try {
					switch (tasksPageSteps.clickOn_SaveAndCompleteBtn()) {
					case 0:
						taskReportingPageSteps.waitForTaskCompletion(taskName);
						break;

					case 1:
						tasksPageSteps.taskSelfAssign(rows.get(i).findElement(
								By.xpath("//td[contains(text(),'" + tasksPageSteps.getCurrTask() + "')]")));
						break;

					default:
						break;
					}

					rows = taskReportingPageSteps.getTableRows();
					headers = taskReportingPageSteps.getTableHeaders();
					taskNameIndex = -1;
					taskStatusIndex = -1;
				} catch (Exception exp) {
					exp.printStackTrace();
				}
				// break;
				// } else {
				taskReportingPageSteps.refreshSearchResult();
				break;
				// }
			}
		}
	}

	@Then("^User Navigates to Task Reporting Page$")
	public void User_Navigates_to_Task_Reporting_Page() {
		taskReportingPageSteps.navigateTo_TaskReportingPage();
	}

	@When("^User clicks on Task Reporting tab at the top of the page$")
	public void User_clicks_on_Task_Reporting_tab_at_the_top_of_the_page() {
		taskReportingPageSteps.navigateTo_TaskReportingPage();
	}

	@And("^User clicks on Domain Criteria sub-tab$")
	public void User_clicks_on_Domain_Criteria_sub_tab() {
		taskReportingPageSteps.navigateTo_DomainCriteria();
	}

	@And("^User selects Search On Id as \"([^\"]*)\" and enters the \"([^\"]*)\"$")
	public void User_selects_Search_On_Id_as_and_enters_the(String TypeOfSearchOnID, String ID) {
		taskReportingPageSteps.selectSearchOnID(TypeOfSearchOnID);
		taskReportingPageSteps.enterSearchOnID();
	}

	@When("^Move to Network Order sub tab under domain criteria$")
	public void move_to_Network_Order_sub_tab_under_domain_criteria() {
		taskReportingPageSteps.navigateTo_NetworkOrderPage();
	}

	@When("^User enters the \"([^\"]*)\"$")
	public void user_enters_the(String arg1) {
		taskReportingPageSteps.enterNetworkOrderID(arg1);
	}

	@Then("^User validates that Task with task name \"([^\"]*)\" is getting displayed$")
	public void User_validates_that_Task_with_task_name_is_getting_displayed(String trgTaskName) {
		if (taskReportingPageSteps.getRowNumberforTask(trgTaskName) > 0) {
			assertTrue(true);
		} else {
			assertTrue("Task " + trgTaskName + " does not exist.", false);
		}
	}

	@When("^User clicks on Manage Task link$")
	public void User_clicks_on_ManageTask_link() {
		taskReportingPageSteps.clickOnManageTask();
	}

	@And("^User selects the required group and assign a user by selecting the appropriate name$")
	public void User_selects_the_required_group_and_assign_a_user_by_selecting_the_appropriate_name() {
		tasksPageSteps.populateMandatoryFields(tasksPageSteps.getCurrTask());
	}

	@And("^User clicks on Save and Complete button$")
	public void User_clicks_on_Save_and_Complete_button() {
		tasksPageSteps.clickOn_SaveAndCompleteBtn();
	}

	@And("^User clicks on Refresh button$")
	public void User_clicks_on_Refresh_button() {
		taskReportingPageSteps.refreshSearchResult();
	}

	@Then("^User validates that Task with task name \"([^\"]*)\" is marked as complete$")
	public void User_validates_that_Task_with_task_name_is_marked_as_complete(String trgTaskName) {
		taskReportingPageSteps.waitForTaskCompletion(trgTaskName);
	}

	@And("^User enters required details$")
	public void User_selects_enters_required_details() {
		tasksPageSteps.populateMandatoryFields(tasksPageSteps.getCurrTask());
	}

	@When("^User clicks on Manage Task link for \"([^\"]*)\" task$")
	public void User_clicks_on_Manage_Task_link_for_task(String trgTaskName) {
		taskReportingPageSteps.getRowNumberforTask(trgTaskName);
		taskReportingPageSteps.clickOnManageTask();
	}

	@Then("^User validates that all tasks are marked as complete$")
	public void User_validates_that_all_tasks_are_marked_as_complete() {
		taskReportingPageSteps.validateTasksCompletionStatus(taskReportingPageSteps.getTableRows(),
				taskReportingPageSteps.getTableHeaders());
	}

	// Newly Added
	@And("^User select dependency task filter as \"([^\"]*)\" and automation task filter as \"([^\\\"]*)\"$")
	public void User_select_dependency_task_filter_as_and_automation_task_filter_as(String dependencyTaskFilter,
			String automationTaskFilter) {
		taskReportingPageSteps.selectDependencyTaskFilter(dependencyTaskFilter);
		taskReportingPageSteps.selectAutomationTaskFilter(automationTaskFilter);
	}

	@And("^User validates results grid and completes all the tasks upto \"([^\\\"]*)\" task")
	public void User_validates_results_grid_and_completes_all_the_tasks_upto_task(String trgTaskNameAndProductComponent)
			throws InterruptedException {

		System.out.println("$$$Validating Task Reporting Table...");
		String taskName, taskStatus, performer, processName, productComponent; // orderID,
		int taskNameIndex = -1, taskStatusIndex = -1, productComponentIndex = -1;
		WebElement btn_ManageTask;
		boolean taskCompleted = false;
		List<WebElementFacade> rows = taskReportingPageSteps.getTableRows();
		List<WebElementFacade> headers = taskReportingPageSteps.getTableHeaders();
		int i, j = 0;

		String terminatingRegion = "NA";
		// String terminatingRegion=tasksPageSteps.getTerminatingRegionCode();

		// taskReportingPageSteps.validateTaskPerformer(rows,
		// headers,terminatingRegion);
		// System.out.println("targetTaskName="+trgTaskName);
		while (taskReportingPageSteps.validateTasksCompletionStatus2(rows, headers,
				trgTaskNameAndProductComponent) == false) {
			taskReportingPageSteps.sync(taskReportingPageSteps.getPageObj());
			taskReportingPageSteps.sync(taskReportingPageSteps.getPageObj(),
					ExpectedConditions.visibilityOf(rows.get(1)));//changed from 1 to 0 by umar
			if (j == 0) {
				taskReportingPageSteps.validateTaskPerformer(rows, headers, terminatingRegion);
			}
			for (i = 0; i < rows.size(); i++) {

				List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));

				taskNameIndex = (taskNameIndex > -1) ? taskNameIndex
						: ((taskReportingPageSteps.getColumnNum("Task Name", headers)) - 1);
				taskStatusIndex = (taskStatusIndex > -1) ? taskStatusIndex
						: ((taskReportingPageSteps.getColumnNum("Task Status", headers)) - 1);
				productComponentIndex = (productComponentIndex > -1) ? productComponentIndex
						: ((taskReportingPageSteps.getColumnNum("Product Component", headers)) - 1);

				taskName = cells.get(taskNameIndex).getText();
				taskStatus = cells.get(taskStatusIndex).getText();
				productComponent = cells.get(productComponentIndex).getText();
				tasksPageSteps.setCurrTask(taskName);

				System.out.println("Current Task - " + taskName);

				String[] value = trgTaskNameAndProductComponent.split(" of ");
				String trgTaskName = value[0];
				String trgProductComponent = value[1];
				// System.out.println("Value of i1 -"+i);
				if (taskName.equals(trgTaskName) && trgProductComponent.contains(productComponent)) {
					System.out.println("Equal to Target task");
					break;
				}

				if ((taskName.startsWith("AUTO")) || (taskName.startsWith("DEPENDENCY"))
						|| (taskStatus.equals("Completed"))
						|| (taskName.startsWith("Verify Physical Install Tasks Completion"))
						|| taskName.equals("Work Circuit Design waiting for Port Assignment")
						|| taskName.equals("Waiting for ALL Dates")
						|| (taskName.equals("ActivateSvc_AddlActivation_EU"))
						|| (taskName.equals("ActivateSvc_AddlActivation_NA"))
						|| (taskName.equals("Update Process Data"))
						|| (taskName.equals("Autopilot Offnet Processing is Active"))) {
					if ((taskName.startsWith("AUTO_CompleteBuildingExtension"))
							|| (taskName.startsWith("AUTO_InitiateBuildingExtension"))
							|| (taskName.startsWith("AUTO_Ethernet_Order_Creation"))
							|| (taskName.equals("AUTO_initiate_slm_setup")) || (taskName.equals("AUTO_Create_SAP_PR"))
							|| (taskName.startsWith("AUTO_GetBuildingExtensionCLLIs"))
							|| (taskName.startsWith("DEPENDENCY - buildingExtensionsComplete"))
							|| taskName.equals("AUTO_Meraki_Logistics")
							|| taskName.equals("AUTO_Meraki_Addl_Activation")
							|| taskName.equals("AUTO_PDCS_Trunk_Status_InService")
							|| taskName.equals("AUTO_PDCS_Activate_Path")
							|| taskName.equals("AUTO_PDCS_Path_Status_InService")
							|| (taskName.startsWith("AUTO_EWAS_Init")) || (taskName.startsWith("AUTO_EWAS_Logistics"))
							|| (taskName.startsWith("AUTO_Fortinet_Init"))
							|| (taskName.startsWith("AUTO_Fortinet_Logistics"))
							|| (taskName.startsWith("AUTO_Meraki_Init"))
							|| (taskName.startsWith("AUTO_Meraki_Logistics"))
							|| (taskName.startsWith("AUTO_MerakiMES_Init"))
							|| (taskName.startsWith("AUTO_MerakiMES_Logistics"))
							|| (taskName.startsWith("AUTO_ManageTDG"))
							|| (taskName.startsWith("AUTO_Offnet_Design_CFA"))
							|| (taskName.startsWith("AUTO_Offnet_Qualify_Order"))
							|| (taskName.startsWith("AUTO_Offnet_Complete_Design"))
							|| (taskName.startsWith("AUTO_Offnet_Receive_Complete"))
							|| (taskName.startsWith("AUTO_Offnet_Complete"))
							|| (taskName.startsWith("AUTO_Activate_Network"))) {
						tasksPageSteps.taskSelfAssign(
								rows.get(i).findElement(By.xpath("//td[contains(text(),'" + taskName + "')]")));
						System.out.println("Self-Assigning the task : " + taskName + "     --Successful");
						taskReportingPageSteps.refreshSearchResult();

						break;
					} else if (taskStatus.equals("Completed")) {
						break;
					}

					else if (taskName.equals("Work Circuit Design waiting for Port Assignment")
							|| taskName.equals("Manage Milestones")||taskName.equals("Autopilot Offnet Processing is Active")) {
						taskReportingPageSteps.refreshSearchResult();
						continue;
					} else {
						if (i == 0) {
							taskReportingPageSteps.refreshSearchResult();
						}
						System.out.println("Skipping the task : " + taskName);
						continue;
					}
				}

				btn_ManageTask = cells.get((taskReportingPageSteps.getColumnNum("Actions", headers)) - 1)
						.findElement(By.xpath("//a[contains(@href,'"
								+ cells.get((taskReportingPageSteps.getColumnNum("Task Id", headers)) - 1).getText()
								+ "')]"));
				taskReportingPageSteps.sync(taskReportingPageSteps.getPageObj(), btn_ManageTask);
				taskReportingPageSteps.sync(taskReportingPageSteps.getPageObj(),
						ExpectedConditions.elementToBeClickable(btn_ManageTask));

				JavascriptExecutor js = (JavascriptExecutor) taskReportingPageSteps.getDriver();
				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						cells.get((taskReportingPageSteps.getColumnNum("Actions", headers)) - 1));

				btn_ManageTask.click();
				taskReportingPageSteps.WaitForPageToLoad(120);

				try {
					switch (tasksPageSteps.clickOn_SaveAndCompleteBtn()) {
					case 0:
						taskReportingPageSteps.verifyTaskCompleted(taskName, productComponent);
						j = 0;
						break;

					case 1:

						// System.out.println("Value of i2 -"+i);
						tasksPageSteps.taskSelfAssign(rows.get(i).findElement(
								By.xpath("//td[contains(text(),'" + tasksPageSteps.getCurrTask() + "')]")));
						j = 1;
						break;

					default:
						break;
					}

					rows = taskReportingPageSteps.getTableRows();
					headers = taskReportingPageSteps.getTableHeaders();
					taskNameIndex = -1;
					taskStatusIndex = -1;
				} catch (Exception exp) {
					exp.printStackTrace();
				}

				// taskReportingPageSteps.refreshSearchResult();
				break;

			}
		}
	}

	@Then("^User validates the results grid and completes all the available tasks in task reporting")
	public void User_validates_the_results_grid_and_completes_all_the_available_tasks_in_task_reporting()
			throws InterruptedException {
		// taskReportingPageSteps.validateTaskReportingTable();
		System.out.println("$$$Validating Task Reporting Table...");
		String taskName, taskStatus, taskId, performer, processName, productComponent; // orderID,
		int taskNameIndex = -1, taskStatusIndex = -1, taskIdIndex = -1, productComponentIndex = -1;
		WebElement btn_ManageTask;

		boolean performerValidation = true;
		List<WebElementFacade> rows = taskReportingPageSteps.getTableRows();
		// List<WebElementFacade> columns = taskReportingPageSteps.getTableColumns();
		List<WebElementFacade> headers = taskReportingPageSteps.getTableHeaders();
		int i;

		String terminatingRegion = tasksPageSteps.getTerminatingRegionCode();
//		System.out.println("Termintaing Region code-"+terminatingRegion);

		while (taskReportingPageSteps.validateTasksCompletionStatus(rows, headers) == false) {
			taskReportingPageSteps.sync(taskReportingPageSteps.getPageObj());
			if (rows.size() > 0) {
				taskReportingPageSteps.sync(taskReportingPageSteps.getPageObj(),
						ExpectedConditions.visibilityOf(rows.get(1)));
			} else {
				rows = taskReportingPageSteps.getTableRows();
			}
			// taskReportingPageSteps.sync(taskReportingPageSteps.getPageObj(),
			// ExpectedConditions.visibilityOf(columns.get(1)));
			if (performerValidation == true) {
				taskReportingPageSteps.validateTaskPerformer(rows, headers, terminatingRegion);
			}

			for (i = 0; i < rows.size(); i++) {

				List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
				// orderID = cells.get((taskReportingPageSteps.getColumnNum("Customer Order Id",
				// headers))-1).getText();

				taskNameIndex = (taskNameIndex > -1) ? taskNameIndex
						: ((taskReportingPageSteps.getColumnNum("Task Name", headers)) - 1);
				taskStatusIndex = (taskStatusIndex > -1) ? taskStatusIndex
						: ((taskReportingPageSteps.getColumnNum("Task Status", headers)) - 1);
				taskIdIndex = (taskIdIndex > -1) ? taskIdIndex
						: ((taskReportingPageSteps.getColumnNum("Task Id", headers)) - 1);
				productComponentIndex = (productComponentIndex > -1) ? productComponentIndex
						: ((taskReportingPageSteps.getColumnNum("Product Component", headers)) - 1);

				taskName = cells.get(taskNameIndex).getText();
				taskStatus = cells.get(taskStatusIndex).getText();
				productComponent = cells.get(productComponentIndex).getText();
				taskId = cells.get(taskIdIndex).getText();
				tasksPageSteps.setCurrTask(taskName);

				System.out.println("Current Task - " + taskName);
				// System.out.println("I value - " + i);

				if ((taskName.startsWith("AUTO")) || (taskName.startsWith("DEPENDENCY"))
						|| (taskStatus.equals("Completed"))
						|| (taskName.startsWith("Verify Physical Install Tasks Completion"))
						|| (taskName.equals("Work Circuit Design waiting for Port Assignment"))
						|| (taskName.equals("Waiting for ALL Dates"))
						|| (taskName.equals("ActivateSvc_AddlActivation_EU"))
						|| (taskName.equals("ActivateSvc_AddlActivation_NA"))
						|| (taskName.equals("Update Process Data"))
						|| (taskName.equals("Available for Post Test Exceptn"))
						|| (taskName.equals("Waiting For productCCD set"))) {
					if ((taskName.startsWith("AUTO_CompleteBuildingExtension"))
							|| (taskName.startsWith("AUTO_InitiateBuildingExtension"))
							|| (taskName.startsWith("AUTO_Ethernet_Order_Creation"))
							|| (taskName.equals("AUTO_initiate_slm_setup")) || (taskName.equals("AUTO_Create_SAP_PR"))
							|| (taskName.startsWith("AUTO_GetBuildingExtensionCLLIs"))
							|| (taskName.startsWith("DEPENDENCY - buildingExtensionsComplete"))
							|| taskName.equals("AUTO_Meraki_Addl_Activation")
							|| taskName.equals("AUTO_PDCS_Trunk_Status_InService")
							|| taskName.equals("AUTO_PDCS_Activate_Path")
							|| taskName.equals("AUTO_PDCS_Path_Status_InService")
							|| (taskName.startsWith("AUTO_EWAS_Init")) || (taskName.startsWith("AUTO_EWAS_Logistics"))
							|| (taskName.startsWith("AUTO_Fortinet_Init"))
							|| (taskName.startsWith("AUTO_Fortinet_Logistics"))
							|| (taskName.startsWith("AUTO_Meraki_Init"))
							|| (taskName.startsWith("AUTO_Meraki_Logistics"))
							|| (taskName.startsWith("AUTO_MerakiMES_Init"))
							|| (taskName.startsWith("AUTO_MerakiMES_Logistics"))
							|| (taskName.startsWith("AUTO_ManageTDG")) || (taskName.startsWith("AUTO_Activate_Network"))
							|| (taskName.startsWith("AUTO_NaaS_Qualify_Order"))
							|| (taskName.startsWith("AUTO_NaaS_Create_Port"))
							|| (taskName.startsWith("AUTO_NaaS_Create_Path"))
							|| (taskName.startsWith("AUTO_NaaS_Add_ILC"))
							|| (taskName.startsWith("AUTO_NaaS_Create_Headless_DIA"))
							|| (taskName.startsWith("AUTO_NaaS_Create_Entity"))
							|| (taskName.startsWith("AUTO_NaaS_Create_Internet"))
							//|| (taskName.startsWith("AUTO_GetUserEmailAndCUID"))
							|| (taskName.startsWith("AUTO_GetLocationContactInfo_EAIM"))
							|| (taskName.startsWith("AUTO_EAIM_OT_BPMS_Integration"))
							|| (taskName.startsWith("AUTO_EAIM_OT_OrderAccepted"))
							|| (taskName.startsWith("AUTO_UCPE_Logistics"))
							|| (taskName.startsWith("AUTO_Offnet_Design_CFA"))
							|| (taskName.startsWith("AUTO_Offnet_Qualify_Order"))
							|| (taskName.startsWith("AUTO_Offnet_Complete_Design"))
							|| (taskName.startsWith("AUTO_Offnet_Receive_Complete"))
							|| (taskName.startsWith("AUTO_Offnet_Complete"))
							|| (taskName.startsWith("AUTO_NaaS_Test_Internet"))) {
						tasksPageSteps.taskSelfAssign(
								rows.get(i).findElement(By.xpath("//td[contains(text(),'" + taskName + "')]")));
						System.out.println("Self-Assigning the task : " + taskName + "     --Successful");
						taskReportingPageSteps.refreshSearchResult();
						performerValidation = false;
						break;
					} else if (taskStatus.equals("Completed")) {
						break;
					}

					else if (taskName.equals("Work Circuit Design waiting for Port Assignment")
							|| taskName.equals("Manage Milestones")||taskName.equals("Autopilot Offnet Processing is Active")) {
						taskReportingPageSteps.refreshSearchResult();
						performerValidation = false;
						continue;
					
					} else {
						if (i == 0) {
							taskReportingPageSteps.refreshSearchResult();
						}
						System.out.println("Skipping the task : " + taskName);
						continue;
					}
				}

				// performer =
				// cells.get((taskReportingPageSteps.getColumnNum("Performer"))-1).getText();
				// processName = cells.get((taskReportingPageSteps.getColumnNum("Process
				// Name"))-1).getText();
				btn_ManageTask = cells.get((taskReportingPageSteps.getColumnNum("Actions", headers)) - 1)
						.findElement(By.xpath("//a[contains(@href,'"
								+ cells.get((taskReportingPageSteps.getColumnNum("Task Id", headers)) - 1).getText()
								+ "')]"));
				taskReportingPageSteps.sync(taskReportingPageSteps.getPageObj(), btn_ManageTask);
				taskReportingPageSteps.sync(taskReportingPageSteps.getPageObj(),
						ExpectedConditions.elementToBeClickable(btn_ManageTask));

				JavascriptExecutor js = (JavascriptExecutor) taskReportingPageSteps.getDriver();
				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						cells.get((taskReportingPageSteps.getColumnNum("Actions", headers)) - 1));

				btn_ManageTask.click();
				taskReportingPageSteps.WaitForPageToLoad(120);

				try {
					switch (tasksPageSteps.clickOn_SaveAndCompleteButton()) {
					case 0:
						taskReportingPageSteps.verifyTaskCompleted(taskName, productComponent);
						performerValidation = true;
						break;

					case 1:
						tasksPageSteps.taskSelfAssign(rows.get(i)
								.findElement(By.xpath("//td[text()='" + tasksPageSteps.getCurrTask() + "']")));

						performerValidation = false;
						break;

					default:
						break;
					}

					rows = taskReportingPageSteps.getTableRows();
					headers = taskReportingPageSteps.getTableHeaders();
					taskNameIndex = -1;
					taskStatusIndex = -1;
				} catch (Exception exp) {
					exp.printStackTrace();
				}
				break;
			}
		}
	}

	// task Page
	@Then("User validate the new mandatory Gateway IP field added in task detail page$")
	public void User_validate_the_new_mandatory_Gateway_IP_field_added_in_task_detail_page() {
		tasksPageSteps.validateGatewayIpFieldInTaskPage();
	}

	@Then("User clicks on Manage Task link of \"([^\\\"]*)\" task$")
	public void User_clicks_on_Manage_Task_link_of_task(String trgTaskName) {
		tasksPageSteps.setCurrTask(trgTaskName);
		taskReportingPageSteps.clickOnManageTaskLink(trgTaskName);
	}

	// task Page
	@When("User validate the selected LCON information should display in Local Contacts section$")
	public void User_validate_the_selected_LCON_information_should_display_in_Local_Contacts_section(DataTable dt) {
		List<List<String>> list = dt.asLists(String.class);
		tasksPageSteps.validateLocalContactsInformation(list);
	}

	// task Page
	@When("User validate the Product Family and PIID link in Related PR Dispatch section$")
	public void User_validate_the_Product_Family_and_PIID_link_in_Related_PR_Dispatch_section() {
		tasksPageSteps.validateProductFamily();
	}

	// task Page
	@When("User clicks on Save and Complete button to complete the task$")
	public void User_clicks_on_Save_and_Complete_button_to_complete_the_task() {
		tasksPageSteps.clickOnSaveAndCompleteButton();
	}

	@Then("^user validate the tasks should get completed before Develop and Deploy Config task spwaned in task reporting$")
	public void user_validate_the_should_get_completed_before_Develop_and_Deploy_Config_task_spwaned_in_task_reporting(
			DataTable dt) {

		List<List<String>> list = dt.asLists(String.class);
		// String[] expectedData=new String [2];
		for (int i = 0; i <= list.size() - 1; i++) {
			String expectedData = list.get(i).get(0);
			System.out.println("Expected Data-" + expectedData);
			taskReportingPageSteps.waitForTaskCompletion3(expectedData);

		}

	}

	// task Page
	@Then("^User validate the mandatory Tenant Name editable field added in the task$")
	public void user_validate_the_mandatory_Tenant_Name_editable_field_added_in_the_task() {

		tasksPageSteps.validateMandatoryTenantNameField();
	}

	// task Page
	@Then("^User validate the selected LCON data should dispaly in \"([^\"]*)\"$")
	public void user_validate_the_selected_LCON_data_should_dispaly_in(String taskName, DataTable dt) {

		List<List<String>> list = dt.asLists(String.class);
		tasksPageSteps.validateLocalContactsInformation(list);
	}

	// task Page
	@Then("^validate the Large Kit type dropdown should display the following values$")
	public void validate_the_Large_Kit_type_dropdown_should_display_the_following_values(DataTable dt) {

		List<List<String>> list = dt.asLists(String.class);
		// String[] expectedData=new String [2];
		tasksPageSteps.validateLargeDropdownKitValues(list);
	}

	// task Page
	@Then("^User validate that the selected Kit list \"([^\"]*)\" value should display in create PR dispatch task$")
	public void user_validate_that_the_selected_Kit_list_value_should_display_in_create_PR_dispatch_task(
			String cpeType) {

		tasksPageSteps.verifySelectedCPEPackageType(cpeType);
	}

	// task Page
	@Then("^User validate the XLarge SD WAN device should dispaly the kit list mandatory dropdown with below values$")
	public void user_validate_the_XLarge_SD_WAN_device_should_dispaly_the_kit_list_mandatory_dropdown_with_below_values(
			DataTable dt) {
		List<List<String>> list = dt.asLists(String.class);
		// String[] expectedData=new String [2];
		tasksPageSteps.validateXLargeDropdownKitValues(list);

	}

	@Then("^User validate the following task should gets completed before completion of \"([^\"]*)\" task$")
	public void user_validate_the_following_task_should_gets_completed_before_completion_of_task(String arg1,
			DataTable dt) {

		List<List<String>> list = dt.asLists(String.class);
		// String[] expectedData=new String [2];
		for (int i = 0; i <= list.size() - 2; i++) {
			String expectedData = list.get(i + 1).get(0);
			System.out.println("Expected Data-" + expectedData);
			taskReportingPageSteps.waitForTaskCompletion3(expectedData);
		}

	}

	@Then("^User validate the following tasks should not get spwaned in task reporting$")
	public void user_validate_the_following_tasks_should_not_get_spwaned_in_task_reporting(DataTable dt) {

		List<List<String>> list = dt.asLists(String.class);
		// String[] expectedData=new String [2];
		for (int i = 0; i <= list.size() - 1; i++) {
			String expectedData = list.get(i).get(0);
			System.out.println("Expected Data-" + expectedData);
			taskReportingPageSteps.validateTaskShouldNotTrigger(expectedData);
		}
		
		taskReportingPageSteps.moveToFirstPage();
		taskReportingPageSteps.refreshSearchResult();

	}

//@When("^User navigates to Quickstart sub tab$")
//public void user_navigates_to_Quickstart_sub_tab() {
//taskReportingPageSteps.navigates_to_Quickstart_sub_tab();
//
//}
//
//
//@When("^User selects Search On Id as \"([^\"]*)\" and enters the request \"([^\"]*)\"$")
//public void user_selects_Search_On_Id_as_and_enters_the_request(String TypeOfSearchOnID, String arg2) {
//
//taskReportingPageSteps.selectTypeOfSearchOnID(TypeOfSearchOnID);
//taskReportingPageSteps.enterSearchOnId();
//}

	@Then("^User search the \"([^\"]*)\" task in task reporting page$")
	public void user_search_the_task_in_task_reporting_page(String trgTaskName) {

		taskReportingPageSteps.validateTaskInTaskReportingPage(trgTaskName);
		// taskReportingPageSteps.searchTasksInTaskRepotingPage(trgTaskName);
		taskReportingPageSteps.refreshSearchResult();

	}

	@Then("^User validate the tasks should get completed before \"([^\"]*)\" task spwaned in task reporting$")
	public void user_validate_the_tasks_should_get_completed_before_task_spwaned_in_task_reporting(String arg1,
			DataTable dt) {

		List<List<String>> list = dt.asLists(String.class);
		// String[] expectedData=new String [2];
		System.out.println(list.size());
		for (int i = 0; i <= list.size() - 1; i++) {
			String expectedData = list.get(i).get(0);
			
			System.out.println("Expected Data-" + expectedData);
			taskReportingPageSteps.waitForTaskCompletion3(expectedData);
		}
		taskReportingPageSteps.moveToFirstPage();
		taskReportingPageSteps.refreshSearchResult();

		// throw new PendingException();
	}

	@Then("^User navigates back to the first page of task reporting page$")
	public void user_navigates_back_to_the_first_page_of_task_reporting_page() {

		taskReportingPageSteps.backToTaskReportingFirstPage();
	}

	@Then("^User validates the results grid with the project type$")
	public void user_validates_the_results_grid_with_the_project_type() {
		taskReportingPageSteps.ValidateProjectTypeinTaskReportingPage();

	}

	@When("^User selects the \"([^\"]*)\" option in create Date dropdown and enters the relative date$")
	public void user_selects_the_option_in_create_Date_dropdown_and_enters_the_relative_date(String arg1,
			DataTable arg2) {
		List<List<String>> list = arg2.asLists(String.class);
		// String[] expectedData=new String [2];
		for (int i = 0; i <= list.size() - 2; i++) {
			String expectedData = list.get(i + 1).get(0);
			System.out.println("Expected Data-" + expectedData);
			taskReportingPageSteps.selectTaskCreateDateDropdown(arg1);
			taskReportingPageSteps.selectTaskCreateDateValue(expectedData);
			// taskReportingPageSteps.waitForTaskCompletion3(expectedData);
		}
	}

	@When("^User selects the \"([^\"]*)\" option in complete Date dropdown and enters the relative date$")
	public void user_selects_the_option_in_complete_Date_dropdown_and_enters_the_relative_date(String arg1,
			DataTable arg2) {
		List<List<String>> list = arg2.asLists(String.class);
		// String[] expectedData=new String [2];
		for (int i = 0; i <= list.size() - 2; i++) {
			String expectedData = list.get(i + 1).get(0);
			System.out.println("Expected Data-" + expectedData);
			taskReportingPageSteps.selectTaskCompleteDateDropdown(arg1);
			taskReportingPageSteps.selectTaskCompleteDateValue(expectedData);
			// taskReportingPageSteps.waitForTaskCompletion3(expectedData);
		}

	}

	@When("^User select the \"([^\"]*)\" under Solution Type/Project Type dropdown values$")
	public void user_select_the_under_Solution_Type_Project_Type_dropdown_values(String arg1, DataTable arg2) {
		List<List<String>> list = arg2.asLists(String.class);
		// String[] expectedData=new String [2];
		taskReportingPageSteps.selectSolutionTypeOrProjectType(arg1);

		String expectedData = list.get(1).get(0);
		System.out.println("Expected Data-" + expectedData);

		taskReportingPageSteps.selectProjectTypeValue(expectedData);
		// taskReportingPageSteps.waitForTaskCompletion3(expectedData);

	}

	@Then("User validate the Performer Name in task reporting page$")
	public void User_validate_the_Performer_Name_in_task_reporting_page(String taskName) {
		tasksPageSteps.validatePerformerNameinTaskReportingPage(taskName);

	}


@Then("^User validate the Process Name of \"([^\"]*)\" kicked of in task reporting page$")
public void user_validate_the_Process_Name_of_kicked_of_in_task_reporting_page(String trgTaskName) {
	tasksPageSteps.validateProcessNameinTaskReportingPage(trgTaskName);
}
//	@Then("User validate the Process Name kicked of in task reporting page$")
//	public void User_validate_the_Process_Name_kicked_of_in_task_reporting_page() {
//	
//	}
	

	@And("^User clicks on back To TaskReportingPage$")
	public void User_clicks_on_back_To_TaskReportingPage() {

		tasksPageSteps.backToTaskReportingPage();
	}

	@Then("User validate the Primary Director attribute in task details$")
	public void User_validate_the_Primary_Director_attribute_in_task_details() {
		tasksPageSteps.validatePrimaryDirectorInTaskDetailsPage();

	}

	@Then("^User validate the tasks should get completed before Perform End to End Test task spwaned in task reporting$")
	public void user_validate_task_should_get_completed_before_Perform_End_to_End_Test_task_spwaned_in_task_reporting(
			DataTable dt) {

		List<List<String>> list = dt.asLists(String.class);
		// String[] expectedData=new String [2];
		for (int i = 0; i <= list.size() - 1; i++) {
			String expectedData = list.get(i).get(0);
			System.out.println("Expected Data-" + expectedData);
			taskReportingPageSteps.waitForTaskCompletion3(expectedData);

		}

	}

	@Then("User validate the CPE Package type in task details$")
	public void user_validate_the_CPE_Package_type_in_task_details() {
		tasksPageSteps.validateCPEPackageTypeInTaskPage();
	}

	// vendor orderid -CaptureFOC
	@Then("User validate the Vendor Order Id attribute in task details$")
	public void user_validate_the_Vendor_Order_Id_attribute_in_task_details() {
		tasksPageSteps.validateVendorOrderIdInTaskPage();
	}

	@When("^Move to QuickStart Order sub tab under domain criteria$")
	public void move_to_QuickStart_Order_sub_tab_under_domain_criteria() {

		taskReportingPageSteps.navigateTo_QuickStartPageUnderTaskReporting();
	}

	@Then("^User validate the tasks should get completed before Review SOW task spwaned in task reporting$")
	public void user_validate_the_tasks_should_get_completed_before_Review_SOW_task_spwaned_in_task_reporting(
			DataTable dt) {

		List<List<String>> list = dt.asLists(String.class);
		// String[] expectedData=new String [2];
		for (int i = 0; i <= list.size() - 1; i++) {
			String expectedData = list.get(i).get(0);
			System.out.println("Expected Data-" + expectedData);
			taskReportingPageSteps.waitForTaskCompletion3(expectedData);

		}

	}

	@Then("^User validates the CMMC banner should display on top of page$")
	public void user_validates_the_CMMC_banner_should_display_on_top_of_page() {

		taskReportingPageSteps.validateCMMCBannerOnTopOfPage();

	}
	
	@Then("^User validates the Customer Name in the Manage order page$")
	public void user_validates_the_Customer_Name_in_the_Manage_order_page(DataTable dt) {
		
	List<List<String>> list = dt.asLists(String.class);
	String expectedData = list.get(1).get(0);
	System.out.println("Expected Data-"+expectedData);
	taskReportingPageSteps.validatesCustomerNameInManageOrderPage(expectedData);
	}

	@Then("^User validates the Customer Name in the task reporting page$")
	public void user_validates_the_Customer_Name_in_the_task_reporting_page(DataTable dt) {

	List<List<String>> list = dt.asLists(String.class);
	String expectedData = list.get(1).get(0);
	System.out.println("Expected Data-"+expectedData);
	taskReportingPageSteps.validatesCustomerNameInTaskReportingPage(expectedData);
	}
	
	
	@Then("^User validate the tasks should get completed before \"([^\"]*)\" task completed in task reporting$")
	public void user_validate_the_tasks_should_get_completed_before_task_completed_in_task_reporting(String arg1, DataTable dt) {

		List<List<String>> list = dt.asLists(String.class);
		// String[] expectedData=new String [2];
		for (int i = 0; i <= list.size() - 2; i++) {
			String expectedData = list.get(i + 1).get(0);
			System.out.println("Expected Data-" + expectedData);
			taskReportingPageSteps.waitForTaskCompletion3(expectedData);
		}

		// throw new PendingException();
	}
	
	@When("^User clicks on manage Task link of \"([^\"]*)\" task$")
	public void user_clicks_on_manage_Task_link_of_task(String taskName) {
	  
		taskReportingPageSteps.clickOnManageTasks(taskName);
//		// Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
	}
	

	
	}

