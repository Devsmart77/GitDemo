package Academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver InitializeDriver() throws IOException {

		FileInputStream fin = new FileInputStream(
				"C:\\Users\\MAHADEV\\eclipse-workspace\\E2EProject\\src\\main\\java\\Academy\\config.properties");
		prop = new Properties();

		prop.load(fin);
		//String BrowserName = prop.getProperty("browser");
		String BrowserName = System.getProperty("browser");
		

		if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
		} else if (BrowserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (BrowserName.equals("opera")) {
			System.setProperty("webdriver.opera.driver",
					System.getProperty("user.dir")+"\\Drivers\\operadriver.exe");
			driver = new OperaDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	public String getScreenshots(String testMethodName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path= "C:\\Users\\MAHADEV\\eclipse-workspace\\E2EProject\\Screenshots\\"+testMethodName+".png";
		FileUtils.copyFile(src, new File(path));
		return path;
	}

	
}
