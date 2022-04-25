package com.ctl.it.qa.bpms.pages;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SwiftPage extends Page{
	
	@FindBy(xpath = "(//span[contains(@class,'k-widget k-dropdown k-header')])[1]")
	public WebElementFacade ddl_business_order_id_select;
	
	@FindBy(xpath = "(//input[contains(@id,'AccountNumberSearchEntry')])[1]")
	public WebElementFacade tbx_account;
	
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'Business Order Id')]")
	public WebElementFacade ddl_business_order_id_selected;
	
	@FindBy(xpath = "//input[contains(@id,'searchId')]")
	public WebElementFacade tbx_order_id_field;	
	
	@FindBy(xpath = "(//span[contains(@class,'k-input ng-scope')])[1]")
	public WebElementFacade tbx_order_id;	
		
	@FindBy(xpath = "//a[contains(@id,'searchBtn')]")
	public WebElementFacade btn_search;
	
	@FindBy(xpath = "(//button[@id='AccountManagementSearchBtn'])[1]")
	public WebElementFacade btn_select_account;
	
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[2]")
	public WebElementFacade ddl_select_order_type;
	
	@FindBy(xpath = "//*[@id=\"OrderTypeDropdown\"]")
	public WebElementFacade order_type_dropdown;
	
	@FindBy(xpath = "//*[@id=\"assignRoleInfo\\\"]/table/tbody/tr[5]/td[2]/span/span/span[2]/span")
	public WebElementFacade lbl_NAE_select;
	
//	@FindBy(xpath = "//*[@id=\"assignRoleInfo\"]/table/tbody/tr[5]/td[2]/span/span/input")
//	public WebElementFacade txt_NAE_select;
	
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'Modify/Add')]")
	public WebElementFacade ddl_order_type_selected;
	
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'Install')]")
	public WebElementFacade ddl_order_type_install_selected;
	
	@FindBy(xpath = "//input[@aria-owns='CoordinatorDropdown_listbox']")
	public WebElementFacade ddl_CCM_select;
	
	@FindBy(xpath = "//*[@id=\"assignRoleInfo\"]/table/tbody/tr[3]/td[2]/span/span/span[2]/span")
	public WebElementFacade lbl_CCM_select;
	
	@FindBy(xpath = "(//span[contains(@unselectable,'on')])[3]")
	public WebElementFacade ddl_order;
	
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'Customer Id')]")
	public WebElementFacade ddl_customer_id;
	
	@FindBy(xpath = "//input[@aria-owns='OESDropdown_listbox']")
	public WebElementFacade ddl_OES_select;
	
	@FindBy(xpath = "//input[@aria-owns='NAEDropdown_listbox']")
	public WebElementFacade ddl_NAE_select;
	
	@FindBy(xpath = "//*[@id=\"assignRoleInfo\"]/table/tbody/tr[4]/td[2]/span/span/span[2]/span")
	public WebElementFacade lbl_OES_select;
	
	@FindBy(xpath = "(//button[contains(.,'Search')])[1]")
	public WebElementFacade btn_search_account;
	
//	@FindBy(xpath = "//span[contains(.,'LEVEL 3 DEMO AND TESTING')]")
	
	@FindBy(xpath = "//*[@id=\"AccountManagementSearchGrid\"]/div[2]/table/tbody/tr")
	public WebElementFacade lnk_select_account;
	
	@FindBy(xpath = "(//button[contains(.,'OK')])[1]")
	public WebElementFacade btn_ok_account;
	
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[2]")
	public WebElementFacade btn_select_office;
	
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[3]")
	public WebElementFacade btn_select_product_type;
	
