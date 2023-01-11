package tests.day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Day08_WindowHandle2 extends TestBase {

    @Test
    public void newWindowTest(){

        //open TechProEducation on window 1
        driver.get("https://www.techproeducation.com");
        String techProTitle = driver.getTitle();
        Assert.assertTrue(techProTitle.contains("Techpro Education"));
        String techProHandle = driver.getWindowHandle();//getting window 1 id

        //open amazon on window 2
        driver.switchTo().newWindow(WindowType.WINDOW);//Creates a new window and switches to that automatically
        driver.get("https://amazon.com");
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));
        String amazonHandle = driver.getWindowHandle();//getting window 2 id

        //open Linkedin on window 3
        driver.switchTo().newWindow(WindowType.WINDOW);//Creates a new window and switches to that automatically
        driver.get("https://linkedin.com");
        String linkedinTitle = driver.getTitle();
        Assert.assertTrue(linkedinTitle.contains("LinkedIn"));
        String linkedinHandle = driver.getWindowHandle();//getting window 3 id


        //Switch back to TechPro
        driver.switchTo().window(techProHandle);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //Switch back to amazon
        driver.switchTo().window(amazonHandle);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //Switch back to LinkedIn
        driver.switchTo().window(linkedinHandle);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
    }

    @Test
    public void newTabTest(){

        //open TechProEducation on TAB 1
        driver.get("https://www.techproeducation.com");
        String techProTitle = driver.getTitle();
        Assert.assertTrue(techProTitle.contains("Techpro Education"));
        String techProHandle = driver.getWindowHandle();//getting TAB 1 id

        //open amazon on TAB 2
        driver.switchTo().newWindow(WindowType.TAB);//Creates a new TAB and switches to that automatically
        driver.get("https://amazon.com");
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));
        String amazonHandle = driver.getWindowHandle();//getting TAB 2 id

        //open Linkedin on TAB 3
        driver.switchTo().newWindow(WindowType.TAB);//Creates a new TAB and switches to that automatically
        driver.get("https://linkedin.com");
        String linkedinTitle = driver.getTitle();
        Assert.assertTrue(linkedinTitle.contains("LinkedIn"));
        String linkedinHandle = driver.getWindowHandle();//getting TAB 3 id


        //Switch back to TechPro
        driver.switchTo().window(techProHandle);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //Switch back to amazon
        driver.switchTo().window(amazonHandle);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //Switch back to LinkedIn
        driver.switchTo().window(linkedinHandle);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

    }
}
