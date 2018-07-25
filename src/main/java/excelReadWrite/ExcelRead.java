package excelReadWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead{
	public static void main(String[] args) {
		
//	
//	 try{
//         FileInputStream file = new FileInputStream(new File("C:\\Users\\prasad\\Desktop\\Student.xlsx"));
//
//         //Create Workbook instance holding reference to .xlsx file
//         XSSFWorkbook workbook = new XSSFWorkbook(file);
//
//         //Get first/desired sheet from the workbook
//         XSSFSheet sheet = workbook.getSheetAt(0);
//
//         //Iterate through each rows one by one
//         Iterator<Row> rowIterator = sheet.iterator();
//         while (rowIterator.hasNext())
//         {
//             Row row = rowIterator.next();
//             //For each row, iterate through all the columns
//             Iterator<Cell> cellIterator = row.cellIterator();
//              
//             while (cellIterator.hasNext())
//             {
//                 Cell cell = cellIterator.next();
//                 //Check the cell type and format accordingly
//                 switch (cell.getCellType())
//                 {
//                     case Cell.CELL_TYPE_NUMERIC:
//                         System.out.print(cell.getNumericCellValue()+"  ");
//                         break;
//                     case Cell.CELL_TYPE_STRING:
//                         System.out.print(cell.getStringCellValue()+"  " );
//                         break;
//                 }
//             }
//             System.out.println("");
//         }
//         file.close();
//     }
//     catch (Exception e)
//     {
//         e.printStackTrace();
//     }
		
		readDatafromExcel();
	
	}

public static Object[][] readDatafromExcel() {
	Object [][] testData= new Object[6][3];
	int rowCount=0;
	int cellCount=0;
	XSSFWorkbook workbook=null;
	try{
		workbook=new XSSFWorkbook("C:\\Users\\prasad\\Desktop\\Student.xlsx");
		XSSFSheet sheet = workbook.getSheet("StudentSheet2");
		Iterator<Row> rows=sheet.iterator();
		boolean flag=true;
		while(rows.hasNext()){
			Row singleRow=rows.next();
			if(flag){
				flag=false;
				continue;
			}
			System.out.println("\n");
			Iterator<Cell> cells = singleRow.iterator();
			while(cells.hasNext()){
				Cell singleCell=cells.next();
				if(singleCell.getCellType()==0){
					System.out.println(singleCell.getNumericCellValue()+"|");
				}
				if(singleCell.getCellType()==1){
				String cellValue= singleCell.getStringCellValue().equals("NA")?null:singleCell.getStringCellValue();
				testData[rowCount][cellCount]=cellValue;
				cellCount++;
				}
			}
			rowCount++;
			cellCount=0;
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
//	finally{
//		try {
//			if(workbook!=null)
////				workbook.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	return testData;
	
}
}