package com.xl.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Component;

public class TestWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWindow frame = new TestWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox);
		
		Box box_h = Box.createHorizontalBox();
		verticalBox.add(box_h);
		
		JButton btnNewButton = new JButton("New button");
		box_h.add(btnNewButton);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		box_h.add(verticalStrut);
		
		JButton btnNewButton_1 = new JButton("New button");
		box_h.add(btnNewButton_1);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		JButton btnNewButton_2 = new JButton("New button");
		horizontalBox.add(btnNewButton_2);
		
		Component verticalGlue = Box.createVerticalGlue();
		horizontalBox.add(verticalGlue);
		
		JButton btnNewButton_3 = new JButton("New button");
		horizontalBox.add(btnNewButton_3);
	}

}
