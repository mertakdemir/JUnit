package tests.ders;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ders4 {

    @Test
    public void readExcel() throws IOException {

        String path = "./src/test/java/resources/Capitals.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("Sheet1");

        Row row = sheet.getRow(0);

        Cell cell = row.getCell(0);
        System.out.println(cell.toString());


        workbook.getSheet("Sheet1").getRow(0).getCell(0);
        int num = sheet.getLastRowNum()+1;

        sheet.getPhysicalNumberOfRows();

        //Print country, capital key value pairs as map object

        Map<String, String> myMap = new HashMap<>();

        for (int i = 0; i<num; i++){
            //workbook.getSheet("Sheet1").getRow(0).getCell(0);
            String country = sheet.getRow(i).getCell(0).toString();
            String capital = sheet.getRow(i).getCell(1).toString();
            myMap.put(country,capital);
        }
        System.out.println(myMap);

    }

    @Test
    public void writeExcel() throws IOException {

        String path = "./src/test/java/resources/Capitals.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("Sheet1");

        Row row = sheet.getRow(0);

        Cell cell = row.createCell(2);

        cell.setCellValue("POPULATION");

        //Create a cell on the 2nd row 3rd cell(index2), and write 150000
        sheet.getRow(1).createCell(2).setCellValue("150000");

        //Create a cell on the 3rd row 3rd cell(index2), and write 250000
        sheet.getRow(2).createCell(2).setCellValue("250000");

        //Create a cell on the 1st row 5th cell(index4), and write 80000
        sheet.getRow(0).createCell(4).setCellValue("80000");


        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

    }
}
