package tests.ders;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class ders3 extends TestBase {
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
    public void test1(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/girl2.jpg']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='New User Signup!']")).isDisplayed());

        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("John");
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("john@doee.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[.='Signup']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//*[.='Enter Account Information'])[2]")).isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("12345");

        WebElement days = driver.findElement(By.id("days"));
        Select select = new Select(days);
        select.selectByIndex(3);

        WebElement months = driver.findElement(By.id("months"));
        Select select1 = new Select(months);
        select1.selectByVisibleText("February");

        WebElement years = driver.findElement(By.id("years"));
        Select select2 = new Select(years);
        select2.selectByVisibleText("2000");

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("John");
        driver.findElement(By.id("last_name")).sendKeys("Doe");
        driver.findElement(By.id("company")).sendKeys("TechPro");
        driver.findElement(By.id("address1")).sendKeys("United Kingdom");
        driver.findElement(By.id("address2")).sendKeys("Cordoba");

        WebElement dropdown = driver.findElement(By.id("country"));
        Select select3 = new Select(dropdown);
        select3.selectByVisibleText("Canada");

        driver.findElement(By.id("state")).sendKeys("Montreal");
        driver.findElement(By.id("city")).sendKeys("Maputo");
        driver.findElement(By.id("zipcode")).sendKeys("14573");
        driver.findElement(By.id("mobile_number")).sendKeys("123123123");

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[.='Create Account']")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//*[.='Account Created!'])[2]")).isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[.='Continue']")).click();

        //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//a[.=' Logged in as John']")).isDisplayed());

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[.=' Delete Account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("(//*[.='Account Deleted!'])[2]")).isDisplayed());














    }

}
