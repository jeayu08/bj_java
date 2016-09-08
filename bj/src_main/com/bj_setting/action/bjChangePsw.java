package com.bj_setting.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.base.dao.UserDao;
import com.bj.dao.bj_changePsw_dao;



public class bjChangePsw extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    HttpSession session = req.getSession();
		    String c_id= (String) session.getAttribute("id");
	    
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");	
			String c_old_psw = req.getParameter("old_psw");
			String c_new_psw = req.getParameter("new_psw");
			UserDao user= new  UserDao(c_id);
			String psw=user.getPassWord();
			bj_changePsw_dao changeDao= new bj_changePsw_dao(c_id,c_old_psw,c_new_psw);
			
//			System.out.println(c_id);
//            List<Map<String,Object>> infos = searchDao.bj_search();		   
		   String str="";		 
		   if(psw.equals(c_old_psw))
		   {
			   changeDao.changePsw();
		   str = "ok";
		   }else{
			   str = "fail" ;
		   }
//		   System.out.println(str);
			PrintWriter pw = null;
			try {
				pw = resp.getWriter(); 
				 pw.print(str);//²»ÄÜÐ´³Éprintln
				 pw.flush();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(pw!=null){
					pw.close();
				}
			}

	}
}
