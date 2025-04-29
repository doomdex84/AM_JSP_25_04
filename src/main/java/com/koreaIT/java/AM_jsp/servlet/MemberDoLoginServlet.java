package com.koreaIT.java.AM_jsp.servlet;




import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.koreaIT.java.AM_jsp.util.DBUtil;
import com.koreaIT.java.AM_jsp.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/doLogin")
public class MemberDoLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		// DB 연결
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 x");
			e.printStackTrace();

		}

		String url = "jdbc:mysql://127.0.0.1:3306/AM_JSP_25_04?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, password);

			String loginId = request.getParameter("loginId");
			String loginPw = request.getParameter("loginPw");
			

			SecSql sql = SecSql.from("SELECT COUNT(*) AS cnt FROM `member`");
			sql.append("WHERE loginId = ?;", loginId);

			boolean isJoinableLoginId = DBUtil.selectRowIntValue(conn, sql) == 0;

			if (isJoinableLoginId == false) {
				response.getWriter().append(String
						.format("<script>alert('%s는 이미 로그인중 '); location.replace('../member/login');</script>", loginId));
				return;
			}

			sql = SecSql.from("SELECT *");
			sql.append("FROM `member`");
			sql.append("ORDER BY id DESC;");
			
			int id = DBUtil.selectRowIntValue(conn, sql);

			
			response.getWriter().append(
					String.format("<script>alert('%d번 로그인'); location.replace('../article/list');</script>", id));

		} catch (SQLException e) {
			System.out.println("에러 1 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}