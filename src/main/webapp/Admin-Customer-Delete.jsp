<%@page import="Dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int ID = Integer.parseInt(request.getParameter("ID"));
	CustomerDao.deleteCustomer(ID);
	response.sendRedirect("Admin-Customer-List.jsp");
	%>
</body>
</html>