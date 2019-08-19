import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.UIManager;

import com.xl.util.ClipBoard;
import com.xl.util.UIUtil;
import com.xl.util.XmlToJson;
import com.xl.window.JSONToCodeWindow;


public class JsonFormatMain {

	
	public static void main(String[] args) {
		UIUtil.setWindowsStyle();//设置windows风格
	JSONToCodeWindow	 window= new JSONToCodeWindow();
		window.setVisible(true);
		File file = null;
		String type=null;
		File input=null;
		File output=null;
		String coding = "UTF-8";
		
		if(args.length>0){
			//获取类型
			
			//获取输入文件
			
			//获取输出文件
			for(int i=0;i<args.length-1;i++){
				String item = args[i];
				switch (item) {
				case "-t":
					type = args[i+1];
					break;
				case "-f":
					file = new File(args[i+1]);
					break;
				case "-i":
					
						input = (new File(args[i+1]));
					
					break;
				case "-o":
					
						output = new File(args[i+1]);
					
					
					break;
				case "-coding":
					coding = args[i+1];
					break;

				default:
					break;
				}
			}
			//
			if(type==null){
				System.out.println("type unknown,please input -t.");
			}
			//检测是否已输入
			else if(input==null){
				System.out.println("file unknowm,please input -i.");
			}
			
			if(output==null){
//				System.out.println("input unknoen,please output -o.");
				output =new File( input.getParentFile(),input.getName()+".json");
			}
			
			switch (type) {
			case "xmlToJson":
				String text;
				try {
					text = readText(input, coding);
					XmlToJson xmlToJson = new XmlToJson(text);
//					ClipBoard.setText(xmlToJson.check());
					saveText(output, xmlToJson.check(coding), coding);
//					System.exit(0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				break;

			default:
				break;
			}
		}
	}
	
	
	
	
	//写入文本
	
	public static void saveText(File file,String text,String coding) throws UnsupportedEncodingException, IOException{
		  FileOutputStream outStream = new FileOutputStream(file);
          outStream.write(text.toString().getBytes(coding));
	}
	
	
	//读取文本
	public static String readText(File file,String coding) throws IOException {
		   FileInputStream input = new FileInputStream(file);
           byte[] buf = new byte[input.available()];
           input.read(buf);
           input.close();
           return new String(buf,coding);
	}
	
	
	
	
	
	
	
}
