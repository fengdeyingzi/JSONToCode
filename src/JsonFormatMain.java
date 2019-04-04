import javax.swing.UIManager;


import com.xl.util.UIUtil;
import com.xl.window.JSONToCodeWindow;


public class JsonFormatMain {

	
	public static void main(String[] args) {
		UIUtil.setWindowsStyle();//设置windows风格
	JSONToCodeWindow	 window= new JSONToCodeWindow();
		window.setVisible(true);
	}
}
