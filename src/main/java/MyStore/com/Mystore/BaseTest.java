package MyStore.com.Mystore;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; // ✅ Correct import

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.EmailReportSender;
import utils.ExtentReportManager;

public class BaseTest { 

    public static WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;

    // ✅ Proper logger declaration
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
	//private static final String ExtentReportManager = null;

    @BeforeSuite
    public void setUpReport() {
    	
    	//Extent Report generation
        extent = ExtentReportManager.getReportInstance();  // Initializes the report
    }
//Listner TestListenerAdapter tla = new TestListenerAdapter();
 

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
    }

    public WebDriver getDriver() {
        return driver;
    }

    // VERY IMPORTANT!

            @AfterSuite
            public void tearDown() {
                if (extent != null) {
                    extent.flush(); // Finish report writing
                }

                String reportPath = "C:\\Users\\popeye\\My Coding\\com.Mystore\\Reports\\ExtentReport.html";
                String recipient = "csk02547@gmail.com";

                EmailReportSender.sendReportByEmail(recipient, reportPath);
            }
        
        
    }

