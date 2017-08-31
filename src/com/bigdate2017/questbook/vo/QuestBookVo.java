package com.bigdate2017.questbook.vo;

public class QuestBookVo {
	private Long no;
	private String name;
	private String password;
	private String content;
	private String reg_day;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_day() {
		return reg_day;
	}
	public void setReg_day(String reg_day) {
		this.reg_day = reg_day;
	}
	@Override
	public String toString() {
		return "QuestBookVo [no=" + no + ", name=" + name + ", password=" + password + ", content=" + content
				+ ", reg_day=" + reg_day + "]";
	}
	
	
	
	
	
	
}

