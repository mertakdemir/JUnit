package tests.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleVerification {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com/");
    }

    @Test
    public void titleTest(){
        //Accept cookies
        driver.findElement(By.xpath("//*[.='Tümünü kabul et']")).click();

        //Verify if Google title is : "Google"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void imageTest(){
        //Accept cookies
        driver.findElement(By.xpath("//*[.='Tümünü kabul et']")).click();

        //Verify ig Google image displays or not
        driver.findElement(By.id("hplogo")).isDisplayed();
    }

    @Test
    public void gmailTest(){
        //Accept cookies
        driver.findElement(By.xpath("//*[.='Tümünü kabul et']")).click();

        //Verify if gmail link is displays or not
        driver.findElement(By.linkText("Gmail")).isDisplayed();

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
