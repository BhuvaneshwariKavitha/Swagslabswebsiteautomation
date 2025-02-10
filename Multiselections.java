package Testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Commonfunctions.commonfunction;
import Pageobjectmodel.productspageobj;

public class Multiselections extends commonfunction {
	


   @Test
	public void Productmultiselection() throws IOException {
		  //login successfull
     Scanner scan = new Scanner(System.in);
        
		System.out.println("Enter the product count :" );
		int productcount = scan.nextInt();
		scan.nextLine();                 //get num from user for creating products array;
		System.out.println(productcount);
		
	   List<String> products = new ArrayList<>(); //creates list array of string 
	   for(int i = 0; i<productcount;i++) {
	    	
	    	 System.out.println("Enter the product name :" + (i+1) + ":"  );
	    	 
	    	 products.add(scan.nextLine().toLowerCase());//get products name to select  from user ;
	    	 
	    }
	   System.out.println("products successfully entered by user");
	   System.out.println("----------------------------------------------------------");
		  
	   PageFactory.initElements(driver, productspageobj.class);
	   for (String searchfor : products) //searchfor will store products name and the loop startrs executing;
	   {
		
		  List<WebElement> productname = driver.findElements(By.xpath("//a[contains(@id, 'title_link')]"));
		   
		   for (int i = 0 ;i<productname.size();i++ ) {//this loop will execute the num of tym the xpath(title) presents in.
			   
			       
			    String produt_to_select = productname.get(i).getText();//compares both string 
			    if(produt_to_select.equalsIgnoreCase(searchfor))
			    	
			   {
				   
				   driver.findElements(By.xpath("//button[text()='Add to cart']")).get(i).click();
				   
					 System.out.println("Product Added to cart");
				  
			   }
			 
		}
		   System.out.println("----------------------------------------------------------");
			
        
        }
	   System.out.println("User have selected:");
           for (String product : products) {//display the products which user entered;
            System.out.println("- " + product);
        
	   }    
      
       System.out.println("----------------------------------------------------------");
   		
  }
		
	}

	   
	
		
		
		
		
	
	
	
	
	
	
	
	
	
	


