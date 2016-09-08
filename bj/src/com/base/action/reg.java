package com.base.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.base.dao.UserDao;

public class reg extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
//		String loger =(String) session.getAttribute("id");
		String id = req.getParameter("name");
		String password = req.getParameter("pass");
//		int M_number=Integer.parseInt(M_num);
//		String M_code = req.getParameter("code");
//		String M_save_place = req.getParameter("place");
//		String reason = req.getParameter("buss_reason");
//		String begintime = req.getParameter("buss_begintime");
//		String endtime = req.getParameter("buss_endtime");
//		UserNameDao namedao = new UserNameDao(editor);
//		String editor_name = namedao.getName();

		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sm.format(new Date());

		UserDao dao  = new  UserDao(id,password);
		dao.reg();

		 String str = "ok";
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