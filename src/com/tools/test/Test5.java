package com.tools.test;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;



//import net.sf.json.xml.XMLSerializer;

//import com.alibaba.fastjson.JSONObject;
//import org.jdom2.Element;
//import org.jdom2.JDOMException;
//import org.jdom2.input.SAXBuilder;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.LinkedList;
//import java.util.List;


public class Test5 {
	public static void main(String[] args) throws DocumentException{
		String xml ="<?xml version=\"1.0\" encoding=\"GBK\" standalone=\"no\"?>"
				+"<Root>"
				+"<businessId>6005</businessId>"
				+"<bankCode>0</bankCode>"
				+"<authorCode></authorCode>"
				+"<reqBody>"
				+"<cards>"
				+"<cardNo>8416102497110598</cardNo>"
				+"<termType>0</termType>"
				+"<products>"
				+"<productId>1162451</productId>"
				+"<productType></productType>"
				+"<duration>12</duration>"
				+"<pay>288.00</pay>"
				+"</products>"
				+"</cards>"
				+"<total>288.00</total>"
				+"</reqBody>"
				+"</Root>";

		
		
		
		Document doc = DocumentHelper.parseText(xml);
		Element root = doc.getRootElement();

       // System.out.println("根节点："+root.getName());
        String retMsg = "{\r\n";
      //获得根元素下的孩子元素
       List<Element> eList = root.elements();
       //遍历子元素
       for(Element element:eList) {
    	   String eleName = element.getName();
    	   String elevalue = element.getTextTrim();
           //System.out.println(eleName+ "   "+elevalue);
    	   if(eleName.equals("reqBody")){
    		   retMsg = retMsg + "\""+eleName+"\" : {\r\n";
    	   }else{
    		   retMsg = retMsg + "\""+eleName+"\" : " + "\""+elevalue+"\",\r\n";
    	   }
    	   
           if(eleName.equals("reqBody")){
        	   List<Element> eList2 = element.elements();
        	   for (Element element2:eList2){
            	   String eleName2 = element2.getName();
            	   String eleValue2 = element2.getTextTrim();
            	   if(eleName2.equals("cards")){
            		   retMsg = retMsg +"\""+eleName2+"\"" + " : [\r\n{\r\n";
            	   }else{
            		   retMsg = retMsg + "\""+eleName2+"\" : " + "\""+eleValue2+"\"\r\n}";
            	   }
                   if(eleName2.equals("cards")){
                	   List<Element> eList3 = element2.elements();
                	   for (Element element3:eList3){
                		   String eleName3 = element3.getName();
                		   String eleValue3 = element3.getTextTrim();
                		   if(eleName3.equals("products")){
                			   retMsg = retMsg +"\""+eleName3+"\"" + " : [\r\n{\r\n";
                		   }else{
                			   retMsg = retMsg + "\""+eleName3+"\" : " + "\""+eleValue3+"\",\r\n";
                		   }
                		   if(eleName3.equals("products")){
                			   List<Element> eList4 = element3.elements();
                			   for (Element element4:eList4){
                				   String eleName4 = element4.getName();
                				   String eleValue4 = element4.getTextTrim();
                				   if(eleName4.equals("pay")){
                					   retMsg = retMsg + "\""+eleName4+"\" : " + "\""+eleValue4+"\"\r\n";
                					   retMsg = retMsg +"}\r\n]\r\n}\r\n],\r\n";
                				   }else{
                					   retMsg = retMsg + "\""+eleName4+"\" : " + "\""+eleValue4+"\",\r\n";
                				   }
                        		   
                			   }
                    	   }
                	   }                	   
                	   
                   }
        	   }
               
           }
       }
       
       retMsg = retMsg + "\r\n}";
       
       System.out.println(retMsg);

		
		//xml = xml.replace("<Root>", "").replace("</Root>", "");
 
//        /* 第一种方法，使用JSON-JAVA提供的方法 */
//        //将xml转为json
//        JSONObject jsonObject = XML.toJSONObject(xml);
//        //设置缩进
//        String json = jsonObject.toString(4);
//        //输出格式化后的json
//        //System.out.println(json);
//        String retMsg = "{\r\n";
//        
//        for(String str:jsonObject.keySet()){
//        	if(jsonObject.get(str) instanceof JSONObject){
//        		System.out.println(str + ":" +jsonObject.get(str));
//        		JSONObject json2 = (JSONObject)jsonObject.get(str);
//        		for(String str1:json2.keySet()){
//        			System.out.println(str1 + ":" +json2.get(str1));
//        			JSONObject json3 = (JSONObject)json2.get(str1);
//        			if(json2.get(str1) instanceof JSONObject){
//        				for(String str2:json3.keySet()){
//        					System.out.println(str2 + ":" +json3.get(str2));
//        				}
//        			}
//        		}
//        		retMsg = retMsg + "\""+str+"\"" + ":" + "\""+jsonObject.get(str)+"\"" + ",\r\n";
//        	}else{
//        		//System.out.println(str + ":" +jsonObject.get(str));
//        		retMsg = retMsg + "\""+str+"\"" + ":" + "\""+jsonObject.get(str)+"\"" + ",\r\n";
//        	}
//        }
//        
//        retMsg = retMsg +"\r\n}";
        
        //System.out.println(retMsg);
        
//        JSONObject businessIdJsonObject = jsonObject("businessId");
//        System.out.println("businessID=="+businessIdJsonObject.toString(4));
//        
//        JSONObject payUnitsJsonObject = jsonObject.getJSONObject("reqBody");
//        JSONObject payUnitJsonObject = null;
//        JSONArray payUnitJsonArray = null;
//        Object payUnitObject = payUnitsJsonObject.get("cards");
//        payUnitJsonObject = (JSONObject)payUnitObject;
//        System.out.println(payUnitJsonObject.toString(4));
//        if(payUnitObject instanceof JSONObject){
//        	payUnitJsonObject = (JSONObject)payUnitObject;
//        	System.out.println("object");
//        }else if(payUnitObject instanceof JSONArray){
//        	payUnitJsonArray = (JSONArray)payUnitObject;
//        	System.out.println("array");
//        }
        //payUnitJsonArray = (JSONArray)payUnitObject;
        
        //System.out.println(payUnitJsonArray.toString(4));
		
//		JSONObject json=xml2JSON(xml.getBytes());
//        System.out.println(json.toJSONString());
		//xml2json(xml);
	}
	
//	public static String xml2json(String xml) {
//			//创建XMLSerializer对象
//			XMLSerializer xmlSerializer = new XMLSerializer();
//			//将xml转化为json
//			String result = xmlSerializer.read(xml).toString();
//			System.out.println(result);
//			return result;
//	}
	
//	public static JSONObject xml2JSON(byte[] xml) throws JDOMException, IOException {
//        JSONObject json = new JSONObject();
//        InputStream is = new ByteArrayInputStream(xml);
//        SAXBuilder sb = new SAXBuilder();
//        org.jdom2.Document doc = sb.build(is);
//        Element root = doc.getRootElement();
//        json.put(root.getName(), iterateElement(root));
//        return json;
//    }
//
//    private static JSONObject iterateElement(Element element) {
//        List node = element.getChildren();
//        Element et = null;
//        JSONObject obj = new JSONObject();
//        List list = null;
//        for (int i = 0; i < node.size(); i++) {
//            list = new LinkedList();
//            et = (Element) node.get(i);
//            if (et.getTextTrim().equals("")) {
//                if (et.getChildren().size() == 0)
//                    continue;
//                if (obj.containsKey(et.getName())) {
//                    list = (List) obj.get(et.getName());
//                }
//                list.add(iterateElement(et));
//                obj.put(et.getName(), list);
//            } else {
//                if (obj.containsKey(et.getName())) {
//                    list = (List) obj.get(et.getName());
//                }
//                list.add(et.getTextTrim());
//                obj.put(et.getName(), list);
//            }
//        }
//        return obj;
//    }
	
}
