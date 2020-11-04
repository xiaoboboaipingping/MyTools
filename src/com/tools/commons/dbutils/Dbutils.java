package com.tools.commons.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;


public class Dbutils {
    private static Connection conn = null;  
    private static String url = "";  
    private static String jdbcDriver = "";  
    private static String user = "";  
    private static String password = ""; 
    
    /**
     * 读取配置文件获取连接信息，并进行连接
     * @return Connection
     */
    public static Connection DbConnection(){
    	try {
			PropertiesConfiguration config = new PropertiesConfiguration("conf/config.ini");
			url = config.getString("url");
			jdbcDriver = config.getString("mysqlDriver");
			user = config.getString("UserName");
			password = config.getString("Pws");
			DbUtils.loadDriver(jdbcDriver);
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return conn;
    }
    
    
    public static List<String> getColumn(Connection conn,String sql) throws SQLException{
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	ResultSetMetaData rsmd = null;
    	
    	List<String> l = new ArrayList<>();
    	
    	pstmt = (PreparedStatement) conn.prepareStatement(sql);

        rs = pstmt.executeQuery();

        rsmd = (ResultSetMetaData) rs.getMetaData(); //获取字段名

        if(rsmd != null){

          int count  = rsmd.getColumnCount();

          for(int i=1;i<=count;i++){

            //System.out.println("hyqTest======"+rsmd.getColumnName(i));
            l.add(rsmd.getColumnName(i));
          }

        }
		return l;
    }
    
    
    /**
     * 查询后返回bean的list类型
     * @param conn
     * @param sql
     * @param className
     * @return
     */
    public static List<?> getQueryListBean(Connection conn,String sql,Class className){
    	QueryRunner qr = new QueryRunner();
    	try {
			List<?> results = (List<?>) qr.query(conn, sql, new BeanListHandler<Class>(className));
			return results;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
    	return null;
    } 
    
    /**
     * 查询后返回map的list类型
     * @param conn
     * @param sql
     * @param className
     * @return
     */
    public static List<?> getQueryListMap(Connection conn,String sql){
    	QueryRunner qr = new QueryRunner();
    	try {
			List<?> results = (List<?>) qr.query(conn, sql, new MapListHandler());
			return results;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(conn);
		}
    	return null;
    } 
    
    public static void insert(Connection conn) throws SQLException{  
    	QueryRunner qr = new QueryRunner();
        String sql = "insert into Course (Cno, Cname, Ccredit, Semster, Period) values ('C01', '计算机文化学', 3, 1, null);";  
        qr.update(conn, sql);  
         sql = "insert into Course (Cno, Cname, Ccredit, Semster, Period) values ('C02', 'VB', 2, 3, null);";  
        qr.update(conn, sql); 
         sql = "insert into Course (Cno, Cname, Ccredit, Semster, Period) values ('C03', '计算机网络', 4, 7, null);";  
        qr.update(conn, sql); 
         sql = "insert into Course (Cno, Cname, Ccredit, Semster, Period) values ('C04', '数据库基础', 6, 6, null);";  
        qr.update(conn, sql); 
         sql = "insert into Course (Cno, Cname, Ccredit, Semster, Period) values ('C05', '高等数学', 8, 2, null);";  
        qr.update(conn, sql); 
         sql = "insert into Course (Cno, Cname, Ccredit, Semster, Period) values ('C06', '数据结构', 5, 4, null);";  
        qr.update(conn, sql); 
    } 
    
        
	
	public static void main(String[] args) throws SQLException {
		Connection conn = DbConnection();
		//String sql = "select * from person";
		//bean读取方式
//		List<?> personList = getQueryListBean(conn,sql,Person.class);		
//		for (int i = 0; i < personList.size(); i++) {  
//            Person p = (Person) personList.get(i);  
//            System.out.println("id:" + p.getId() + ",name:" + p.getUserName()+",age:"+p.getAge());  
//        } 
		
		//map读取方式
//		List<?> personList = getQueryListMap(conn,sql);
//		for (int i = 0; i < personList.size(); i++) {  
//            Map<?, ?> map = (Map<?, ?>) personList.get(i);  
//            System.out.println("id:" + map.get("id") + ",name:" + map.get("username")+ ",age:" + map.get("age"));  
//        } 
		//insert(conn);
		List<String> l = Dbutils.getColumn(conn,"select * from weapontype");
		for (String column:l){
			System.out.println("private String "+column+";");
		}
	}
}
