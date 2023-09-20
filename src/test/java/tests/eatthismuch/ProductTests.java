package tests.eatthismuch;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductTests {


    WebDriver driver;

    @Test
    public void test1() throws InterruptedException {
        driver = Driver.getDriver();
        driver.get("https://www.eatthismuch.com/");

        driver.findElement(By.linkText("Browse Foods")).click();

        List<Product> products = new ArrayList<>();

        Select select = new Select(driver.findElement(By.cssSelector("select.sort_by_nutrient")));
        select.selectByValue("sugar");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("sugar"));

        // located the titles, to find out how many products we have
        List<WebElement> titles = driver.findElements(By.cssSelector("div.result_name"));
        List<WebElement> calories = driver.findElements(By.xpath("//div[@class = 'row result_stats']/div[1]"));
        List<WebElement> carbs = driver.findElements(By.xpath("//div[@class = 'row result_stats']/div[2]"));
        List<WebElement> fats = driver.findElements(By.xpath("//div[@class = 'row result_stats']/div[3]"));
        List<WebElement> proteins = driver.findElements(By.xpath("//div[@class = 'row result_stats']/div[4]"));
        List<WebElement> sugars = driver.findElements(By.xpath("//div[@class = 'row result_stats']/div[5]"));



        for (int i = 0; i < titles.size(); i++){
            String title = titles.get(i).getText();
            int calorie = Integer.parseInt(calories.get(i).getText().trim());
            double carb = Double.parseDouble(carbs.get(i).getText().trim().split(" ")[0]);
            double fat = Double.parseDouble(fats.get(i).getText().trim().split(" ")[0]);
            double protein = Double.parseDouble(proteins.get(i).getText().trim().split(" ")[0]);
            double sugar = Double.parseDouble(sugars.get(i).getText().trim().split(" ")[0]);

            products.add(new Product( title,  calorie,  carb,  fat,  protein,  sugar));
        }


        System.out.println(products.get(5).getSugar());



    }

}
