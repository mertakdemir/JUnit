package tests.homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Synchronization02 extends TestBase {

    @Test
    public void test(){

        //Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Click on remove button
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();

        //And verify the message is equal to “It's gone!”
        WebElement message = driver.findElement(By.id("message"));
        waitForVisibility(message, 7);
        Assert.assertEquals(message.getText(), "It's gone!");

        //Then click on Add button
        driver.findElement(By.xpath("//button[.='Add']")).click();

        //And verify the message is equal to “It's back!”
        WebElement message2 = driver.findElement(By.id("message"));
        waitForVisibility(message2, 7);
        Assert.assertEquals(message2.getText(), "It's back!");
    }
}
