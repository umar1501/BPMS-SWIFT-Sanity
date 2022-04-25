package com.ctl.it.qa.bpms.pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ctl.it.qa.bpms.pages.common.CommonObjectsPage;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;

public class TaskReportingPage extends CommonObjectsPage {

	OrdersPage ordersPage;

	public Map<String, Integer> map = new HashMap<String, Integer>();

	private int NoOfCols = 0;

	// public String currentOrderID;

	// Objects for tabs under Search
	// Criteria*******************************************************************

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl03_coSearchTab_coIdsListBox")
	public WebElementFacade sel_SearchOnId_TaskReportingPage;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl03_coSearchTab_coIdsTextBox")
	public WebElementFacade tbx_SearchID_TaskReportingPage;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl03_noSearchTab_networkOrderIdTextBox")
	public WebElementFacade tbx_NetworkOrderSearchID_TaskReportingPage;

	@FindBy(xpath = "//textarea[@id='ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl03_qsSearchTab_qsIdsTextBox']")
	public WebElementFacade tbx_quickStartSearchID_TaskReportingPage;

	// *********************************************************************************************************

	// Object for
	// Table*****************************************************************************************
	@FindBy(id = "ctl00_mainContent_searchView_resultsPanel_ResultsGrid")
	public WebElementFacade tbl_SearchResults;

	@FindBy(xpath = "//table[@id='ctl00_mainContent_searchView_resultsPanel_ResultsGrid']/tbody/tr[contains(@class,'grid-row')]")
	public List<WebElementFacade> rows;

	@FindBy(xpath = "//table[@id='ctl00_mainContent_searchView_resultsPanel_ResultsGrid']/tbody/tr[contains(@class,'grid-row')][1]/td")
	public List<WebElementFacade> columns;

	@FindBy(xpath = "//table[@id='ctl00_mainContent_searchView_resultsPanel_ResultsGrid']/tbody/tr[contains(@class,'grid-header')]/th")
	public List<WebElementFacade> headers;

	@FindBy(id = "ctl00_mainContent_searchView_resultsPanel_refreshBtn")
	public WebElementFacade btn_Refresh_SearchResults;

	// *********************************************************************************************************

	// Objects for
	// Filters**************************************************************************************

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl02_taskStatus")
	public WebElementFacade sel_TaskStatusFilter_TaskReportingPage;

	// *********************************************************************************************************
	// Object for dependency and automation task filter
	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl02_excludeMilestoneDependencyTasksDropDown")
	public WebElementFacade sel_dependencyTaskFilter_TaskReportingPage;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl02_excludeAutoTasksDropDown")
	public WebElementFacade sel_automationTaskFilter_TaskReportingPage;
	// *********************************************************************************************************

	// Objects for Results Grid
	// Actions*************************************************************************

	@FindBy(xpath = "//a[contains(@title,'Manage Task')]")
	public WebElementFacade btn_ManageTask_TaskReportingPage;

	// *********************************************************************************************************

	// Objects for first page and next page in Result grid

	@FindBy(xpath = "(//*[@class='grid-pager']//td[4]/following-sibling::td)[1]")
	public WebElementFacade pages;

	@FindBy(xpath = "(//*[@class='silk-icon silk-icon-control-fastforward'])[1]")
	public WebElementFacade btn_NextPage;

	@FindBy(xpath = "(//a[@class='silk-icon silk-icon-control-start'])[1]")
	public WebElementFacade firstPageSearchResult;
	// *********************************************************************************************************

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl02_createDateRange_rangeType")
	public WebElementFacade taskCreateDateRange;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl02_createDateRange_relativeDropDown")
	public WebElementFacade taskCreateDateRangeValue;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl02_completeDateDateRange_rangeType")
	public WebElementFacade taskCompleteDateRange;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl02_completeDateDateRange_relativeDropDown")
	public WebElementFacade taskCompleteDateRangeValue;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl03_noSearchTab_solutionOrProjectTypeDropDown")
	public WebElementFacade selectProjectTypeOrSolutionType;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl03_noSearchTab_solutionOrProjectTypeListBox")
	public WebElementFacade selectProjectType;

