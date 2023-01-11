package tests.demoqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.security.Key;

public class Task2 extends TestBase {

    @Test
    public void test1(){

        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[.='Forms']")).click();

        driver.findElement(By.xpath("//span[.='Practice Form']")).click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");
        String mail = "john@doe.com";
        driver.findElement(By.id("userEmail")).sendKeys(mail);
        Assert.assertTrue(mail.contains("@")&&mail.contains("."));
        waitFor(5);
        driver.findElement(By.xpath("//label[.='Male']")).click();
        waitFor(5);
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='gender-radio-1']")).isSelected());
        waitFor(3);
        String phone = "0123456789";
        WebElement phoneNumber = driver.findElement(By.id("userNumber"));
        phoneNumber.sendKeys(phone);
        Assert.assertTrue(phone.replaceAll("[0-9]", "").isEmpty());
        Assert.assertTrue(phone.length()==10);


        WebElement date = driver.findElement(By.id("dateOfBirthInput"));
        date.click();

        WebElement month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        Select select = new Select(month);
        select.selectByVisibleText("December");

        WebElement year = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        Select select1 = new Select(year);
        select1.selectByVisibleText("1998");

        waitFor(4);
        driver.findElement(By.xpath("//div[@aria-label='Choose Wednesday, December 30th, 1998']")).click();

        driver.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys("Registration");
        waitFor(3);

        driver.findElement(By.xpath("(//label[@class='custom-control-label'])[5]")).click();
        waitFor(3);
        Assert.assertTrue( driver.findElement(By.id("hobbies-checkbox-2")).isSelected());

        String userHome = System.getProperty("user.home");
        String path = userHome+"\\OneDrive\\Desktop\\logo.jpeg";
        driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys(path);
        waitFor(3);

        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Stockholm");

        //driver.findElement(By.id("react-select-6-input")).sendKeys("Haryana"+ Keys.ENTER);
        //driver.findElement(By.id("react-select-7-input")).sendKeys("Karnal"+ Keys.ENTER);






    }
}