//	@FindBy(xpath = "//button[@id='SaveNewOrderPackageButton']")
	@FindBy(xpath = "//button[contains(@ng-click,'Create()')]")
	public WebElementFacade btn_save_package;
	
	@FindBy(xpath = "//a[@href='#customerTabContentOrderPackages']")
	public WebElementFacade btn_order_package;
	
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[43]")
	public WebElementFacade ddl_EVC_class;
	
	@FindBy(xpath = "//*[@id=\"orderPackagesGrid\"]/div[2]/table/tbody/tr[1]/td[1]/a")
	public WebElementFacade lnk_account;
	
	@FindBy(xpath = "//a[@id='headerLinkAnchor']")
	public WebElementFacade lnk_account1;
	
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'Order Package Id')]")
	public WebElementFacade ddl_order_id;
	
	@FindBy(xpath = "//button[@id='ShowCreateOrderPackageFormBtn']")
	public WebElementFacade btn_create_new_package;
		
	@FindBy(xpath = "//a[contains(@id,'productPackagesTab')]")
	public WebElementFacade btn_product_packages;
	
	@FindBy(xpath = "//button[@id='addPspBtn']")
	public WebElementFacade btn_add_psp;
	
	@FindBy(xpath = "//input[@id='searchClliCriteriaTextBox']")
	public WebElementFacade tbx_clli_search;
	
	@FindBy(xpath = "//button[@id='location-search-button']")
	public WebElementFacade btn_clli_search;
	
//	@FindBy(xpath = "(//label[@class='k-checkbox-label'])[20]")
//	@FindBy(xpath = "(//*[@id=\"locationSearchGrid\"]/div[2]/table/tbody/tr[6]/td[1]")
	@FindBy(xpath = "//label[@for='SL0002991479']")
	public WebElementFacade cbx_clli_select;
	
//	@FindBy(xpath = "(//label[@class='k-checkbox-label'])[30]")
	@FindBy(xpath = "//*[@id=\"locationSearchGrid\"]/div[2]/table/tbody/tr[14]/td[1]")
	public WebElementFacade cbx_clli_select_1;
	
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[31]")
	public WebElementFacade ddl_network_status;
	
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Off Net')])[7]")
	public WebElementFacade ddl_select_offnet;
	
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[32]")
	public WebElementFacade ddl_port_bandwidth;
	
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[33]")
	public WebElementFacade ddl_bandwidth;
		
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'10 Mbps')])[3]")
	public WebElementFacade ddl_select_bandwidth_10mbps;
	
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'1 Gbps')])[25]")
	public WebElementFacade ddl_select_bandwidth_1gbps;
	
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[34]")
	public WebElementFacade ddl_uni_type;
	
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Transparent')])[22]")
	public WebElementFacade ddl_select_uni_transparent;
	
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Multiplexed')])[18]")
	public WebElementFacade ddl_select_uni_multiplexed;
	
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[37]")
	public WebElementFacade ddl_BE;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Standard Delivery - To the MPoE (Customer Provided)')])[23]")
