package tests.day06_practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Practice04 {
    WebDriver driver;

    // Create chrome driver by using @Before annotation and WebDriverManager
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait int case needed
        driver.manage().window().maximize();
        // Go to url : http://www.uitestpractice.com/
        driver.get("https://testpages.herokuapp.com/styled/index.html");
    }

    @Test
    public void test2() {
        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();

        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("10");

        // Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("5");

        // Click on Calculate
        driver.findElement(By.id("calculate")).click();

        // Get the result
        String result = driver.findElement(By.id("answer")).getText();

        // Verify the result
        Assert.assertEquals(result, "15");

        // Print the result
        System.out.println("result = " + result);
    }

    @Test
    public void divisionTest(){

        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();

        // Click division operation
        WebElement division = driver.findElement(By.id("function"));
        Select select = new Select(division);
        select.selectByVisibleText("divide");

        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("20");

        // Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("10");

        // Click on Calculate
        driver.findElement(By.id("calculate")).click();

        // Get the result
        String result = driver.findElement(By.id("answer")).getText();

        // Verify the result
        Assert.assertEquals(result, "2");

        // Print the result
        System.out.println("result = " + result);
    }

    // Close the browser by using @After annotation
    @After
    public void tearDown(){
        driver.quit();
    }
}
