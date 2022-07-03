package Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Academy.Base;
import jdk.internal.org.jline.utils.Log;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class MultipleTest extends Base {

	public static Logger Log = LogManager.getLogger(MultipleTest.class.getName());
	
	@BeforeTest
	public void browserLaunch() throws IOException {
		Log.info("Driver Initialized");
		driver = InitializeDriver();
	

	}
	@Test(dataProvider="getData")
	public void LoginChecking(String un, String pd, String txt) throws IOException {

	Log.debug("Launching the URL");
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		Log.debug("Navigate to Home Page");
		String text = lp.getTitleText().getText();
		Log.debug("Checking Assertion");
		Assert.assertEquals(text, "FEATURED COURSES");
		Log.debug("Checking Assertion for Contact link");
		Assert.assertTrue(lp.contact().isDisplayed());
		lp.getLogin().click();
		Log.debug("Clicked on Login link");
		LoginPage lg = new LoginPage(driver);
		Log.debug("Entering username");
		lg.getEmail().sendKeys(un);
		Log.debug("Entering password");
		lg.getPassword().sendKeys(pd);
		System.out.println(txt);
		Log.info("Clicking on Login button");
		lg.loginBtn().click();
		//System.out.println(lg.alertMsg().getText());
//		driver.close();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[2][3];
		data[0][0]= "abc@gmail.com";
		data[0][1]= "Password1";
		data[0][2]= "First credential entered";
		
		data[1][0]= "def@gmail.com";
		data[1][1]= "Password2";
		data[1][2]= "Second credential entered";
		
		return data;
	}

}
