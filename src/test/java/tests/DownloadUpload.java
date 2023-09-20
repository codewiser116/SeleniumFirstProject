package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class DownloadUpload {

    WebDriver driver;

    @Test
    public void testDownload(){
        driver = Driver.getDriver();

        driver.get("https://the-internet.herokuapp.com/download");

        driver.findElement(By.linkText("scrrenshot.png")).click();

        driver.findElement(By.linkText("Apr.pdf")).click();

    }


    @Test
    public void testUpload(){
        driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/upload");

        // 1. locate the upload button
        WebElement fileUploadButton = driver.findElement(By.id("file-upload"));

        // 2. find the absolute path to file and send it as keys
        fileUploadButton.sendKeys("/Users/codewiseacademy/Desktop/students.json");

        // 3. click on submit button
        driver.findElement(By.id("file-submit")).click();


    }

    @Test
    public void testUploadGuru99(){
        driver = Driver.getDriver();
        driver.get("https://demo.guru99.com/test/upload/");

        driver.findElement(By.id("uploadfile_0")).sendKeys("/Users/codewiseacademy/Downloads/scrrenshot.png");

        driver.findElement(By.id("terms")).click();

        driver.findElement(By.id("submitbutton")).click();
    }

}
