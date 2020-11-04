package com.tools.commons.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

public class ToolsFileNameUtils {
	public static void main(String[] args) throws IOException {
		String fileDirectory = "D:\\work";
		String fileName="ZFYK.cfg";
		String fileFullName= fileDirectory +"\\"+fileName;
		System.out.println("(1)��ʾlinux·��:"+FilenameUtils.normalizeNoEndSeparator(fileFullName));
		System.out.println("(2)�ϲ�Ŀ¼���ļ���Ϊ�ļ�ȫ·��:"+FilenameUtils.concat(fileDirectory,fileName));
		System.out.println("(3)�ļ�·��ȥ��Ŀ¼�ͺ�׺����ļ���:"+FilenameUtils.getBaseName(fileFullName));
		System.out.println("(4)��ȡ�ļ��ĺ�׺:"+FilenameUtils.getExtension(fileFullName));
		System.out.println("(5)��ȡ�ļ�������Ŀ¼:"+FilenameUtils.getFullPath(fileFullName));
		System.out.println("(6)��ȡ�ļ���Ŀ¼������������:"+FilenameUtils.getFullPathNoEndSeparator(fileFullName));
		System.out.println("(7)��ȡ�ļ����ƣ�������׺:"+FilenameUtils.getName(fileFullName));
		System.out.println("(8)ȥ��ǰ׺��·��:"+FilenameUtils.getPath(fileFullName));
		System.out.println("(9)ȥ��ǰ׺����βȥ���ָ���:"+FilenameUtils.getPathNoEndSeparator(fileFullName));
		System.out.println("(10)��ȡǰ׺:"+FilenameUtils.getPrefix(fileFullName));
		System.out.println("(11)��ȡǰ׺����:"+FilenameUtils.getPrefixLength(fileFullName));
		System.out.println("(12)��ȡ���һ��.��λ��:"+FilenameUtils.indexOfExtension(fileFullName));
		System.out.println("(13)��ȡ���һ��/��λ��:"+FilenameUtils.indexOfLastSeparator(fileFullName));
		System.out.println("(14)��ȡ��ǰϵͳ��ʽ��·��:"+FilenameUtils.normalize(fileFullName));
        System.out.println("(15)��ȡ��ǰϵͳ�޽�β�ָ�����·��:"+FilenameUtils.normalizeNoEndSeparator(fileDirectory));
        System.out.println("(16)��ȡlinuxϵͳ�޽�β�ָ�����·��:"+FilenameUtils.normalizeNoEndSeparator(fileDirectory));
        System.out.println("(17)�Ƴ��ļ�����չ��:"+FilenameUtils.removeExtension(fileFullName));
        System.out.println("(18)ת���ָ���Ϊ��ǰϵͳ�ָ���:"+FilenameUtils.separatorsToSystem(fileFullName));
        System.out.println("(19)ת���ָ���Ϊlinuxϵͳ�ָ���:"+FilenameUtils.separatorsToUnix(fileFullName));
        System.out.println("(20)ת���ָ���Ϊwindowsϵͳ�ָ���:"+FilenameUtils.separatorsToWindows(fileFullName));
        System.out.println("(21)�ж�Ŀ¼���Ƿ����ָ���ļ���Ŀ¼:"+FilenameUtils.directoryContains(fileDirectory, fileName));
        String linuxFileName = FilenameUtils.normalize(fileFullName);
        System.out.println("(22)�ж��ļ�·���Ƿ���ͬ:"+FilenameUtils.equals(fileFullName, linuxFileName));
        System.out.println("(23)�ж��ļ�·���Ƿ���ͬ����ʽ������Сд������:"+FilenameUtils.equals(fileFullName,FilenameUtils.normalize(fileFullName),true,IOCase.INSENSITIVE));
        System.out.println("(24)�ж��ļ�·���Ƿ���ͬ����ʽ������Сд����:" + FilenameUtils.equalsNormalized(fileFullName, linuxFileName));
        System.out.println("(25)�ж��ļ�·���Ƿ���ͬ������ʽ������Сд���и���ϵͳ����windows�����У�linux��������:"+ FilenameUtils.equalsOnSystem(fileFullName, linuxFileName));
        List<String> extensions = new ArrayList<String>();
        extensions.add("txt");
        extensions.add("cfg");
        System.out.println("(26)�ж��ļ���չ���Ƿ������ָ��������:"+ FilenameUtils.isExtension(fileFullName, extensions));
        System.out.println("(27)�ж��ļ���չ���Ƿ����ָ����չ��:"+ FilenameUtils.isExtension(fileFullName, "cfg"));
        System.out.println("(28)�ж��ļ���չ���Ƿ������ָ���ַ���������:"+ FilenameUtils.isExtension(fileFullName, new String[]{"cfg","java"}));
        System.out.println("(29)�ж��ļ���չ���Ƿ��ָ������ƥ�䣬��Сд����:" + FilenameUtils.wildcardMatch(fileName, "*.???"));
        System.out.println("(30)�ж��ļ���չ���Ƿ��ָ������ƥ�䣬��Сд������:"+ FilenameUtils.wildcardMatch(fileName, "*.???",IOCase.INSENSITIVE));
        System.out.println("(31)�ж��ļ���չ���Ƿ��ָ������ƥ�䣬����ϵͳ�ж������ͣ�windows:�����У�linux������:" +FilenameUtils.wildcardMatchOnSystem(fileName,"*.???"));
	}
}
