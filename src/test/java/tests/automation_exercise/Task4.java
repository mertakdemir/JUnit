package tests.automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Task4 extends TestBase {

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page
     */

    @Test
    public void test(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Login to your account']")).isDisplayed());

        //6. Enter correct email address and password
        driver.findElement(By.name("email")).sendKeys("aaaaa@abbbbc.com");
        driver.findElement(By.name("password")).sendKeys("12345");

        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//a[.=' Logged in as Mert']")).isDisplayed());

        //9. Click 'Logout' button
        driver.findElement(By.xpath("//a[.=' Logout']")).click();

        //10. Verify that user is navigated to login page
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Login to your account']")).isDisplayed());



    }
}
