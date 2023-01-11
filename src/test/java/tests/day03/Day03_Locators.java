package tests.day03;

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

public class Day03_Locators {



    WebDriver driver;
    @Before
    public void setUp(){
        // User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // IMPLICIT WAIT
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait int case needed
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @Test
    public void logInTest(){

        // Locating the username and typing the password
        WebElement username = driver.findElement(By.name("username")); //Location username by name
        username.sendKeys("Admin"); // Typing "Admin"
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        //Location the button and clicking
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        // Verifying the login is successful
        //1. We can use default page URL to do assertion
        //2. Or we can locate a CORE ELEMENT on the default page to assert is that element is displayed on the page

        //Login page : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        //Default page: https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals(actualURL, expectedURL); // If login is successful, it PASSES, otherwise it FAILS.

//      NOTE : We do not need to use containers. We can use method chain in selenium
//        driver.findElement(By.name("username")).sendKeys("Admin");
//        driver.findElement(By.name("password")).sendKeys("admin123");
//        driver.findElement(By.tagName("button")).click();


        }
        @After
    public void tearDown() {
            driver.quit();
        }
    }

