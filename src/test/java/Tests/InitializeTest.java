package Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Academy.Base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class InitializeTest extends Base {

	@BeforeTest
	public void browserLaunch() throws IOException {
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void LaunchBrowser() throws IOException {

	
		
		
		LandingPage lp = new LandingPage(driver);
		String text = lp.getTitleText().getText();
		Assert.assertEquals(text, "FEATURED COURSES");
		Assert.assertTrue(lp.contact().isDisplayed());
//		lp.getLogin().click();
//		LoginPage lg = new LoginPage(driver);
//		lg.getEmail().sendKeys(un);
//		lg.getPassword().sendKeys(pd);
//		System.out.println(txt);
//		lg.loginBtn().click();
//		System.out.println(lg.alertMsg().getText());
////		driver.close();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	//@DataProvider
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
