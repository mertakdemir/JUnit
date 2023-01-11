package tests.automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task11 extends TestBase {

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Cart' button
5. Scroll down to footer
6. Verify text 'SUBSCRIPTION'
7. Enter email address in input and click arrow button
8. Verify success message 'You have been successfully subscribed!' is visible
     */
    @Test
    public void test(){

        //    1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Features Items']")).isDisplayed());

        //4. Click 'Cart' button
        driver.findElement(By.xpath("//a[.=' Cart']")).click();

        //5. Scroll down to footer
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        //6. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Subscription']")).isDisplayed());

        //7. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys("john@doem.com");
        driver.findElement(By.id("subscribe")).click();

        //8. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='You have been successfully subscribed!']")).isDisplayed());

    }
}
