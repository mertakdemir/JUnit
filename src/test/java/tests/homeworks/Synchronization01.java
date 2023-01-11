package tests.homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Synchronization01 extends TestBase {

    @Test
    public void test(){


        //Go to https://the-internet.herokuapp.com/dynamic_loading/2
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        //When user clicks on the Start button
        driver.findElement(By.xpath("//button[.='Start']")).click();

        //Then verify the ‘Hello World!’ Shows up on the screen
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']")));
        Assert.assertTrue(helloWorld.isDisplayed());

        //waitForClickAbility(driver.findElement(By.xpath("//h4[.='Hello World!']")), 10);
        //Assert.assertTrue(driver.findElement(By.xpath("//h4[.='Hello World!']")).isDisplayed());
    }
}
