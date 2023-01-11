package tests.day17_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Q02 extends TestBase {

    /*
    Given
        Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
    When
        Click on "click me" button
    Then
        Verify that "Event Triggered"
     */

    @Test
    public void test(){

        //        Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");

        //        Click on "click me" button
        waitFor(4);
        driver.findElement(By.id("growbutton")).click();

        //        Verify that "Event Triggered"
        String growButtonStatus = driver.findElement(By.id("growbuttonstatus")).getText();
        Assert.assertEquals("Event Triggered",growButtonStatus);
    }

}
