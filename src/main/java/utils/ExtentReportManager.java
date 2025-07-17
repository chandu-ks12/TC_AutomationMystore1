package utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("Reports/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);

            // Add system/environment info
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
            extent.setSystemInfo("Environment", "QA"); // You can change based on profile
            extent.setSystemInfo("Browser", "Chrome");  // Or fetch dynamically from config

        }
        return extent;
    }
}
