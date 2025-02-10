package Testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import Commonfunctions.commonfunction;
import Pageobjectmodel.productspageobj;

public class Filterfunction extends commonfunction{
	
	loginfunctionality_withvalidcredentials LOF = new loginfunctionality_withvalidcredentials();
	
	@Test
	public void Filterfunctionality() throws IOException
	{
		LOF.verifylogin();
		PageFactory.initElements(driver, productspageobj.class);
		List<WebElement> productsort =  driver.findElements(By.xpath("//a[contains(@id, 'title_link')]"));
		 System.out.println("ProductsList before any fiters applied: ");
		int PROS=0;
		
		for (WebElement webElement : productsort) {
			
			String productslist = webElement.getText();
		  System.out.println(productslist);
		  PROS++;
		  
	}
	
	System.out.println("-----------------------------------------------------------------");
	      System.out.println("Selecting filter option");
		  productspageobj.Filtericon.click(); //clicking filter option;
		  
		   
		   WebElement dropdown = driver.findElement(By.className("product_sort_container"));
		   Select dropselect = new Select(dropdown);
		   List<WebElement> dropdownlist = dropselect.getOptions(); //get all options from dropdown 
		   List<String> optionsText = new ArrayList<>(); //obect for optionslist
		    for (WebElement option : dropdownlist) {
	            optionsText.add(option.getText());
	        }
		    System.out.println("dropdown options :" + optionsText);
   System.out.println("-----------------------------------------------------------------");
		      
		    
		    System.out.println("Enter the value to select:(note:value should be less than 5)");
			 Scanner sc = new Scanner(System.in);
			  int index = sc.nextInt();//entering option for selection
		      dropselect.selectByIndex(index);
		    
		 List<WebElement> productsorted =  driver.findElements(By.xpath("//a[contains(@id, 'title_link')]"));
		  int PROS1=0;
		  for (WebElement webElement : productsorted) {
															//iterates title after any filters applied;
				String prolist = webElement.getText();
				System.out.println(prolist);
				
				PROS1++;
				}
		 
		
		
	}

	
	
	
	
	
	
	
	
}
