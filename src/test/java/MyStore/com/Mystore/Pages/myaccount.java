package MyStore.com.Mystore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MyStore.com.Mystore.BasePages;

public class myaccount extends BasePages {

	public myaccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver , this);
	}
		@FindBy(name= "email_create")
		private WebElement emailcreateTxtBox;
		
		@FindBy(name= "SubmitCreate")
		 protected WebElement SubmitCreateBtn;
	
	
	public void ClickOnSubmit(String email_create) {
		
		emailcreateTxtBox.clear();
		emailcreateTxtBox.sendKeys(email_create);
		
		SubmitCreateBtn.click();
		
	}

}
