package com.framework.dao;

import java.util.ArrayList;
import java.util.List;

import com.framework.domain.WorkLog;
import com.framework.impl.WorkLogImpl;

public class WorkLogDao {
	
	public List<WorkLog> findAll() {
		List<WorkLog> list = new ArrayList<WorkLog>();
		WorkLogImpl workLogImpl = new WorkLogImpl();
		list = workLogImpl.findAll();
		return list;
	}
	
	public void addWorkLog(String sql, String ... objs) {
		WorkLogImpl workLogImpl = new WorkLogImpl();
		workLogImpl.addWorkLog(sql, objs[0], objs[1], objs[2]);
	}
	
	public void deleteWorkLog(String sql, String id) {
		WorkLogImpl workLogImpl = new WorkLogImpl();
		workLogImpl.deleteWorkLog(sql, id);
	}
}
