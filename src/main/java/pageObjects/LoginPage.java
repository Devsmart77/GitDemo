package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By emailBox = By.id("user_email");
	By passBox = By.id("user_password");
	By loginButton = By.name("commit");
	By forgetPass = By.linkText("Forgot Password?");
	By alertmsg = By.xpath("//div[@role='alert']");
	
	
	public WebElement getEmail() {
		return driver.findElement(emailBox);
	}
	
	public WebElement getPassword() {
		return driver.findElement(passBox);
	}
	
	public WebElement loginBtn() {
		return driver.findElement(loginButton);
	}
	
	public WebElement forgetPasswd() {
		return driver.findElement(forgetPass);
	}
	
	public WebElement alertMsg() {
		return driver.findElement(alertmsg);
	}
}
