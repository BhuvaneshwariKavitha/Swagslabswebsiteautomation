package Testcases;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Commonfunctions.commonfunction;
import Pageobjectmodel.productspageobj;

public class checkoutfunction extends commonfunction{
	
Addtocartfunction ac = new Addtocartfunction();
Multiselections MS = new Multiselections();

	@Test
	public void checkoutpage() throws IOException
	
	{
		//ac.addtocartfunctionality(); //load cart method
		MS.Productmultiselection();
		PageFactory.initElements(driver, productspageobj.class);
		productspageobj.Cartfunction.click();
		String addedproducts = productspageobj.Cartbadgefunction.getText();//get num of products in cart icon
		System.out.println( "Number of products user added in cart: " + addedproducts); 
		int cartcount = addedproducts.isEmpty()?0:Integer.parseInt(addedproducts);// check the text and converts it into interger.
		//This is a ternary operator (shorthand for an if-else condition).
           //convert addedproducts  from a string to an integer using Integer.parseInt(cartCountText).

		List<WebElement> cartproducts = driver.findElements(By.className("cart_item")); //get values of cart products 
		int cartitem = cartproducts.size();
		System.out.println( "Number of products in checkout page: " + cartitem); 
		
		if(cartcount == cartitem) {
			
			System.out.println("The cartcount and cartitems are equal!!");
			
		}else {
			
			System.out.println("The cartcount and cartitems are not equal!!");
			
			
		}
	      System.out.println("Proceed to checkout for listed products");
	     System.out.println("Do You want to remove any products from the list?:");
		
		System.out.println("--------------------------------------------------------");
		System.out.println("PRODUCT DETAILS");
		
		List<WebElement> productname = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> description = driver.findElements(By.className("inventory_item_desc"));
		List<WebElement> price = driver.findElements(By.className("inventory_item_price"));
		List<WebElement> productquan =driver.findElements(By.className("cart_quantity"));

    for(int i = 0; i < productname.size();i++) //starts looping until productname presents in webpage; 
    {
	 
	   String proname = productname.get(i).getText(); 
	   String prodes = description.get(i).getText();    //get the values of i
	   String proprice = price.get(i).getText();
	   String proquan = productquan.get(i).getText();
	   System.out.println("Product " + (i + 1) + ": " + proname);
       System.out.println("Description: " + prodes);
       System.out.println("price" + proprice);
       System.out.println("quantity" + proquan);
       System.out.println("--------------------------------------------------------------");
   
    }
   
    Scanner scan = new Scanner(System.in);
    System.out.println("Do You want to remove any products from the list?:");
    String response = scan.nextLine();
    if(response.equalsIgnoreCase("Yes")) {
    	 System.out.println("Enter product name to remove:");
    	 String productstoremove = scan.nextLine(); //gets the user input to remove
    	 System.out.println("Entered product :" + productstoremove);
    	 for(int i = 0; i <productname.size();i++) {//iterates the products in cart 
    		 String productoncart = productname.get(i).getText();
    		 if(productoncart.equalsIgnoreCase(productstoremove)) {
    			 
    			 WebElement remove = driver.findElement(By.xpath("//button[text()='Remove']"));
    	    	 remove.click();
    	    		 System.out.println("product removed!");
    			 
    		 }else {
    			 
    			 System.out.println("the entered product not added in cart!!");
    		 }
    			}
    	 
     }
    
    else if(response.equalsIgnoreCase("NO")) {
    	
    	System.out.println("Enter preferance : 'continue shopping ' or 'Checkout'"); 
    	    
    }
    
   
	
     String preferance =  scan.nextLine();//gets user's preferance
    System.out.println(preferance);
    if(preferance.equalsIgnoreCase("continue shopping")) {
    	
    	 productspageobj.continueshoppingbutton.click();
    	 System.out.println("navigated to product dashboard");
   	  
    }
    
    else if(preferance.equalsIgnoreCase("checkout"))
    	
      productspageobj.checkout.click();
      System.out.println("navigated to checkout page");
 	  System.out.println("--------------------------------------------------------------");
      
    }
    
	  					
	   
	}
		
		
	
	
	
	
	
	
	
	
	

