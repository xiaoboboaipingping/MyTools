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
     * @param tarZipSource 源文件
     * @param targetDir 目标目录
     */
    public static void decompress(String tarZipSource, String targetDir) {
        FileInputStream fInput = null;
        BufferedInputStream bufInput = null;
        ArchiveInputStream archiveInput = null;
        try {
            // 文件流
            fInput = new FileInputStream(tarZipSource);
            // 缓冲流
            bufInput = new BufferedInputStream(fInput);
            // GZIP压缩流
            GZIPInputStream gzipInput = new GZIPInputStream(bufInput);
            // tar压缩格式（tar类型）
            ArchiveStreamFactory aStramFactory = new ArchiveStreamFactory();
            archiveInput = aStramFactory.createArchiveInputStream("tar", gzipInput);
            // tar压缩文件条目
            TarArchiveEntry entry = (TarArchiveEntry) archiveInput.getNextEntry();
            while (entry != null) {
                // 条目名称
                String entryName = entry.getName();
                if(entry.isDirectory()){
                    // 如果当前条目是目录
                    createDir(targetDir,entryName,1);
                }else if(entry.isFile()){
                    // 如果当前条目是文件
                    String fullFileName = createDir(targetDir,entryName,2);
                    // 输出文件
                    warpOutput(fullFileName,archiveInput);
                }
                // 下一个条目
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
        // 静默关闭处理
        try {
            if (null != input) {
                input.close();
            }
            input = null;
        } catch (IOException e) { }
    }
    
    /**
     * @param baseDir 根目录
     * @param entry 压缩包条目
     * @param type 类型：1、目录；2、文件
     * @return
     */
    public static String createDir(String baseDir,String entry,int type){
        // 拆分名称
        String[] items = entry.split("/");
        String fullFilePath = baseDir;
        for (int i = 0; i < items.length; i++) {
            String item = items[i];
            fullFilePath = fullFilePath + File.separator + item;
            if(type==2){
                if(i!=items.length-1){
                    // 如果目录不存在，就创建
                    File tmpFile = new File(fullFilePath);
                    if(!tmpFile.exists()){
                        tmpFile.mkdir();
                    }
                }
            }else{
                // 如果目录不存在，就创建
                File tmpFile = new File(fullFilePath);
                if(!tmpFile.exists()){
                    tmpFile.mkdir();
                }
            }
        }
        // 返回目录全路径
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
        System.out.println("解压共用了：" + (end - start) + "ms");
    }
}
