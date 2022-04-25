package com.ctl.it.qa.bpms.steps;


import com.ctl.it.qa.bpms.pages.SearchResultsPage;
import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.Steps;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

@SuppressWarnings("serial")
public abstract class SfaSteps extends Steps {

	SearchResultsPage searchResultsPage;

	

	public void open_search_results_page() {
		WaitForPageToLoad(150);
		searchResultsPage.btn_search.click();
		while (!isExist(searchResultsPage)) {
			searchResultsPage.btn_search.click();
		}
	}

	

	public void open_record(String recordType, String recordName) {
		
		open_search_results_page();
		
		shouldExist(searchResultsPage);
		
		searchResultsPage.searchObject(recordType, recordName);
		
		searchResultsPage.selectResult(recordType, recordName);
		
		WaitForPageToLoad(60);
	}

	
	
	public IntDataContainer get_data_for_page(Page page) {
		return commonData.getContainer(page.getClass().getSimpleName());
	}

	public IntDataContainer get_container_from_xml(String... containers) {
		IntDataContainer actualContainer = commonData;
		for (int i = 0; i < containers.length; i++) {
			actualContainer = actualContainer.getContainer(containers[i]);
		}
		actualContainer.setActualValuesForAllContainers();
		return actualContainer;
	}

}
