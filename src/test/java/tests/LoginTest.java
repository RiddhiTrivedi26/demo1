package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import library.DataFile;
import pages.Loginpage;

public class LoginTest {
	
	WebDriver driver;
	Loginpage lp=new Loginpage();
	DataFile df=new DataFile();
	
	@BeforeMethod
	public void beforeMethod() {
		lp.openBrowser();
		lp.openLoginPage();
		}
	@AfterMethod
	public void afterMethod() {
		
	lp.closebrowser();
	}
		
		@Test(priority=1)
	public void loginwithWrongIDWrongPass() throws InterruptedException{
		lp.login(df.wrongEmail, df.wrongPassword);
		 Assert.assertEquals(lp.readError(),df.globalError);
		
		}
		@Test(priority=2)
		public void loginemptyEmail() throws InterruptedException {
			lp.login("", df.wrongPassword);
			Assert.assertEquals(lp.reademailError(),df.emptyEmailError);
		}
		@Test(priority=3)
		public void loginemptypass() throws InterruptedException {
			lp.login(df.wrongEmail,"");
			Assert.assertEquals(lp.readpassError(), df.emptyPassError);
		}
	
	

}
