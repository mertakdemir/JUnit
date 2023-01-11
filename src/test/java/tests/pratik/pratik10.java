package tests.pratik;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class pratik10 extends TestBase {

    @Test
    public void test1(){

        String userDIR = System.getProperty("user.dir");
        System.out.println("userDIR = " + userDIR);

        String userHOME = System.getProperty("user.home");
        System.out.println("userHOME = " + userHOME);

        String path = userHOME + "\\OneDrive\\Desktop\\logo.jpeg";
        boolean isExist = Files.exists(Paths.get(path));
        Assert.assertTrue(isExist);

    }

    @Test
    public void test2(){

        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        driver.findElement(By.linkText("b10 all test cases, code.docx")).click();

        String userHOME = System.getProperty("user.home");
        String path = userHOME + "\\Downloads\\b10 all test cases, code.docx";

        boolean isExist = Files.exists(Paths.get(path));
        Assert.assertTrue(isExist);

    }

    @Test
    public void test3() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement upload = driver.findElement(By.id("file-upload"));
        String userHOME = System.getProperty("user.home");
        String path =  userHOME + "\\OneDrive\\Desktop\\logo.jpeg";
        upload.sendKeys(path);

        driver.findElement(By.id("file-submit")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().equals("File Uploaded!"));

    }

    @Test
    public void test4(){

        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

        driver.findElement(By.id("myCountry")).sendKeys("uni");

        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();

        driver.findElement(By.xpath("//input[@type='button']")).click();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You selected: United Kingdom");
    }

    @Test
    public void test5() throws IOException {

        driver.get("https://www.amazon.com");

        takeScreenshotOfPage();
    }


}
