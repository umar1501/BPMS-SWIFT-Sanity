package com.ctl.it.qa.bpms.steps;

import static org.junit.Assert.assertEquals;

import com.ctl.it.qa.bpms.steps.common.CommonObjectsPageSteps;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ctl.it.qa.bpms.pages.EnchancedSearchPage;
import com.ctl.it.qa.bpms.pages.OrdersPage;
import com.ctl.it.qa.bpms.pages.TaskReportingPage;
import com.ctl.it.qa.bpms.pages.TasksPage;
import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.Steps;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class EnchancedSearchPageSteps extends CommonObjectsPageSteps {

	TaskReportingPage taskReportingPage;
	TasksPage tasksPage;
	OrdersPage ordersPage;
	EnchancedSearchPage enchancedSearchPage;

	@Step
	public void selectSearchOnID(String idToSelect) {
		enchancedSearchPage.sync(enchancedSearchPage, enchancedSearchPage.sel_SearchOnId_EnchancedSearchPage);
		Select select = new Select(enchancedSearchPage.sel_SearchOnId_EnchancedSearchPage);
		select.selectByVisibleText(idToSelect);
	}

	@Step
	public void enterSearchOnID() {
		enchancedSearchPage.sync(enchancedSearchPage, enchancedSearchPage.tbx_SearchID_EnchancedSearchPage);
		enchancedSearchPage.tbx_SearchID_EnchancedSearchPage
				.sendKeys(Serenity.sessionVariableCalled("OrderID").toString());
	}

	@Step
	public void backToEnchancedSearchMainPage() {
		// taskReportingPage.backToEnchancedSearchMainPage();
	}

	@Step
	public void clickOn_TaskSearchGoBtn() {
		enchancedSearchPage.sync(enchancedSearchPage, enchancedSearchPage.btn_TaskSearch_GoBar);
		enchancedSearchPage.btn_TaskSearch_GoBar.click();
		WaitForPageToLoad(120);
		closeNotification();
	}

	@Step
	public void navigateTo_EnchanceSearchPage() {
		enchancedSearchPage.navigateTo_EnchanceSearchPage();
	}

	@Step
	public void navigateTo_SearchTabinEnchancedSearch() {
		enchancedSearchPage.navigateTo_SearchTabinEnchanced();
	}

	@Step
	public void validateCountrycodeInTaskSearchEnchancedSearchPage() {
		enchancedSearchPage.validateCountryCodeinTaskSearch();

	}

}
