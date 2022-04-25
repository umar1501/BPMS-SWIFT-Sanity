package com.ctl.it.qa.bpms.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SfaContractPage extends SfaPage {
	
	@FindBy(xpath = "//input[@id='NextTopButton']")
	public WebElementFacade btn_next_top;
	
	@FindBy(xpath = "//input[@id='NextButton']")
	public WebElementFacade btn_next_bottom;
	
	@FindBy(xpath = "//input[@id='PreviousTopButton']")
	public WebElementFacade btn_previous_top;
	
	@FindBy(xpath = "//input[@id='PreviousButton']")
	public WebElementFacade btn_previous_bottom;
	
	@FindBy(xpath = "//span[@id = 'BreadCrumbTrailUC_lblCurrentStep']")
	public WebElementFacade lbl_done;
	
	@FindBy(xpath = "//select[@id = 'ctl00_AgreementTypeDropDownList']")
	public WebElementFacade ddl_agreement_type;
	
	@FindBy(xpath = "(//td[@class='qc-tableField']/following::input[1])[1]")
	public WebElementFacade cbx_atm_service;
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_next_top;
	}

}
