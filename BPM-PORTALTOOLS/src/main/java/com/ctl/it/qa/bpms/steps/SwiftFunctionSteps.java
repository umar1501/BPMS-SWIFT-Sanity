package com.ctl.it.qa.bpms.steps;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ctl.it.qa.bpms.pages.SwiftCustomerPage;
import com.ctl.it.qa.bpms.pages.SwiftHomePage;
import com.ctl.it.qa.bpms.pages.SwiftOrderPackagePage;
import com.ctl.it.qa.staf.Steps;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;



@SuppressWarnings({ "serial", "unused" })
public class SwiftFunctionSteps extends Steps {
	
	SwiftHomePage	swiftHomePage;
	SwiftCustomerPage swiftcustomerpage;
	SwiftOrderPackagePage swiftorderpackagepage;
	
	private static String orderId ;

    public static String getSwiftOrderId(){
        return SwiftFunctionSteps.orderId;
    }

    public static void setSwiftOrderId(String orderId){
    	SwiftFunctionSteps.orderId = orderId;
    }
	@Step
	public void impersonateuser(String user_id) {
		waitABit(1000);
		swiftHomePage.img_user_icon.click();
		swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(swiftHomePage.ddl_imp_user));
		swiftHomePage.tbx_imp_user.clear();
		swiftHomePage.tbx_imp_user.sendKeys(user_id);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(1000);
		swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(swiftHomePage.btn_imp_user));
		swiftHomePage.btn_imp_user.click();
		swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(swiftHomePage.lbl_imp_user));
		//assertThat("Impersonated user is not working", (swiftHomePage.lbl_imp_user.getText().toLowerCase()).contains(user_id.toLowerCase()));
	}
	
	@Step
	public void loadOPbyOPID(String dd_list, String OPID) {
		swiftHomePage.rbn_search_op.click();
		swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.elementToBeClickable(swiftHomePage.ddl_search_op));
		swiftHomePage.ddl_search_op.click();
		swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(swiftHomePage.lbl_search_list);
        for(WebElementFacade search_list : swiftHomePage.lbl_search_list) {
        	swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(search_list));
            if(search_list.getText().trim().equalsIgnoreCase(dd_list)) {
            	search_list.click();
                break;
            }
        }
		//search OrderPackage
        swiftHomePage.tbx_search_op.sendKeys(OPID);
        swiftHomePage.btn_seach_op.click();
//		//No records Found means Error else Pass
        swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.textToBePresentInElement(swiftHomePage.lbl_display_op, OPID));
        //swiftHomePage.lbl_display_op.getValue()
	}
	
	@SuppressWarnings("static-access")
	@Step
