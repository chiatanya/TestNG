package Annotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class configannotations2 {
	@Test(groups="Smoke")
	public void Test3() {
		System.out.println("   Print Test 3 details");
	}
	
	@Test(groups="Regression")
	public void Test4() {
		System.out.println("Print Test 4 details");
	}
	 
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("Print this before running any test for configannotations2");
	}
	
	@AfterMethod
	public void AfterMethod() {
		System.out.println("Print this After running any  test for configannotations2");
	}
	
	@BeforeClass
	public void Beforeclass() {
		System.out.println("  (2)Run this before configurations2 class");
	}
	
	@AfterClass
	public void Afterclass() {
		System.out.println("  (2)Run this After configurations2 class");
	}
	
	@BeforeTest
	public void BeforeTest() {
		System.out.println("22  Before Each Test");
	}
	
	@AfterTest
	public void AfterTest() {
		System.out.println("22  After Each Test");
	}
	
	@BeforeGroups(groups= {"Regression","Smoke"})
	
		public void beforegroup() {
			System.out.println("before group");
		}
	@AfterGroups(groups= {"Regression","Smoke"})
	
	public void aftergroup() {
		System.out.println("After group");
	}
}
