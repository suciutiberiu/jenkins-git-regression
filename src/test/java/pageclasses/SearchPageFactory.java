package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {
	WebDriver driver;
	
	@FindBy(id="header-history")
	WebElement headerHistory;
	
	@FindBy(xpath="//button[@id='tab-flight-tab-hp']")
	WebElement flightTab;
	
	@FindBy(id = "flight-origin-hp-flight")
	WebElement originCity;
	
	@FindBy(id = "flight-destination-hp-flight")
	WebElement destinationCity;
	
	@FindBy(id = "flight-departing-hp-flight")
	WebElement departuredDate;	
	
	@FindBy(id = "flight-returning-hp-flight")
	WebElement returnDate;
	
	public SearchPageFactory(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	public void clickFlightTab() {
		//headerHistory.click();
		flightTab.click();
	}
	
	public void setOriginCity(String origin) {
		originCity.sendKeys(origin);
	}
	
	public void setDestinationCity(String destination) {
		destinationCity.sendKeys(destination);
	}
	
	public void setDeparturedDate(String depature) {
		departuredDate.sendKeys(depature);
	}
	
	public void setReturnDate(String returnD) {
		returnDate.sendKeys(returnD);
	}
}
