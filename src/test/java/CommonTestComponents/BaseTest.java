package CommonTestComponents;

import NBHPages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

   public static WebDriver driver;
    public static WebDriver initialiesDriver(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }
    @BeforeMethod
    public void loginpage(){
        driver=initialiesDriver();
        LoginPage lg=new LoginPage(driver);
        lg.openUrl();
        lg.nBHLogin("mamaearth@nobroker.com","nobroker1");
    }

    @AfterMethod
    public static WebDriver closeDriver(){
        driver.close();
        return driver;
    }

}
