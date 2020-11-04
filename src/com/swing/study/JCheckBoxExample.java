package com.swing.study;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

/**
 * ¸´Ñ¡¿ò
 * @author xiaobobo
 *
 */
public class JCheckBoxExample extends JFrame {
	public JCheckBoxExample() {
		// TODO Auto-generated constructor stub
		super("¸´Ñ¡¿ò");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		Favorite f = new Favorite();
		container.add(f);
		pack();
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		JCheckBoxExample jcbe = new JCheckBoxExample();
		jcbe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
