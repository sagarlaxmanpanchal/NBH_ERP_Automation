package NBHPages;

import CommonComponents.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonMethods {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".nb__GGkUH")
    public WebElement societyLoginBtn;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement userEmail;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement userPassword;

    @FindBy(xpath = "//div[@class='nb__1Zwxx' and contains(text(),'Login')]")
    private WebElement loginBtn;

    @FindBy(id = "alertMessageBox")
    private WebElement errorMessage;

    public void openUrl(){
        driver.get("https://www.nobrokerhood.com/");
    }

    public void nBHLogin(String userName, String Password){
        societyLoginBtn.click();
        userEmail.sendKeys(userName);
        userPassword.sendKeys(Password);
        loginBtn.click();
    }
}
