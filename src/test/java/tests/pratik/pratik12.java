package tests.pratik;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pratik12 extends TestBase {

    @Test
    public void test1() throws InterruptedException {


        //Go to https://demo.guru99.com/test/drag_drop.html
        driver.get("https://demo.guru99.com/test/drag_drop.html");


        Thread.sleep(5000);
        //Drag orange elements on proper boxes below them
        Actions actions = new Actions(driver);
        WebElement bank = driver.findElement(By.xpath("//a[.=' BANK ']"));
        WebElement debitAccount = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
        WebElement amount = driver.findElement(By.xpath("//a[.=' 5000']"));
        WebElement debitAmount = driver.findElement(By.xpath("(//li[@class='placeholder'])[2]"));
        WebElement sales = driver.findElement(By.xpath("//a[.=' SALES ']"));
        WebElement creditAccount = driver.findElement(By.xpath("(//li[@class='placeholder'])[3]"));
        WebElement amount2 = driver.findElement(By.xpath("//a[.=' 5000 ']"));
        WebElement creditAmount = driver.findElement(By.xpath("(//li[@class='placeholder'])[4]"));

        actions.dragAndDrop(bank, debitAccount).dragAndDrop(amount, debitAmount).dragAndDrop(sales, creditAccount).dragAndDrop(amount2, creditAmount).build().perform();

        Thread.sleep(3000);
        //Verify they are dropped.
        Assert.assertTrue(driver.findElement(By.id("equal")).isDisplayed());
    }

    @Test
    public void test2(){

        //        Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

        //       Type "My File" into "Notes about the file" input
        driver.findElement(By.xpath("//input[@name='note']")).sendKeys("My File");

        //        Select the file to upload
        String userHome = System.getProperty("user.home");
        String path = userHome+"\\OneDrive\\Desktop\\My File.txt";
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(path);


        //        Click on "Press" button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //        Assert that "Your notes on the file were" equals "My File"
        Assert.assertTrue(driver.findElement(By.xpath("//blockquote")).getText().equals("My File"));

        //        Assert that file Content contains "You uploaded me"
        Assert.assertTrue(driver.findElement(By.xpath("//pre")).getText().contains("You uploaded me"));
    }

    @Test
    public void test3(){

        //        Go to http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        //        Click on the "Add Element" button 100 times
        WebElement addElement = driver.findElement(By.xpath("//button[.='Add Element']"));
        for (int i = 0; i<100; i++){
            addElement.click();
        }

        //        Click on the "Delete" button 20 times
        List<WebElement> delete = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        for (int i = 0; i<20; i++){
            delete.get(i).click();
        }

        List<WebElement> afterDelete = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));

        //        Assert that 20 buttons were deleted.
        Assert.assertEquals(afterDelete.size(), 80);



    }

    @Test
    public void test4(){

        //      Go to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

        //      Enter the username  as "standard_user"
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //      Enter the password as   "secret_sauce"
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //      Click on login button
        driver.findElement(By.id("login-button")).click();

        //      Order products by "Price (low to high)"
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Price (low to high)");

        //      Assert that last product costs $49.99, first product costs $7.99
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        Assert.assertTrue(products.get(0).getText().equals("$7.99"));
        Assert.assertTrue(products.get(products.size()-1).getText().equals("$49.99"));

    }

    @Test
    public void test5() throws InterruptedException {

        //        Go to http://webdriveruniversity.com/To-Do-List/index.html
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");


        Thread.sleep(3000);
        //        Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
        Actions actions = new Actions(driver);
        WebElement todos = driver.findElement(By.xpath("//input[@type='text']"));
        List<String> elements = new ArrayList<>(Arrays.asList("Prepare breakfast", "Wash the dishes", "Take care of baby", "Help your kid's homework", "Study Selenium", "Sleep"));
        for (String w : elements){
            actions.click(todos).sendKeys(w).sendKeys(Keys.ENTER).build().perform();
        }

        Thread.sleep(3000);
        //        Strikethrough all todos.
        List<WebElement> strike = driver.findElements(By.xpath("//li"));
        for (WebElement w : strike){
            w.click();
        }

        Thread.sleep(3000);
        //        Delete all todos.
        List<WebElement> delete = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));
        for (WebElement w : delete){
            w.click();
        }


        Thread.sleep(3000);
        //        Assert that all todos deleted.
        List<WebElement> todo = driver.findElements(By.xpath("//li"));
        Assert.assertEquals(todo.size(), 0);

    }
}
