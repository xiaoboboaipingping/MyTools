package com.tools.test;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.FileUtils;

import com.alibaba.excel.util.FileUtil;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class Test6 {
	public static void main(String[] args) throws IOException {
		//16����ת��10����
//		String xxx = "c4cfbea9";
//		System.out.println("ת��ǰ"+xxx);
//		String t = hexStringToString(xxx);
//		//String t = Integer.toHexString(Integer.parseInt(xxx));
//		System.out.println("ת����"+t);

        //10����ת��16����   c4cfbea9
//		String xxx = "�Ͼ�";
//		System.out.println("ת��ǰ"+xxx);
//		String t = str2HexStr(xxx);
//		System.out.println("ת����"+t);
		
		//paseint 16
//		String xxx = "12d687";
//		System.out.println("ת��ǰ"+xxx);
//		String t = Integer.toHexString(Integer.parseInt(xxx));
//		System.out.println("ת����"+t);
		
		String xxx = "�⺣��123С����";
		System.out.println(xxx.getBytes().length);
		for(int i=0;i<xxx.getBytes().length;i++){
			System.out.println(xxx.getBytes()[i]);
		}
	}
	
	
	

	/**
	 * �ַ���ת����Ϊ16����(����Unicode����)
	 * @param str
	 * @return
	 */
	public static String str2HexStr(String str) {
	    char[] chars = "0123456789abcdef".toCharArray();
	    StringBuilder sb = new StringBuilder("");
	    byte[] bs = str.getBytes();
	    int bit;
	    for (int i = 0; i < bs.length; i++) {
	        bit = (bs[i] & 0x0f0) >> 4;
	        sb.append(chars[bit]);
	        bit = bs[i] & 0x0f;
	        sb.append(chars[bit]);
	        // sb.append(' ');
	    }
	    return sb.toString().trim();
	}
    
    /**
     * 16����ת����Ϊstring�����ַ���
     * @param s
     * @return
     */
    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "GBK");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }
    
	   /**
  * Converts the byte array to HEX string.
  *
  * @param buffer
  *            the buffer.
  * @return the HEX string.
  */
 private static String toHexString2(byte[] buffer) {

     String bufferString = "";

     for (int i = 0; i < buffer.length; i++) {

         String hexChar = Integer.toHexString(buffer[i] & 0xFF);
         if (hexChar.length() == 1) {
             hexChar = "0" + hexChar;
         }

         bufferString += hexChar.toUpperCase();
     }

     return bufferString;
 }
}

