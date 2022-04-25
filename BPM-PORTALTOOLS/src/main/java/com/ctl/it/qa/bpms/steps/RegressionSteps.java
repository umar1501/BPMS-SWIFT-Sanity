package com.ctl.it.qa.bpms.steps;

import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.http.util.TextUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctl.it.qa.bpms.pages.BaseStep;
import com.ctl.it.qa.bpms.pages.MetaStormPage;
import com.ctl.it.qa.bpms.pages.SwiftCustomerPage;
import com.ctl.it.qa.bpms.pages.SwiftHomePage;
import com.ctl.it.qa.bpms.pages.SwiftOrderPackagePage;
import com.ctl.it.qa.bpms.pages.SwiftPage;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;
import com.ibm.icu.impl.Assert;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;


public class RegressionSteps extends BaseStep{

	SwiftPage swiftpage;
	SwiftOrderPackagePage swiftorderpackagepage;
	SwiftCustomerPage swiftcustomerpage;
	SwiftHomePage	swiftHomePage;
	MetaStormPage metastormpage;

	IntDataContainer Container1 = envData.getContainer("TEST2");
	//IntDataContainer Container2 = commonData.getContainer("SFDC2");
	IntDataContainer Container3 = envData.getContainer("SwIFT");
	IntDataContainer Container6 = envData.getContainer("MetaStorm");




	String sess = null;
	public static String orderpackageid = null;

	@Step

	public void user_logged_in_Swift_in_specified_environment_with_Account_ID(String ENV, String Account_ID) {
		try {	
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

			if (ENV.contains("1")) {
				swiftpage.openAt(Container3.getFieldValue("ITV1"));
			}
			if (ENV.contains("2")) {
				swiftpage.openAt(Container3.getFieldValue("ITV2"));
			}
			if (ENV.contains("4")) {
				swiftpage.openAt(Container3.getFieldValue("ITV4"));
			}
			WaitForPageToLoad(120);
			ExpectedConditions.visibilityOf(swiftpage.ddl_order);
			System.out.println("Swift Page Launched");
			String url = getDriver().getCurrentUrl();
			System.out.println("Current URL : "+url);
			swiftpage.maximize();
			WaitForPageToLoad(10000);  // wait for auto log in
			ExpectedConditions.visibilityOf(swiftpage.ddl_order);
			swiftpage.ddl_order.click();
			waitABit(10000);
			ExpectedConditions.visibilityOf(swiftpage.ddl_customer_id);
			swiftpage.ddl_customer_id.click();
			waitABit(2000);
			ExpectedConditions.visibilityOf(swiftpage.tbx_order_id_field);
			swiftpage.tbx_order_id_field.sendKeys(Account_ID + Keys.ENTER);
			customwaitforpageloading(swiftpage);  

			String parent=getDriver().getWindowHandle();
			System.out.println(parent);
			ExpectedConditions.elementToBeClickable(swiftpage.lnk_account);			
			swiftpage.lnk_account.click();
			WaitForPageToLoad(60);
			ExpectedConditions.elementToBeClickable(swiftpage.lnk_account1);
			swiftpage.lnk_account1.click();
			WaitForPageToLoad(60);

			java.util.Set<String> child = getDriver().getWindowHandles(); 

			getDriver().switchTo().window(parent);
			waitABit(5000);
			getDriver().close();

			System.out.println("Size of the Window : "+child.size());
			//	child.remove(parent);	
			getDriver().switchTo().window((String) child.toArray()[1]);
			getDriver().manage().window().maximize();

			String url1 = getDriver().getCurrentUrl();
			System.out.println("Current URL : "+url1);

		}
		catch(Exception e){
			Assert.fail(e);
		}
	}
	@Step

