package tests.pratik;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class pratik6 extends TestBase {

    @Test
    public void test1(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        String actual = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Alert", actual);

        driver.switchTo().alert().accept();

        String actual2 = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You successfully clicked an alert", actual2);
    }

    @Test
    public void test2(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        String actual3 = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Confirm", actual3);

        driver.switchTo().alert().dismiss();

        String actual4 = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You clicked: Cancel", actual4);
    }

    @Test
    public void test3(){

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        String actual5 = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS prompt", actual5);

        driver.switchTo().alert().sendKeys("Hello World");
        driver.switchTo().alert().accept();

        String actual6 = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You entered: Hello World", actual6);


    }

    @Test
    public void test4(){

        driver.get("https://the-internet.herokuapp.com/iframe");
        String a = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(a.contains("Editor"));

        driver.switchTo().frame(0);
        //driver.switchTo().frame("mce_0_ifr");
        //driver.switchTo().frame("//iframe[@id='mce_0_ifr']");

        WebElement box = driver.findElement(By.xpath("//p"));

        box.clear();

        box.sendKeys("This text box is inside the iframe");

        driver.switchTo().parentFrame();
        Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
    }

    @Test
    public void test5(){

        driver.get("https://the-internet.herokuapp.com/windows");

        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window", text);

        Assert.assertEquals("The Internet", driver.getTitle());

        String window1Handle = driver.getWindowHandle();
        System.out.println("window1Handle = " + window1Handle);

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> allOptions = driver.getWindowHandles();
        for (String w : allOptions){
            if (!w.equals(window1Handle)){
                driver.switchTo().window(w);
            }
        }

        Assert.assertEquals("New Window", driver.getTitle());

        String text2 = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window", text2);

        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet", driver.getTitle());

    }

}
