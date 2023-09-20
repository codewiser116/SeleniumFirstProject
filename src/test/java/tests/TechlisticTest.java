package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class TechlisticTest{
    public static void main(String[] args) {
        /*
        1. go to https://www.techlistic.com/p/selenium-practice-form.html
        2. send "Your name" to first_name field
        3. ctrl + c the entered name
        4. paste it in last_name field
         */

        WebDriver driver = Driver.getDriver();
        driver.get("https://cashwise.us/main");
        driver.findElement(By.xpath("//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root css-1o6c4rv']")).click();

        WebElement email = driver.findElement(By.cssSelector("input[id=':r3:']"));
        WebElement password = driver.findElement(By.cssSelector("input[id=':r4:']"));


        email.click();
        email.sendKeys("Bena");

        Actions actions = new Actions(driver);

        actions.moveToElement(email)
                .click()
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .moveToElement(email)
                .keyDown(Keys.COMMAND)
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .moveToElement(password)
                .click()
                .keyDown(Keys.COMMAND)
                .sendKeys("v")
                .keyUp(Keys.COMMAND)
                .build()
                .perform();
    }


    public static void ctrlCctrlV(WebDriver driver, WebElement toCopy, WebElement toPaste){
        Actions actions = new Actions(driver);

        actions.moveToElement(toCopy)
                .click()
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .moveToElement(toCopy)
                .keyDown(Keys.COMMAND)
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .moveToElement(toPaste)
                .click()
                .keyDown(Keys.COMMAND)
                .sendKeys("v")
                .keyUp(Keys.COMMAND)
                .build()
                .perform();
    }
}
