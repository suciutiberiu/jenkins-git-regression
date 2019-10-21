package com.expedia.flightsbooking_profiles;

import org.testng.annotations.Test;
import pageclasses.SearchPage;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TestNG_TestSuite {
	private WebDriver driver;
	private String baseUrl;
	private static final Logger log = LogManager.getLogger(TestNG_TestSuite.class.getName());
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Selenium WebDrive\\selenium\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  baseUrl = "https://www.expedia.com/";
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//  PropertyConfigurator.configure("log4j2-test.properties");
	  driver.get(baseUrl);
  }
  @Test
  public void fillBasicInfo() throws Exception {
	  SearchPage.navigateToFlightsTab(driver);
	  SearchPage.fillOriginTextBox(driver, "New York");
	  SearchPage.fillDestinationTextBox(driver, "Chicago");
	  SearchPage.fillDepartureDateTextBox(driver, "5/9/2019");
	 // SearchPage.clearInput(element, driver);
	  SearchPage.fillReturnDateTextBox(driver, "5/13/2019");
  }
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
}