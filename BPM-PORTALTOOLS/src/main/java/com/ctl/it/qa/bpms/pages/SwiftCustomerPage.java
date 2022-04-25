package com.ctl.it.qa.bpms.pages;

import java.util.List;

import org.openqa.selenium.support.ui.Select;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SwiftCustomerPage extends Page{

	//Click on create new order package button ele 
	@FindBy(css = "button#ShowCreateOrderPackageFormBtn")
	public WebElementFacade btn_Create_new_order_package;
	
	//Click on Acount button ele
	@FindBy(xpath = "(//button[contains(@id,'AccountManagementSearchBtn')])[1]")
	public WebElementFacade lbl_Account;
	
	//Click on search button ele
	@FindBy(xpath = "(//button[contains(.,'Search')])[1]")
	public WebElementFacade btn_search;
	
	//Click on Customer ban num.
	@FindBy(xpath = "//*[@id='AccountManagementSearchGrid']/div[2]/table/tbody/tr[2]")
	public WebElementFacade lbl_custAcc;
		
	//Click on ok button ele.
	@FindBy(xpath = "(//button[contains(.,'OK')])[1]")
	public WebElementFacade btn_ok;
	
	//Click on Sales office dropdown list
	@FindBy(xpath = "(//span[contains(@unselectable,'on')])[7]")
	public WebElementFacade ddl_salesoffice;
	
	//Select any sales office from dropdown list.
	@FindBy(css = "ul#SalesOfficeOptionsDropDown_listbox li[aria-selected='false']")
	public List<WebElementFacade> lbl_salesoffice_List;
	
	//Click on product dropdown list
	@FindBy(xpath = "(//span[contains(@unselectable,'on')])[11]")
	public WebElementFacade ddl_product;
	
	//Select any Product from dropdown list
	@FindBy(css = "ul#ProductsOptionDropDown_listbox li[aria-selected='false'] div")
	public List<WebElementFacade> lbl_productlist;
	
	//Click on save new order package button ele.
	@FindBy(xpath = "//button[@id='SaveNewOrderPackageButton']")
	public WebElementFacade btn_saveneworder;
	
	//Click on Order Detail Tab.
	@FindBy(xpath = "//a[contains(.,'Order Details')]")
	public WebElementFacade btn_Order_Detail_Tab;
	
	//Click on Order Type arrow.
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[3]")
	public WebElementFacade ddl_OrderType_arrow;
	
	//Selecting order type from dropdown.
	@FindBy(css = "ul#OrderTypeDropdown_listbox li[aria-selected='false']")
	public List<WebElementFacade> lbl_OrderType_List;
	
	//Click on CCM arrow button.
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[5]")
	public WebElementFacade ddl_CCM_arrow;
	
	//Selecting CCM from CCM dropdown list.
	@FindBy(css = "ul#CoordinatorDropdown_listbox li[aria-selected='false']")
	public List<WebElementFacade> lbl_CCM_List;
	
	//Click on OES arrow.
	@FindBy(xpath = "//span[contains(@aria-controls,'OESDropdown_listbox')]")
	public WebElementFacade ddl_OES_arrow;
	
	//Selecting OES from CCM dropdown list.
	@FindBy(css = "ul#OESDropdown_listbox li[aria-selected='false']")
	public List<WebElementFacade> lbl_OES_List;
	
	//Click on Save Changes button.
	@FindBy(xpath = "(//button[contains(.,'Save Changes')])[1]")
	public WebElementFacade btn_Save_Changes;
	
	//Click on Validate button.
	@FindBy(xpath = "//button[contains(.,'? Validate')]")
	public WebElementFacade btn_Validate;
	
	//Click on OK Button in Validation result alert box.
	@FindBy(xpath = "(//button[contains(.,'OK')])[6]")
	public WebElementFacade btn_Ok_Button;
	
	//Click on Complete Button.
	@FindBy(xpath = "(//button[contains(.,'Complete')])[2]")
	public WebElementFacade btn_Complete;
	
	//Task_POP name
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[2]/td[7]/span[contains(.,'Prepare Order Package')]")
	public WebElementFacade lbl_POP_Task;
	
	//Task Analyze/Adjust PSPs name for Swift initiated.
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[3]/td[7]/span[contains(.,'Analyze/Adjust PSPs')]")
	public WebElementFacade lbl_Ana_Adj_Task;
	
	//Task Analyze/Adjust PSPs name for Swift initiated.
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[2]/td[7]/span[contains(.,'Analyze/Adjust PSPs')]")
	public WebElementFacade lbl_Ana_Adj_Task_SFDC;
	
	//Task Gather Order Details.
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[3]/td[7]/span[contains(.,'Gather Order Details')]")
	public WebElementFacade lbl_GOD_Task_SFDC;
	
	//Task Welcome Customer.
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[5]/td[7]/span[contains(.,'Welcome Customer')]")
	public WebElementFacade lbl_WelCust_Task_SFDC;
	
	//Task Welcome Customer.
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[6]/td[7]/span[contains(.,'Order Validation')]")
	public WebElementFacade lbl_OV_Task_SFDC;
	
	//Task Customer Coordination.
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[4]/td[7]/span[contains(.,'Customer Coordination')]")
	public WebElementFacade lbl_CustomerCord_Task_SFDC;
	
	
	//Assigned Name1 for Swift intiated order.
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[2]/td[5]/span")
	public WebElementFacade lbl_Assigned_name1;
	
	//Assigned Name2 for Swift intiated order.
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[3]/td[5]/span")
	public WebElementFacade lbl_Assigned_name2;
	
	//Assigned Name2 for SFDC intiated order A/A Task.
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[2]/td[5]/span")
	public WebElementFacade lbl_Assigned_name1_SFDC;
	
	//Assigned Name4 for 4th row Task.
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[5]/td[5]/span")
	public WebElementFacade lbl_Assigned_name4;
	
	//Assigned Name4 for 3th row Task.
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[4]/td[5]/span")
	public WebElementFacade lbl_Assigned_name3;
	
	//Assigned Name5 for 5th row Task.
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[6]/td[5]/span")
	public WebElementFacade lbl_Assigned_name5;
		
	
	//@FindBy(xpath = "//span[@id='headerUserInfo']//following::span[@ng-show='IsImpersonated'][1]")
	//public WebElementFacade lbl_imp_user;
	
	//POP Task Row
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[2]")
	public WebElementFacade lbl_POP_Row;
	
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[3]")
	public WebElementFacade lbl_anasy_adst_Row;
	
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[4]")
	public WebElementFacade lbl_Credit_Approval_Row;
	
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[4]")
	public WebElementFacade lbl_Order_val_Row3;
	
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[5]")
	public WebElementFacade lbl_Order_val_Row;
	
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[6]")
	public WebElementFacade lbl_Wait_for_BPMS_Acceptance_Row;
	
	//6th task row
	@FindBy(xpath = "(//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[6])[1]")
	public WebElementFacade lnk_OV_Task_fifth_row;
	
	//6th task row
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[7]")
	public WebElementFacade lbl_sixth_task_Row;
	
	//Contact tab button
	@FindBy(xpath = "//a[contains(@id,'contactsTab')]")
	public WebElementFacade btn_Contacts_Tab;
	
	//Type contact name tab.
	@FindBy(xpath = "(//button[contains(.,'...')])[1]")
	public WebElementFacade btn_Contact_Name_Tab;
	
	//Select contact name in List.
	@FindBy(xpath = "//span[contains(.,'Kim Alberti')]")
	public WebElementFacade lbl_Contact_Name_sel;
	
	//Ok button in contacts tab.
	@FindBy(xpath = "//button[@ng-click='AvailableContactsOKClick()']")
	public WebElementFacade btn_Contacts_Ok;
	
	//Role dropdown in Contats Tab.
	@FindBy(xpath = "(//div[contains(@deselectable,'on')])[2]")
	public WebElementFacade lbl_Role_Tab;
	
	@FindBy(xpath = "(//label[contains(.,'Order Contact')])[3]")
	public WebElementFacade lbl_Order_Contact_Chkbx;
	
	@FindBy(xpath = "(//div[@deselectable='on'])[4]")
	public WebElementFacade lbl_Section_Tab;
	
	@FindBy(xpath = "//*[@id='productSummaryGrid']/div[3]/table/tbody/tr[1]/td[1]/a")
	public WebElementFacade btn_Product_Arrow;
	
	@FindBy(xpath = "//*[@id='productGridDetail443213818']/table/tbody/tr[1]/td[3]")
	public WebElementFacade lbl_Prod_Nm_Row;
	
	@FindBy(xpath = "//button[contains(.,'Set/Edit Dates')]")
	public WebElementFacade btn_Set_Date;
	
	@FindBy(xpath = "//input[contains(@id,'CurrentCrdDatePicker')]")
	public WebElementFacade tbx_Current_date_pick;
	
	@FindBy(xpath = "//button[@ng-click='ValidateDateChanges()'][contains(.,'Save')]")
	public WebElementFacade btn_Valid_Date_Save;
	
	@FindBy(xpath = "//button[contains(.,'Open TDG Form')]")
	public WebElementFacade btn_TDG_Open;
	
	@FindBy(xpath = "//a[@class='btn btn-success'][contains(.,'Edit')]")
	public WebElementFacade btn_Edit_Button;
	
	@FindBy(xpath = "//a[@class='btn btn-success'][contains(.,'Save')]")
	public WebElementFacade btn_TDG_Save;
	
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[last()]/td[4]/span")
	public WebElementFacade lbl_last_task_status;
	
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[last()]/td[7]/span")
	public WebElementFacade lbl_last_task_name;
	
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[last()]/td[5]/span")
	public WebElementFacade lbl_last_task_assigned;
	
	@FindBy(xpath = "//*[@id='taskGrid']/div[3]/table/tbody/tr[last()]")
	public WebElementFacade lbl_last_task_row;

	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
