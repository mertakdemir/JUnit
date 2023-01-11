package tests.homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Jqueryui01 extends TestBase {


    /*
    When user goes to https://jqueryui.com/accordion/
And user clicks on Section2 accordion
Verify the text contains “Sed non urna.”
     */
    @Test
    public void test(){

        driver.get("https://jqueryui.com/accordion/");

        driver.switchTo().frame(0);

        driver.findElement(By.xpath("//*[@id='ui-id-3']")).click();

        waitFor(4);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='ui-id-4']//p")).getText().contains("Sed non urna."));

    }
}
