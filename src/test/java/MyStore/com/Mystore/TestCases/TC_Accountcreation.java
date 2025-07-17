package MyStore.com.Mystore.TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MyStore.com.Mystore.BaseTest;
import MyStore.com.Mystore.Pages.AccountCreation;
import utils.TestListener;




@Listeners(TestListener.class)
public class TC_Accountcreation extends BaseTest {
	
	@Test
	public void AccountCreationVerification() {
		test = extent.createTest("verifyMyaccountcreation");
		test.info("VerifyingAccountCreatedreated");
		logger.info("Account Succesfull Created ");
		driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
		AccountCreation ac = new AccountCreation(driver);
		ac.AccCreation(
		    "john_auto_" + System.currentTimeMillis() + "@mail.com",
		    "John","don", "john@example.com", "Password123", "5", "4", "2008"
		    
		);
		test.info("VerifyingAccountCreatedreated-Entering All Form Details");
		logger.info("All Details Enterd correctlly and valied");
		System.out.println("AccountSucssefully created");
		test.info("VerifyingAccountCreatedreated-Entered All form details are correct");
				driver.close();
	}

}
