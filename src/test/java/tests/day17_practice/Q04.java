package tests.day17_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Q04 extends TestBase {

    /*
    Given
        Go to https://testpages.herokuapp.com/
    When
        Click on File Downloads
    And
        Click on Server Download
    Then
        Verify that file is downloaded
     */
    @Test
    public void test(){

        //        Go to https://testpages.herokuapp.com/
        driver.get("https://testpages.herokuapp.com/");

        //        Click on File Downloads
        driver.findElement(By.id("download")).click();

        //        Click on Server Download
        driver.findElement(By.id("server-download")).click();

        //        Verify that file is downloaded
        String userHome = System.getProperty("user.home");
        Path path =  Paths.get(userHome+"\\OneDrive\\Downloads\\textfile.txt");

        Files.exists(path);
    }
}
