package com.tools.commons.lang;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

public class ToolsCommonsLangUtils {
	public static void main(String[] args) {
		//�ж��Ƿ�Ϊnull
		//System.out.println(StringUtils.isEmpty(null)); 
		
		//�ж��Ƿ���null
		//System.out.println(StringUtils.isNotEmpty(""));
		
		//�ж��Ƿ��ǿ�(����пո񣬻�ȥ���ո��ж�)����null
		//System.out.println(StringUtils.isBlank(null));
		
		//�ж��Ƿ��ǿ�(����пո񣬻�ȥ���ո��ж�)����null
		//System.out.println(StringUtils.isNotBlank(""));
		
		//ȥ�ո�
		//System.out.println(StringUtils.trim("   abc  "));
		
		//ȥ�ո񣬽�Null��"" ת��ΪNull  
        //System.out.println(StringUtils.trimToNull(""));
        
        //ȥ�ո񣬽�NULL �� "" ת��Ϊ""  
        //System.out.println(StringUtils.trimToEmpty(null));
		
		//ȥ�������ַ�  \n \t \r\n��
        //System.out.println(StringUtils.strip("��Һ�  ��  \n"));
		
		//ͬ�ϣ���""��nullת��ΪNull  
        //System.out.println(StringUtils.stripToNull(" 12312312 \t"));
        
        //�����ַ���ΪNullʱ ת��Ϊָ�����ַ���(������)  
        //System.out.println(StringUtils.defaultString(null, "df"));
		
		//���ַ���Ϊnull����""ʱ��ת��Ϊָ�����ַ���(������)  
        //System.out.println(StringUtils.defaultIfEmpty("123", "sos"));
        
		//����ڶ�������Ϊnullȥ�ո�(����ȥ���ַ���2��һ�����ַ�������һ��Ϊֹ)
        //System.out.println(StringUtils.strip("ffsfsdf", "f"));
		
		//����ڶ�������Ϊnullֻȥǰ��ո�(����ȥ���ַ���ǰ��һ�����ַ�������һ��Ϊֹ)  
		//System.out.println(StringUtils.stripStart("ddsuuu ", "d"));
		
		//����ڶ�������Ϊnullֻȥ����ո�(����ȥ���ַ�������һ�����ַ�������һ��Ϊֹ)
		//System.out.println(StringUtils.stripEnd("dabads", "das"));
		
		//�ж�2���ַ����Ƿ����,NULLҲ���
		//System.out.println(StringUtils.equals(null, null));  
		
		//�ж�2���ַ����Ƿ����(���Դ�Сд)
		//System.out.println(StringUtils.equalsIgnoreCase("abc", "ABc"));  
		
		//��ͨ�����ַ������һ����Ϊnull����""����-1
		//System.out.println(StringUtils.indexOf(null, "a"));  
		
		//��ָ��λ��(������)��ʼ���ң������ӵ�2���ַ���ʼ����k�ַ�  
		//System.out.println(StringUtils.indexOf("akfekcd�л�", "k", 2));  
		
		//���ң������������ǳ��ֵڼ��Σ�����˵������ַ��������ҵľ���k���ֵڶ��ε�λ��
		//System.out.println(StringUtils.ordinalIndexOf("akfekcd�л�", "k", 2));  
		
		//���Ҳ����ִ�Сд
		//System.out.println(StringUtils.indexOfIgnoreCase("adfs", "D"));
		
		//��ָ��λ�ò��ң������ִ�Сд
		//System.out.println(StringUtils.indexOfIgnoreCase("adfs", "a", 3));  
		
		//�غ���ǰ����
		//System.out.println(StringUtils.lastIndexOf("adfas", "a")); 
		
		//��ָ��λ�ã��غ���ǰ����
		//System.out.println(StringUtils.lastIndexOf("dabasdafs", "a", 7));  
		
		//�غ���ǰ���ң������������ǳ��ֵڼ��Σ�����˵������ַ��������ҵľ���f���ֵڶ��ε�λ��
		//System.out.println(StringUtils.lastOrdinalIndexOf("yksdfdht", "f", 1));  
		
		//�غ���ǰ�飬�����ִ�Сд
		//System.out.println(StringUtils.lastIndexOfIgnoreCase("sdffet", "E"));
		
		//�غ���ǰ�飬�����ִ�Сд(δ��)
		//System.out.println(StringUtils.lastIndexOfIgnoreCase("efefrfs��", "F" , 2));  
		
		//�Ƿ����������1�Ƿ��������2
		//System.out.println(StringUtils.contains("sdf", "df"));
		
		//�Ƿ����(�����ִ�Сд)������1�Ƿ��������2
		//System.out.println(StringUtils.containsIgnoreCase("sdf", "D")); 
		
		//�Ƿ�����ո�(������)
		//System.out.println(StringUtils.containsWhitespace(" d"));
	
		//��ѯ�ַ�����������һԪ����ͬ�ĵ�һ����ͬ��λ��
		//System.out.println(StringUtils.indexOfAny("absfekf", new String[]{"f", "b"}));  
		
		//����ԭ����
//		String array[] = new String[]{" �л� ", "�� ��", "�����͹�"};
//		System.out.println("ԭ�����ǣ�");
//		for(int i=0;i<array.length;i++){
//	    	System.out.println("["+array[i]+"]");
//	    }
		
		//����ȥ�����пո�
//	    String retArray[] = StringUtils.stripAll(array); 
//	    System.out.println("ת����������ǣ�");
//	    for(int i=0;i<retArray.length;i++){
//	    	System.out.println("["+retArray[i]+"]");
//	    }
	    
		//����ڶ�������Ϊnull.������ÿ���ַ�������ȥ�ո�(����ȥ������ÿ��Ԫ�ؿ�ʼ�ͽ�βһ�����ַ�) 
//	    String retArray[] = StringUtils.stripAll(array,"��"); 
//	    System.out.println("ת����������ǣ�");
//	    for(int i=0;i<retArray.length;i++){
//	    	System.out.println("["+retArray[i]+"]");
//	    }	
		/**
         * count ����һ������ַ������䳤����ָ�����ַ���,�ַ����Ӳ�������ĸ�����ַ�����ѡ���������ʾ��
         * letters true,���ɵ��ַ������԰�����ĸ�ַ�
         * numbers true,���ɵ��ַ������԰��������ַ�
         */
//		String random = RandomStringUtils.random(5,true, false);
//		System.out.println(random);
		
		/**
         * ����һ������ַ������䳤����ָ�����ַ�����
         * ���������ַ�����ѡ���ַ�
         */
//		String random = RandomStringUtils.random(22);
//        System.out.println(random);
		
		/**
         * ����һ������ַ������䳤����ָ�����ַ�����
         * �ַ������ַ���ָ�����ַ�����ѡ�񣬲���Ϊ�ա����NULL����ʹ�������ַ�����
         */
		String random = RandomStringUtils.random(15, "abcdefgABCDEFG123456789");
        System.out.println(random);
		
	}
}
