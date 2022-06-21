package com.github.rezzco.QATemplate;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public ExtentReportNG() {
		// TODO Auto-generated constructor stub
	}

	public static ExtentReports getReportObject() {
		String reportFilePath = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportFilePath);
		spark.config().setReportName("QA Template");
		spark.config().setDocumentTitle("Test Results");
		
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Rezzco");
		
		return extent;
	}
}
