package com.framework.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.framework.domain.WorkLog;

public class WorkLogImpl {
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<WorkLog> findAll() {
		List<WorkLog> list = new ArrayList<WorkLog>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet res = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test1", "root", "admin");
			statement = conn.prepareStatement("select id,name,content from work_log");
			res = statement.executeQuery();
			while (res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
			    String content = res.getString(3);
			    WorkLog workLog = new WorkLog(id, name, content);
			    list.add(workLog);
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
		return list;
	}
	
	/**
	 * 新增数据
	 * @param workLog
	 * @param objs
	 */
	public void addWorkLog(String sql, String id, String name, String content) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet res = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test1", "root", "admin");
			statement = conn.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(id));
			statement.setString(2, name);
			statement.setString(3, content);
			statement.executeUpdate();
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
	
	public void deleteWorkLog(String sql, String id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet res = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test1", "root", "admin");
			statement = conn.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(id));
			statement.executeUpdate();
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
