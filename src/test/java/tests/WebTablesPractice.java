package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class WebTablesPractice {

    WebDriver driver;

    @Test
    public void practiceTables(){
        driver = Driver.getDriver();
        driver.get("https://omayo.blogspot.com/");

        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));

        List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath("./td"));

            for (WebElement cell : cells){
                System.out.println(cell.getText());
            }
        }
    }




    @Test
    public void altynai(){
        driver = Driver.getDriver();
        driver.get("https://omayo.blogspot.com/");

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (int i = 0; i<rows.size(); i++) {
            List<WebElement> ages = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[" + (i + 1) + "]/td[2]"));
            List<WebElement> names = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[" + (i + 1) + "]/td[1]"));
            List<WebElement> places = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[" + (i + 1) + "]/td[3]"));

            for (int j = 0; j < ages.size(); j++) {
                int agesInt = Integer.parseInt(ages.get(j).getText());
                if (agesInt <= 30){
                    System.out.println("“Name: ”" + names.get(j).getText());
                    System.out.println("“Age: ”" + ages.get(j).getText());
                    System.out.println("“Place: ”" + places.get(j).getText());
                    System.out.println("===================");
                }
            }
        }


    }


    @Test
    public void test3() {
        driver = Driver.getDriver();
        driver.get("https://omayo.blogspot.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        wait.until(ExpectedConditions.visibilityOf(table));

        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr"));

        for (int rowNumber = 0; rowNumber < rows.size(); rowNumber++) {
            WebElement ageCell = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[" + (rowNumber + 1) + "]/td[2]"));
            int age = Integer.parseInt(ageCell.getText());

            if (age <= 25) {
                System.out.println("Name: " + driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[" + (rowNumber + 1) + "]/td[1]")).getText());
                System.out.println("Age: " + age);
                System.out.println("Place: " + driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[" + (rowNumber + 1) + "]/td[3]")).getText());
                System.out.println("-----------------");
            }
        }

        driver.quit();
    }




}
