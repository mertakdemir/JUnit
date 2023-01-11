package tests.automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.awt.*;

public class Task1 extends TestBase {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    @Test
    public void test(){

        // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='/products']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='New User Signup!']")).isDisplayed());

        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Mert");
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("akdemirmertsafa@gmaiil.co");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[.='Enter Account Information']")).isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("id_gender1")).click();
        Assert.assertTrue(driver.findElement(By.id("id_gender1")).isSelected());

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

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();
        Assert.assertTrue(driver.findElement(By.id("newsletter")).isSelected());

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();
        Assert.assertTrue(driver.findElement(By.id("optin")).isSelected());

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
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

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[.='Account Created!']")).isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.linkText("Continue")).click();

        //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//a[.=' Logged in as Mert']")).isDisplayed());

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//b[.='Account Deleted!']")).isDisplayed());
        driver.findElement(By.linkText("Continue")).click();




    }
}
