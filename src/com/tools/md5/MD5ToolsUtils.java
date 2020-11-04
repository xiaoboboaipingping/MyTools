package com.tools.md5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 
 * @���ߣ� �⺣��
 * @���ܣ�MD5��ز����Ĺ�����
 *
 */
public class MD5ToolsUtils {
	
	 /**
     * Ĭ�ϵ������ַ�����ϣ��������ֽ�ת���� 16 ���Ʊ�ʾ���ַ�,apacheУ�����ص��ļ�����ȷ���õľ���Ĭ�ϵ�������
     */
    protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
 
    protected static MessageDigest messagedigest = null;
    
    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nsaex) {
            System.err.println(MD5ToolsUtils.class.getName()
                    + "��ʼ��ʧ�ܣ�MessageDigest��֧��MD5Util��");
            nsaex.printStackTrace();
        }
    }
    
    /**
     * @���ߣ� �⺣��
     * @���ܣ�����byte���������md5У��ֵ
     * @��Σ�byte[]
     * @���Σ�MD5У����String
     * 
     * */
    public static String getMD5Byte(byte[] bytes) {
        messagedigest.update(bytes);
        return bufferToHex(messagedigest.digest());
    }
    
    /**
     * @���ߣ� �⺣��
     * @���ܣ������ļ���md5У��ֵ
     * @��Σ�File
     * @���Σ�MD5У����String
     */
    public static String getFileMD5String(File file) throws IOException {       
        InputStream fis;
        fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int numRead = 0;
        while ((numRead = fis.read(buffer)) > 0) {
            messagedigest.update(buffer, 0, numRead);
        }
        fis.close();
        return bufferToHex(messagedigest.digest());
    }
    
    /**
     * @���ߣ� �⺣��
     * @���ܣ������ַ�����md5У��ֵ
     * @��Σ��ַ�������String
     * @���Σ�MD5У����String
     */
    public static String getMD5String(String s) {
        return getMD5Byte(s.getBytes());
    }
              
    /**
     * @���ߣ� �⺣��
     * @���ܣ��ж��ַ�����md5У�����Ƿ���һ����֪��md5����ƥ��
     * @��Σ� password ҪУ����ַ���
     * @���Σ� md5PwdStr ��֪��md5У����
     */
    public static boolean checkPassword(String md5, String md5PwdStr) {
        return md5.equals(md5PwdStr);
    }
     
    private static String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }
 
    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }
 
    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 0xf0) >> 4];// ȡ�ֽ��и� 4 λ������ת��, >>> Ϊ�߼����ƣ�������λһ������,�˴�δ�������ַ����кβ�ͬ 
        char c1 = hexDigits[bt & 0xf];// ȡ�ֽ��е� 4 λ������ת�� 
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }
}
