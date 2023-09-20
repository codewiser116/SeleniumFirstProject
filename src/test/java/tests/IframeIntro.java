package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class IframeIntro {

    WebDriver driver;

    @Test
    public void closeGoogleSignIn(){
        /*   1. go to ebay.com   */
        driver = Driver.getDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/draggable.php#load_box");

        /*   3. switch to  iframe    */
        driver.switchTo().frame(0);

        WebElement draggable = driver.findElement(By.id("draggable"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable)
                .moveByOffset(200, 150)
                .moveByOffset(30, 50)
                .build()
                .perform();
    }


    @Test
    public void testDraggable() throws InterruptedException {
        driver = Driver.getDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/draggable.php#load_box");

        driver.findElement(By.xpath("//a[contains(text(), 'Constrain movement')]")).click();

        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='draggable/default2.html']"));
        driver.switchTo().frame(iframe);

        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.id("draggable2")))
                .moveByOffset(200, 0)
                .release()
                .build()
                .perform();

        Thread.sleep(3000);
        actions.clickAndHold(driver.findElement(By.id("draggable2")))
                .moveByOffset(-200, 0)
                .release()
                .build()
                .perform();

        Thread.sleep(3000);
        actions.clickAndHold(driver.findElement(By.id("draggable")))
                .moveByOffset(0, -100)
                .release()
                .build()
                .perform();

        Thread.sleep(3000);
        actions.clickAndHold(driver.findElement(By.id("draggable")))
                .moveByOffset(0, 100)
                .release()
                .build()
                .perform();
    }






}
