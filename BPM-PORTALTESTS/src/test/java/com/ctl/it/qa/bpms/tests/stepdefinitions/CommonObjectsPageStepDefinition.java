package com.ctl.it.qa.bpms.tests.stepdefinitions;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ctl.it.qa.bpms.steps.OrdersPageSteps;
import com.ctl.it.qa.bpms.steps.TaskReportingPageSteps;
import com.ctl.it.qa.bpms.steps.TasksPageSteps;
import com.ctl.it.qa.bpms.steps.common.CommonObjectsPageSteps;
import com.ctl.it.qa.staf.Page;
//import com.ctl.it.qa.staf.SplunkLogger;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CommonObjectsPageStepDefinition {

	@Steps
	CommonObjectsPageSteps commonObjectsPageSteps;
	@Steps
	OrdersPageSteps ordersPageSteps;
	@Steps
	TasksPageSteps tasksPageSteps;
	@Steps
	TaskReportingPageSteps taskReportingPageSteps;

	@Before
	public void beforeEveryScenario(Scenario scenario) {
		//SplunkLogger.stepDefinitionSplunkBefore(CommonObjectsPageStepDefinition.class, scenario);
	}

	@After
	public void afterEveryScenario(Scenario scenario) {
	//	SplunkLogger.stepDefinitionSplunkAfter(CommonObjectsPageStepDefinition.class, scenario);
		com.ctl.it.qa.staf.Steps.isInitialized = false;
		Page.isInitialized = false;
		// scenario.write("Data used for this test case:" + "\r Order ID : " +
		// Serenity.sessionVariableCalled("OrderID").toString());
		// printData(scenario);
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) commonObjectsPageSteps.getDriver())
					.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		// RallyTools.captureResultforCaaC(scenario); //for version 1.3.2 and below
		// commonObjectsPageSteps.captureTestResult(scenario); //for version 1.3.3 and

		commonObjectsPageSteps.getDriver().quit();

	}

	@Given("^User Launches BPMS Portal and logs in as \"([^\"]*)\" with valid credentials$")
	public void User_Launches_BPMS_Portal_and_logs_in_as_with_valid_credentials(String userName) throws Throwable {
		commonObjectsPageSteps.launchPortalAndLogin(userName);
	}

	@When("^User fetch the sanity orderId from database$")
	public void user_fetch_the_sanity_orderId_from_database() throws SQLException {
		commonObjectsPageSteps.getOrderIDFromDB();
	}

	@When("^User fetch the orderId from database \"([^\"]*)\"$")
	public void user_fetch_the_orderId_from_database(String orderId) {
		commonObjectsPageSteps.getOrderIDFromDatabse(orderId);
	}

	@Given("^User launches BPMS portal and logged in as \"([^\"]*)\" with valid credentials$")
	public void user_launches_BPMS_portal_and_logged_in_as_with_valid_credentials(String userName) {
		commonObjectsPageSteps.loginToBPMSPortal(userName);
	}
//	
//	@Given("^User launches BPMS portal and logged in as \"([^\"]*)\" with valid credentials$")
//	public void user_launches_BPMS_portal_and_logged_in_as_with_valid_credentials(String userName) {​
//	commonObjectsPageSteps.loginToBPMSPortal(userName);
//	}
}
