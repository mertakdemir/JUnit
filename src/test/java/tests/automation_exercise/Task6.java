package tests.automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task6 extends TestBase {

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
     */
    @Test
    public void test() throws InterruptedException {

        // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='/products']")).isDisplayed());

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[.=' Contact us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Get In Touch']")).isDisplayed());

        //6. Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Mert");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abcd@efg.com");
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Register");
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("I registered successfully");

        //7. Upload file
        WebElement upload = driver.findElement(By.name("upload_file"));
        String userHome = System.getProperty("user.home");
        String path = userHome+"\\OneDrive\\Desktop\\logo.jpeg";
        upload.sendKeys(path);
        Thread.sleep(3000);

        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //9. Click OK button
        driver.switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//*[.='Success! Your details have been submitted successfully.'])[1]")).isDisplayed());

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("(//*[.=' Home'])[4]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/girl2.jpg']")).isDisplayed());

    }
}
