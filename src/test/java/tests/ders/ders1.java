package tests.ders;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ders1 extends TestBase {

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://www.uitestpractice.com/");
        driver.findElement(By.xpath("(//*[.='Form'])[2]")).click();
        //driver.findElement(By.xpath("//a[@href='/Students/Form']")).click();
        driver.findElement(By.id("firstname")).sendKeys("John");
        driver.findElement(By.id("lastname")).sendKeys("Doe");
        driver.findElement(By.xpath("(//input[@name='optradio'])[1]")).click();
        driver.findElement(By.xpath("//input[@value='read']")).click();
        WebElement dropdown = driver.findElement(By.id("sel1"));
        Select select = new Select(dropdown);
        select.selectByIndex(13);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement w : allOptions){
            System.out.println(w.getText());
        }
        driver.findElement(By.id("datepicker")).sendKeys("02/01/2000");
        driver.findElement(By.id("phonenumber")).sendKeys("12345");
        driver.findElement(By.id("username")).sendKeys("john_doe");
        driver.findElement(By.id("email")).sendKeys("john@doe.com");
        driver.findElement(By.id("comment")).sendKeys("Hi, My name is John Doe");
        driver.findElement(By.id("pwd")).sendKeys("12345");
        WebElement a = driver.findElement(By.xpath("//button[@type='submit']"));
        a.sendKeys(Keys.ENTER);

    }

    @Test
    public void test2(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.id("calculatetest")).click();
        WebElement a = driver.findElement(By.id("function"));
        Select b = new Select(a);
        b.selectByVisibleText("divide");
        driver.findElement(By.id("number1")).sendKeys("10");
        driver.findElement(By.id("number2")).sendKeys("2");
        WebElement division = driver.findElement(By.id("calculate"));
        division.sendKeys(Keys.ENTER);
        String text = driver.findElement(By.id("answer")).getText();
        Assert.assertEquals("5", text);

    }

    @Test
    public void test3(){

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        String text = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Alert", text);
        driver.switchTo().alert().accept();  //accept, dissmiss, sendKeys, getText
        String actual = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You successfully clicked an alert", actual);

        driver.findElement(By.xpath("//*[.='Click for JS Confirm']")).click();
        Assert.assertEquals("I am a JS Confirm", driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        String actual2 = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You clicked: Cancel", actual2);

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        String actual3 = driver.switchTo().alert().getText();
        Assert.assertTrue(actual3.equals("I am a JS prompt"));
        driver.switchTo().alert().sendKeys("Hello World");
        driver.switchTo().alert().accept();
        String actual4 = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(actual4.equals("You entered: Hello World"));


    }

    @Test
    public void test4() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(0);
        //driver.switchTo().frame("mce_0_ifr");
        //river.switchTo().frame("//iframe[@id='mce_0_ifr']");

        WebElement box = driver.findElement(By.xpath("//p"));

        String text = driver.findElement(By.xpath("(//*[.='Your content goes here.'])[3]")).getText();
        Assert.assertEquals("Your content goes here.", text);

        box.clear();

        box.sendKeys("This text box is inside the iframe");
        String text2 = driver.findElement(By.xpath("(//*[.='This text box is inside the iframe'])[3]")).getText();
        Thread.sleep(3000);

        Assert.assertEquals("This text box is inside the iframe", text2);

        driver.switchTo().parentFrame();
        Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());

    }

    @Test
    public void test5(){

        driver.get("https://the-internet.herokuapp.com/windows");

        String window1 = driver.getWindowHandle();
        System.out.println("window1 = " + window1);
        Assert.assertEquals("The Internet", driver.getTitle());

        WebElement a = driver.findElement(By.linkText("Click Here"));
        a.sendKeys(Keys.ENTER);

        Set<String> windows = driver.getWindowHandles();

        for (String w : windows){
            if (!w.equals(window1)){
                driver.switchTo().window(w);
            }
        }

        Assert.assertEquals("New Window", driver.getTitle());



    }

    @Test
    public void test6() {

        driver.get("https://www.google.com/");

        driver.findElement(By.xpath("//*[.='Tümünü kabul et']")).click();


        //Search for “porcelain teapot”
         driver.findElement(By.xpath("//input[@name='q']")).sendKeys("porcelain teapot" + Keys.ENTER);

        //And print how many related results displayed on Google
        String result = driver.findElement(By.id("result-stats")).getText();
        System.out.println("result = " + result);


    }

    @Test
    public void test7(){

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[.='Tümünü kabul et']")).click();


        Assert.assertTrue(driver.getTitle().equals("Google"));

        Assert.assertTrue(driver.findElement(By.id("hplogo")).isDisplayed());

        String isDisplayed = driver.findElement(By.linkText("Gmail")).getText();

        Assert.assertEquals("No there is no such element", isDisplayed, "Gmail");


    }

    @Test
    public void test8(){



        //Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);

        //Get the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals("All Departments", actual);

        //Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
        //select.selectByIndex(3);
        //Assert.assertEquals("Amazon Devices", actual2);


        //Print all the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
         List<WebElement> allOptions = select.getOptions();
        for (WebElement w : allOptions){
            System.out.println(w.getText());
        }

        //GET the total number of options in the dropdown
        int totalNumOfOptions = allOptions.size();
        System.out.println("totalNumOfOptions = " + totalNumOfOptions);

        //Assert if ‘Appliances’ is a dropdown option. Print true if “Appliances” is an option. Print false otherwise.
        boolean flag = false;
        for (WebElement w : allOptions){
            if (w.getText().contains("Appliances")){
                flag = true;
            }
        }
        Assert.assertFalse(false);


        //BONUS: Assert if the dropdown is in Alphabetical Order
        List<String> options = new ArrayList<>();
        System.out.println("options = " + options);
        for (WebElement w : allOptions){
            options.add(w.getText());
        }
        System.out.println("options = " + options);

        List<String> newOptions = new ArrayList<>(options);
        System.out.println("newOptions = " + newOptions);
        Collections.sort(newOptions);

        Assert.assertEquals(options, newOptions);
        //Assert.assertTrue(options.equals(newOptions));
        //Assert.assertFalse(!options.equals(newOptions));



    }
}
