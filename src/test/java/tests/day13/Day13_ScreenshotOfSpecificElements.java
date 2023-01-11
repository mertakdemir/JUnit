package tests.day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class Day13_ScreenshotOfSpecificElements extends TestBase {

    @Test
    public void screenshotTest() throws IOException {

        driver.get("https://techproeducation.com/");

        WebElement techProEdLogo = driver.findElement(By.xpath("//div[@data-id='898ce2e']"));
        Assert.assertTrue(techProEdLogo.isDisplayed());
        waitFor(3);
        takeScreenshotOfTheElement(techProEdLogo);
        waitFor(3);

        //Taking screenshot of social media icons
        WebElement socials = driver.findElement(By.xpath("//div[@data-id='d7545f2']"));
        takeScreenshotOfTheElement(socials);
    }
}
