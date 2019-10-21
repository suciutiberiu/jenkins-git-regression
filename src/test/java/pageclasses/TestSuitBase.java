package pageclasses;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestSuitBase {
	protected WebDriver driver;
	protected SearchPageFactory search;

	@Parameters({ "platform", "browser", "version", "URL" })
	@BeforeClass(alwaysRun = true)
	public void setup(String platform, String browser, String version, String URL) throws MalformedURLException {
		driver = getDriverInstance(platform, browser, version, URL);
		search = PageFactory.initElements(driver, SearchPageFactory.class);
	}

	public static WebDriver getDriverInstance(String platform, String browser, String version, String URL)
			throws MalformedURLException {
		String nodeURL = "http://192.168.1.5:5555/wd/hub";
		WebDriver driver = null;
		DesiredCapabilities caps = new DesiredCapabilities();

		// Platform
		if (platform.equalsIgnoreCase("Windows")) {
			caps.setPlatform(Platform.WINDOWS);
		}
		if (platform.equalsIgnoreCase("MAC")) {
			caps.setPlatform(Platform.MAC);
		}

		// browser
		if (browser.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		}
		
		//Version
		caps.setVersion(version);
		driver=new RemoteWebDriver(new URL(nodeURL), caps);
		
		//Maximize the browser's window
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Open the Application
		driver.get(URL);
		return driver;
	}

}
