package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleFinanceSearchPage {
	
	WebDriver driver = null;
	By google_Finance_SearchBox_XPath = By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[2]/div/div[3]/div[3]/div/div/div/div[1]/input[2]");
	By suggestion_Box_Open = By.className("mLoZRc");
	
	public GoogleFinanceSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void textbox_search(String searchString) {
		driver.findElement(google_Finance_SearchBox_XPath).click();
		driver.findElement(google_Finance_SearchBox_XPath).sendKeys(searchString);		
	}
	
	public void search_Ticker(String selectDataPoint) throws InterruptedException {
//		driver.findElement(google_Finance_SearchBox_XPath).sendKeys(Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-exchange=\"BMV\"]")));
		
//		WebElement dropDown = driver.findElement(suggestion_Box_Open);
//		
////		Thread.sleep(20000);
//		dropDown.findElement(By.xpath("//*[@id=\"nngdp1631\"]")).click();
		driver.findElement(By.xpath("//*[@data-exchange=\"BMV\"]")).click();
		
		
	}

}
