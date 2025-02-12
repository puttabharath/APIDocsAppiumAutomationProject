package testComponents;

import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import pages.BaseTest;
import testData.ExtentReporterNG;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {
    private ExtentTest test;
    private final ExtentReports extent = ExtentReporterNG.getReportObject();
    private final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        AndroidDriver driver = null;

        try {
            driver = (AndroidDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());
        } catch (Exception e) {
            extentTest.get().log(Status.FAIL, "Failed to fetch AndroidDriver instance: " + e.getMessage());
        }

        if (driver != null) {
            try {
                String filePath = getScreenshot(result.getMethod().getMethodName(), driver);
                if (filePath != null) {
                    extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
                } else {
                    extentTest.get().log(Status.FAIL, "Screenshot path is null.");
                }
            } catch (IOException e) {
                extentTest.get().log(Status.FAIL, "Failed to capture screenshot: " + e.getMessage());
            }
        } else {
            extentTest.get().log(Status.FAIL, "Driver instance is null, screenshot not captured.");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