//	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Standard Delivery - To the MPoE (Customer Provided)')])[19]")
	public WebElementFacade ddl_select_BE_standard;
	
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'<default> Extended Delivery - To the Customer Suite (Lumen Provided)')])[19]")
	public WebElementFacade ddl_select_BE;
	
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Next')])[1]")
	public WebElementFacade btn_next_2;	
	
	@FindBy(xpath = "(//button[@ng-disabled='!CanDoNext'])[1]")
	public WebElementFacade btn_next;
	
	@FindBy(xpath = "//button[contains(.,'New Product Package')]")
	public WebElementFacade btn_new_product_package;
	
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade ddl_select_product;
	
	@FindBy(xpath = "//*[@id=\"productsDropDownList\"]")
	public WebElementFacade product_dropdown_list;
	
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'E-Line - EVC')]")
	public WebElementFacade ddl_evc_selected;
	
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[4]")
	public WebElementFacade ddl_select_address;
	
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[5]")
	public WebElementFacade ddl_select_address2;
	
	@FindBy(xpath = "(//i[@class='fa fa-pencil'])[3]")
	public WebElementFacade lnk_pencil1;
	
	@FindBy(xpath = "//input[@id='ambiguousSearchableInput']")
	public WebElementFacade tbx_search_uni_1;
	
	@FindBy(xpath = "//button[@id='relationshipSearchSearchButton']")
	public WebElementFacade btn_search_uni1;

	@FindBy(xpath = "(//a[@class='k-icon k-i-expand'])[5]")
	public WebElementFacade btn_expand_1;
	
	@FindBy(xpath = "//td[@role='gridcell'][contains(.,'Yes')]")
	public WebElementFacade lnk_select_uni;
	
	@FindBy(xpath = "//button[@id='relationshipSaveBtn']")
	public WebElementFacade btn_relationship_save;
	
	@FindBy(xpath = "(//i[contains(@class,'fa fa-pencil')])[4]")
	public WebElementFacade lnk_pencil2;	
	
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'UNI')])[1]")
	public WebElementFacade ddl_uni_selected;
	
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Dedicated Internet Access')])[1]")
	public WebElementFacade ddl_dia_selected;
	
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'UNI')])[2]")
	public WebElementFacade ddl_uni_selected2;
	
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Next')])[3]")
	public WebElementFacade btn_next_second;
	
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Save')])[1]")
	public WebElementFacade btn_save;
	
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Save')])[1]")
	public WebElementFacade btn_save_vrf;
	
	@FindBy(xpath = "//span[@ng-show='DocumentCount != 0']")
	public WebElementFacade lnk_docs;
	
	@FindBy(xpath = "//div[@class='leftNavSectionItem'][contains(.,'Docs (0)')]")
	public WebElementFacade lnk_docs1;
	
	// for having 1 doc.
	@FindBy(xpath = "//div[@class='leftNavSectionItem'][contains(.,'Docs (1)')]")
	public WebElementFacade lnk_docs1_one;
	
	@FindBy(xpath = "//td[contains(.,'SOF.pdf')]")
	public WebElementFacade lnk_sof;
	
	@FindBy(xpath = "//button[@id='deleteDocBtn']")
	public WebElementFacade btn_delete_sof;
	
	@FindBy(xpath = "//input[@id='fileUploadInput']")
	public WebElementFacade btn_attach_doc;
	
	@FindBy(xpath = "(//div[contains(@deselectable,'on')])[6]")
	public WebElementFacade ddl_doc_type;
	
	@FindBy(xpath = "//button[@ng-click='UpdateDocument(this)']")
	public WebElementFacade btn_save_doc;
	
	@FindBy(xpath = "(//a[@aria-label='Close'])[4]")
	public WebElementFacade lnk_close_window;
	
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'iSE Design')]")
	public WebElementFacade ddl_doc_ise;
	
