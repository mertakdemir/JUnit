package tests.day13;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day13_ReadExcel {


    @Test
    public void readExcelTest() throws IOException {

        //Store the path of the  file in a string
        String path = "./src/test/java/resources/Capitals.xlsx";

        //Open the file
        FileInputStream fileInputStream = new FileInputStream(path);

        //Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Open the first worksheet
        Sheet sheet1 = workbook.getSheet("Sheet1");

        //Go to first row
        Row row1 = sheet1.getRow(0); //index starts at 0, going to the first row.

        //Go to first cell on that first row and print
        Cell cell1 = row1.getCell(0);//index starts at 0, reading the first cell data that is on the first row.
        System.out.println("cell1 = " + cell1);

        //Go to second cell on that first row and print
        Cell cell2 = row1.getCell(1);
        System.out.println("cell2 = " + cell2);

        //Go to 2nd row first cell  and assert if the data equal to the USA
        String r2c1 = sheet1.getRow(1).getCell(0).toString();
        Assert.assertEquals("USA", r2c1);

        //Go to 3rd row 2nd cell-chain the row and cell
        String r3c2 = sheet1.getRow(2).getCell(1).toString();
        System.out.println("r3c2 = " + r3c2);

        //Find the number of row
        int numOfRow = sheet1.getLastRowNum()+1;
        System.out.println("numOfRow = " + numOfRow);

        //Find the number of used row
        int numberOfData = sheet1.getPhysicalNumberOfRows();
        System.out.println("numberOfData = " + numberOfData);

        //Print country, capital key value pairs as map object
        Map<String, String> countryCapitals = new HashMap<>();

        for (int rowNum = 1; rowNum<numOfRow; rowNum++) {
            String country = sheet1.getRow(rowNum).getCell(0).toString();
            String capital = sheet1.getRow(rowNum).getCell(1).toString();
            countryCapitals.put(country, capital);
        }
        System.out.println("countryCapitals = " + countryCapitals);

    }
}
