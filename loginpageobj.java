package Pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class loginpageobj {
	
@FindBy(id ="user-name")
 public static WebElement login;
 
 @FindBy(id = "password")
 public static WebElement password;
 
 @FindBy(id="login-button")
 public static WebElement loginbutton;
 
 @FindBy(xpath= "//*[contains(text(),'Epic sadface:')]")
 public static WebElement error;
 
 public loginpageobj(WebDriver driver) {
	    
	    PageFactory.initElements(driver, this);  // Initialize WebElements
	}

}
 
 








