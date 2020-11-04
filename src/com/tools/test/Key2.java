package com.tools.test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Scanner;

import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Key2 {

	private static final String PUBLIC_KEY_PATH = "/qdtest/xipdb2/user/haibo/java/RSA/key/public_key";
	private static final String PRIVATE_KEY_PATH = "/qdtest/xipdb2/user/haibo/java/RSA/key/private_key";
	//private static final String PUBLIC_KEY_PATH = "d:/test/public_key";
	//private static final String PRIVATE_KEY_PATH = "d:/test/private_key";

	/**
	 * 生成私钥 公钥
	 */
	public static void geration() {
		KeyPairGenerator keyPairGenerator;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			SecureRandom secureRandom = new SecureRandom(new Date().toString().getBytes());
			keyPairGenerator.initialize(1024, secureRandom);
			KeyPair keyPair = keyPairGenerator.genKeyPair();
			byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
			FileOutputStream fos = new FileOutputStream(PUBLIC_KEY_PATH);
			fos.write(publicKeyBytes);
			fos.close();

			byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
			fos = new FileOutputStream(PRIVATE_KEY_PATH);
			fos.write(privateKeyBytes);
			fos.close();
			System.out.println("生成成功：\n私钥的位置在："+PRIVATE_KEY_PATH+"\n公钥的位置在："+PUBLIC_KEY_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取公钥
	 * 
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public static PublicKey getPublicKey(String filename) throws Exception {
		File f = new File(filename);
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		byte[] keyBytes = new byte[(int) f.length()];
		dis.readFully(keyBytes);
		dis.close();
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}

	/**
	 * 获取私钥
	 * 
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public static PrivateKey getPrivateKey(String filename) throws Exception {
		File f = new File(filename);
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		byte[] keyBytes = new byte[(int) f.length()];
		dis.readFully(keyBytes);
		dis.close();
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(spec);
	}

	/**
	 * 加密方法
	 * 
	 * @param source 源数据
	 * @param publicKey  公钥
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String source, Key publicKey) throws Exception {
		/** 得到Cipher对象来实现对源数据的RSA加密 */
		Cipher cipher = Cipher.getInstance("RSA", new BouncyCastleProvider());
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] b = source.getBytes();
		/** 执行加密操作 */
		byte[] b1 = cipher.doFinal(b);
		return new String(Hex.encodeHex(b1));
	}

	/**
	 * 解密算法
	 * 
	 * @param cryptograph  密文
	 * @param privateKey  私钥
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String cryptograph, Key privateKey) throws Exception {
		Cipher cipher = null;
		/** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
		if (cipher == null) {
			cipher = Cipher.getInstance("RSA", new BouncyCastleProvider());
		}
		try {
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] b1 = Hex.decodeHex(cryptograph.toCharArray());

			/** 执行解密操作 */
			byte[] b = cipher.doFinal(b1);
			System.out.println("res:" + new String(b));
			return new String(b);
		} catch (Exception e) {
			// 一旦发生RSA解密错误，重置cipher
			cipher = null;
			System.out.println("cipher reset");
			e.printStackTrace();
			throw e;
		}
	}

	public static void main(String[] args) throws Exception {		
		//参数1：加解密标志  0加密 1解密
		//参数2：加解密内容
		//参数3：公钥/私钥文件位置
		//参数4：生成文件地址
		String deOrEnFlag = args[0].trim();//加密解密标识	
		String mes = args[1].trim(); //加密或解密内容
		String key = args[2].trim(); //公钥或私钥
		String filePath = args[3].trim(); //生成文件位置
		RSAPrivateKey publicKey = (RSAPrivateKey) getPrivateKey(key);
		if("0".equals(deOrEnFlag)){
			//加密情况
			String target = encrypt(mes, publicKey);
			//将内容写入到文件
			FileToolsUtils.fileWriterFile(filePath, target, false);
		}else if("1".equals(deOrEnFlag)){
			//解密情况
			String target = decrypt(mes, publicKey);
			//将内容写入到文件
			FileToolsUtils.fileWriterFile(filePath, target, false);			
		}else{
			System.out.println("加解密标志输入错误！");
			return;
		}
		
		
		
	}

}
