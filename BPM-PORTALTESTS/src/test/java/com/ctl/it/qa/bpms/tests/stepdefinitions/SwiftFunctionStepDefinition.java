package com.ctl.it.qa.bpms.tests.stepdefinitions;

import java.sql.SQLException;

import com.ctl.it.qa.bpms.pages.SfaContractPage;
import com.ctl.it.qa.bpms.pages.SwiftHomePage;
import com.ctl.it.qa.bpms.steps.SfaSteps;
import com.ctl.it.qa.bpms.steps.SwiftFunctionSteps;
import com.ctl.it.qa.bpms.steps.UserSteps;
import com.ctl.it.qa.staf.Page;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import database.steps.DbValidations;
import database.steps.SwiftDBSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class SwiftFunctionStepDefinition {
	@Steps
	UserSteps endUser;
	SwiftHomePage swifthomePage;
	
	@Steps
	SwiftFunctionSteps swiftfunctionSteps;
	
	@Steps
	SfaSteps sfasteps;
	
//	@Steps
	//OpportunityPage opportunityPage;
	
	@Steps
	SfaContractPage sfaContractPage;
	
	@Steps
	SwiftDBSteps swiftDBSteps;
	DbValidations dbvalidations;
	


	
	// ********************** GIVEN METHODS **************************

	/*@Given("^I am logged in as a \"([^\"]*)\" user in SSO$")
	public void i_am_logged_in_as_a_user_in_SSO(String userType) {
		String url = Page.envData.getFieldValue("sso-console");
		Serenity.setSessionVariable("url").to(url);
		Serenity.setSessionVariable("user_type").to(userType);
		endUser.is_in_sso_login_page(url);
		endUser.logs_in_sso_as(userType);
	}*/
	
	@When("^I am opening a swift application$")
	public void i_am_opening_a_swift_application() {
		String url = Page.envData.getFieldValue("swift-url");
		Serenity.setSessionVariable("url").to(url);
		//Serenity.setSessionVariable("user_type").to(userType);
		endUser.is_in_swift_login_page(url);
		//endUser.logs_in_sso_as(userType);
	}
	
	/*@Given("^I log in with \"([^\"]*)\" user in SFA as CareOrder$")
	public void i_log_in_with_user_in_SFA_as_careorder(String userType){
		String url = Page.envData.getFieldValue("sso-console");
		Serenity.setSessionVariable("url").to(url);
		Serenity.setSessionVariable("user_type").to(userType);
		endUser.is_in_sfa_login_page(url);
		endUser.logs_in_as(userType);
		Serenity.setSessionVariable("user_type").to(userType);
	}*/
	
	@Given("I navigate to swift application page with \"([^\"]*)\"")
	public void i_navigate_to_swift_application_page_with(String Account) throws InterruptedException {
		swiftfunctionSteps.i_navigate_to_swift_application_page_with_customer(Account);
	    
	}
	
	// ********************** WHEN METHODS **************************
	
	/*@When("^I search for Opportunity ID \"([^\"]*)\" in SFA$")
	public void i_search_opptyID_in_sfa(String oppty_id) {
		System.out.println("Start");
	//	cgtContractSteps.search_oppty(oppty_id);
		
		sfasteps.open_record("Opportunities", oppty_id);
		
		}*/
	
	

	// ********************** THEN METHODS **************************


	@Then("^I Impersonate to different User \"([^\"]*)\"$")
	public void i_impersonate_to_different_user(String user_id) {
		swiftfunctionSteps.impersonateuser(user_id);
//		Click on the usericon
//		Change the username
//		Click on Impersonate
	}
	
	@Then("^I load the Order Package in Swift by its \"([^\"]*)\" for \"([^\"]*)\" status$")
	public void load_the_order_package(String dd_list, String status) throws ClassNotFoundException, SQLException {
		swiftDBSteps.DataBaseConnection();
		String OPID = dbvalidations.fetchOPId(status);
		i_am_opening_a_swift_application();
		swiftfunctionSteps.loadOPbyOPID(dd_list,OPID);
	}
	
	@Then("^I load the Order Package in Swift by its \"([^\"]*)\" for \"([^\"]*)\" status using \"([^\"]*)\"$")
	public void load_the_order_package (String dd_list, String status, String BOID ) throws ClassNotFoundException, SQLException {
		i_am_opening_a_swift_application();
//		swiftfunctionSteps.loadOPbyBOID(dd_list,BOID);
	}
	
	/*@Then("I create DIA product {string} {string}")
	public void i_create_DIA_product(String Product, String Address) throws InterruptedException {
		
		swiftfunctionSteps.create_DIA_product(Product,Address);
	}*/
	
	/*@Then("I should validate and complete the order {string} {string} {string}")
	public void i_should_validate_and_complete_the_order(String Order_Type, String CCM, String OES) throws InterruptedException {
		String dd_list = "Order Package Id";
		String OPID = "552100809";
		swiftfunctionSteps.loadOPbyOPID(dd_list, OPID);
		swiftfunctionSteps.Validate_And_Complete_The_Order(Order_Type,CCM,OES);
	}*/
	
	// ********************** AND METHODS **************************
	/*@And("^I click on Generate Contract$")
	public void iClickOnGenerateContract() throws InterruptedException{
		sfasteps.WaitForPageToLoad(150);
		opportunityPage.shouldExist(opportunityPage);
		opportunityPage.generateContract();
	}*/

	/*@And("^I am navigated to Contract page$")
	public void iAmNavigatedToContractPage() throws InterruptedException{
	//	sfasteps.WaitForPageToLoad(150);
		Thread.sleep(5000);
		sfaContractPage.shouldExist(sfaContractPage);
	}*/
	
	@And("I Verify the Account info {string} {string}")
	public void i_Verify_the_Account_info(String Sales_office, String ProductID) throws InterruptedException {
		swiftfunctionSteps.Verify_Account_info(Sales_office,ProductID);
	}
}

