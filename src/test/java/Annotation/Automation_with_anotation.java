package Annotation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation_with_anotation {
	WebDriver driver;
@BeforeClass
public void browserLoad() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	//driver.get("https://www.lambdatest.com/selenium-playground/");
	
}

@AfterClass
public void BrowserCLose() {
	driver.quit();
}

@Test
public void TableSarch() {
	
	driver.findElement(By.xpath("//a[text()='Table Sort & Search']")).click();
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Bennett");
	
}
@Test
public void DatePicker() {
	driver.findElement(By.linkText("Bootstrap Date Picker")).click();
	driver.findElement(By.xpath("//input[@type='date']")).sendKeys("01/16/1999");
}

@BeforeMethod
public void Home() {
	driver.get("https://www.lambdatest.com/selenium-playground/");
}


}
