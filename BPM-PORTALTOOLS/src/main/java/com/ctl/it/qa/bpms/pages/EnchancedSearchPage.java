package com.ctl.it.qa.bpms.pages;

import com.ctl.it.qa.bpms.pages.common.CommonObjectsPage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class EnchancedSearchPage extends CommonObjectsPage {

	// public String currentOrderID;

	@FindBy(id = "ctl00_mainContent_solrTaskSearch_rpnlSearchCriteria_i0_txtTaskGlobalSearch")
	public WebElementFacade sel_SearchOnId_EnchancedSearchPage;

	@FindBy(id = "ctl00_mainContent_solrTaskSearch_rpnlSearchCriteria_i0_txtTaskGlobalSearch")
	public WebElementFacade tbx_SearchID_EnchancedSearchPage;

	@FindBy(id = "ctl00_mainContent_solrTaskSearch_rpnlSearchCriteria_i0_btnTaskGlobalSearch")
	public WebElementFacade btn_TaskSearch_GoBar;

	@FindBy(xpath = "//*[@id=\"ctl00_navigationList\"]//a[contains(text(),'Enhanced Search')]")
	public WebElementFacade nav_EnchancedSearch;

	@FindBy(xpath = "//*[@id=\"ctl00_mainContent_RadTabStrip1\"]/div/ul/li[2]/a/span/span/span[contains(text(),'Search')]")
	public WebElementFacade tab_Search_EnchancedSearchPage;

	@FindBy(xpath = "//*[@id='ctl00_mainContent_solrTaskSearch_pnlTaskSearchResults_i0_solrTaskSearch_grdTaskSearch_ctl00_ctl04_lblAEndcode']")
	public WebElementFacade AEndCountryCode;

	@FindBy(xpath = "//*[@id='ctl00_mainContent_solrTaskSearch_pnlTaskSearchResults_i0_solrTaskSearch_grdTaskSearch_ctl00_ctl04_lblZEndcode']")
	public WebElementFacade ZEndCountryCode;

	public void navigateTo_EnchanceSearchPage() {
		sync(this, nav_EnchancedSearch);

		nav_TaskReporting.click();
		System.out.println("Navigating to Enchanced Search Page...     --Successful");

		System.out.println("*****************************");
		System.out.println("*    Enchanced Search Page    *");
		System.out.println("*****************************");

		WaitForPageToLoad(120);
	}

	public void navigateTo_SearchTabinEnchanced() {
		sync(this, tab_Search_EnchancedSearchPage);

		tab_Search_EnchancedSearchPage.click();
		System.out.println("Navigating to Search Tab...     --Successful");

		WaitForPageToLoad(60);
	}

	public void validateCountryCodeinTaskSearch() {

		String actualsAEndCountrycode = AEndCountryCode.getText();
		String actualZendCountrycode = ZEndCountryCode.getText();

		System.out.println("Current A End country code is " + actualsAEndCountrycode);
		System.out.println("Current Z End country code is " + actualZendCountrycode);

		if (actualsAEndCountrycode.equals("AR") || (actualZendCountrycode.equals("AR"))) {
			System.out.println("Validation of A End and Z End country code is ...     --Successful");
		}
	}

}
