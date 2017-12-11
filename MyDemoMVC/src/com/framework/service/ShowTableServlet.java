package com.framework.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.framework.dao.WorkLogDao;
import com.framework.domain.WorkLog;

public class ShowTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WorkLogDao workLogDao = new WorkLogDao();
		List<WorkLog> workLogDaoList = workLogDao.findAll();
		request.setAttribute("workLogDaoList", workLogDaoList);
		request.getRequestDispatcher("showTable.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
