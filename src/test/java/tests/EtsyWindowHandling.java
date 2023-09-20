package tests;

import org.junit.Test;
import org.openqa.selenium.*;
import utilities.Driver;

public class EtsyWindowHandling {
    /*
        // Opens a new tab and switches to new tab
        driver.switchTo().newWindow(WindowType.TAB);

        // Opens a new window and switches to new window
        driver.switchTo().newWindow(WindowType.WINDOW);

        1. go to etsy
        2. search for "canvas"
        3. copy url
        4. open new tab
        5. go to the saved url thru new tab

     */

    @Test
    public void testNewTab(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.etsy.com/?ref=lgo");
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("canvas", Keys.ENTER);

        String url = driver.getCurrentUrl();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);
    }


    /*
    1. go to etsy
    2. go to amazon (new tab)
    3. go to google (new tab)
     */
    @Test
    public void test2(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.etsy.com/?ref=lgo");

        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        System.out.println(width);
        System.out.println(height);

        driver.manage().window().setSize(new Dimension(800, 400));



    }



}















