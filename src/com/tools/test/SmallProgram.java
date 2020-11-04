package com.tools.test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class SmallProgram {
	//不用- * /实现加减乘和除
	public static void main(String[] args) {
//		int m = 6;
//		int n = 2;
//		System.out.println("加法："+add(m,n));
//		System.out.println("减法："+sub(m,n));
//		System.out.println("乘法："+mul(m,n));
//		System.out.println("除法："+div(m,n));
//		smallPro();
//		String a[] = {"1","2","3","4","5"};
//		List<String> lString = new ArrayList<String>();
//		for(int i=0;i<a.length;i++){
//			lString.add(a[i]);
//		}
//		Object beginArray[] = lString.subList(0, 2).toArray();
//		Object endArray[] = lString.subList(3, lString.size()).toArray();
//		
//		lString.clear();
//		for(int j =0;j<endArray.length;j++){
//			lString.add(endArray[j].toString());
//		}
//		for(int i =0;i<beginArray.length;i++){
//			lString.add(beginArray[i].toString());
//		}
//		
//		for(int i=0;i<lString.size();i++){
//			System.out.println(lString.get(i));
//		}
		String PRIVATE_KEY_PATH = "d://test//private_key";
		String cryptograph = "786a359fb267c513e0fe6393c6c330f238266140ae4f60d9dc2352d48fabda146744801929bfcd6390ea00d2b544283aaaac1f3c38be36753a9ff2d3043fe3da8c8b1da6ab04004d24e9aeb3f51a69834327684a29bf0c4f8d2c38716231fac47f550dfa1b524d2a37a542848f43ce9d8628694cf80cf446f6e87abc9c4eaadc";
		RSAPrivateKey privKey = null;
		try {
			privKey = (RSAPrivateKey) getPrivateKey(PRIVATE_KEY_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String target = null;
		try {
			target = decrypt(cryptograph, privKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 解密密文
		System.out.println("用私钥解密后的字符串为：" + target);
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
	
	public static int add(int m,int n){
		return m + n;
	}
	
	public static int sub(int m,int n){
		int num = 0;
		for(int i =n;i<m;i++){
			num ++;
		}
		return num;
	}
	
	public static int mul(int m,int n){
		int num = 0;
		for(int i=0;i<m;i++){
			for(int j =0;j<n;j++){
				num ++;
			}
		}
		return num;
	}
	
	public static int div(int m,int n){
		int num = 0;
		for(int i= n;i<m;i+=n){
			num ++;
		}
		return num;
	}
	
	private static List zh(List<String> lString,int m){
		Object beginArray[] = lString.subList(0, m).toArray();
		Object endArray[] = lString.subList(m+1, lString.size()).toArray();
		
		lString.clear();
		for(int j =0;j<endArray.length;j++){
			lString.add(endArray[j].toString());
		}
		for(int i =0;i<beginArray.length;i++){
			lString.add(beginArray[i].toString());
		}
		return lString;
	}
	
	public static void smallPro(){
		String a[] = {"1","2","3","4","5"};
		int step = 3;
		int point = 0;
		List<String> lString = new ArrayList<String>();
		for(int i=0;i<a.length;i++){
			lString.add(a[i]);
		}
		while(true){
			if(lString.size()>step){
				for(int i = 0;i<lString.size();i++){
					if(point == step){
						point = 0;
						lString = zh(lString,i);
						break;
					}
					point ++;
				}	
			}else{
				break;
			}
		}
		System.out.print("最后一次----");
		for(int i =0;i<lString.size();i++){
			System.out.print(lString.get(i));
		}
		
	}
}
