package com.tools.json;

import org.json.JSONObject;
import org.json.XML;

import net.sf.json.xml.XMLSerializer;

public class JsonControl {
	public static String xmlTOJson(String xml){
		 /* 第二种方法，使用json-lib提供的方法 */
        //创建 XMLSerializer对象
        XMLSerializer xmlSerializer = new XMLSerializer();
        //将xml转为json（注：如果是元素的属性，会在json里的key前加一个@标识）
        String result = xmlSerializer.read(xml).toString();
        //输出json内容
        return result;
	}
	
	public static String jsonToXml(String json){
		JSONObject jsonObject = new JSONObject(json);
        String xml = XML.toString(jsonObject);
        return xml;
	}
	
	public static void main(String[] args) {
		String xml = "<?xml version=\"1.0\" encoding=\"gbk\"?>" +
                "<business>" +
                "<body >" +
                "<kpzdbs>开票终端标识</kpzdbs>" +
                "<fplxdm>发票类型代码</fplxdm>" +
                "<fpdm>发票代码</fpdm>" +
                "<fphm>发票号码</fphm>" +
                "<dylx>打印类型</dylx>" +
                "<dyfs>打印方式</dyfs>" +
                "<printername>打印机名称</printername>" +
                "</body>" +
                "</business>";
		System.out.println("转换前的xml是："+xml);
		String json = xmlTOJson(xml);
		System.out.println("转换后的json是:"+json);
		
		String xmlZh = jsonToXml(json);
		System.out.println("再次转换回的xml是："+xmlZh);
		
	}
}
