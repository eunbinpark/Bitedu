<%@page import="bitedu.bipa.member.vo.TestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정화면</title>
</head>
<body>
<h1>수정화면</h1>
<!-- scriptlet -->

<%
	//String id = request.getParameter("user_id");
	//out.print("<h1>"+id+"</h1>");
	TestVO test = (TestVO)request.getAttribute("test");
	String id = test.getId();
	String pwd = test.getPwd1();
%>
<br>
<h1><%=id%><%=pwd%></h1>
</body>
</html>