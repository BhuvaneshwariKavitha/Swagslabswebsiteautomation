package Pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class dashboardobjects {

	 @FindBy(id= "react-burger-menu-btn")
	 public static WebElement menubutton;
	 
	 @FindBy(id= "inventory_sidebar_link")
	 public static WebElement allitem;
	 
	 @FindBy(id= "about_sidebar_link")
	 public static WebElement about;
	 
	 @FindBy(id= "logout_sidebar_link")
	 public static WebElement logout;
	 
	 @FindBy(id= "reset_sidebar_link")
	 public static WebElement Reset;
	 
	
	
	
	
	
	
	
	
}
