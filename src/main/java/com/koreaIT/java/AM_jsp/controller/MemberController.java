package com.koreaIT.java.AM_jsp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.koreaIT.java.AM_jsp.service.MemberService;
import com.koreaIT.java.AM_jsp.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberController {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private Connection conn;

	private MemberService memberService;

	public MemberController(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		this.conn = conn;
		this.request = request;
		this.response = response;

		this.memberService = new MemberService(conn);
	}

	public void doJoin() throws ServletException, IOException{

		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		String name = request.getParameter("name");

		SecSql sql = SecSql.from("SELECT COUNT(*) AS cnt FROM `member`");
		sql.append("WHERE loginId = ?;", loginId);

		boolean isJoinableLoginId = memberService.selectRowIntValue(conn, sql) == 0;

		if (isJoinableLoginId == false) {
			response.getWriter().append(String
					.format("<script>alert('%s는 이미 사용중'); location.replace('../member/join');</script>", loginId));
			return;
		}

		int id = memberService.getDoJoin(loginId, loginPw, name);

		response.getWriter().append(
				String.format("<script>alert('%d번 회원이 가입됨'); location.replace('../article/list');</script>", id));

		request.getRequestDispatcher("/jsp/member/join.jsp").forward(request, response);
	}

	public void doLogin() throws ServletException, IOException {

		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");

		List<Map<String, Object>> memberRow = memberService.getDoLogin(loginId, loginPw);

		if (memberRow.isEmpty()) {
			response.getWriter().append(String
					.format("<script>alert('%s는 없는 아이디야'); location.replace('../member/login');</script>", loginId));
			return;
		}

		if (memberRow.get("loginPw").equals(loginPw) == false) {
			response.getWriter().append(
					String.format("<script>alert('비밀번호 불일치'); location.replace('../member/login');</script>", loginId));
			return;
		}
		response.getWriter().append(String.format(
				"<script>alert('%s님 로그인됨'); location.replace('../s/home/main');</script>", memberRow.get("name")));

		request.getRequestDispatcher("/jsp/member/login.jsp").forward(request, response);
	}
}