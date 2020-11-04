package com.tools.test;

import java.io.File;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class Zip {
	
	public static void main(String[] args) {
		String src_file = "D:\\test\\111.txt";
		String dst_file = "D:\\test\\111.zip";
		String encode = "111";
		encrypt_zip(src_file, dst_file, encode);
	}
	
    /**
     * @Title: encrypt_zip 
     * @Description:��ָ��·���µ��ļ�ѹ����ָ��zip�ļ�������ָ���������,������Ϊ�գ��򲻽��м��ܱ��� 
     * @param src_file ��ѹ���ļ�·��
     * @param dst_file zip·��+�ļ��� 
     * @param encode ��������  
     * @return 
     */
    public static void encrypt_zip(String src_file, String dst_file, String encode) {
        File file = new File(src_file);

        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);//ѹ����ʽ
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); // ѹ������

        parameters.setEncryptFiles(true);
        parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);//���ܷ�ʽ
        parameters.setPassword(encode.toCharArray());//��������

        try {
            ZipFile zipFile = new ZipFile(dst_file);
            zipFile.setFileNameCharset("gbk");
            zipFile.addFile(file, parameters);

        } catch (ZipException e) {
            e.printStackTrace();
        }

    }
}
