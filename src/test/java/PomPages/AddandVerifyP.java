package PomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utiles.ExplicitCode;

public class AddandVerifyP {
	WebDriver dr;
	ExplicitCode e;

	public AddandVerifyP(WebDriver dr){
		this.dr=dr;
		e=new ExplicitCode();
	}
	
	By shoppingcart=By.xpath("//*[@id='cart']//button");
	By viewcart=By.xpath("//*[@id='cart']//following::a[3]");
	By bookname=By.xpath("//*[@class='table-responsive']//following::a[2]");

	public void ClickS() {
		WebElement e_id=e.clickable(shoppingcart, 20);
		e_id.click();
	}
	public void ClickV() {
		WebElement e_id=e.clickable(viewcart, 20);
		e_id.click();
	}
	public String GetName() {
		WebElement e_id=e.waitelement(bookname, 20);
		String r=e_id.getText();
		return r;
	}
	public void AddVerify() {
		
		this.ClickS();
		this.ClickV();
		e.Screenshot();
	}
}
