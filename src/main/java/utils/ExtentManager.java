package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        reporter.config().setReportName("UI Test Results");
        reporter.config().setDocumentTitle("Automation Report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Kishor");
        return extent;
    }
}
