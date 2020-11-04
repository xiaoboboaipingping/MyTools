package com.swing.study;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Favorite extends JPanel {
	JCheckBox sport,computer,music,read;
	
	public Favorite() {
		// TODO Auto-generated constructor stub
		sport = new JCheckBox("运动");
		computer = new JCheckBox("计算机");
		music = new JCheckBox("音乐");
		read = new JCheckBox("读书");
		add(new JLabel("爱好"));
		add(sport);
		add(computer);
		add(music);
		add(read);
		sport.setSelected(false);
		computer.setSelected(false);
		music.setSelected(false);
		read.setSelected(false);
	}
}
