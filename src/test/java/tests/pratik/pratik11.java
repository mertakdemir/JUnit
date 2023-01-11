package tests.pratik;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pratik11 extends TestBase {
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    public void autoComplete(String a, String b){

        driver.findElement(By.id("myCountry")).sendKeys(a);

        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='"+b+"']")).click();

        driver.findElement(By.xpath("//input[@type='button']")).click();

        String result = driver.findElement(By.id("result")).getText();

        Assert.assertTrue(result.contains(b));
    }

    @Test
    public void test1(){

        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

        autoComplete("uni", "United Kingdom");

        autoComplete("an", "Angola");

    }

    @Test
    public void test2() throws IOException {

        driver.get("https://amazon.com");

        Actions actions = new Actions(driver);
        WebElement a = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(a);
        takeScreenshotOfPage();

        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        takeScreenshotOfTheElement(logo);
    }



    public void extent() {
        //      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/reports/" + currentTime + "html_report.html";
//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();
//        ***************
//        adding custom System Info
        extentReports.setSystemInfo("Test Environment", "Regression");
        extentReports.setSystemInfo("Application", "TechProEd");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Team", "Eagles");
        extentReports.setSystemInfo("SQA", "John Fox");
        extentReports.setSystemInfo("Sprint Number", "SP205");
//        adding more custom info
        extentHtmlReporter.config().setReportName("TechProEd home page");
        extentHtmlReporter.config().setDocumentTitle("TechProEd extent reports");
//        ********************
//        DONE WITH CONFIGURATION
        extentReports.attachReporter(extentHtmlReporter);
//        SUMMARY: Extent Reports and Extent HTML Reporter is used to add custom information on the report and create the report in a PATH
//        REPORT IS DONE. NOW CREATING EXTENT TEST TO LOG INFO IN THE TEST CASE
//        Creating extent test
        extentTest = extentReports.createTest("My Extent Reporter", "Regression Test Report");
    }

    @Test
    public void test3(){
        extent();
        driver.get("https://www.amazon.com");
        extentTest.pass("Passed");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop" + Keys.ENTER);
        extentTest.pass("Passed");

        driver.navigate().back();
        extentTest.fail("Failed");

        extentTest.skip("Skipped");

        extentReportsTearDown();

    }

    @Test
    public void test4() throws IOException {

        String path = "./src/test/java/resources/Capitals.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet1 = workbook.getSheet("Sheet1");

        String r2c2 = sheet1.getRow(1).getCell(1).toString();
        System.out.println("r1c1 = " + r2c2);

        String r2c1 = sheet1.getRow(1).getCell(0).toString();
        System.out.println("r2c1 = " + r2c1);

        int numOfRow = sheet1.getLastRowNum()+1;
        System.out.println("numOfRow = " + numOfRow);

        int numOfUsedRow = sheet1.getPhysicalNumberOfRows();
        System.out.println("numOfUsedRow = " + numOfUsedRow);

        //Print country, capital key value pairs as map object
        Map<String, String> a = new HashMap<>();

        for (int i = 1; i<11; i++){

            String country = sheet1.getRow(i).getCell(0).toString();
            String capital = sheet1.getRow(i).getCell(1).toString();
            a.put(country, capital);
        }

        System.out.println("a = " + a);


    }

    @Test
    public void test5() throws IOException {

        String path = "./src/test/java/resources/Capitals.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("Sheet1");

        Row row = sheet.getRow(0);
        //Create a cell on the 3rd column (2nd index) on the first row
        Cell r1c3 = row.createCell(2);
        r1c3.setCellValue("POPULATION");

        //Create a cell on the 2nd row 3rd cell(index2), and write 150000
        sheet.getRow(1).createCell(2).setCellValue("150000");

        //Create a cell on the 3rd row 3rd cell(index2), and write 250000
        sheet.getRow(2).createCell(2).setCellValue("250000");

        //Create a cell on the 4th row 3rd cell(index2), and write 54000
        sheet.getRow(3).createCell(2).setCellValue("54000");

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

    }

    @Test
    public void test6(){

        //https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 1 : Print the entire table
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println("table1 = " + table1);

        //Task 2 : Print All Rows
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        for (WebElement w : allRows){
            System.out.println(w.getText());
        }

        //Task 3 : Print Last row data only
        System.out.println(allRows.get(allRows.size()-1).getText());

        //Task 4 : Print column 5 data in the table body
        List<WebElement> column5 = driver.findElements(By.xpath("//table[@id='table1']//td[5]"));
        int row = 1;
        for (WebElement w : column5){
            System.out.println("Column : "+ row + " Column 5 ==> " + w.getText());
            row++;
        }

        //Task 5 : Write a method that accepts 2 parameters
        //Parameter 1 = row number
        //Parameter 2 = column number
        //printData(2,3);  => prints data in 2nd row 3rd column


    }

    public void data(int row, int column) throws IOException {

         String result = driver.findElement(By.xpath("//table[@id='table1']//tr["+row+"]//td["+column+"]")).getText();

        System.out.println("result = " + result);
    }

    @Test
    public void test7() throws IOException {

        driver.get("https://the-internet.herokuapp.com/tables");
        data(1,1);

    }
    public void extentReportsTearDown(){
//        generating the report
        extentReports.flush();
    }
}
