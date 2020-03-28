package PomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utiles.ExplicitCode;

public class RegisterPage {
	WebDriver dr;
ExplicitCode e;


  
public RegisterPage(WebDriver dr){
	this.dr=dr;
	e= new ExplicitCode();
}
//xpaths for register page
By profile=By.xpath("//ul[@class='list-inline']//li[2]");
By register=By.xpath("//ul[@class='list-inline']//li[2]//ul//li[1]/a ");
By username=By.xpath("//input[@name='firstname'] ");
By lastname=By.xpath("//input[@name='lastname']");
By email=By.xpath("//input[@name='email']  ");
By telephone1=By.xpath("//input[@name='telephone'] ");
By pas=By.xpath("//input[@name='password']");
By conf=By.xpath("//input[@name='confirm']");
By  agree=By.xpath("//input[@name='agree']");
By Btn=By.xpath("//input[@class='btn btn-primary']");
By Btn1= By.xpath("//div[@class='pull-right']");
By my=By.xpath("//div[@id='content']//h2[1]");
//pom methods for register page
public void pr(){
System.out.println("inn profile");
WebElement e_id=e.clickable(profile, 20);
e_id.click();
}
public void log(){
	System.out.println("inn register");
WebElement e_id=e.clickable(register, 20);
e_id.click();
}
public void uname(String usname){
WebElement e_id=e.waitelement(username, 20);
e_id.sendKeys(usname);	

}
public void lname(String usname){
WebElement e_id=e.waitelement(lastname, 20);
e_id.sendKeys(usname);	

}

public void Email(String Email){
WebElement e_id=e.waitelement(email, 20);
e_id.sendKeys(Email);

}
public void Telephone(String telephone){
WebElement e_id=e.waitelement(telephone1, 20);
e_id.sendKeys(telephone);

}
public void password(String pword){
WebElement e_id=e.waitelement(pas, 20);
e_id.sendKeys(pword);

}
public void conpassword(String pword){
WebElement e_id=e.waitelement(conf, 20);
e_id.sendKeys(pword);

}
public void agree(){
WebElement e_id=e.clickable(agree, 20);
e_id.click();

}
public void button(){
WebElement e_id=e.clickable(Btn, 20);
e_id.click();

}
public void button1(){
WebElement e_id=e.clickable(Btn1, 20);
e_id.click();

}
public String  myaccount() {
	WebElement e_id=e.waitelement(my, 20);
	String s=e_id.getText();
	return s;
}
//method for register page
public void Register(String fn,String ln,String email,String tele,String password) {
	this.pr();
	this.log();
	this.uname(fn);
	this.lname(ln);
this.Email(email);
this.Telephone(tele);
this.password(password);
this.conpassword(password);
this.agree();
this.button();
this.button1();
e.Screenshot();
}
}
