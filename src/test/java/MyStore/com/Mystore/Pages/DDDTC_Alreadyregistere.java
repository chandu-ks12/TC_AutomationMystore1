package MyStore.com.Mystore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MyStore.com.Mystore.BasePages;

public class DDDTC_Alreadyregistere extends BasePages{

	
	public DDDTC_Alreadyregistere(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements( driver , this);
	}
		// TODO Auto-generated constructor stub
	


	@FindBy(name = "email")
	private WebElement emailTxtBox;
	
	@FindBy(name = "passwd")
	private WebElement passwdTxtBox;
	
	@FindBy(name = "SubmitLogin")
	private WebElement SubmitLoginBtn;

	
	public void registered(String email , String passwd) {
		
		emailTxtBox.clear();
		emailTxtBox.sendKeys(email);
		
		passwdTxtBox.clear();
		passwdTxtBox.sendKeys(passwd);
		
		SubmitLoginBtn.click();
		
		System.out.println("Alreadyregistered Complited");
		
	}
}
		

