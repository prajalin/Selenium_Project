package qedge_march11;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAndWriteData2 {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi = new FileInputStream("C:/Test/Dummy-2.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet ws = wb.getSheet("Login");
		Row rownum = ws.getRow(0);
		System.out.println(rownum);
		int rc = ws.getLastRowNum();
		int cc = rownum.getLastCellNum();
		System.out.println(rc+"    "+ cc);
		for(int i=1;i<=rc;i++)
		{
			if(wb.getSheet("Login").getRow(i).getCell(1).getCellType()==Cell.CELL_TYPE_NUMERIC)
			{
				String username = ws.getRow(i).getCell(0).getStringCellValue();
				int celldata = (int)ws.getRow(i).getCell(1).getNumericCellValue();
				String password = String.valueOf(celldata);
				System.out.println(username+"   "+ password);
				ws.getRow(i).createCell(2).setCellValue("pass");
			}
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("C:/Test/Results-2.xlsx");
		wb.write(fo);
		fi.close();
		wb.close();
		

	}

}
