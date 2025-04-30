package com.koreaIT.java.AM_jsp.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.koreaIT.java.AM_jsp.util.DBUtil;
import com.koreaIT.java.AM_jsp.util.SecSql;

public class MemberDao {

	private Connection conn;

	public MemberDao(Connection conn) {
		this.conn = conn;
	}

	public int doJoin(String loginId, String loginPw, String name) {
		
		SecSql sql = SecSql.from("INSERT INTO `member`");
		sql.append("SET regDate = NOW(),");
		sql.append("loginId = ?,", loginId);
		sql.append("loginPw = ?,", loginPw);
		sql.append("`name` = ?;", name);

		 return DBUtil.insert(conn, sql);
	}

	public List<Map<String, Object>> getDoLogin(String loginId, String loginPw) {
		
		SecSql sql = SecSql.from("SELECT *");
		sql.append("FROM `member`");
		sql.append("WHERE loginId = ?;", loginId);
		
		return  DBUtil.selectRows(conn, sql);
	}
	
}
