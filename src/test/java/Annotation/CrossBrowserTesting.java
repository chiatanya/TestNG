package Annotation;

import java.awt.Desktop.Action;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting {
WebDriver driver;
private String username= "chaitanya_hegde";
private String accesskey="Xt5lud7bVfsIdyhmTCNMjfxV9RqWMuDYHZBH0uR0cp2jen4sy8";
private String Hub= "@hub.lambdatest.com/wd/hub";
DesiredCapabilities capabilities = new DesiredCapabilities();
	
	@Parameters(value={"Browser","Version","Platform"})
	@BeforeMethod
	public void browserLoad(String browser,String version,String platform) {
		capabilities.setCapability("build", "2.1");
		capabilities.setCapability("Name", "crossbrowser");
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("version", version);
		capabilities.setCapability("platform", platform);
		capabilities.setCapability("network", true);
		capabilities.setCapability("console", true);
		capabilities.setCapability("visual", true);
		
		try {
			driver=new RemoteWebDriver(new URL("https://"+username+":"+accesskey+Hub),capabilities);
		}
		catch (MalformedURLException exc) {
			exc.printStackTrace();
			
		}
		
	}
	@AfterMethod
	public void cut() {
		driver.quit();
	}
	
	@Test
	public void SelectDropdownList() {
		driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
		WebElement dropdown =driver.findElement(By.id("select-demo"));
		
		Select dropelement= new Select(dropdown);
		dropelement.selectByValue("Monday");
	}
	
	@Test
	public void DragandDrop() {
		driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
		Actions actions = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement Destination = driver.findElement(By.id("droppable"));
		
		actions.dragAndDrop(source, Destination).build().perform();
		
	}
}
