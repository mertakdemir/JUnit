package tests.day05;

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

public class Day05_dynamic_xpath {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        this.driver.manage().window().maximize();
        this.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void dynamicXpath(){
        //1. XPATH = //*[.='TEXT OF THE ELEMENT']
        WebElement userNameText = driver.findElement(By.xpath("//*[.='Username : Admin']"));
        Assert.assertTrue(userNameText.isDisplayed());
        WebElement passwordText = driver.findElement(By.xpath("//*[.='Password : admin123']"));
        Assert.assertTrue(passwordText.isDisplayed());

        //2. XPATH = //*[(text()='TEXT OF THE ELEMENT')] //*[(text()='Username : Admin)]
        WebElement userNameText2 = driver.findElement(By.xpath("//*[(text()='Username : Admin')]"));
        Assert.assertTrue(userNameText2.isDisplayed());

        //3. XPATH = //*[contains(text(),'PARTIAL OR FULL TEXT OF ELEMENT')]
        WebElement passwordText2 = driver.findElement(By.xpath("//*[contains(text(),'Passw') ]"));
        Assert.assertTrue(passwordText2.isDisplayed());

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
