package Pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class productspageobj {


	
	@FindBy(xpath="//a[contains(@id, 'title_link')]")
	public static WebElement productsname;
	
	@FindBy(id="add-to-cart")
	public static WebElement addtocart;
	
	@FindBy(xpath="//button[text()='Remove']")
	public static WebElement Removefromcart;
	
	@FindBy(className = "product_sort_container")
	public static WebElement Filtericon;
	
	@FindBy(className = "shopping_cart_link")
	public static WebElement Cartfunction;
	
	@FindBy(css ="[data-test='shopping-cart-badge']")
	public static WebElement Cartbadgefunction;
	
	@FindBy(className = "cart_item")
	public static WebElement cartlist;
	
	@FindBy(id = "continue-shopping")
	public static WebElement continueshoppingbutton;
	
	@FindBy(id = "checkout")
	public static WebElement checkout;
	
	@FindBy(className = "summary_info_label")
	public static WebElement Paymentinfo;
	
	@FindBy(className = "summary_value_label")
	public static WebElement Paymentvalue;
	
	@FindBy(className = "summary_value_label")
	public static WebElement Subtotal;
	
	
	
	
	
}
