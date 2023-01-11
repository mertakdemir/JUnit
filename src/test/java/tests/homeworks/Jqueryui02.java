package tests.homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Jqueryui02 extends TestBase {

    /*
    When user goes to https://jqueryui.com/datepicker/
And select the next date of the current date
EG if today is August 30, 2022 -> select August 31, 2022
     */

    @Test
    public void test() throws IOException {

        driver.get("https://jqueryui.com/datepicker/");

        driver.switchTo().frame(0);

        WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
        date.click();

        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td[.='4']")).click();
        waitFor(3);
        takeScreenshotOfTheElement(date);

    }

    @Test
    public void test1(){

        driver.get("https://jqueryui.com/datepicker/");

        driver.switchTo().frame(0);

        WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
        date.click();

        List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td[@data-handler='selectDay']"));

        String currentDate = new SimpleDateFormat("d").format(new Date());
        System.out.println(currentDate);

        for (int i = 0; i<days.size(); i++){

            if (days.get(i).getText().equals(currentDate)){

                days.get(i+1).click();
            }
        }


    }
}
