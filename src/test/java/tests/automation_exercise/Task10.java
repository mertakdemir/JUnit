package tests.automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class Task10 extends TestBase {

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down to footer
5. Verify text 'SUBSCRIPTION'
6. Enter email address in input and click arrow button
7. Verify success message 'You have been successfully subscribed!' is visible
     */

     @Test
    public void test() throws InterruptedException {

         //    1. Launch browser
         //2. Navigate to url 'http://automationexercise.com'
         driver.get("http://automationexercise.com");

         //3. Verify that home page is visible successfully
         Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Features Items']")).isDisplayed());

         //4. Scroll down to footer
         Actions actions = new Actions(driver);
         actions.sendKeys(Keys.PAGE_DOWN).
                 sendKeys(Keys.PAGE_DOWN).
                 sendKeys(Keys.PAGE_DOWN).
                 sendKeys(Keys.PAGE_DOWN).
                 sendKeys(Keys.PAGE_DOWN).
                 sendKeys(Keys.PAGE_DOWN).
                 sendKeys(Keys.PAGE_DOWN).
                 sendKeys(Keys.PAGE_DOWN).
                 sendKeys(Keys.PAGE_DOWN).
                 sendKeys(Keys.PAGE_DOWN).
                 sendKeys(Keys.PAGE_DOWN).
                 sendKeys(Keys.PAGE_DOWN).
                 build().
                 perform();
         Thread.sleep(3000);

         //5. Verify text 'SUBSCRIPTION'
         Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Subscription']")).isDisplayed());

         //6. Enter email address in input and click arrow button
         driver.findElement(By.id("susbscribe_email")).sendKeys("john@doem.com");
         driver.findElement(By.id("subscribe")).click();

         //7. Verify success message 'You have been successfully subscribed!' is visible
         Assert.assertTrue(driver.findElement(By.xpath("//*[.='You have been successfully subscribed!']")).isDisplayed());

     }
}
