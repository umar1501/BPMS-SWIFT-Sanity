package com.ctl.it.qa.bpms.pages;

import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SSOLoginPage extends SfaPage {

	public static IntDataContainer dataContainer;

	@FindBy(xpath = "//input[@name='username']")
	public WebElementFacade tbx_user_name;

	@FindBy(xpath = "//input[@name='password']")
	public WebElementFacade tbx_password;

	@FindBy(xpath = "//input[@value='LOGIN']")
	public WebElementFacade btn_login;

	public SSOLoginPage() {
		initialize();
	}

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_login;
	}

	public void enterCredentials(String userType) {
		IntDataContainer dataContainer = envData.getContainer(
				this.getClass().getSimpleName()).getContainer(userType);
		tbx_user_name.type(dataContainer.getFieldValue("tbx_user_name"));
		tbx_password.type(dataContainer.getFieldValue("tbx_password"));
	}
}
