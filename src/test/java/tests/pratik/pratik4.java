package tests.pratik;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class pratik4 {

    // ...Practice 3...
    // Create chrome driver by using @Before annotation and WebDriverManager
    // Go to url : http://www.uitestpractice.com/
    // Click on 'Form'
    // Fill the First Name: John
    // Fill the Last Name: Doe
    // Check the Marital Status: Married
    // Check the Hobby: Reading
    // Select the Country : Canada
    // Fill the Date Of Birth: 1st February 2000
    // Fill the Phone Number: 12345
    // Fill the User Name: john_doe
    // Fill the Eamil: john@doe.com
    // Fill the About Yourself: My name is John Doe. I am a famous man. Because my name is used as a mock data everywhere.
    // Fill the Password: John.123
    // Click on Submit Button
    // Close the browser by using @After annotation

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.uitestpractice.com/");
    }

    @Test
    public void test1(){
        driver.findElement(By.xpath("//*[.='Form']")).click();
        driver.findElement(By.id("firstname")).sendKeys("John");
        driver.findElement(By.id("lastname")).sendKeys("Doe");
        driver.findElement(By.xpath("(//input[@name='optradio'])[1]")).click();
        driver.findElement(By.xpath("//input[@value='read']")).click();
        WebElement dropdown = driver.findElement(By.id("sel1"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Canada");
        driver.findElement(By.id("datepicker")).sendKeys("02/01/2000");
        driver.findElement(By.id("phonenumber")).sendKeys("12345");
        driver.findElement(By.id("username")).sendKeys("john_doe");
        driver.findElement(By.id("email")).sendKeys("john@doe.com");
        driver.findElement(By.id("comment")).sendKeys("My name is John Doe. I am a famous man. Because my name is used as a mock data everywhere.");
        driver.findElement(By.id("pwd")).sendKeys("John.123");
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.sendKeys(Keys.ENTER);




    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
