package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

        return driver;
    }


    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}
