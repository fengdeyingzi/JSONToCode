package com.xl.window;

import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.xl.util.JsonFormat;
import com.xl.util.JsonToCode;

public class JSONToCodeWindow extends JFrame{

	JTextArea editArea;
	JTextField textField;
	JButton button;
	JScrollPane scrollPane;
	TextWindow textWindow;
	public JSONToCodeWindow(){
		int screen_w,screen_h;
		textWindow=  new TextWindow();
		
		Toolkit toolkit= Toolkit.getDefaultToolkit();
		screen_w= (int) toolkit.getScreenSize().getWidth();
		screen_h = (int) toolkit.getScreenSize().getHeight();
		JPanel mainJPanel= new JPanel();
		setContentPane(mainJPanel);
		setLayout(new BoxLayout(mainJPanel, BoxLayout.Y_AXIS));
		Box box_v= Box.createVerticalBox();
		getContentPane().add(box_v);
		mainJPanel.setSize(640, 480);
		//
		 editArea= new JTextArea();
		 editArea.setColumns(20);
		 editArea.setRows(10);
		 textField= new JTextField();
		 scrollPane= new JScrollPane(editArea);
		 //scrollPane.add(editArea);
		 
		 button= new JButton("开始转换");
		 textField.setPreferredSize(new Dimension(640, 20));
		 textField.setMaximumSize(new Dimension(640, 20));
		 box_v.add(textField);
		box_v.add(scrollPane);
		box_v.add(button);
		//设置对齐方式 不然会出问题
		button.setAlignmentX((float) 0.5);
		mainJPanel.add(box_v);
		//设置最大宽高 用于适应布局
		button.setMaximumSize(new Dimension(screen_w,20));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String textString=editArea.getText().toString();
				String jsonNameString= textField.getText();
				
				JsonToCode jsonToCode= new JsonToCode();
				if(jsonNameString.length()!=0){
					jsonToCode.setJsonObjectName(jsonNameString);
				}
				jsonToCode.setJson(textString);
				
				textWindow.setText(jsonToCode.getCode());
				textWindow.setVisible(true);
				
				//editArea.setText(textString);
			}
		});
		setSize(new Dimension(640, 480));
		setLocation((screen_w-640)/2, (screen_h-480)/2);
		textWindow.setLocation((screen_w-640)/2, (screen_h-480)/2);
		setTitle("json转代码v1.0 - 风的影子 - 2019.3.29");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setVisible(true);
	}
}
