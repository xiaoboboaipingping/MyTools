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
     * @Description:将指定路径下的文件压缩至指定zip文件，并以指定密码加密,若密码为空，则不进行加密保护 
     * @param src_file 待压缩文件路径
     * @param dst_file zip路径+文件名 
     * @param encode 加密密码  
     * @return 
     */
    public static void encrypt_zip(String src_file, String dst_file, String encode) {
        File file = new File(src_file);

        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);//压缩方式
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); // 压缩级别

        parameters.setEncryptFiles(true);
        parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);//加密方式
        parameters.setPassword(encode.toCharArray());//设置密码

        try {
            ZipFile zipFile = new ZipFile(dst_file);
            zipFile.setFileNameCharset("gbk");
            zipFile.addFile(file, parameters);

        } catch (ZipException e) {
            e.printStackTrace();
        }

    }
}
