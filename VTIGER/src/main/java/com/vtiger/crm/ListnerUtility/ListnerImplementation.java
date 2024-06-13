
package com.vtiger.crm.ListnerUtility;

import java.io.File;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.BaseClass;
import com.vtiger.crm.generic.webdriverutility.UtilityClassobject;

/**
 * Listener Implementation class
 * @author Neelima
 *
 */
public class ListnerImplementation implements ITestListener,ISuiteListener {
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test ;
	
	public void onStart(ISuite suite) {

		String date=new Date().toString().replace(" ", "_").replace(":", "_");
		//Spark Report Config
		System.out.println("Report configuration");
		spark=new ExtentSparkReporter("./AdvanceReport/report"+date+".html");
		spark.config().setDocumentTitle("Test Suite Result");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK); 

		//Add environment info and create Test
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();    
		
		test=report.createTest(methodName);
		UtilityClassobject.setTest(test);
		test.log(Status.INFO, methodName+"On Test Started");

	}

	public void onTestFailure(ITestResult result) {

		String date=new Date().toString().replace(" ", "_").replace(":", "_");
		String testName = result.getMethod().getMethodName(); 

		//		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		//		File src = ts.getScreenshotAs(OutputType.FILE);
		//		File des = new File("./Screenshot/"+testName+date+".png");
		//		String path = des.getAbsolutePath();
		//		
		//		test.addScreenCaptureFromPath(path);
		//		test.log(Status.FAIL, testName+"Fail");

		//		try {
		//			FileHandler.copy(src,des);
		//		} catch (IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}

		TakesScreenshot ts=(TakesScreenshot)UtilityClassobject.getDriver();
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath, testName+"_"+date);
		test.log(Status.FAIL, testName+"On Test Fail");

	}

	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		test.log(Status.PASS,testName+"  On Test Success");
		//	result.getName()----> To get this method name
	}

	
	public void onFinish(ISuite suite) {
		test.log(Status.INFO, "Report Backup");
		report.flush();
	}

}
