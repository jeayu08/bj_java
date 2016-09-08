package com.bj_input.action;

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

import com.bj.dao.bj_search_dao;



public class bj_search extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    HttpSession session = req.getSession();
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			String bj_name = req.getParameter("bj_name");
			String bj_code = req.getParameter("bj_code");
//			String buss_place = req.getParameter("buss_place");
//			String buss_reason = req.getParameter("buss_reason");
//			String buss_begintime = req.getParameter("buss_begintime");
//			String buss_endtime = req.getParameter("buss_endtime");
			String p_count = req.getParameter("pull_count");
			int count = Integer.parseInt(p_count);
			bj_search_dao searchDao = new bj_search_dao(bj_name,bj_code,count);
            List<Map<String,Object>> infos = searchDao.bj_search();
		    JSONArray busslist = JSONArray.fromObject(infos);
			PrintWriter pw = null;
			try {
				pw = resp.getWriter(); 
				 pw.print(busslist);//����д��println
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
