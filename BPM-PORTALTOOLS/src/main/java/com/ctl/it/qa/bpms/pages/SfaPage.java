package com.ctl.it.qa.bpms.pages;

import java.util.List;
import com.ctl.it.qa.staf.*;
import java.util.concurrent.TimeUnit;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.Pages;

import org.openqa.selenium.By;

public abstract class SfaPage extends Page{

	@FindBy(xpath = "//input[@id = 'phSearchButton']")
	public WebElementFacade btn_search;

	@FindBy(xpath = "//input[@title='Continue']")
	public WebElementFacade btn_continue;

	@FindBy(id = "userNav-arrow")
	public WebElementFacade lnk_user_name_old;

	@FindBy(xpath = "//b[@class = 'zen-selectArrow']")
	public WebElementFacade lnk_user_name_new;

	@FindBy(css = "a[title='Logout']")
	public WebElementFacade lnk_logout;

	@FindBy(xpath = "//a[@id='helpBubbleCloseX']/img")
	public WebElementFacade img_close;

	@FindBy(css = "table[class = 'list']")
	public WebElementFacade tbl_search_result;

	@FindBy(css = "input[value*='New Service Location']")
	public WebElementFacade btn_new_service_location;

	@FindBy(name = "new")
	public WebElementFacade btn_new;

	@FindBy(css = "input[value='Save and Return']")
	public WebElementFacade btn_save_return;

	@FindBy(css = "input[value*= 'Save']")
	public WebElementFacade btn_save;

	@FindBy(css = "input[value = 'Next']")
	public WebElementFacade btn_next;

	@FindBy(css = "input[value *= 'Edit']")
	public WebElementFacade btn_edit;

	@FindBy(css = "input[value = 'Cancel']")
	public WebElementFacade btn_cancel;

	@FindBy(css = "input[value = 'Order Summary']")
	public WebElementFacade btn_order_summary;
	
	@FindBy(css = "input[value = 'General Information']")
	public WebElementFacade btn_general_information;
	
	@FindBy(css = "input[value = 'Product Details']")
	public WebElementFacade btn_product_details;

	@FindBy(xpath = "//li[@id='home_Tab']/a")
	public WebElementFacade lnk_home;

	@FindBy(xpath = "//span[contains(@class,'globalHeaderProfile')]/..")
	public WebElementFacade lbl_logged_in_user;

	@FindBy(css = "input[value='Submit to Order Processing']")
	public WebElementFacade btn_submit_to_order_processing;

	@FindBy(css = "input[value='Accept']")
	public WebElementFacade btn_accept;

	@FindBy(css = "input[value='Return']")
	public WebElementFacade btn_return;

	@FindBy(xpath = ".//img[@title='All Tabs']")
	public WebElementFacade lnk_all_tabs;
	
	@FindBy(id = "tsidButton")
	public WebElementFacade ddl_sales;
	
	@FindBy(xpath = "//a[contains(text(), 'Repair Console')]")
	public WebElementFacade lnk_repair_console;
	
    @FindBy(xpath="//input[@id='phSearchInput']")
    public WebElementFacade tbx_globalSearch;

	public void openTab(String tabName) {
		try {
			lnk_all_tabs.withTimeoutOf(60, TimeUnit.SECONDS).waitUntilVisible();
			lnk_all_tabs.click();
		} catch (Exception ex) {
			
		}
			
		if (tabName.equalsIgnoreCase("Proposal")){
			findBy("(//img[contains(@title,'Proposals')])[3]").click();
		}
		
		else
			
		find(By.cssSelector("img[title = '" + tabName + "']")).click();
		
	}

	public void logout() {
		if (lnk_user_name_old.isPresent() && lnk_user_name_old.isEnabled()) {
			lnk_user_name_old.click();
		} else {
			lnk_user_name_new.click();
		}
		lnk_logout.click();
	}

	public void closePopUps() { // NO_UCD (unused code)
		closeHelpBubble();
	}

	private void closeHelpBubble() {
		if (img_close.isPresent()) {
			img_close.click();
		}
	}

	public void waitForResultTableToLoad() {
		tbl_search_result.isPresent();
		tbl_search_result.waitUntilPresent();
	}

	public void navigateToHomePage() {
		lnk_home.isPresent();
		lnk_home.click();
	}

	public void switchtoFrame(String frame) {
		getDriver().switchTo().window(getDriver().getWindowHandle());
		getDriver().switchTo().frame(frame);
	}

	public void closeBrowser() {
		getDriver().close();
	}

	public void switchToFrame(WebElementFacade element) {
		List<WebElementFacade> lstFrames = findAll(By.tagName("iframe"));
		for(WebElementFacade we : lstFrames) {
			String frame = we.getAttribute("id");
			switchtoFrame(frame);
			if (element.isCurrentlyVisible()) {
				break;
			}
			getDriver().switchTo().defaultContent();
		}
	}


}
	

