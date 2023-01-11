package tests.day18_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.stylesheets.LinkStyle;
import utilities.TestBase;

import java.util.List;

public class Q01 extends TestBase {

    //Calculate the total amount on the table
    //https://testpages.herokuapp.com/styled/tag/table.html

    @Test
    public void test(){

        driver.get("https://testpages.herokuapp.com/styled/tag/table.html");

        List<WebElement> amounts = driver.findElements(By.xpath("//table//tbody//tr//td[2]"));

        double sum = 0;

        for (WebElement w : amounts){
           sum = sum + Double.parseDouble(w.getText());
        }

        System.out.println("sum = " + sum);

        Assert.assertTrue(sum==110.3);
    }
}
