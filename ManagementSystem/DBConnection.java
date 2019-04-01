package ManagementSystem;

import java.io.*;
import java.sql.*;
import java.util.*;
	public class DBConnection {
		public static Connection getDBConnection( ) throws Exception {
	    	Properties prop = new Properties();
	    	prop.load(new FileInputStream("D:\\java ���\\StudentManagementSystem\\src\\ManagementSystem\\logon_initial.properties"));
		    String drivers = prop.getProperty("drivers");
		    String url = prop.getProperty("url");
		    String username = prop.getProperty("username");
		    String password= prop.getProperty("password");  
		    	 Class.forName(drivers);   //������������JDK7���ϰ汾���Բ���  
		    	 Connection conn= DriverManager.getConnection(url,username,password); //�������ݿ�	 
	        return conn;
	   }  
		//�����ݿ��teacher���н��н�ʦ�����֤,�û���������
		public static boolean teacherQuery(String user,String pwd,Connection conn,PreparedStatement perstmt){
			String sql=null;
			boolean flag=true;
			int row=0;
			try{
		    	sql="select * from teacher where username=? and password=?";
		        perstmt=conn.prepareStatement(sql);
		    	perstmt.setString(1, user);
		    	perstmt.setString(2, pwd);
		    	ResultSet rs=perstmt.executeQuery();
		    	while(rs.next()){
		    		row++;
		    	}
		    	if(row==0){
		    		flag=false;
		    	}
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;
		}
		//�����ݿ�student���н��н�ʦ�����֤,�û���������
		public static boolean studentQuery(String user,String pwd,Connection conn,PreparedStatement perstmt){
			String sql=null;
			boolean flag=true;
			int row=0;
			try{
		    	sql="select * from student where username=? and password=?";
		    	perstmt=conn.prepareStatement(sql);
		    	perstmt.setString(1, user);
		    	perstmt.setString(2, pwd);
		    	ResultSet rs=perstmt.executeQuery();
		    	while(rs.next()){
		    		row++;
		    	}
		    	if(row==0){
		    		flag=false;
		    	}
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
			return flag;
		}
		
	   public static void Close(Connection conn) throws SQLException{
		   conn.close();	  
	   }
	}
