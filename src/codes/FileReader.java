package codes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileReader {
	
	public Object[][] fetchdata(String filepath) throws FileNotFoundException{
		Object[][] data=null;
		System.out.println("File to be read is : " + filepath);
		File dataFile=new File(filepath);
		FileInputStream f = new FileInputStream(dataFile);
		try {
			XSSFWorkbook wb = new XSSFWorkbook(f);
			
			XSSFSheet sheet = wb.getSheetAt(0);
		
			int rows = sheet.getLastRowNum();
			System.out.println("rows in sheet = "+rows);
			data = new Object[rows+1][2];
			for(int i=0; i<= rows; i++){
				String username1 = sheet.getRow(i).getCell(0).getStringCellValue();
				String password1 = sheet.getRow(i).getCell(1).getStringCellValue();
				data[i][0] = username1;
				data[i][1] = password1;
				System.out.println("Username is : " + data[i][0]);
				System.out.println("Password is : " + data[i][1]);
			}
			
			wb.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Read excel file
		
		return data;
		
	}
}
