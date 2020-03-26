package PomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utiles.ExplicitCode;

public class DesktopVerification {
	WebDriver dr;
	ExplicitCode e;

	public DesktopVerification(WebDriver dr){
		this.dr=dr;
		e=new ExplicitCode();
	}
	By Desktops=By.xpath("//*[@id='menu']//following::a[1]");
	By ShowDesk=By.xpath("//*[@id='menu']//following::a[4]");
	By Verify=By.xpath("//*[@id='content']//h2");
	public void ClickP() {
		WebElement e_id=e.clickable(Desktops, 20);
		e_id.click();
	}
	public void ClickA() {
		WebElement e_id=e.clickable(ShowDesk, 20);
		e_id.click();
	}
	public String GetName() {
		WebElement e_id=e.waitelement(Verify, 20);
		String r=e_id.getText();
		return r;
	}
	public void VerifyDe() {
		this.ClickP();
		this.ClickA();
		e.Screenshot();
	}
}
