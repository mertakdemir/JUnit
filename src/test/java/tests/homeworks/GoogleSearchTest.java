package tests.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleSearchTest {

    WebDriver driver;

    //When user goes to https://www.google.com/
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com/");
    }

    @Test
    public void test1(){

        //Accept cookies
        driver.findElement(By.xpath("//*[.='Tümünü kabul et']")).click();

        //Search for “porcelain teapot”
        WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
        search.sendKeys("porcelain teapot");
        search.sendKeys(Keys.ENTER);

        //And print how many related results displayed on Google
        String results = driver.findElement(By.id("result-stats")).getText();
        System.out.println(results);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
