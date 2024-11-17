package excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelData {

    public static void main(String[] args) throws IOException {
//        excel file ---WorkBook----Sheet---Row---Cell
FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\TestData\\test data.xlsx");
        XSSFWorkbook workbook= new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("Sheet1");

        int totalRows = sheet.getLastRowNum();
        int totalCells=sheet.getRow(0).getLastCellNum();
        System.out.println(totalRows);
        System.out.println(totalCells);

        for(int r=0;r<totalRows;r++)
        {
            XSSFRow currentRow=sheet.getRow(r);

        for(int c=0;c<totalCells;c++)
        {
            XSSFCell cell=currentRow.getCell(c);
            String str=cell.toString();
            System.out.print(str+"\t");
        }
            System.out.println();
        }
        workbook.close();
        fis.close();
    }
}
