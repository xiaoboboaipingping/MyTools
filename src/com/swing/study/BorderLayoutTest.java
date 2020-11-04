package com.swing.study;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * �߽粼��ʾ��
 */
public class BorderLayoutTest {
	public BorderLayoutTest() {
		// TODO Auto-generated constructor stub
		JFrame jf = new JFrame();
		Container contentPane = jf.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(new JButton("��"),BorderLayout.EAST);
		contentPane.add(new JButton("��"),BorderLayout.WEST);
		contentPane.add(new JButton("��"),BorderLayout.SOUTH);
		contentPane.add(new JButton("��"),BorderLayout.NORTH);
		contentPane.add(new JLabel("��",JLabel.CENTER),BorderLayout.CENTER);
		
		jf.setTitle("BorderLaout���ֹ�����ʾ��");
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
