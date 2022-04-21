package qedge_march11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAndWriteData {

	public static void main(String[] args) throws IOException, IllegalStateException, Throwable 
	{
		FileInputStream fi = new FileInputStream("C:/Test/Dummy-1.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet ws = wb.getSheet("Login");
		//get first row
		Row rownum = ws.getRow(0);
		//get no of rows
		int rc = ws.getLastRowNum();
		//get no of cell from rows
		int cc = rownum.getLastCellNum();
		System.out.println(rc +"   "+ cc);
		//get all rows and all cells
		for(int i=1;i<=rc;i++)
		{
			//get all rows first column data
			String username = ws.getRow(i).getCell(0).getStringCellValue();
			String password = ws.getRow(i).getCell(1).getStringCellValue();
			System.out.println(username+"    "+password);
			ws.getRow(i).createCell(2).setCellValue("pass");
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("C:/Test/Results-55.xlsx");
		wb.write(fo);
		fi.close();
		wb.close();
		
		
		
		}

}
