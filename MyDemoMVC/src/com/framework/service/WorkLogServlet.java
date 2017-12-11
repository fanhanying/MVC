package com.framework.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.framework.dao.WorkLogDao;

public class WorkLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getParameter("id");
		WorkLogDao workLogDao = new WorkLogDao();
		workLogDao.deleteWorkLog("delete from work_log where id = ?", id);
		request.getRequestDispatcher("/showTableServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getParameter("id");
		String name = (String) request.getParameter("name");
		String content = (String) request.getParameter("content");
		WorkLogDao workLogDao = new WorkLogDao();
		workLogDao.addWorkLog("insert into work_log values(?,?,?)", id, name, content);
		request.getRequestDispatcher("table.jsp").forward(request, response);
	}

}
