package com.swing.study;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * 边界布局示例
 */
public class BorderLayoutTest {
	public BorderLayoutTest() {
		// TODO Auto-generated constructor stub
		JFrame jf = new JFrame();
		Container contentPane = jf.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(new JButton("东"),BorderLayout.EAST);
		contentPane.add(new JButton("西"),BorderLayout.WEST);
		contentPane.add(new JButton("南"),BorderLayout.SOUTH);
		contentPane.add(new JButton("北"),BorderLayout.NORTH);
		contentPane.add(new JLabel("中",JLabel.CENTER),BorderLayout.CENTER);
		
		jf.setTitle("BorderLaout布局管理器示例");
		jf.pack();
		jf.setVisible(true);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	 
	public static void main(String[] args) {
		new BorderLayoutTest();
	}
}
