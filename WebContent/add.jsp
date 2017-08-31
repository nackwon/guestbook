<%@page import="com.bigdate2017.questbook.dao.QuestBookDao"%>
<%@page import="com.bigdate2017.questbook.vo.QuestBookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	
<% 
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String password = request.getParameter("pass");
	String content = request.getParameter("content");
	
	QuestBookVo vo = new QuestBookVo();
	vo.setName(name);
	vo.setPassword(password);
	vo.setContent(content);
	
	new QuestBookDao().insert(vo);
	
	response.sendRedirect(request.getContextPath());
%>
