package tests.demoqa;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Task1 extends TestBase {

    @Test
    public void test1(){

        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[.='Elements']")).click();

        driver.findElement(By.xpath("//span[.='Text Box']")).click();

        driver.findElement(By.id("userName")).sendKeys("Mert Akdemir");
        driver.findElement(By.id("userEmail")).sendKeys("abc@abc.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Stockholm");
        driver.findElement(By.id("permanentAddress")).sendKeys("Sweden");
        driver.findElement(By.id("submit")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']")).isDisplayed());
    }

    @Test
    public void test2(){

        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[.='Elements']")).click();

        driver.findElement(By.xpath("//span[.='Check Box']")).click();
        driver.findElement(By.xpath("//span[@class='rct-checkbox']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[.='You have selected :']")).isDisplayed());

        driver.findElement(By.xpath("//span[@class='rct-checkbox']")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[7]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[.='You have selected :']")).isDisplayed());

        driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
        driver.findElement(By.xpath("//span[@class='rct-checkbox']")).click();
        driver.findElement(By.xpath("//span[@class='rct-checkbox']")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
        driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[3]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[.='You have selected :']")).isDisplayed());

    }

    @Test
    public void test3() throws InterruptedException {

        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[.='Elements']")).click();

        driver.findElement(By.xpath("//span[.='Radio Button']")).click();
        driver.findElement(By.xpath("(//label[@class='custom-control-label'])[2]")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//span[.='Impressive']")).isDisplayed());
    }

    @Test
    public void test4(){

        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[.='Elements']")).click();

        driver.findElement(By.xpath("//span[.='Web Tables']")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='rt-tbody']//div//div//div[@class='rt-td']"));

        for (WebElement w : elements){
            if (!w.getText().contains(" ")){
                System.out.println(w.getText());
            }
        }
    }

    @Test @Ignore
    public void test5() throws InterruptedException {

        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[.='Elements']")).click();

        driver.findElement(By.xpath("//span[.='Buttons']")).click();


        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        WebElement click = driver.findElement(By.xpath("(//button[@type='button'])[4]"));

        Actions actions = new Actions(driver);

        actions.doubleClick(doubleClick);
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed());

        actions.contextClick(rightClick);
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).isDisplayed());

        actions.click(click);
        Thread.sleep(4000);
        Assert.assertTrue(driver.findElement(By.id("dynamicClickMessage")).isDisplayed());

    }

    @Test
    public void test6(){

        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[.='Elements']")).click();

        driver.findElement(By.xpath("//span[.='Links']")).click();

        String windowHandle1 = driver.getWindowHandle();

        driver.findElement(By.id("simpleLink")).click();

        Set<String> windows = driver.getWindowHandles();
        for (String w : windows){
            if (!w.equals(windowHandle1)){
                driver.switchTo().window(w);
            }
        }

        String windowHandle2 = driver.getWindowHandle();

        driver.findElement(By.xpath("//h5[.='Elements']")).click();

        driver.findElement(By.xpath("//span[.='Links']")).click();

        driver.findElement(By.id("bad-request")).click();

        Assert.assertTrue(driver.findElement(By.id("linkResponse")).isDisplayed());

        driver.switchTo().window(windowHandle1);

    }

    @Test
    public void test7(){

        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[.='Elements']")).click();

        driver.findElement(By.xpath("//span[.='Broken Links - Images']")).click();

        driver.findElement(By.xpath("//a[.='Click Here for Valid Link']")).click();
        Assert.assertEquals(driver.getTitle(), "ToolsQA");

        driver.navigate().back();

        driver.findElement(By.xpath("//a[.='Click Here for Broken Link']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        driver.navigate().back();
        Assert.assertTrue(driver.findElement(By.xpath("//p[.='Broken image']")).isDisplayed());

    }

    @Test
    public void test8() throws InterruptedException {

        driver.get("https://demoqa.com/");

        driver.findElement(By.xpath("//h5[.='Elements']")).click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[.='Upload and Download']")).click();

        String userHome = System.getProperty("user.home");
        String path = userHome+"\\OneDrive\\Desktop\\sampleFile.jpeg";
        driver.findElement(By.id("uploadFile")).sendKeys(path);
        Assert.assertTrue(driver.findElement(By.id("uploadedFilePath")).isDisplayed());

    }

    @Test
    public void test9() throws InterruptedException {

        driver.get("https://demoqa.com/");
        driver.findElement(By.xpath("//h5[.='Elements']")).click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[.='Dynamic Properties']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement visible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        Assert.assertTrue(visible.isDisplayed());
    }
}
