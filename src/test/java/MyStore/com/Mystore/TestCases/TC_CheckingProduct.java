package MyStore.com.Mystore.TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MyStore.com.Mystore.BaseTest;
import MyStore.com.Mystore.Pages.CheckingProduct;
import utils.TestListener;


@Listeners(TestListener.class)
public class TC_CheckingProduct extends BaseTest {
	
	@Test
	public void CheckingOrderSummary() {
		logger.info("CheckingProductSummary");
		 test = extent.createTest("Checking OrderSummary");
	     test.info("Verifying login with credentials email");
		driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
		CheckingProduct pro = new CheckingProduct(driver);
		pro.OrderSummry("csk02547@gmail.com" , "Bond@1992");
		
	}

}
