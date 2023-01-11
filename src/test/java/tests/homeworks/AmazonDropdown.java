package tests.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

//Create A Class: AmazonDropdown
public class AmazonDropdown {
    WebDriver driver;

    //Create A Method dropdownTest
    //Go to https://www.amazon.com/
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test1(){

        //Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

        //Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
        Select select = new Select(dropdown);
        String firstElement = select.getFirstSelectedOption().getText();
        assertEquals("All Departments", firstElement);

        //Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
        //select.selectByIndex(3);
        //String fourthElement = select.getFirstSelectedOption().getText();
        //Assert.assertEquals(fourthElement, "Amazon Devices");

        //Print all the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
        List<WebElement> allOptions = select.getOptions();
        for (WebElement w : allOptions){
            System.out.println(w.getText());
        }

        //Print the total number of options in the dropdown
        int totalNumber = allOptions.size();
        System.out.println(totalNumber);

        //Assert if ‘Appliances’ is a dropdown option. Print true if “Appliances” is an option. Print false otherwise.
        boolean flag = false;
        for (WebElement w : allOptions){
            if (w.getText().contains("Appliances")){
                flag = true;
            }
        }
        Assert.assertFalse(flag);

        //BONUS: Assert if the dropdown is in Alphabetical Order
        List<String> optionList = new ArrayList<>();
        for (WebElement w: allOptions){
            optionList.add(w.getText());
        }
        List<String> expectedList = new ArrayList<>(optionList);
        Collections.sort(expectedList);
        assertEquals(expectedList,optionList);








    }

     @After
    public void tearDown(){
        driver.quit();
     }
}
