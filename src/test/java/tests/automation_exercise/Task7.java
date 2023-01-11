package tests.automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.charset.StandardCharsets;

public class Task7 extends TestBase {

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Test Cases' button
5. Verify user is navigated to test cases page successfully
     */

    @Test
    public void test(){

        //    1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Features Items']")).isDisplayed());

        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//a[.=' Test Cases']")).click();

        //5. Verify user is navigated to test cases page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//b[.='Test Cases']")).isDisplayed());
    }
}
