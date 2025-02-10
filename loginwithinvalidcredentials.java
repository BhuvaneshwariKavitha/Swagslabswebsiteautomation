package Testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Commonfunctions.commonfunction;
import Pageobjectmodel.loginpageobj;
import org.openqa.selenium.OutputType;
import  org.openqa.selenium.TakesScreenshot;


public class loginwithinvalidcredentials extends commonfunction {

	
	
	@Test
	public void invalilogin_attempt() throws IOException
	
	{
	   
		PageFactory.initElements(driver, loginpageobj.class);
		loginpageobj.login.sendKeys("locked_out_user");
		loginpageobj.password.sendKeys("sertiooui");
		loginpageobj.loginbutton.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
		
		String currenturl= driver.getCurrentUrl();
		if(currenturl.matches("https://www.saucedemo.com/inventory.html")) {
			
			System.out.println("login with invalid credentials has been successfull");
		}
		else
		{
			WebElement error = driver.findElement(By.xpath("//*[contains(text(),'Epic sadface:')]"));
			String errormessage = error.getText();
			System.out.println("error occured" + " " + errormessage);
		}
		
		  captureScreenshot();
	}

	
	
	
	
	
	
}
