package Annotation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTesting2 {
	WebDriver driver;
	
	@BeforeMethod
	public void browserLoad() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://www.lambdatest.com/selenium-playground/");
		
	}
	
	
	@Test
	public void Test3Bootstrape() {
		driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-alert-messages-demo");
		System.out.println("bootstrape"+Thread.currentThread().getId());
	}
	
	@Test
	public void Test4Draganddrop() {
		driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
		System.out.println("dragdroop"+Thread.currentThread().getId());
	}

}
