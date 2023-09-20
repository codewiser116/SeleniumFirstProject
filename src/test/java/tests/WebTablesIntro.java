package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;

public class WebTablesIntro {

    WebDriver driver;

    @Test
    public void printTableInfo(){
        driver = Driver.getDriver();

        /*
        1. go to https://the-internet.herokuapp.com/tables
        2. print all value of 1st row of 1 table
         */

        driver.get("https://the-internet.herokuapp.com/tables");

        /*
        if you get /tr, one element is returned and all columns of the row
        return as one String
        below code prints all columns as one String - one row
         */

        System.out.println(driver.findElement
                (By.xpath("//table[@id='table1']/tbody/tr[1]")).getText());

        /*
        if you get tr/td, it returns cells of the given tr as a list of webelements
        and we can use loops to go thru the list and print elements
         */
        List<WebElement> rowOne = driver.findElements
                (By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        for (WebElement column : rowOne){
            System.out.println(column.getText());
        }


        /*
        print just first names
         */
        List<WebElement> firstNames = driver.findElements
                (By.xpath("//table[@id='table1']/tbody/tr/td[2]"));

        for (WebElement name : firstNames) {
            System.out.println(name.getText());
        }

        /*
        print header row of the table
         */
        List<WebElement> headerRow = driver.findElements
                (By.xpath("//table[@id='table1']/thead//th"));

        for (WebElement name : headerRow) {
            System.out.println(name.getText());
        }





    }


    @Test
    public void printTableInfo2(){
        driver = Driver.getDriver();
        driver.get("https://demo.guru99.com/test/table.html");


        /*
        1. List<WebElement> rows = find locator for 5 rows
        2. create int index = 1
        3. create loop, inside loop:
            - create List<WebElement> columns = xpath must be dynamic, use index here
            - print (row #)
            - create loop, inside loop
                print (column #)
         */



    }


}
