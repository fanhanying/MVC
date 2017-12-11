package com.framework.utils;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JDBCUtils extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet res = null;
		response.setContentType("text/html;charset=utf-8");
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test1", "root", "admin");
			statement = conn.prepareStatement("select name,address from table1 where id = ?");
			statement.setInt(1, 1);
			res = statement.executeQuery();
			PrintWriter writer = response.getWriter();
			String name = "";
			String address = "";
			while (res.next()) {
				name = res.getString(1);
			    address = res.getString(2);
			}
			if (request.getParameter("name").equals(name)
					&& request.getParameter("address").equals(address)) {
				writer.println("name: " + name);
				writer.println("address: " + address);
			} else {
				writer.println("不存在" + request.getParameter("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(res != null) {
					res.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
