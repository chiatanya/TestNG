package Annotation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWaits {

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/");
	}
	
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	
	@Test
	public void TestExplicitWait() {
		driver.findElement(By.linkText("Dynamic Data Loading")).click();
		driver.findElement(By.id("save")).click();
		boolean imageDisplay;
		By path=By.xpath("//div[@id='loading']//img");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(path));
		
		try {
			imageDisplay=driver.findElement(path).isDisplayed();

		} catch (NoSuchElementException e) {
		    imageDisplay = false;  // If element is not found, set imageDisplay to false
		}
		
		Assert.assertTrue(imageDisplay,"Images is not displayed");
	}
}
