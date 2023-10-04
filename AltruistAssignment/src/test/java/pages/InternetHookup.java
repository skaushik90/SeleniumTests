package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InternetHookup {
	WebDriver driver = null;
	public InternetHookup(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToLink(String str) { 
		driver.findElement(By.xpath("//*[text()='"+str+"']")).click();
	}
	
	public void dragAndDrop(String str, String str1) {
		Actions action = new Actions(driver);
		WebElement from =driver.findElement(By.xpath("//*[text()='"+str+"']"));
		WebElement to =driver.findElement(By.xpath("//*[text()='"+str1+"']"));
		action.dragAndDrop(from, to).perform();
	}
	
	public void contextPopup() {
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.id("hot-spot"))).perform();
		driver.switchTo().alert().accept();
	}
	
	public void fileUpload() {
//		Actions action = new Actions(driver);
		driver.findElement(By.id("file-upload")).sendKeys("/Users/ksrinivasan/Desktop/SQL Join.png");
		driver.findElement(By.id("file-upload")).submit();
		
	}
}
