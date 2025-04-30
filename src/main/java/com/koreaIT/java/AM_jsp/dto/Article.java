package com.koreaIT.java.AM_jsp.dto;


import java.time.LocalDateTime;
import java.util.Map;

public class Article {
	private int id;
	private LocalDateTime regDate;
	private int memberId;
	private String title;
	private String body;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Article(LocalDateTime regDate, int id, int memberId, String title, String body) {
		this.regDate = regDate;
		this.id = id;
		this.memberId = memberId;
		this.title = title;
		this.body = body;
	}

	public Article(Map<String, Object> articleMap) {
		this.id = (int) articleMap.get("id");
		this.regDate = (LocalDateTime) articleMap.get("regDate");
		this.memberId = (int) articleMap.get("memberId");
		this.title = (String) articleMap.get("title");
		this.body = (String) articleMap.get("body");

		this.name = (String) articleMap.get("name");

	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", regDate=" + regDate + ", memberId=" + memberId + ", title=" + title + ", body="
				+ body + ", name=" + name + "]";
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}