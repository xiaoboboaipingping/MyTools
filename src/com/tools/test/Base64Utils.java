package com.tools.test;

import org.apache.commons.codec.binary.Base64;


import java.io.UnsupportedEncodingException;

public class Base64Utils {

    private static final String UTF_8 = "GBK";

    /**
     * �Ը������ַ�������base64�������
     */
    public static byte[] decodeDataByte(String inputData) {

        try {
            if (null == inputData) {
                return null;
            }
            return Base64.decodeBase64(inputData.getBytes(UTF_8));
        } catch (UnsupportedEncodingException e) {
        }

        return null;
    }
    
    /**
     * �Ը������ַ�������base64���ܲ���
     */
    public static String encodeDataByte(byte[] inputData) {

        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.encodeBase64(inputData), UTF_8);
        } catch (UnsupportedEncodingException e) {
        }

        return null;
    }

    /**
     * �Ը������ַ�������base64�������
     */
    public static String decodeData(String inputData) {

        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.decodeBase64(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
        }

        return null;
    }

    /**
     * �Ը������ַ�������base64���ܲ���
     */
    public static String encodeData(String inputData) {

        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.encodeBase64(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
        }

        return null;
    }

    public static void main(String[] args) {
        //System.out.println(Base64Utils.encodeData("{\"YHBH\": 2,\"FYID\": 2400,\"BH\": \"1D6282CF71719D2E9F379E72291A6616\",\"AH\": \"��2015����ִ200��\"}"));
        
        System.out.println(Base64Utils.decodeData("eyJNU0dDT0RFIjoiLTEiLCJNU0ciOiLCt8OWwr3DosKyw47DisO9w4rCp8Kww5zCo8KhIn0="));
    }
}
