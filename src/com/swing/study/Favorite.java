package com.swing.study;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Favorite extends JPanel {
	JCheckBox sport,computer,music,read;
	
	public Favorite() {
		// TODO Auto-generated constructor stub
		sport = new JCheckBox("�˶�");
		computer = new JCheckBox("�����");
		music = new JCheckBox("����");
		read = new JCheckBox("����");
		add(new JLabel("����"));
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
