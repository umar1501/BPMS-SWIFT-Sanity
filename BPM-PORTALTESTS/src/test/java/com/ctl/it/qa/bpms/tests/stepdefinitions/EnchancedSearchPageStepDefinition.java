package com.ctl.it.qa.bpms.tests.stepdefinitions;

import com.ctl.it.qa.bpms.steps.EnchancedSearchPageSteps;
import com.ctl.it.qa.bpms.steps.OrdersPageSteps;
import com.ctl.it.qa.bpms.steps.TasksPageSteps;
import com.ctl.it.qa.bpms.steps.common.CommonObjectsPageSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class EnchancedSearchPageStepDefinition {

	@Steps
	CommonObjectsPageSteps commonObjectsPageSteps;
	@Steps
	OrdersPageSteps ordersPageSteps;
	@Steps
	TasksPageSteps tasksPageSteps;
	@Steps
	EnchancedSearchPageSteps enchancedSearchPageSteps;

	@When("^User clicks on Enchanced Search tab at the top of the page$")
	public void User_clicks_on_Enchanced_Search_tab_at_the_top_of_the_page() {
		enchancedSearchPageSteps.navigateTo_EnchanceSearchPage();
	}

	@And("^User clicks on Search sub-tab in EnchancedSearch Page$")
	public void User_clicks_on_Search_sub_tab_in_EnchancedSearch_Page() {
		enchancedSearchPageSteps.navigateTo_SearchTabinEnchancedSearch();
	}

	@And("^User clicks on Task Search subtab in Search subtab$")
	public void User_clicks_on_Task_Search_subtab_in_Search_subtab() {
		enchancedSearchPageSteps.navigateTo_SearchTabinEnchancedSearch();
	}

	@And("^User selects Search On Id in TaskSearch EnchancedSearch as \"([^\"]*)\" and enters the \"([^\"]*)\"$")
	public void User_selects_Search_On_Id_in_TaskSearch_EnchancedSearch_as_and_enters_the(String TypeOfSearchOnID,
			String ID) {
		enchancedSearchPageSteps.selectSearchOnID(TypeOfSearchOnID);
		enchancedSearchPageSteps.enterSearchOnID();
		// taskReportingPageSteps.enterSearchOnID();
	}

	@And("^User clicks on Task Search Go button$")
	public void User_clicks_on_Task_Search_Go_button() {
		enchancedSearchPageSteps.clickOn_TaskSearchGoBtn();
	}

	@Then("User validate the CountryCode in task Search Result in Enchancedreporting page$")
	public void User_validate_the_CountryCode_in_task_Search_Result_in_Enchancedreporting_page() {
		enchancedSearchPageSteps.validateCountrycodeInTaskSearchEnchancedSearchPage();

	}

}
