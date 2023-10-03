package test;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.*;

public class GOOGLTicker_POM {
	
	private WebDriver driver = null;
	
	@BeforeTest
	public void setupTest() throws InterruptedException {
		
		//SETUP: Open a Chrome browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void googleFinanceSearch() throws InterruptedException
	{
		GoogleFinanceChartPage chartPageObject = new GoogleFinanceChartPage(driver);
		GoogleFinanceSearchPage financeSearchPage = new GoogleFinanceSearchPage(driver);
		//EXERCISE: 
		driver.get("https://www.google.com/finance/");
		
		// Search for GOOGL ticker
		financeSearchPage.textbox_search("GOOGL");
		financeSearchPage.search_Ticker("BMV");

		//	Wait for 10 seconds or until Graph shows  
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ushogf")));

				
		chartPageObject.wait_For_Page_Load();		
		
		// VERIFICATION: If value returned is not ERROR then print the previous closing price 
		// or print error
		String prev_close = chartPageObject.get_Prev_Close_Price();
		if (prev_close == "ERROR") {
			System.out.println("Incorrect String Returned: " + prev_close);
		} else 
			System.out.println("Google Ticker Previous Close = " + prev_close);
		
		
	}
	
	@AfterTest
	public void teardownTest() {
		
		//TEARDOWN: Close the driver
		driver.close();
		
	}
}
