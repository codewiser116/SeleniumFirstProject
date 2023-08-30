package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class SelectIntro {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. Go to https://blazedemo.com/
        2. Choose Portland as departure city
        3. Choose London as destination city
        4. Click on "Find Flights"
         */

        WebDriver driver = Driver.getDriver();

//        driver.get("https://blazedemo.com/");
//
//        WebElement departureCityDropDwn = driver.findElement(By.name("fromPort"));
//        Select select = new Select(departureCityDropDwn);
//        select.selectByVisibleText("Portland");
//
//        WebElement destinationCityDropDwn = driver.findElement(By.name("toPort"));
//        Select select1 = new Select(destinationCityDropDwn);
//        select1.selectByVisibleText("London");
//
//        WebElement findBtn = driver.findElement(By.cssSelector("input.btn"));
//        findBtn.click();



        /*
        1. go to https://demoqa.com/select-menu
        2. from old style select menu choose option black by value
        3. from multiselect dropdown list, select Green and Red
        4. deselect red
        BREAK UNTIL 10:30
         */
        driver.get("https://demoqa.com/select-menu");

//        WebElement oldStyleDropDwn = driver.findElement(By.id("oldSelectMenu"));
//        Select select = new Select(oldStyleDropDwn);
//        select.selectByValue("5");
//        Thread.sleep(3000);

//        select.deselectByValue("5");

        Thread.sleep(3000);
        WebElement multiSelectDropDwn = driver.findElement(By.xpath("//div[contains(text(), 'Select...')]"));
        multiSelectDropDwn.click();

        Thread.sleep(5000);

        driver.findElement(By.xpath
                ("//div[contains(text(), 'Select...')]/../../../div/div/div[contains(text(), 'Green')]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(), 'Green')]/following-sibling::div")).click();


//<div class=" css-yt9ioa-option" id="react-select-4-option-2" tabindex="-1">Black</div>

        /*
        BREAK UNTIL 12:10 PM
         */








/*
    1. go to https://the-internet.herokuapp.com/dropdown
    2. select "option 2" by index
 */
//        driver.get("https://the-internet.herokuapp.com/dropdown");
//        Select select = new Select(driver.findElement(By.id("dropdown")));
//        select.selectByIndex(2);







    }
}
