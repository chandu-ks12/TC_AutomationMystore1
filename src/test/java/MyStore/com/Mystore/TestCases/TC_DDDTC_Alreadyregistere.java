package MyStore.com.Mystore.TestCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MyStore.com.Mystore.BaseTest;
import MyStore.com.Mystore.Pages.Alreadyregistered;
import utils.DataProviders;
import utils.TestListener;

@Listeners(TestListener.class)
public class TC_DDDTC_Alreadyregistere extends BaseTest {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verifyRegistration(String email, String password) {  // ✅ Accept parameters

        test = extent.createTest("Login Test with: " + email);
        test.info("Verifying login with credentials: " + email);

        logger.info("Testing login with email: " + email);
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

        Alreadyregistered al = new Alreadyregistered(driver);
        al.registered(email, password); // ✅ Using dynamic data

        test.info("Verifying redirection to account page");
        String expectedUrl = "http://www.automationpractice.pl/index.php?controller=my-account";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed or wrong redirection.");

        logger.info("URL matched, login successful for: " + email);
        driver.close();
    }
}
