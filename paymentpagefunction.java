package Testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Commonfunctions.commonfunction;
import Pageobjectmodel.checkoutpageobject;

public class paymentpagefunction extends commonfunction {
	
	checkoutinfofunctionality CF = new checkoutinfofunctionality();
	
   @Test
	public void paymentpage() throws IOException {
		
		CF.checkoutinformation();
		PageFactory.initElements(driver, checkoutpageobject.class);
		
		List<WebElement> itemspresent = driver.findElements(By.className("inventory_item_name"));
	    
	  for (WebElement webElement : itemspresent) {
		  
		  String itemsname = webElement.getText();
		 System.out.println("itotal items : " + itemsname ); // iterate every product name present in final page
		  }
	
	   int itemscount = itemspresent.size(); // count items no:
	   System.out.println("Total itemscount:" + itemscount);
	   
	   List<WebElement> itemsprice = driver.findElements(By.className("inventory_item_price"));
	   double totalPrice = 0.0;
	   for (WebElement webElement : itemsprice) {
		   
		   String price = webElement.getText().replace("$", "").trim(); //calculate the items total 
		   Double pricefinal = Double.parseDouble(price);
		   totalPrice += pricefinal;
		   }
	   
	     System.out.println("Total Price: $" + totalPrice);
	     
	     

	  WebElement priceonpage = driver.findElement(By.className("summary_subtotal_label"));
	  double priceonweb = 0.0;
	  String fi = priceonpage.getText().replace("Item total: $", "").trim();
	  System.out.println(fi); // gets the item total value listed below
	  Double finalprice = Double.parseDouble(fi);
	  priceonweb += finalprice;
	  System.out.println("Price on web: $" + priceonweb);
	     
	  
	  if(totalPrice==priceonweb) { // if both calculationa are equal this block will executed
		  
		  System.out.println("Both price are equal before adding tax amount");
		   WebElement info = driver.findElement(By.className("summary_info")); 
		   String infoaboutproducts = info.getText();
		   System.out.println("informaton about order: " + infoaboutproducts );
			
 } else {
	 
	 System.out.println("calculation glitch");
	 
 }
	   
   }
   
}
	  
	  	   
	
	
	
	
	
	
	
	

