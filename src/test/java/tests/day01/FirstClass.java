package tests.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
    public static void main(String[] args) {
        //1st Step: Set up Chrome Driver
        System.setProperty("webdriver.chrome.driver","./src/drivers/chromedriver.exe");

        //2nd Step: Create Chrome Driver
        WebDriver driver = new ChromeDriver();

        //3rd Step: Now that we created web-driver, we can automate web application
        driver.get("https://www.techproeducation.com");

    }
}
