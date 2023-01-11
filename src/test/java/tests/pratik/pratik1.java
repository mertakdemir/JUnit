package tests.pratik;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class pratik1 {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

    }

    @Test
    public void test(){

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("akdemirler_05@hotmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("23030086080Ab@");
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        driver.findElement(By.xpath("//button[@value='1']")).click();





    }

    @After
    public void tearDown(){
        //driver.quit();
    }
}
