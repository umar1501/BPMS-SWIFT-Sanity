package com.ctl.it.qa.bpms.tests.stepdefinitions;

import com.ctl.it.qa.bpms.steps.RegressionSteps;
import com.ctl.it.qa.bpms.steps.SwiftFunctionSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RegressionUserStepDefinition {

	@Steps

	RegressionSteps Regsteps;

	@Steps
	SwiftFunctionSteps swiftfunctionSteps;

	//********************** GIVEN METHODS **************************


	@Given("User logged in Swift in specified environment {string} with Account ID {string}")
	public void user_logged_in_Swift_in_specified_environment_with_Account_ID(String ENV, String Account_ID) {

		Regsteps.user_logged_in_Swift_in_specified_environment_with_Account_ID(ENV, Account_ID);
	}




	// ********************** WHEN METHODS **************************

	
	@When("User creates the new order package")
	public void user_creates_the_new_order_package() {
		Regsteps.user_creates_the_new_order_package();
	}

	@When("User validates order package created by searching for order package ID")
	public void user_validates_order_package_created_by_searching_for_order_package_ID() {
		Regsteps.user_validates_order_package_created_by_searching_for_order_package_ID();
	}

	@When("User search and select the following CLLI {string} and Product {string}")
	public void user_search_and_select_the_following_CLLI_and_Product(String clli, String product) {
		Regsteps.user_search_and_select_the_following_CLLI_and_Product(clli,product);
	}


	@When("User configures and saves the product {string}")
	public void user_configures_and_saves_the_product(String attributeList) {
		Regsteps.user_configures_and_saves_the_product(attributeList);
	}
	
	@When("User updates the contact details {string}")
	public void user_updates_the_contact_details(String Contact) {

		Regsteps.user_updates_the_contact_details(Contact);
	}

	
	@When("User updates the order details and dates {string}")
	public void user_updates_the_order_details_and_dates(String order_type) {
		Regsteps.user_updates_the_order_details_and_dates(order_type);
	}

	/*@When("I craete the order package with required products for Cllis {string}")
	public void i_craete_the_order_package_with_required_products_for_Cllis(String Clli) {
		Regsteps.I_craete_the_order_package_with_required_products_for_Cllis(Clli);

	}*/

	/*@When("I attach the SOF in swift")
	public void i_attach_the_SOF_in_swift() {

		diaRegsteps.i_attach_the_SOF_in_swift();
	}

	@When("I validate, reassign and complete the first task in swift")
	public void i_validate_reassign_and_complete_the_first_task_in_swift() {

		diaRegsteps.i_validate_reassign_and_complete_the_first_task_in_swift();
	}

	@When("I reassign, validate and complete the second task in swift {string}")
	public void i_reassign_validate_and_complete_the_second_task_in_swift(String ENV) {

		diaRegsteps.i_reassign_validate_and_complete_the_second_task_in_swift(ENV);
	}

	@When("I reassign, validate and complete the last task in swift")
	public void i_reassign_validate_and_complete_the_last_task_in_swift() {

		diaRegsteps.i_reassign_validate_and_complete_the_last_task_in_swift();

	}*/

	// ********************** THEN METHODS **************************

	@Then("User should validate and complete the tasks generated")
	public void User_should_validate_and_complete_the_tasks_generated() throws InterruptedException {
		//String dd_list = "Order Package Id";
		//String OPID = "552050931";
		//swiftfunctionSteps.loadOPbyOPID(dd_list, OPID);
		Regsteps.User_should_validate_and_complete_the_tasks_generated();
	}

	@Then("I should validate and complete the First task")
	public void i_should_validate_and_complete_the_First_task() {

		Regsteps.i_should_validate_and_complete_the_First_task();
	}


	@Then("I Should Validate and complete GOD task")
	public void i_Should_Validate_and_complete_GOD_task() {

		Regsteps.i_Should_Validate_and_complete_GOD_task();
	}

	@Then("I Should validate and complete welcome customer and customer cord task for HDIC {string}")
	public void i_Should_validate_and_complete_welcome_customer_and_customer_cord_task_for_HDIC(String ENV) {

		Regsteps.i_Should_validate_and_complete_welcome_customer_and_customer_cord_task_for_HDIC(ENV);
	}

	@Then("I should validate and complete waiting for Downstream system task in metastorm {string}")
	public void i_should_validate_and_complete_waiting_for_Downstream_system_task_in_metastorm(String ENV) {

		Regsteps.i_should_validate_and_complete_waiting_for_Downstream_system_task_in_metastorm(ENV);
	}

	@Then("I should validate and complete Order Validation task.")
	public void i_should_validate_and_complete_Order_Validation_task() {
		Regsteps.i_should_validate_and_complete_Order_Validation_task();
	}

	@Then("I should validate customer as \"([^\"]*)\" for Authorised user")
	public void i_should_validate_customer_as_for_Authorised_user(String CustName) {
		Regsteps.i_should_validate_customer_as_for_Authorised_user(CustName);
	}





}
