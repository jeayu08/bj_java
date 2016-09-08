package com.bj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bj.system.DBUtils;

public class bj_input_dao {
	private String M_id;
	private int M_number;
	private String M_code;
	private String M_save_place;
//	private String buss_place;
//	private String buss_reason;
//	private String buss_begintime;
//	private String buss_endtime;
//	private String time;

	 public bj_input_dao (String M_id,int M_number,String M_code,String M_save_place){
		this.M_id = M_id;
		this.M_number = M_number;
		this.M_code = M_code;
		this.M_save_place = M_save_place;
//		this.buss_place = buss_place;
//		this.buss_reason = buss_reason;
//		this.buss_begintime = buss_begintime;
//		this.buss_endtime = buss_endtime;
//		this.time = time;
	}
	 
	 public void bj_input(){
		 int i =0;
		 Connection conn = DBUtils.getConnection();
		 if(conn == null)return;
		 StringBuffer sb = new StringBuffer();
         sb.append("INSERT INTO `bj_db`.`bj_input`(M_id, M_number,M_code,M_save_place)");
//         `editor`, `editor_name`,`bussmen_name`,`accounts`,`buss_place`,`buss_reason`,`buss_begintime`,`buss_endtime`,`time`
         sb.append(" VALUES (?,?,?,?)");
	     PreparedStatement pstmt = null;
	     try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setObject(1,M_id);
			pstmt.setObject(2,M_number);
			pstmt.setObject(3,M_code);
			pstmt.setObject(4,M_save_place);
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


