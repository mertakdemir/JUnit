package tests.ders;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ders6 extends TestBase {


    @Test
    public void test1(){


        //       Go to https://demo.guru99.com/test/drag_drop.html
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        //       Drag orange elements on proper boxes below them
        Actions actions = new Actions(driver);

        WebElement bank = driver.findElement(By.xpath("//a[.=' BANK ']"));
        WebElement debitAccount = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
        WebElement price = driver.findElement(By.xpath("//a[.=' 5000']"));
        WebElement debitAmount = driver.findElement(By.xpath("(//li[@class='placeholder'])[2]"));
        WebElement sales = driver.findElement(By.xpath("//a[.=' SALES ']"));
        WebElement creditAccount = driver.findElement(By.xpath("(//li[@class='placeholder'])[3]"));
        WebElement price2 = driver.findElement(By.xpath("//a[.=' 5000 ']"));
        WebElement creditAmount = driver.findElement(By.xpath("(//li[@class='placeholder'])[4]"));


        actions.
                dragAndDrop(bank, debitAccount)
                .dragAndDrop(price, debitAmount)
                .dragAndDrop(sales, creditAccount)
                .dragAndDrop(price2, creditAmount)
                .build().perform();


        //       Verify they are dropped.
        waitFor(3);
        Assert.assertTrue(driver.findElement(By.xpath("//a[.='Perfect!']")).isDisplayed());
    }

    @Test
    public void test2(){

        //        Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

        //       Type "My File" into "Notes about the file" input
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("My File");

        //        Select the file to upload
        //"user.dir", "user.home"
        String userHome = System.getProperty("user.home");
        String path = userHome+"\\OneDrive\\Desktop\\My File.txt";
        driver.findElement(By.name("upfile")).sendKeys(path);
        waitFor(3);

        //        Click on "Press" button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //        Assert that "Your notes on the file were" equals "My File"
        Assert.assertEquals("My File", driver.findElement(By.xpath("//blockquote")).getText());

        //        Assert that file Content contains "Hello World"
        Assert.assertTrue(driver.findElement(By.xpath("//pre")).getText().contains("Hello World"));
    }

    @Test
    public void test3(){

        //        Go to http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        //        Click on the "Add Element" button 100 times
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        for (int i = 0; i<100; i++){
            addElement.click();
        }

        //        Click on the "Delete" button 20 times
        List<WebElement> delete = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        for (int i = 0; i<20; i++){
            delete.get(i).click();
        }

        //        Assert that 20 buttons were deleted.
        List<WebElement> afterDelete = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        Assert.assertEquals(delete.size(), afterDelete.size()+20);
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
        waitFor(2);
        Assert.assertTrue(driver.findElement(By.xpath("//span[.='Products']")).isDisplayed());

        //      Order products by "Price (low to high)"
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Price (low to high)");

        //      Assert that last product costs $49.99, first product costs $7.99
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        Assert.assertTrue(prices.get(0).getText().equals("$7.99"));
        Assert.assertTrue(prices.get(prices.size()-1).getText().equals("$49.99"));

    }

    @Test
    public void test4Olumsuz(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user123");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }

    @Test
    public void test5(){

        //Go to http://webdriveruniversity.com/To-Do-List/index.html
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

        //Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
        WebElement todos = driver.findElement(By.xpath("//input[@type='text']"));
        List<String> todosToAdd = new ArrayList<>(Arrays.asList("Prepare breakfast", "Wash the dishes", "Take care of baby", "Help your kid's homework", "Study Selenium", "Sleep"));

        for (String w : todosToAdd){
            todos.sendKeys(w, Keys.ENTER);
        }


        //Strikethrough all todos.
        List<WebElement> items = driver.findElements(By.xpath("//li"));
        for (WebElement w : items){
            w.click();
        }

        //        Delete all todos.
        List<WebElement> delete = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));
        for (WebElement w : delete){
            w.click();
        }

        waitFor(4);
        //Assert that all todos deleted.
        List<WebElement> itemsAfterDelete = driver.findElements(By.xpath("//li"));
        Assert.assertEquals(itemsAfterDelete.size(), 0);

    }
}
