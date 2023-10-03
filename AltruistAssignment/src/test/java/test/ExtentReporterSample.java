package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.GoogleFinanceChartPage;
import pages.GoogleFinanceSearchPage;
import pages.OpenBrowser;

public class ExtentReporterSample {
	
	private WebDriver driver = null;
	private ExtentReports extent = new ExtentReports();
	private ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");	
	private ExtentTest test = null;
	
	@Parameters("browserName")
	@BeforeTest
	public void setupTest(String browserName) throws InterruptedException {
		spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		test = extent.createTest("Sample Google Search Test");
		
		//SETUP: Open a browser
		driver = OpenBrowser.openBrowser(driver, browserName , test);		
		
	}
	
	@Test
	public void googleFinanceSearch() throws InterruptedException
	{
		GoogleFinanceChartPage chartPageObject = new GoogleFinanceChartPage(driver);
		GoogleFinanceSearchPage financeSearchPage = new GoogleFinanceSearchPage(driver);
		//EXERCISE: 
		driver.get("https://www.google.com/finance/");
		
		test.log(Status.PASS, "Navigated to www.google.com/finance/");
		
		// Search for GOOGL ticker
		financeSearchPage.textbox_search("GOOGL");
		financeSearchPage.search_Ticker("NASDAQ");
		
		test.log(Status.PASS, "Searched for GOOGL ticker");

		//	Wait for 10 seconds or until Graph shows  
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ushogf")));

				
		chartPageObject.wait_For_Page_Load();	
		
		test.log(Status.PASS, "Search result loaded");
		
		// VERIFICATION: If value returned is not ERROR then print the previous closing price 
		// or print error
		String prev_close = chartPageObject.get_Prev_Close_Price();
		if (prev_close == "ERROR") {
			test.log(Status.FAIL, "Search result loaded incorrectly. Returned String: "+ prev_close);
		} else 
			test.log(Status.PASS, "Google Ticker Previous Close = " + prev_close);
		
	}
	
	@AfterTest
	public void teardownTest() {
		
		//TEARDOWN: Close the driver
		driver.close();
		test.info("Test Completed");
		
		extent.flush();
		
	}
}
