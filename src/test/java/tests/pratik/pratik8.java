package tests.pratik;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class pratik8 extends TestBase {

    @Test
    public void test1(){

        driver.get("https://the-internet.herokuapp.com/windows");
        Assert.assertEquals("The Internet", driver.getTitle());
        String header = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window", header);
        String window1Handle = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windows = driver.getWindowHandles();
        for (String w : windows){
            if (!w.equals(window1Handle)){
                driver.switchTo().window(w);
            }
        }
        String window2Handle = driver.getWindowHandle();
        Assert.assertEquals("New Window", driver.getTitle());
        String header2 = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window", header2);

        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet", driver.getTitle());

        driver.switchTo().window(window2Handle);
        Assert.assertEquals("New Window", driver.getTitle());

    }

    @Test
    public void test2(){

        driver.get("https://www.techproeducation.com");
        Assert.assertTrue(driver.getTitle().contains("Education"));
        String first = driver.getWindowHandle();


        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Spend"));
        String second = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://mgmgroup.se");
        Assert.assertTrue(driver.getTitle().contains("MGM"));
        String third = driver.getWindowHandle();

    }

    @Test
    public void test3(){

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Assert.assertEquals("Congratulations! You must have the proper credentials.",driver.findElement(By.xpath("//p")).getText());

    }

    @Test
    public void test4(){
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);

        WebElement box = driver.findElement(By.id("hot-spot"));

        actions.contextClick(box).perform();

        Assert.assertTrue(driver.switchTo().alert().getText().equals("You selected a context menu"));

        driver.switchTo().alert().accept();

    }

    @Test
    public void test5(){
        driver.get("https://www.amazon.com/");

        WebElement hover = driver.findElement(By.id("nav-link-accountList"));

        Actions actions = new Actions(driver);

        actions.moveToElement(hover).perform();

        driver.findElement(By.linkText("Account")).click();

        Assert.assertTrue(driver.getTitle().equals("Your Account"));
    }

    @Test
    public void test6() throws InterruptedException {

        driver.get("https://www.techproeducation.com");

        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(2000);

    }
}
