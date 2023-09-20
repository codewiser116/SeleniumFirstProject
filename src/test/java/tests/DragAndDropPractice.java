package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class DragAndDropPractice {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. go to https://the-internet.herokuapp.com/drag_and_drop
        2. dragAndDrop A into B's place
            1. locate the sourceElement (A)
            2. locate the targetElement (B)
            3. actions.dragAndDrop(sourceElement, targetElement).build().perform();
         */

        WebDriver driver = Driver.getDriver();
//        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
//
//        WebElement a = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
//        WebElement b = driver.findElement(By.cssSelector("div#trash"));

//        actions.dragAndDrop(a, b).perform();
//        actions.dragAndDropBy(a, 150, 150).build().perform();


//        Thread.sleep(10);


        Actions actions = new Actions(driver);

        driver.get("https://demoqa.com/droppable");

        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(sourceElement, targetElement).build().perform();


        /*
        1. click on "Accept"
        2. drag and drop "Acceptable"
        3. drag and drop "Not acceptable"
         */

        driver.findElement(By.id("droppableExample-tab-accept")).click();

        WebElement acceptableElement = driver.findElement(By.id("acceptable"));
        WebElement notAcceptableElement = driver.findElement(By.id("notAcceptable"));

        WebElement sourceBox = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']"));

        actions
                .clickAndHold(acceptableElement)
                .moveToElement(sourceBox)
                .release()
                .build()
                .perform();


        actions
                .clickAndHold(notAcceptableElement)
                .moveToElement(sourceBox)
                .release()
                .build()
                .perform();










    }
}
