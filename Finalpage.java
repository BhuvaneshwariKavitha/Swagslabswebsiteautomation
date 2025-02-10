package Testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.testng.annotations.Test;

import Commonfunctions.commonfunction;
import Pageobjectmodel.checkoutpageobject;

public class Finalpage extends commonfunction{

	paymentpagefunction PF = new paymentpagefunction();
	
	@Test
	public void Finalpagefuntions() throws IOException {
		
		PF.paymentpage();
		
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Click 'Continue' preferance to proceed further :or: click 'cancel' to navigate back " );
			String preferance = scan.nextLine();
			if(preferance.equalsIgnoreCase("continue")) {
				
				checkoutpageobject.Finish.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String completeurl=	driver.getCurrentUrl();
			
			System.out.println("NEW PAGE LOADED :" + completeurl);
			
			String completeconfirm = checkoutpageobject.message.getText();
			String completemessage = checkoutpageobject.message2.getText();
			if(completeconfirm.contains("Thank you"))
			{
				
				System.out.println(completeconfirm);
				System.out.println("SUCCESSFULLY ORDER PLACED!!!");
				captureScreenshot();
			}
			
				
				
		}
			else if(preferance.equalsIgnoreCase("cancel")) {
				
				checkoutpageobject.canceloption.click();
				
				
			}
		
		
	   System.out.println("WANT TO GO BACK TO THE HOME PAGE??");
	   String Final = scan.nextLine();
	   if(Final.equalsIgnoreCase("yes")) {
		   
		   
		   checkoutpageobject.BACKHOME.click();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 System.out.println(driver.getCurrentUrl());
		   System.out.println("products page has been loaded!");
		   
	   } 
	   
	
}
	
	
	
	
	
}
