package Annotation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autmation_Paramaterized {
	WebDriver driver;
	
	@Parameters("URL")
	@BeforeMethod
	public void setup(String url) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	@Test
	@Parameters({"Task","Execute"})
	public void filedownload(String task,String execute) {
		driver.findElement(By.linkText("File Download")).click();
		driver.findElement(By.id("textbox")).sendKeys(task+"File Execution"+execute);
		driver.findElement(By.id("create")).click();
		driver.findElement(By.id("link-to-download")).click(); 
	}
	
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
