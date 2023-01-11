package tests.pratik;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class pratik7 extends TestBase {

    @Test
    public void test1(){
        driver.get("http://www.uitestpractice.com/");

        driver.findElement(By.xpath("//a[@href='/Students/Form']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Mert");
        driver.findElement(By.id("lastname")).sendKeys("Akdemir");
        driver.findElement(By.xpath("(//input[@name='optradio'])[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@name='optradio'])[1]")).isSelected());
        driver.findElement(By.xpath("//input[@value='read']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='read']")).isSelected());
        WebElement dropdown = driver.findElement(By.id("sel1"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Canada");
        //select.selectByIndex(13);
        driver.findElement(By.id("datepicker")).sendKeys("30/12/1998");
        driver.findElement(By.id("phonenumber")).sendKeys("0700732421");
        driver.findElement(By.id("username")).sendKeys("Excalibur");
        driver.findElement(By.id("email")).sendKeys("akdemirmertsafa@gmail.com");
        driver.findElement(By.id("comment")).sendKeys("Merhaba, ismim Mert Sefa Akdemir");
        driver.findElement(By.id("pwd")).sendKeys("12345");
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.sendKeys(Keys.ENTER);
    }

    @Test
    public void test2(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.id("calculatetest")).click();
        WebElement dropdown = driver.findElement(By.id("function"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("times");
        driver.findElement(By.id("number1")).sendKeys("10");
        driver.findElement(By.id("number2")).sendKeys("5");
        driver.findElement(By.id("calculate")).click();
        String result = driver.findElement(By.id("answer")).getText();
        Assert.assertEquals("50", result);
    }

    @Test
    public void test3(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        String text = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS prompt", text);
        driver.switchTo().alert().sendKeys("Hello World");
        driver.switchTo().alert().accept();
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You entered: Hello World", result);
    }

    @Test
    public void test4(){

        driver.get("https://the-internet.herokuapp.com/iframe");
        String header = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(header.contains("Editor"));
        driver.switchTo().frame("mce_0_ifr");
        //driver.switchTo().frame(0);
        //driver.switchTo().frame("//iframe[@id='mce_0_ifr']");
        WebElement box = driver.findElement(By.xpath("//p"));
        box.clear();
        box.sendKeys("Hello World");
        driver.switchTo().parentFrame();
        Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
    }

    @Test
    public void test5(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String header = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window", header);
        Assert.assertEquals("The Internet", driver.getTitle());
        String window1Handle = driver.getWindowHandle();
        System.out.println("window1Handle = " + window1Handle);
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windows = driver.getWindowHandles();
        for (String w : windows){
            if (!w.equals(window1Handle)){
                driver.switchTo().window(w);
            }
        }
        String window2Handle = driver.getWindowHandle();
        Assert.assertEquals("New Window", driver.findElement(By.xpath("//h3")).getText());
        Assert.assertEquals("New Window", driver.getTitle());

        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet", driver.getTitle());

        driver.switchTo().window(window2Handle);
        Assert.assertEquals("New Window", driver.getTitle());
    }

    @Test
    public void test6(){
        driver.get("https://www.amazon.com/");
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);
        String first = select.getFirstSelectedOption().getText();
        Assert.assertEquals("All Departments", first);
        select.selectByIndex(5);
        String second = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Books", second);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement w : allOptions){
            System.out.println(w.getText());
        }
        System.out.println(allOptions.size());
        boolean flag = false;
        for (WebElement w : allOptions){
            if (w.getText().contains("Baby")){
                flag = true;
            }
        }
        Assert.assertTrue(flag);

        List<String> options = new ArrayList<>();
        for (WebElement w : allOptions){
            options.add(w.getText());
        }
        List<String> options2 = new ArrayList<>(options);
        Collections.sort(options2);
        Assert.assertEquals(options, options2);


    }
}
