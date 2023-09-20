package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;



public class LetsKodeItTest {
    WebDriver driver;

    /*
        1. Go to https://www.letskodeit.com/
        2. Click on Practice on menu
        3. Switch to the second window
        4. Click on the 'open tab' button
        5. Switch to the third tab
        6. Print the Title and URL of the third tab
     */

    @Test
    public void testWindows(){
        driver = Driver.getDriver();
        driver.get("https://www.letskodeit.com/");

        WebElement practiceButton = driver.findElement(By.linkText("PRACTICE"));
        windowHandle(practiceButton);

        WebElement openTabButton = driver.findElement(By.id("opentab"));
        windowHandle(openTabButton);

    }

    public void windowHandle(WebElement element){
        element.click();
        String handle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for(String h : handles){
            if(!h.equals(handle)){
                driver.switchTo().window(h);
            }
        }
    }

}
