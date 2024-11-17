package Practice;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateExcelData {

    public static void main(String[] args) throws IOException {

        FileOutputStream fos= new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\Myfile.xlsx");
        XSSFWorkbook workbook= new XSSFWorkbook();
        XSSFSheet sh=workbook.createSheet("Data");

        XSSFRow row1=sh.createRow(0);
        row1.createCell(0).setCellValue("john");
        row1.createCell(1).setCellValue("12");
        row1.createCell(2).setCellValue("ineligible");

        XSSFRow row2=sh.createRow(1);
        row2.createCell(0).setCellValue("Ken");
        row2.createCell(1).setCellValue("19");
        row2.createCell(2).setCellValue("eligible");
//        create in a specific row and cell, say 6th row 4th cell
        XSSFRow row6=sh.createRow(5);
        row6.createCell(5).setCellValue("love");

        workbook.write(fos);
        workbook.close();
        fos.close();
    }
}
