<%@page import="com.bigdate2017.questbook.dao.QuestBookDao"%>
<%@page import="com.bigdate2017.questbook.vo.QuestBookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% 
	request.setCharacterEncoding("utf-8");
 	String password = request.getParameter("password");
 	String hidden = request.getParameter("no");
 	
 	QuestBookVo vo = new QuestBookVo();
 	vo.setPassword(password);
 	vo.setNo(Long.parseLong(hidden));
 	
 	new QuestBookDao().delete(vo);
 	
 	response.sendRedirect(request.getContextPath());
 	
 %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>