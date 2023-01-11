package tests.day16;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day16_TimeOutException extends TestBase {

    @Test
    public void timeOutTest(){

        driver.get("https://techproeducation.com/");
        waitForVisibility(By.id("wrong-id"), 15);
    }
}
