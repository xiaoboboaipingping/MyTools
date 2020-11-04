package com.tools.commons.compress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;

public class UnGZipUtil {
	/**
     * @param tarZipSource Դ�ļ�
     * @param targetDir Ŀ��Ŀ¼
     */
    public static void decompress(String tarZipSource, String targetDir) {
        FileInputStream fInput = null;
        BufferedInputStream bufInput = null;
        ArchiveInputStream archiveInput = null;
        try {
            // �ļ���
            fInput = new FileInputStream(tarZipSource);
            // ������
            bufInput = new BufferedInputStream(fInput);
            // GZIPѹ����
            GZIPInputStream gzipInput = new GZIPInputStream(bufInput);
            // tarѹ����ʽ��tar���ͣ�
            ArchiveStreamFactory aStramFactory = new ArchiveStreamFactory();
            archiveInput = aStramFactory.createArchiveInputStream("tar", gzipInput);
            // tarѹ���ļ���Ŀ
            TarArchiveEntry entry = (TarArchiveEntry) archiveInput.getNextEntry();
            while (entry != null) {
                // ��Ŀ����
                String entryName = entry.getName();
                if(entry.isDirectory()){
                    // �����ǰ��Ŀ��Ŀ¼
                    createDir(targetDir,entryName,1);
                }else if(entry.isFile()){
                    // �����ǰ��Ŀ���ļ�
                    String fullFileName = createDir(targetDir,entryName,2);
                    // ����ļ�
                    warpOutput(fullFileName,archiveInput);
                }
                // ��һ����Ŀ
                entry = (TarArchiveEntry) archiveInput.getNextEntry();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(archiveInput);
            close(bufInput);
            close(fInput);
        }
    }
    
    /**
     * @param file
     * @param input
     * @throws IOException
     */
    private static void warpOutput(String file,InputStream input) 
            throws IOException {
        FileOutputStream fOuput = new FileOutputStream(file);
        BufferedOutputStream bufOutput = new BufferedOutputStream(fOuput);  
        int b = -1;  
        while ((b = input.read()) != -1){  
            bufOutput.write(b);  
        }  
        bufOutput.flush();  
        bufOutput.close();
    }

    /**
     * @param input
     */
    public static void close(InputStream input){
        // ��Ĭ�رմ���
        try {
            if (null != input) {
                input.close();
            }
            input = null;
        } catch (IOException e) { }
    }
    
    /**
     * @param baseDir ��Ŀ¼
     * @param entry ѹ������Ŀ
     * @param type ���ͣ�1��Ŀ¼��2���ļ�
     * @return
     */
    public static String createDir(String baseDir,String entry,int type){
        // �������
        String[] items = entry.split("/");
        String fullFilePath = baseDir;
        for (int i = 0; i < items.length; i++) {
            String item = items[i];
            fullFilePath = fullFilePath + File.separator + item;
            if(type==2){
                if(i!=items.length-1){
                    // ���Ŀ¼�����ڣ��ʹ���
                    File tmpFile = new File(fullFilePath);
                    if(!tmpFile.exists()){
                        tmpFile.mkdir();
                    }
                }
            }else{
                // ���Ŀ¼�����ڣ��ʹ���
                File tmpFile = new File(fullFilePath);
                if(!tmpFile.exists()){
                    tmpFile.mkdir();
                }
            }
        }
        // ����Ŀ¼ȫ·��
        File fullFile = new File(fullFilePath);
        return fullFile.getAbsolutePath();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String base = "D:/crm/";
        UnGZipUtil.decompress(base + "ylsw_20200620.tar.gz",base+"ylsw_20200620/");
        long end = System.currentTimeMillis();
        System.out.println("��ѹ�����ˣ�" + (end - start) + "ms");
    }
}