	@FindBy(xpath = "//td[@title='Task Name']")
	public List<WebElementFacade> taskNames;

	@FindBy(xpath = "/html/body/ul/li[2]")
	public WebElementFacade cmmcBannerText;

	@FindBy(id = "ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl03_domainTabs_Quick")
	public WebElementFacade quickStartSubTab;
	
	@FindBy(xpath = "//td[@title='Customer Name:']")
	public WebElementFacade customerName;

	@FindBy(xpath = "//td[@title='Customer Name']")
	public List<WebElement> customerNames;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return tab_CommonCriteria_TaskReportingPage;
	}

	public int getNoOfColumns() {
		if (NoOfCols < 1) {
			getTableHeaders();
		}
		return NoOfCols;
	}

	public List<WebElementFacade> getTableRows() {
		sync(this, ExpectedConditions.visibilityOfNestedElementsLocatedBy(tbl_SearchResults,
				By.xpath("./tbody/tr[contains(@class,'grid-row')]")));
		try {
			if (rows.size() < 1) {
				getTableRows();
			}
		} catch (Exception exp) {
			exp.printStackTrace();
			waitABit(5000);
		}

		return rows;
	}

	public List<WebElementFacade> getTableColumns() {
		sync(this, ExpectedConditions.visibilityOfNestedElementsLocatedBy(tbl_SearchResults,
				By.xpath("./tbody/tr[contains(@class,'grid-row')]/td")));
		try {
			if (columns.size() < 1) {
				getTableColumns();
			}
		} catch (Exception exp) {
			exp.printStackTrace();
			waitABit(5000);
		}

		return columns;
	}

	public List<WebElementFacade> getTableHeaders() {
		sync(this, ExpectedConditions.visibilityOfNestedElementsLocatedBy(tbl_SearchResults,
				By.xpath("./tbody/tr[contains(@class,'grid-header')]/th")));
		try {
			if (headers.size() < 1) {
				getTableHeaders();
			} else {
				NoOfCols = headers.size();
				if (NoOfCols != map.size()) {
					map.clear();
					for (int i = 0; i < headers.size(); i++) {
						map.put(headers.get(i).getText(), i + 1);
					}
				}
			}
		} catch (Exception exp) {
			exp.printStackTrace();
			waitABit(5000);
		}

		return headers;
	}

	public int getColumnNum(String columnName, List<WebElementFacade> headers) {

		if (headers == null || headers.size() < 1) {
			headers = getTableHeaders();
		}
		int columnNum = 0;

		try {
			columnNum = map.get(columnName);
		} catch (Exception exp) {
			for (int i = 0; i < headers.size(); i++) {
				map.put(headers.get(i).getText(), i + 1);
			}
			getColumnNum(columnName, headers);
		}

		System.out.println("Column Number for Column : " + columnName + " is : " + columnNum);
		return columnNum;

	}

	public void waitTillElementToBeClicakble(WebElement trgElement) {
		sync(this, trgElement);
		WebDriverWait wait = new WebDriverWait(this.getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(trgElement));
		WaitForPageToLoad(120);
	}

	public void backToTaskReportingFirstPage() {
		String pageNos = pages.getText();
		System.out.println(pageNos);
		if (!pageNos.startsWith("(Page 1")) {
			waitTillElementToBeClicakble(firstPageSearchResult);
			firstPageSearchResult.click();
		}
		waitABit(3000);
	}

	public void selectTaskCreateDateDropdown(String value) {

		Select select = new Select(taskCreateDateRange);
		select.selectByVisibleText((value));

		waitABit(8000);
	}

	public void selectTaskCreateDateValue(String expectedData) {
		Select select = new Select(taskCreateDateRangeValue);
		select.selectByVisibleText((expectedData));
		waitABit(8000);

	}

	public void selectTaskCompleteDateDropdown(String value) {
		Select select = new Select(taskCompleteDateRange);
		select.selectByVisibleText((value));
		waitABit(8000);
	}

	public void selectTaskCompleteDateValue(String expectedData) {
		Select select = new Select(taskCompleteDateRangeValue);
		select.selectByVisibleText((expectedData));
		waitABit(8000);
	}

	public void selectSolutionTypeOrProjectType(String value) {
		sync(this, selectProjectTypeOrSolutionType);
		waitABit(1000);
		Select select = new Select(selectProjectTypeOrSolutionType);
		select.selectByVisibleText((value));
		waitABit(8000);
	}

	public void selectProjectTypeValue(String expectedData) {

//		WebElement select1 = getDriver().findElement(By.xpath("//select[@id='ctl00_mainContent_searchView_criteriaPanel_criteriaControl_ctl03_noSearchTab_solutionOrProjectTypeListBox']//option[@value='DarkFiber']"));
//		WebElement select2 = getDriver().findElement(By.xpath("//option[@value='InsideWire']"));
//
//		WebElement select3 = getDriver().findElement(By.xpath("//option[@value='BuildingAddExpansion']"));
		
		Select s1= new Select(selectProjectType);
		s1.selectByVisibleText("Dark Fiber");
		s1.selectByVisibleText("Inside Wire");
		s1.selectByVisibleText("Building Add Expansion");
//		Actions action = new Actions(getDriver());
//		action.sendKeys(Keys.CONTROL).click(select1).click(select2).click(select3).build().perform();

		waitABit(8000);
	}

	public void ValidateProjectTypeinTaskReportingPage() {
		List<WebElement> list = getDriver().findElements(By.xpath("//td[@title='Project Type']"));

		for (int i = 0; i <= list.size(); i++) {

			String projectTypeValue = list.get(i).getText();
			if (projectTypeValue.equals("Dark Fiber") || projectTypeValue.equals("Inside Wire")
					|| projectTypeValue.equals("Building Add Expansion")) {
				System.out.println("Project Type Value Successfully validated");
			}
		}

	}

	// To check tasks not generating in Task Reporting Page

	public void validateTaskShouldNotTrigger(String expectedData) {
		
		
		boolean trgTaskFound = false;
		int n=5;
		String[] expectedTasks = expectedData.split(" -or- ");
		String pageValue = pages.getText();
		String[] pageNo = pageValue.split("of ");
		String totalPage = pageNo[1].replace(")", "");
		System.out.println("Total-Page No=" + totalPage);
		Actions a1 = new Actions(this.getDriver());
		int page = Integer.parseInt(totalPage);
		for (int j = 1; j <= page; j++) {
			for (int i = 0; i <= taskNames.size() - 1; i++) {
				String tasksName = taskNames.get(i).getText();
				System.out.println("Page No=" + j);
				System.out.println("TaskName-" + tasksName);
				for (int k = 0; k <= expectedTasks.length-1; k++) {
					if(k!=n) {
					if (expectedTasks[k].equals(tasksName)) {
						System.out.println("Failed task is present in workflow" );
						n=k;
						trgTaskFound = true;
						break;
					}
					}
				}
				
			}
			
			if(j!=page)
			{
			a1.moveToElement(btn_NextPage).click().perform();
			System.out.println("next page clicked");
			waitABit(5000);
			}
		}
		
		if (trgTaskFound == false) {
			System.out.println("Successfully validated the target task is not kicked off in the workflow");
			
		}

	}


		
