package NBHPages;

import CommonComponents.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingHeads extends CommonMethods {
  WebDriver driver;
    public BillingHeads(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //Locators for Page Modal
    @FindBy(xpath = "//div[contains(text(),'Financial Management')]")
    private WebElement GoTOFinancialManagement;
    @FindBy(xpath = "//div[@class='inline-block nb__DAYS7 nb__CW0Vt' and text()='Billing']")
    private WebElement GoToBilling;

    @FindBy(xpath = "//div[@title='Billing Heads']")
    private WebElement GoToBillingHeads;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-xs btn-round']")
    private WebElement AddBillHeadButton;

    By menu = By.id("sidebad-tab");

    public void CreateBillhead(){
        waitUntilExpectedconditionvisibility(menu);
        GoTOFinancialManagement.click();
        GoToBilling.click();
        GoToBillingHeads.click();
        AddBillHeadButton.click();

    }
}
