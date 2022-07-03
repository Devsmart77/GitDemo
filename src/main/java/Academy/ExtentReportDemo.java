package Academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	static ExtentReports report;
	@BeforeTest
	public static ExtentReports config() {
	String path = System.getProperty("user.dir")+"\\reports\\report.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	
	reporter.config().setReportName("My new report");
	reporter.config().setDocumentTitle("Mahadev Report");
	
	report = new ExtentReports();
	report.attachReporter(reporter);
	return report; 
	
	}
	
	
	
}
