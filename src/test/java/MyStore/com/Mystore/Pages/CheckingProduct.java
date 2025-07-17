package MyStore.com.Mystore.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MyStore.com.Mystore.BasePages;


public class CheckingProduct extends BasePages {

	public CheckingProduct(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements( driver , this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}

	@FindBy(className ="login")
	private WebElement logiBtn;
	
	@FindBy(name ="email")
	private WebElement usernametxtbox;
	
	@FindBy(name ="passwd")
	private WebElement paaswordnametxtbox;
	
	@FindBy(name ="SubmitLogin")
	private WebElement submitbtn;
	
	@FindBy(xpath="//span[normalize-space()='Order history and details']")
	private WebElement ordersummarybtn;

	public  void OrderSummry(String username , String password) {
		
		logiBtn.click();
		usernametxtbox.sendKeys(username);
		paaswordnametxtbox.sendKeys(password);
		submitbtn.click();
		ordersummarybtn.click();
	}
	
}
