package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class LambdaTest {

    /*
    TC #1
    1. go to https://www.lambdatest.com/selenium-playground/bootstrap-modal-demo
    2. click on "Launch Modal"
    3. click on "Save Changes"

    TC #2
    1. go to https://www.lambdatest.com/selenium-playground/bootstrap-modal-demo
    2. click on "Launch Modal"
    3. click on "Close"

    TC #3
    1. go to https://www.lambdatest.com/selenium-playground/bootstrap-modal-demo
    2. click on "Launch Modal"
    3. click on "x" button
     */


    WebDriver driver;

    @Before
    public void before(){
        /*
            1. go to https://www.lambdatest.com/selenium-playground/bootstrap-modal-demo
            2. click on "Launch Modal"
         */
        driver = Driver.getDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-modal-demo");
        driver.findElement(By.xpath("//div[text()='Single Modal']/following-sibling::button")).click();

    }

    @Test
    public void saveChanges()  {
        // click on "Save Changes"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='myModal']//button[text()='Save Changes']"))));
        driver.findElement(By.xpath("//div[@id='myModal']//button[text()='Save Changes']")).click();
    }

    @Test
    public void cancelChanges(){
        // click on "Close"
        driver.findElement(By.xpath("//div[@id='myModal']//button[text()='Close']")).click();

    }

    @Test
    public void closePopup(){
        //click on "x" button
        driver.findElement(By.xpath("//div[@id='myModal']//button[text()='×']")).click();
    }

    @After
    public void cleanup(){
        Driver.closeDriver();
    }








}
