package tests.day17_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Q05 extends TestBase {

    @Test
    public void test(){

        //Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        //Fill the username, password and textArea comment:
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("JohnDoe");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
        WebElement comments = driver.findElement(By.xpath("//textarea[@name='comments']"));
        comments.clear();
        comments.sendKeys("Hello I am a comment");

        //Choose a file and upload it
        String userHome = System.getProperty("user.home");
        String path = userHome+"\\OneDrive\\Desktop\\logo.jpeg";
        driver.findElement(By.xpath("//input[@name='filename']")).sendKeys(path);

        //Select all checkboxes, radio item and dropdowns
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@value='cb1']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@value='cb2']"));
        WebElement checkbox3 = driver.findElement(By.xpath("//input[@value='cb3']"));

        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }
        if (!checkbox3.isSelected()){
            checkbox3.click();
        }

        driver.findElement(By.xpath("//input[@value='rd1']")).click(); //Radio Button 1

        WebElement dropdown = driver.findElement(By.xpath("//select[@multiple='multiple']"));
        Select select=new Select(dropdown);
        select.deselectAll();

        driver.findElement(By.xpath("//option[@value='ms1']")).click();//Option 1
        //select.selectByIndex(0);
        //dropdown.sendKeys(Keys.SHIFT);
        //select.selectByIndex(1);//Option 2


        //Click on submit
        driver.findElement(By.xpath("//input[@value='submit']")).click();

        //Verify that uploaded file name is on the Form Details.
        String message = driver.findElement(By.xpath("//div[@class='explanation']//p")).getText();
        Assert.assertTrue(message.contains("You submitted a form."));
    }
}
