package reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // Log the start of the test
        ExtentReportManager.startTest(result.getName(), result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log success for the test
        ExtentTest test = ExtentReportManager.getTest();
       // test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log failure for the test
        ExtentTest test = ExtentReportManager.getTest();
       // test.log(Status.FAIL, "Test failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log skipped tests
        ExtentTest test = ExtentReportManager.getTest();
       // test.log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not used in this example
    }

    @Override
    public void onStart(ITestContext context) {
        // Setup for report
        ExtentReportManager.createInstance();
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush reports after tests complete
        ExtentReportManager.flushReports();
    }
}
