package com.blackTouch.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;
public class ExtentManager {
	
	    private static ExtentReports extent;
	    private static ExtentTest test;

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
	            
	            
	            spark.config().setDocumentTitle("Automation Test Report");
	            spark.config().setReportName("BlackTouch Test Execution Report");
	            spark.config().setTheme(Theme.DARK);
	            
	            
	            extent = new ExtentReports();
	            extent.attachReporter(spark);
	            
	            
	            extent.setSystemInfo("Tester", "Prasad Prashant Vernekar");
	            extent.setSystemInfo("Browser", "Chrome");
	            extent.setSystemInfo("Browser", "Firefox");
	            extent.setSystemInfo("Browser", "Microsoft Edge");
	        }
	        return extent;
	    }

	    public static ExtentTest createTest(String testName) {
	        test = getInstance().createTest(testName);
	        return test;
	    }

	    public static void flushReports() {
	        if (extent != null) {
	            extent.flush();
	        }
	    }


}
