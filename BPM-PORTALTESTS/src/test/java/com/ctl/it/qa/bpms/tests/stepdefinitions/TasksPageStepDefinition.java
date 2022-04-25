package com.ctl.it.qa.bpms.tests.stepdefinitions;

import java.util.List;

import com.ctl.it.qa.bpms.steps.OrdersPageSteps;
import com.ctl.it.qa.bpms.steps.TasksPageSteps;
import com.ctl.it.qa.bpms.steps.common.CommonObjectsPageSteps;

import io.cucumber.datatable.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TasksPageStepDefinition {

	@Steps
	CommonObjectsPageSteps commonObjectsPageSteps;
	@Steps
	OrdersPageSteps ordersPageSteps;
	@Steps
	TasksPageSteps tasksPageSteps;

	@Then("^User validate the following links url in \"([^\"]*)\" task details page$")
	public void user_validate_the_following_links_url_in_task_details_page(String taskName, DataTable links) {

		List<List<String>> list = links.asLists(String.class);
		// String[] expectedData=new String [2];
		for (int i = 0; i <= list.size() - 2; i++) {
			String linkName = list.get(i + 1).get(0);
			// System.out.println("Expected Data-"+expectedData);
			tasksPageSteps.validateLinksInTaskDetailsPage(linkName, taskName);
			// tasksPageSteps.validateLinksUrlInTaskDetailsPage(linkName,taskName);

		}

	}

	@Then("^User validate the \"([^\"]*)\" value in \"([^\"]*)\" task of Cellular Access$")
	public void user_validate_the_value_in_task_of_Cellular_Access(String primaryWireless, String taskName) {
		String[] primaryWirelessValue = primaryWireless.split("-");
		System.out.println("Primary Wireless Expected Value-" + primaryWirelessValue[1]);
		tasksPageSteps.validatePrimaryWirelessValueInTaskDetailsPage(primaryWirelessValue[1]);

	}

	@Then("^User validate the primary wireless banner should display on the top of task$")
	public void user_validate_the_primary_wireless_banner_should_display_on_the_top_of_task() {
		tasksPageSteps.validatePrimarywirelessBannerOnTopOfOrderInformationSection();
	}

	@Then("^User validate that the new \"([^\"]*)\" field should display in \"([^\"]*)\" task details page$")
	public void user_validate_that_the_new_field_should_display_in_task_details_page(String arg1, String arg2) {

		tasksPageSteps.validateAltShippingAddressFieldInTaskDetailsPage();

	}

	@When("^User enters the Alt Shipping Address value$")
	public void user_enters_the_Alt_Shipping_Address_value() {

		tasksPageSteps.enterAltShipAddressFieldValue();
	}

	@When("^User validate the entered \"([^\"]*)\" should display in \"([^\"]*)\" task$")
	public void user_validate_the_entered_should_display_in_task(String arg1, String arg2) {
		tasksPageSteps.validateAltShipAddressFieldValue();
	}

	@Then("^User validate the spare device displays as a warning label above the Order information section$")
	public void user_validate_the_spare_device_displays_as_a_warning_label_above_the_Order_information_section() {

		// tasksPageSteps.validateSpareDeviceWarningLabel();
	}

	@Then("^User validate the Vendor Order Id attribute should display in task details$")
	public void user_validate_the_Vendor_Order_Id_attribute_should_display_in_task_detial() {
		tasksPageSteps.validateVendorOrderIdAttributeOnTaskDetails();
	}

	@Then("^User validate the internally supported CPE attribute should display in task details$")
	public void user_validate_the_internally_supported_CPE_attribute_should_display_in_task_detial() {
		tasksPageSteps.validateInternallySupportedCPEAttributeInTaskDetails();

	}

	@Then("^User validate the selected internally supported CPE value should display in task details$")
	public void user_validate_the_selected_internally_supported_CPE_value_should_display_in_task_detial() {

		tasksPageSteps.validateSelectedInternallySupportedCPEValue();
	}

	@Then("^User validate the task will open until all related access types are completed$")
	public void user_validate_the_task_will_open_until_all_related_access_types_are_completed() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new PendingException();
	}

	@Then("^User validate the following attributes in \"([^\"]*)\" task$")
	public void user_validate_the_following_attributes_in_task(String arg1, DataTable dt) {
		List<List<String>> list = dt.asLists(String.class);
		tasksPageSteps.validateAttributesInAuto_Meraki_Init_TaskDetailsPage(list);
	}

	@Then("^User validate the Static IP and Wireless IMEI is optional atrribute in \"([^\"]*)\" task$")
	public void user_validate_the_Static_IP_and_Wireless_IMEI_is_optional_atrribute_in_task(String arg1) {

		tasksPageSteps.validateStaticIpAndWirelessIMEIAttributes();

	}

	@Then("^user validate the mandatory device Name field should allow (\\d+) character$")
	public void user_validate_the_mandatory_device_Name_field_should_allow_character(int value) {

		tasksPageSteps.validateDeviceNameMandatoryFieldWithMaxlengthCharacter();
	}

	@When("^user validates the task should display the Access SCID$")
	public void user_validates_the_task_should_display_the_Access_SCID() {

		tasksPageSteps.validateAccessSCID();

	}

	@When("^user validates the task should display the CPE SCID$")
	public void user_validates_the_task_should_display_the_CPE_SCID() {

		tasksPageSteps.validateCPESCID();
	}

	@Then("^User validates the Follow Up Date should display the in task details page$")
	public void user_validates_the_Follow_Up_Date_should_display_the_in_task_details_page() {
		// tasksPageSteps.validateFollowUpDateFieldInTaskDetaislPage();
	}

	@Then("^User validate the following attributes in \"([^\"]*)\" task details page$")
	public void user_validate_the_following_attributes_in_task_details_page(String arg1, DataTable dt) {
		List<List<String>> list = dt.asLists(String.class);
		// tasksPageSteps.validateAttributesInTaskDetailsPage(arg1,list);

	}

	@Then("^User validate the device name field should accept max length character in task detail page$")
	public void user_validate_the_device_name_field_should_accept_max_length_character_in_task_detail_page() {
		tasksPageSteps.validateDeviceNameMandatoryFieldWithMaxlengthCharacter();
	}

	@Then("User validate InternalTDGRequired dataslot present in task detail page$")
	public void user_validate_InternalTDGRequired_dataslot_present_in_task_detail_page() {
		tasksPageSteps.validateInternalTDGRequiredInTaskPage();
	}

	@Then("User validate the Device PID present in task detail page$")
	public void user_validate_the_Device_PID_present_in_task_detail_page() {
		tasksPageSteps.validateDevicePIDInTaskDetailsPage();
	}

	@Then("^User validate the exit to BAU attributes in \"([^\"]*)\" task$")
	public void user_validate_the_exit_to_BAU_attributes_in_task(String arg1) {
		tasksPageSteps.validateExitToBAUFieldInTaskDetailsPage();
	}

	@Then("^User validate the region code value in \"([^\"]*)\" task$")
	public void user_validate_the_region_code_value_in_task(String arg1) {
		tasksPageSteps.validateRegionCodeValueInTaskDetailsPage();
	}

	@Then("^User validates the EAIM Customer Name in the \"([^\"]*)\" task$")
	public void user_validates_the_EAIM_Customer_Name_in_the_task(String arg1) {
		tasksPageSteps.validateEAIMCustomerNameInTaskDetailsPage();

	}

	@Then("User validate the additional dropdownvalues in Primary Director in task detail page$")
	public void user_validate_the_additional_dropdownvalues_in_Primary_Director_in_task_detail_page() {
		tasksPageSteps.validatePrimaryDirectorDropDownValuesInTaskDetailsPage();
	}

	@When("^User User selects the alternate site option in client site or alternate site dropdown$")
	public void user_User_selects_the_alternate_site_option_in_client_site_or_alternate_site_dropdown() {
		tasksPageSteps.selectsAlternate_Site_option_In_ClientSite_Or_AlternateSiteFieldsInTaskDetailsPage();
	}

	@Then("^User validates the PL and SL fields will be enabled$")
	public void user_validates_the_PL_and_SL_fields_will_be_enabled() {
		tasksPageSteps.validatesPL_and_SL_FieldsInTaskDetailsPage();
	}

	@When("^User selects the client site option in client site or alternate site dropdown$")
	public void user_selects_the_client_site_option_in_client_site_or_alternate_site_dropdown() {
		tasksPageSteps.selectsClient_Site_option_In_ClientSite_Or_AlternateSiteFieldsInTaskDetailsPage();

	}

	@Then("^User validates the PL and SL fields will be disabled$")
	public void user_validates_the_PL_and_SL_fields_will_be_disabled() {

	}

	@Then("^User validate the cost of intervention field in \"([^\"]*)\" task$")
	public void user_validate_the_cost_of_intervention_field_in_task(String arg1) {
		tasksPageSteps.validateCostOfInterventionFieldsInTaskDetailsPage();

	}

	@Then("^User validate the no show dropdown values in \"([^\"]*)\" task$")
	public void user_validate_the_no_show_dropdown_values_in_task(String arg1) {
		tasksPageSteps.validatesNoShowDropdownValuesInTaskReportingPage();
	}

	@Then("^User selects the No value in no show dropdown$")
	public void user_selects_the_Yes_value_in_no_show_dropdown() {
		tasksPageSteps.selectNoValueInNoShowDropdown();
	}

	@Then("^User validates the Reason No show attributes is not required field$")
	public void user_validates_the_Reason_No_show_attributes_is_not_required_field() {
		tasksPageSteps.validateReasonForNoShowAttributesStatus();

	}

	@Then("^User validate the below \"([^\"]*)\" with \"([^\"]*)\" values in \"([^\"]*)\" task$")
	public void user_validate_the_below_with_values_in_task(String arg1, String arg2, String arg3, DataTable values) {
		List<List<String>> list = values.asLists(String.class);

		tasksPageSteps.validatesdropdownValuesInEAIMApprovalInterventionTask(list);
	}

	@Then("^User validate the client site or alternate site dropdown values in \"([^\"]*)\" task$")
	public void user_validate_the_client_site_or_alternate_site_dropdown_values_in_task(String arg1) {

		tasksPageSteps.validateClientSite_Or_AlternateSiteFieldsInTaskDetailsPage();
	}
	
	@When("^User enters the activation result and fcd date required field in \"([^\"]*)\" task$")
	public void user_enters_the_activation_result_and_fcd_date_required_field_in_task(String taskName) {
		tasksPageSteps.enterActivationResultAndfcdDate(taskName);
	}


	@Then("^User validate FCD with CCD")
	public void user_validate_FCD_with_CCD() {
		tasksPageSteps.validateFCDwithCCD();
	}
	
	@When("^User provides \"([^\"]*)\" value in AutopilotManagedOffnet text field$")
	public void user_provides_value_in_AutopilotManagedOffnet_text_field(String autoPilotManagedOffnetTxtFieldvalue) {
		tasksPageSteps.autoPilotManagedOffnetTxtField(autoPilotManagedOffnetTxtFieldvalue);
	}


	@When("^User creates the ASR in the Design Offnet Segment task for DAL order")
	public void user_creates_the_ASR_in_the_Design_Offnet_Segment_task_for_DAL_order() {
		tasksPageSteps.createASRForDALOrder();
	}

	


}