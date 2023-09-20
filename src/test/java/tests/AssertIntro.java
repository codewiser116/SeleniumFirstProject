package tests;

import org.junit.Assert;
import org.junit.Test;

public class AssertIntro {
    /*
            1. check if "Lion" contains "o"
            2. check if 34 < 9
            3. check if true is equal to true & false
            4. check if "Chicago" is equal to "Chicago"
     */

    @Test
    public void checkLion(){
        Assert.assertTrue("Lion".contains("o"));
        System.out.println("This is lion method");
    }

    @Test
    public void compareTwoNums(){
        System.out.println("compare two nums method");
        Assert.assertTrue(34 < 9);
    }

    @Test
    public void compareBooleans(){
        Assert.assertEquals(true, true & false);
    }
}
