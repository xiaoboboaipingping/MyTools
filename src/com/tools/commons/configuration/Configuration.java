package com.tools.commons.configuration;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Configuration {
	public static void main(String[] args) throws ConfigurationException {
		PropertiesConfiguration config = new PropertiesConfiguration("conf/config.ini");
		
		//��ȡ�����ļ�����
//		String port = config.getString("Port");
//		System.out.println(port);
		
		//�����ļ�
//		config.save("config.bak.ini");
		
		//д�������ļ�
		config.setProperty("test", "#000000");  
		config.save();
		
		
	}
}
