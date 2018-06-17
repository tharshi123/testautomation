package test1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class salestest {

	
	public WebDriver driver;
	public String driverPath = "C:\\Users\\Tharshini\\Downloads\\chromedriver_win32\\chromedriver.exe";
	
	
@BeforeTest
	public void setUp() {
				
		System.setProperty("webdriver.chrome.driver",driverPath );
	    driver = new ChromeDriver();
	    driver.get("https://login.salesforce.com/");
		
	}	

@Parameters({ "username", "password" })
@Test
public void Login(String username,String password)
{
        
        WebElement e1 = driver.findElement(By.id("username"));
        e1.sendKeys(username);
        driver.findElement(By.name("pw")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        		
        WebElement e2 =driver.findElement(By.cssSelector("div[id='error']"));
        String errormsg = e2.getText();
        System.out.println(errormsg);
        
       
     
	}
 
@AfterTest
public void tearingDown(){
	System.out.println("Closing the browser");
	driver.close();
	
}

}

