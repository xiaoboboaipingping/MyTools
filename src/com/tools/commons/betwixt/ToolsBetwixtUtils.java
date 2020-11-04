package com.tools.commons.betwixt;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.apache.commons.betwixt.io.BeanReader;
import org.apache.commons.betwixt.io.BeanWriter;
import org.xml.sax.SAXException;

import com.tools.commons.beanutils.PersonDAO;

public class ToolsBetwixtUtils {
	public static void main(String[] args) throws IOException, SAXException, IntrospectionException {
		//1�� ��JavaBeanת��ΪXML
        // �ȴ���һ��StringWriter�����ǽ�����д��Ϊһ���ַ���         
        StringWriter outputWriter = new StringWriter();  
        // Betwixt����������ǽ�Beanд��Ϊһ��Ƭ��  
        // �������Ҫ��������XML���ݣ�����Ӧ��д��ͷ��ʽ  
        outputWriter.write("<?xml version=��1.0�� encoding=��UTF-8�� ?>\n");  
        // ����һ��BeanWriter���佫д�뵽����Ԥ����stream��  
        BeanWriter beanWriter = new BeanWriter(outputWriter);  
        // ����betwixt  
        // ����������ο�java docs �����µ��ĵ�  
        beanWriter.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);  
        beanWriter.getBindingConfiguration().setMapIDs(false);  
        beanWriter.enablePrettyPrint();  
        // �������ط�������XML�ĸ��ڵ�����Betwixt���Լ��²���ʲô  
        // ���������ǽ�����Bean����Ϊ���ڵ��  
        beanWriter.write("person", new PersonDAO("John Smith", 21));  
        //������  
        System.out.println(outputWriter.toString());  
        // Betwixtд����Ƭ�϶�����һ���ĵ������Բ�Ҫ�Զ��Ĺرյ�writers����streams��  
        //�����������һ�����ӣ��������������飬���Կ��Թص�  
        outputWriter.close(); 	
        
        //2�� ��XMLת��ΪJavaBean 
        // �ȴ���һ��XML���������������Ϊ���ӣ���������Ӳ������һ��XML����  
//        StringReader xmlReader = new StringReader(  
//        "<?xml version='1.0' encoding='UTF-8' ?><person><age>25</age><name>James Smith</name></person>");  
//        //����BeanReader  
//        BeanReader beanReader  = new BeanReader();  
//        //����reader  
//        beanReader.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);  
//        beanReader.getBindingConfiguration().setMapIDs(false);  
//        //ע��beans���Ա�betwixt֪��XML��Ҫ��ת��Ϊһ��ʲôBean  
//        beanReader.registerBeanClass("person", PersonDAO.class);  
//        //�������Ƕ�XML���н���  
//        PersonDAO person = (PersonDAO) beanReader.parse(xmlReader);  
//        //������  
//        System.out.println(person);  
	}
}