//	@FindBy(xpath = "//span[@class='boldfont requiredDocType'][contains(.,'Service Order Form')]")
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Service Order Form')])[2]")
	public WebElementFacade ddl_doc_sof;
	
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'iSE Design')])[1]")
	public WebElementFacade ddl_doc_ise_Design;
	
	
	@FindBy(xpath = "//button[contains(.,'New Product Package')]")
	public WebElementFacade btn_new_package;
	
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade ddl_new_package;
	
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'VRF ID')]")
	public WebElementFacade lnk_VRF_ID;
	
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[4]")
	public WebElementFacade ddl_vrf_address;
	
	@FindBy(xpath = "(//input[@ng-model='attribute.AttributeValue'])[1]")
	public WebElementFacade tbx_network_name;
	
	@FindBy(xpath = "//button[@id='editDatesBtn']")
	public WebElementFacade btn_edit_dates;
	
	@FindBy(xpath = "//input[@id='NewNddDatePicker']")
	public WebElementFacade tbx_negotiated_date;
	
	@FindBy(xpath = "//input[@id='CurrentCrdDatePicker']")
	public WebElementFacade tbx_requested_date;
	
	@FindBy(xpath = "//button[@id='EditDateDialogOkBtn']")
	public WebElementFacade btn_save_dates;
	
	@FindBy(xpath = "//div[@class='k-grid-content k-auto-scrollable table-responsive']/table/tbody/tr[1]/td[4]")
	public WebElementFacade btn_first_product;
	
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable table-responsive']/table/tbody/tr[2]//div[2]//tr[1])[2]")
	public WebElementFacade btn_first_sub_product_vrf;
	
	@FindBy(xpath = "(//div[@class='productGridDetail k-grid k-widget k-display-block']/table/tbody/tr[@class='k-master-row'])[1]")
	public WebElementFacade btn_first_sub_product;
	
	@FindBy(xpath = "//h4[@class='panelsub-title collapsed'][contains(.,'Addresses')]")
	public WebElementFacade btn_addresses;
	
	@FindBy(xpath = "//h4[@class='panelsub-title collapsed'][contains(.,'Products : E-Access - OVC')]")
	public WebElementFacade btn_product_ovc;
	
	@FindBy(xpath = "//h4[@class='panelsub-title collapsed'][contains(.,'Products : Wholesale UNI')]")
	public WebElementFacade btn_product_uni;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-edit'])[1]")
	public WebElementFacade btn_first_address_edit_transparent;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-edit'])[2]")
	public WebElementFacade btn_second_address2_edit;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[136]")
	public WebElementFacade btn_end_user_CLLI1_transparent;
	
	public WebElementFacade aendcllitransparent(String a_end_clli_transparent) {
		WebElementFacade aendcllitransparent = findBy("//li[@tabindex='-1'][contains(.,'"+a_end_clli_transparent+"')]");
		return aendcllitransparent;
	}
	
	public WebElementFacade zendcllitransparent(String z_end_clli_transparent) {
		WebElementFacade zendcllitransparent = findBy("//li[@tabindex='-1'][contains(.,'"+z_end_clli_transparent+"')]");
		return zendcllitransparent;
	}
	
	
	public WebElementFacade aendclli(String a_end_clli) {
		WebElementFacade aendclli = findBy("//li[@tabindex='-1'][contains(.,'"+a_end_clli+"')]");
		return aendclli;
	}
	
	public WebElementFacade zendclli(String z_end_clli) {
		WebElementFacade zendclli = findBy("//li[@tabindex='-1'][contains(.,'"+z_end_clli+"')]");
		return zendclli;
	}
	
	
	@FindBy(xpath = "//i[@class='glyphicon glyphicon-edit']")
	public WebElementFacade btn_uni_address_edit;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[112]")
	public WebElementFacade btn_end_user_CLLI;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[114]")
	public WebElementFacade btn_end_user_CLLI_eline_uni1;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[110]")
	public WebElementFacade btn_end_user_CLLI_uni2;
	
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'MMPHTNBGS08')]")
	public WebElementFacade lnk_end_user_CLLI_select_MMPHTNBGS08;
	
	//@FindBy(xpath= "//select[contains(@id,'endUserClliDropDown')]/option[contains (@value,'SL0000031877')]")
	@FindBy(xpath = "(//li[contains(@data-offset-index,'38')])[322]")
	public WebElementFacade btn_end_user_CLLI_DNVTCO56S00;
	
	//@FindBy(xpath= "//select[contains(@id,'endUserClliDropDown')]/option[contains (@value,'SL0000425147')]")
	@FindBy(xpath = "(//li[@data-offset-index='4'])[27]")
	public WebElementFacade btn_end_user_CLLI_CLEYOHIGS00;
	
	
	//span[@aria-owns='endUserClliDropDown_listbox']/select/option[@value='SL0000514362']
	
	//span[@aria-owns='endUserClliDropDown_listbox']/select
	
	
	@FindBy(xpath = "//button[contains(.,'Update Service Address')]")
	public WebElementFacade btn_end_user_CLLI_update;
	
	@FindBy(xpath = "//button[@ng-click='PullRelatedPsps()'][contains(.,'Save')]")
	public WebElementFacade btn_end_user_CLLI_update_save;
	
	@FindBy(xpath = "//button[contains(@ng-click,'SaveOrderPackageClick()')]")
	public WebElementFacade btn_top_save;
	
	@FindBy(xpath = "//div[@class='k-grid-content k-auto-scrollable table-responsive']/table/tbody/tr[3]")
	public WebElementFacade btn_second_product;
		
	@FindBy(xpath = "//div[@class='k-grid-content k-auto-scrollable table-responsive']/table/tbody/tr[2]")
	public WebElementFacade btn_second_product_ipvpn_logical;
	
	@FindBy(xpath = "(//div[@class='productGridDetail k-grid k-widget k-display-block']/table/tbody/tr[@class='k-master-row'])[2]")
	public WebElementFacade btn_second_sub_product;
	
	@FindBy(xpath = "(//div[@class='productGridDetail k-grid k-widget k-display-block']/table/tbody/tr[@class='k-master-row'])[1]")
	public WebElementFacade btn_second_sub_product_ipvpn_logical;
		
	@FindBy(xpath = "//i[@class='glyphicon glyphicon-edit']")
	public WebElementFacade btn_second_address1_edit;
	
	@FindBy(xpath = "//i[@class='glyphicon glyphicon-edit']")
	public WebElementFacade btn_address_edit_elan_evc;
		
	@FindBy(xpath = "//h4[@class='panelsub-title collapsed'][contains(.,'Details')]")
	public WebElementFacade btn_details;
	
	@FindBy(xpath = "(//i[@class='fa fa-pencil'])[2]")
	public WebElementFacade lnk_vrf_id_edit;
	
	@FindBy(xpath = "(//i[@class='fa fa-pencil'])[1]")
	public WebElementFacade lnk_ban_edit;
	
	@FindBy(xpath = "(//button[@id='AccountManagementSearchBtn'])[1]")
	public WebElementFacade lnk_ban_new;
	
	@FindBy(xpath = "(//input[@id='AccountNumberSearchEntry'])[1]")
	public WebElementFacade tbx_ban_new;
	
	@FindBy(xpath = "(//button[contains(.,'Search')])[3]")
	public WebElementFacade btn_ban_search;
	
	@FindBy(xpath = "//span[@ng-bind='dataItem.AccountName']")
	public WebElementFacade lnk_ban_first;
	
	@FindBy(xpath = "(//button[@ng-click='AccountManagementSearchOkClick()'])[1]")
	public WebElementFacade btn_ban_ok;
	
	@FindBy(xpath = "//button[@ng-click='CommitAccountNumber()']")
	public WebElementFacade btn_ban_save;
		
	@FindBy(xpath = "//button[@id='vrfAutoFillCustomerNumber']")
	public WebElementFacade btn_auto_fill;
	
	@FindBy(xpath = "//button[@id='vrfSearchSearchButton']")
	public WebElementFacade btn_search_vrf;
	
	@FindBy(xpath = "//button[@ng-click='CommitVrf()']")
	public WebElementFacade btn_vrf_select_save;
	
	@FindBy(xpath = "//button[@id='editServiceAddressCancelButton']")
	public WebElementFacade btn_cancel;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-edit'])[1]")
	public WebElementFacade btn_second_address1_edit_eline;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-edit'])[2]")
	public WebElementFacade btn_second_address2_edit_eline;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[132]")
	public WebElementFacade btn_end_user_CLLI2_transparent;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-edit'])[2]")
	public WebElementFacade btn_address2_edit;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[106]")
	public WebElementFacade btn_end_user_2CLLI_transparent;
	
	@FindBy(xpath = "//i[@class='glyphicon glyphicon-edit']")
	public WebElementFacade btn_second_address_edit;
	
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[142]")
	public WebElementFacade btn_end_user_2CLLI;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[134]")
	public WebElementFacade btn_end_user_CLLI_eline;
	
	public WebElementFacade aendclli1(String a_end_clli) {
		WebElementFacade aendclli1 = findBy("//li[@tabindex='-1'][contains(.,'"+a_end_clli+"')]");
		return aendclli1;
	}
	
	public WebElementFacade zendclli2(String z_end_clli) {
		WebElementFacade zendclli2 = findBy("//li[@tabindex='-1'][contains(.,'"+z_end_clli+"')]");
		return zendclli2;
	}
	
	public WebElementFacade aendclli_gvpn(String a_end_clli) {
		WebElementFacade aendclli_gvpn = findBy("//li[@tabindex='-1'][contains(.,'"+a_end_clli+"')]");
		return aendclli_gvpn;
	}
	
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'BNGHNYBCS00')]")
	public WebElementFacade lnk_end_user_2CLLI_select_BNGHNYBCS00;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[142]")
	public WebElementFacade btn_end_user_2CLLI2;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[106]")
	public WebElementFacade btn_ovc_end_user_CLLI2_eaccess;
	
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[124]")
	public WebElementFacade btn_ovc_end_user_CLLI1;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[95]")
	public WebElementFacade btn_end_user_CLLI_elan_evc;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[96]")
	public WebElementFacade btn_end_user_CLLI_elan_evc_endpoint;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[112]")
	public WebElementFacade btn_end_user_CLLI_elan_evc_UNI;
	
	
	@FindBy(xpath = "//span[@aria-owns='endUserClliDropDown_listbox']/span/span[1]")
	public WebElementFacade ddl_end_user_CLLI_update;
	
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'LABBRMCOS00')]")
	public WebElementFacade lnk_ovc_end_user_CLLI1_select_LABBRMCOS00;
	
	
	public WebElementFacade aendcllieaccess(String a_end_clli_eaccess) {
		WebElementFacade aendcllieaccess = findBy("//li[@tabindex='-1'][contains(.,'"+a_end_clli_eaccess+"')]");
		return aendcllieaccess;
	}
	
	
	public WebElementFacade aendcllielan(String a_end_clli_elan) {
		WebElementFacade aendcllielan = findBy("//li[@tabindex='-1'][contains(.,'"+a_end_clli_elan+"')]");
		return aendcllielan;
	}
	
	public WebElementFacade bendcllielan(String b_end_clli_elan) {
		WebElementFacade bendcllielan = findBy("//li[@tabindex='-1'][contains(.,'"+b_end_clli_elan+"')]");
		return bendcllielan;
	}
	
	public WebElementFacade cendcllielan(String c_end_clli_elan) {
		WebElementFacade cendcllielan = findBy("//li[@tabindex='-1'][contains(.,'"+c_end_clli_elan+"')]");
		return cendcllielan;
	}
		
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'CLEYOHIGS00')]")
	public WebElementFacade lnk_ovc_end_user_CLLI1_select_cleyohig;
		
	
	@FindBy(xpath = "//div[@class='k-grid-content k-auto-scrollable table-responsive']/table/tbody/tr[4]")
	public WebElementFacade btn_third_product;
	
	@FindBy(xpath = "(//div[@class='productGridDetail k-grid k-widget k-display-block']/table/tbody/tr[@class='k-master-row'])[2]")
	public WebElementFacade btn_third_sub_product;
	
	@FindBy(xpath = "//i[@class='glyphicon glyphicon-edit']")
	public WebElementFacade btn_third_address_edit;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[110]")
	public WebElementFacade btn_end_user_eline_uni2;
	
	
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[2])[1]")
	public WebElementFacade btn_order_package_first;
	
	
	@FindBy(xpath = "//a[contains(@id,'orderDetailsTab')]")
	public WebElementFacade btn_order_details;
	
	//@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[7]")
	//@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[6]")
	@FindBy(xpath = "//input[@aria-owns='OESDropdown_listbox']")
	public WebElementFacade ddl_OES;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[9]")
	public WebElementFacade ddl_VSC;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[12]")
	public WebElementFacade ddl_TDE;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[14]")
	public WebElementFacade ddl_Director;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[15]")
	public WebElementFacade ddl_Manager;
	
	//@FindBy(xpath = "//button[@id='validateTask']")
	@FindBy(xpath = "//button[contains(@ng-click,'ValidateTaskClick()')]")
	public WebElementFacade btn_validate;
	
	
	@FindBy(xpath = "//button[@id='completeTask']")
	public WebElementFacade btn_complete;
	
	
	@FindBy(xpath = "//div[@id='taskGrid']/div[3]/table/tbody/tr[2]")
	public WebElementFacade lnk_order_package_1st_task;
	
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[4])[1]")
	public WebElementFacade lnk_order_package_ready1;
	
	@FindBy(xpath = "//a[contains(@id,'searchBtn')]")
	public WebElementFacade btn_OrderId_Search_Button;
	
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[5])[1]")
	public WebElementFacade lnk_order_package_ready4th;
	
	@FindBy(xpath = "//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[3]")
	public WebElementFacade lnk_order_package_second;
	
	@FindBy(xpath = "//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[5]")
	public WebElementFacade lnk_order_package_fourth;
	
	@FindBy(xpath = "//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[4]")
	public WebElementFacade lnk_order_package_third;
	
	@FindBy(xpath = "//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[6]")
	public WebElementFacade lnk_order_package_fifth;
	
	@FindBy(xpath = "//button[@id='reassignTaskToMe']")
	public WebElementFacade btn_reassign_me;
	
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[3])[1]")
	public WebElementFacade lnk_order_package_ready2;
	
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[5])[1]")
	public WebElementFacade lnk_order_package_ready4;
	
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[4])[1]")
	public WebElementFacade lnk_order_package_ready3;
	
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable'])[1]/table/tbody/tr[2]/td[5]")
	public WebElementFacade btn_order_package_space;
	
	@FindBy(xpath = "//span[@id='headerUserInfo']")
	public WebElementFacade btn_userinfo;
	
	@FindBy(xpath = "(//input[@ng-model='attribute.AttributeValue'])[1]")
	public WebElementFacade tbx_ins_id_1;
	
	@FindBy(xpath = "(//input[@ng-model='attribute.AttributeValue'])[2]")
	public WebElementFacade tbx_ins_id_2;
	
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[32]")
	public WebElementFacade ddl_evc;
	
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[33]")
	public WebElementFacade ddl_select_bandwidth;
	
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[34]")
	public WebElementFacade ddl_select_class;
	
	@FindBy(xpath = "//input[@aria-owns='impersonateUserId_listbox']")
	public WebElementFacade tbx_impersonate_to_user;
	
	@FindBy(xpath = "//button[@id='impersonateUserBtn']")
	public WebElementFacade btn_impersonate;
	
	@FindBy(xpath = "//div[@id='taskGrid']/div[3]/table/tbody/tr[1]/td/p/a")
	public WebElementFacade btn_collapse;
	
	@FindBy(xpath = "//label[contains(@for,'cbHeader')]")
	public WebElementFacade cbx_collapse_checkbox;
	
	@FindBy(xpath = "//a[@href='#contacts']")
	public WebElementFacade btn_contacts;
	
	@FindBy(xpath = "//input[@class='contact-form-elements contact-name-text-box k-input']")
	public WebElementFacade tbx_add_contact;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[1]")
	public WebElementFacade tbx_contact_role;
	
	@FindBy(xpath = "(//input[@type='checkbox'][contains(@id,'CON')])[1]")
	public WebElementFacade cbx_contact_role_select;
	
	@FindBy(xpath = "(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[2]")
	public WebElementFacade tbx_contact_section;
	
	@FindBy(xpath = "//input[@id='OrderPackage']")
	public WebElementFacade cbx_contact_section_1;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[50]")
	public WebElementFacade cbx_contact_section_2;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[51]")
	public WebElementFacade cbx_contact_section_3;
	
	
	@FindBy(xpath = "//div[@id='taskGrid']/div[3]/table/tbody/tr[2]/td[4]/span")
	public WebElementFacade lbl_ready;
	
	@FindBy(xpath = "//button[@id='GetPspsButton']")
	public WebElementFacade btn_getpsp;
	
	@FindBy(xpath = "//input[@id='pspIdInventorySearchTxt']")
	public WebElementFacade tbx_psp_id;
	
	@FindBy(xpath = "//span[@ng-bind='dataItem.ProductPackageId']")
	public WebElementFacade btn_psp_id_row;
	
	@FindBy(xpath = "//button[@id='modifyBtn']")
	public WebElementFacade btn_modify;
	
	@FindBy(xpath = "//button[@id='modifyDisconnectOkBtn']")
	public WebElementFacade btn_modify_ok;
	
	@FindBy(xpath = "(//button[@ng-click='OkBtnClicked()'])[3]")
	public WebElementFacade btn_modify_ok_ok;
	
	@FindBy(xpath = "//label[@for='existingOPRadio']")
	public WebElementFacade rbn_modify_existing_package;
	
	@FindBy(xpath = "//span[contains(.,'551531805')]")
	public WebElementFacade lnk_modify_order_package_select;
	
	@FindBy(xpath = "(//span[@class='k-input ng-scope'])[2]")
	public WebElementFacade ddl_order_type;
	
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'Modify/Add')]")
	public WebElementFacade ddl_order_type_select;
	
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[6]")
	public WebElementFacade ddl_CCM;
	
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-edit']")
	public WebElementFacade btn_attributes_edit;
	
	@FindBy(xpath = "//span[@class='k-input ng-scope' and contains(text(),'bps')]")
	public WebElementFacade ddl_bandwidth_edit;
	
	@FindBy(xpath = "(//span[@class='k-input ng-scope' and contains(text(),'bps')])[2]")
	public WebElementFacade ddl_bandwidth_edit_ovc;
	
	
	
			
	@Override
	public WebElementFacade getUniqueElementInPage() {
	return btn_search;
	}

}

	

