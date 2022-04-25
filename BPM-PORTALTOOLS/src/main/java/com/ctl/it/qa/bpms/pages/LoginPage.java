package com.ctl.it.qa.bpms.pages;


import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends SfaPage {

	@FindBy(id = "username")
	public WebElementFacade tbx_username;

	@FindBy(id = "password")
	public WebElementFacade tbx_password;

	@FindBy(id = "Login")
	public WebElementFacade btn_log_in_to_salesforce;
	
	@FindBy(css = "input[value ='Login']")
	public WebElementFacade btn_log_in_to_partner_portal;

	@FindBy(xpath = "(//span[. = 'CenturyLink OAM SSO'])[1]")
	public WebElementFacade btn_centurylink_sso;
	
	@FindBy(css = "a[id='cancel_idp_hint']")
	//@FindBy(xpath = "//a[text()='Log In with a Different Account']")
	public WebElementFacade btn_log_in_with_different_account;
	
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return tbx_username;
	}

	public void enterCredentials(String userType) {
		IntDataContainer dataContainer = envData.getContainer(
				this.getClass().getSimpleName()).getContainer(userType);
		tbx_username.type(dataContainer.getFieldValue("tbx_username"));
		tbx_password.type(dataContainer.getFieldValue("tbx_password"));
	}
}