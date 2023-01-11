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

public class Day05_RadioButton {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        this.driver.manage().window().maximize();
        this.driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");
    }

    @Test
    public void radioTest(){
        //Select red
        WebElement redOption = driver.findElement(By.id("red"));
        redOption.click();
        Assert.assertTrue(redOption.isSelected());//Verifying the red radio button is selected
        //Select football
        WebElement footballOption = driver.findElement(By.id("football"));
        footballOption.click();
        Assert.assertTrue(footballOption.isSelected());//Verifying the red football option is selected
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
