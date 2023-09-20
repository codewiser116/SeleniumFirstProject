package tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class JUnitIntro {


    @Test
    public void test1(){

        WebDriver driver = Driver.getDriver();
        driver.get("https://www.google.com/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test
    public void test2(){

        if("weather".equals("nice")){
            System.out.println("hello");
        }else{
            Assert.fail();
        }

        Assert.assertEquals("weather", "nice");




        System.out.println("I'm test 2");
        Assert.assertTrue("hello".length() < 20);
    }

    @Test
    public void test3(){
        System.out.println("I'm test 3");
        Assert.assertNotEquals(123, 1234);
        Assert.assertNotEquals(true, false);
        Assert.assertEquals(1, 10);
        Assert.assertNull(null);
    }

    @Before
    public void beforeTest(){
        System.out.println("This method runs before every test");
    }

    @After
    public void afterTest(){
        System.out.println("This method runs after every test");
    }

    @BeforeClass
    public static void anyname(){
        System.out.println("THIS IS BEFORE CLASS METHOD");
    }

    @AfterClass
    public static void whatevername(){
        System.out.println("THIS IS AFTER CLASS METHOD");
    }

}
