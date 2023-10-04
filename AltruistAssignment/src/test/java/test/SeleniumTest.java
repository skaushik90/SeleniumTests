package test;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.OpenBrowser;
import pages.SauceDemoLogin;
import pages.SauceDemoSwagLabs;

public class SeleniumTest {
	
	private WebDriver driver = null;
	
	@Parameters("browserName")
	@BeforeTest
	public void setupTest(String browserName) {
		driver = OpenBrowser.openBrowser(driver, browserName);
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test
	public void testSauceDemo() throws InterruptedException {
		SauceDemoLogin loginPage = new SauceDemoLogin(driver);
		SauceDemoSwagLabs sauceDemo = new SauceDemoSwagLabs(driver);
		loginPage.login("standard_user", "secret_sauce");
		sauceDemo.addToCart();
		sauceDemo.checkOut("Joker", "Batman", "12345");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
