package tests.day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class Day07_WindowHandle1 extends TestBase {

    @Test
    public void windowHandleTest(){

        //Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

        //Then user verifies the text : “Opening a new window”
        String window1Text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window", window1Text);

        //Then user verifies the title of the page is “The Internet”
        Assert.assertEquals("The Internet", driver.getTitle());

        //GETTING THE WINDOW 1 HANDLE(UNIQUE PAGE ID)
        String window1Handle = driver.getWindowHandle(); //RETURNS THE CURRENT WINDOW ID
        System.out.println("window1Handle = " + window1Handle);

        //When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();


        //WE DO TESTING IN A NEW WINDOW, SO WE MUST SWITCH TO THAT WINDOW
        //AS OF NOW 2 WINDOWS OPEN, USE getWindowHandles() TO GET BOTH IDs
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("allWindowHandles = " + allWindowHandles);
        for (String eachHandle : allWindowHandles){
            if (!eachHandle.equals(window1Handle)){
                driver.switchTo().window(eachHandle);
            }
        }

        //Then user verifies the new window title is “New Window”
        Assert.assertEquals("New Window", driver.getTitle());


        String window2Handle = driver.getWindowHandle();// WINDOW 2 ID
        //Then user verifies the text:  “New Window”
        String window2Text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window", window2Text);

        //When user goes back to the previous window and then verifies the title : “The Internet”
        driver.switchTo().window(window1Handle);// Switches to window 1;
        Assert.assertEquals("The Internet", driver.getTitle());


    }

}
