package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class CheckboxIntro {
    public static void main(String[] args) throws InterruptedException {
        /*
        Task:
            1. go to https://demoqa.com/checkbox
            2. click on Home checkbox
            3. verify "You have selected" text
            4. uncheck "Home" checkbox
            5. verify "You have selected" text is gone
         */

        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/checkbox");

        System.out.println(driver.findElement(By.cssSelector("label[for=tree-node-home]")).isSelected());

        WebElement homeCheckbox = driver.findElement(By.cssSelector("label[for=tree-node-home]"));
        homeCheckbox.click();

        boolean isCheckboxSelected = homeCheckbox.isSelected();
        boolean isCheckboxEnabled = homeCheckbox.isEnabled();
        boolean isDisplayed = homeCheckbox.isDisplayed();

        System.out.println("Checkbox is selected? " + isCheckboxSelected);
        System.out.println("Checkbox is enabled? " + isCheckboxEnabled);
        System.out.println("Checkbox is displayed? " + isDisplayed);

        WebElement selectedText = driver.findElement(By.xpath("//span[contains(text(), 'You have selected :')]"));
        System.out.println("Is text displayed: " + selectedText.isDisplayed());

        homeCheckbox.click();

//        System.out.println("Is text displayed: " + selectedText.isDisplayed());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        /*
        by locator
        We wait for element to appear before clicking
         */
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        driver.findElement(By.id("")).click();


        /*
        by element
        First we wait for element to appear, then store it in WebElement object
         */
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable
                (driver.findElement(By.id("username"))));

        element.click();








    }
}
