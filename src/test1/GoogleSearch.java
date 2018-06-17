package test1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearch {
	
	
	
	
	public WebDriver driver;
	public String driverPath = "C:\\Users\\Tharshini\\Downloads\\chromedriver_win32\\chromedriver.exe";
	
	
@BeforeTest
	public void setUp() {
				
		System.setProperty("webdriver.chrome.driver",driverPath );
	    driver = new ChromeDriver();
	   
		
	}	

	
@Test 
public void openGoogle()
{
	  driver.get("http://www.google.com");
	  String pageUrl = "https://www.google.com/?gws_rd=ssl";
	  Assert.assertEquals(driver.getCurrentUrl(), pageUrl);

}

@Test
public void search() throws IOException
{
	System.out.println("I am insight search function");
	WebElement e = driver.findElement(By.name("q"));
	e.sendKeys("Java");
	e.submit();
	
	driver.manage().window().maximize();
	WebElement searchPanel  = driver.findElement(By.id("search"));
	
	PrintWriter writer = new PrintWriter(new FileWriter("C:/Users/Tharshini/Desktop/JavaOutput/searchResult.txt",true));
	
		List <WebElement>  searchResult = searchPanel.findElements(By.tagName("a"));
		
		   for(int x=0; x<searchResult.size();x++)
		   {
			   	System.out.println(searchResult.get(x).getText());
			   	writer.println(searchResult.get(x).getAttribute("href"));
		   } 
	
	//}
	
	
	writer.close();
	
  
  
	
}
  


}
