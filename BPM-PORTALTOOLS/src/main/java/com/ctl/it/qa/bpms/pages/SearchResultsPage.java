package com.ctl.it.qa.bpms.pages;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchResultsPage extends SfaPage {

	@FindBy(xpath= "//input[@id = 'secondSearchText']")
	public WebElementFacade tbx_search;

	@FindBy(xpath= "//input[@id = 'secondSearchButton']")
	public WebElementFacade btn_search_again;

	@FindBy(xpath = "//tr[th[a[contains(text(), 'Opportunity Name')]]]/following-sibling::tr[1]/th/a")
	public WebElementFacade lnk_serachedOpportunities;

	// for direct search
	@FindBy(xpath = "//*[@id='phSearchInput']")
	public WebElementFacade tbx_search_box;
	
	@FindBy(xpath = "//*[@id='phSearchButton']")
	public WebElementFacade btn_search_order;
	//

	@FindBy(xpath = "//*[@id='Task__c_body']/table/tbody/tr[2]/td[1]/a")
	public WebElementFacade btn_edit;
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return tbx_search;
	}

	private By getResultXPath(String objectName, String searchValue) {

		if (objectName.equals("Order Requests")||objectName.equals("Opportunities")) {
			return By.xpath("//td[text()='" + searchValue
					+ "']/preceding-sibling::th/a");
		} else {
			return By
					.xpath("//table[@summary = '"
							+ objectName
							+ "']/parent::div/following-sibling::div[1]/..//*[text() = '"
							+ searchValue + "']");
		}
	}

	private void selectObject(String objectName) {
		WebElementFacade element=find(By.xpath("//span[. = '" + objectName + "']"));
		withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable(element));
		element.click();
		//find(By.xpath("//span[. = '" + objectName + "']")).click();
		shouldExist(this);
	}

	public void searchObject(String objectName, String searchValue) {
		selectObject(objectName);
		withTimeoutOf(60, TimeUnit.SECONDS).waitFor(tbx_search).type(searchValue);
		withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable(btn_search_again));
		btn_search_again.click();
	}

	private boolean isResultFound(String objectName, String searchValue) {
		boolean isFound = false;
		withTimeoutOf(10, TimeUnit.SECONDS).waitForPresenceOf(
				getResultXPath(objectName, searchValue));
		if (find(getResultXPath(objectName, searchValue)).isPresent()) {
			isFound = true;
		}
		return isFound;
	}

	public void selectResult(String objectName, String searchValue) {
		assertThat("No result was found when searched " + objectName
				+ "with value '" + searchValue + "'",
				isResultFound(objectName, searchValue));
		find(getResultXPath(objectName, searchValue)).withTimeoutOf(20, TimeUnit.SECONDS).waitUntilClickable().click();
	}
}
