package Annotation;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumcloudjiolocation {
	WebDriver driver;
	@BeforeMethod
	public void browserLoad() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/");
		
	}
	
	@Test
	public void loc() {
		Map<String, Object> geoParams = new HashMap<String, Object>();
		geoParams.put("latitude", 25.1972);
		geoParams.put("longitude", 55.2744);
		geoParams.put("accuracy", 1);
		((ChromiumDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride",geoParams);
		driver.get("https://where-am-i.org/");
	}
	
}
