<%@page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
boolean isLogined = (boolean) request.getAttribute("isLogined");
int loginedMemberId = (int) request.getAttribute("loginedMemberId");
Map<String, Object> loginedMember = (Map<String, Object>) request.getAttribute("loginedMember");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>

</head>
<body>
	<h1>메인 페이지</h1>
	
	<%@ include file="../part/top_bar.jspf" %>
	

	<ul>
		<li><a href="../article/list">리스트로 이동</a></li>
		<li><a href="../article/write">글쓰기</a></li>
		<li><a href="../member/join">회원가입</a></li>
		<li><a href="../member/login">로그인</a></li>
	</ul>

</body>
</html>