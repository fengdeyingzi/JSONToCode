import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.xl.util.ExcelUtil;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<StringBuffer> list_xml= new ArrayList<>();
//		list_xml.add(new StringBuffer());
		String key = null;
		//读取excel
		try {
			Workbook work = ExcelUtil.getWorkbook("D://test.xls");
			Sheet sheet = work.getSheet("item");
			for(int iy =1;iy<sheet.getLastRowNum();iy++){
				Row row = sheet.getRow(iy);
				for(int ix = 0;ix<row.getLastCellNum();ix++){
					Cell col = row.getCell(ix);
					if(ix==0)
					key = col.getStringCellValue();
//					System.out.println(col.getStringCellValue());
					if(ix>=1){
						StringBuffer buffer = new StringBuffer();
						buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources xmlns:tools=\"http://schemas.android.com/tools\">\n");
						String value = col.getStringCellValue();
						if(ix>=list_xml.size()){
						list_xml.add(buffer);
					}
						StringBuffer tempbuffer = list_xml.get(ix-1);
						tempbuffer.append("    <string name=\""+key+"\" >"+value+"</string>\n");
					}
					
				}
//				System.out.println("----");
			}
			
			
			
			
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		for(int i=0;i<list_xml.size();i++){
			list_xml.get(i).append("</resources>");
			System.out.println(list_xml.get(i).toString());
			//依次写入文件
			
		}
		
		
		
		
		
		
		
//		String values[][] = {
//				{
//					"第一行",
//					"第二行",
//					"第三行",
//					"第四行",
//				},
//				{
//					"值1",
//					"值2",
//					"值3",
//					"值4"
//				}
//		};
//		String titles[] = {
//				"标题1",
//				"标题2",
//				"标题3",
//				"标题4"
//		};
//		String values2[][] = new String[12][8];
//		
//		HSSFWorkbook work = ExcelUtil.getHSSFWorkbook("测试名字", titles, values, null);
//		System.out.println("初始化成功");
//		FileOutputStream out;
//		try {
//			out = new FileOutputStream(new File("D:\\test.xls"));
//			try {
//				work.write(out);
//				out.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}
	
	

}
