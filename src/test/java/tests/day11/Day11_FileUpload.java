package tests.day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day11_FileUpload extends TestBase {

    @Test
    public void fileUploadTest(){

        driver.get("https://the-internet.herokuapp.com/upload");
        //1. Locate choose file
        //<input type="file">
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

        //2. Select a file from your computer
        String userHOME = System.getProperty("user.home");
        String pathOfFile = userHOME + "\\OneDrive\\Desktop\\logo.jpeg"; //WINDOWS
        //"C:\Users\akdem\OneDrive\Desktop\logo.jpeg"

        chooseFileButton.sendKeys(pathOfFile);

        //3. Then locate and click upload
        driver.findElement(By.id("file-submit")).click();

        //4. Asserting
        boolean isDisplayed = driver.findElement(By.xpath("//h3")).getText().equals("File Uploaded!");
        Assert.assertTrue(isDisplayed);
    }

    /*
    How do you upload a file with Selenium?
    -First, Selenium has limitation automation of files. But file upload can be done with Selenium.
    We locate the choose file button and use "sendKeys()" function to send the path of the file.
    Then we click upload button to upload the file.
    Path of the file should be dynamic - use "System.getProperty("user.home")


       LIMITATION:
    Selenium has limitation automation DESKTOP APPS
    For example, we can not find path of files, or verify if file exists on out machines with selenum
    Instead we use java File libraries
     */
}
