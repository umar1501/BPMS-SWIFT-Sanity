package com.ctl.it.qa.bpms.steps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctl.it.qa.bpms.pages.SwiftCustomerPage;
import com.ctl.it.qa.bpms.pages.SwiftHomePage;
import com.ctl.it.qa.bpms.pages.SwiftOrderPackagePage;
import com.ctl.it.qa.staf.Steps;

import net.serenitybdd.core.pages.WebElementFacade;


public class DIA_OrderUserStep extends Steps
{
	
	 SwiftHomePage swifthomepage;
	 SwiftCustomerPage swiftcustomerpage;
	 SwiftOrderPackagePage swiftorderpackagepage;
	 SwiftFunctionSteps swiftfunctionSteps;
	 
	 
	 	 
	 
	 public void WaitForVisibilityOf(WebElementFacade element){
	        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }
	 
	
	
	 // @Step
	/*  public void i_navigate_to_swift_application_page_with_customer(String Account) throws InterruptedException 
	  {
		  swifthomepage.lbl_customer.click();
		  System.out.println("Clicked on Customer list..");
		  swifthomepage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(swifthomepage.lbl_Cust_List);
		  for(WebElementFacade customer_ele : swifthomepage.lbl_Cust_List) {
	      swifthomepage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(customer_ele ));
		  if(customer_ele.getText().trim().equalsIgnoreCase(Account)) {
			  customer_ele.click();
		  break;
		  }
		  }
		
		  System.out.println("Clicked on koach customer..");
		  System.out.println("I Am in customer Page.");
		  swiftcustomerpage.btn_Create_new_order_package.click();
		  
	  }*/
	  
	 /* public void Verify_Account_info(String Sales_office, String ProductID) throws InterruptedException
	  {
		  //Selecting Account number.
		  swiftcustomerpage.lbl_Account.click();
		  System.out.println("Clicked on Account!!");
		 swiftcustomerpage.btn_search.click();
		 System.out.println("Clicked on Search!!");
		  
	     swiftcustomerpage.lbl_custAcc.click();
			 
		 swiftcustomerpage.btn_ok.click();
			 Thread.sleep(10000);
			 
			 //Selecting Sales office from Dropdown 
			 swiftcustomerpage.ddl_salesoffice.click();
			  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(swiftcustomerpage.lbl_salesoffice_List);
			  for(WebElementFacade sales_ele : swiftcustomerpage.lbl_salesoffice_List) {
			  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(sales_ele ));
			  if(sales_ele.getText().trim().equalsIgnoreCase(Sales_office)) {
				  sales_ele.click();
			  break;
			  }
			  }
			  
			  //Selecting Product Type.
			  swiftcustomerpage.ddl_product.click();
			  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(swiftcustomerpage.lbl_productlist);
			  for(WebElementFacade product_ele : swiftcustomerpage.lbl_productlist) {
			  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(product_ele ));
			  if(product_ele.getText().trim().equalsIgnoreCase(ProductID)) {
				  product_ele.click();
			  break;
			  }
			  }
			  
			  // Clicking on Save Button.
			  swiftcustomerpage.btn_saveneworder.click();
			  Thread.sleep(30000);
			  getDriver().navigate().refresh();
			 
			 
	  }*/

	
	  
	 /* public void create_DIA_product(String Product, String Address) throws InterruptedException
	  {
	      
		  
		  
		  swiftorderpackagepage.btn_Product_Page.click();
		  swiftorderpackagepage.btn_Add_PSP.click();
		  
		  // Creating product in Create_new_product_package_page
		  
		  Actions actions = new Actions(getDriver()); 
		  swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.elementToBeClickable(swiftorderpackagepage.tbx_CLLI_ID));
		  
		  swiftorderpackagepage.tbx_CLLI_ID.sendKeys("WASHDC89");
		  Thread.sleep(10000);
		  //swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.elementToBeClickable(swiftorderpackagepage.btn_Search));
		  
		  swiftorderpackagepage.btn_Search.click();
		  Thread.sleep(10000);
		
		  //Clicking on Address Checkbox.
		  WebElement checkbox = getDriver().findElement(By.xpath("//table[@role='grid']//tbody/tr[1]//label[@class='k-checkbox-label']"));
		  actions.moveToElement(checkbox).click().perform();
		  
		 // swiftorderpackagepage.cbx_Checkbox.click();		  
		  swiftorderpackagepage.btn_next.click();
		  swiftorderpackagepage.btn_Newpodpkg.click();
		  Thread.sleep(10000);
		  
		  // Selecting DIA product from Product Dropdown list.
		  swiftorderpackagepage.lbl_Product.click();
		  
		  swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(swiftorderpackagepage.lbl_Diaproductlist);
		  for(WebElementFacade Diaproduct_ele : swiftorderpackagepage.lbl_Diaproductlist) {
			  swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(Diaproduct_ele ));
		  if(Diaproduct_ele.getText().trim().equalsIgnoreCase(Product)) {
			  Diaproduct_ele.click();
		  break;
		  }
		  }
		  
		  Thread.sleep(10000);
		  //Selecting Address from Address Dropdown 
		  swiftorderpackagepage.lbl_address.click();
		  
		  swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(swiftorderpackagepage. lbl_AddSelect);
		  for(WebElementFacade addproduct_ele : swiftorderpackagepage. lbl_AddSelect) {
			  swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(addproduct_ele ));
		  if(addproduct_ele.getText().trim().equalsIgnoreCase(Address)) {
			  addproduct_ele.click();
			 System.out.println("Clicked on Address>>>>");
		  break;
		  }
		  }
		  
		 // IntDataContainer osData = get_data_for_page(swiftorderpackagepage).getContainer("DIA_Normal_Install");
		 // fillFields(swiftorderpackagepage, osData.getMandatoryFieldsFromAllContainers());
		  
		 // Selecting Circuit Type 
		  swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(40)).waitFor(ExpectedConditions.elementToBeClickable(swiftorderpackagepage.lbl_Circuit_Type));
		  swiftorderpackagepage.lbl_Circuit_Type.click();
		  getDriver().switchTo().activeElement().sendKeys("Fast E", Keys.ENTER);
		  System.out.println("Entered Circuit Type,,,,,,,,,!!!!!");
		  Thread.sleep(10000);
		  
		  // Selecting Port Type
		 swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftorderpackagepage.lbl_Port_Type));
		  swiftorderpackagepage.lbl_Port_Type.click();
		  getDriver().switchTo().activeElement().sendKeys("Flat Rate", Keys.ENTER);
		  Thread.sleep(30000);
		  
		  //Click on Next button.
		  swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftorderpackagepage.btn_next1));
		  swiftorderpackagepage.btn_next1.click();
		  Thread.sleep(10000);
		  
		  
		  //Click on Next Button.
		  swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftorderpackagepage.btn_next2));
		  swiftorderpackagepage.btn_next2.click();
		  Thread.sleep(10000);
		  
		  //Click on Save button.
		  swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftorderpackagepage.btn_Save));
		  swiftorderpackagepage.btn_Save.click();
		  Thread.sleep(40000);
		  
		  //Click on Order detail tab.
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Order_Detail_Tab));
		  swiftcustomerpage.btn_Order_Detail_Tab.click();
		  
		  
	  }*/
	  