	public void user_creates_the_new_order_package_with_required_products_for_Cllis(String clli, String env, String product, String attributeList){

		try { 
			

		}
		catch(Exception e) {
			Assert.fail(e);
			System.out.println(e);
		}

	}
	@Step 
	public void user_updates_the_contact_details(String Contact) {
	try {
		waitABit(2000);
		customClickableWait(swiftpage.btn_contacts);
		swiftpage.btn_contacts.click();
		System.out.println("Updating Contacts");
		waitABit(2000);
		swiftpage.tbx_add_contact.sendKeys(Contact);
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		waitABit(2000);
		swiftpage.tbx_contact_role.click();
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(2000);
		swiftpage.tbx_contact_section.click();
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		waitABit(2000);
		swiftpage.btn_contacts.click();
		customwaitforpageloading(swiftpage);
		swiftpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftpage.btn_contacts));
		System.out.println("Contacts Updated Successfully");

		

//			WebElement Oops = getDriver().findElement(By.xpath("//h2[@id='OopsTitle']"));
//
//			WebElement Overlay = getDriver().findElement(By.xpath("//div[@class='k-overlay']"));
//
//
//			for (int i = 0; i < 5; i++) {
//
//				if (Oops.isDisplayed() && Overlay.isDisplayed()) {
//
//
//					System.out.println("Oops Displayed, Closing the Window");
//					waitABit(2000);
//					getDriver().findElement(By.xpath("//button[contains(.,'Refresh Page')]")).click();
//
//				} else {
//
//					System.out.println("Contacts Updated Successfully");
//					break;
//				}
//
//			}

		} catch (Exception e) {

			Assert.fail(e);
		}

		//a[@class='k-button k-bare k-button-icon k-window-action k-state-hover']

	}

	@Step 
	public void User_should_validate_and_complete_the_tasks_generated() {
		try {
	
			String taskName = null, taskStatus = null, taskAssigned = null, currentUser = null ;
		
			do {
				
				customwaitforpageloading(swiftpage);
	//			swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(50)).waitFor(ExpectedConditions.visibilityOf(swiftcustomerpage.lbl_last_task_status));
				taskStatus = swiftcustomerpage.lbl_last_task_status.getText().trim();
            	while(!taskStatus.contains("Ready") ) {
            		getDriver().navigate().refresh();
            		customwaitforpageloading(swiftpage);
            		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(150)).waitFor(ExpectedConditions.visibilityOf(swiftcustomerpage.lbl_last_task_status));
            		taskStatus = swiftcustomerpage.lbl_last_task_status.getText().trim();

            	}
            	customwaitforpageloading(swiftpage);
            	swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_last_task_row));
            	swiftcustomerpage.lbl_last_task_row.click();
            	swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(50)).waitFor(ExpectedConditions.visibilityOf(swiftcustomerpage.lbl_last_task_name));
            	taskName = swiftcustomerpage.lbl_last_task_name.getText().trim();
            	swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(50)).waitFor(ExpectedConditions.visibilityOf(swiftHomePage.lbl_imp_user));
            	currentUser = swiftHomePage.lbl_imp_user.getText().toLowerCase();
            	swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(50)).waitFor(ExpectedConditions.visibilityOf(swiftcustomerpage.lbl_last_task_assigned));
            	taskAssigned = swiftcustomerpage.lbl_last_task_assigned.getText().toLowerCase();
            	System.out.println("Task name : " + taskName);
            	System.out.println("Task status : " + taskStatus);
            	System.out.println("Current User : " + currentUser);
            	System.out.println("Assigned Name : " + taskAssigned);
            	customwaitforpageloading(swiftpage);
    			if(taskName.contains("Wait For Credit Approval") || taskName.contains("Waiting For BPMS Acceptance")) {
    				
    				customwaitforpageloading(swiftpage);
    				while(taskStatus.contains("Ready")  && taskAssigned.contains("system task")) {
    					customwaitforpageloading(swiftpage);
    					swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(50)).waitFor(ExpectedConditions.visibilityOf(swiftcustomerpage.lbl_last_task_assigned));
    					customwaitforpageloading(swiftpage);
    					taskAssigned = swiftcustomerpage.lbl_last_task_assigned.getText().toLowerCase();
    					taskStatus = swiftcustomerpage.lbl_last_task_status.getText().trim();
    					swiftpage.btn_OrderId_Search_Button.click();
    					waitABit(14000);
    				}	
    				
    				if(taskName.contains("Waiting For BPMS Acceptance"))
    					break;
    				
    				
    			}
    			else {
    				customwaitforpageloading(swiftpage);
    			 if(taskName.contains("Order Validation")) {
    				swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_TDG_Open));
    				System.out.println("Opening TDG form");
    				swiftcustomerpage.btn_TDG_Open.click();
    				waitABit(50000);
    				WaitForPageToLoad(10000);
    				customwaitforpageloading(swiftpage);
    				setParentHandle();
    				setChildHandle();
    				switchToChildWindow();
    				waitABit(30000);
    				swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(150)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Edit_Button));
    				swiftcustomerpage.btn_Edit_Button.click();
    		        if(!swiftcustomerpage.btn_TDG_Save.isClickable())
    		        	swiftcustomerpage.btn_Edit_Button.click();
    		        System.out.println("Clicked on Edit button");
    				swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(150)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_TDG_Save));
    				swiftcustomerpage.btn_TDG_Save.click();
    				waitABit(20000);
    				System.out.println("Clicked on Save button");
    				getDriver().close();
    				waitABit(3000);
    				System.out.println("TDG form closed");
    				switchToParentWindow();
    				
    			}
    			 customwaitforpageloading(swiftpage);
    			if(!currentUser.contains(taskAssigned))
    			{
    				// Impersonate the user 
    				impersonateuser(taskAssigned);
    				customwaitforpageloading(swiftpage);
        			WaitForPageToLoad(10000);
    			}
    			
    			//Click on Validate Button.
