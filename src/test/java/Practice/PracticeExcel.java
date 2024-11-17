package Practice;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class PracticeExcel {

//    excel file --- workbook --- sheet --- row---cell
public static void main(String[] args) throws IOException {
        FileInputStream fis2= new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Myfile.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis2);
        XSSFSheet sh=workbook.getSheet("Data");
        int totalRows=sh.getLastRowNum();
        int totalcells=sh.getRow(0).getLastCellNum();

        for(int i=0;i<=totalRows;i++)
        {
            XSSFRow getRow=sh.getRow(i);
            for(int j=0;j<totalcells;j++)
            {
                XSSFCell getCell=getRow.getCell(j);
                String str=getCell.toString();
                System.out.print(str+"\t");
            }
            System.out.println();
        }
    System.out.println("Successfully read test data from excel sheet");
workbook.close();
        fis2.close();

    }


}
