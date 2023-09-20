package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class BrowserStackTest {
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.browserstack.com/");

//        driver.findElement(By.id("signupModalButton")).click();

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("signupModalButton"));
        actions.moveToElement(element).click().perform();


        Action action =
        actions.moveToElement(element).clickAndHold().contextClick().doubleClick().build();

        action.perform();

        action.perform();













    }
}
