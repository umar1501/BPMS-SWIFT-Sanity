package com.ctl.it.qa.bpms.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SelectRecordTypePage extends SfaPage {

	@FindBy(id = "p3")
	public WebElementFacade ddl_record_type_of_new_record;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return ddl_record_type_of_new_record;
	}

	public void selectRecordType(String recordType) {
		shouldExist(this);
		ddl_record_type_of_new_record.selectByVisibleText(recordType);
		btn_continue.click();
	}
}
