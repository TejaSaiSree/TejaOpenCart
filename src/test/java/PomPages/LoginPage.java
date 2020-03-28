package PomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utiles.ExplicitCode;

public class LoginPage {
WebDriver dr;
ExplicitCode e;

public LoginPage(WebDriver dr){
	this.dr=dr;
	e=new ExplicitCode();
}
//xpaths for login page
By profile=By.xpath("//ul[@class='list-inline']//li[2]");
By login=By.xpath("//*[@id='top-links']//following::a[4]");
By email=By.xpath("//*[@id='input-email']");
By pass=By.xpath("//*[@id='input-password']");
By click=By.xpath("//*[@value='Login']");
By alert=By.xpath("//div[@class='alert alert-danger alert-dismissible']//i");
//pom methods for login page
public void pr(){
System.out.println("inn profile");
WebElement e_id=e.clickable(profile, 20);
e_id.click();
}
public void log(){
	System.out.println("inn register");
WebElement e_id=e.clickable(login, 20);
e_id.click();
}
public void email_name(String s){
System.out.println("inn email");
WebElement e_id=e.waitelement(email, 20);
e_id.sendKeys(s);
}
public void password(String s){
System.out.println("inn password");
WebElement e_id=e.waitelement(pass, 20);
e_id.sendKeys(s);
}
public void  button() {
	System.out.println("inn click button");
	WebElement e_id=e.clickable(click, 20);
	e_id.click();	
}
//method for login page
public void Login(String email,String password) {
	this.pr();
	this.log();
	this.email_name(email);
	this.password(password);
	this.button();
	e.Screenshot();
}
public String title() {
	String s=dr.getTitle();
	return s;
}
// method for invalid user error message
public String message() {
	String s=dr.findElement(alert).getText();
	return s;
}
}
