package tests.pratik;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class pratik9 extends TestBase {

    @Test
    public void test1() {

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);

        WebElement search = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(search, target).perform();
        actions.clickAndHold(search).moveToElement(target).build().perform();
        actions.clickAndHold(search).moveByOffset(160, 30).perform();
        actions.dragAndDropBy(search, 160, 30).perform();


    }

    @Test
    public void test2() {

        driver.get("https://www.amazon.com");

        //Find the total number of cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("cookies.size() = " + cookies.size());

        //Print all the cookies
        for (Cookie w : cookies) {
            System.out.println("w.getName() = " + w.getName());
        }
        //Get the cookies by their name
        Cookie cookie = driver.manage().getCookieNamed("i18n-prefs");

        //Add a new cookie
        Cookie cookie2 = new Cookie("First", "My First Cookie");
        driver.manage().addCookie(cookie2);

        //Delete cookie by name
        driver.manage().deleteCookieNamed("session-id-time");

    }

    @Test
    public void test3() throws InterruptedException {

        driver.get("https://phptravels.com/demo/");
        driver.findElement(By.name("first_name")).sendKeys("John");
        driver.findElement(By.name("last_name")).sendKeys("Doe");
        driver.findElement(By.name("business_name")).sendKeys("QA Engineer");
        driver.findElement(By.name("email")).sendKeys("john@doe.com");
        int num1 = Integer.valueOf(driver.findElement(By.id("numb1")).getText());
        int num2 = Integer.valueOf(driver.findElement(By.id("numb2")).getText());
        String result = num1+num2+"";
        driver.findElement(By.id("number")).sendKeys(result);
        driver.findElement(By.id("demo")).click();
        //String alert = driver.switchTo().alert().getText();
        //Assert.assertTrue(alert.equals("Something went wrong please try again later"));
        //driver.switchTo().alert().accept();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//strong[.=' Thank you!']")).isDisplayed());

    }

    @Test
    public void test4() {

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        WebElement iframe = driver.findElement(By.id("emoojis"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();

        List<WebElement> emojis = driver.findElements(By.xpath("//div[@id='nature']/div/img"));
        for (WebElement w : emojis){
            w.click();
        }

        driver.switchTo().defaultContent();

        List<WebElement> text = driver.findElements(By.xpath("//input"));
        List<String> input = new ArrayList<>(Arrays.asList("This", "iFrame", "example", "looks", "really", "funny", "does", "not", "it", "?", "!"));

        for (int i = 0; i<text.size(); i++){

            text.get(i).sendKeys(input.get(i));
        }

        driver.findElement(By.id("send")).click();

        WebElement code = driver.findElement(By.id("code"));
        Assert.assertTrue(code.isDisplayed());

    }

    @Test
    public void test5() {
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        driver.findElement(By.id("button1")).click();

        String alert = driver.switchTo().alert().getText();
        Assert.assertTrue(alert.equals("I am an alert box!"));

        driver.switchTo().alert().accept();
    }

    @Test
    public void test6() {
        driver.get("https://www.gmibank.com/");

        WebElement hover = driver.findElement(By.xpath("//h4[.='Premium']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hover).perform();
        driver.findElement(By.xpath("(//a[.='Book Now'])[2]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("services"));
    }

    @Test
    public void test7(){
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement stockholm = driver.findElement(By.id("box2"));
        WebElement washington = driver.findElement(By.id("box3"));
        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement seoul = driver.findElement(By.id("box5"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement madrid = driver.findElement(By.id("box7"));

        WebElement norway = driver.findElement(By.id("box101"));
        WebElement sweden = driver.findElement(By.id("box102"));
        WebElement usa = driver.findElement(By.id("box103"));
        WebElement denmark = driver.findElement(By.id("box104"));
        WebElement korea = driver.findElement(By.id("box105"));
        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(oslo, norway).
                dragAndDrop(stockholm,sweden).
                dragAndDrop(washington, usa).
                dragAndDrop(copenhagen, denmark).
                dragAndDrop(seoul, korea).
                dragAndDrop(rome, italy).
                dragAndDrop(madrid, spain).
                build().
                perform();
    }


}
