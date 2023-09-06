package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;

public class EtsyTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/codewiseacademy/Desktop/SeleniumFirstProject/src/test/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String searchWord = "wall decor";

        WebElement searchInput = driver.findElement(By.name("search_query"));
        searchInput.click();
        searchInput.sendKeys(searchWord);

        WebElement searchButton = driver.findElement(By.xpath("//button[@value='Search']"));
        searchButton.click();

        String url = driver.getCurrentUrl();

        if (url.contains("wall")){
            System.out.println("Search button worked!");
        }else{
            System.out.println("Failed to search wall!");
        }

        Thread.sleep(5000);
        driver.navigate().refresh();

        String value = driver.findElement(By.name("search_query")).getAttribute("value");

        if (value.equals("wall decor")){
            System.out.println("yes, wall decor!");
        }else{
            System.out.println("failed");
        }

        WebElement xButton = driver.findElement(By.xpath("//button[@data-search-close-btn]"));

        xButton.click();
        searchButton.click();


        /*
        1. go to https://www.etsy.com/
        2. locate search input and enter "wall decor"
        3. click on search button
        4. verify "wall decor" is still in search input
        and verify url contains "wall"
        5. click on "X" button on search input
        6. verify search input is empty
         */
    }
}
