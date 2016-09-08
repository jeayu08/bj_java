package com.bj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.base.dao.UserDao;
import com.bj.system.DBUtils;

public class bj_changePsw_dao {
	private String c_id;
	private String c_old_psw;
	private String c_new_psw;
	private boolean ture;
	public bj_changePsw_dao(String c_id,String c_old_psw,String c_new_psw){
		this.c_id = c_id;
		this.c_old_psw = c_old_psw;
		this.c_new_psw = c_new_psw;		
	}	
	public void changePsw (){		
		int i =0;		
		 Connection conn = DBUtils.getConnection();
		 if(conn == null)return;
		 String sb="UPDATE bj_db.user SET password='"+this.c_new_psw+"'"+" WHERE name="+"'"+this.c_id+"'";
//        `editor`, `editor_name`,`bussmen_name`,`accounts`,`buss_place`,`buss_reason`,`buss_begintime`,`buss_endtime`,`time`
	     PreparedStatement pstmt = null;
	     try {
			pstmt = conn.prepareStatement(sb.toString());
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
	
