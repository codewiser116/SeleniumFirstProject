package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;

public class EatThisMuchExcHandling {

    WebDriver driver;

    @Test
    public void test1(){
        driver = Driver.getDriver();
        driver.get("https://www.eatthismuch.com/");


        try{
            driver.findElement(By.linkText("Browse\n" +
                    "                                    Foods")).click();
        }catch (NoSuchElementException e){
            driver.findElement(By.linkText("Browse Foods")).click();
        }

        List<WebElement> titles = driver.findElements(By.cssSelector("div.result_name"));
        System.out.println(titles.size());

        List<WebElement> calories = driver.findElements(By.xpath("//div[@class='col-2 offset-1 nutrient_cell']"));
        System.out.println(calories.size());


    }

}
