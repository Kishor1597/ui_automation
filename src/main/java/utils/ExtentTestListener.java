package utils;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

public class ExtentTestListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        StepLogger.setTest(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.initDriver();
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
        test.get().fail(result.getThrowable());
        test.get().addScreenCaptureFromPath(screenshotPath);
        StepLogger.fail("Test Failed with screenshot: " + screenshotPath);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
