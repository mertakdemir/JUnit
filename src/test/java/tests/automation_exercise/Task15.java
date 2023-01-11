package tests.automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Task15 extends TestBase {

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill all details in Signup and create account
6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
7. Verify ' Logged in as username' at top
8. Add products to cart
9. Click 'Cart' button
10. Verify that cart page is displayed
11. Click Proceed To Checkout
12. Verify Address Details and Review Your Order
13. Enter description in comment text area and click 'Place Order'
14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
15. Click 'Pay and Confirm Order' button
16. Verify success message 'Your order has been placed successfully!'
17. Click 'Delete Account' button
18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */
    @Test
    public void test() throws InterruptedException {

        //    1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Features Items']")).isDisplayed());

        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Mert");
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("aaaaa@abbbbc.com");
        driver.findElement(By.xpath("//button[.='Signup']")).click();
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("12345");

        WebElement dropdown = driver.findElement(By.id("days"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("30");

        WebElement dropdown2 = driver.findElement(By.id("months"));
        Select select2 = new Select(dropdown2);
        select2.selectByVisibleText("December");

        WebElement dropdown3 = driver.findElement(By.id("years"));
        Select select3 = new Select(dropdown3);
        select3.selectByVisibleText("1998");

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        driver.findElement(By.id("first_name")).sendKeys("Mert");
        driver.findElement(By.id("last_name")).sendKeys("Akdemir");
        driver.findElement(By.id("company")).sendKeys("TechPro");
        driver.findElement(By.id("address1")).sendKeys("United States");
        driver.findElement(By.id("address2")).sendKeys("United States");

        WebElement dropdown4 = driver.findElement(By.id("country"));
        Select select4 = new Select(dropdown4);
        select4.selectByVisibleText("United States");

        driver.findElement(By.id("state")).sendKeys("New York");
        driver.findElement(By.id("city")).sendKeys("New York");
        driver.findElement(By.id("zipcode")).sendKeys("12345");
        driver.findElement(By.id("mobile_number")).sendKeys("1234567890");

        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();


        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("(//*[.='Account Created!'])[2]")).isDisplayed());
        driver.findElement(By.xpath("//a[.='Continue']")).click();

        //7. Verify ' Logged in as username' at top
        Assert.assertTrue(driver.findElement(By.xpath("//a[.=' Logged in as Mert']")).isDisplayed());

        //8. Add products to cart
        WebElement hover = driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hover);
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();


    }
}
