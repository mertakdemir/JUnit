package tests.demoqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class Task3 extends TestBase {

    @Test
    public void test(){

        driver.get("https://demoqa.com/");
        driver.findElement(By.xpath("//h5[.='Alerts, Frame & Windows']")).click();

        driver.findElement(By.xpath("//span[.='Browser Windows']")).click();

        driver.findElement(By.id("tabButton")).click();

        String window = driver.getWindowHandle();

        Set<String> windows = driver.getWindowHandles();
        for (String w : windows){
            if (!w.equals(window)){
                driver.switchTo().window(w);
            }
        }
        waitFor(3);

        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        driver.switchTo().window(window);
        waitFor(3);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[.='Browser Windows'])[1]")).isDisplayed());

    }

    @Test
    public void test2(){

        driver.get("https://demoqa.com/");
        driver.findElement(By.xpath("//h5[.='Alerts, Frame & Windows']")).click();

        driver.findElement(By.xpath("//span[.='Alerts']")).click();

        driver.findElement(By.id("alertButton")).click();
        String text = driver.switchTo().alert().getText();
        Assert.assertTrue(text.contains("button"));
        driver.switchTo().alert().accept();

        driver.findElement(By.id("timerAlertButton")).click();
        waitFor(6);

        String text2 = driver.switchTo().alert().getText();
        Assert.assertTrue(text2.contains("appeared"));
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmButton")).click();
        String text3 = driver.switchTo().alert().getText();
        Assert.assertTrue(text3.contains("confirm"));
        driver.switchTo().alert().dismiss();
        Assert.assertTrue(driver.findElement(By.id("confirmResult")).isDisplayed());

        driver.findElement(By.id("promtButton")).click();
        String text4 = driver.switchTo().alert().getText();
        Assert.assertTrue(text4.contains("enter"));
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.id("promptResult")).isDisplayed());
    }

}
