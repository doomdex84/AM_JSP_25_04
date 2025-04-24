<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Map<String, Object>> articleRows = (List<Map<String, Object>>) request.getAttribute("articleRows");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<h2>게시글 목록</h2>

	<a href="../home/main">메인으로 이동</a>

	<ul>
		<%
		for (Map<String, Object> articleRow : articleRows) {
		%>
		<li><%=articleRow.get("id")%>번,<%=articleRow.get("regDate")%>, <a
			href="detail?id=<%=articleRow.get("id")%>"><%=articleRow.get("title")%></a>,<%=articleRow.get("body")%></li>
		<%
		}
		%>

	</ul>


</body>