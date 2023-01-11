package tests.automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.security.Key;

public class Task13 extends TestBase {

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'View Product' for any product on home page
5. Verify product detail is opened
6. Increase quantity to 4
7. Click 'Add to cart' button
8. Click 'View Cart' button
9. Verify that product is displayed in cart page with exact quantity
     */
    @Test
    public void test() throws InterruptedException {

        //    1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Features Items']")).isDisplayed());

        Thread.sleep(5000);

        //4. Click 'View Product' for any product on home page
        driver.findElement(By.xpath("(//i[@class='fa fa-plus-square'])[1]")).click();


        //5. Verify product detail is opened
        //Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Stylish Dress']")).isDisplayed());

        //6. Increase quantity to 4
        //String quantity = driver.findElement(By.id("quantity")).getText();
        //int num1 = Integer.valueOf(quantity);
        //int num2 = 4-num1;

        //driver.findElement(By.id("quantity")).sendKeys(num1+num2+"");


    }
}
