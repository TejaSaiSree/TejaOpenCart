package PomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utiles.ExplicitCode;

public class Search {
	WebDriver dr;
	ExplicitCode e;

	public Search(WebDriver dr){
		this.dr=dr;
		e=new ExplicitCode();
	}
	By search=By.xpath("//input[@name='search']");
	By option=By.xpath("//div[@id='search']//span//button ");
	By message=By.xpath("//input[@id='button-search']//following::p[1]");
	By product=By.xpath("/html/body/div[2]/div/div/div[3]/div[1]/div/div[1]");
	By addtocart=By.xpath("//button[@id='button-cart']");
	public void ClickP() {
		WebElement e_id=e.clickable(product, 20);
		e_id.click();
	}
	public void ClickA() {
		WebElement e_id=e.clickable(addtocart, 20);
		e_id.click();
	}
	public void searchproduct(String s) {
		WebElement e_id=e.waitelement(search, 20);
		e_id.sendKeys(s);
	}
	public void searchoption() {
		WebElement e_id=e.clickable(option, 20);
		e_id.click();
	}
	public String errormessage() {
		WebElement e_id=e.waitelement(message, 20);
		String s=e_id.getText();
		return s;
	}
	public void searchtheproduct(String r) {
		this.searchproduct(r);
		this.searchoption();
		this.ClickP();
		this.ClickA();
		e.Screenshot();
	}
}
