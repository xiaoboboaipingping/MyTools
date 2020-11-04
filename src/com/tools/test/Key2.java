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
	 * ����˽Կ ��Կ
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
			System.out.println("���ɳɹ���\n˽Կ��λ���ڣ�"+PRIVATE_KEY_PATH+"\n��Կ��λ���ڣ�"+PUBLIC_KEY_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ��Կ
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
	 * ��ȡ˽Կ
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
	 * ���ܷ���
	 * 
	 * @param source Դ����
	 * @param publicKey  ��Կ
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String source, Key publicKey) throws Exception {
		/** �õ�Cipher������ʵ�ֶ�Դ���ݵ�RSA���� */
		Cipher cipher = Cipher.getInstance("RSA", new BouncyCastleProvider());
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] b = source.getBytes();
		/** ִ�м��ܲ��� */
		byte[] b1 = cipher.doFinal(b);
		return new String(Hex.encodeHex(b1));
	}

	/**
	 * �����㷨
	 * 
	 * @param cryptograph  ����
	 * @param privateKey  ˽Կ
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String cryptograph, Key privateKey) throws Exception {
		Cipher cipher = null;
		/** �õ�Cipher��������ù�Կ���ܵ����ݽ���RSA���� */
		if (cipher == null) {
			cipher = Cipher.getInstance("RSA", new BouncyCastleProvider());
		}
		try {
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] b1 = Hex.decodeHex(cryptograph.toCharArray());

			/** ִ�н��ܲ��� */
			byte[] b = cipher.doFinal(b1);
			System.out.println("res:" + new String(b));
			return new String(b);
		} catch (Exception e) {
			// һ������RSA���ܴ�������cipher
			cipher = null;
			System.out.println("cipher reset");
			e.printStackTrace();
			throw e;
		}
	}

	public static void main(String[] args) throws Exception {		
		//����1���ӽ��ܱ�־  0���� 1����
		//����2���ӽ�������
		//����3����Կ/˽Կ�ļ�λ��
		//����4�������ļ���ַ
		String deOrEnFlag = args[0].trim();//���ܽ��ܱ�ʶ	
		String mes = args[1].trim(); //���ܻ��������
		String key = args[2].trim(); //��Կ��˽Կ
		String filePath = args[3].trim(); //�����ļ�λ��
		RSAPrivateKey publicKey = (RSAPrivateKey) getPrivateKey(key);
		if("0".equals(deOrEnFlag)){
			//�������
			String target = encrypt(mes, publicKey);
			//������д�뵽�ļ�
			FileToolsUtils.fileWriterFile(filePath, target, false);
		}else if("1".equals(deOrEnFlag)){
			//�������
			String target = decrypt(mes, publicKey);
			//������д�뵽�ļ�
			FileToolsUtils.fileWriterFile(filePath, target, false);			
		}else{
			System.out.println("�ӽ��ܱ�־�������");
			return;
		}
		
		
		
	}

}
