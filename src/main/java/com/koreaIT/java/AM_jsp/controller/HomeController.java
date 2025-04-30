package com.koreaIT.java.AM_jsp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class HomeController {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private Connection conn;

	public HomeController(HttpServletRequest request, HttpServletResponse response) {
		this.conn = conn;
		this.request = request;
		this.response = response;
	}

	public void showMain() throws ServletException, IOException {
		HttpSession session = request.getSession();

		boolean isLogined = false;
		int loginedMemberId = -1;
		Map<String, Object> loginedMember = null;

		if (session.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (int) session.getAttribute("loginedMemberId");
			loginedMember = (Map<String, Object>) session.getAttribute("loginedMember");
		}

		request.setAttribute("isLogined", isLogined);
		request.setAttribute("loginedMemberId", loginedMemberId);
		request.setAttribute("loginedMember", loginedMember);

		request.getRequestDispatcher("/jsp/home/main.jsp").forward(request, response);

	}

}