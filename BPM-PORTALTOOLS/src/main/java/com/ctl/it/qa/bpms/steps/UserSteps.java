package com.ctl.it.qa.bpms.steps;

import java.util.Map;

import com.ctl.it.qa.bpms.pages.AllTabsPage;
import com.ctl.it.qa.bpms.pages.LoginPage;
import com.ctl.it.qa.bpms.pages.SSOLoginPage;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.thucydides.core.annotations.Step;

@SuppressWarnings("serial")
public class UserSteps extends SfaSteps {

	LoginPage loginPage;
	AllTabsPage allTabsPage;
	SSOLoginPage ssoLoginPage;

	@Step
	public void try_logging_in_as(String userType) {
		shouldExist(loginPage);
		loginPage.enterCredentials(userType);
		loginPage.btn_log_in_to_salesforce.click();
	}

	@Step
	public void logs_in_as(String userType) {
		shouldExist(loginPage);
		loginPage.enterCredentials(userType);
		loginPage.btn_log_in_to_salesforce.click();
		WaitForPageToLoad(200);

	}

	@Step
	public void logs_in_as_with_different_accountoption(String userType) {
		loginPage.btn_log_in_with_different_account.click();
		shouldExist(loginPage);
		loginPage.enterCredentials(userType);
		loginPage.btn_log_in_to_salesforce.click();
		WaitForPageToLoad(200);

	}

	@Step
	public void is_in_sfa_login_page(String url) {
		loginPage.openAt(url);
		loginPage.maximize();
	}

	@Step
	public void is_in_sso_login_page(String url) {
		/*loginPage.getDriver().navigate().to("https://www.google.com");
		try {
			loginPage.getDriver().switchTo().alert().accept();
		} catch (NoAlertPresentException ex) {

		}*/
		WaitForPageToLoad(20000);
		//*Sohaib* waitABit(2000);
		loginPage.openAt(url);
		loginPage.maximize();
		WaitForPageToLoad(20000);
		//loginPage.btn_centurylink_sso.click();
	}
	
	@Step
	public void is_in_swift_login_page(String url) {
		WaitForPageToLoad(20000);
		loginPage.openAt(url);
		loginPage.maximize();
		WaitForPageToLoad(50000);
		//loginPage.btn_centurylink_sso.click();
	}
	
	@Step
	public void is_in_direct_sso_login_page(String url) {
		/*loginPage.getDriver().navigate().to("https://www.google.com");
		try {
			loginPage.getDriver().switchTo().alert().accept();
		} catch (NoAlertPresentException ex) {

		}*/
		WaitForPageToLoad(20000);
		//*Sohaib* waitABit(2000);
		loginPage.openAt(url);
		loginPage.maximize();
		WaitForPageToLoad(20000);
		//loginPage.btn_centurylink_sso.click();
	}

	@Step
	public void logs_in_sso_as(String userType) {
		shouldExist(ssoLoginPage);
		ssoLoginPage.enterCredentials(userType);
		ssoLoginPage.btn_login.click();
		WaitForPageToLoad(20000);
	}

		
	public void logs_in_using_name(String userName) {
		shouldExist(loginPage);
		IntDataContainer userDetails = null;
		Map<String, IntDataContainer> users = get_data_for_page(loginPage).getContainers();
		for (Map.Entry<String, IntDataContainer> user : users.entrySet()) {
			userDetails = user.getValue();
			if ((userDetails.getFieldValue("first_name") + " " + userDetails.getFieldValue("last_name"))
					.equalsIgnoreCase(userName)) {
				logs_in_as(user.getKey());
				break;
			}
		}
	}

	public String getUserName(String userType) {
		String firstName = envData.getContainer("LoginPage").getContainer(userType).getFieldValue("first_name");
		String lastName = envData.getContainer("LoginPage").getContainer(userType).getFieldValue("last_name");
		return firstName + " " + lastName;
	}

	
}
