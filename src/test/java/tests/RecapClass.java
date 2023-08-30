package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;

public class RecapClass {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "/Users/codewiseacademy/Desktop/SeleniumFirstProject/src/test/drivers/chromedriver");

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://youtube.com");
//        chromeDriver.manage().window().maximize();
//        WebElement inputBar = chromeDriver.findElement(By.className("gLFyf"));
//        inputBar.sendKeys("Codewise Academy");
//        inputBar.sendKeys(Keys.ENTER);

        chromeDriver.findElement(By.xpath("((//div[@id='contents'])[1]//a)[1]")).click();

//        Thread.sleep(100);
        WebElement searchButton = chromeDriver.findElement(By.name("btnK"));
        searchButton.click();


        chromeDriver.findElement(By.name("btnK")).click();



//        chromeDriver.findElement(By.name("btnK")).click();

        Thread.sleep(3000);
        chromeDriver.quit();
    }
}
