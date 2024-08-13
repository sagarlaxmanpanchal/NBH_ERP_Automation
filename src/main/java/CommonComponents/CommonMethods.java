package CommonComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods {
    WebDriver driver;
    public CommonMethods(WebDriver driver) {
        this.driver=driver;
    }

    public void sleep() throws InterruptedException {
        Thread.sleep(3000);
    }

    public void waitUntilExpectedconditionvisibility(By findBy){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public void waitUntilExpectedconditioninvisibility(By findBy){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }
    public void waitUntilExpectedClickable(By findBy){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }

    public void dropdownByValue(By findBy, String value){
        WebElement dropdownselection= driver.findElement(findBy);
        Select se=new Select(dropdownselection);
        se.selectByValue(value);
    }

    public void dropdownByInddex(By findBy, int index){
        WebElement dropdownselection=driver.findElement(findBy);
        Select se=new Select(dropdownselection);
        se.selectByIndex(index);
    }

    public void inputData(By findBy,String values){
        WebElement inputValues=driver.findElement(findBy);
        inputValues.sendKeys(values);
    }




}
