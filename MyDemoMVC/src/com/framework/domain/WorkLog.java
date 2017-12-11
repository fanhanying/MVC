package com.framework.domain;

public class WorkLog {
	
	private int id;
	
	private String name;
	
	private String content;

	
	public WorkLog(int id, String name, String content) {
		this.id = id;
		this.name = name;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
