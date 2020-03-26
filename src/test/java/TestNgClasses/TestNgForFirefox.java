package TestNgClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class TestNgForFirefox  extends ExplicitCode{
	WebDriver dr;
	AddandVerifyP adv;
	DesktopVerification dv;
	LoginPage LP;
	RegisterPage rp;
	Search s;
	
	@BeforeMethod
	public void LB() {
		launchbrowser("firefox");
	}
	@BeforeClass
	public void GE() {
		getExcel("Sheet1");
	}
	@Test(priority=0,dataProvider="register")
	  public void f(String fn,String ln,String email,String tele,String password,String search) {
		 rp=new RegisterPage(dr);
		 int g=tele.length();
	      String k=tele.substring(1, g-1);
		 rp.Register(fn, ln, email, k, password);
		String r=rp.myaccount();
		Assert.assertTrue(r.contains("My"));
		LP = new LoginPage(dr);
		LP.Login(email, password);
		
	  }
	@Test(priority=1,dataProvider="register")
	public void f1(String fn,String ln,String email,String tele,String password,String search) {
		LP = new LoginPage(dr);
		LP.Login(email, password);
		s= new Search(dr);
		s.searchtheproduct(search);
		adv= new AddandVerifyP(dr);
		adv.AddVerify();
		String a=adv.GetName();
		Assert.assertTrue(a.contains("Macbook"));
	}
	@Test(priority=2)
	public void f2() {
		dv= new DesktopVerification(dr);
		dv.VerifyDe();
	}
	
	 @DataProvider(name="register")
	  public String[][] register(){
		   return testdata;
	  }
}
