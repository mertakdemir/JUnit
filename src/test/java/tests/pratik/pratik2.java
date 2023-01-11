package tests.pratik;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class pratik2 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        this.driver.manage().window().maximize();
        this.driver.get("https://www.instagram.com/");
    }

    @Test
    public void test1(){
        driver.findElement(By.xpath("//button[@class='_a9-- _a9_0']")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("mert_akdemir_");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("29969899Abb");
        driver.findElement(By.xpath("//button[@class='_acan _acao _acat _aj1-']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[@type='button']")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/div/div/div/div/div[2]/div[7]/div/div/a/div")).click();



    }
    @After
    public void tearDown(){

        //driver.quit();
    }

}
