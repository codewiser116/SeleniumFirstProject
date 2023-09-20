package tests;

import org.checkerframework.checker.units.qual.C;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserPopUp {

    WebDriver driver;

    @Before
    public void prepareDriver(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/codewiseacademy/Desktop/SeleniumFirstProject/src/test/drivers/chromedriver");

    }

    @Test
    public void testWithoutDisable(){
        driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/");
    }

    @Test
    public void testWithDisable(){
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        options.addArguments("enable-automation");
        driver = new ChromeDriver(options);
        driver.get("https://ultimateqa.com/");
    }


}
