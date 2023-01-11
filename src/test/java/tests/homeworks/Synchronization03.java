package tests.homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class Synchronization03 extends TestBase {

    @Test
    public void test() throws IOException {

        //Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Click enable Button
        driver.findElement(By.xpath("//button[.='Enable']")).click();

        //And verify the message is equal to “It's enabled!”
        WebElement message = driver.findElement(By.id("message"));
        waitForVisibility(message, 7);
        Assert.assertEquals(message.getText(), "It's enabled!");

        //And verify the textbox is enabled (I can type in the box)
        WebElement text = driver.findElement(By.xpath("//input[@type='text']"));
        text.sendKeys("I can type in the box");
        Assert.assertTrue(text.isEnabled());
        takeScreenshotOfTheElement(text);

        //And click on Disable button
        driver.findElement(By.xpath("//button[.='Disable']")).click();

        //And verify the message is equal to “It's disabled!”
        WebElement message2 = driver.findElement(By.id("message"));
        waitForVisibility(message2, 7);
        Assert.assertEquals(message2.getText(), "It's disabled!");

        //And verify the textbox is disabled (I cannot type in the box)
        WebElement text2 = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(text2.isEnabled());
        takeScreenshotOfTheElement(text2);

        //NOTE: .isEnabled(); is used to check if an element is enabled or not
    }
}
