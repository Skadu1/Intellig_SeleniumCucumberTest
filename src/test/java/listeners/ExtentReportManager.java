package listeners;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {
    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        // Specify the path where the report will be generated
        String reportPath = "test-output/ExtentSparkReport.html";

        // Create an instance of ExtentSparkReporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

        // Configure the SparkReporter settings
        sparkReporter.config().setDocumentTitle("Test Automation Report");
        sparkReporter.config().setReportName("Functional Test Report");
        sparkReporter.config().setTheme(Theme.DARK);  // Optional: Dark theme

        // Create an instance of ExtentReports and attach the SparkReporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Computer Name","LocalHost");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("Tester Name","Sreedeep");
        extent.setSystemInfo("os","windows 10");
        extent.setSystemInfo("Browser Name","Chrome");

    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test in the report when a test starts
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log success if the test passes
        test.pass("Test passed successfully.");
        test.log(Status.PASS,"Test case passed is "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log failure and add screenshot if needed
        test.fail("test failed");
        test.log(Status.FAIL,"Test case failed is "+result.getName());
        test.fail(result.getThrowable());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log skipped tests
        test.skip("Test skipped.");
        test.log(Status.SKIP,"Test skipped is "+result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush the extent report at the end of the test run
        extent.flush();
    }
}


