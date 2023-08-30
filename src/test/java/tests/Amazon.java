package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.List;

public class Amazon {
    public static void main(String[] args) {
        /*
        Navigate to https://www.amazon.com/
        From dropdown menu, select “Electronics” option
        Enter “Smart watch” in search input
        Verify every result contains “Smart watch”
            - create List<WebElement> list = driver.findElements
            - loop thru the list, check if every result contains "smart watch"
         */

        WebDriver driver = Driver.getDriver();
        driver.get("https://www.amazon.com/");

        WebElement categoryDropDwn = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(categoryDropDwn);
        select.selectByVisibleText("Electronics");

        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        searchInput.click();
        searchInput.sendKeys("smartwatch", Keys.ENTER);

        List<WebElement> results =
                driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

        for (WebElement element : results){
            if (!element.getText().toLowerCase().contains("smart watch") &&
                    !element.getText().toLowerCase().contains("smartwatch")){
                System.out.println("Fail, this result does not contain smart watch: \n" + element.getText() );
            }
        }




    }
}
