package com.tools.json;

import org.json.JSONObject;
import org.json.XML;

import net.sf.json.xml.XMLSerializer;

public class JsonControl {
	public static String xmlTOJson(String xml){
		 /* �ڶ��ַ�����ʹ��json-lib�ṩ�ķ��� */
        //���� XMLSerializer����
        XMLSerializer xmlSerializer = new XMLSerializer();
        //��xmlתΪjson��ע�������Ԫ�ص����ԣ�����json���keyǰ��һ��@��ʶ��
        String result = xmlSerializer.read(xml).toString();
        //���json����
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
                "<kpzdbs>��Ʊ�ն˱�ʶ</kpzdbs>" +
                "<fplxdm>��Ʊ���ʹ���</fplxdm>" +
                "<fpdm>��Ʊ����</fpdm>" +
                "<fphm>��Ʊ����</fphm>" +
                "<dylx>��ӡ����</dylx>" +
                "<dyfs>��ӡ��ʽ</dyfs>" +
                "<printername>��ӡ������</printername>" +
                "</body>" +
                "</business>";
		System.out.println("ת��ǰ��xml�ǣ�"+xml);
		String json = xmlTOJson(xml);
		System.out.println("ת�����json��:"+json);
		
		String xmlZh = jsonToXml(json);
		System.out.println("�ٴ�ת���ص�xml�ǣ�"+xmlZh);
		
	}
}
