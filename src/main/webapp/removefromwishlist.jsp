<%@page import="Dao.WishlistDao"%>
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
int id = Integer.parseInt(request.getParameter("wid"));
WishlistDao.removefromewishlist(id);
response.sendRedirect("wishlist.jsp");
%>
</body>
</html>