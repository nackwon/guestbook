<%@page import="com.bigdate2017.questbook.vo.QuestBookVo"%>
<%@page import="java.util.List"%>
<%@page import="com.bigdate2017.questbook.dao.QuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	QuestBookDao dao = new QuestBookDao();
	List<QuestBookVo> list = dao.getList();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="add.jsp" method="post">
	<table border="1">
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td colspan="4"><textarea name="content" cols="60" rows="5"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="right"><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	
	
	
	<%
		int count = list.size();
		for(QuestBookVo vo : list) {
	%>
	
	<br>
	<table border="1">
		<tr>
			<td><%=count--%></td>
			<td><%=vo.getName()%></td>
			<td><%=vo.getReg_day()%></td>
			
			<td><a href="deleteform.jsp?no=<%=vo.getNo()%>">삭제</a></td>
		</tr>
		<tr>
			<td colspan="4"><%=vo.getContent() %></td>
		</tr>
	</table>
	<br/>

	<% } %>
	
</body>
</html>