package com.swing.study;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 面板示例
 * @author xiaobobo
 *
 */
public class JPanelExample extends JFrame {
	JButton[] buttons;
	JPanel panel1;
	CustomPanel panel2;
	
	public JPanelExample() {
		// TODO Auto-generated constructor stub
		super("面板示例");
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		panel1 = new JPanel(new FlowLayout());
		buttons = new JButton[4];
		for(int i=0;i<buttons.length;i++){
			buttons[i] = new JButton("按钮" + (i + 1));
			panel1.add(buttons[i]);
		}
		panel2 = new CustomPanel();
		container.add(panel1,BorderLayout.NORTH);
		container.add(panel2,BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		JPanelExample jpe = new JPanelExample();
		jpe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
