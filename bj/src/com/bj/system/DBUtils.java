package com.bj.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtils {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://127.0.0.1:3306/bj_db";
	
	//��һ�� ��������   
	static{
		 try {
				Class.forName(driver);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args){
		try {
//			System.out.println(DriverManager.getConnection(url,"root","Rfvmg3EaSCZ2").toString());
			System.out.println(DriverManager.getConnection(url,"root","gg711762").toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�ڶ���  �������ݿ�
	public static Connection getConnection(){	
		try {
//			return DriverManager.getConnection(url,"root","Rfvmg3EaSCZ2");
			return DriverManager.getConnection(url,"root","gg711762");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
     //�ر�connection
	public static void close(Connection connection){
		try {
			if(connection != null && !connection.isClosed()){
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pStatement) {
		try{
			if(pStatement == null || pStatement.isClosed())return;
			pStatement.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
