package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class ClickPractice {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. go to https://demo.guru99.com/test/simple_context_menu.html
        2. click on "right click button"
        3. thread.sleep(3)
        4. right click on "right click button"
        5. click on "double click button"
        6. thread.sleep(3)
        7. double click on "double click button"
         */

        WebDriver driver = Driver.getDriver();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement rcButton = driver.findElement(By.xpath("//span[contains(text(), 'right click me')]"));
        WebElement dcButton = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));

        Actions actions = new Actions(driver);

        actions.contextClick(rcButton).perform();

        actions.doubleClick(dcButton).perform();



    }
}
