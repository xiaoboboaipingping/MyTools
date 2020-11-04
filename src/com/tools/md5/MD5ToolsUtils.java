package com.tools.md5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 
 * @作者： 吴海波
 * @功能：MD5相关操作的工具类
 *
 */
public class MD5ToolsUtils {
	
	 /**
     * 默认的密码字符串组合，用来将字节转换成 16 进制表示的字符,apache校验下载的文件的正确性用的就是默认的这个组合
     */
    protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
 
    protected static MessageDigest messagedigest = null;
    
    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nsaex) {
            System.err.println(MD5ToolsUtils.class.getName()
                    + "初始化失败，MessageDigest不支持MD5Util。");
            nsaex.printStackTrace();
        }
    }
    
    /**
     * @作者： 吴海波
     * @功能：生成byte类型数组的md5校验值
     * @入参：byte[]
     * @出参：MD5校验码String
     * 
     * */
    public static String getMD5Byte(byte[] bytes) {
        messagedigest.update(bytes);
        return bufferToHex(messagedigest.digest());
    }
    
    /**
     * @作者： 吴海波
     * @功能：生成文件的md5校验值
     * @入参：File
     * @出参：MD5校验码String
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
     * @作者： 吴海波
     * @功能：生成字符串的md5校验值
     * @入参：字符串类型String
     * @出参：MD5校验码String
     */
    public static String getMD5String(String s) {
        return getMD5Byte(s.getBytes());
    }
              
    /**
     * @作者： 吴海波
     * @功能：判断字符串的md5校验码是否与一个已知的md5码相匹配
     * @入参： password 要校验的字符串
     * @出参： md5PwdStr 已知的md5校验码
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
        char c0 = hexDigits[(bt & 0xf0) >> 4];// 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移,此处未发现两种符号有何不同 
        char c1 = hexDigits[bt & 0xf];// 取字节中低 4 位的数字转换 
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }
}
