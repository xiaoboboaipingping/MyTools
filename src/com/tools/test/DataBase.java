package com.tools.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DataBase {
	 static String iniPath = ""; //ini 文件的路径
	 static Properties p = null;
	 static File file = null;

		/*
		 * 构造方法给初始值赋值
		 * add by haibo
		 * addtime  2016-04-13
		 */		 
	 public DataBase(){
		  this.iniPath = "conf/config.ini"; //ini 文件的路径
		  this.p = new Properties();
		  this.file = new File(iniPath);		 
	      try {
			p.load(new FileInputStream(iniPath));//读取配置文件
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	 }
	 
		/*
		 * 获取sqlserver连接
		 * add by haibo
		 * addtime  2016-04-13
		 */		
		public static Connection getCon(){
			  Connection conn = null; 
//		      System.out.println("获取sql的ip地址:"+p.get("ServerName"));
//		
//		      System.out.println("获取sql的实例名:"+p.get("sqldata"));
//		      
//		      System.out.println("获取sql的登录端口:"+p.get("Port"));
//		      
//		      System.out.println("获取sql的登录名:"+p.get("UserName"));
//		     
//		      System.out.println("获取sql的登录密码:"+p.get("Pws"));
//		      
		      
		     
		      //String sqlIp = p.get("ServerName").toString();
		     // String sqlData = p.get("sqldata").toString();
		      String sqlUser = p.get("UserName").toString();
		      String sqlPass = p.get("Pws").toString(); 
		      //String sqlPort = p.get("Port").toString(); 
		      String mysqlDriver = p.get("mysqlDriver").toString(); 
		      String url = p.get("url").toString(); 
		      //String sqlCon = sqlIp+ "/" + sqlData;
		      
			  try {  
			   Class.forName(mysqlDriver);  
			   conn = DriverManager.getConnection(url, ""+sqlUser+"", ""+sqlPass+""); 
			  }catch(Exception e){
				  e.printStackTrace();
			  }
			  return conn;		  
		}	
		
		/*
		 * 查询
		 * add by haibo
		 * addtime  2016-04-13
		 */	
		public static List<Map<String,String>> query(String sqls) throws SQLException {
			new DataBase();
			Connection conn = getCon();
			List<Map<String,String>> l = new ArrayList<Map<String,String>>();
			ResultSet rs = null;  
			Statement stmt = null;    
		    try {
		 	   stmt = conn.createStatement(); 
			   rs = stmt.executeQuery(sqls); 
//			   wl.logwrite(sql);
			   ResultSetMetaData metaData = rs.getMetaData();    
			   while(rs.next()) { 
				   HashMap<String,String> map = new HashMap<String,String>();
			   for (int i=1;i<=metaData.getColumnCount();i++){  
				   map.put(metaData.getColumnName(i).toUpperCase(), rs.getString(metaData.getColumnName(i)));
			    }
			   	   l.add(map);
			   }

		    } catch (SQLException e) {
		        stmt.close();
		        e.printStackTrace();
		    }finally{
		    	stmt.close();
		    }
		    return l;
		}	
		
		/*
		 * 增加方法
		 * add by haibo
		 * addtime  2016-04-13
		 */	
		public static int insert(Connection conn,String sql) throws SQLException {
		    int i = 0;
		    PreparedStatement pstmt = null;
		    try {
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        i = pstmt.executeUpdate();

		    } catch (SQLException e) {
		        //pstmt.close();
		        e.printStackTrace();
		    }finally{
		    	pstmt.close();
		    }
		    return i;
		}		
		
		public static void main(String[] args) throws SQLException, UnsupportedEncodingException {
//			new DataBase();
//			Connection connection = getCon();
//			List<Map<String,String>> lists = query(connection,"select * from test");
//			for (Map<String,String> ss:lists){
//				System.out.println(ss.get("TRXNO"));
//			}
		}		
		
}
