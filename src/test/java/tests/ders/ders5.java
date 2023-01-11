package tests.ders;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class ders5 extends TestBase {

    @Test
    public void test1(){


        driver.get("https://the-internet.herokuapp.com/tables");

        String a =  driver.findElement(By.xpath("//table[@id='table1']//thead//tr//th[.='Email']")).getText();
        System.out.println("a = " + a);

        String b = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr//td[.='http://www.timconway.com']")).getText();
        System.out.println("b = " + b);

        List<WebElement> row5 = driver.findElements(By.xpath("//table[@id='table1']//tr[4]//td"));

        for (WebElement w : row5){
            System.out.println("w.getText() = " + w.getText());
        }

    }
}
