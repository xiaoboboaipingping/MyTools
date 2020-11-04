package com.tools.study.dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jUtils {
	public static Document load(String filename) {  
	    Document document = null;  
	    try {  
	        SAXReader saxReader = new SAXReader();  
	        document = saxReader.read(new File(filename)); // ��ȡXML�ļ�,���document����  
	    } catch (Exception ex) {  
	        ex.printStackTrace();  
	    }  
	    return document;  
	}  
	
	public static void main(String[] args) {
		Document doc = load("d://test1//data.xml"); 
		Element root = doc.getRootElement(); 
		for (Iterator ie = root.elementIterator(); ie.hasNext();) {
	        System.out.println("======");
	        Element element = (Element) ie.next();
	        System.out.println(element.getName());
	        // ö������
            for (Iterator ia = element.attributeIterator(); ia.hasNext();) {
               Attribute attribute = (Attribute) ia.next();
               System.out.println(attribute.getName() + ":"
                      + attribute.getData());
            }
            
         // ö�ٵ�ǰ�ڵ��������ӽڵ�
            for (Iterator ieson = element.elementIterator(); ieson.hasNext();) {
               Element elementSon = (Element) ieson.next();
               System.out.println(elementSon.getName() + ":"+ elementSon.getText());
            }
	    }
	}
	
	public static String test(){
		return "haha";
	}
}
