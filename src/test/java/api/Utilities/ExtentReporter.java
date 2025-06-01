package api.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentReporter  implements ITestListener {

	public static ExtentSparkReporter spark;
	public static ExtentReports ereports;
	public static ExtentTest etests;
	
	public void onStart(ITestContext Context) {
		
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/myReport.html");
		spark.config().setDocumentTitle("ExtentReport for My First Test Case");
		spark.config().setReportName("First Test Case EXtent Report");
		spark.config().setTheme(Theme.DARK);
		
		ereports=new ExtentReports();
		ereports.attachReporter(spark);
		
		ereports.setSystemInfo("Name", "Thirupathi");
		ereports.setSystemInfo("City", "Hyderabad");		
		
	}
	
	public void onTestSuccess(ITestResult result) {
		etests=ereports.createTest(result.getName());
		etests.log(Status.PASS,"TestCase is Success&   :   "+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		etests=ereports.createTest(result.getName());
		etests.log(Status.FAIL,"Test case failed*    :   "+result.getThrowable());
	}
	public void onTestSkipped(ITestResult result) {
		etests=ereports.createTest(result.getName());
		etests.log(Status.SKIP,"Test Case Skipped   :  "+result.getName());
	}
	
	public void onFinish(ITestContext context) {
		ereports.flush();
	}
	
	
	
}
