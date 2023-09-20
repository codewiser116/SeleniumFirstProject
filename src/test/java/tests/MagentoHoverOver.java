package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;
import utilities.UtilWait;

import java.time.Duration;

public class MagentoHoverOver {
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();

        driver.get("https://magento.softwaretestingboard.com/");

        /*
        1. go to https://magento.softwaretestingboard.com/
        2. hover over "Women"
        3. click on "Tops"

        Pseudocode:
        1. Actions actions = new Actions(driver);
        2. WebElement parentElement = find it;
        3. actions.moveToElement(parentElement);
        4. WebElement childElement = find it;
        5. actions.moveToElement(childElement);
        6. actions.click().build().perform();
         */

        WebElement parentElement = driver.findElement(By.id("ui-id-4"));

        Actions actions = new Actions(driver);
        actions.moveToElement(parentElement); //hover over "Women"

        WebElement childElement = driver.findElement(By.id("ui-id-9"));

        actions.moveToElement(childElement);
        actions.click().build().perform();

        driver.get("https://magento.softwaretestingboard.com/");

        UtilWait.waitUntilElementIsVisible(driver, 20, By.id("ui-id-4"));

        actions.moveToElement(driver.findElement(By.id("ui-id-4"))); //hover over "Women"

        actions.moveToElement(driver.findElement(By.id("ui-id-9")));
        actions.click().build().perform();






    }
}
