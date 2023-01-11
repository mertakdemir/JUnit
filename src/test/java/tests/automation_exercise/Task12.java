package tests.automation_exercise;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;



public class Task12 extends TestBase {

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Products' button
5. Hover over first product and click 'Add to cart'
6. Click 'Continue Shopping' button
7. Hover over second product and click 'Add to cart'
8. Click 'View Cart' button
9. Verify both products are added to Cart
10. Verify their prices, quantity and total price
     */
    @Test
    public void test() throws InterruptedException {

        //    1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Features Items']")).isDisplayed());

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //5. Hover over first product and click 'Add to cart'
        Thread.sleep(6000);
        WebElement product = driver.findElement(By.xpath("(//div[@class='product-overlay'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[2]")).click();

        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();

        //7. Hover over second product and click 'Add to cart'
        Thread.sleep(6000);
        WebElement product2 = driver.findElement(By.xpath("//a[@href='/product_details/2']"));
        actions.moveToElement(product2).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[.='Add to cart'])[3]")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[.='View Cart']")).click();

        //9. Verify both products are added to Cart
        Assert.assertTrue(driver.findElement(By.xpath("//a[.='Blue Top']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[.='Men Tshirt']")).isDisplayed());

        //10. Verify their prices, quantity and total price
        Assert.assertEquals(driver.findElement(By.xpath("(//p[.='Rs. 500'])[1]")).getText(), "Rs. 500");
        Assert.assertEquals(driver.findElement(By.xpath("(//button[.='1'])[1]")).getText(), "1");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[.='Rs. 500'])[2]")).getText(), "Rs. 500");

        Assert.assertEquals(driver.findElement(By.xpath("(//p[.='Rs. 400'])[1]")).getText(), "Rs. 400");
        Assert.assertEquals(driver.findElement(By.xpath("(//button[.='1'])[2]")).getText(), "1");
        Assert.assertEquals(driver.findElement(By.xpath("(//p[.='Rs. 400'])[2]")).getText(), "Rs. 400");



    }
}
