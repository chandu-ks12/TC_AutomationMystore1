package MyStore.com.Mystore.TestCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MyStore.com.Mystore.BaseTest;

import MyStore.com.Mystore.Pages.SignInPage;
import MyStore.com.Mystore.Pages.myaccount;
import utils.TestListener;


@Listeners(TestListener.class)
public class TC_SignInPage extends BaseTest {
	
	protected WebDriverWait wait;
	@Test
	public void VeryFySignInPage() {
		//test = extent.createTest("VeryFySignInPage");
		test = extent.createTest("Login Test").assignAuthor("Chandrakant").assignCategory("Regression");
		logger.info("Launching browser");
		 test.info("Launching browser");
	        test.pass("Browser launched successfully");

	        test.info("Navigating to login page");
		driver.get("http://www.automationpractice.pl/index.php");
		//SimpleLounch pg = new SimpleLounch(driver);
		
		 SignInPage pg = new SignInPage(driver);
		
		pg.ClickBtn();
		
		
		myaccount ac = new myaccount(driver);
		
		ac.ClickOnSubmit("kchandaneng@gmail.com");
		System.out.println("SignIn Complited");
		
		String expectedUrl = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
		String actualUrl = driver.getCurrentUrl();

		//Checking Asssertion and printing in log file if matching fails
		try {
		    Assert.assertEquals(actualUrl, expectedUrl);
		    logger.info("✅ URL matched: " + actualUrl);
		    test.pass("URL matched: " + actualUrl);
		} catch (AssertionError e) {
		    logger.error("❌ URL not matched! Expected: " + expectedUrl + ", but got: " + actualUrl);
		    test.fail("URL mismatch - Expected: " + expectedUrl + " but got: " + actualUrl);
		    throw e;  // Re-throw to ensure test still fails
		}

		logger.info("Checking URL completed.");
	}

}
