package com.ctl.it.qa.bpms.pages;

import java.util.List;

import org.openqa.selenium.support.ui.Select;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SwiftOrderPackagePage extends Page
{

	@FindBy(xpath = "//a[contains(.,'Product Packages')]")
	public WebElementFacade btn_Product_Page;
	
	@FindBy(xpath = "(//button[contains(.,'Add PSP')])[1]")
	public WebElementFacade btn_Add_PSP;
	
	@FindBy(xpath = "//input[contains(@id,'searchClliCriteriaTextBox')]")
	public WebElementFacade tbx_CLLI_ID;
	
	@FindBy(xpath = "//button[@ng-click='SearchLocations()']")
	public WebElementFacade btn_Search;
	
	
	@FindBy(xpath = "//table[@role='grid']//tbody/tr[1]//label[@class='k-checkbox-label']")
	public WebElementFacade cbx_Checkbox;
	
	
	@FindBy(xpath = "(//button[contains(.,'Next')])[4]")
	public WebElementFacade btn_next;
	
	@FindBy(xpath = "//button[contains(.,'New Product Package')]")
	public WebElementFacade btn_Newpodpkg;
	
	@FindBy(xpath = "(//span[contains(.,'- Select -')])[3]")
	public  WebElementFacade lbl_Product;
	
	@FindBy(css = "ul#productsDropDownList_listbox li[aria-selected='false']")
	public List<WebElementFacade> lbl_Diaproductlist;
	
	@FindBy(xpath = "(//span[contains(.,'- Select -')])[4]")
	public  WebElementFacade lbl_address;
	
	@FindBy(css = "ul#address1DropDownList_listbox li[aria-selected='false']")
	public List<WebElementFacade> lbl_AddSelect	;
	
	@FindBy(xpath = "//*[@id=\"productEditor\"]/div[3]/div[2]/table/tbody/tr[5]/td[2]/div/span/span/span[2]/span")
	public WebElementFacade lbl_inside_wiring;
	
    // Click on Circuit_Type Dropdown
	@FindBy(xpath = "//*[@id='productEditor']/div[3]/div[2]/table/tbody/tr[4]/td[2]/div/span/span/span[2]/span" )
    public  WebElementFacade lbl_Circuit_Type;
	
	// Click on Port_Type Dropdown
	@FindBy(xpath = "//*[@id='productEditor']/div[3]/div[2]/table/tbody/tr[7]/td[2]/div/span/span/span[2]/span")
	 public  WebElementFacade lbl_Port_Type;
	
	@FindBy(xpath = "//*[@id='productEditor']/div[3]/div[2]/table/tbody/tr[9]/td[2]/div/span/span/span[2]/span")
	 public  WebElementFacade lbl_RouterPOP;
	
	
	// Click on Next Button in Create New Product Package(s)
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Next')])[1]")
	public  WebElementFacade btn_next1;
	
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Next')])[2]")
	public  WebElementFacade btn_next2;
	
	// Click on Save button
	@FindBy(xpath = "(//button[@type='button'][contains(.,'Save')])[1]")
	public  WebElementFacade btn_Save;
	
	
	
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
