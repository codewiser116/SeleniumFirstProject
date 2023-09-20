package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.Driver;

public class AlertDemo99 {

    WebDriver driver;

    @Before
    public void initializeDriver(){
        driver = Driver.getDriver();
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.cssSelector("input[name=cusid]")).sendKeys("52454");
        driver.findElement(By.cssSelector("input[name=submit]")).click();
    }


    @Test
    public void testAlert1() {

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.accept(); //accepts first alert

        System.out.println(alert.getText());
        alert.accept(); //accepts second alert
    }

    @Test
    public void testAlert2(){
        /*
        1. go to website
        2. provide id
        3. click on delete
        4. press on Cancel -> alert.dismiss
         */
        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.dismiss(); //---> cancel


    }




}
