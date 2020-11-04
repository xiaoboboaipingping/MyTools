package com.swing.study;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CustomPanel extends JPanel {
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString("Welcome to Java Shape World", 20, 20);
		g.drawRect(20, 40, 130, 130);
		g.setColor(Color.green);
		g.fillRect(20, 40, 130, 130);
		g.drawOval(160, 40, 100, 100);
		g.setColor(Color.orange);
		g.fillOval(160, 40, 100, 100);
	}
	public Dimension getPreferredSize(){
		return new Dimension(200,200);
	}
}
