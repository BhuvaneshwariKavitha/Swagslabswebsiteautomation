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
	 
	 
	String ICON =  productspageobj.Cartbadgefunction.getText();
	System.out.println("Cart products count :" + ICON);
	productspageobj.Cartfunction.click();
	 
     if(ICON.isEmpty()|| ICON.equalsIgnoreCase("0")) {
		
		System.out.println("Your cart is empty!!");
		
		
	}else {
		
		System.out.println("cart count" + ICON);
		
		
		
	}
		 
	 }
	    
	
	
	
	
	
	}
	
	
	


