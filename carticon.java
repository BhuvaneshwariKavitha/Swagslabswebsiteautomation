package Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Commonfunctions.commonfunction;
import Pageobjectmodel.productspageobj;



public class carticon extends commonfunction {
	
Multiselections AC = new Multiselections();

loginfunctionality_withvalidcredentials LOS = new loginfunctionality_withvalidcredentials();
@Test
public void addtocartbadge() throws IOException {
	
	PageFactory.initElements(driver, productspageobj.class);
	 AC.Productmultiselection();
	 
	 
	String ICON =  productspageobj.Cartbadgefunction.getText().trim();
	productspageobj.Cartfunction.click();
	
	int badgecountbefore_refersh = Integer.parseInt(ICON);
	 
     if(ICON.isEmpty()|| ICON.equalsIgnoreCase("0")) {
		
		System.out.println("Your cart is empty!!");
		
		
	}else {
		
		System.out.println("cart badgecount" + badgecountbefore_refersh);
		
	}
     driver.navigate().refresh(); //refershing the page 
     
     String after_refresh = productspageobj.Cartbadgefunction.getText().trim();
 	
		int badgecountafter_refresh =Integer.parseInt(after_refresh);
		
		 Assert.assertEquals(badgecountbefore_refersh, badgecountafter_refresh," Count not remains same");
		  
   List<WebElement> items =  driver.findElements(By.className("inventory_item_name"));
 
     int elements = items.size();
   
     System.out.println("Number of products added to cart : " + elements);
     
  
     Assert.assertEquals(elements, badgecountafter_refresh," Count mismatch ");
    
	 }
	    
	
	
}
	
	
	


