package test1;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class FBLogin {
	

	public WebDriver driver;
	public String driverPath = "C:\\Users\\Tharshini\\Downloads\\chromedriver_win32\\chromedriver.exe";
	
	
@BeforeTest
	public void setUp() {
				
		System.setProperty("webdriver.chrome.driver",driverPath );
	    driver = new ChromeDriver();
	    driver.get("http://www.facebook.com");
		
	}	

    @Parameters({ "username", "password" })
	@Test
	public void login(String username, String password) 
	{
	  
	  driver.findElement(By.id("email")).sendKeys(username);
	  driver.findElement(By.id("pass")).sendKeys(password);
	  driver.findElement(By.id("loginbutton")).click();
     }
  
  
  @AfterSuite
  public void afterSuite() {
  }

}
