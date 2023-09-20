package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class Driver {

    static WebDriver driver;


    public static WebDriver getDriver(){

        System.setProperty("webdriver.chrome.driver",
                "/Users/codewiseacademy/Desktop/SeleniumFirstProject/src/test/drivers/chromedriver");

        if (driver != null){
            return driver;
        }

        String browser = Config.getProperty("browser");

        switch (browser){
            case "chrome" ->
                    driver = new ChromeDriver();
            case "firefox" ->
                    driver = new FirefoxDriver();
            default ->
                    driver = new ChromeDriver();
        }

        driver.manage().window().maximize();

        /*
        PageLoadWait waits until all elements in the page are loaded
         */
        int pageWait = Integer.parseInt((Config.getProperty("pageLoadTimeOut")));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageWait));

        /*
        Implicit wait, waits until element is visible.
         */
        int waitTime = Integer.parseInt(Config.getProperty("implicitWait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));

        return driver;
    }


    public static WebDriver getDriverWithDisabledNotification(){

        System.setProperty("webdriver.chrome.driver",
                "/Users/codewiseacademy/Desktop/SeleniumFirstProject/src/test/drivers/chromedriver");

        if (driver != null){
            return driver;
        }

        String browser = Config.getProperty("browser");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");

        driver = new ChromeDriver(options);

        FirefoxOptions fireOptions = new FirefoxOptions();



        switch (browser){
            case "chrome" ->
                    driver = new ChromeDriver(options);
            case "firefox" ->
                    driver = new FirefoxDriver(fireOptions);
            default ->
                    driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();

        /*
        PageLoadWait waits until all elements in the page are loaded
         */
        int pageWait = Integer.parseInt((Config.getProperty("pageLoadTimeOut")));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageWait));

        /*
        Implicit wait, waits until element is visible.
         */
        int waitTime = Integer.parseInt(Config.getProperty("implicitWait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));

        return driver;
    }


    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}
