package com.swing.study;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * 下拉组合框
 * @author xiaobobo
 *
 */
public class JComboBoxExample extends JFrame {
	JComboBox comboBox1,comboBox2;
	String cityNames[] = {"北京","上海","重庆","南京","武汉","杭州"};
	public JComboBoxExample() {
		// TODO Auto-generated constructor stub
		super("组合框");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		comboBox1 = new JComboBox(cityNames);
		comboBox1.setSelectedIndex(3);
		comboBox1.setEditable(false);
		comboBox2 = new JComboBox(cityNames);
		comboBox2.setSelectedItem(cityNames[1]);
		comboBox2.addItem(new String("长沙"));
		comboBox2.setEditable(true);
		container.add(comboBox1);
		container.add(comboBox2);
		pack();
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		JComboBoxExample jcbe = new JComboBoxExample();
		jcbe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
