package Utiles;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import excel_utilities.getexcel;

public class ExplicitCode extends getexcel{//here we are extending getexcel to acquire the properties and variables for get excel 
	protected static WebDriver dr;
	  static int counter=1;

	// method or explicit code to wait for  elements
public WebElement waitelement(By Locator,int timeout) {
	WebElement e=null;
	try {
	WebDriverWait wait= new WebDriverWait(dr,timeout);
	 e=wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	System.out.println("element located");

	}catch(Exception e1){

	  System.out.println("element not found"+e1);	
	}
return e;	
}
// method or explicit code to wait for clickable elements
public WebElement clickable(By Locator, int timeout) {
	WebElement e=null;
	try {
		WebDriverWait wait = new WebDriverWait(dr,timeout);
		e= wait.until(ExpectedConditions.elementToBeClickable(Locator));
		System.out.println("element located");
		return e;
		}catch(Exception e1){

		  System.out.println("element not found"+e1);	
		}
	return null;
}
//method to take screenshots
public void Screenshot() {
	String path="src\\test\\resources\\testdata\\screenshots";
	String filename=counter+".png";
	File f1=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	File f2= new File(path+filename);
	try {
		FileUtils.copyFile(f1, f2);
	} catch (IOException e) {
		// TODO Auto-generated catch block

		System.out.println(counter +"failed");
		e.printStackTrace();
	}
	counter ++;
}
//method for launching the browser
public static WebDriver launchbrowser(String browser) {
String s="src\\test\\resources\\drivers\\chromedriver_v79.exe";
String s1="src\\test\\resources\\drivers\\geckodriver_v73.exe";
if(browser.contains("chrome")) {
	System.setProperty("webdriver.chrome.driver", s);
	dr= new ChromeDriver();
}else if(browser.contains("firefox")) {
	System.setProperty("webdriver.gecko.driver",s1);
    dr=new FirefoxDriver();
}
dr.get("https://demo.opencart.com/");
dr.manage().window().maximize();
dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

return dr;	
}
}
