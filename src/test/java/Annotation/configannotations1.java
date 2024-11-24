package Annotation;

import org.testng.annotations.*;


public class configannotations1 {
	@Test(groups="Smoke")
	public void Test1() {
		System.out.println("   Print Test 1 details");
	}
	
	@Test(groups="Regression")
	public void Test2() {
		System.out.println("Print Test 2 details");
	}
	 
	@BeforeMethod
	public void BeforeTest() {
		System.out.println("Print this before running any test");
	}
	
	@AfterMethod
	public void AfterTest() {
		System.out.println("Print this After running any Test test");
	}
	
	@BeforeClass
	public void Beforeclass() {
		System.out.println("  (1)Run this before configurations1");
	}
	
	@AfterClass
	public void Afterclass() {
		System.out.println("  (1)Run this After configurations1");
	}
}

