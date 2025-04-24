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
<style>
table>thead>tr>th, table>tbody>tr>td {
	padding: 5px;
}
</style>
</head>
<body>
	<h2>게시글 목록</h2>

	<a href="../home/main">메인으로 이동</a>

	<table style="border-collapse: collapse; border-color: green;"
		border="1px">
		<thead>
			<tr>
				<th>번호</th>
				<th>날짜</th>
				<th>제목</th>
				<th>내용</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Map<String, Object> articleRow : articleRows) {
			%>
			<tr style="text-align: center;">
				<td><%=articleRow.get("id")%>번</td>
				<td><%=articleRow.get("regDate")%></td>
				<td><%=articleRow.get("title")%></td>
				<td><%=articleRow.get("body")%></td>
				<td><a
					onclick="if ( confirm('정말 삭제하시겠습니까?') == false ) { return false; }"
					href="doDelete?id=<%=articleRow.get("id")%>">del</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
		
		<tfoot>
		<tr style="color:red;">
		<tp>
		<a href="">----<1>-</a>
		<a href="">-<2>-</a>
		<a href="">-<3>-</a>
		<a href="">-<4>-</a>
		<a href="">-<5>-</a>
		<a href="">-<6>-</a>
		<a href="">-<7>-</a>
		<a href="">-<8>-</a>
		<a href="">-<9>-</a>
		<a href="">-<10>-----</a>
		</tp>
		</tr>
		
		</tfoot>
	</table>

	<!-- 
	<ul>
<%-- 		<%
		for (Map<String, Object> articleRow : articleRows) {
		%>
		<li><%=articleRow.get("id")%>번,<%=articleRow.get("regDate")%>, <a
			href="detail?id=<%=articleRow.get("id")%>"><%=articleRow.get("title")%></a>,<%=articleRow.get("body")%></li>
}

		%>
--%>
	</ul>
 -->

</body>
</html>