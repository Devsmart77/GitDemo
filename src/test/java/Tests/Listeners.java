package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Academy.Base;
import Academy.ExtentReportDemo;

public class Listeners extends Base implements ITestListener {
	ExtentTest test;
	ExtentReports report = ExtentReportDemo.config();
	ThreadLocal<ExtentTest> ExtentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = report.createTest(result.getMethod().getMethodName());
		ExtentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest.get().log(Status.PASS, "Test is passed successfully");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest.get().fail(result.getThrowable());
		String testMethodName = result.getMethod().getMethodName();
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		try {
			ExtentTest.get().addScreenCaptureFromPath(getScreenshots(testMethodName, driver), testMethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		report.flush();
	}

}
