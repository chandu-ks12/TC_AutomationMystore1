package MyStore.com.Mystore;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; // ✅ Correct Log4j2 Logger import
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePages {

	protected WebDriver driver;
	protected WebDriverWait wait;

	

	public BasePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}

	
}
