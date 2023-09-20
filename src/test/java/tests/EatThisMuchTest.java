package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class EatThisMuchTest {

    /*
    1. go to https://www.eatthismuch.com/
    2. I want to eat 2500 calories
    3. in 5 meals
    4. choose "Mediterranean" diet
    5. click on "Generate"
    6. click on "No, thanks" in pop up
    7. verify the meal plan has:
        breakfast
        lunch
        snack
        dinner
        snack
    8. click on chart icon
    9. verify chart pop up window appeared
    10. verify total number of calories in pop up chart matches the total number of calories in main menu
    11. verify the total number of calories is less than target
     */

    @Test
    public void testMealPlan(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.eatthismuch.com/");

        WebElement caloriesInputField = driver.findElement(By.id("cal_input"));
        String targetCalories = "2500";
        caloriesInputField.sendKeys(targetCalories);

        Select select = new Select(driver.findElement(By.id("num_meals_selector")));
        select.selectByValue("5");
        
        WebElement mediterraneanDiet = driver.findElement(By.xpath("//li[@data-value='mediterranean']"));
        mediterraneanDiet.click();

        WebElement generateButton = driver.findElement(By.xpath("//button[@data-loading-text='Generate']"));
        generateButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement noThanksLocator = driver.findElement(By.xpath("//div[@class='cancel_popover btn btn-outline-secondary' and text()='No thanks']"));
        wait.until(ExpectedConditions.elementToBeClickable(noThanksLocator)).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(noThanksLocator)
                .click()
                .release()
                .build()
                .perform();

        String [] expected5Meals = {"Breakfast", "Lunch", "Snack", "Dinner", "Snack"};
        String [] actual5Meals = new String[expected5Meals.length];

        List <WebElement> meals = driver.findElements(By.cssSelector("div.print_meal_title"));

        for (int i = 0; i < expected5Meals.length; i++){
            actual5Meals[i] = meals.get(i).getText();
        }

        Assert.assertEquals("Meals did not match the expected ones", expected5Meals, actual5Meals);

        WebElement chartIcon = driver.findElement(By.cssSelector("div.plan_spark_chart"));
        chartIcon.click();

        WebElement popUpPieChart = driver.findElement(By.cssSelector("div.cumulative_graph"));

        Assert.assertTrue(popUpPieChart.isDisplayed());

        WebElement totalCaloriesWebEl = driver.findElement(By.xpath("//div[text()='Calories']//following-sibling::div"));
        int totalCaloriesInPopUp = Integer.parseInt(totalCaloriesWebEl.getText().trim());

        WebElement planCaloriesWebEl = driver.findElement(By.cssSelector("div.plan_calories"));
        int planCalories = Integer.parseInt(planCaloriesWebEl.getText().trim().split(" ")[0]);

        Assert.assertEquals(totalCaloriesInPopUp, planCalories);
        Assert.assertTrue(totalCaloriesInPopUp < Integer.parseInt(targetCalories) + 100);
        Assert.assertTrue(totalCaloriesInPopUp > Integer.parseInt(targetCalories) - 100);


    }


}
