package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleFinanceChartPage {
	
	WebDriver driver = null;
	By graph_Class_Name = By.className("ushogf"); 
	By prev_Close_Price_Class = By.className("pFZ9G");
	
	public GoogleFinanceChartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void wait_For_Page_Load() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(graph_Class_Name));
		
	}
	
	public String get_Prev_Close_Price() {
		String prev_close = driver.findElement(prev_Close_Price_Class).getText();		
		
		// Split the string. Make sure the first 2 words are "Prev" and "close" as 
		// verification and print the final value
		String[] outputArray = prev_close.split(" ");
		
		if (outputArray.length == 3  && outputArray[0].equals("Prev") && outputArray[1].equals("close") ) {
			return outputArray[2];
		} else {
			return "ERROR";
		}
	}
}
