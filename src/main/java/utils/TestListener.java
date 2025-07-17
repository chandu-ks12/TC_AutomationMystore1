package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import MyStore.com.Mystore.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = getDriver();
        if (driver != null) {
            String testName = result.getName();
            String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String screenshotPath = "C:\\Users\\popeye\\My Coding\\com.Mystore\\Reports\\Screenshots\\" + testName + "_" + timeStamp + ".png";
                FileUtils.copyFile(screenshot, new File(screenshotPath));
                System.out.println("Screenshot saved: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WebDriver getDriver() {
        try {
			return BaseTest.driver;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ensure driver is static in BaseTest
		return null;
    }
}
