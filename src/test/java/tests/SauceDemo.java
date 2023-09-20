package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SauceDemo {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "/Users/codewiseacademy/Desktop/SeleniumFirstProject/src/test/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize(); // maximizes the screen
//        driver.manage().window().minimize(); // minimize the screen
//        driver.manage().window().fullscreen(); //fullscreen

        System.out.println(driver.findElement(By.tagName("form")).getText());




        List<WebElement> elements = driver.findElements(By.tagName("div"));

        System.out.println(elements.size());










        /*
        A maximized window is not the same as a fullscreen window.
        When maximized, the title bar etc. of the window is still displayed.
        In fullscreen mode, the title bar is not displayed.
         */

        /*
        TC #01
            1. Go to saucedemo.com
            2. Provide valid username
            3. Provide valid password
            4. Click on Login button
            5. Verify user is logged in
        */

        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("URL did not match", expectedUrl, actualUrl);


        /*
            1. Go to saucedemo.com
            2. Provide valid username
            3. Provide valid password
            4. Click on Login button
            5. Verify user is logged in
            6. Add "Sauce Labs Backpack" to the cart
            7. Go to cart
            8. Click on Checkout button
            9. Enter First Name
            10. Enter Last Name
            11. Enter Zip Code
            12. Click on "Continue"
            13. Click on "Finish"
            14. Verify checkout was successful
            "Thank you for your order!"

         */


        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

        WebElement shoppingCart = driver.findElement(By.className("shopping_cart_container"));
        shoppingCart.click();

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();


        /*
        Locate, firstname, lastname, zipcode
        fill out with data
        click on continue
         */
        driver.findElement(By.id("first-name")).sendKeys("Dana");
        driver.findElement(By.id("last-name")).sendKeys("Ubaidillaeav");
        driver.findElement(By.id("postal-code")).sendKeys("60136");

        /*
           Click on "Continue"
           Click on "Finish"
         */

        driver.findElement(By.name("continue")).click();

        Thread.sleep(9000); //wait 9 seconds

        driver.findElement(By.id("finish")).click();

        String actualResult = driver.findElement(By.className("complete-header")).getText();
        String expectResult = "Thank you for your order!";

        WebElement backhomeButton = driver.findElement(By.id("back-to-products"));
        String text = backhomeButton.getText();

        if(actualResult.equals(expectResult)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }




        driver.close();
        driver.quit();







    }
}
