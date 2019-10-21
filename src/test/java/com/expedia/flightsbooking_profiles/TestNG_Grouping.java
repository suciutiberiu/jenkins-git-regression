package com.expedia.flightsbooking_profiles;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;

public class TestNG_Grouping {
	
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		System.out.println("This method runs before class");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		System.out.println();
		System.out.println("This method runs before every method");
	}

	@Test(groups = {"car","suv"})
	public void testBMWX6() {
		System.out.println("Running test -> BMW X6");
	}
	
	@Test(groups = {"car", "sedan"})
	public void testAudiA6() {
		System.out.println("Running test -> Audi A6");
	}
	
	@Test(groups = {"bikes"})
	public void testNinja() {
		System.out.println("Running test -> Kawasaki Ninja");
	}
	
	@Test(groups = {"bikes"})
	public void testHondaCBR() {
		System.out.println("Running test -> Honda CBR");
	}

	@AfterClass(alwaysRun = true)
	public void cleanUp() {
		System.out.println();
		System.out.println("This method runs after class");
	}

}
