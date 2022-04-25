package com.ctl.it.qa.bpms.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.Steps;

import net.serenitybdd.core.pages.WebElementFacade;

public class BaseStep extends Steps {
	SwiftHomePage	swiftHomePage;
	public int count = 0;
	
	

	public void customClickableWait(WebElementFacade element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 500);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	
	public void customVisibleWaitism(WebElementFacade element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 150);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void customVisibleWaitBAN(WebElementFacade element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 150);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void customwaitforpageloading(Page page) {
	        page.withTimeoutOf(Duration.ofSeconds(800))
	                .waitForElementsToDisappear(org.openqa.selenium.By.xpath("//div[@class='k-loading-image']"));
	        System.out.println("Page Loading Circle is being Displayed");
	        waitABit(5000);
	    }
	 
	public void customwaitforpageloadingbilling(Page page) {
        page.withTimeoutOf(Duration.ofSeconds(800))
                .waitForElementsToDisappear(org.openqa.selenium.By.xpath("(//div[@class='popupBackground'])[1]"));
        System.out.println("Page Loading Circle is being Displayed");
        waitABit(5000);
    }
	
	public void customwaitforpageloadingipvpn(Page page) {
        page.withTimeoutOf(Duration.ofSeconds(300))
                .waitForElementsToDisappear(org.openqa.selenium.By.xpath("//div[@class='lds-ellipsis']"));
        System.out.println("Page Loading Circle is being Displayed");
        waitABit(5000);
    }
	
	
	public void customwaitforpageloadingism(Page page) {
        page.withTimeoutOf(Duration.ofSeconds(250))
                .waitForElementsToDisappear(org.openqa.selenium.By.xpath("(//div[contains(.,'Auto signing...')])[4]"));
        System.out.println("Page Loading Circle is being Displayed");
        waitABit(5000);
    }
 
	
	 public void customwaitforpageloadingasri(Page page) {
	        page.withTimeoutOf(Duration.ofSeconds(250))
	                .waitForElementsToDisappear(org.openqa.selenium.By.xpath("//button[@class='btn btn-primary'][contains(.,'Loading...')]"));
	        System.out.println("Page Loading Circle is being Displayed");
	        waitABit(5000);
	    }
	 
	//To import impersonate method from DIA_RegStep class. 
	 public void impersonateuser(String user_id) {
			waitABit(1000);
			swiftHomePage.img_user_icon.click();
			swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(swiftHomePage.ddl_imp_user));
			swiftHomePage.tbx_imp_user.clear();
			swiftHomePage.tbx_imp_user.sendKeys(user_id);
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
			waitABit(1000);
			swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(swiftHomePage.btn_imp_user));
			swiftHomePage.btn_imp_user.click();
			swiftHomePage.withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.visibilityOf(swiftHomePage.lbl_imp_user));
			//assertThat("Impersonated user is not working", (swiftHomePage.lbl_imp_user.getText().toLowerCase()).contains(user_id.toLowerCase()));
		}
	 
	 
	 
	 public boolean isalertpresent() {
		 boolean presentFlag = false;
		 
		 try {
			
			 WebDriverWait wait = new WebDriverWait(getDriver(), 30000);
			 if(wait.until(ExpectedConditions.alertIsPresent())==null){
				 System.out.println("Alert is Not Present");
			 }
			 else
			    {
				 Alert alert = getDriver().switchTo().alert();
				 alert.accept();
				 System.out.println("Alert was Present and Accepted");
				 presentFlag = true;
			    }
		 		} catch (NoAlertPresentException e) {
		 			e.printStackTrace();
			
		 		}
		 	return presentFlag;
	 	}
	 
	  
	 
	public void customVisibilityWait(WebElementFacade element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 120);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void customwaitforpageloading(){
		waitABit(20000);
	}
	
	
	public void  getserviceIconEnable(boolean isIconEnable , WebElementFacade iconElement )
	{
	while ( isIconEnable && count < 10) {
		waitABit(20000);
		iconElement.click();
		System.out.println("clicked on hierachy");
		count++;
	}
	
	}


}
