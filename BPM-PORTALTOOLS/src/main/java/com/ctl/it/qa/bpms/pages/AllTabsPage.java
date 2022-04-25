package com.ctl.it.qa.bpms.pages;

import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class AllTabsPage extends SfaPage {
	
	@FindBy(xpath="//option[text()='All Tabs'][@selected='selected']")
	public WebElementFacade ddl_all_tabs;
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return ddl_all_tabs;
	}

	public void openPage(String pageName) {
		find(By.cssSelector("img[title = '" + pageName + "']")).click();
	}
}
