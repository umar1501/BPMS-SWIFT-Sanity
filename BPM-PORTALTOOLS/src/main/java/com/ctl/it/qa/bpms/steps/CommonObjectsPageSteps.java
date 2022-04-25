package com.ctl.it.qa.bpms.steps;

import com.ctl.it.qa.bpms.pages.CommonObjectsPage;
import com.ctl.it.qa.bpms.pages.EnchancedSearchPage;
import com.ctl.it.qa.bpms.pages.OrdersPage;
import com.ctl.it.qa.bpms.pages.TaskReportingPage;
import com.ctl.it.qa.bpms.pages.TasksPage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

public class CommonObjectsPageSteps extends Steps {

	CommonObjectsPage commonObjectsPage;
	OrdersPage ordersPage;
	TasksPage tasksPage;
	TaskReportingPage taskReportingPage;
	EnchancedSearchPage enchancedSearchPage;

	@Step
	public void launchPortalAndLogin(String userName) throws InterruptedException {
		commonObjectsPage.openPortal(userName);
		// commonObjectsPage.getOrderIDFromDB();
	}

	@Step
	public void closeNotification() {
		commonObjectsPage.closeNotification();
	}

	@Step
	public void checkAlert() {
		commonObjectsPage.checkAlert();
	}

	@Step
	public void navigateToTasksPage() {
		commonObjectsPage.navigateToTasksPage();
	}

	@Step
	public void clickSearchBtn_CriteriaToolbar() throws InterruptedException {
		commonObjectsPage.clickSearchBtn_CriteriaToolbar();
	}

	@Step
	public void clickResetBtn_CriteriaToolbar() {
		commonObjectsPage.clickResetBtn_CriteriaToolbar();
	}

	@Step
	public void navigateToQuickStartPageUnderOrderPage() {
		commonObjectsPage.navigateToQuickStartPageUnderOrderPage();
	}
}
