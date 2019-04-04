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
import com.xl.util.ParameterToCode;

public class JSONToCodeWindow extends JFrame{

	JTextArea editArea;
	JTextField textField;
	JButton button;
	JButton button2;
	JButton button_format;
	JScrollPane scrollPane;
	TextWindow textWindow;
	public JSONToCodeWindow(){
		int screen_w,screen_h;
		textWindow=  new TextWindow();
		int array[]= new int[]{1,21};
		System.out.println("数组"+array.toString());
		
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
		 
		 button= new JButton("json转代码");
		//设置对齐方式 不然会出问题
		button.setAlignmentX((float) 0.5);
		
		button2= new JButton("参数转代码");
		button2.setAlignmentX(0.5f);
		button_format= new JButton("json格式化");
		button_format.setAlignmentX(0.5f);
		
		 textField.setPreferredSize(new Dimension(640, 20));
		 textField.setMaximumSize(new Dimension(640, 20));
		 box_v.add(textField);
		box_v.add(scrollPane);
		Box box_h= Box.createHorizontalBox();
		box_h.add(button);
		box_h.add(Box.createRigidArea(new Dimension(10, 20)));
		box_h.add(button2);
		box_h.add(Box.createRigidArea(new Dimension(10, 20)));
		box_h.add(button_format);
		box_v.add(box_h);
		box_h.setPreferredSize(new Dimension(640, 30));
		mainJPanel.add(box_v);
		//设置最大宽高 用于适应布局
		//button.setPreferredSize(new Dimension(400, 60));
		button.setMaximumSize(new Dimension(screen_w,60));
		button2.setMaximumSize(new Dimension(screen_w, 60));
		button_format.setMaximumSize(new Dimension(screen_w, 60));
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
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String textString=editArea.getText().toString();
				String jsonNameString= textField.getText();
				
				textWindow.setText(ParameterToCode.toCode(jsonNameString, textString));
				textWindow.setVisible(true);
			}
		});
		button_format.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String jsonFormatText= JsonFormat.formatJson(editArea.getText());
				editArea.setText(jsonFormatText);
			}
		});
		setSize(new Dimension(640, 480));
		setLocation((screen_w-640)/2, (screen_h-480)/2);
		textWindow.setLocation((screen_w-640)/2, (screen_h-480)/2);
		setTitle("json转代码v1.1 - 风的影子 - 2019.3.29");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setVisible(true);
	}
}