//	public void loadOPbyBOID(String dd_list, String BOID) {
//		QuoteDetailSteps quoteDetailSteps = new QuoteDetailSteps();
//		swiftHomePage.rbn_search_op.click();
//		swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.elementToBeClickable(swiftHomePage.ddl_search_op));
//		swiftHomePage.ddl_search_op.click();
//		swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(swiftHomePage.lbl_search_list);
//        for(WebElementFacade search_list : swiftHomePage.lbl_search_list) {
//        	swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(search_list));
//            if(search_list.getText().trim().equalsIgnoreCase(dd_list)) {
//            	search_list.click();
//                break;
//            }
//        }
//		//search OrderPackage
//        swiftHomePage.tbx_search_op.sendKeys(quoteDetailSteps.getboid());
//        swiftHomePage.btn_seach_op.click();
////		//No records Found means Error else Pass
//        swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.textToBePresentInElement(swiftHomePage.lbl_display_boid, BOID));
//        waitABit(3000);
//        //swiftHomePage.lbl_display_boid.getValue();
//        SwiftFunctionSteps.setSwiftOrderId(swiftHomePage.swift_orderId.getText());
//        
//	}
	
	
	public void i_navigate_to_swift_application_page_with_customer(String Account) throws InterruptedException 
	  {
		  swiftHomePage.lbl_customer.click();
		  System.out.println("Clicked on Customer list..");
		  swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(swiftHomePage.lbl_Cust_List);
		  for(WebElementFacade customer_ele : swiftHomePage.lbl_Cust_List) {
			  swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(customer_ele ));
		  if(customer_ele.getText().trim().equalsIgnoreCase(Account)) {
			  customer_ele.click();
		  break;
		  }
		  }
		
		  System.out.println("Clicked on koach customer..");
		  System.out.println("I Am in customer Page.");
		  swiftcustomerpage.btn_Create_new_order_package.click();
		  
	  }
	
	public void Verify_Account_info(String Sales_office, String ProductID) throws InterruptedException
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
			 
			 
	  }
	
	public void create_DIA_product(String Product, String Address) throws InterruptedException
	  {
	      
		  
		  
		  swiftorderpackagepage.btn_Product_Page.click();
		  swiftorderpackagepage.btn_Add_PSP.click();
		  
		  // Creating product in Create_new_product_package_page
		  
		  Actions actions = new Actions(getDriver()); 
		  swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.elementToBeClickable(swiftorderpackagepage.tbx_CLLI_ID));
		  
		  swiftorderpackagepage.tbx_CLLI_ID.sendKeys("WASHDCMT");
		  waitABit(1000);
		  //swiftorderpackagepage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.elementToBeClickable(swiftorderpackagepage.btn_Search));
		  
		  swiftorderpackagepage.btn_Search.click();
		  waitABit(20000);
		
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
		  
		  
	  }
	
	public void Validate_And_Complete_The_Order(String Order_Type, String CCM, String OES) throws InterruptedException
	  {
		  
		  //Click on Order type Drop down List.
		  waitABit(1000);
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
		 swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_Assigned_name1));
		 String Assignedname1 = swiftcustomerpage.lbl_Assigned_name1.getText().toLowerCase();
		 System.out.println("Assigned name : " + Assignedname1);
		  
		 //if the assigned name is not equal to current user 
		 //impersonateuser("Nunna, Madhav");
		 swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(swiftHomePage.lbl_imp_user));
		 String CurrentUser1 = swiftHomePage.lbl_imp_user.getText().toLowerCase();
		 System.out.println("Current User : " + CurrentUser1);
		 if(!swiftHomePage.lbl_imp_user.getText().toLowerCase().contains(Assignedname1.toLowerCase()))
		 {
			// Impersonate the user 
			 
			 
			 impersonateuser(Assignedname1);
			 
		 }
		  
	   //Select the POP task row
	     swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_POP_Row));
		 swiftcustomerpage.lbl_POP_Row.click();
		  
		//validate and complete.
		//Click on Validate Button.
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Validate));
		  swiftcustomerpage.btn_Validate.click();
		  waitABit(1000);
		  
		//Click on OK Button in Validation result alert box.
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Ok_Button));
		  swiftcustomerpage.btn_Ok_Button.click();
		  
		  
		  //Click on Complete Button.
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Complete));
		  swiftcustomerpage.btn_Complete.click();
		  waitABit(40000);
		  getDriver().navigate().refresh();
		  waitABit(30000);
		  
		// validating and completing Analyze/Adjust Task.
		  swiftcustomerpage.lbl_anasy_adst_Row.click();
		  
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
		  
		//validate and complete.
		//Click on Validate Button.
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Validate));
		  swiftcustomerpage.btn_Validate.click();
		  waitABit(1000);
			  
		//Click on OK Button in Validation result alert box.
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Ok_Button));
		  swiftcustomerpage.btn_Ok_Button.click();
		  
          swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_Ana_Adj_Task));
		  
		  //if the task name is pop 
		  //get the assigned name value of the pop task 
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_Assigned_name2));
		  String Assignedname2 = swiftcustomerpage.lbl_Assigned_name2.getText().toLowerCase();
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
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Complete));
		  swiftcustomerpage.btn_Complete.click();
		  waitABit(40000);
		  getDriver().navigate().refresh();
		  waitABit(50000);
		  getDriver().navigate().refresh();
		  waitABit(40000);
		  
		  //Adding contacts information in contact tab.
		  swiftcustomerpage.btn_Contacts_Tab.click();
		  waitABit(10000);
		  swiftcustomerpage.btn_Contact_Name_Tab.click();
		  waitABit(10000);
		  swiftcustomerpage.lbl_Contact_Name_sel.click();
		  swiftcustomerpage.btn_Contacts_Ok.click();
		  waitABit(1000);
		  swiftcustomerpage.lbl_Role_Tab.click();
		  swiftcustomerpage.lbl_Order_Contact_Chkbx.click();
		  swiftcustomerpage.lbl_Section_Tab.click();
		  waitABit(1000);
		  
		  getDriver().findElement(By.id("OrderPackage")).click();
		  getDriver().findElement(By.id("SL0000607753")).click();
		  getDriver().findElement(By.id("SL0000086590")).click();
		  waitABit(50000);
		  
		  swiftorderpackagepage.btn_Product_Page.click();
		  swiftcustomerpage.btn_Product_Arrow.click();
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_Prod_Nm_Row));
		  swiftcustomerpage.lbl_Prod_Nm_Row.click();
		  waitABit(1000);
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Set_Date));
		  swiftcustomerpage.btn_Set_Date.click();
		  swiftcustomerpage.tbx_Current_date_pick.sendKeys("8/11/2021");
		  swiftcustomerpage.btn_Valid_Date_Save.click();
		  waitABit(10000);
		  
		  //Click on Open TDG Button 
		  swiftcustomerpage.btn_TDG_Open.click();
		  waitABit(10000);
		  setParentHandle();
		  setChildHandle();
		  switchToChildWindow();
		  waitABit(10000);
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Edit_Button));
		  swiftcustomerpage.btn_Edit_Button.click();
		  waitABit(10000);
		  swiftcustomerpage.btn_TDG_Save.click();
		  
		  switchToParentWindow();
		  waitABit(10000);
		  
		 // swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Save_Changes));
		 // swiftcustomerpage.btn_Save_Changes.click();
		  
		  swiftcustomerpage.lbl_Order_val_Row.click();
		  
		  
		  
		//Click on Validate Button.
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Validate));
		  swiftcustomerpage.btn_Validate.click();
		  waitABit(1000);
			  
		//Click on OK Button in Validation result alert box.
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Ok_Button));
		  swiftcustomerpage.btn_Ok_Button.click();
		  
		  //swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.lbl_Assigned_name1));
		  WebElement Assign = getDriver().findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[5]/td[5]/span"));
		  String Assignedname3 = Assign.getText().toLowerCase();
			 
		  System.out.println("Assigned name 3 : " + Assignedname3);
			  
			 //if the assigned name is not equal to current user 
			 //impersonateuser("Nunna, Madhav");
		  swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(swiftHomePage.lbl_imp_user));
		  String CurrentUser3 = swiftHomePage.lbl_imp_user.getText().toLowerCase();
		  System.out.println("Current User 3 : " + CurrentUser3);
		  if(!swiftHomePage.lbl_imp_user.getText().toLowerCase().contains(Assignedname3.toLowerCase()))
		 {
				// Impersonate the user 
				 
				 
		    impersonateuser(Assignedname3);
				 
		 }
		//Click on Complete Button.
		  swiftcustomerpage.withTimeoutOf(Duration.ofSeconds(60)).waitFor(ExpectedConditions.elementToBeClickable(swiftcustomerpage.btn_Complete));
		  swiftcustomerpage.btn_Complete.click();
		  waitABit(40000);
		  getDriver().navigate().refresh();
		  waitABit(50000);
		  getDriver().navigate().refresh();
		  waitABit(40000);
		  getDriver().navigate().refresh();
		  waitABit(40000);
	  }
		  
	
}