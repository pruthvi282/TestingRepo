package genericlib;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener {
	static WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;

	public void onTestStart(ITestResult result) {
		 test=report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+"passs");
	}

	public void onTestFailure(ITestResult result) {
		WebDriverUtlitiy web=new WebDriverUtlitiy();
		try {
			web.TakeScreenShot(result.getMethod().getMethodName(), driver);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+"skipped");
	}

	
	public void onStart(ITestContext context) {
		ExtentSparkReporter reporter=new ExtentSparkReporter("./report.html");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("TestReporter");
		report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("os", "windows");
		report.setSystemInfo("Enviornmnet", "Stage");
		report.setSystemInfo("Application", "web");
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

	
}
