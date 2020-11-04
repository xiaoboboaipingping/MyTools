package com.tools.commons.configuration;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Configuration {
	public static void main(String[] args) throws ConfigurationException {
		PropertiesConfiguration config = new PropertiesConfiguration("conf/config.ini");
		
		//读取配置文件内容
//		String port = config.getString("Port");
//		System.out.println(port);
		
		//复制文件
//		config.save("config.bak.ini");
		
		//写入配置文件
		config.setProperty("test", "#000000");  
		config.save();
		
		
	}
}
