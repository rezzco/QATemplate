package com.github.rezzco.QATemplate;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener extends Base implements ITestListener{
private WebDriver driver;
private ExtentReports extent= ExtentReportNG.getReportObject();
private ExtentTest test;
 
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName().toUpperCase());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
//		Test to take screenshot whenever it encounters an error
		String testFailName = result.getMethod().getMethodName();
try {
	driver=(WebDriver)result
			.getTestClass()
			.getRealClass()
			.getDeclaredField("driver")
			.get(result.getInstance());
} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		try {
			captureScreenshot(driver,testFailName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
