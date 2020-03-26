package excel_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getexcel {
	public static String[][] testdata;//array to store the data
	public static int rownum;
	public static String filename="src\\test\\resources\\testdata\\open_cart.xlsx";
	//method for getting the data from excel..
   public static void getExcel(String sheet){
	   testdata= new String[4][6];
	  	   File f= new File(filename);
	  	   for(int rownum=1;rownum<=3;rownum++){
	   try {
		FileInputStream fis= new FileInputStream(f);
		XSSFWorkbook w=new XSSFWorkbook(fis);
		XSSFSheet s=w.getSheet(sheet);
		XSSFRow r=s.getRow(rownum);
		for(int col=0;col<=5;col++){
		XSSFCell c=r.getCell(col);
		testdata[rownum][col]=c.getStringCellValue();//storing the data
		System.out.println(testdata[rownum][col]);
		}
	    } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  	   }
	  	   
   
	  
   }
//   public static void main(String[] args) {
//	   getexcel g= new getexcel(); // for checking whether the data is displaying or not.....
//	   g.getExcel("Sheet1");	   }
//   
}
