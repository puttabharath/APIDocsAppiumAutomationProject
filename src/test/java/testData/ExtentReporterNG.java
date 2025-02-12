package testData;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReporterNG {
    public static ExtentReports getReportObject() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String formattedDateTime = now.format(formatter);

        // Construct the dynamic path with date and time
        String path = System.getProperty("user.dir") + "/reports/API_Docs_" + formattedDateTime + "_index.html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Mobile Automation Results");
        reporter.config().setDocumentTitle("API Docs Test Results");
        reporter.config().setTheme(Theme.DARK);

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Bharath Kumar Putta");
        extent.setSystemInfo("Host Name", "API Docs App");
        extent.setSystemInfo("Environment", "Automation Script - QA");
        extent.setSystemInfo("User Name", "PBK");

        return extent;
    }
}
