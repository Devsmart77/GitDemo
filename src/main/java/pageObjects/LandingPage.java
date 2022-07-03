package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage {

	WebDriver driver;
	
	By LoginButton = By.xpath("//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a");
	By Text = By.xpath("//div[@class='text-center']/h2");
	By Contact = By.xpath("//div[@class='container']/nav/ul/li[8]");
	////*[@id="homepage"]/header/div[1]/div/nav/ul/li[4]/a
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getLogin() {
		
		return driver.findElement(LoginButton);
	}
	public WebElement getTitleText() {
		return driver.findElement(Text);
	}
	public WebElement contact() {
		return driver.findElement(Contact);
	}
}
