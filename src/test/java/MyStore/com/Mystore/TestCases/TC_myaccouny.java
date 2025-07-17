package MyStore.com.Mystore.TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MyStore.com.Mystore.BaseTest;
import MyStore.com.Mystore.Pages.myaccount;
import utils.TestListener;

@Listeners(TestListener.class)
public class TC_myaccouny extends BaseTest {
	
	
	@Test
	
	public void verifyMyaccount() {
		test = extent.createTest("verifyMyaccount");
		test.info("VerifyingAccount");
		logger.info("Entering Email Id of user ");
		logger.info("AccountVerifyied with valied credentials");
		driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
		
		myaccount acc = new myaccount(driver);
		
		logger.info("Submit Complited");
		acc.ClickOnSubmit("csk02547@gmail.com");
		
		System.out.println("MyAccount Complited");
		driver.close();
	}

}
