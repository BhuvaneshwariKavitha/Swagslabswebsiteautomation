package Testcases;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Commonfunctions.commonfunction;
import Pageobjectmodel.productspageobj;

public class productselction extends commonfunction{
	
	
	loginfunctionality_withvalidcredentials los = new loginfunctionality_withvalidcredentials();
	
	 
	
	
    @Test
	public void products() throws IOException {
    	los.verifylogin();
    	 System.out.println("Enter the product name:");
    	 Scanner SC = new Scanner(System.in);
   	     String product = SC.nextLine(); //product to select;
 	  
    	
   	  System.out.println("You have selected :" + product);
		
		
		
		PageFactory.initElements(driver, productspageobj.class);
		List<WebElement> numberofproducts = driver.findElements(By.xpath("//a[contains(@id, 'title_link')]"));
		System.out.println(" number of products present in webpage :" + numberofproducts.size());
		List<WebElement>  products = driver.findElements(By.xpath("//a[contains(@id, 'title_link')]"));
		int PRO = 0;
	    for (WebElement webElement : products) {
	    	String productsonwebpage = webElement.getText();
	    	System.out.println(productsonwebpage);
			
		if(productsonwebpage.equalsIgnoreCase(product)) 
		{
			webElement.click();
		//captureScreenshot();
			break;
		}
		
	
		PRO++;
	    }
	 
			 
		 }
			  
   
	 
		
	   
		
	 
	
	

	  
	    
	    
	    
	    
	    
		}
		
	
    
    
    
    
		
		

	
	


