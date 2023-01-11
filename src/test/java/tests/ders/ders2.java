package tests.ders;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ders2 extends TestBase{

     /*

    Given
         Go to url : https://phptravels.com/demo/
    When
         Fill the form
    And
         Click on 'SUBMIT'
    Then
         Assert that the form has been sent
     */

    @Test @Ignore
    public void test1() throws InterruptedException {

        driver.get("https://phptravels.com/demo/");

        driver.findElement(By.name("first_name")).sendKeys("John");
        driver.findElement(By.name("last_name")).sendKeys("Doe");
        driver.findElement(By.name("business_name")).sendKeys("QA Engineer");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("john@doe.com");

        int num1 = Integer.valueOf(driver.findElement(By.id("numb1")).getText());
        int num2 = Integer.valueOf(driver.findElement(By.id("numb2")).getText());
        String sum = String.valueOf(num1 + num2);
        System.out.println(sum);

        WebElement result = driver.findElement(By.id("number"));
        result.sendKeys(sum);

        driver.findElement(By.xpath("//button[@id='demo']")).click();

        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//strong[.=' Thank you!']")).isDisplayed());

    }

    @Test
    public void test2() throws InterruptedException {
        /*
    Given
        Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    When
        Click on the "Animals and Nature" emoji
    And
        Click all the "Animals and Nature"  emoji elements
    And
        Fill the form
    And
        Press the apply button
    Then
        Verify "code" element is displayed
     */
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        WebElement iframe = driver.findElement(By.id("emoojis"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();

        List<WebElement> emojis = driver.findElements(By.xpath("//div[@id='nature']//div//img"));
        for (WebElement w : emojis){
            w.click();
        }

        System.out.println(emojis.size());

        driver.switchTo().defaultContent();

        List<WebElement> form = driver.findElements(By.xpath("//input"));
        List<String> fill = new ArrayList<>(Arrays.asList("This", "iFrame", "example", "looks", "really", "funny", "does", "not", "it", "?", "!"));

        for (int i = 0; i< form.size(); i++){

            form.get(i).sendKeys(fill.get(i));

        }

        Thread.sleep(3000);

        driver.findElement(By.id("send")).click();

        Assert.assertTrue(driver.findElement(By.id("code")).isDisplayed());


    }

    @Test
    public void test3(){

        /*
    Given
        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    When
        Click "CLICK ME" of JavaScript Alert
    And
        Get the alert text
    Then
        Verify that message is "I am an alert box!"
    When
        Accept pop-up
     */

        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        driver.findElement(By.xpath("(//p[.='CLICK ME!'])[1]")).click();

        String text = driver.switchTo().alert().getText();

        Assert.assertEquals("I am an alert box!", text);

        driver.switchTo().alert().accept();


    }

    @Test
    public void test4() throws InterruptedException {

        /*
   Given
        Go to https://www.gmibank.com/
   When
        Hover over "Premium" Deposit Package
   And
        Click on "Book Now"
   Then
        Verify url contains "services"
    */

        driver.get("https://www.gmibank.com/");

        Actions actions = new Actions(driver);
        WebElement premium = driver.findElement(By.xpath("//h4[.='Premium']"));
        actions.moveToElement(premium).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//a[.='Book Now'])[2]")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("services"));

    }

    @Test
    public void test5() throws InterruptedException {

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
        actions.
                dragAndDrop(oslo, norway).
                dragAndDrop(stockholm, sweden).
                dragAndDrop(washington, usa).
                dragAndDrop(copenhagen, denmark).
                dragAndDrop(seoul, korea).
                dragAndDrop(rome, italy).
                dragAndDrop(madrid, spain).
                build().
                perform();

        Thread.sleep(4000);

    }


}
