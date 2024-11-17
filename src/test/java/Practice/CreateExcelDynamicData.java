package Practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CreateExcelDynamicData {
    public static void main(String[] args) throws IOException {

        FileOutputStream fos1= new FileOutputStream(System.getProperty("user.dir")+"//TestData//file_dynamic.xlsx");

        XSSFWorkbook wb= new XSSFWorkbook();
       XSSFSheet sh= wb.createSheet("data");
       Scanner sc= new Scanner(System.in);
       System.out.println("Enter no of rows: ");
       int rowCount=sc.nextInt();

        System.out.println("Enter no of cells: ");
        int cellCount=sc.nextInt();

        for(int i=0;i<rowCount;i++)
        {
            XSSFRow row=sh.createRow(i);
            for (int j=0;j<cellCount;j++)
            {
                XSSFCell cell=row.createCell(j);
                cell.setCellValue(sc.next());
            }
        }

        wb.write(fos1);
        wb.close();
        fos1.close();
        System.out.println("File is created");
    }

}