//    			swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Validate));
//    			swiftcustomerpage.btn_Validate.click();
//    			waitABit(1000);
//
//    			//Click on OK Button in Validation result alert box.
//    			swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Ok_Button));
//    			swiftcustomerpage.btn_Ok_Button.click();
    			swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(50)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_last_task_row));
    			swiftcustomerpage.lbl_last_task_row.click();
            	
    			//Click on Complete Button.
    			swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Complete));
    			swiftcustomerpage.btn_Complete.click();
    			swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_last_task_row));
    			waitABit(15000);
    			WaitForPageToLoad(11000);
    			System.out.println("clicked on complete button");
    			
    			}	
   
			}
			
			while(!(taskName.contains("Waiting For BPMS Acceptance") && taskStatus.contains("Completed")));
			System.out.println("Order is accepted by BPMS");
		
		}
		catch (Exception e) {
			Assert.fail(e);
		}
	}

	@Step 
	public void i_should_validate_and_complete_the_First_task()
	{
		String orderpackageid = getDriver().findElement(By.xpath("//div[@class='k-link']/span[1]")).getText();
		System.out.println("Order Package ID = " + orderpackageid);

		Serenity.setSessionVariable("orderpackageid").to(orderpackageid);
		sess = Serenity.sessionVariableCalled("orderpackageid");
		waitABit(3000);

		swiftpage.ddl_order.click();
		waitABit(2000);
		swiftpage.ddl_order_id.click();
		waitABit(2000);
		swiftpage.tbx_order_id_field.clear();
		waitABit(1000);
		swiftpage.tbx_order_id_field.sendKeys(orderpackageid + Keys.ENTER);
		waitABit(10000);

		swiftpage.lbl_OES_select.click();
		getDriver().switchTo().activeElement().sendKeys("Praveenya", Keys.ENTER);
		waitABit(2000);
		waitABit(2000);
		swiftpage.btn_top_save.click();
		customwaitforpageloading(swiftpage);
		waitABit(2000);

		// Validating and completing Analyze/Adjust Task.
		//Click on Validate Button.
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Validate));
		swiftcustomerpage.btn_Validate.click();
		waitABit(1000);

		//Click on OK Button in Validation result alert box.
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Ok_Button));
		swiftcustomerpage.btn_Ok_Button.click();

		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_Ana_Adj_Task_SFDC));

		//if the task name is Analyze/Adjust.
		//get the assigned name value of the Analyze/Adjust task 
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_Assigned_name1_SFDC));
		String Assignedname2 = swiftcustomerpage.lbl_Assigned_name1_SFDC.getText().toLowerCase();
		System.out.println("Assigned name 2 : " + Assignedname2);

		//if the assigned name is not equal to current user 
		//impersonateuser("Nunna, Madhav");
		swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(swiftHomePage.lbl_imp_user));
		String CurrentUser2 = swiftHomePage.lbl_imp_user.getText().toLowerCase();
		System.out.println("Current User 2 : " + CurrentUser2);
		if(!swiftHomePage.lbl_imp_user.getText().toLowerCase().contains(Assignedname2.toLowerCase()))
		{
			// Impersonate the user 
			impersonateuser(Assignedname2);

		}

		//Click on Complete Button.
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(120)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Complete));
		swiftcustomerpage.btn_Complete.click();

		System.out.println("Waiting for Next Task to Generate");

		try {

			for (int i = 0; i < 100; i++) {

				waitABit(5000);
				String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]")).getText();
				System.out.println("Update Task Status : "+UpdatedTask);

				if (UpdatedTask.contains("1 - 4 of 4 items")) {
					System.out.println("2nd Task Generated");
					waitABit(2000);
					break;

				} else {

					waitABit(30000);
					getDriver().navigate().refresh();
					WaitForPageToLoad(60);
					System.out.println("2nd Task Not Generated, Retrying");
				}


				customwaitforpageloading(swiftpage);
			}
		}
		catch (Exception e) {
			System.out.println(e);	
		}

	}

	@Step 
	public void i_Should_Validate_and_complete_GOD_task()
	{
		swiftcustomerpage.lbl_anasy_adst_Row.click();

		customClickableWait(swiftpage.lnk_docs1_one);
		swiftpage.lnk_docs1_one.click();
		waitABit(3000);

		String FilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\ISE.pdf";
		System.out.println("SOF File Path : " +FilePath);

		getDriver().findElement(By.id("fileUploadInput")).sendKeys(FilePath);
		waitABit(8000);

		customClickableWait(swiftpage.ddl_doc_type);
		swiftpage.ddl_doc_type.click();
		customClickableWait(swiftpage.ddl_doc_ise_Design);
		swiftpage.ddl_doc_ise_Design.click();
		waitABit(3000);
		swiftpage.btn_save_doc.click();
		waitABit(5000);
		customwaitforpageloading(swiftpage);
		swiftpage.lnk_close_window.click();
		waitABit(5000);

		getDriver().navigate().refresh();
		waitABit(30000);
		WaitForPageToLoad(60);

		//Click on Validate Button.
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Validate));
		swiftcustomerpage.btn_Validate.click();
		waitABit(1000);

		//Click on OK Button in Validation result alert box.
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Ok_Button));
		swiftcustomerpage.btn_Ok_Button.click();
		customwaitforpageloading(swiftpage);

		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_GOD_Task_SFDC));

		//if the task name is Gather order Details.
		//get the assigned name value of the Gather order Details task 
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_Assigned_name2));
		String Assignedname2ndtask = swiftcustomerpage.lbl_Assigned_name2.getText().toLowerCase();
		System.out.println("Assigned name 2nd task : " + Assignedname2ndtask);

		//if the assigned name is not equal to current user 
		//impersonateuser("Nunna, Madhav");
		swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(swiftHomePage.lbl_imp_user));
		String CurrentUser2 = swiftHomePage.lbl_imp_user.getText().toLowerCase();
		System.out.println("Current User 2 : " + CurrentUser2);
		if(!swiftHomePage.lbl_imp_user.getText().toLowerCase().contains(Assignedname2ndtask.toLowerCase()))
		{
			// Impersonate the user 
			impersonateuser(Assignedname2ndtask);

		}

		//Click on Complete Button.
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(120)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Complete));
		swiftcustomerpage.btn_Complete.click();
		System.out.println("2nd Task Completed");

		String Packg_Status = getDriver().findElement(By.xpath("//span[@id='OrderPackageStatusLbl']")).getText();
		System.out.println("Package Status : "+Packg_Status);

		try {

			for (int i = 0; i < 100; i++) {

				waitABit(2000);
				String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]")).getText();
				System.out.println("Update Task Status : "+UpdatedTask);

				if (UpdatedTask.contains("1 - 4 of 4 items")) {

					waitABit(2000);
					break;

				} else {

					waitABit(30000);
					getDriver().navigate().refresh();
					WaitForPageToLoad(60);

				}

				System.out.println("3rd and 4th Task Generated");
				customwaitforpageloading(swiftpage);
			}
		}
		catch (Exception e) {
			System.out.println(e);	
		} 

	}

	@Step 
	public void i_Should_validate_and_complete_welcome_customer_and_customer_cord_task_for_HDIC(String ENV)
	{
		swiftcustomerpage.lbl_Order_val_Row.click();
		customClickableWait(swiftpage.lnk_order_package_ready4);

		for (int i = 0; i < 5; i++) {

			String FourthTask = getDriver().findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[5]/td[4]/span")).getText();

			System.out.println("Fourth Task Status : "+FourthTask);

			if (FourthTask.contains("Ready")) {

				System.out.println("Fourth Task is Ready to be Validated");
				break;

			} else {

				System.out.println("Fourth Task is Not Ready to be Validated, Switching to MetaStorm");

				//getDriver().close();

				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

				if (ENV.contains("1")) {
					metastormpage.openAt(Container6.getFieldValue("ITV1"));
				}
				if (ENV.contains("2")) {
					metastormpage.openAt(Container6.getFieldValue("ITV2"));
				}
				if (ENV.contains("4")) {
					metastormpage.openAt(Container6.getFieldValue("ITV4"));
				}

				WaitForPageToLoad(100);
				metastormpage.maximize();
				waitABit(5000);	//auto login wait
				System.out.println("MetaStorm Page is Loaded");
				System.out.println("Current URL : "+getDriver().getCurrentUrl());
				customClickableWait(metastormpage.btn_watch_list);
				metastormpage.btn_watch_list.click();
				waitABit(3000);
				customClickableWait(metastormpage.ddl_process);
				metastormpage.ddl_process.click();
				waitABit(5000);
				customClickableWait(metastormpage.ddl_process_OP_Welcome);
				metastormpage.ddl_process_OP_Welcome.click();
				waitABit(5000);
				customClickableWait(metastormpage.ddl_stage);
				metastormpage.ddl_stage.click();
				waitABit(5000);
				customClickableWait(metastormpage.ddl_stage_select);
				metastormpage.ddl_stage_select.click();
				waitABit(5000);

				String parent=getDriver().getWindowHandle();

				System.out.println("Sess Value for Xpath is : "+sess);
				metastormpage.metastorm(sess).click();
				waitABit(10000);

				java.util.Set<String> child = getDriver().getWindowHandles(); 
				System.out.println("Size of the Window : "+child.size());
				child.remove(parent);

				getDriver().switchTo().window((String) child.toArray()[0]);
				getDriver().getTitle();
				getDriver().manage().window().maximize();

				try {

					List<WebElement> TaskList = getDriver().findElements(By.xpath("//span[contains(.,'ManuallyExpireWCTaskWait')]"));

					for (int k = 0; k < TaskList.size(); k++) {
						waitABit(5000);
						if (TaskList.get(k).getText().contains("ManuallyExpireWCTaskWait")) {
							waitABit(5000);
							System.out.println("Manually Expire WC Task Wait Button Found");
							String parent1 = getDriver().getWindowHandle();
							TaskList.get(k).click();
							System.out.println("Manually Expire WC Task Wait Clicked");
							waitABit(10000);


							for (String childWindowHandle : getDriver().getWindowHandles()) {
								//If window handle is not main window handle then close it 
								if(!childWindowHandle.equals(parent1)){
									getDriver().switchTo().window(childWindowHandle);

									getDriver().switchTo().activeElement().sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);
								}
							} 

							System.out.println("Metastorm Task Performed");
							getDriver().switchTo().window(parent);

						}
					}
				}

				catch (Exception e) {

					System.out.println("Catched Exception : "+e.getMessage());
				}
				finally {
					System.out.println("Manually Expire WC Task Done");
				}				

				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

				if (ENV.contains("1")) {
					swiftpage.openAt(Container3.getFieldValue("ITV1"));
				}
				if (ENV.contains("2")) {
					swiftpage.openAt(Container3.getFieldValue("ITV2"));
				}
				if (ENV.contains("4")) {
					swiftpage.openAt(Container3.getFieldValue("ITV4"));
				}

				WaitForPageToLoad(60);
				System.out.println("Swift Page Launched Again");
				swiftpage.maximize();
				WaitForPageToLoad(5);  // wait for auto log in
				swiftpage.btn_OrderId_Search_Button.click();
				waitABit(10000);
				getDriver().navigate().refresh();
				waitABit(2000);
				WaitForPageToLoad(60); 

				customClickableWait(swiftpage.lnk_order_package_ready4th);
				waitABit(10000);



			}
		}	

		//Validating and completing Welcome Customer Task(4th Row).
		//Click on Validate Button.
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Validate));
		swiftcustomerpage.btn_Validate.click();
		waitABit(1000);

		//Click on OK Button in Validation result alert box.
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Ok_Button));
		swiftcustomerpage.btn_Ok_Button.click();

		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_CustomerCord_Task_SFDC));

		//if the task name is Customer Coordination 
		//get the assigned name value of the Gather order Details task 
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_Assigned_name4));
		String Assignedname4 = swiftcustomerpage.lbl_Assigned_name3.getText().toLowerCase();
		System.out.println("Assigned name 4 : " + Assignedname4);

		//if the assigned name is not equal to current user 
		//impersonateuser("Nunna, Madhav");
		swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(swiftHomePage.lbl_imp_user));
		String CurrentUser2 = swiftHomePage.lbl_imp_user.getText().toLowerCase();
		System.out.println("Current User 2 : " + CurrentUser2);
		if(!swiftHomePage.lbl_imp_user.getText().toLowerCase().contains(Assignedname4.toLowerCase()))
		{
			// Impersonate the user 
			impersonateuser(Assignedname4);

		}

		//Click on Complete Button.
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(120)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Complete));
		swiftcustomerpage.btn_Complete.click();
		waitABit(20000);
		System.out.println("4nd Task Completed");

		String Packg_Status = getDriver().findElement(By.xpath("//span[@id='OrderPackageStatusLbl']")).getText();
		System.out.println("Package Status : "+Packg_Status);

		//Validating and completing Customaer Coordination Task (3rd Row).
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_Credit_Approval_Row));
		swiftcustomerpage.lbl_Credit_Approval_Row.click();

		//Click on Validate Button.
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Validate));
		swiftcustomerpage.btn_Validate.click();
		waitABit(1000);

		//Click on OK Button in Validation result alert box.
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Ok_Button));
		swiftcustomerpage.btn_Ok_Button.click();

		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_WelCust_Task_SFDC));

		//if the task name is Welcome Customer
		//get the assigned name value of the Gather order Details task 
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_Assigned_name3));
		String Assignedname3 = swiftcustomerpage.lbl_Assigned_name4.getText().toLowerCase();
		System.out.println("Assigned name 3 : " + Assignedname3);

		//if the assigned name is not equal to current user 
		//impersonateuser("Nunna, Madhav");
		swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(swiftHomePage.lbl_imp_user));
		String CurrentUser3 = swiftHomePage.lbl_imp_user.getText().toLowerCase();
		System.out.println("Current User 2 : " + CurrentUser3);
		if(!swiftHomePage.lbl_imp_user.getText().toLowerCase().contains(Assignedname3.toLowerCase()))
		{
			// Impersonate the user 
			impersonateuser(Assignedname3);

		}

		//Click on Complete Button.
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(120)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Complete));
		swiftcustomerpage.btn_Complete.click();
		waitABit(20000);
		System.out.println("4nd Task Completed");

		String Packg_Status1 = getDriver().findElement(By.xpath("//span[@id='OrderPackageStatusLbl']")).getText();
		System.out.println("Package Status : "+Packg_Status1);

		try {

			for (int i = 0; i < 100; i++) {

				waitABit(2000);
				String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]")).getText();
				System.out.println("Update Task Status : "+UpdatedTask);

				if (UpdatedTask.contains("1 - 6 of 6 items")) {

					waitABit(2000);
					break;

				} else {

					waitABit(30000);
					getDriver().navigate().refresh();
					WaitForPageToLoad(60);

				}

				System.out.println("5th and 6th Task Generated");
				customwaitforpageloading(swiftpage);
			}
		}
		catch (Exception e) {
			System.out.println(e);	
		} 

	}

	@Step 
	public void i_should_validate_and_complete_waiting_for_Downstream_system_task_in_metastorm(String ENV)
	{
		//Validating and completing Waiting for downstream Task (6th Row).
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_sixth_task_Row));
		swiftcustomerpage.lbl_sixth_task_Row.click();

		for (int i = 0; i < 7; i++) {

			String SixthTask = getDriver().findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[7]/td[4]/span")).getText();

			System.out.println("Sixth Task Status : "+SixthTask);
			//if we are using existing order, then take the initiated order from the xpath.

			if (SixthTask.contains("Ready")) {
				System.out.println("Switching to MetaStorm since third task is ready status but its system task cant complete so switching to Mentastorm :");

				//getDriver().close();

				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

				if (ENV.contains("1")) {
					metastormpage.openAt(Container6.getFieldValue("ITV1"));
				}
				if (ENV.contains("2")) {
					metastormpage.openAt(Container6.getFieldValue("ITV2"));
				}
				if (ENV.contains("4")) {
					metastormpage.openAt(Container6.getFieldValue("ITV4"));
				}

				WaitForPageToLoad(100);
				metastormpage.maximize();
				waitABit(5000);	//auto login wait
				System.out.println("MetaStorm Page is Loaded");
				System.out.println("Current URL : "+getDriver().getCurrentUrl());
				customClickableWait(metastormpage.btn_watch_list);
				metastormpage.btn_watch_list.click();
				waitABit(3000);
				customClickableWait(metastormpage.ddl_process);
				metastormpage.ddl_process.click();
				waitABit(5000);
				customClickableWait(metastormpage.ddl_process_OP_Install);
				metastormpage.ddl_process_OP_Install.click();
				waitABit(5000);
				customClickableWait(metastormpage.ddl_stage);
				metastormpage.ddl_stage.click();
				waitABit(5000);
				customClickableWait(metastormpage.ddl_Wait_for_downstream);
				metastormpage.ddl_Wait_for_downstream.click();
				waitABit(5000);
				metastormpage.btn_Update_Click.click();
				waitABit(5000);
				metastormpage.btn_Update_Click.click();
				waitABit(5000);

				String parent=getDriver().getWindowHandle();

				System.out.println("Sess Value for Xpath is : "+sess);
				metastormpage.metastorm(sess).click();
				waitABit(10000);

				java.util.Set<String> child = getDriver().getWindowHandles(); 
				System.out.println("Size of the Window : "+child.size());
				child.remove(parent);

				getDriver().switchTo().window((String) child.toArray()[0]);
				getDriver().getTitle();
				getDriver().manage().window().maximize();

				try {

					List<WebElement> TaskList = getDriver().findElements(By.xpath("//span[contains(.,'ActivateOVTask')]"));

					for (int k = 0; k < TaskList.size(); k++) {
						waitABit(5000);
						if (TaskList.get(k).getText().contains("ActivateOVTask")) {
							waitABit(5000);
							System.out.println("ActivateOVTask Task Button Found");
							String parent1 = getDriver().getWindowHandle();
							TaskList.get(k).click();
							System.out.println("ActivateOVTask Clicked");
							waitABit(10000);

							Set<String> grandchild = getDriver().getWindowHandles();
							System.out.println("Size of the Window : "+grandchild.size());
							getDriver().switchTo().activeElement().sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER);
							waitABit(2000);				
							System.out.println("Metastorm Task Performed");
							getDriver().switchTo().window(parent);
							waitABit(1000);
							//getDriver().close();

						}
					}
				}

				catch (Exception e) {

					System.out.println("Catched Exception : "+e.getMessage());
				}
				finally {
					System.out.println("ActivateOVTask' Task Done");
				}				

				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

				if (ENV.contains("1")) {
					swiftpage.openAt(Container3.getFieldValue("ITV1"));
				}
				if (ENV.contains("2")) {
					swiftpage.openAt(Container3.getFieldValue("ITV2"));
				}
				if (ENV.contains("4")) {
					swiftpage.openAt(Container3.getFieldValue("ITV4"));
				}

				WaitForPageToLoad(80);
				System.out.println("Swift Page Launched Again");
				swiftpage.maximize();
				WaitForPageToLoad(5);  // wait for auto log in
				//swiftpage.tbx_order_id_field.clear();
				//swiftpage.tbx_order_id_field.sendKeys(orderpackageid + Keys.ENTER);
				swiftpage.btn_OrderId_Search_Button.click();

				WaitForPageToLoad(60); 
				getDriver().navigate().refresh();
				customClickableWait(swiftcustomerpage.lbl_sixth_task_Row);

			} 
		}		

	}

	@Step 
	public void i_should_validate_and_complete_Order_Validation_task()
	{
		//Validating and completing Waiting for downstream Task (6th Row).
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lnk_OV_Task_fifth_row));
		swiftcustomerpage.lnk_OV_Task_fifth_row.click();

		System.out.println("Updating NDD & CRD");	
		customClickableWait(swiftpage.btn_product_packages);
		customwaitforpageloading(swiftpage);
		swiftpage.btn_product_packages.waitUntilClickable().click();
		waitABit(3000);

		System.out.println("Impersonating");
		customClickableWait(swiftpage.btn_userinfo);
		swiftpage.btn_userinfo.click();
		waitABit(5000);
		getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']")).clear();
		waitABit(2000);
		getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']")).sendKeys("K R, Mangalagowri");
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(2000);
		swiftpage.btn_impersonate.click();
		customwaitforpageloading(swiftpage);
		System.out.println("Impersonated to a User");

		System.out.println("Before Click on check box");
		WebElement checkbox5 = getDriver().findElement(By.id("cbHeader"));
		JavascriptExecutor js5 = ((JavascriptExecutor) getDriver());
		js5.executeScript("arguments[0].click();", checkbox5);


		System.out.println("After clicking on Check box");
		customClickableWait(swiftpage.btn_edit_dates);
		swiftpage.btn_edit_dates.click();

		waitABit(1000);
		swiftpage.tbx_requested_date.clear();
		waitABit(1000);
		swiftpage.tbx_requested_date.sendKeys(RegressionSteps.getDate());
		waitABit(2000);
		swiftpage.btn_save_dates.click();
		customwaitforpageloading(swiftpage);
		System.out.println("NDD & CRD Updated");

		//Click on Open TDG Button 
		swiftcustomerpage.btn_TDG_Open.click();
		customwaitforpageloading(swiftpage);
		waitABit(10000);
		setParentHandle();
		setChildHandle();
		switchToChildWindow();
		waitABit(30000);
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(120)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Edit_Button));
		swiftcustomerpage.btn_Edit_Button.click();
		waitABit(30000);
		swiftcustomerpage.btn_TDG_Save.click();
		switchToParentWindow();
		waitABit(10000);

		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lnk_OV_Task_fifth_row));
		swiftcustomerpage.lnk_OV_Task_fifth_row.click();

		//Click on Validate Button.
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Validate));
		swiftcustomerpage.btn_Validate.click();
		waitABit(1000);

		//Click on OK Button in Validation result alert box.
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Ok_Button));
		swiftcustomerpage.btn_Ok_Button.click();

		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_OV_Task_SFDC));

		//if the task name is Order Validation 
		//get the assigned name value of the Order Validation  task 
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_Assigned_name5));
		String Assignedname5 = swiftcustomerpage.lbl_Assigned_name5.getText().toLowerCase();
		System.out.println("Assigned name 5 : " + Assignedname5);

		//if the assigned name is not equal to current user 
		//impersonateuser("Nunna, Madhav");
		swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(swiftHomePage.lbl_imp_user));
		String CurrentUser3 = swiftHomePage.lbl_imp_user.getText().toLowerCase();
		System.out.println("Current User 2 : " + CurrentUser3);
		if(!swiftHomePage.lbl_imp_user.getText().toLowerCase().contains(Assignedname5.toLowerCase()))
		{
			// Impersonate the user 
			impersonateuser(Assignedname5);

		}

		//Click on Complete Button.
		swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(120)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Complete));
		swiftcustomerpage.btn_Complete.click();
		waitABit(20000);
		System.out.println("5nd Task Completed");

		String Packg_Status1 = getDriver().findElement(By.xpath("//span[@id='OrderPackageStatusLbl']")).getText();
		System.out.println("Package Status : "+Packg_Status1);

		try {

			for (int i = 0; i < 100; i++) {

				waitABit(2000);
				String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]")).getText();
				System.out.println("Update Task Status : "+UpdatedTask);

				if (UpdatedTask.contains("1 - 7 of 7 items")) {

					waitABit(2000);
					break;

				} else {

					waitABit(30000);
					getDriver().navigate().refresh();
					WaitForPageToLoad(60);

				}

				System.out.println("7th Task Generated");
				customwaitforpageloading(swiftpage);
			}
		}
		catch (Exception e) {
			System.out.println(e);	
		} 

		try {

			for (int i = 0; i < 100; i++) {

				waitABit(2000);
				String UpdatedStatus = getDriver().findElement(By.xpath("//span[contains(@id,'OrderPackageStatusLbl')]")).getText();
				System.out.println("Update Package Status : "+UpdatedStatus);

				if (UpdatedStatus.contains("Ordered")) {
					System.out.println("DIA Product is Routed to BPMS DownStream!!");
					waitABit(2000);
					break;

				} else {

					waitABit(30000);
					getDriver().navigate().refresh();
					WaitForPageToLoad(60);

				}

				System.out.println("DIA Product is NOT YET Routed to BPMS DownStream!!");
				customwaitforpageloading(swiftpage);
			}
		}
		catch (Exception e) {
			System.out.println(e);	
		} 

	}

	@Step 
	public void i_should_validate_customer_as_for_Authorised_user(String CustName)
	{
		String AuthCustName = swiftHomePage.lbl_Cust_Name.getText().toLowerCase();
		System.out.println(" Authorised Customer name is : " + CustName + ", And Auth customer name in UI is : " + AuthCustName);
		assertThat("It ia not an Authorized Customer account", (swiftHomePage.lbl_Cust_Name.getText().toLowerCase()).contains(CustName.toLowerCase()));

	}

	@Step 
	public Map<String, String> createConfigKeyValuePair(String entries) throws Exception {

		String[] attributes =  entries.split(";");
		Map<String, String> map = new HashMap<String, String>();
		for (String entry : attributes) {
			if (!TextUtils.isEmpty(entry) && entry.contains(":")) {
				String[] keyValue = entry.split(":");
				map.put(keyValue[0], keyValue[1]);
			}
		}

		return map;
	}

	@Step 
	public void user_creates_the_new_order_package()
	{
		try {
			customwaitforpageloading(swiftpage);  
			swiftpage.btn_create_new_package.click();
			waitABit(2000);

			String url2 = getDriver().getCurrentUrl();
			System.out.println("Current URL : "+url2);

			System.out.println("Selecting Acount");
			swiftpage.btn_select_account.click();
			waitABit(2000);
			swiftpage.tbx_account.sendKeys("750101");
			waitABit(2000);		
			System.out.println("Account Number Entered");
			swiftpage.btn_search_account.click();
			waitABit(8000);
			System.out.println("Clicked on Search");
			swiftpage.lnk_select_account.click();
			waitABit(2000);
			System.out.println("Account Selected");
			waitABit(2000);

			WebDriverWait wait = new WebDriverWait(getDriver(), 30);
			WebElement ok = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@ng-click='AccountManagementSearchOkClick()'])[1]")));

			JavascriptExecutor js = (JavascriptExecutor)getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);arguments[0].click()", ok);


			//	swiftpage.btn_ok_account.click();
			waitABit(2000);
			System.out.println("Ok Clicked");
			swiftpage.btn_select_office.click();
			waitABit(2000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
			System.out.println("Office Selected");
			waitABit(2000);
			swiftpage.btn_select_product_type.click();
			waitABit(2000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			waitABit(2000);
			swiftpage.btn_order_package.click();

			String ur3 = getDriver().getCurrentUrl();
			System.out.println("Current URL : "+ur3);
			waitABit(2000);
			System.out.println("Product Type Selected");


			WebElement save = getDriver().findElement(By.id("SaveNewOrderPackageButton"));

			JavascriptExecutor js0 = (JavascriptExecutor)getDriver();
			js0.executeScript("arguments[0].scrollIntoView(true);arguments[0].click()", save);



			waitABit(15000);
			String ur4 = getDriver().getCurrentUrl();
			System.out.println("Current URL : "+ur4);

			try {

				for (int i = 0; i < 5; i++) {

					if (save.isDisplayed()) {

						System.out.println("Failed to Click on Save");
						waitABit(2000);
						swiftpage.btn_save_package.click();
						waitABit(15000);
						String ur5 = getDriver().getCurrentUrl();
						System.out.println("Current URL : "+ur5);

					} else {

						break;
					}

				}

			} catch (Exception e) {
				System.out.println(e);
			}

			customwaitforpageloading(swiftpage);  
			System.out.println("New Order Package Created");
			waitABit(5000);
			String ur6 = getDriver().getCurrentUrl();
			System.out.println("Current URL : "+ur6);
		}
		catch (Exception e) {
			Assert.fail(e);
		}
	}

	@Step 
	public void user_validates_order_package_created_by_searching_for_order_package_ID()
	{
		try {
		orderpackageid = getDriver().findElement(By.xpath("//div[@class='k-link']/span[1]")).getText();
		System.out.println("Order Package ID = " + orderpackageid);

		Serenity.setSessionVariable("orderpackageid").to(orderpackageid);
		sess = Serenity.sessionVariableCalled("orderpackageid");
		waitABit(3000);

		swiftpage.ddl_order.click();
		waitABit(2000);
		swiftpage.ddl_order_id.click();
		waitABit(2000);
		swiftpage.tbx_order_id_field.clear();
		waitABit(1000);
		swiftpage.tbx_order_id_field.sendKeys(orderpackageid + Keys.ENTER);


		for (int i = 0; i < 500; i++) {

			String	ispackageavailable = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]")).getText(); 

			if (ispackageavailable.contains("1 - 1 of 1 items")) {
				System.out.println("Order Package Available");
				break;
			}

			else {

				System.out.println("Order Package not Available, Retrying");
				waitABit(3000);
				swiftpage.btn_search.click();	
				customwaitforpageloading(swiftpage);
			}
		}
		}
		catch (Exception e) {
			Assert.fail(e);
		}


	}

	@Step 
	public void user_search_and_select_the_following_CLLI_and_Product(String clli, String product)
	{
		try {
			customwaitforpageloading(swiftpage); 
			customClickableWait(swiftpage.btn_product_packages);
			swiftpage.btn_product_packages.click();
			waitABit(2000);
			swiftpage.btn_add_psp.click();
			waitABit(2000);
			customwaitforpageloading(swiftpage);
			swiftpage.tbx_clli_search.sendKeys(clli + Keys.TAB);
			waitABit(3000);
			customwaitforpageloading(swiftpage);
			swiftpage.btn_clli_search.click();
			waitABit(2000);
			customwaitforpageloading(swiftpage);
			waitABit(2000);
			WebElement checkbox = getDriver().findElement(By.xpath("(//input[contains(@name,'Floor')])[1]"));

			JavascriptExecutor js = ((JavascriptExecutor) getDriver());
			js.executeScript("arguments[0].click();", checkbox);				
			waitABit(3000);
			swiftpage.btn_next.click();
			waitABit(2000);
			swiftpage.btn_new_product_package.click();
			customwaitforpageloading(swiftpage);
			swiftpage.ddl_select_product.click();
			getDriver().findElement(By.xpath("(//li[@tabindex='-1'][contains(.,'"+product.trim()+"')])[1]")).click();;
			waitABit(3000);
			customwaitforpageloading(swiftpage);
			customwaitforpageloading(swiftpage);
			swiftpage.ddl_select_address.click();
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().findElement(By.xpath("//span[contains(.,'= Required Information')]")).click();
		}
		catch (Exception e) {
			Assert.fail(e);
		}
	}
	
	@Step
	public void user_configures_and_saves_the_product(String attributeList)
	{
		try {
			
			Map<String, String> configKeyValuePair = new HashMap<String, String>();
			configKeyValuePair = createConfigKeyValuePair(attributeList);
			customwaitforpageloading(swiftpage);
			String[] attributes =  attributeList.split(";");
			WaitForPageToLoad(5000);

			for(int i=0;i<attributes.length;i++){
				String[] keyValuePair =  attributes[i].split(":");
				String key = keyValuePair[0];
				String value = keyValuePair[1];
				WaitForPageToLoad(6000);	
				getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				//Selecting Circuit Type 
				if(key.equals("Circuit_Type")) {
					customwaitforpageloading(swiftpage);
					swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(40)).waitFor(ExpectedConditions.elementToBeClickable(swiftorderpackagepage.lbl_Circuit_Type));
					swiftorderpackagepage.lbl_Circuit_Type.click();
					waitABit(2000);
					//	getDriver().findElement(By.xpath("//select[@id='paList3']/option[.='"+value+"']")).click();
					getDriver().switchTo().activeElement().sendKeys(value, Keys.ENTER);
					System.out.println("Circuit type is selected,,,,,,,,,!!!!!");
					waitABit(3000);
				}
				// Selecting Inside Wiring Type
				else if(key.equals("InsideWiring")) {
					waitABit(2000);
					customwaitforpageloading(swiftpage);
					swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftorderpackagepage.lbl_inside_wiring));
					swiftorderpackagepage.lbl_inside_wiring.click();
					getDriver().switchTo().activeElement().sendKeys(value, Keys.ENTER);
					System.out.println("Inside wiring type is selected,,,,,,,,,!!!!!");
					waitABit(4000);
				}
				// Selecting Port Type
				else if(key.equals("Port_Type")) {
					waitABit(2000);
					customwaitforpageloading(swiftpage);
					swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftorderpackagepage.lbl_Port_Type));
					swiftorderpackagepage.lbl_Port_Type.click();
					getDriver().switchTo().activeElement().sendKeys(value, Keys.ENTER);
					System.out.println("port type is selected,,,,,,,,,!!!!!");
				}
			}
			waitABit(2000);
			if(!swiftpage.btn_next_2.isEnabled()) {
				customwaitforpageloading(swiftpage);
				swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftorderpackagepage.lbl_RouterPOP));
				swiftorderpackagepage.lbl_RouterPOP.click();
				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN, Keys.ENTER);
				System.out.println("Router POP is selected,,,,,,,,,!!!!!");
			}
			waitABit(3000);	
			customwaitforpageloading(swiftpage);
			swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftpage.btn_next_2));
			swiftpage.btn_next_2.click();
			customwaitforpageloading(swiftpage);
			waitABit(2000);
			swiftpage.btn_next.click();
			customwaitforpageloading(swiftpage);
			waitABit(2000);
			swiftpage.btn_save.click();
			customwaitforpageloading(swiftpage);		
			waitABit(5000);
			System.out.println("*********A End product Configured**********");
		} 
		
		catch (Exception e) {
			Assert.fail(e);
		}
	}
	
	@Step
	public void user_updates_the_order_details_and_dates(String order_type)
	{
		try {
			customwaitforpageloading(swiftpage);
			customClickableWait(swiftpage.btn_order_details);
			swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(120)).waitFor(ExpectedConditions.elementToBeClickable(swiftpage.btn_order_details));
			swiftpage.btn_order_details.click();
			waitABit(2000); 
			ExpectedConditions.visibilityOf(swiftpage.order_type_dropdown);
			swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftpage.ddl_select_order_type));
			swiftpage.ddl_select_order_type.click();
			getDriver().switchTo().activeElement().sendKeys(order_type,Keys.ENTER);
			waitABit(2000);
			customwaitforpageloading(swiftpage);
			swiftpage.ddl_CCM_select.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
			waitABit(2000);
			swiftpage.ddl_OES_select.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
			waitABit(2000);
			swiftpage.ddl_NAE_select.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
			waitABit(3000);
			swiftpage.btn_top_save.click();
			System.out.println("Updating NDD & CRD");	
			customClickableWait(swiftpage.btn_product_packages);
			customwaitforpageloading(swiftpage);
			swiftpage.btn_product_packages.waitUntilClickable().click();
			System.out.println("Before Click on check box");
			WebElement checkbox5 = getDriver().findElement(By.id("cbHeader"));
			JavascriptExecutor js5 = ((JavascriptExecutor) getDriver());
			js5.executeScript("arguments[0].click();", checkbox5);
			System.out.println("After clicking on Check box");
			customClickableWait(swiftpage.btn_edit_dates);
			swiftpage.btn_edit_dates.click();
			waitABit(1000);
			swiftpage.tbx_requested_date.clear();
			waitABit(1000);
			swiftpage.tbx_requested_date.sendKeys(RegressionSteps.getDate());
			waitABit(2000);
			swiftpage.btn_save_dates.click();
			customwaitforpageloading(swiftpage);
			System.out.println("NDD & CRD Updated");
			
		} catch (Exception e) {
			Assert.fail(e);
		}
	}
}











