package test;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {
	
	public static void main (String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectPath+ "/src/test/resources/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
//		System.getProperty("webdriver.chrome.driver", "/AltruistExcercise/src/main/resources/drivers/Google Chrome for Testing.app");
//		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
	}

}
