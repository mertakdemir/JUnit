package tests.day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Day09_Cookies extends TestBase {

    @Test
    public void cookieTest(){

        driver.get("https://www.amazon.com");

        //Find the total number of cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies = allCookies.size();
        System.out.println("numOfCookies = " + numOfCookies);

        //Print all the cookies
        for (Cookie w : allCookies){
            System.out.println("COOKIE --->> : " + w);
            System.out.println("COOKIE VALUE--->> : " + w.getValue());
            System.out.println("COOKIE NAME--->> : " + w.getName());
        }

        //Get the cookies by their name
        System.out.println("Cookie Named : " + driver.manage().getCookieNamed("i18n-prefs"));

        //Add a new cookie
        Cookie cookie = new Cookie("my-fav-cookie", "apple-pie");
        driver.manage().addCookie(cookie);
        Set<Cookie> newCookies = driver.manage().getCookies();
        System.out.println("New Number Of Cookies ====>>> " + newCookies.size());

        //Delete cookie by name
        driver.manage().deleteCookieNamed("session-id");
        int lastNumOfCookies = driver.manage().getCookies().size();
        System.out.println("Last Number Of Cookies ===>>> " + lastNumOfCookies);

        //Delete all the cookies
        driver.manage().deleteAllCookies();
        int finalNumOfCookies = driver.manage().getCookies().size();
        System.out.println("Final Number Of Cookies ===>>> " + finalNumOfCookies);

    }
}
