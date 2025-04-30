<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.koreaIT.java.AM_jsp.dto.Article" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Article> articles = (List<Article>) request.getAttribute("articles");

int cPage = (int) request.getAttribute("page");
int totalCnt = (int) request.getAttribute("totalCnt");
int totalPage = (int) request.getAttribute("totalPage");

boolean isLogined = (boolean) request.getAttribute("isLogined");
int loginedMemberId = (int) request.getAttribute("loginedMemberId");
Map<String, Object> loginedMember = (Map<String, Object>) request.getAttribute("loginedMember");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<style>
table>thead>tr>th, table>tbody>tr>td {
	padding: 5px;
}
</style>
</head>
<body>
	<h2>게시글 목록</h2>


	<%@ include file="../part/top_bar.jspf"%>

	<a href="../home/main">메인으로 이동</a>


	<div>
		총 게시글 갯수 :
		<%=totalCnt%>
	</div>

	<table style="border-collapse: collapse; border-color: green;"
		border="1px">
		<thead>
			<tr>
				<th>번호</th>
				<th>날짜</th>
				<th>작성자</th>
				<th>제목</th>
				<th>내용</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<%
			for(Article article : articles) {
			%>
			<tr style="text-align: center;">
				<td><%=article.getId()%>번</td>
				<td><%=article.getRegDate()%></td>
				<td><%=article.getName()%></td>
				<td><a href="detail?id=<%=article.getId()%>"><%=article.getTitle()%></a></td>
				<td><%=article.getBody()%></td>
				<td><a href="modify?id=<%=article.getId()%>">수정</a></td>
				<td><a onclick="if ( confirm('정말 삭제하시겠습니까?') == false ) { return false; }"
						href="doDelete?id=<%=article.getId()%>">del</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<style type="text/css">
	
.page {
	font-size: 1.4rem;
}

.page>a {
	color: black;
	text-decoration: none;
}

.page>a.cPage {
	color: red;
	text-decoration: underline;
}
</style>

	<div class="page">
		<%
		for (int i = 1; i <= totalPage; i++) {
		%>
		<a class="<%=cPage == i ? "cPage" : ""%>" href="list?page=<%=i%>"><%=i%></a>
		<%
		}
		%>

	</div>


</body>
</html>