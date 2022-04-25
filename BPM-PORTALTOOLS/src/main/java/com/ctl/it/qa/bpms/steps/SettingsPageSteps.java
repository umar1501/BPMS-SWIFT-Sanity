package com.ctl.it.qa.bpms.steps;

import com.ctl.it.qa.bpms.pages.SettingsPage;

import net.thucydides.core.annotations.Step;

public class SettingsPageSteps extends CommonObjectsPageSteps {

	SettingsPage settingsPage;

	@Step
	public void ImpersonateUser(String trgUser) {
		settingsPage.ImpersonateUser(trgUser);
	}

	@Step
	public void removeAllCache() {
		settingsPage.btn_RemoveAllCache.click();
	}

	@Step
	public void removeImpersonation() {
		settingsPage.lnk_UndoImpersonate.click();
	}

	@Step
	public void enterImpersonationID(String trgUser) {
		settingsPage.enterImpersonationID(trgUser);
	}

}
