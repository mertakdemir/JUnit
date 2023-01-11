package tests.day08;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class Day08_Actions3 extends TestBase {

    @Test
    public void pageUpDownTest() throws InterruptedException {


        //Go to techproeducation
        driver.get("https://www.techproeducation.com");

        Actions actions = new Actions(driver);
        // sendKeys(Keys.PAGE_DOWN) is used to scroll the page down
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        //actions.sendKeys(Keys.PAGE_DOWN).perform();

        //CHAIN METHOD. Scrolling 3 times
        //build() is used when we chain multiple function to make sure the connection is strong. This is recommended.
        //perform() is used when there is single or multiple commend to execute the action
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();

        // ARROW DOWN = scroll down a little. This scrolls less than page down
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        //PAGE_UP = Scroll Up
        actions.sendKeys(Keys.PAGE_UP).perform();

        // ARROW_UP = scroll up a little. This scrolls less than page up
        actions.sendKeys(Keys.ARROW_UP).perform();
    }
}
