package com.koreaIT.java.AM_jsp.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.koreaIT.java.AM_jsp.dao.MemberDao;
import com.koreaIT.java.AM_jsp.util.DBUtil;
import com.koreaIT.java.AM_jsp.util.SecSql;

public class MemberService {

	private Connection conn;
	private MemberDao memberDao;

	public MemberService(Connection conn) {
		this.conn =conn;
		this.memberDao = new MemberDao(conn);

	}

	public int selectRowIntValue(Connection conn, SecSql sql) {

		return DBUtil.selectRowIntValue(conn, sql);
	}

	public int getDoJoin(String loginId, String loginPw, String name) {

		return memberDao.doJoin(loginId, loginPw, name);
	}

	
	public List<Map<String, Object>> getDoLogin(String loginId, String loginPw) {
		
		return memberDao.getDoLogin(loginId,loginPw);
	}

}