//		boolean trgTaskFound = false;
//		String[] expectedTasks = expectedData.split(" -or- ");
//		String pageValue = pages.getText();
//		String[] pageNo = pageValue.split("of ");
//		String totalPage = pageNo[1].replace(")", "");
//		System.out.println("Total-Page No=" + totalPage);
//		Actions a1 = new Actions(this.getDriver());
//		int page = Integer.parseInt(totalPage);
//		for (int j = 1; j < page; j++) {
//			for (int i = 0; i <= taskNames.size() - 1; i++) {
//				String tasksName = taskNames.get(i).getText();
//				System.out.println("Page No=" + j);
//				System.out.println("TaskName-" + tasksName);
//				for (int k = 0; k <= expectedTasks.length; k++) {
//					if (expectedTasks[k].equals(tasksName)) {
//						System.out.println("Found the target task-" + tasksName);
//						trgTaskFound = true;
//						break;
//					}
//				}
//			}
//			if (trgTaskFound == true) {
//				break;
//			}
//			a1.moveToElement(btn_NextPage).click().perform();
//			System.out.println("next page clicked");
//			waitABit(5000);
//		}
//		
//		if (trgTaskFound == false) {
//			System.out.println("Successfully validated the target task is not kicked off in the workflow");
//		}
//	}

	public void validateCMMCBannerOnTopOfPage() {
		waitABit(5000);
		String cmmcBannerMessage = cmmcBannerText.getText();
		System.out.println(cmmcBannerMessage);

	}
	

	public void validatesCustomerNameInManageOrderPage(String expectedData) {
	waitABit(5000);
	waitABit(5000);
	boolean status=customerName.isDisplayed();
	System.out.println("Status-"+status);
	String actualData=customerName.getText();
	System.out.println("Actual Data="+actualData);
	Assert.assertEquals(expectedData, actualData);
	
	} 
	
	
	public void validatesCustomerNameInTaskReportingPage(String expectedData) {
	for(int i=0;i<=customerNames.size()-1;i++){
	waitABit(5000);
	String actualData=customerNames.get(i).getText();
	System.out.println("Actual Data1="+actualData);
	Assert.assertEquals(expectedData, actualData);
	
	}

	}

	public void clickOnManageTasks(String taskName) {
	
		String trgTaskName1="//td[text()='";
		String trgTaskName2="']/..//td/a[1]";
		
		WebElement manageTask = getDriver().findElement(By.xpath(trgTaskName1+taskName+trgTaskName2));
		sync(this, ExpectedConditions.visibilityOfNestedElementsLocatedBy(tbl_SearchResults,
				By.xpath(trgTaskName1+taskName+trgTaskName2)));
        waitTillElementToBeClicakble(manageTask);
        sync(this, manageTask);
        waitABit(1000);
        manageTask.click();
        System.out.println("Success");
        waitABit(1000);
	}

	public void waitForTaskCompletion3(String trgTaskName) {
		
		
		boolean trgTaskFound = false;
		int n=5;
		String[] expectedTasks = trgTaskName.split(" -or- ");
		String pageValue = pages.getText();
		String[] pageNo = pageValue.split("of ");
		String totalPage = pageNo[1].replace(")", "");
		System.out.println("Total-Page No=" + totalPage);
		Actions a1 = new Actions(this.getDriver());
		int page = Integer.parseInt(totalPage);
		for (int j = 1; j <= page; j++) {
			for (int i = 0; i <= taskNames.size() - 1; i++) {
				String tasksName = taskNames.get(i).getText();
				System.out.println("Page No=" + j);
				System.out.println("TaskName-" + tasksName);
				for (int k = 0; k <= expectedTasks.length-1; k++) {
					if(k!=n) {
					if (expectedTasks[k].equals(tasksName)) {
						String taskStatus1="//td[@title='Task Name' and text()='";
						String taskStatus2 = expectedTasks[k] + "']/../td[@title='Task Status']";
						WebElement taskStatusElement= getDriver().findElement(By.xpath(taskStatus1+taskStatus2));
						String taskStatus = taskStatusElement.getText();
						if(taskStatus.equals("Completed"))
						{
						System.out.println("Successfully validated the- "+tasksName+"  task completed" );
						n=k;
						trgTaskFound = true;
						break;
						}
					}
					}
				}
				
			}
			
			if(j!=page)
			{
			a1.moveToElement(btn_NextPage).click().perform();
			System.out.println("next page clicked");
			waitABit(5000);
			}
		}
		
		if (trgTaskFound == true) {
			System.out.println("Successfully validated the target task is completed in the workflow");
			
		}
		else if(trgTaskFound == false)
		{
			throw new ArithmeticException("Falied -target task is not completed");	
		}

	}
	
	
}


//	public void validateCMMCBannerOnTopOfPage(){
//  
	//waitABit(5000);
//        String cmmcBannerMessage=cmmcBannerText.getText();
//        System.out.println(cmmcBannerMessage);
//    }​​​​​

