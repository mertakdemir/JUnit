package tests.homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class Jqueryui04 extends TestBase {

    //When user goes to https://jqueryui.com/autocomplete/
    //And type Apple
    //Then select Applescript

    @Test
    public void test() throws IOException {


        driver.get("https://jqueryui.com/autocomplete/");
        driver.switchTo().frame(0);

        driver.findElement(By.xpath("//input[@id='tags']")).sendKeys("Apple");
        WebElement apple = driver.findElement(By.xpath("//div[.='AppleScript']"));
        apple.click();


    }
}
