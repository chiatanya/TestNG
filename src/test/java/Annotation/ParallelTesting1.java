package Annotation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTesting1 {
	WebDriver driver;
	
	@BeforeMethod
	public void browserLoad() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://www.lambdatest.com/selenium-playground/");
		
	}
	
	
	@Test
	public void Test_1datePicker() {
		driver.get("https://www.lambdatest.com/selenium-playground/jquery-date-picker-demo");
		System.out.println("datePicker"+Thread.currentThread().getId());
	}
	
	@Test
	public void Test2dataListFilter() {
		driver.get("https://www.lambdatest.com/selenium-playground/data-list-filter-demo");
		System.out.println("Data Filter"+Thread.currentThread().getId());
	}

}
