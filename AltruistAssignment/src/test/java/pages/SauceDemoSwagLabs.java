package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SauceDemoSwagLabs {
	
	WebDriver driver = null;
	By sortDropDown = By.className("product_sort_container");
	
	public SauceDemoSwagLabs(WebDriver driver) {
		this.driver = driver;
	}
	
	public void sortItems(String sortOption) {
		driver.findElement(sortDropDown).click();
		driver.findElement(By.xpath("//*[value=\""+sortOption+"\"]")).click();
		
	}
	
	public void addToCart() {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(), "1");
	}
	public void checkOut(String fname, String lname, String zip) {
		driver.findElement(By.className("shopping_cart_badge")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("cart.html")); 
		driver.findElement(By.id("checkout")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"));
		driver.findElement(By.id("first-name")).sendKeys(fname);
		driver.findElement(By.id("last-name")).sendKeys(lname);
		driver.findElement(By.id("postal-code")).sendKeys(zip);
		driver.findElement(By.id("continue")).click();
	}
}
