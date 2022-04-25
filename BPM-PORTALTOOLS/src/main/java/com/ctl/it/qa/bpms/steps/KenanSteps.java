package com.ctl.it.qa.bpms.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.staf.Steps;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

@SuppressWarnings("serial")
public class KenanSteps extends Steps{

	private final Logger slf4jLogger = LoggerFactory.getLogger(KenanSteps.class);
	
	@Step
	public  void loginIntoKenan() throws InterruptedException{
		try {
			WebDriver driver = getDriver();
			slf4jLogger.info("Loggin into Kenan");
			
			driver.get(envData.getFieldValue("Kenan_url"));
			driver.manage().window().maximize();
			WaitForPageToLoad(5000);
			WaitForPageToLoad(5000);
			Thread.sleep(5000);	
		}
		catch (Exception e) {
			slf4jLogger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	@Step
	public  void VerifyCustOrderIdInfo(String Id) throws InterruptedException{
		try {
			WebDriver driver = getDriver();
			slf4jLogger.info("Verify Cust order Id Info from Kenan Billing");
			
			Wait<WebDriver> wait = new WebDriverWait(driver, 10000);
			
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='tvUserApplicationn1']/img"))));
			driver.findElement(By.xpath("//*[@id='tvUserApplicationn1']/img")).click();
			WaitForPageToLoad(5000);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='tvUserApplicationt8']"))));
			driver.findElement(By.xpath("//*[@id='tvUserApplicationt8']")).click();
			WaitForPageToLoad(5000);
			WaitForPageToLoad(5000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frmContent']")));
			WaitForPageToLoad(5000);
			
			Select s = new Select(driver.findElement(By.xpath("/html/body/form/div[1]/table/tbody/tr[1]/td[2]/select")));
			s.selectByIndex(0);
			//*[@id='Textbox_CustOrderID']
			driver.findElement(By.xpath("/html/body/form/div[1]/table/tbody/tr[4]/td[4]/input")).sendKeys(Id);;
			
			Select s1 = new Select(driver.findElement(By.xpath("/html/body/form/div[1]/table/tbody/tr[1]/td[4]/select")));
			s1.selectByIndex(0);
			WaitForPageToLoad(5000);
			Thread.sleep(5000);	
			
			driver.findElement(By.xpath("/html/body/form/div[1]/table/tbody/tr[1]/td[5]/input")).click();
			WaitForPageToLoad(5000);
			WaitForPageToLoad(5000);
		}
		catch (Exception e) {
			slf4jLogger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
		

}
