package test;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class GOOGLTicker {
	
	private WebDriver driver = null;
	
	@BeforeTest
	public void setupTest() throws InterruptedException {
		
		//SETUP: Open a chrome browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void googleFinanceSearch() throws InterruptedException
	{
		//EXERCISE: 
		driver.get("https://www.google.com/finance/");
		
		String google_Finance_SearchBox_XPath = "//*[@id=\"yDmH0d\"]/c-wiz[2]/div/div[3]/div[3]/div/div/div/div[1]/input[2]";
		
		// Search for GOOGL ticker
		driver.findElement(By.xpath(google_Finance_SearchBox_XPath)).click();
		driver.findElement(By.xpath(google_Finance_SearchBox_XPath)).sendKeys("GOOGL");
		driver.findElement(By.xpath(google_Finance_SearchBox_XPath)).sendKeys(Keys.ENTER);

		//	Wait for 10 seconds or until Graph shows  
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ushogf")));

				
		String prev_close = driver.findElement(By.className("pFZ9G")).getText();		
		
		// VERIFICATION: Split the string. Make sure the first 2 words are "Prev" and "close" as 
		// verification and print the final value
		String[] outputArray = prev_close.split(" ");
		
		if (outputArray.length == 3  && outputArray[0].equals("Prev") && outputArray[1].equals("close") ) {
			System.out.println("Google Ticker Previous Close = " + outputArray[2]);
		} else {
			System.out.println("Incorrect String Returned: " + prev_close);
		}
		
	}
	
	@AfterTest
	public void teardownTest() {
		
		//TEARDOWN: Close the driver
		driver.close();
		
	}
}
