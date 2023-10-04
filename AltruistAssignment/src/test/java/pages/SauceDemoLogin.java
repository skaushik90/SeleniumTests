package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceDemoLogin {
	WebDriver driver = null;
	By userName = By.id("user-name");
	By password = By.id("password");
	By loginBtn = By.id("login-button");
	
	public SauceDemoLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String userName, String password) {
		driver.findElement(this.userName).sendKeys(userName);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(loginBtn).click();		
	}
}
