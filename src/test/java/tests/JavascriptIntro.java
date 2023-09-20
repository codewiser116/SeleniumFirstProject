package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class JavascriptIntro {

    WebDriver driver;

    @Test
    public void test1() throws InterruptedException {

        /*
        1. go to https://www.eatthismuch.com/
        2. click on Browse Foods
        3. move to next page
         */

        driver = Driver.getDriver();
        driver.get("https://www.eatthismuch.com/");

        driver.findElement(By.linkText("Browse Foods")).click();

        String forwardButtonLocator = "(//a[@class='change_page'])[2]";



        // 1. create instance of JSExecutor class
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 2. click on button
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(forwardButtonLocator)));
        Thread.sleep(2000);
//        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(forwardButtonLocator)));
//        Thread.sleep(2000);
//        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(forwardButtonLocator)));

        js.executeScript("arguments[0].value='baked potato';", driver.findElement(By.name("q")));

        js.executeScript("arguments[0].checked=true;",
                driver.findElement(By.xpath("(//input[@name='nutrition_multiplier'])[2]")));


        js.executeScript("window.scrollBy(0, 2000);");
        Thread.sleep(2000);

        js.executeScript("arguments[0].click();",
                driver.findElement(By.xpath("//a[contains(text(), 'Facebook')]")));






//        js.executeScript(“document.getElementByID(‘element id ’).click();”);
//
//        js.executeScript("arguments[0].click();", element);

    }











    public static void anyStaticMethod(int ... args) {

        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }

    }


}
