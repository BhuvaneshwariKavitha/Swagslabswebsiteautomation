package Testcases;

import java.io.IOException;
import java.security.PublicKey;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Commonfunctions.commonfunction;
import Pageobjectmodel.productspageobj;

public class Addtocartfunction extends commonfunction {
	
	productselction PS = new productselction();
	
    @Test
	public void addtocartfunctionality() throws IOException
	{
    	PageFactory.initElements(driver,productspageobj.class);
		PS.products();
		productspageobj.addtocart.click(); //will add to cart the selected product.
		System.out.println("PRODUCT ADDED TO CART");
		  driver.navigate().back();
			
	 }
	
    @Test
    public void remove() {
   
    	WebElement Rem = productspageobj.Removefromcart;
	    if(Rem.isDisplayed()) {
		Rem.click();
	    System.out.println("Product removed from cart");//will remove the products if selected;
		}else {
   	 
   	 System.out.println("Your Cart is empty!! Make a selection ");
 		
   	 
    }
    
 }
	
  
    
    
    
}
