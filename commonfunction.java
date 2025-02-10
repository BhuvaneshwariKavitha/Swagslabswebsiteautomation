package Commonfunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Testcases.loginfunctionality_withvalidcredentials;

import org.openqa.selenium.TakesScreenshot;


public class commonfunction {

  public static WebDriver driver=null;

	public static Properties PR=null;
	
	public Properties loadpropertyfile() throws IOException {
		//to load properties from property file;
		FileInputStream fI = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\GMAILPROJECT\\src\\config.properties");
		PR = new Properties();
		PR.load(fI);
		System.out.println(PR.getProperty("URL"));
		System.out.println(PR.getProperty("Browser"));
		
		return PR;
	
	}
	@BeforeMethod
	public void launchbrowser() throws IOException
	{
		loadpropertyfile();
		
		String browser= PR.getProperty("Browser");
		String URL = PR.getProperty("URL");
		String Products = PR.getProperty("Product");
		
		
		if(browser.equalsIgnoreCase("chrome")) {
	
	 System.setProperty("WebDriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application.exe" );
	  driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("WebDriver.gecko.driver", "C:\\Program Files\\Google\\Chrome\\Application.exe");
		driver = new FirefoxDriver();
			
			
		}
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	}	
	
	public void scrolldown() {
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 300).perform();
		
	}
	
	public static void captureScreenshot() throws IOException {
		    TakesScreenshot Ts = (TakesScreenshot)driver;
			File captureSS = Ts.getScreenshotAs(OutputType.FILE);
			
			File Screenshotfolder = new File("Screenshots");
			if(!Screenshotfolder.exists()) {
				
				Screenshotfolder.mkdir();
				
			}
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        File destFile = new File(Screenshotfolder, "screenshot_" + timestamp + ".png");

	        FileInputStream fis = new FileInputStream(captureSS);      // Read screenshot file
	        FileOutputStream fos = new FileOutputStream(destFile);   // Write to destination

	        byte[] buffer = new byte[1024];  // Buffer to copy data
	        int length;
	        while ((length = fis.read(buffer)) > 0) {
	            fos.write(buffer, 0, length);
	        }
			
	       
	        fis.close();
	        fos.close();

	        System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
	      
			
		}

	
	
	
	@AfterMethod
	public void closebrowser() {
		
		driver.quit();
		
	}
	
	
	}
    
    

	

