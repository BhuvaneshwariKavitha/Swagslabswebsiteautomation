package Testcases;



import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Commonfunctions.commonfunction;
import Pageobjectmodel.dashboardobjects;

public class menubuttonfunctions extends commonfunction {

	
    @Test
	public void menufunctions() throws IOException {
	
		
		PageFactory.initElements(driver, dashboardobjects.class);
		dashboardobjects.menubutton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Pick any option from below: ");
		
		List<WebElement> sidemenu = driver.findElements(By.xpath("//a[@class='bm-item menu-item']"));
		for (WebElement webElement : sidemenu) {
			
		String options = webElement.getText();
		System.out.println(options);
		}
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter option: ");
		String menuoption = scan.nextLine();
		
		if(menuoption.equalsIgnoreCase("All Items")) {
			dashboardobjects.allitem.click();
		   String pageURL =	driver.getCurrentUrl();
		   System.out.println("Current URL :"+ pageURL);
		   
			
		}else if(menuoption.equalsIgnoreCase("About")) {
			
			dashboardobjects.about.click();
			 String pagesource =	driver.getCurrentUrl();
				System.out.println("Current URL :" + pagesource);
				captureScreenshot();
			
		}else if(menuoption.equalsIgnoreCase("Logout")) {
			
			dashboardobjects.logout.click();
			 String URL =	driver.getCurrentUrl();
			 System.out.println("Current URL :"+ URL);
			 captureScreenshot();
				
			
		}else if(menuoption.equalsIgnoreCase("Reset")) {
			
			dashboardobjects.Reset.click();
			 String sourceURL =	driver.getCurrentUrl();
			 System.out.println("Current URL :"+ sourceURL);
				
		
		
		
		
		
	}
	

		}
    
    
}
