package tests.automation_exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Task8 extends TestBase {

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. The products list is visible
7. Click on 'View Product' of first product
8. User is landed to product detail page
9. Verify that detail is visible: product name, category, price, availability, condition, brand
     */

    @Test
    public void test(){

        //    1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Features Items']")).isDisplayed());

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='All Products']")).isDisplayed());

        //6. The products list is visible
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='product-image-wrapper']"));
        int counter = 0;
        for (WebElement w : products){
            if (w.isDisplayed()){
                counter++;
            }

        }
        System.out.println(products.size());
        System.out.println(counter);

        Assert.assertEquals(products.size(), counter);

        //7. Click on 'View Product' of first product
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();

        //8. User is landed to product detail page
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-information']")).isDisplayed());

        //9. Verify that detail is visible: product name, category, price, availability, condition, brand
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Blue Top']")).isDisplayed());


    }
}
