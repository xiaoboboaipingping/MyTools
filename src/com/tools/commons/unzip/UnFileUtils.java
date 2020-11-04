package com.tools.commons.unzip;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.tools.tar.TarEntry;
import org.apache.tools.tar.TarInputStream;
import org.apache.tools.tar.TarOutputStream;

public class UnFileUtils {
	public static void unGzipFile(String sourcedir) {
        String ouputfile = "";
        try {
            //����gzipѹ���ļ�������
            FileInputStream fin = new FileInputStream(sourcedir);
            //����gzip��ѹ������
            GZIPInputStream gzin = new GZIPInputStream(fin);
            //������ѹ�ļ������
            ouputfile = sourcedir.substring(0,sourcedir.lastIndexOf('.'));
            ouputfile = ouputfile.substring(0,ouputfile.lastIndexOf('.'));
            FileOutputStream fout = new FileOutputStream(ouputfile);

            int num;
            byte[] buf=new byte[1024];

            while ((num = gzin.read(buf,0,buf.length)) != -1)
            {
                fout.write(buf,0,num);
            }

            gzin.close();
            fout.close();
            fin.close();
        } catch (Exception ex){
            System.err.println(ex.toString());
        }
        return;
    }
	
	/**
     * ��ѹ��zipFile
     * @param file Ҫ��ѹ��zip�ļ�����
     * @param outputDir Ҫ��ѹ��ĳ��ָ����Ŀ¼��
     * @throws IOException
     */
    public static void unZip(File file,String outputDir) throws IOException {
        ZipFile zipFile = null;

        try {
            Charset CP866 = Charset.forName("CP866");  //specifying alternative (non UTF-8) charset
            //ZipFile zipFile = new ZipFile(zipArchive, CP866);
            zipFile =  new ZipFile(file, CP866);
            createDirectory(outputDir,null);//�������Ŀ¼

            Enumeration<?> enums = zipFile.entries();
            while(enums.hasMoreElements()){

                ZipEntry entry = (ZipEntry) enums.nextElement();
                System.out.println("��ѹ." +  entry.getName());

                if(entry.isDirectory()){//��Ŀ¼
                    createDirectory(outputDir,entry.getName());//������Ŀ¼
                }else{//���ļ�
                    File tmpFile = new File(outputDir + "/" + entry.getName());
                    createDirectory(tmpFile.getParent() + "/",null);//�������Ŀ¼

                    InputStream in = null;
                    OutputStream out = null;
                    try{
                        in = zipFile.getInputStream(entry);;
                        out = new FileOutputStream(tmpFile);
                        int length = 0;

                        byte[] b = new byte[2048];
                        while((length = in.read(b)) != -1){
                            out.write(b, 0, length);
                        }

                    }catch(IOException ex){
                        throw ex;
                    }finally{
                        if(in!=null)
                            in.close();
                        if(out!=null)
                            out.close();
                    }
                }
            }

        } catch (IOException e) {
            throw new IOException("��ѹ���ļ������쳣",e);
        } finally{
            try{
                if(zipFile != null){
                    zipFile.close();
                }
            }catch(IOException ex){
                throw new IOException("�ر�zipFile�����쳣",ex);
            }
        }
    }

    /**
     * ����Ŀ¼
     * @param outputDir
     * @param subDir
     */
    public static void createDirectory(String outputDir,String subDir){
        File file = new File(outputDir);
        if(!(subDir == null || subDir.trim().equals(""))){//��Ŀ¼��Ϊ��
            file = new File(outputDir + "/" + subDir);
        }
        if(!file.exists()){
              if(!file.getParentFile().exists())
                  file.getParentFile().mkdirs();
            file.mkdirs();
        }
    }
    
    
  //------------------------------------------------------------------------------------------------------
    /**
     * ��ѹtar.gz �ļ�
     * @param file Ҫ��ѹ��tar.gz�ļ�����
     * @param outputDir Ҫ��ѹ��ĳ��ָ����Ŀ¼��
     * @throws IOException
     */
    public static void unTarGz(File file,String outputDir) throws IOException{
        TarInputStream tarIn = null;
        try{
            tarIn = new TarInputStream(new GZIPInputStream(
                    new BufferedInputStream(new FileInputStream(file))),
                    1024);

            createDirectory(outputDir,null);//�������Ŀ¼

            TarEntry entry = null;
            while( (entry = tarIn.getNextEntry()) != null ){

                if(entry.isDirectory()){//��Ŀ¼
                    entry.getName();
                    createDirectory(outputDir,entry.getName());//������Ŀ¼
                }else{//���ļ�
                    File tmpFile = new File(outputDir + "/" + entry.getName());
                    createDirectory(tmpFile.getParent() + "/",null);//�������Ŀ¼
                    OutputStream out = null;
                    try{
                        out = new FileOutputStream(tmpFile);
                        int length = 0;

                        byte[] b = new byte[1024];

                        while((length = tarIn.read(b)) != -1){
                            out.write(b, 0, length);
                        }

                    }catch(IOException ex){
                        throw ex;
                    }finally{

                        if(out!=null)
                            out.close();
                    }
                }
            }
        }catch(IOException ex){
            throw new IOException("��ѹ�鵵�ļ������쳣",ex);
        } finally{
            try{
                if(tarIn != null){
                    tarIn.close();
                }
            }catch(IOException ex){
                throw new IOException("�ر�tarFile�����쳣",ex);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
		File f = new File("D:/crm/ylsw_20200620.tar.gz");
		String outDir = "D:/crm/ylsw_20200620";
		unTarGz(f,outDir);
	}
}
