package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
//		
		driver.findElement(By.name("q")).sendKeys("Kaushik");
//		WebElement dropdown = driver.findElement(By.className("G43f7e"));
//		dropdown.findElement(By.xpath("//*[@id=\"Alh6id\"]/div[1]/div/ul/li[1]")).click();
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		driver.close();
		driver.quit();
	}
}
