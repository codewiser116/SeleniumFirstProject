package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Gadgetarium {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get("https://gadgetarium.us/");

        /*
        Implicit Wait
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));


        /*
        Explicit Wait
         */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Delivery"))));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Delivery"))));
//        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.linkText("Delivery")), ""));





        for (int i = 1; i <= 10; i++){
            try {
                driver.findElement(By.linkText("Delivery")).click();
                break;
            }catch (ElementClickInterceptedException e){
                Thread.sleep(1000);
            }catch (ElementNotInteractableException ei){
                Thread.sleep(1000);
            }
        }



//        try {
//            driver.findElement(By.linkText("Delivery")).click();
//
//        }catch (Exception e){
//            Thread.sleep(2000);
//            try{
//                driver.findElement(By.linkText("Delivery")).click();
//
//            }catch (Exception e2){
//                System.out.println("Couldnt click");
//            }
//        }








        String text = driver.findElement(By.xpath("//p[text()='Pay by card online']")).getText();
        System.out.println(text);


    }


}
