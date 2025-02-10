package Pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkoutpageobject {

	
	@FindBy(id = "first-name")
	public static WebElement chFname;
	
	@FindBy(id = "last-name")
	public static WebElement chLname;
	
	@FindBy(id = "postal-code")
	public static WebElement chPostalcode;
	
	@FindBy(id = "continue")
	public static WebElement continueoption;
	
	@FindBy(id = "cancel")
	public static WebElement canceloption;
	
	
	@FindBy(id = "finish")
	public static WebElement Finish;
	
	@FindBy(className = "complete-header")
	public static WebElement message;
	
	@FindBy(className = "complete-text")
	public static WebElement message2;
	
   @FindBy(name = "back-to-products")
	public static WebElement BACKHOME;
	
	
	
	
	
	
}
