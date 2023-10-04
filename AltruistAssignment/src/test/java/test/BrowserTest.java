package test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pages.InternetHookup;
import pages.OpenBrowser;

public class BrowserTest {
	
	private WebDriver driver = null;
	
	@Parameters("browserName")
	@BeforeMethod
	public void setupTest(String browserName) {
		driver = OpenBrowser.openBrowser(driver, browserName);
		driver.get("https://the-internet.herokuapp.com/");
	}
	
	@Test
	public void testDragAndDrop() throws InterruptedException {
		InternetHookup obj = new InternetHookup(driver);
		obj.goToLink("Drag and Drop");
		obj.dragAndDrop("A", "B");
	}
	
	@Test
	public void testRightClickPopup() throws InterruptedException {
		InternetHookup obj = new InternetHookup(driver);
		obj.goToLink("Context Menu");
		obj.contextPopup();
	}
	
	@Test
	public void testFileUploader() throws InterruptedException {
		InternetHookup obj = new InternetHookup(driver);
		obj.goToLink("File Upload");
//		Thread.sleep(20000);
		obj.fileUpload();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
