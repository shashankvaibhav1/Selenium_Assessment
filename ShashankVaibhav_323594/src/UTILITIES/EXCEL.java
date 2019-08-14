/*
 * Name: Shashank Vaibhav
 * Emp.Id: 323594
 */
package UTILITIES;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EXCEL {
	ArrayList<ArrayList> al;
	
	public ArrayList read_excel() {
		al = new ArrayList<ArrayList>();
		try {
			File f = new File("abc.xlsx");
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheetAt(0);
			for(int i=2; i<=sh.getLastRowNum(); i++) {
				XSSFRow row = sh.getRow(i);
				ArrayList ex = new ArrayList();
				ex.add(row.getCell(0));
				ex.add(row.getCell(1));
				ex.add(row.getCell(2));
				al.add(ex);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	public ArrayList verify_excel() {
		al = new ArrayList<ArrayList>();
		try {
			File f = new File("abc.xlsx");
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheetAt(1);
			for(int i=2; i<=sh.getLastRowNum(); i++) {
				XSSFRow row = sh.getRow(i);
				ArrayList ex = new ArrayList();
				ex.add(row.getCell(0));
				ex.add(row.getCell(1));
				al.add(ex);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
}
