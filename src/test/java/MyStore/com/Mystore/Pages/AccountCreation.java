package MyStore.com.Mystore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import MyStore.com.Mystore.BasePages;

public class AccountCreation extends BasePages {

    public AccountCreation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email_create")
    private WebElement emailcreateTxtBox;

    @FindBy(name = "SubmitCreate")
    private WebElement submitCreateBtn;

    @FindBy(id = "id_gender1") // Use "id_gender2" for female
    private WebElement genderRadio;

    @FindBy(name = "customer_firstname")
    private WebElement customerfirstnameTxtBox;

    @FindBy(name = "customer_lastname")
    private WebElement customer_lastnameTxtBox;
    
    @FindBy(name = "email")
    private WebElement customeremailTxtBox;

    @FindBy(name = "passwd")
    private WebElement customerpasswdTxtBox;

    @FindBy(id = "days")
    private WebElement dropedowndays;

    @FindBy(id = "months")
    private WebElement dropedownmonths;

    @FindBy(id = "years")
    private WebElement dropedownyear;


    @FindBy(id = "uniform-newsletter")
    private WebElement checkBoxSelect;

    @FindBy(id = "submitAccount")
    private WebElement submitAccountBtn;

    // Dropdown Methods
    public void selectDay(String day) {
        new Select(dropedowndays).selectByValue(day);
    }

    public void selectMonth(String month) {
        new Select(dropedownmonths).selectByValue(month);
    }

    public void selectYear(String year) {
        new Select(dropedownyear).selectByValue(year);
    }

    // Complete account creation flow
    public void AccCreation(String email_create, String firstname,String lastname, String email, String password,
                            String day, String month, String year) {

        emailcreateTxtBox.sendKeys(email_create);
        submitCreateBtn.click();

        // Wait for form to load (use explicit wait in real tests)
        try {
            Thread.sleep(2000); // 👈 Replace with WebDriverWait in real framework
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        genderRadio.click();
        
        customerfirstnameTxtBox.sendKeys(firstname);
        customer_lastnameTxtBox.sendKeys(lastname);
        customeremailTxtBox.clear();
        customeremailTxtBox.sendKeys(email);
        customerpasswdTxtBox.sendKeys(password);

       selectDay(day);
             selectMonth(month);
        selectYear(year);

        checkBoxSelect.click(); // optional newsletter

        submitAccountBtn.click();
    }

	
}
