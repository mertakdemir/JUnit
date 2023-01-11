package tests.day15;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class Day15_JSExecutor extends TestBase {

    @Test
    public void scrollIntoViewTest() throws IOException {

        driver.get("https://techproeducation.com/");
        waitFor(3);

        //1. Create js executor object
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //2. Execute the command
        waitFor(3);
        //Scrolling to "We Offer" text
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[.='we offer']")));
        takeScreenshotOfPage();

        waitFor(3);
        //Scrolling to "ENROLL FREE" text
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//span[.=' Enroll Free ']")));
        takeScreenshotOfPage();

        waitFor(3);
        //Scrolling to "WHY US" element
        scrollIntoViewJS(driver.findElement(By.xpath("//h3[.='WHY US?']")));
        takeScreenshotOfPage();

        waitFor(3);
        //Scrolling to "ENROLL FREE" text
        scrollIntoViewJS(driver.findElement(By.xpath("//span[.=' Enroll Free ']")));

        //Scroll all the way down
        scrollAllDownByJS();
        waitFor(3);
        takeScreenshotOfPage();
        //Scroll all the way up
        scrollAllUpByJS();
        waitFor(3);
        takeScreenshotOfPage();

    }

    /*
click on an element
@param WebElement
Normally we use element.click() method in selenium
When there is an issue with click()-hidden, different UI, ...
Then we can use javascript click that works better
*/
    @Test
    public void clickByJSTest(){

        driver.get("https://techproeducation.com/");

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        clickByJS(lmsLogin);
    }

    @Test
    public void typeInTheInputTest(){

        driver.get("https://techproeducation.com/");

        setValueByJS(driver.findElement(By.xpath("//input[@type='search']")), "QA");
    }

    @Test
    public void getValueOfInputTest(){

        driver.get("https://www.priceline.com/");

        getValueByJS("hotelDates");

    }

    @Test
    public void colorByJSTest(){

        driver.get("https://www.priceline.com/");

        changeBackgroundColorByJS(driver.findElement(By.xpath("//button[@data-testid='HOTELS_SUBMIT_BUTTON']")),"red");
        addBorderWithJS(driver.findElement(By.xpath("//button[@data-testid='HOTELS_SUBMIT_BUTTON']")), "5px solid green");
    }

}
