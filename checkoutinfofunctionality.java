package Testcases;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Commonfunctions.commonfunction;
import Pageobjectmodel.checkoutpageobject;

public class checkoutinfofunctionality extends commonfunction {

	checkoutfunction CF = new checkoutfunction();
	@Test
	public void checkoutinformation() throws IOException {
		
		 CF.checkoutpage();
		 driver.getCurrentUrl();
		 PageFactory.initElements(driver, checkoutpageobject.class);
	     WebElement Fname =	checkoutpageobject.chFname;
	     Scanner scan = new Scanner(System.in);
	     System.out.println("Enter First name:");
	     String Firname = scan.nextLine();
	     Fname.sendKeys(Firname);
	     WebElement Lname = checkoutpageobject.chLname;
	     System.out.println("Enter Last name:");
	     String LTname = scan.nextLine();
	     Lname.sendKeys(LTname);
		 WebElement PScode=checkoutpageobject.chPostalcode;
		  System.out.println("Enter postal code:");
		    String postcode = scan.nextLine();
		    if(isvalidpostcode(postcode)) {
		    	 
		    	System.out.println("Valid postcode.");
		    	 PScode.sendKeys(postcode);
				    
	        }
		    
		    
		 else {
	            
		    	
		    	System.out.println(" Invalid postcode. Postcode must be a 6-digit number.");
	        }
		    	
		   
		 
	     System.out.println("click' CONTINUE'(to proceed ) or 'CANCEL' (to navigateback)");
	     String preferance = scan.nextLine();
	     if(preferance.equalsIgnoreCase("Continue")) {
	    	 
	    	 checkoutpageobject.continueoption.click();
	    	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    	String loadedpage =  driver.getCurrentUrl();
	    	System.out.println("current url :" + loadedpage);
	    	 
	    	  }
	      else if (preferance.equalsIgnoreCase("cancel")) {
	    	 
	    	 
	    	 checkoutpageobject.canceloption.click();
	     }
	    
	}	     
	     
	public static boolean isvalidpostcode(String postcode) {
		
		return postcode.matches("\\d{6}");
		
		}
	
	
	
	
	
}
	

