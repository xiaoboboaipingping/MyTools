package com.tools.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.GZIPInputStream;

public class FileToolsUtils
{
  public static boolean createFile(String filePath)
  {
    File file = new File(filePath);
    if (!file.exists()) {
      try {
        file.createNewFile();
        return true;
      } catch (IOException e) {
        System.out.println(e.getMessage());
        return false;
      }
    }
    return true;
  }
  
  public static boolean fileOutPutStreamWriteFile(String filePath, String fileMessage, boolean appendFlag)
  {
    File file = new File(filePath);
    try {
      FileOutputStream out = new FileOutputStream(file, appendFlag);
      byte[] buy = fileMessage.getBytes();
      out.write(buy);
      out.close();
      return true;
    } catch (Exception e) {
      System.out.println("出现错误：" + e.getMessage()); }
    return false;
  }
  
  public static String fileInPutStreamReadFile(String filePath)
  {
    File file = new File(filePath);
    try {
      FileInputStream fileInputStream = new FileInputStream(file);
      byte[] byt = new byte[1024];
      int len = fileInputStream.read(byt);
      fileInputStream.close();
      return new String(byt, 0, len);
    } catch (Exception e) {
      System.out.println("出现错误：" + e.getMessage()); }
    return "";
  }
  
  public static boolean fileWriterFile(String filePath, String fileMessage, boolean appendFlag)
  {
    File file = new File(filePath);
    try {
      FileWriter fileWriter = new FileWriter(file, appendFlag);
      fileWriter.write(fileMessage);
      fileWriter.close();
      return true;
    } catch (Exception e) {
      System.out.println("出现错误：" + e.getMessage()); }
    return false;
  }
  
  public static String fileReaderFile(String filePath)
  {
    File file = new File(filePath);
    try {
      FileReader fileReader = new FileReader(file);
      char[] byt = new char[1024];
      int len = fileReader.read(byt);
      fileReader.close();
      return new String(byt, 0, len);
    } catch (Exception e) {
      System.out.println("出现错误：" + e.getMessage()); }
    return "";
  }
  
  public static boolean bufferWriterFile(String filePath, String[] fileMessage, boolean appendFlag)
  {
    File file = new File(filePath);
    try {
      FileWriter fileWriter = new FileWriter(file, appendFlag);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      for (int i = 0; i < fileMessage.length; i++) {
        bufferedWriter.write(fileMessage[i]);
        bufferedWriter.newLine();
      }
      bufferedWriter.close();
      fileWriter.close();
      return true;
    } catch (Exception e) {
      System.out.println("出现错误：" + e.getMessage()); }
    return false;
  }
  
  public static String bufferedReaderFile(String filePath)
  {
    File file = new File(filePath);
    try {
      FileReader fileReader = new FileReader(file);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String content = "";
      String fileMessage = "";
      while ((content = bufferedReader.readLine()) != null) {
    	System.out.println(content);
        fileMessage = fileMessage +"\n" + content;
      }
      bufferedReader.close();
      fileReader.close();
      return fileMessage;
    } catch (Exception e) {
      System.out.println("出现错误：" + e.getMessage()); }
    return "";
  }
  
  public static boolean deleteFile(String filePath)
  {
    File file = new File(filePath);
    if (file.exists()) {
      file.delete();
      return true;
    }
    System.out.println("文件未存在！");
    return false;
  }
  
  public static Map<String, Object> findFileMessage(String filePath)
  {
    Map<String, Object> fileMessageMap = new HashMap();
    File file = new File(filePath);
    if (file.exists()) {
      fileMessageMap.put("fileName", file.getName());
      fileMessageMap.put("fileCanRead", Boolean.valueOf(file.canRead()));
      fileMessageMap.put("filecanWrite", Boolean.valueOf(file.canWrite()));
      fileMessageMap.put("fileExits", Boolean.valueOf(file.exists()));
      fileMessageMap.put("fileLength", Long.valueOf(file.length()));
      fileMessageMap.put("fileAbsolutePath", file.getAbsolutePath());
      fileMessageMap.put("fileParent", file.getParentFile());
      fileMessageMap.put("fileIsFile", Boolean.valueOf(file.isFile()));
      fileMessageMap.put("fileIsDirectory", Boolean.valueOf(file.isDirectory()));
      fileMessageMap.put("fileHidden", Boolean.valueOf(file.isHidden()));
      
      long time = file.lastModified();
      Date d = new Date(time);
      
      Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String dateString = format.format(d);
      fileMessageMap.put("fileLastModified", dateString);
    } else {
      fileMessageMap.put("fileExits", Boolean.valueOf(false));
      System.out.println("文件不存在！");
    }
    return fileMessageMap;
  }
  
  public static List<String> getFileName(String path)
  {
    File f = new File(path);
    List<String> fileList = new ArrayList();
    if (!f.exists()) {
      System.out.println(path + " not exists");
      return null;
    }
    File[] fa = f.listFiles();
    for (int i = 0; i < fa.length; i++) {
      File fs = fa[i];
      if (!fs.isDirectory())
      {
        fileList.add(fs.getName());
      }
    }
    return fileList;
  }
  
  public static List<String> getFileDir(String path)
  {
    File f = new File(path);
    List<String> fileList = new ArrayList();
    if (!f.exists()) {
      System.out.println(path + " not exists");
      return null;
    }
    File[] fa = f.listFiles();
    for (int i = 0; i < fa.length; i++) {
      File fs = fa[i];
      if (fs.isDirectory()) {
        fileList.add(fs.getName());
      }
    }
    return fileList;
  }
  
  public static void createDirectory(String outputDir, String subDir)
  {
    File file = new File(outputDir);
    if ((subDir != null) && (!subDir.trim().equals(""))) {
      file = new File(outputDir + "/" + subDir);
    }
    if (!file.exists()) {
      if (!file.getParentFile().exists())
        file.getParentFile().mkdirs();
      file.mkdirs();
    }
  }
  
  public static void unGzipFile(String sourcedir, String ouputfile)
  {
    try
    {
      FileInputStream fin = new FileInputStream(sourcedir);
      
      GZIPInputStream gzin = new GZIPInputStream(fin);
      
      FileOutputStream fout = new FileOutputStream(ouputfile);
      
      byte[] buf = new byte[1024];
      
      int num;
      while ((num = gzin.read(buf, 0, buf.length)) != -1) {
        fout.write(buf, 0, num);
      }
      
      gzin.close();
      fout.close();
      fin.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  public static String getPara(String fileName, String key)
    throws Exception
  {
    Properties prop = new Properties();
    try
    {
      FileInputStream fis = new FileInputStream(fileName);
      prop.load(fis);
      if (fis != null)
        fis.close();
    } catch (Exception e) {
      throw e;
    }
    return prop.getProperty(key);
  }
}
