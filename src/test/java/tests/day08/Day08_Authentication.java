package tests.day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day08_Authentication extends TestBase {

    @Test
    public void authTest(){

        /*
        username : admin
        password : admin
        URL : the-internet.herokuapp.com/basic_auth
        SPECIAL URL FOR AUTHENTICATION:
        GO LINK : https://username:password@url
         */

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String successMessage = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(successMessage.contains("Congratulations! You must have the proper credentials."));

    }
}
