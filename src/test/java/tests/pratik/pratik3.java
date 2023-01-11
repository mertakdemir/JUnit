package tests.pratik;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class pratik3 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        this.driver.manage().window().maximize();
        this.driver.get("https://www.walmart.com/");
    }
    @Test
    public void test3(){

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Nutella");
        driver.findElement(By.xpath("//button[@style='right:0.25rem;cursor:pointer']")).click();
        driver.findElement(By.xpath("//div[@data-item-id='45589900']")).click();
        driver.findElement(By.xpath("//button[@style='position:relative']")).click();
        driver.findElement(By.id("cart-badge")).click();
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div/div/div/div/div[2]/div[1]/div[2]/div/div/div[2]/section/div/div/div/ul/li/div[3]/div[2]/div/section/div/div/button[2]")).click();
        driver.findElement(By.id("Continue to checkout button")).click();
        driver.findElement(By.xpath("//input[@id='email-split-screen']")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//button[@data-automation-id='signin-continue-submit-btn']")).click();
        Assert.assertTrue(driver.findElement(By.id("global-error")).isDisplayed());

    }
}