	  /*public void Validate_And_Complete_The_Order(String Order_Type, String CCM, String OES) throws InterruptedException
	  {
		  
		  //Click on Order type Drop down List.
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.ddl_OrderType_arrow));
		  swiftcustomerpage.ddl_OrderType_arrow.click();
		  
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(swiftcustomerpage.lbl_OrderType_List);
		  for(WebElementFacade OrderType_ele : swiftcustomerpage.lbl_OrderType_List) {
			  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(OrderType_ele ));
		  if(OrderType_ele.getText().trim().equalsIgnoreCase(Order_Type)) {
			  OrderType_ele.click();
		  break;
		  }
		  }
		  
		  //Click on CCM Drop down List.
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.ddl_CCM_arrow));
		  swiftcustomerpage.ddl_CCM_arrow.click();
		  
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(swiftcustomerpage.lbl_CCM_List);
		  for(WebElementFacade CCM_ele : swiftcustomerpage.lbl_CCM_List) {
			  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(CCM_ele));
		  if(CCM_ele.getText().trim().equalsIgnoreCase(CCM)) {
			  CCM_ele.click();
		  break;
		  }
		  }
		  
		  //Click on OES Drop Down List.
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.ddl_OES_arrow));
		  swiftcustomerpage.ddl_OES_arrow.click();
		  
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(swiftcustomerpage.lbl_OES_List);
		  for(WebElementFacade OESList_ele : swiftcustomerpage.lbl_OES_List) {
			  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(OESList_ele));
		  if(OESList_ele.getText().trim().equalsIgnoreCase(OES)) {
			  OESList_ele.click();
		  break;
		  }
		  }
		  
		  //Click on Save Changes Button.
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Save_Changes));
		  swiftcustomerpage.btn_Save_Changes.click();
		  
		  System.out.println("AM Doing Validation And Completeing the Tasks !!!!!");
		  
		  //wait for POP task.
		 swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_POP_Task));
		  //if the task name is pop 
		  //get the assigned name value of the pop task 
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_Assigned_name));
		 String Assignedname = swiftcustomerpage.lbl_Assigned_name.getText().toLowerCase();
		 System.out.println("Given name" + Assignedname);
		  //if the assigned name is not equal to current user 
		 String CurrentUser = swiftcustomerpage.lbl_imp_user.getText().toLowerCase();
		 System.out.println("Current User : " + CurrentUser);
		 if(swiftcustomerpage.lbl_imp_user.getText().toLowerCase().contains(Assignedname.toLowerCase()))
		 {
			// Impersonate the user 
			 
			 swiftfunctionSteps.impersonateuser(Assignedname);
			 
		 }
		  
		  //Select the POP task row
		// swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_POP_Row));
		 swiftcustomerpage.lbl_POP_Row.click();
		  //validate and complete.
		  
		  //Click on Validate Button.
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Validate));
		  swiftcustomerpage.btn_Validate.click();
		  
		  //Click on OK Button in Validation result alert box.
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Ok_Button));
		  swiftcustomerpage.btn_Ok_Button.click();
		  
		  //Click on Complete Button.
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Complete));
		  swiftcustomerpage.btn_Complete.click();
		  Thread.sleep(40000);
		  getDriver().navigate().refresh();
		  Thread.sleep(30000);
		 
		  
	  }*/
		  
	  
	  	  
}
		  
	  


	  

