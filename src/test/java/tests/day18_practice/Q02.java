package tests.day18_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;

public class Q02 extends TestBase {

    /*
    Given
        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    When
        Click on Ajax Loader
    And
        Click on "Click Me!" button
    Then
        Assert that button is clicked
    And
        Take screenshot after each step
     */

    @Test
    public void test() throws IOException {

        //        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        takeScreenshotOfPage();

        //        Click on Ajax Loader
        driver.findElement(By.id("button3")).click();
        takeScreenshotOfPage();

        //        Click on "Click Me!" button
        waitForClickAbility(By.id("button1"), 10).click();
        //driver.findElement(By.xpath("//p[.='CLICK ME!']"));
        takeScreenshotOfPage();

        //        Assert that button is clicked
        waitFor(3);
        Assert.assertTrue(driver.findElement(By.xpath("//h4")).isDisplayed());
        takeScreenshotOfPage();

        //        Take screenshot after each step
    }
}
