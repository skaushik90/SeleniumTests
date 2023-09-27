package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleFinanceSearchPage {
	
	WebDriver driver = null;
	By google_Finance_SearchBox_XPath = By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[2]/div/div[3]/div[3]/div/div/div/div[1]/input[2]");
	
	public GoogleFinanceSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void textbox_search(String searchString) {
		driver.findElement(google_Finance_SearchBox_XPath).click();
		driver.findElement(google_Finance_SearchBox_XPath).sendKeys(searchString);		
	}
	
	public void search_Ticker() {
		driver.findElement(google_Finance_SearchBox_XPath).sendKeys(Keys.ENTER);
		
	}

}
