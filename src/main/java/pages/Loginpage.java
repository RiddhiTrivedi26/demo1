package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='username']")
	public WebElement userName;
	
	@FindBy(xpath="//input[@id='uapPassword']")
	public WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-block td-button-secondary']")
	public WebElement submittButton;
	
	@FindBy(xpath="//div[@class='banner-container']//div//p")
	public WebElement globalError;
	
	@FindBy(xpath="//span[contains(text(),'Please enter your Username or Access Card number.')]")
	public WebElement idError;
	
	@FindBy(xpath="//span[contains(text(),'Please enter your password')]")
	public WebElement passError;
	
	
	public void openBrowser() {
		
		String browser="Firefox";//chrome,safari
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","/Users/jaydave/seleniumjar/geckodriver");
			 driver=new FirefoxDriver();
		}else if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","/Users/jaydave/seleniumjar/chromedriver");
			driver=new ChromeDriver();
			}else {
		System.setProperty("webdriver.safari.driver","/Users/jaydave/seleniumjar/geckodriver");
		 driver=new FirefoxDriver();
			}
		
		PageFactory.initElements(driver,this);
			
		}
	public void openLoginPage() {
		driver.get("https://authentication.td.com/uap-ui/?consumer=easyweb&locale=en_CA#/uap/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void closebrowser() {
		driver.quit();
		}
	
	public void login(String a,String b) throws InterruptedException {
		userName.sendKeys(a);
		password.sendKeys(b);
		submittButton.click();
		Thread.sleep(20000);
	}
	
	public String readError() {
		String actualErr = globalError.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String reademailError() {
		String actualError=idError.getText();
		System.out.println(actualError);
		return actualError;
	}
	
	public String readpassError() {
		String actualError=passError.getText();
		System.out.println(actualError);
		return actualError;
	}
	 
	
	
	
	
	
	
	
}





