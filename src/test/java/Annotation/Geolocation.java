package Annotation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Geolocation {
	WebDriver driver;
	private String username= "chaitanya_hegde";
	private String accesskey="Xt5lud7bVfsIdyhmTCNMjfxV9RqWMuDYHZBH0uR0cp2jen4sy8";
	private String Hub= "@hub.lambdatest.com/wd/hub";
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	@BeforeClass
	public void setup() {
	/*capabilities.setCapability("build", "3.1");
	capabilities.setCapability("name", "crossbrowser");
	capabilities.setCapability("geoLocation", "IN");
	capabilities.setCapability("browserName", "chrome");
	capabilities.setCapability("version", "103.0");
	capabilities.setCapability("platform", "Windows 10");
	capabilities.setCapability("network", true);
	capabilities.setCapability("console", true);
	capabilities.setCapability("visual", true); */
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("130");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "chaitanya_hegde");
		ltOptions.put("accessKey", "Xt5lud7bVfsIdyhmTCNMjfxV9RqWMuDYHZBH0uR0cp2jen4sy8");
		ltOptions.put("geoLocation", "IN");
		ltOptions.put("project", "Untitled");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		browserOptions.setCapability("LT:Options", ltOptions);
	
	
	
	try {
		driver=new RemoteWebDriver(new URL("https://"+username+":"+accesskey+Hub),browserOptions);
	}
	catch (MalformedURLException exc) {
		exc.printStackTrace();
		
	}
	driver.get("https://where-am-i.org/");
}
	@Test
	public void Testgeolocation() {
		WebElement ele = driver.findElement(By.id("address"));
		System.out.println(ele.getText());
	}
	
}
