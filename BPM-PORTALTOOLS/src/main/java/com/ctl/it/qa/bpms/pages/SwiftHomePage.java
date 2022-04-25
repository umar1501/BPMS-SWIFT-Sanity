package com.ctl.it.qa.bpms.pages;

import java.util.List;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SwiftHomePage extends Page{
	
	@FindBy(xpath = "//span[@id='headerUserInfo']//span[2]")
	public WebElementFacade img_user_icon;
	
	@FindBy(xpath = "//input[@class='k-input']")
	public WebElementFacade tbx_imp_user;
	
	@FindBy(xpath = "//button[@id='impersonateUserBtn']")
	public WebElementFacade btn_imp_user;
	
    //@FindBy(xpath = "//span[@id='headerUserInfo']//following::span[@ng-show='IsImpersonated'][1]")
	@FindBy(css = "span#headerUserInfo")
	public WebElementFacade lbl_imp_user;
	
	
	
	@FindBy(xpath = "//span[@unselectable='on'][@class='k-select'][@aria-controls='impersonateUserId_listbox']//span[@class='k-icon k-i-arrow-60-down']")
	public WebElementFacade ddl_imp_user;

	@FindBy(css = "div#searchWrapper span.k-dropdown")
	public WebElementFacade ddl_search_op;
	
	@FindBy(css = "ul[aria-hidden='false'] li[role='option']")
	public List<WebElementFacade> lbl_search_list;
	
	@FindBy(xpath ="//label[@for='searchRadioOrders']")
	public WebElementFacade rbn_search_op;
	
	@FindBy(xpath ="//input[@id='searchId']")
	public WebElementFacade tbx_search_op;
	
	@FindBy(xpath ="//a[@id='searchBtn']")
	public WebElementFacade btn_seach_op;
	
	@FindBy(xpath ="//div[@class='k-link']//following::span[@class='ng-binding'][1]")
	public WebElementFacade lbl_display_op;
	
	@FindBy(xpath ="//div[@class='k-link']//following::span[@class='ng-binding'][2]")
	public WebElementFacade lbl_display_boid;
	
	@FindBy(xpath ="//*[@id='pageMetaData']/div[2]/span[1]")
	public WebElementFacade swift_orderId;
	
	//Click on Customer dropdown 
	@FindBy(css ="li#customerTab")
	public WebElementFacade lbl_customer;
	
	//Click on SUNSAY UAT customer.
	@FindBy(css = "li#customerTab ul[aria-hidden='false'] li")
	public List<WebElementFacade> lbl_Cust_List;
	
	@FindBy(xpath = "//a[contains(@id,'headerLinkAnchor')]")
	public WebElementFacade lbl_Cust_Name;
	
	
	
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return img_user_icon;
	}

}

