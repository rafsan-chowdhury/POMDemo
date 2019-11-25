package com.demo.qa.extentReportListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportListener implements ITestListener{

	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest test;

	public ExtentReportListener()
	{
		htmlReporter=new ExtentHtmlReporter("Demo_Extent_Report.html");
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		test=extent.createTest("Test Report"," Description");
	}

	public void onTestStart(ITestResult result) {
		test=extent.createTest("Test Report for: "+result.getName()," Description");
		test.log(Status.INFO, "Starting Tests for : "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getName()+" is passed ");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getName()+" is failed ");
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
	{		

	}	
	public void onTestSkipped(ITestResult result) {
		if(result.wasRetried()) {
			test.log(Status.WARNING, result.getName()+" is retried ");
		}else {
			test.log(Status.SKIP, result.getName()+" is skipped ");
		}
		
	}

	public void onStart(ITestContext context) {
		test.info("Test started");
		test.info("Open the Browser");
		test.log(Status.PASS, "Navigate to the testing URL");

	}

	public void onFinish(ITestContext context) {
		test.info("Closed the browser");
		test.info("Test Completed");
		extent.flush();	

	}


}
