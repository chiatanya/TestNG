package Annotation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation_TakeScreenshot {
	WebDriver driver;
	
	@BeforeClass
	public void Serup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/");
	}
	
	@Test
	public void SimpleFormDeo() {
		driver.findElement(By.linkText("Simple Form Demo")).click();
		driver.findElement(By.id("user-message")).sendKeys("ScreenShot");
		driver.findElement(By.id("showInput")).click();
		String Message=driver.findElement(By.id("message")).getText();
		Assert.assertEquals(Message, "ScreeniShot","Message is not same");
		
	}
	
	@AfterMethod
	public void TakeScreenShot(ITestResult testresult) throws IOException {
		if(ITestResult.FAILURE==testresult.getStatus()) {
		TakesScreenshot screenshot = (TakesScreenshot) driver; //interface takeshot and casting what is that
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\chegd\\eclipse-workspace\\TestNg\\Resource\\ScreenShot/"+testresult.getName()+".png");
		FileHandler.copy(source,destination);
	}
		
	}
	@AfterClass
	public void quit() {
		driver.quit();
	}
	
	
}
