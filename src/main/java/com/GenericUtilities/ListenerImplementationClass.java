package com.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass  implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		//execution start from here
		String MethodName=result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"-----> TestScript Execution Started");
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"---->Passed" );
		Reporter.log(MethodName+"-----> TestScript Execution Successful");

	}
	public void onTestFailure(ITestResult result) {
//		String FScript=result.getMethod().getMethodName();
//		String FS=FScript+ new JavaUtility().getSystemDate();
//	EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
//	File src=edriver.getScreenshotAs(OutputType.FILE);
//	File dst=new File("./Screenshot/"+FS+".png");
//	File path=dst.getAbsoluteFile();
//	try {
//		FileUtils.copyFile(src, dst);
//	} 
//	catch (IOException e) {
//		e.printStackTrace();
//	}
		try {
			String screenshotname=WebDriverUtility.getScreenShot(BaseClass.sdriver,result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshotname);
		}catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		test.log(Status.FAIL,result.getThrowable() );
		Reporter.log("TestScript Execution Failed");
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.SKIP,MethodName+"---->Skipped" );
		Reporter.log(MethodName+"-----> TestScript Execution Skipped");

	}
	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtnetReport/report.html");
		htmlReport.config().setDocumentTitle("project TY Sdet 47");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Sale");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base_Browser", "Chrome");
		report.setSystemInfo("OS", "window");
		report.setSystemInfo("Base_url", "https://localhost:3333");
		report.setSystemInfo("Reporter_Name", "V_K");
	}

	public void onFinish(ITestContext context) {
	//consolidate the report
		report.flush();
	}

}
