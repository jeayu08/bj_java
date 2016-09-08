package com.base.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bj.system.DBUtils;

public class UserDao {
	
private String name;
	
	private String password;
	public UserDao(String name) {
		super();
		this.name = name;
		
	}
	public UserDao(String name,String password) {
		super();
		this.name = name;
		this.password = password;
	}
   

	public String getPassWord(){
	      Connection conn = DBUtils.getConnection();
	      if(conn == null)return null;
	      String sql ="SELECT password FROM user WHERE name ="+"'"+this.name+"'";
	      String psw = "";
	//第四步 执行查询 使用Statement类中的executeQuery方法执行查询
	      try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()){
					psw=rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBUtils.close(conn);
				return psw;
			
			}
	
	   }
	
	 public void reg(){
		 int i =0;
		 Connection conn = DBUtils.getConnection();
		 if(conn == null)return;
		 StringBuffer sb = new StringBuffer();
         sb.append("INSERT INTO `bj_db`.`user`(name, password)");
//         `editor`, `editor_name`,`bussmen_name`,`accounts`,`buss_place`,`buss_reason`,`buss_begintime`,`buss_endtime`,`time`
         sb.append(" VALUES (?,?)");
	     PreparedStatement pstmt = null;
	     try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setObject(1,name);
			pstmt.setObject(2,password);
			
//			pstmt.setObject(5,buss_place);
//			pstmt.setObject(6,buss_reason);
//			pstmt.setObject(7,buss_begintime);
//			pstmt.setObject(8,buss_endtime);
//			pstmt.setObject(9,time);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(conn);
			return;
		}
         
	 }
}
	



