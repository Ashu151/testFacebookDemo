package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import .utilities.ExtentTestManager;
import facebookbasePage.FacebookBasePage;



public class FacebookLoginPage extends FacebookBasePage {
	//WebDriver driver;
	
	public FacebookLoginPage(WebDriver driver) {
		super(driver);
		//this.driver=driver;
	}
	
	
	
	public final By usernameFieldLocator = By.xpath("//input[@id='email']");
	public final By passwordFieldLocator = By.xpath("//input[@id='pass']");
	//button[@name='login']
	public final By LoginButtonLocator = By.xpath("//button[@name='login']");

	
	
	public void openPage() {
		
		
		driver.get(baseUrl);
		driver.manage().deleteAllCookies();
		//log.info("Page Opened!");
		//ExtentTestManager.getTest().info("Page Opened!");
	}
	

}
