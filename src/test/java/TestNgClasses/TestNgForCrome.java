package TestNgClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PomPages.AddandVerifyP;
import PomPages.DesktopVerification;
import PomPages.LoginPage;
import PomPages.RegisterPage;
import PomPages.Search;
import Utiles.ExplicitCode;


public class TestNgForCrome extends ExplicitCode { //here we extends explicit code for acquiring properties  and variables of explicit code
	WebDriver dr;
	AddandVerifyP adv;
	DesktopVerification dv;
	LoginPage LP;
	RegisterPage rp;
	Search s;
	
	@BeforeMethod
	public void LB() {
		launchbrowser("chrome");
	}
	@BeforeClass
	public void GE() {
		getExcel("Sheet1");
	}
	@Test(priority=0,dataProvider="register")
	  public void RegisterandLogin(String fn,String ln,String email,String tele,String password,String search) {
		 rp=new RegisterPage(dr);//object creation
		 int g=tele.length();//since telephone number is in numeric so in excel we have given in "" so for removing the "" using sub string method
	      String k=tele.substring(1, g-1);
		 rp.Register(fn, ln, email, k, password);
		String r=rp.myaccount();
		Assert.assertTrue(r.contains("My"));//checking for successful login
		LP = new LoginPage(dr);//object creation
		LP.Login(email, password);
		
	  }
	@Test(priority=1,dataProvider="register")
	public void SearchandAddproducts(String fn,String ln,String email,String tele,String password,String search) {
	
		s= new Search(dr);//object creation
		s.searchtheproduct(search);
		adv= new AddandVerifyP(dr);//object creation
		adv.AddVerify();
		String a=adv.GetName();
		Assert.assertTrue(a.contains("Macbook"));//checking for whether the product is added to cart are not
	}
	@Test(priority=2)
	public void Desktops() {
		dv= new DesktopVerification(dr);//object creation
		dv.VerifyDe();
		String s=dv.GetName();
		Assert.assertTrue(s.contains("Desktops"));//checking the desktops page is opened or not
	}
	
	 @DataProvider(name="register")
	  public String[][] register(){
		   return testdata;
	  }
	 @AfterMethod
	 public void CloseBrowser() {
		 dr.quit();
	 }
}
