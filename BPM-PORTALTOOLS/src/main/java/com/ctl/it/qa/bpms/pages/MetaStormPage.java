package com.ctl.it.qa.bpms.pages;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class MetaStormPage extends Page {


	@FindBy(xpath = "//span[@class='rtbText'][contains(.,'Watch List')]")
	public WebElementFacade btn_watch_list;
	
	
	@FindBy(xpath = "(//input[contains(@name,'ProcessList')])[1]")
	public WebElementFacade ddl_process;
	
	@FindBy(xpath = "//li[contains(.,'OP_Welcome_Customer')]")
	public WebElementFacade ddl_process_OP_Welcome;
	
	@FindBy(xpath = "//li[contains(.,'OP Credit Check')]")
	public WebElementFacade ddl_process_OP_CreditCheck;
	
	@FindBy(xpath = "//li[contains(.,'OP Install')]")
	public WebElementFacade ddl_process_OP_Install;
	
	@FindBy(xpath = "(//input[contains(@name,'StageList')])[1]")
	public WebElementFacade ddl_stage;
	
	@FindBy(xpath = "//li[contains(.,'Waiting For Downstream System Job Completion')]")
	public WebElementFacade ddl_Wait_for_downstream;
	
	@FindBy(xpath = "//li[contains(.,'WaitForAutoComplete')]")
	public WebElementFacade ddl_stage_select;
	
	@FindBy(xpath = "//li[contains(.,'Wait For Credit Approval')]")
	public WebElementFacade ddl_stage_CA__select;
	
	@FindBy(xpath = "//a[@title='Click here to sort'][contains(.,'Updated')]")
	public WebElementFacade btn_Update_Click;
	
	@FindBy(xpath = "(//td[contains(.,'Wait For Credit Approval')])[4]")
	public WebElementFacade btn_Credit_Approcal_Buton_Click;
	
	@FindBy(xpath = "//a[@title='Click here to sort'][contains(.,'Folder')]")
	public WebElementFacade btn_folder;
	
	public WebElementFacade metastorm(String sess) {
	System.out.println("Session Variable : "+sess);	

	WebElementFacade metastormelement = findBy("(//td[@class='met-Cell'][contains(.,'"+ sess +"')])[1]");
	System.out.println("Metastorm Element Xpath : "+metastormelement);
	return metastormelement;
	
	}
	
	@FindBy(xpath = "(//td[@class='met-Cell'])[1]")
	public WebElementFacade btn_first_order;
	
	@FindBy(xpath = "//div[@class = 'actionFolderWrapper']/div[3]/div/div/ul/li[9]/a/span")
	public WebElementFacade btn_manual_expire;
	
	@FindBy(xpath = "//input[contains(@id,'btnConfirm')]")
	public WebElementFacade btn_manual_expire_ok;
	
	@FindBy(xpath = "//input[contains(@value,'Yes')]")
	public WebElementFacade btn_CreditCheck_yes_Button;
	
	
	
	//div[@id = 'eSeparator']/span[3] alternate for OK

	@Override
	public WebElementFacade getUniqueElementInPage() {
	return btn_watch_list;
	}

}
