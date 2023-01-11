package tests.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_URLVerification {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com");

        //Verify if homepage url is "https://techproeducation.com/"
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://techproeducation.com/";

        if (actualURL.equals(expectedURL)){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
            System.out.println("ACTUAL URL : " + actualURL);
            System.out.println("EXPECTED URL : " + expectedURL);
        }

        driver.quit();

        /*
        WHAT IS YOUR APPROACH FOR AUTOMATION?
        -I read the acceptance criteria carefully.
        -Then I create my test cases
        -Then I do my manual testing FIRST
         -If all good, then I start complete my automation script
         -If I find a bug or defect, then I talk to DEV. Dev fixes the issue, then I retest. If all is good, then start my automation script.
        -When the automation is complete, I prepare the report for the user story. In fact, My automation script
        generates html reports for us. I upload those reports to the JIRA.
        -For my manual test cases, I manually take screenshots and prepare reports and attach them to the JIRA.
        WHAT DO WE DO WHEN OUR TEST CASE PASS ?
    - Prepare report and upload to JIRA
--------------------------------------------------
        WHAT DO YOU DO WHEN YOUR TEST CASE FAILS?
    -Retest to make sure from the failure.It can be data issue, typo, documentation issue or is can be a real bug.
    -If that is a bug, then talk to the dev and let them fix the bug.
    -After the fix, we retest. when test cases passes we upload to JIRA
------------------------------------------------
        WHAT DO YOU DO WHEN YOU FIND A BUG ?
    -Retest to make sure from the failure.It can be data issue, typo, documentation issue or is can be a real bug.
    -If that is a bug, then talk to the dev and let them fix the bug.
    -After the fix, we retest. when test cases passes we upload to JIRA
------------------------------------------------
         */
    }
}
