package MyStore.com.Mystore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import MyStore.com.Mystore.BasePages;

public class SignInPage extends BasePages {
	
	protected WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		
		super(driver);
		 PageFactory.initElements(driver,this);
	}
	
	@FindBy(className= "login")
   protected WebElement signInBtn;

 
public void ClickBtn() {
	
	signInBtn.click();
}
}