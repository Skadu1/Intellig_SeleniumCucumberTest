package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
       System.out.println("Started the test execution");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting Test");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("test case skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Ending the test execution");
    }

}
