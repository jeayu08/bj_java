package com.bj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bj.system.DBUtils;

public class bj_search_dao {
	private String bj_name;
	private String bj_code;
//	private String buss_place;
//	private String buss_reason;
//	private String buss_begintime;
//	private String buss_endtime;
	private int count;
	
	 public bj_search_dao(String bj_name,String bj_code,int count){
		this.bj_name = bj_name;
		this.bj_code = bj_code;
//		this.buss_place = buss_place;
//		this.buss_reason = buss_reason;
//		this.buss_begintime = buss_begintime;
//		this.buss_endtime = buss_endtime;
		this.count = 5*count;
		
	}
	 public List bj_search(){
         Connection conn =null;
         PreparedStatement pstmt =null;
         List infos = null;
         try {
			 conn=DBUtils.getConnection();
			 if(conn==null) return null;
			 StringBuffer sb = new StringBuffer();
//			 if (buss_endtime == "") {
//				 buss_endtime = "2050-12-12";
//			 }
			 sb.append("SELECT * ");
			 sb.append(" FROM bj_db.bj_input");
			 sb.append(" WHERE CONCAT(M_id) LIKE ? AND CONCAT(M_code) LIKE ?  ");
			 sb.append(" ORDER BY M_key DESC LIMIT ?,5");
			 pstmt = conn.prepareStatement(sb.toString());
			 pstmt.setObject(1, "%"+this.bj_name+"%");
			 pstmt.setObject(2, "%"+this.bj_code+"%");
//			 pstmt.setObject(3, "%"+this.buss_place+"%");
//			 pstmt.setObject(4, "%"+this.buss_reason+"%");
//			 pstmt.setObject(5, this.buss_begintime);
//			 pstmt.setObject(6, this.buss_endtime);
			 pstmt.setObject(3, this.count);
			 ResultSet rs = pstmt.executeQuery();
			 infos = new ArrayList<Map<String,Object>>();
			 ResultSetMetaData rsmd = rs.getMetaData();
			 while(rs.next()){
				 Map<String,Object> item = new HashMap<String, Object>();
				 int nCount = rsmd.getColumnCount();
				 for(int i = 0; i <nCount;++i){
					 item.put(rsmd.getColumnLabel(i+1), rs.getString(i+1));
				 }
				 		 
				 infos.add(item);
			 }
	         
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn);
			return infos;
			
		}
	}

}
