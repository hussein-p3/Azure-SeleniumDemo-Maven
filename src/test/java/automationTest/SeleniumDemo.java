package automationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDemo {

	WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String broswserName) {
		if(broswserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (broswserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("https://azure.microsoft.com/en-us/services/devops/pipelines/");
		
	}

	@Test
	public void TC_01_Verify_Documentation_Title() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Documentation']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "Azure documentation | Microsoft Docs");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
