package tests;

import com.sun.jdi.request.DuplicateRequestException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.UtilWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class MagentoTest {

    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();

        /*
        1. go to https://magento.softwaretestingboard.com/
        2. click on "Sale"
        3. click on "Women's deals"
        4. choose size, color of the first product and add to cart
        5. click on add to cart for a second product
        6. choose size, color, quantity and add to cart
        7. go to cart
        8. click on "Proceed to Checkout"
        9. checkout
         */

        driver.get("https://magento.softwaretestingboard.com/");

        UtilWait.waitUntilElementIsVisible(driver, 30, By.id("ui-id-8")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-8")));


        driver.findElement(By.xpath("//span[@class='more button']")).click();

        addProductToCart(driver);

    }

    public static void addProductToCart(WebDriver driver){

        List<WebElement> addToCartButtons = UtilWait.waitUntilAllElementsAreVisible
                (driver, 20, By.xpath("//button[@title='Add to Cart']"));

        int randomButton = new Random().nextInt(1, addToCartButtons.size());

        List<WebElement> productSizes = UtilWait.waitUntilAllElementsAreVisible
                (driver, 20, By.xpath("(//div[@class='swatch-attribute size']/div)[" + randomButton + "]/div"));

        List<WebElement> productColors = UtilWait.waitUntilAllElementsAreVisible
                (driver, 20, By.xpath("(//div[@class='swatch-attribute color']/div)[" + randomButton + "]/div"));


        int randomSize = new Random().nextInt(1, productSizes.size());
        int randomColor = new Random().nextInt(1, productColors.size());


        productSizes.get(randomSize).click();
        productColors.get(randomColor).click();


        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButtons.get(randomButton));
        actions.click().build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtons.get(randomButton))).click();



    }












}
