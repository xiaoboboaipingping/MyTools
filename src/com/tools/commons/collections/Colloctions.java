package com.tools.commons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.bidimap.TreeBidiMap;
import org.apache.commons.collections.map.LinkedMap;

public class Colloctions {
	public static void main(String[] args) {
		/** 
	        * �õ������ﰴ˳���ŵ�key֮���ĳһKey 
	        */  
//	        OrderedMap map = new LinkedMap();  
//	        map.put("FIVE", "5");  
//	        map.put("SIX", "6");  
//	        map.put("SEVEN", "7");  
//	        System.out.println(map.firstKey()); // returns "FIVE"  
//	        System.out.println(map.nextKey("FIVE")); // returns "SIX"  
//	        System.out.println(map.nextKey("SIX")); // returns "SEVEN" 
	        
	        
//	        /** 
//	         * ͨ��key�õ�value 
//	         * ͨ��value�õ�key 
//	         * ��map���key��value�Ե� 
//	         */  
//	       
//	         BidiMap bidi = new TreeBidiMap();  
//	         bidi.put("SIX", "6");  
//	         System.out.println(bidi.get("SIX"));  // returns "6"  
//	         System.out.println(bidi.getKey("6"));  // returns "SIX"  
//	         //       bidi.removeValue("6");  // removes the mapping  
//	         BidiMap inverse = bidi.inverseBidiMap();  // returns a map with keys and values swapped  
//	         System.out.println(inverse);
		
		
		
//        /** 
//         * �õ�������������ͬ��Ԫ�� 
//         */  
        List<String> list1 = new ArrayList<String>();  
        list1.add("1");  
        list1.add("2");  
        list1.add("3");  
        List<String> list2 = new ArrayList<String>();  
        list2.add("2");  
        list2.add("3");  
        list2.add("5");  
        Collection c = CollectionUtils.retainAll(list1, list2);  
        System.out.println(c); 
	}
}
