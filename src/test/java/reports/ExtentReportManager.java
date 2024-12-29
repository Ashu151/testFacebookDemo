package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;  // Use SparkReporter
import com.aventstack.extentreports.Status;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // Initialize ExtentReports object
    public static void createInstance() {
        if (extent == null) {
            String reportPath = "target/extent-report.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
    }

    // Start a new test
    public static void startTest(String testName, String description) {
        ExtentTest extentTest = extent.createTest(testName, description);
        test.set(extentTest);
    }

    // Get current test
    public static ExtentTest getTest() {
        return test.get();
    }

    // Flush the report after test execution
    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
