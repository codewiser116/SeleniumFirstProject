package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.UtilWait;

import java.time.Duration;
import java.util.Set;

public class SauceDemoWindows {

    WebDriver driver;

    @Before
    public void before(){
        driver = Driver.getDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Test
    public void testSocialMedia(){

        String sauceLabsMainWindow = driver.getWindowHandle();

        WebElement twitter = driver.findElement(By.cssSelector("li[class='social_twitter']"));
        WebElement facebook = driver.findElement(By.cssSelector("li[class='social_facebook']"));
        WebElement linkedin = driver.findElement(By.cssSelector("li[class='social_linkedin']"));

        verifyTheSocialMediaURL(twitter, "https://twitter.com/saucelabs", sauceLabsMainWindow);
        verifyTheSocialMediaURL(facebook, "https://www.facebook.com/saucelabs", sauceLabsMainWindow);
        verifyTheSocialMediaURL(linkedin, "https://www.linkedin.com/company/sauce-labs/", sauceLabsMainWindow);

    }


    public void verifyTheSocialMediaURL(WebElement socialMediaButton, String expectedUrl, String mainPageID){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(socialMediaButton));

        socialMediaButton.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String window : driver.getWindowHandles()){
            if (!window.equals(mainPageID)){
                driver.switchTo().window(window);
            }
        }

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        driver.close();
        driver.switchTo().window(mainPageID);
    }



}
