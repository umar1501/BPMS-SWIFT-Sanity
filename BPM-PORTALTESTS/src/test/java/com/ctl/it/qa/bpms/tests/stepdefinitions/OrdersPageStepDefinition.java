package com.ctl.it.qa.bpms.tests.stepdefinitions;

import java.util.List;

import com.ctl.it.qa.bpms.steps.OrdersPageSteps;
import com.ctl.it.qa.bpms.steps.TaskReportingPageSteps;
import com.ctl.it.qa.bpms.steps.TasksPageSteps;
import com.ctl.it.qa.bpms.steps.common.CommonObjectsPageSteps;

import io.cucumber.datatable.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrdersPageStepDefinition {

	@Steps
	CommonObjectsPageSteps commonObjectsPageSteps;
	@Steps
	OrdersPageSteps ordersPageSteps;
	@Steps
	TasksPageSteps tasksPageSteps;
	@Steps
	TaskReportingPageSteps taskReportingPageSteps;

	@When("^User Navigates to Orders Page$")
	public void User_Navigates_to_Orders_Page() {
		ordersPageSteps.navigateTo_OrdersPage();
	}

	@Then("^Results Grid is displayed with details$")
	public void Results_Grid_is_displayed_with_details() {
		ordersPageSteps.IsSearchResultTableDispalyed();
	}

	@And("^User validates Results Grid with following data for ID")
	public void User_validates_Results_Grid_with_following_data(DataTable dt) {
		List<List<String>> list = dt.asLists(String.class);
		ordersPageSteps.validateOrdersPage_ResultsTable(list);
	}

	@And("^User Enters Search Criteria with SearchOnIDType as \"([^\"]*)\" and SearchOnID on Orders Page$")
	public void User_Enters_Search_Criteria_with_SearchOnID_as_and_SearchOnID_as_on_Orders_Page(
			String TypeOfSearchOnID) {
		ordersPageSteps.selectSearchOnID(TypeOfSearchOnID);

		ordersPageSteps.enterSearchOnID();

	}

	@When("^User clicks on Orders tab at the top of the page$")
	public void User_clicks_on_Orders_tab_at_the_top_of_the_page() {
		ordersPageSteps.navigateTo_OrdersPage();
	}

	@And("^User selects Customer Order sub-tab under Search Criteria$")
	public void User_selects_Customer_Order_sub_tab_under_Search_Criteria() {
		ordersPageSteps.navigateTo_CustomerOrderTab();
		;
	}

	@And("^User selects \"([^\"]*)\" and enters the \"([^\"]*)\"$")
	public void User_selects_and_enters_the_ID(String TypeOfSearchOnID, String ID) {
		ordersPageSteps.selectSearchOnID(TypeOfSearchOnID);
		ordersPageSteps.enterSearchOnID();
	}

	@And("^User clicks on search button$")
	public void User_clicks_on_search_button() {
		ordersPageSteps.clickOn_SearchBtn();
	}

	@Then("^User validates the Order Status as \"([^\"]*)\"$")
	public void User_validates_the_Order_Status_as(String trgOrderStatus) {
		ordersPageSteps.validate_OrderStatus(trgOrderStatus);
	}

	@When("^User clicks on Manage Order link$")
	public void User_clicks_on_Manage_Order_link() {
		ordersPageSteps.clickOn_ManageOrder();
	}

	@And("^User clicks on Select an order version under Order Details Tab$")
	public void User_clicks_on_Select_an_order_version_under_Order_Details_Tab() {
		ordersPageSteps.click_SelectAnOrderVersion();
	}

	@And("^User clicks on version number hyperlink$")
	public void User_clicks_on_version_number_hyperlink() {
		ordersPageSteps.click_VersionNumber();
	}

	@When("^User clicks on Back link$")
	public void User_clicks_on_Back_link() {
		ordersPageSteps.click_BackBtn();
	}

	@When("^User clicks on Manage Order link against \"([^\\\"]*)\" type$")
	public void user_clicks_on_Manage_Order_link_against_type(String productType) {
		ordersPageSteps.clickOn_ManageOrderInOrderPage(productType);
	}

	@Then("^User should have High availability flag as \"([^\"]*)\"$")
	public void user_should_have_High_availability_flag_as(String status) {
		ordersPageSteps.checkHighAvailabilityStatus(status);
	}

	@Then("^User validates the CCD in order details tab for HC_SDWAN_CPE$")
	public void user_validates_CCD_in_order_details_tab_for_HC_SDWAN_CPE() {
		ordersPageSteps.validateCCD();
	}

	@Then("^User retrieves the service Id of \"([^\"]*)\" component$")
	public void user_retrieves_the_service_Id_of_component(String component) {

		ordersPageSteps.retrieveServiceIdOfComponent(component);
	}

	@Then("^User validate the number of static IPs attribute value$")
	public void user_validate_the_number_of_static_IPs_attribute_value() {
		ordersPageSteps.validateNoOfStaticIP();
	}

	@Then("^User validates the Product Family in order details tab$")
	public void User_validates_the_Product_Family_in_order_details_tab() {
		ordersPageSteps.validateProductFamily();
	}

	@Then("^User validates the TDG Data in order details tab$")
	public void User_validates_the_TDG_Data_in_order_details_tab() {
		ordersPageSteps.validateTDGData();
	}

	@Then("^User validates the SalesRepRegion in order details tab$")
	public void User_validates_the_SalesRepRegion_in_order_details_tab() {
		ordersPageSteps.validateSalesRegionCode();
	}

	@Then("^User validates the HotCut Details in order details tab$")
	public void User_validates_the_HotCut_Details_in_order_details_tab() {
		ordersPageSteps.validateHotCutDetails();
	}

	@When("^Move to QuickStart Order sub tab under Orders Page$")
	public void move_to_QuickStart_Order_sub_tab_under_Orders_Page() {
		commonObjectsPageSteps.navigateToQuickStartPageUnderOrderPage();
	}

	@Then("^User validates the ProjectGroupId in order details tab$")
	public void User_validates_the_ProjectGroupId_in_order_details_tab() {
		ordersPageSteps.validateProjectIDLength();
	}

	@When("^User selects the \"([^\"]*)\" and enters the \"([^\"]*)\"$")
	public void user_selects_the_and_enters_the(String TypeOfSearchOnID, String Id) {
		ordersPageSteps.selectQSSearchOnID(TypeOfSearchOnID);
		ordersPageSteps.enterQSSearchOnID(Id);
	}
	
	@When("^User clicks on Process Progression link of Data component in orders page$")
	public void User_clicks_on_Process_Progression_link_of_Data_component_in_orders_page(String productType) {
		ordersPageSteps.clickOn_ProcessProgression_DataComponent(productType);
	}

	@And("^User clicks on Logic History in Process Progression page$")
	public void User_clicks_on_Logic_History_in_Process_Progression_page() {
		ordersPageSteps.clickOn_LogicHistory();
	}

	
	@Then("^User validates the BEDependency Decomposer task $")
	public void User_validates_the_BEDependency_Decomposer_task() {
		ordersPageSteps.validateBEDependencyDecomposertask();
	}
}