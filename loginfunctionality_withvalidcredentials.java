package Testcases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Commonfunctions.commonfunction;
import Pageobjectmodel.loginpageobj;


public class loginfunctionality_withvalidcredentials extends commonfunction{
	

	
	public static void verifylogin() throws IOException {
		System.out.println("success");
		PageFactory.initElements(driver, loginpageobj.class);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		loginpageobj.login.sendKeys("standard_user");
		loginpageobj.password.sendKeys("secret_sauce");
		loginpageobj.loginbutton.click();
		
		
		driver.manage().window().maximize();
		//driver.switchTo().alert().accept();


		
		}
	
	
	
	

}
