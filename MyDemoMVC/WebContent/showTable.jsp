<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.framework.domain.WorkLog, java.util.*"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
table jsp

<table border='1px;' cellpadding="10px" cellspacing="0px;">
	<tr align="center"> 
		<td width="100px;">id</td>
		<td width="100px;">名称</td>
		<td width="100px;">内容</td>
		<td width="100px;">操作</td>
	</tr>
<%
	ArrayList<WorkLog> logList = (ArrayList)request.getAttribute("workLogDaoList");
	for (WorkLog workLog : logList) {
%>
	<tr align="center">
		<td>
		<%=workLog.getId() %>
		</td>
		<td>
		<%=workLog.getName() %>
		</td>
		<td>
		<%=workLog.getContent() %>
		</td>
		<td><a href="workLogServlet?id=<%=workLog.getId() %>">删除</a></td>
	</tr>
<%
	}
%>
</table>
</body>
</html>