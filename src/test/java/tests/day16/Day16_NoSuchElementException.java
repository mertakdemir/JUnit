package tests.day16;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day16_NoSuchElementException extends TestBase {

    @Test
    public void noSuchElementTest(){

        driver.get("https://techproeducation.com/");

        //Wrong locator
        driver.findElement(By.id("wrong-id"));
    }
}
