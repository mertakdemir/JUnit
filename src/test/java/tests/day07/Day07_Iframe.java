package tests.day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day07_Iframe extends TestBase {

    @Test
    public void iframeTest(){

        //Go to https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Verify the Bolded text contains “Editor”
        String header = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(header.contains("Editor"));

        //GETTING IN THE IFRAME
        driver.switchTo().frame(0);
        //driver.switchTo().frame("mce_0_ifr");
        //driver.switchTo().frame("//iframe[@id='mce_0_ifr']");

        //Locate the text box
        WebElement box = driver.findElement(By.xpath("//p"));

        //Delete the text in the text box
        box.clear();//clear() is used to delete the text is the elements

        //Type “This text box is inside the iframe”
        box.sendKeys("This text box is inside the iframe");

        //Verify the text Elemental Selenium text is displayed on the page
        driver.switchTo().parentFrame();
        Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());


    }
}
/*
        What might be the reason for your test case to fail?
        -There may be wait problem. The page may be very slow. Internet maybe not fast enough.
        Put some more wait. We can use explicit wait in selenium(we will learn later)
        -Locator might be incorrect.
        -Double check locator and fix if needed
        -Data issue. Typo in our expected values.
       -If there is any documentation issue, we can talk to BA to fix the document and then we can use correct expected values
        -Maybe there is an iframe on the page
        -We first need to switch to the frame
        -Maybe there is an alert on the page
        -We first need to handle the alert by accepting or dismissing
        -It may be a real bug that is caused by the latest codes.
        -We discuss the issue with the team then raise a bug ticket if needed
 */
