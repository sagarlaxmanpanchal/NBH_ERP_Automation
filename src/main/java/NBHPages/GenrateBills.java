package NBHPages;

import CommonComponents.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GenrateBills extends CommonMethods {
    WebDriver driver;

    public GenrateBills(WebDriver driver) {
        super(driver);

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //Locators for Page Modal
    @FindBy(xpath = "//div[contains(text(),'Financial Management')]")
    private WebElement GoTOFinancialManagement;
    @FindBy(xpath = "//div[@class='inline-block nb__DAYS7 nb__CW0Vt' and text()='Billing']")
    private WebElement GoToBilling;
    @FindBy(xpath = "//div[@class='inline-block nb__DAYS7 nb__2Oysw nb__CW0Vt' and text()='Generate Bills']")
    private WebElement GoToGenrateBills;

    @FindBy (id = "s2id_autogen1")
    private  WebElement flatDetails;

    @FindBy(id = "submit_btn")
    private WebElement Submitbtn;

    @FindBy(xpath = "//button[@class='confirm' ][@tabindex='1']")
    private WebElement confirmbtn;
    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement messagee;


// Locators for common methods

    By menu = By.id("sidebad-tab");

    By billUnits = By.id("bill_for");
    By tower=By.id("block_no");
    By selectBillingHead = By.id("change_bill_type");
    By pageloader = By.id("defaultPageLoader");

    By selectBillperiod = By.id("change_bill_cycle1");
    By selectIntrestTreatment = By.id("roi");

    By confirmMessage = By.xpath("//div[@class='sa-icon sa-info']");

    By confirmbutton = By.xpath("//button[@class='confirm' ][@tabindex='1']");
    By message = By.xpath("//div[@class='alert alert-success']");
    By submittButton = By.id("submit_btn");

    //Generating Bill for All flats
    public String billGenrationforAllflats() throws InterruptedException {
        waitUntilExpectedconditionvisibility(menu);
        GoTOFinancialManagement.click();
        GoToBilling.click();
        GoToGenrateBills.click();
        getUnits(0);
        getBillHead("UTILITY_EXPENSE");
        getBillPeriod("4");
        getTreatmentOfIntrest(1);
        waitUntilExpectedClickable(submittButton);
        Submitbtn.click();
        sleep();

        waitUntilExpectedClickable(confirmbutton);
        confirmbtn.click();
        waitUntilExpectedconditionvisibility(message);
        String mess = messagee.getText();
        return mess;

    }
    //Generating Bill for Selected Tower
    public String billGenrationforTower() throws InterruptedException {
        waitUntilExpectedconditionvisibility(menu);
        GoTOFinancialManagement.click();
        GoToBilling.click();
        GoToGenrateBills.click();
        getUnits(1);
        getTowername("B Block");
        getBillHead("UTILITY_EXPENSE");
        getBillPeriod("4");
        getTreatmentOfIntrest(1);
        waitUntilExpectedClickable(submittButton);
        Submitbtn.click();
        sleep();

        waitUntilExpectedClickable(confirmbutton);
        confirmbtn.click();
        waitUntilExpectedconditionvisibility(message);
        String mess = messagee.getText();
        return mess;

    }

    //Generating Bill for Selected Flats
    public String billGenrationforSelectedFlats() throws InterruptedException {
        waitUntilExpectedconditionvisibility(menu);
        GoTOFinancialManagement.click();
        GoToBilling.click();
        GoToGenrateBills.click();
        getUnits(2);
        flatDetails.sendKeys("Ews/2");
        flatDetails.sendKeys(Keys.RETURN);
        flatDetails.sendKeys("EWS/1");
        flatDetails.sendKeys(Keys.RETURN);


        getBillHead("UTILITY_EXPENSE");
        getBillPeriod("4");
        getTreatmentOfIntrest(1);
        waitUntilExpectedClickable(submittButton);
        Submitbtn.click();
        sleep();

        waitUntilExpectedClickable(confirmbutton);
        confirmbtn.click();
        waitUntilExpectedconditionvisibility(message);
        String mess = messagee.getText();
        return mess;

    }

    public void getUnits(int index) {
        dropdownByInddex(billUnits, index);

    }
    public void getTowername(String value){
        dropdownByValue(tower,value);
    }



    public void getBillHead(String billHead) {
        dropdownByValue(selectBillingHead, billHead);
    }

    public void getBillPeriod(String billPeriod) {
        waitUntilExpectedconditioninvisibility(pageloader);
        waitUntilExpectedconditionvisibility(selectBillperiod);
        dropdownByValue(selectBillperiod, billPeriod);
    }

    public void getTreatmentOfIntrest(int intrestTreatmentIndex) {
        dropdownByInddex(selectIntrestTreatment, intrestTreatmentIndex);
    }

}
